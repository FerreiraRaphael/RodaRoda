/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Jogador;
import View.ContainerJogador;

/**
 *
 * @author raphael
 */
public final class ControllerJogador {
    private final Jogador jogador;
    private final ContainerJogador container;
    public String nome;
    public int erros;
    public int numeroRodadas; 
    
   public ControllerJogador(String nome, ContainerJogador ctJogador) {
        this.erros = 0;
        this.jogador = new Jogador();
        this.jogador.setNome(nome);
        this.nome = nome;
        this.container = ctJogador;
        nascimento();
    }
    
    private void nascimento(){
        container.jogadorCriado(this);
    }

    public void somarPontos() {
        int pontos = jogador.getPontos() + jogador.getPontosNaRoda();
        jogador.setPontos(pontos);
        container.jogadorSomouPontos(jogador.getPontos(), jogador.getPontosNaRoda());
    }
    
    public void somarPontosNaRoda(int pontos){
        if (pontos > 0) {
            pontos += jogador.getPontosNaRoda();
        } else {
            pontos = 0;
        }
        jogador.setPontosNaRoda(pontos);
        container.jogadorSomouPontos(jogador.getPontos(), jogador.getPontosNaRoda());
    }
    
    public int getPontos(){
        return jogador.getPontos();
    }
    
    public void passeiVez(){
        container.jogadorPassouVez();
    }
    
    public void minhaVez(){
        container.vezDoJogador();
    }
}
