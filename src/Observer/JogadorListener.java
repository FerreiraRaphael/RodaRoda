/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import Controllers.ControllerJogador;

/** Esta interface está sendo utilizada para o Padrão de Projetos Observer. Tendo como objetivo colocar um padrão para os listenners de ControllerJogador.
 *
 * @author raphael
 */
public interface JogadorListener extends java.util.EventListener{
    /** Este método irá criar o jogador para os listeners dele.
     * 
     * @param jogador ControllerJogador - Será passado como parametro para poder passar os dados para os listenners.
     */
    void jogadorCriado(String nome);
    /** Servirá utilizado para passar para os listeners informações sobre os pontos gerais e os pontos que estão naquela etapa.
     * 
     * @param pontos int - Será os Pontos Gerais do jogador.
     * @param pontoNaRoda int - Será os Pontos por Etapa do jogador.
     */
    void jogadorSomouPontos(int pontos, int pontoNaRoda);
    /** Será implementada aqui o que os listenners vão fazer caso o jogador tenha que passar a vez.
     * 
     */
    void jogadorPassouVez();
    /** Será implementado aqui o que os listenners vão fazer caso seja a vez do Jogador.
     * 
     */
    void vezDoJogador();
}
