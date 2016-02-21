/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Confiracoes.Configuracao;
import Models.Roda;
import Observer.PalavraAdapter;
import java.io.IOException;
import java.util.ArrayList;
import utils.Utils;
import Strategy.RodarAleatorio;
import Strategy.RodarViciado;
import java.util.logging.Level;
import java.util.logging.Logger;
import Observer.RodaListener;

/**
 *
 * @author raphael
 */
public final class ControllerRodaRoda extends PalavraAdapter{

    private final ArrayList<RodaListener> listeners;
    private final ArrayList<ControllerJogador> jogadores;
    private final Roda roda;
    public final ControllerPalavra controllerPalavra;
    private final Utils utils;
    private int atual;
    private Configuracao configuracao;
    private int numeroEtapas;
    
    public ControllerRodaRoda() {
        this.configuracao = Configuracao.getInstance();
        this.controllerPalavra = new ControllerPalavra(
                configuracao.getNumeroPalavras(),
                configuracao.isDiferentesEtapas());
        this.roda = new Roda();
        this.utils = new Utils();
        this.numeroEtapas = configuracao.getNumeroEtapas();
        this.jogadores = new ArrayList<>();
        this.listeners = new ArrayList<>();
        this.atual = -1;
    }
    
    public boolean verificarErros(ControllerJogador jogador, boolean errouPalavra){
        boolean perdeu = false;
        if(errouPalavra){
            gameOver(false);
            perdeu = true;
        }
        if(jogador.erros >= 3){
            gameOver(false);
            perdeu = true;
        }
        return perdeu;
        
    }
    
    public ControllerJogador proximo() {
        ControllerJogador proximo;
        if(atual == -1){
            atual = utils.aleatorio(0, jogadores.size()-1);
            jogadores.get(atual).minhaVez();
            return jogadores.get(atual);
        }
        jogadores.get(atual).passeiVez();
        atual++;
        if (atual >= jogadores.size()) {
            atual = 0;
        }
        jogadores.get(atual).minhaVez();
        return jogadores.get(atual);
    }

    public void tentar(String tentativa, boolean palavra) throws IOException {
        if(!palavra)
            controllerPalavra.compararLetra(tentativa.charAt(0));
        else
            controllerPalavra.compararPalavra(tentativa);
    }

    public void addJogador(ControllerJogador jogador) throws IOException {
        jogadores.add(jogador);
        if (jogadores.size() == configuracao.getNumeroJogadores()) {
            iniciarEtapa();
        }
    }

    public void addListener(RodaListener listener) {
        listeners.add(listener);
    }

    public void removeListener(RodaListener listener) {
        listeners.remove(listener);
    }

    private void gameOver(boolean vencedor) {
        if(vencedor)
            listeners.forEach((listener) -> {
                listener.gameover(verificarVencedor());
            });
        else
            listeners.forEach((listener) -> {
                listener.gameover(null);
            });
    }

    private void iniciarEtapa() throws IOException {
        for(ControllerJogador jogador : jogadores){
            jogador.numeroRodadas = 0;
        }
        for (RodaListener listener : listeners) {
            listener.iniciouEtapa(controllerPalavra.getPalavra(),controllerPalavra.getCategoria(),controllerPalavra.getLetrasRestantes().toString());
        }
    }

    private void finalizarEtapa() throws IOException {
        numeroEtapas--;
        if (numeroEtapas == 0) {
            gameOver(true);
        } else {
            iniciarEtapa();
        }
    }
    
    public Object[] rodar(ControllerJogador jogador) {
        int indice;
        Object[] valor;
        jogador.numeroRodadas ++;
        if(jogador.numeroRodadas != 2)
                valor = roda.rodar(new RodarAleatorio());
        else
            valor = roda.rodar(new RodarViciado());
        return valor;
    }

   

    private ControllerJogador verificarVencedor() {
        ControllerJogador vencedor = null;
        
        for (ControllerJogador jogador : jogadores) {
            if(vencedor == null)
                vencedor = jogador;
            else
                if(vencedor.getPontos() < jogador.getPontos())
                    vencedor = jogador;
        }
        return vencedor;
    }

    @Override
    public void palavraDescoberta() {
        jogadores.forEach((jogador)->{jogador.somarPontosNaRoda(0);});
        try {
            this.finalizarEtapa();
        } catch (IOException ex) {
            Logger.getLogger(ControllerRodaRoda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
