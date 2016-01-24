/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.HashMap;

/**
 *
 * @author raphael
 */
public final class Configuracao {

    
    private final int numeroJogadores;
    private final int numeroPalavras;
    private final int numeroEtapas;

    public Configuracao(int numeroJogadores, int numeroPalavras, int numeroEtapas) {
 
        this.numeroJogadores = numeroJogadores;
        this.numeroPalavras = numeroPalavras;
        this.numeroEtapas = numeroEtapas;
        //System.out.println(this.numeroEtapas);
        //System.out.println(this.numeroJogadores);
        //System.out.println(this.numeroPalavras);
    }

    public int getNumeroJogadores() {
        return numeroJogadores;
    }

    public int getNumeroPalavras() {
        return numeroPalavras;
    }

    public int getNumeroEtapas() {
        return numeroEtapas;
    }
}
