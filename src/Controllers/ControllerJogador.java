/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Jogador;
import View.ContainerJogador;

/** Classe para objeto do tipo ControllerJogador. Esta sendo utilizado também como um Source para o Padrão de Projetos Observer.
 *
 * @author raphael
 */
public final class ControllerJogador {
    private final Jogador jogador;
    private final ContainerJogador container;
    public String nome;
    public int erros;
    public int numeroRodadas; 
    /** Construtor que será utilizado para instanciar a classe ControllerJogador.
     * 
     * @param nome String - Será utilizado para modificar o nome do jogador durante a instancia da classe ControllerJogador.
     * @param ctJogador ContainerJogador - Este será um listener do Classe ControllerJogador.
     */
   public ControllerJogador(String nome, ContainerJogador ctJogador) {
        this.erros = 0;
        this.jogador = new Jogador();
        this.jogador.setNome(nome);
        this.nome = nome;
        this.container = ctJogador;
        nascimento();
    }
    /** Está será um método utilizado para o Padrão de Projetos Observer. Passando para seus observers seus dados.
     * 
     */
    private void nascimento(){
        container.jogadorCriado(nome);
    }
    /** Será utilizado tanto para alterar os pontos do jogador quanto fará parte do Padrão de Projetos Observer avisando aos listeners das modificações feitas.
     * 
     */
    public void somarPontos() {
        int pontos = jogador.getPontos() + jogador.getPontosNaRoda();
        jogador.setPontos(pontos);
        container.jogadorSomouPontos(jogador.getPontos(), jogador.getPontosNaRoda());
    }
    /** Este método será utilizado para poder adicionar pontos nos Pontos da Étapa(pontos da Roda).
     * 
     * @param pontos int - Estes pontos serão os pontos a serem acrescentados.
     */
    public void somarPontosNaRoda(int pontos){
        if (pontos > 0) {
            pontos += jogador.getPontosNaRoda();
        } else {
            pontos = 0;
        }
        jogador.setPontosNaRoda(pontos);
        container.jogadorSomouPontos(jogador.getPontos(), jogador.getPontosNaRoda());
    }
    /** Este Método mostrará os pontos do jogador.
     * 
     * @return int - Este método retornará um inteiro.
     */
    public int getPontos(){
        return jogador.getPontos();
    }
    /** Este método está sendo utilizado para demonstrar que o jogador passou a vez para os listenners. De acordo com o Padrão de Projetos Observer.
     * 
     */
    public void passeiVez(){
        container.jogadorPassouVez();
    }
    /** Este método está sendo utilizado para demonstrar que é a vez daquele jogador para os Listeners. De acorco com o Padrão de Projetos Observer.
     * 
     */
    public void minhaVez(){
        container.vezDoJogador();
    }
}
