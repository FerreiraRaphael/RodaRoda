/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import utils.Utils;

/**
 *
 * @author raphael
 */
public class ControllerRoda extends Controller implements ControllerAbstrato {

    private final Models.Roda roda;
    private final Utils utils;
    //private final List<ControllerJogador> jogadores;
    public ControllerRoda() {
        //this.jogadores = jogadores;
        roda = new Models.Roda();
        utils = new Utils();
        inicializarDados();
    }

    public Object[] rodar(ControllerJogador controllerJogador) {
        ArrayList<Object[]> valores = (ArrayList<Object[]>) get("roda");
        Object[] valor = valores.get(utils.aleatorio(0, valores.size() - 1));
        return valor;
        /*int pontosNaRoda = (int) get(controllerJogador);
        set("valor", valor);
        if ((boolean) valor[0]) {
            set(controllerJogador, pontosNaRoda + (int) valor[1]);
            //controllerJogador.somarPontos((int) valor[1]);
        } else if (valor[1].equals(0)) {
            controllerJogador.perderVez();
        } else {
            set(controllerJogador, 0);
            controllerJogador.perderVez();
        }*/
    }

    @Override
    public void inicializarDados() {
        ArrayList<Object[]> valores = new ArrayList<>();
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
        //for(ControllerJogador jogador : jogadores){
         //   set(jogador, 0);
        //}
    }

    @Override
    public void carregarDados(JSONObject Dados) {
        roda.setRoda((ArrayList<Object[]>) Dados.get("roda"));
    }

    @Override
    public void atualizarDados() {
        carregarDados(getJSON());
    }

}
