/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author raphael
 */
public class Utils {
    public int aleatorio(int min, int max) {
        int range;
        range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
