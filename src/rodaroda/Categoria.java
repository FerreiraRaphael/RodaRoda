/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rodaroda;

import java.util.HashMap;


/**
 *
 * @author raphael
 */
public class Categoria {
    private final HashMap<String, String []> categoria;
    
    public Categoria(){
        categoria = new HashMap<>();
        String [] animal =  {"cachorro"};
        categoria.put("animal", animal );      
    }
    
    public HashMap<String, String[]> getCategoria(){
        return this.categoria;
    }
}
