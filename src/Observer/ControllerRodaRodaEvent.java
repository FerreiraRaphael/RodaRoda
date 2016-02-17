/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import org.json.simple.JSONObject;

/**
 *
 * @author raphael
 */
public class ControllerRodaRodaEvent extends java.util.EventObject{
    
    JSONObject dados;
    
    public ControllerRodaRodaEvent(Object source, JSONObject dados) {
        super(source);
        this.dados = dados;
    }
    
    public ControllerRodaRodaEvent(Object source) {
        super(source);
    }
    
    public JSONObject getDados(){
        return dados;
    }
    
}
