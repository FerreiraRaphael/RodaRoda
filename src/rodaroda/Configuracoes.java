/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rodaroda;

import configurações.NumeroJogadores;
import configurações.NumeroErros;
import configurações.NumeroPalavras;
import configurações.NumeroEtapas;
import java.util.HashMap;


/**
 *
 * @author raphael
 */
public final class Configuracoes {
    
    private int numeroJogadores;
    private int numeroPalavras;
    private int numeroEtapas;
    private int numeroErros;
    private HashMap<String, String[]> palavras;
    
    public Configuracoes() {
        setNumeroJogadores();
        setNumeroEtapas();
        setNumeroPalavras();
        setNumeroErros();
        setPalavras();
    }
    
    public void setNumeroJogadores(){
        NumeroJogadores numeroJogadores = new NumeroJogadores();
        numeroJogadores.scan();
        this.numeroJogadores = numeroJogadores.getNumero();
    }
    
    public void setNumeroEtapas(){
        NumeroEtapas numeroEtapas = new NumeroEtapas();
        numeroEtapas.scan();
        this.numeroEtapas = numeroEtapas.getNumero();
    }
    
    public void setNumeroPalavras(){
        NumeroPalavras numeroPalavras = new NumeroPalavras();
        numeroPalavras.scan();
        this.numeroPalavras = numeroPalavras.getNumero();
    }
    
    public void setNumeroErros(){
        NumeroErros numeroErros = new NumeroErros();
        numeroErros.scan();
        this.numeroErros = numeroErros.getNumero();
    }
    
    public void setPalavras(){
        SelecionarPalavras palavras = new SelecionarPalavras();
        palavras.scan();
        this.palavras = palavras.getPalavrasMap();
    }
    
    
}
