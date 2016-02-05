/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONObject;
import utils.Utils;

/**
 *
 * @author raphael
 */
public class ControllerRoda extends Controller implements ControllerAbstrato {

    private final Models.Roda roda;
    private final Utils utils;

    public ControllerRoda() {
        roda = new Models.Roda();
        utils = new Utils();
        inicializarDados();
    }

    public void rodar(ControllerJogador controllerJogador) {
        List<Object[]> valores = (List<Object[]>) get("roda");
        Object[] valor = valores.get(utils.aleatorio(0, valores.size()));
        set("valor", valor);
        if (valor[0].equals(true)) {
            controllerJogador.somarPontos((int) valor[1]);
        } else if (valor[1].equals(0)) {
            controllerJogador.perderVez();
        } else {
            controllerJogador.somarPontos(-1);
            controllerJogador.perderVez();
        }
    }

    @Override
    public void inicializarDados() {
        List<Object[]> valores = null;
        valores.add(new Object[]{false, 0});
        valores.add(new Object[]{false, 0});
        valores.add(new Object[]{false, 1});
        valores.add(new Object[]{false, 1});
        valores.add(new Object[]{true, 100});
        valores.add(new Object[]{true, 100});
        valores.add(new Object[]{true, 100});
        valores.add(new Object[]{true, 100});
        valores.add(new Object[]{true, 200});
        valores.add(new Object[]{true, 200});
        valores.add(new Object[]{true, 200});
        valores.add(new Object[]{true, 200});
        valores.add(new Object[]{true, 400});
        valores.add(new Object[]{true, 400});
        valores.add(new Object[]{true, 400});
        valores.add(new Object[]{true, 400});
        valores.add(new Object[]{true, 500});
        valores.add(new Object[]{true, 500});
        valores.add(new Object[]{true, 1000});
        valores.add(new Object[]{true, 1000});
        set("roda", valores);
        set("valor", "");
    }

    @Override
    public void carregarDados(JSONObject Dados) {
        roda.setRoda((List<Object>) Dados.get("roda"));
    }

    @Override
    public void atualizarDados() {
        carregarDados(getJSON());
    }

}
