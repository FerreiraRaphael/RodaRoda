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
public final class ControllerConfiguracao {

    private final Configuracao configuracao;
    private final int limiteNumeroJogadores;
    private final int limiteNumeroPalavras;
    private final int limiteNumeroEtapas;

    public ControllerConfiguracao() {
        this.configuracao = Configuracao.getInstance();
        this.limiteNumeroJogadores = 3;
        this.limiteNumeroPalavras = 3;
        this.limiteNumeroEtapas = 7;
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

    public void setNumeroJogadores(int numero) {
        configuracao.setNumeroJogadores(numero);
    }

    public void setNumeroPalavras(int numero) {
        configuracao.setNumeroPalavras(numero);
    }

    public void setNumeroEtapas(int numero) {
        configuracao.setNumeroEtapas(numero);
    }

    public void setDiferentesCategorias(boolean check) {
        configuracao.setDiferentesEtapas(check);
    }

}
