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
public class RodarViciadoTest {

    /**
     * Test of rodar method, of class RodarViciado.
     */
    @Test
    public void testRodar() {
        System.out.println("rodar");
        RodarViciado instance = new RodarViciado();
        int result = instance.rodar();
        assertEquals(0, result);
    }
    
}
