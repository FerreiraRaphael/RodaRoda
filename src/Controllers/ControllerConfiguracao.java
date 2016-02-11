/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Configuracao;
import org.json.simple.JSONObject;
/**
 *
 * @author raphael
 */
public final class ControllerConfiguracao extends Controller implements ControllerAbstrato{
    private Configuracao configuracao;
    
    private final int limiteNumeroJogadores;
    private final int limiteNumeroPalavras;
    private final int limiteNumeroEtapas;
    
    private JSONObject Dados;
    
    public ControllerConfiguracao() {
        configuracao = new Models.Configuracao();
        limiteNumeroJogadores = 3;
        limiteNumeroPalavras = 3;
        limiteNumeroEtapas = 7;
        inicializarDados();
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
            set("numeroJogadores",numero);
            return true;
        } else 
            return false;
    }
    public boolean setNumeroPalavras(int numero) {
        if (numero >= 1 && numero <= limiteNumeroPalavras) {
            set("numeroPalavras",numero);
            return true;
        } else 
            return false;
    }
    public boolean setNumeroEtapas(int numero) {
        if (numero >= 1 && numero <= limiteNumeroEtapas) {
            set("numeroEtapas",numero);
            return true;
        } else 
            return false;
    }

    @Override
    public void inicializarDados() {
        set("numeroEtapas", configuracao.getNumeroEtapas());
        set("numeroPalavras", configuracao.getNumeroPalavras());
        set("numeroJogadores", configuracao.getNumeroJogadores());
        set("limiteEtapas", limiteNumeroEtapas);
        set("limitePalavras", limiteNumeroPalavras);
        set("limiteJogadores", limiteNumeroJogadores);
        set("diferentesCategorias", false);
    }

    @Override
    public void carregarDados(JSONObject Dados) {
        configuracao.setNumeroJogadores((int) Dados.get("numeroJogadores"));
        configuracao.setNumeroPalavras((int) Dados.get("numeroPalavras"));
        configuracao.setNumeroEtapas((int) Dados.get("numeroEtapas"));
    }

    @Override
    public void atualizarDados() {
        carregarDados(getJSON());
    }
}
