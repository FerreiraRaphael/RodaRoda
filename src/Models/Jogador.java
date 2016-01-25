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
    public void somarPontos(int numero){
        this.pontos += numero;
    }

}
