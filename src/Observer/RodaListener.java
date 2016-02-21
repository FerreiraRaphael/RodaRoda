/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import Controllers.ControllerJogador;

/**
 *
 * @author raphael
 */
public interface RodaListener extends java.util.EventListener{
    void gameover(ControllerJogador vencedor);
    void iniciouEtapa(String palavra, String categoria, String restante);
}
