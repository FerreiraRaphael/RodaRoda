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
public interface JogadorListener extends java.util.EventListener{
    void jogadorCriado(ControllerJogador jogador);
    void jogadorSomouPontos(int pontos, int pontoNaRoda);
    void jogadorPassouVez();
    void vezDoJogador();
}
