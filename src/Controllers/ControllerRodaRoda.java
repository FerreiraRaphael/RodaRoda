/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.RodaRoda;
import Views.ViewConfiguracao;
import Views.ViewRodaRoda;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import utils.Utils;

/**
 *
 * @author raphael
 */
public final class ControllerRodaRoda extends Controller implements ControllerAbstrato{
    private final RodaRoda rodaroda;
    private final ControllerPalavra controllerPalavra;
    private final ViewRodaRoda viewRodaRoda;
    private ViewConfiguracao viewConfiguracao;
    private ControllerConfiguracao controllerConfiguracao;
    private ControllerRoda controllerRoda;
    private final Utils utils;
    private int proximo;
    
    public ControllerRodaRoda(){
        controllerConfiguracao = new ControllerConfiguracao();
        controllerRoda = new ControllerRoda();
        controllerPalavra = new ControllerPalavra();
        viewRodaRoda = new ViewRodaRoda(controllerPalavra,this);
        rodaroda = new RodaRoda();
        utils = new Utils();
        inicializarDados();
    }
    public void ligar() throws IOException {
        
    }
    
    public void configuracoes() throws IOException {
        if(viewConfiguracao == null){
        //viewConfiguracoes = viewMain.viewConfiguracao(controllerConfiguracao);
        //viewConfiguracoes.setVisible(true);
        set("viewConfiguracao",viewConfiguracao);
        }
    }
    
    private void setarConfigurações(){
        //viewConfiguracao = new ViewConfiguracao(controllerConfiguracao);
        //viewConfiguracao.selecionarNumeroEtapas();
        //viewConfiguracao.selecionarNumeroJogadores();
        //viewConfiguracao.selecionarNumeroPalavras();
        controllerConfiguracao.atualizarDados();
    }
    private ArrayList<ControllerJogador> setarJogadores(){
        ArrayList<ControllerJogador> jogadores = new ArrayList<>();
        for (int i = 0; i < (int) controllerConfiguracao.get("numeroJogadores"); i++) {
            ControllerJogador jogador = new ControllerJogador(this);
            jogador.set("nome", viewRodaRoda.adicionarJogador());
            jogador.set("pontos", 0);
            jogador.atualizarDados();
            jogadores.add(jogador);
            set(jogador,0);
        }
        set("jogadores",jogadores);
        viewRodaRoda.setJogadores(jogadores);
        return jogadores;
    }
    
    private void rodarEtapas() throws IOException{
        for (int i = 0; i <  (int) controllerConfiguracao.get("numeroEtapas") ; i++) {
            iniciarRodaRoda((ArrayList<ControllerJogador>) get("jogadores"));
        }
    }
    
    public ControllerJogador proximo(){
        ArrayList<ControllerJogador> jogadores = (ArrayList<ControllerJogador>) get("jogadores");
        jogadores.get(proximo).atualizarDados();
        proximo++;
        if( proximo >= jogadores.size() - 1 )
            proximo = 0;
        
        return jogadores.get(proximo);
    } 
    
    private boolean jogar(ControllerJogador jogador){
        Object[] valor = controllerRoda.rodar(jogador);
        int pontosNaRoda = (int) get(jogador);
        set("valor", valor);
        if ((boolean) valor[0]) {
            if(jogador.fazerTentativa(controllerPalavra)){
                set(jogador, pontosNaRoda + (int) valor[1]);
                return true;
                }
        } else if (valor[1].equals(1)) {
            set(jogador, 0);
        }
        return false;
    }
    
    private void iniciarRodaRoda(ArrayList<Controllers.ControllerJogador> jogadores) throws IOException{
        ControllerJogador jogador;
        boolean continuar;
        continuar = true;
        proximo = utils.aleatorio(0, jogadores.size()-1);
        jogador = jogadores.get(proximo);
        controllerPalavra.escolherPalavras(controllerConfiguracao);
        while(continuar){
            viewRodaRoda.telaInicial();
            if(!jogar(jogador))
                jogador = proximo();
            continuar = !controllerPalavra.verificarPalavraSecreta();
        }
    }
    
    @Override
    public void inicializarDados() {
        set("jogadores", rodaroda.getJogadores());
    }

    @Override
    public void carregarDados(JSONObject Dados) {
        rodaroda.setJogadores((ArrayList<ControllerJogador>) Dados.get("jogadores"));
    }

    @Override
    public void atualizarDados() {
        carregarDados(getJSON());
    }
}
