/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Controllers.ControllerPalavraTest;
import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raphael
 */
public class UtilsTest {
    /**
     * Test of aleatorio method, of class Utils.
     */
    @Test
    public void testAleatorio() {
        System.out.println("aleatorio");
        int min = 0;
        int max = 19;
        Utils instance = new Utils();
        int result = instance.aleatorio(min, max);
        assertEquals(min, result, max);
    }

    /**
     * Test of unirString method, of class Utils.
     */
    @Test
    public void testUnirString() {
        System.out.println("unirString");
        ArrayList<String> strings = new ArrayList<>();
        int n = new Random().nextInt();
        for(int i = 0 ; i < n ; i++){
            strings.add(new ControllerPalavraTest().randomString("teste", false));
        }
        String separador = new Arquivo().separador;
        Utils instance = new Utils();
        String result = instance.unirString(strings);
        int fromIndex = 0;
        for(String string : strings){
            fromIndex = result.indexOf(string,fromIndex);
            assertNotEquals(-1, fromIndex);
        }
    }
    
}
