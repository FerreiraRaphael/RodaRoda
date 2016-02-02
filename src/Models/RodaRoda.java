/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;

/**
 *
 * @author raphael
 */
public class RodaRoda implements Model{
    
    
    private List<Controllers.ControllerJogador> controllersJogadores;
    public RodaRoda() {
        //
    }
    public void adicionarJogador(Controllers.ControllerJogador jogador){
        this.controllersJogadores.add(jogador);
    }
    public List<Controllers.ControllerJogador> getJogadores(){
        return this.controllersJogadores;
    };
    
    
    
}
