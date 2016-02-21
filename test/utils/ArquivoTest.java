/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raphael
 */
public class ArquivoTest {

    /**
     * Test of escolherArquivo method, of class Arquivo.
     */
    @Test
    public void testEscolherArquivo() {
        System.out.println("escolherArquivo");
        String caminho = "/Categorias";
        Arquivo instance = new Arquivo();
        instance.escolherArquivo(caminho);
        assertNotNull(instance.getFile());
    }

    /**
     * Test of lerArquivo method, of class Arquivo.
     */
    @Test
    public void testLerArquivo() throws Exception {
        System.out.println("lerArquivo");
        String caminho = "/Categorias";
        Arquivo instance = new Arquivo();
        instance.escolherArquivo(caminho);
        File file = instance.getFile();
        int expResult = 1;
        ArrayList result = instance.lerArquivo(file);
        assertEquals(expResult, result.size(), 20);
    }

    /**
     * Test of getName method, of class Arquivo.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String caminho = "/Categorias";
        Arquivo instance = new Arquivo();
        instance.escolherArquivo(caminho);
        String expResult = instance.getFile().getName();
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
}
