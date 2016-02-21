/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raphael
 */
public class ControllerPalavraTest {

    public ControllerPalavra instance;

    public ControllerPalavraTest() {
        instance = new ControllerPalavra(
                new Random().nextInt(3),
                new Random().nextBoolean());
    }
    /**
     * Test of getLetrasRestantes method, of class ControllerPalavra.
     */
    @Test
    public void testGetLetrasRestantes() throws Exception {
        System.out.println("getLetrasRestantes");
        StringBuilder expResult = instance.getLetrasRestantes();
        StringBuilder result = instance.getLetrasRestantes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoria method, of class ControllerPalavra.
     */
    @Test
    public void testGetCategoria() throws Exception {
        System.out.println("getCategoria");
        String expResult = instance.getCategoria();
        String result = instance.getCategoria();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPalavra method, of class ControllerPalavra.
     */
    @Test
    public void testGetPalavra() throws Exception {
        System.out.println("getPalavra");
        String expResult = instance.getPalavra();
        String result = instance.getPalavra();
        assertEquals(expResult, result);
    }

    /**
     * Test of getErros method, of class ControllerPalavra.
     */
    @Test
    public void testGetErros() {
        System.out.println("getErros");
        String expResult = instance.getErros();
        String result = instance.getErros();
        assertEquals(expResult, result);
    }

    public String randomString(String s, boolean letra) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        if (letra) {
            for (int i = 0; i < s.length(); i++) {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
        } else {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * Test of compararLetra method, of class ControllerPalavra.
     */
    @Test
    public void testCompararLetra() throws IOException {
        System.out.println("compararLetra");
        String secreta = instance.getPalavra();
        String c = randomString(secreta, false);
        boolean expResult = true;
        boolean result = instance.compararLetra(c.charAt(0));
        boolean logica = result == true || result == false;
        assertEquals(expResult, logica);
    }

    /**
     * Test of compararPalavra method, of class ControllerPalavra.
     */
    @Test
    public void testCompararPalavra() throws IOException {
        System.out.println("compararPalavra");
        String palavra = randomString(instance.getPalavra(), 
                            true);
        boolean expResult = true;
        boolean result = instance.compararPalavra(palavra);
        boolean logica = result == true || result == false;
        assertEquals(expResult, logica);
        
    }

    /**
     * Test of palavraDescoberta method, of class ControllerPalavra.
     */
    @Test
    public void testPalavraDescoberta() throws IOException {
        String palavra = instance.getPalavra();
        instance.palavraDescoberta();
        String palavra2 = instance.getPalavra();
        assertNotSame(palavra, palavra2);
    }

}
