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
public class Controller {
    private JSONObject Armazenamento;
    
    public Controller() {
        Armazenamento.put("id", "");
        
    }
    public JSONObject getJSON(){
        return Armazenamento;
    }
    
    public Object get(Object key){
        return Armazenamento.get(key);
    }
    
    public void set(Object key, Object value){
        Armazenamento.put(key, value);
    }
}
