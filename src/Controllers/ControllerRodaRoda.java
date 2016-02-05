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
import java.util.List;
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
        controllerPalavra = new ControllerPalavra();
        viewRodaRoda = new ViewRodaRoda(controllerPalavra);
        rodaroda = new RodaRoda();
        utils = new Utils();
        inicializarDados();
    }
    public void iniciar() throws IOException {
        setarConfigurações();
        setarJogadores();
        //jogo();
    }
    
    private void setarConfigurações(){
        controllerConfiguracao = new ControllerConfiguracao();
        viewConfiguracao = new ViewConfiguracao(controllerConfiguracao);
        viewConfiguracao.selecionarNumeroEtapas();
        viewConfiguracao.selecionarNumeroJogadores();
        viewConfiguracao.selecionarNumeroPalavras();
        controllerConfiguracao.atualizarDados();
    }
    private void setarJogadores(){
        List<ControllerJogador> jogadores = null;
        for (int i = 0; i < (int) controllerConfiguracao.get("numeroJogadores"); i++) {
            ControllerJogador jogador = new ControllerJogador(this);
            jogador.set("nome", viewRodaRoda.adicionarJogador());
            jogador.set("pontos", 0);
            jogador.atualizarDados();
            jogadores.add(jogador);
        }
        set("jogadores",jogadores);
    }
    
    private void etapas(){
        for (int i = 0; i <  (int) controllerConfiguracao.get("numeroEtapas") ; i++) {
            for (int j = 0; j < (int) controllerConfiguracao.get("numeroPalavras"); j++) {
                //iniciarRodaRoda(jogadores);
            }
        }
    }
    
    public Controllers.ControllerJogador proximo(){
        List<Controllers.ControllerJogador> jogadores = (List<Controllers.ControllerJogador>) get("jogadores");
        jogadores.get(proximo).atualizarDados();
        proximo++;
        if(proximo < jogadores.size())
            proximo = 0;
        
        return jogadores.get(proximo);
    } 
    
    private void jogar(Controllers.ControllerJogador jogador){
        controllerRoda.rodar(jogador);
    }
    
    private void iniciarRodaRoda(List<Controllers.ControllerJogador> jogadores) throws IOException{
        ControllerJogador jogador;
        viewRodaRoda.setJogadores(jogadores);
        boolean continuar;
        continuar = true;
        proximo = utils.aleatorio(0, jogadores.size()-1);
        jogador = jogadores.get(proximo);
        controllerPalavra.setarPalavra();
        while(continuar){
            jogar(jogador);
            jogador = proximo();
            continuar = controllerPalavra.verificarPalavraSecreta();
        }
    }
    
    @Override
    public void inicializarDados() {
        set("jogadores", rodaroda.getJogadores());
    }

    @Override
    public void carregarDados(JSONObject Dados) {
        rodaroda.setJogadores((List<ControllerJogador>) Dados.get("jogadores"));
    }

    @Override
    public void atualizarDados() {
        carregarDados(getJSON());
    }
}
