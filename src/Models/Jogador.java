/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author raphael
 */
public class Jogador {
    
    
    private int pontos;
    private int pontosNaRoda;
    private String nome;

    public Jogador() {
        nome = "";
        pontos = 0;
        pontosNaRoda = 0;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getPontosNaRoda() {
        return pontosNaRoda;
    }

    public void setPontosNaRoda(int pontosNaRoda) {
        this.pontosNaRoda = pontosNaRoda;
    }
    /**
     * Get the value of pontos
     *
     * @return the value of pontos
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * Soma o novo valor de pontos;
     *
     * @param numero numero a ser somado 
     */
    public void setPontos(int numero){
        this.pontos = numero;
    }

}
