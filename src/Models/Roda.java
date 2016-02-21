/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Strategy.EstrategiaRodar;
import java.util.ArrayList;

/**
 *
 * @author raphael
 */
public class Roda {
    
    private ArrayList<Object[]> valores;
    public Roda() {
        this.valores = new ArrayList<>();
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
    }  
    
    public Object[] rodar(EstrategiaRodar estrategia) {
        int indice = estrategia.rodar();
        return valores.get(indice);
    }
}
