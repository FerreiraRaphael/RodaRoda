/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Model;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author raphael
 */
public class ControllerRodaRoda extends utils.Utils implements Controller{
    private final Models.RodaRoda rodaroda;
    private Models.Configuracao configuracao;
    private Views.ViewConfiguracao viewConfiguracao;
    private final Controllers.ControllerPalavra controllerPalavra;
    private Controllers.ControllerConfiguracao controllerConfiguracao;
    private int proximo;
    
    public ControllerRodaRoda(){
        controllerPalavra = new Controllers.ControllerPalavra();
        rodaroda = new Models.RodaRoda();
    }
    public void iniciar(){
        this.setarConfigurações();
        this.setarJogadores();
    }
    
    private void setarConfigurações(){
        controllerConfiguracao = new Controllers.ControllerConfiguracao();
        viewConfiguracao = new Views.ViewConfiguracao(controllerConfiguracao);
        viewConfiguracao.selecionarNumeroEtapas();
        viewConfiguracao.selecionarNumeroJogadores();
        viewConfiguracao.selecionarNumeroPalavras();
        controllerConfiguracao.iniciarConfiguracoes();
        configuracao = (Models.Configuracao) controllerConfiguracao.getModel();
    }
    private void setarJogadores(){
        for (int i = 0; i < configuracao.getNumeroJogadores(); i++) {
            rodaroda.adicionarJogador(new Controllers.ControllerJogador());
        }
    }
    private void jogo() throws IOException{
        List<Controllers.ControllerJogador> jogadores;
        jogadores = rodaroda.getJogadores();
        proximo = aleatorio(0, jogadores.size());
        for (int i = 0; i < configuracao.getNumeroEtapas() ; i++) {
            for (int j = 0; j < configuracao.getNumeroPalavras(); j++) {
                controllerPalavra.setarPalavra();
                Models.Palavra palavra = (Models.Palavra) controllerPalavra.getModel();
                //while(continuar);
                    
                
            }
        }
    }
    private boolean tentar(Models.Palavra palavra){
        Scanner scan;
        scan = new Scanner(System.in);
        scan.nextLine();
        return true;
    }
    private Controllers.ControllerJogador proximo(List<Controllers.ControllerJogador> jogadores){
        if(proximo < jogadores.size()){ 
            proximo++;
        }
        else
            this.proximo = 0;
        return jogadores.get(proximo);
    }
    private void jogar(Controllers.ControllerJogador jogador){
        
    }
    
    @Override
    public Model getModel() {
        return this.rodaroda;
    }
    
}
