/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Observer.RodaListener;

/**
 *
 * @author raphael
 */
public class ControllerRodaRodaTest {
    
    public ControllerRodaRodaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of verificarErros method, of class ControllerRodaRoda.
     */
    @Test
    public void testVerificarErros() {
        System.out.println("verificarErros");
        ControllerJogador jogador = null;
        boolean errouPalavra = false;
        ControllerRodaRoda instance = null;
        boolean expResult = false;
        boolean result = instance.verificarErros(jogador, errouPalavra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of proximo method, of class ControllerRodaRoda.
     */
    @Test
    public void testProximo() {
        System.out.println("proximo");
        ControllerRodaRoda instance = null;
        ControllerJogador expResult = null;
        ControllerJogador result = instance.proximo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tentar method, of class ControllerRodaRoda.
     */
    @Test
    public void testTentar() throws Exception {
        System.out.println("tentar");
        String tentativa = "";
        boolean palavra = false;
        ControllerRodaRoda instance = null;
        instance.tentar(tentativa, palavra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addJogador method, of class ControllerRodaRoda.
     */
    @Test
    public void testAddJogador() throws Exception {
        System.out.println("addJogador");
        ControllerJogador jogador = null;
        ControllerRodaRoda instance = null;
        instance.addJogador(jogador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addListener method, of class ControllerRodaRoda.
     */
    @Test
    public void testAddListener() {
        System.out.println("addListener");
        RodaListener listener = null;
        ControllerRodaRoda instance = null;
        instance.addListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeListener method, of class ControllerRodaRoda.
     */
    @Test
    public void testRemoveListener() {
        System.out.println("removeListener");
        RodaListener listener = null;
        ControllerRodaRoda instance = null;
        instance.removeListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rodar method, of class ControllerRodaRoda.
     */
    @Test
    public void testRodar() {
        System.out.println("rodar");
        ControllerJogador jogador = null;
        ControllerRodaRoda instance = null;
        Object[] expResult = null;
        Object[] result = instance.rodar(jogador);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of palavraDescoberta method, of class ControllerRodaRoda.
     */
    @Test
    public void testPalavraDescoberta() {
        System.out.println("palavraDescoberta");
        ControllerRodaRoda instance = null;
        instance.palavraDescoberta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
