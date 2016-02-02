/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raphael
 */
public class Roda extends utils.Utils implements Model{

//    private void somarPontos(int pontos) {
//    }
//
//    private void perderVez() {
//    }
    List<Object> valores;
    
    /*
    duas divisões de perde tudo ,
    duas de passa a vez,
    quatro divisões de 100 pontos ,
    quatro divisões de 200 pontos ,
    quatro divisões de 400 pontos ,
    duas divisões de 500 pontos ,
    duas divisões de 1000 pontos.
    */
    public Roda() {
        valores = new ArrayList<>();
        valores.add("lost");
        valores.add("lost");
        valores.add("pass");
        valores.add("pass");
        valores.add(100);
        valores.add(100);
        valores.add(100);
        valores.add(100);
        valores.add(200);
        valores.add(200);
        valores.add(200);
        valores.add(200);
        valores.add(400);
        valores.add(400);
        valores.add(400);
        valores.add(400);
        valores.add(500);
        valores.add(500);
        valores.add(1000);
        valores.add(1000);
    }
    public Object getValor(){
        return this.valores.get(aleatorio(0, this.valores.size()));
    }
    
}
