/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import Controllers.ControllerJogador;

/** Esta interface servirá como padrão para todo o Listener de ControllerRodaRoda. Como proposto pelo Padrão de Projeto Observer.
 *
 * @author raphael
 */
public interface RodaListener extends java.util.EventListener{
    /** Demonstra a maneira de terminar um jogo.
     * 
     * @param vencedor ControllerJogador - Passará o jogador vencedor.
     */
    void gameover(ControllerJogador vencedor);
    /** Irá demonstrar o processo para o inicio de uma etapa.
     * 
     * @param palavra String - As palavras que serão usados naquela étapa.
     * @param categoria String - A(s) categoria(s) dessa étapa.
     * @param restante String - O restante.
     */
    void iniciouEtapa(String palavra, String categoria, String restante);
}
