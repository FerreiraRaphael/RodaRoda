/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.List;
import utils.Utils;

/**
 *
 * @author raphael
 */
public class Roda{

    private void somarPontos(int pontos) {
    }

    private void perderVez() {
    }
    List<Object> roda;
    
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
        roda = new ArrayList<>();
        roda.add("lost");
        roda.add("lost");
        roda.add("pass");
        roda.add("pass");
        roda.add(100);
        roda.add(100);
        roda.add(100);
        roda.add(100);
        roda.add(200);
        roda.add(200);
        roda.add(200);
        roda.add(200);
        roda.add(400);
        roda.add(400);
        roda.add(400);
        roda.add(400);
        roda.add(500);
        roda.add(500);
        roda.add(1000);
        roda.add(1000);
    }
    
}
