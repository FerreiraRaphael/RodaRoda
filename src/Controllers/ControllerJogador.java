/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Jogador;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 *
 * @author raphael
 */
public final class ControllerJogador extends Controller implements ControllerAbstrato {
    
    private final Models.Jogador jogador;

    public ControllerJogador() {
        this.jogador = new Jogador();
        inicializarDados();
    }

    public boolean fazerTentativa(ControllerPalavra controllerPalavra, String tentativa, boolean tentarPalavra) {
        boolean acertou = false;
        if (!tentarPalavra) {
           if (controllerPalavra.compararLetra(tentativa.charAt(0))) {
                acertou = true;
            }
        } 
        else if (controllerPalavra.compararPalavra(tentativa)) {
            acertou = true;
        }
        return acertou;
    }

    public void somarPontos(int pontos) {
        if (pontos > 0) {
            pontos += (int) get("pontos");
        } else {
            pontos = 0;
        }
        set("pontos", pontos);
    }

    @Override
    public void inicializarDados() {
        set("nome", jogador.getNome());
        set("pontos", jogador.getPontos());
    }

    @Override
    public void carregarDados(JSONObject Dados) {
        jogador.setNome((String) Dados.get("nome"));
        jogador.setPontos((int) Dados.get("pontos"));
    }

    @Override
    public void atualizarDados() {
        carregarDados(getJSON());
    }

}