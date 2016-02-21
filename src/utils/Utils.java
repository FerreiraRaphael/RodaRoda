/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;

/**
 *
 * @author raphael
 */
public class Utils {
    public String separador = " | ";
    public int aleatorio(int min, int max) {
        int range;
        range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
    
    public String unirString(ArrayList<String> strings){
        String retorno = "";
        for(String string : strings){
            if(retorno.equals(""))
                retorno = string;
            else
                retorno = retorno + separador +string;
        }
        return retorno;
    }
}
