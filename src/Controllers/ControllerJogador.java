/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Model;

/**
 *
 * @author raphael
 */
public class ControllerJogador implements Controller{
    private final Models.Jogador jogador;
    public ControllerJogador() {
        this.jogador = new Models.Jogador();
    }
    
    public void perderVez(){
        
    }
    public void somarPontos(int pontos){
        if(pontos > 0)
            pontos += jogador.getPontos();
        else
            pontos = 0;
        jogador.setPontos(pontos);
    }

    @Override
    public Model getModel() {
        return this.jogador;
    }
}
