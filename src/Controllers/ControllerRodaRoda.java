/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Roda;
import Models.RodaRoda;
import Observer.ControllerRodaRodaEvent;
import Observer.ControllerRodaRodaListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import utils.Utils;

/**
 *
 * @author raphael
 */
public final class ControllerRodaRoda extends Controller implements ControllerAbstrato {

    private ArrayList<ControllerRodaRodaListener> listeners;
    private final RodaRoda rodaroda;
    private final Roda roda;
    private final ControllerPalavra controllerPalavra;
    private final ControllerRoda controllerRoda;
    private final Utils utils;
    private int atual;
    private final JSONObject configuracoes;
    private int numeroEtapas;
    private ArrayList<ControllerJogador> jogadores;
    private StringBuilder letrasRestantes;

    public ControllerRodaRoda(JSONObject configuracoes) {
        controllerRoda = new ControllerRoda();
        rodaroda = new RodaRoda();
        roda = new Roda();
        utils = new Utils();
        inicializarDados();
        this.configuracoes = configuracoes;
        numeroEtapas = (int) configuracoes.get("numeroEtapas");
        controllerPalavra = new ControllerPalavra((int) configuracoes.get("numeroPalavras"), true);
        jogadores = new ArrayList<>();
        listeners = new ArrayList<>();
        atual = -1;
    }

    public ControllerJogador proximo() {
        if(atual == -1)
            atual = utils.aleatorio(0, jogadores.size());
        atual++;
        if (atual >= jogadores.size()) {
            atual = 0;
        }

        return jogadores.get(atual);
    }

    public void tentar(String tentativa, boolean palavra) throws IOException {
        if (jogadores.get(atual).fazerTentativa(controllerPalavra, tentativa, palavra)) {
            if (controllerPalavra.verificarPalavraSecreta()) {
                jogadorAcertouPalavra();
            } else {
                retirarLetra(tentativa);
                jogadorAcertou();
            }
        } else if (palavra) {
            jogadorErrouPalavra();
        } else {
            retirarLetra(tentativa);
            jogadorErrou();
        }
    }

    public void addJogador(ControllerJogador jogador) {
        jogadores.add(jogador);
        if (jogadores.size() == (int) configuracoes.get("numeroJogadores")) {
            iniciarEtapa();
        }
    }

    public void addListener(ControllerRodaRodaListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ControllerRodaRodaListener listener) {
        listeners.remove(listener);
    }

    private void jogadorAcertou() throws IOException {
        JSONObject dados = new JSONObject();
        dados.put("palavra", controllerPalavra.getPalavra());
        dados.put("restante", letrasRestantes.toString());
        for (ControllerRodaRodaListener listener : listeners) {
            listener.acertou(new ControllerRodaRodaEvent(this, dados));
        }
    }

    private void jogadorErrou() {
        JSONObject dados = new JSONObject();
        dados.put("erros", controllerPalavra.getErros());
        dados.put("restante", letrasRestantes.toString());
        for (ControllerRodaRodaListener listener : listeners) {
            listener.errou(new ControllerRodaRodaEvent(this, dados));
        }
    }

    private void jogadorAcertouPalavra() throws IOException {
        finalizarEtapa();
        for (ControllerRodaRodaListener listener : listeners) {
            listener.acertouPalavra(new ControllerRodaRodaEvent(this));
        }
        finalizarEtapa();
    }

    private void jogadorErrouPalavra() {
        for (ControllerRodaRodaListener listener : listeners) {
            listener.errouPalavra(new ControllerRodaRodaEvent(this));
        }
    }

    private void gameOver() {
        JSONObject dados = new JSONObject();
        dados.put("vencedor",verificarVencedor());
        for (ControllerRodaRodaListener listener : listeners) {
            listener.gameover(new ControllerRodaRodaEvent(this,dados));
        }
    }

    private void iniciarEtapa() {
        letrasRestantes = new StringBuilder("a b c d e f g h i j k l m n o p q r t s v u x w y z ç");
        JSONObject dados = new JSONObject();
        try {
            dados.put("categoria", controllerPalavra.getCategoria());
            dados.put("palavra", controllerPalavra.getPalavra());
            dados.put("restante", letrasRestantes.toString());
        } catch (IOException ex) {
            Logger.getLogger(ControllerRodaRoda.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (ControllerRodaRodaListener listener : listeners) {
            listener.iniciouEtapa(new ControllerRodaRodaEvent(this, dados));
        }
    }

    private void retirarLetra(String s) {
        int indice = letrasRestantes.indexOf(s);
        letrasRestantes.deleteCharAt(indice);
        if (indice > 0) {
            letrasRestantes.deleteCharAt(indice - 1);
        }
    }

    private void finalizarEtapa() {
        JSONObject dados = new JSONObject();
        numeroEtapas--;
        if (numeroEtapas == 0) {
            gameOver();
        } else {
            iniciarEtapa();
        }
    }

    public Object[] rodar() {
        ArrayList<Object[]> valores = (ArrayList<Object[]>) get("roda");
        Object[] valor = valores.get(utils.aleatorio(0, valores.size() - 1));
        //naRoda = Integer.parseInt((String) valor[1]);
        return valor;
    }

    @Override
    public void inicializarDados() {
        ArrayList<Object[]> valores = new ArrayList<>();
        valores.add(new Object[]{false, "0"});
        valores.add(new Object[]{false, "0"});
        valores.add(new Object[]{false, "1"});
        valores.add(new Object[]{false, "1"});
        valores.add(new Object[]{true, "100"});
        valores.add(new Object[]{true, "100"});
        valores.add(new Object[]{true, "100"});
        valores.add(new Object[]{true, "100"});
        valores.add(new Object[]{true, "200"});
        valores.add(new Object[]{true, "200"});
        valores.add(new Object[]{true, "200"});
        valores.add(new Object[]{true, "200"});
        valores.add(new Object[]{true, "400"});
        valores.add(new Object[]{true, "400"});
        valores.add(new Object[]{true, "400"});
        valores.add(new Object[]{true, "400"});
        valores.add(new Object[]{true, "500"});
        valores.add(new Object[]{true, "500"});
        valores.add(new Object[]{true, "1000"});
        valores.add(new Object[]{true, "1000"});
        set("roda", valores);
        set("valor", "");
        //for(ControllerJogador jogador : jogadores){
        //   set(jogador, 0);
        //}
    }

    @Override
    public void carregarDados(JSONObject Dados) {
        roda.setRoda((ArrayList<Object[]>) Dados.get("roda"));
    }

    @Override
    public void atualizarDados() {
        carregarDados(getJSON());
    }

    private ControllerJogador verificarVencedor() {
        ControllerJogador vencedor = null;
        
        for (ControllerJogador jogador : jogadores) {
            if(vencedor == null)
                vencedor = jogador;
            else
                if((Integer)vencedor.get("pontos")<(Integer)jogador.get("pontos"))
                    vencedor = jogador;
        }
        return vencedor;
    }

}
