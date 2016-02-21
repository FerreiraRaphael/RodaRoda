/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import utils.Utils;

/**
 *
 * @author raphael
 */
public class RodarAleatorio implements EstrategiaRodar{

    @Override
    public int rodar() {
        return new Utils().aleatorio(0, 19);
    }
    
}
