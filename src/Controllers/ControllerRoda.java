/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Model;

/**
 *
 * @author raphael
 */
public class ControllerRoda implements Controller{
    
    private final Models.Roda roda;
    public ControllerRoda() {
        roda = new Models.Roda();
    }
    
    
    public void rodar(ControllerJogador controllerJogador){
         Object valor = this.roda.getValor();
         if(valor instanceof String)
            if(valor.equals("lost"))
                controllerJogador.perderVez();
            else
                controllerJogador.somarPontos(-1);
         else
             controllerJogador.somarPontos((int) valor);                 
    }

    @Override
    public Model getModel() {
        return this.roda;
    }
    
}
