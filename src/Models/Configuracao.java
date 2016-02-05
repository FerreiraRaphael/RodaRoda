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
public final class Configuracao {

    private int numeroJogadores;
    private int numeroPalavras;
    private int numeroEtapas;
    
    public void setNumeroJogadores(int numeroJogadores) {
        this.numeroJogadores = numeroJogadores;
    }

    public void setNumeroPalavras(int numeroPalavras) {
        this.numeroPalavras = numeroPalavras;
    }

    public void setNumeroEtapas(int numeroEtapas) {
        this.numeroEtapas = numeroEtapas;
    }

    public Object getNumeroJogadores() {
        return numeroJogadores;
    }

    public int getNumeroPalavras() {
        return numeroPalavras;
    }

    public int getNumeroEtapas() {
        return numeroEtapas;
    }
}
