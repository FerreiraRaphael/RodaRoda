/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracoes;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raphael
 */
public class ControllerConfiguracaoTest {
    Configuracao conf;
    public ControllerConfiguracaoTest() {
        conf = Configuracao.getInstance();
    }

    /**
     * Test of getLimiteNumeroJogadores method, of class ControllerConfiguracao.
     */
    @Test
    public void testGetLimiteNumeroJogadores() {
        System.out.println("getLimiteNumeroJogadores");
        ControllerConfiguracao instance = new ControllerConfiguracao();
        int expResult = 3;
        int result = instance.getLimiteNumeroJogadores();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLimiteNumeroPalavras method, of class ControllerConfiguracao.
     */
    @Test
    public void testGetLimiteNumeroPalavras() {
        System.out.println("getLimiteNumeroPalavras");
        ControllerConfiguracao instance = new ControllerConfiguracao();
        int expResult = 3;
        int result = instance.getLimiteNumeroPalavras();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLimiteNumeroEtapas method, of class ControllerConfiguracao.
     */
    @Test
    public void testGetLimiteNumeroEtapas() {
        System.out.println("getLimiteNumeroEtapas");
        ControllerConfiguracao instance = new ControllerConfiguracao();
        int expResult = 7;
        int result = instance.getLimiteNumeroEtapas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumeroJogadores method, of class ControllerConfiguracao.
     */
    @Test
    public void testSetNumeroJogadores() {
        System.out.println("setNumeroJogadores");
        int numero = new Random().nextInt(10);
        ControllerConfiguracao instance = new ControllerConfiguracao();
        instance.setNumeroJogadores(numero);
        if(numero <= instance.getLimiteNumeroJogadores())
            assertEquals(numero, conf.getNumeroJogadores());
        else
            assertNotEquals(numero, conf.getNumeroJogadores());
    }

    /**
     * Test of setNumeroPalavras method, of class ControllerConfiguracao.
     */
    @Test
    public void testSetNumeroPalavras() {
        System.out.println("setNumeroPalavras");
        int numero = new Random().nextInt(10);
        ControllerConfiguracao instance = new ControllerConfiguracao();
        instance.setNumeroPalavras(numero);
        if(numero <= instance.getLimiteNumeroPalavras())
            assertEquals(numero, conf.getNumeroPalavras());
        else
            assertNotEquals(numero, conf.getNumeroPalavras());
    }

    /**
     * Test of setNumeroEtapas method, of class ControllerConfiguracao.
     */
    @Test
    public void testSetNumeroEtapas() {
        System.out.println("setNumeroEtapas");
        int numero = new Random().nextInt(10);
        ControllerConfiguracao instance = new ControllerConfiguracao();
        instance.setNumeroEtapas(numero);
        if(numero <= instance.getLimiteNumeroEtapas())
            assertEquals(numero, conf.getNumeroEtapas());
        else
            assertNotEquals(numero, conf.getNumeroEtapas());
    }

    /**
     * Test of setDiferentesCategorias method, of class ControllerConfiguracao.
     */
    @Test
    public void testSetDiferentesCategorias() {
        System.out.println("setDiferentesCategorias");
        boolean check = new Random().nextBoolean();
        ControllerConfiguracao instance = new ControllerConfiguracao();
        instance.setDiferentesCategorias(check);
        assertEquals(check, conf.isDiferentesEtapas());
    }
    
}
