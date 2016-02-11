/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rodaroda;

import View.ViewInicial;

import java.io.IOException;


/**
 *
 * @author raphael
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //ControllerRodaRoda rodaroda = new ControllerRodaRoda();
        //rodaroda.ligar();
        ViewInicial vwInicial = new ViewInicial();
        vwInicial.setLocationRelativeTo(null);
        vwInicial.setVisible(true);
    }
}
