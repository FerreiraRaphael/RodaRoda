/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rodaroda;


import Views.ViewConfiguracao;

/**
 *
 * @author raphael
 */
public class RodaRoda {
    
    Views.ViewConfiguracao viewConfiguracao;
    Controllers.ControllerPalavra controllerPalavra;
    public RodaRoda() {
        viewConfiguracao = new ViewConfiguracao();
        controllerPalavra = new Controllers.ControllerPalavra();
        controllerPalavra.setarPalavra();
    }
    
    
}
