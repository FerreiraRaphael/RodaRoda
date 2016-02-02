/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;



/**
 *
 * @author raphael
 */
public class ControllerConfiguracao implements Controller{
    private final int limiteNumeroJogadores;
    private final int limiteNumeroPalavras;
    private final int limiteNumeroEtapas;
    private int numeroJogares;
    private int numeroPalavras;
    private int numeroEtapas;
    private Models.Configuracao configuracao;
    
    public int getLimiteNumeroJogadores() {
        return limiteNumeroJogadores;
    }

    public int getLimiteNumeroPalavras() {
        return limiteNumeroPalavras;
    }

    public int getLimiteNumeroEtapas() {
        return limiteNumeroEtapas;
    }
    
    public ControllerConfiguracao() {
        this.limiteNumeroJogadores = 3;
        this.limiteNumeroPalavras = 3;
        this.limiteNumeroEtapas = 7;
    }

    public boolean setNumeroJogadores(int numero) {
        if (numero >= 1 && numero <= limiteNumeroJogadores) {
            this.numeroJogares = numero;
            return true;
        } else 
            return false;
    }
    public boolean setNumeroPalavras(int numero) {
        if (numero >= 1 && numero <= limiteNumeroPalavras) {
            this.numeroPalavras = numero;
            return true;
        } else 
            return false;
    }
    public boolean setNumeroEtapas(int numero) {
        if (numero >= 1 && numero <= limiteNumeroEtapas) {
            this.numeroEtapas = numero;
            return true;
        } else 
            return false;
    }
    public void iniciarConfiguracoes(){
        this.configuracao = new Models.Configuracao(numeroJogares, numeroPalavras, numeroEtapas);
    }

    @Override
    public Models.Model getModel() {
           return this.configuracao;
    }
}
