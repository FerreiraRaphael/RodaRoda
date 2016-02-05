/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import org.json.simple.JSONObject;



/**
 *
 * @author raphael
 */
public interface ControllerAbstrato {
    public void inicializarDados();
    public void carregarDados(JSONObject Dados);
    public void atualizarDados();
}
