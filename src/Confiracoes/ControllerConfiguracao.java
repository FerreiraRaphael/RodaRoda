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
public final class ControllerConfiguracao{
    private final Configuracao configuracao;
    
    private final int limiteNumeroJogadores;
    private final int limiteNumeroPalavras;
    private final int limiteNumeroEtapas;
    
    public ControllerConfiguracao() {
        configuracao = Configuracao.getInstance();
        limiteNumeroJogadores = 3;
        limiteNumeroPalavras = 3;
        limiteNumeroEtapas = 7;
    }
    
    public int getLimiteNumeroJogadores() {
        return limiteNumeroJogadores;
    }

    public int getLimiteNumeroPalavras() {
        return limiteNumeroPalavras;
    }

    public int getLimiteNumeroEtapas() {
        return limiteNumeroEtapas;
    }
    
    public boolean setNumeroJogadores(int numero) {
        if (numero >= 1 && numero <= limiteNumeroJogadores) {
            configuracao.setNumeroJogadores(numero);
            return true;
        } else 
            return false;
    }
    public boolean setNumeroPalavras(int numero) {
        if (numero >= 1 && numero <= limiteNumeroPalavras) {
            configuracao.setNumeroPalavras(numero);
            return true;
        } else 
            return false;
    }
    public boolean setNumeroEtapas(int numero) {
        if (numero >= 1 && numero <= limiteNumeroEtapas) {
            configuracao.setNumeroEtapas(numero);
            return true;
        } else 
            return false;
    }
    public void setDiferentesCategorias(boolean check) {
        configuracao.setDiferentesEtapas(check);
    }

}
