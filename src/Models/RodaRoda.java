/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.ControllerJogador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raphael
 */
public class RodaRoda {
    
    
    private ArrayList<Controllers.ControllerJogador> controllersJogadores;
    
    public void setJogador(ControllerJogador jogador){
        controllersJogadores.add(jogador);
    }
    
    public void setJogadores(ArrayList<ControllerJogador> jogadores){
        controllersJogadores = (jogadores);
    }
    
    public ArrayList<Controllers.ControllerJogador> getJogadores(){
        return this.controllersJogadores;
    };
    
    
    
}
