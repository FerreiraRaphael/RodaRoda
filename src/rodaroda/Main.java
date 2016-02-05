/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rodaroda;

import Models.Configuracao;
import java.lang.reflect.Field;

/**
 *
 * @author raphael
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Field[] fields = Configuracao.class.getDeclaredFields();
        
        
        System.out.println("rodaroda.Main.main()");
    }
}
