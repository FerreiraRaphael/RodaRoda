/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raphael
 */
public class RodarAleatorioTest {
    @Test
    public void testRodar() {
        System.out.println("rodar");
        RodarAleatorio instance = new RodarAleatorio();
        int result = instance.rodar();
        assertEquals(0, result, 19);
    }
    
}
