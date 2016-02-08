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
public class Roda{

//    private void somarPontos(int pontos) {
//    }
//
//    private void perderVez() {
//    }
    ArrayList<Object[]> valores;
    
    /*
    duas divisões de perde tudo ,
    duas de passa a vez,
    quatro divisões de 100 pontos ,
    quatro divisões de 200 pontos ,
    quatro divisões de 400 pontos ,
    duas divisões de 500 pontos ,
    duas divisões de 1000 pontos.
    */
    
    public ArrayList<Object []> getRoda(){
        return this.valores;
    }
    public void setRoda(ArrayList<Object []> lista){
        valores = lista;
    }
}
