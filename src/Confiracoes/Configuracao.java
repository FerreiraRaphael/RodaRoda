/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Confiracoes;

/**
 *
 * @author raphael
 */
public class Configuracao {

    private int numeroJogadores;
    private int numeroPalavras;
    private int numeroEtapas;
    private boolean diferentesEtapas;
    private static Configuracao me = null;
    
    private Configuracao() {
        this.numeroJogadores = 0;
        this.numeroPalavras = 0;
        this.numeroEtapas = 0;
        this.diferentesEtapas = true;
    }
    
    public static Configuracao getInstance(){
        if(me == null)
            me = new Configuracao();
        return me;
    }
    
    protected void setDiferentesEtapas(boolean diferentesEtapas) {
        this.diferentesEtapas = diferentesEtapas;
    }
    
    protected void setNumeroJogadores(int numeroJogadores) {
        this.numeroJogadores = numeroJogadores;
    }

    protected void setNumeroPalavras(int numeroPalavras) {
        this.numeroPalavras = numeroPalavras;
    }

    protected void setNumeroEtapas(int numeroEtapas) {
        this.numeroEtapas = numeroEtapas;
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

    public boolean isDiferentesEtapas() {
        return diferentesEtapas;
    }

}
