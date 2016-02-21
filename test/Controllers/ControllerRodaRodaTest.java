/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import View.ContainerJogador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raphael
 */
public class ControllerRodaRodaTest {

    /**
     * Test of verificarErros method, of class ControllerRodaRoda.
     */
    @Test
    public void testVerificarErros() {
        System.out.println("verificarErros");
        ControllerJogador jogador = new ControllerJogador("teste",
                new ContainerJogador());
        jogador.erros = new Random().nextInt(3);
        boolean errouPalavra = new Random().nextBoolean();
        ControllerRodaRoda instance = new ControllerRodaRoda();
        boolean result = instance.verificarErros(jogador, errouPalavra);
        if (jogador.erros >= 3 || errouPalavra) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }

    /**
     * Test of proximo method, of class ControllerRodaRoda.
     */
    @Test
    public void testProximo() throws IOException {
        System.out.println("proximo");
        ControllerRodaRoda instance = new ControllerRodaRoda();
        ArrayList<ControllerJogador> jogadores = new ArrayList<>();
        int numeroJogadores = new Random().nextInt(2);
        for (int i = 0; i <= numeroJogadores; i++) {
            ControllerJogador jogador = new ControllerJogador("teste",
                    new ContainerJogador());
            jogadores.add(jogador);
            instance.addJogador(jogador);
        }
        boolean achou = false;
        for (int i = 0; i <= jogadores.size(); i++) {
            ControllerJogador jogador = instance.proximo();
            if (jogadores.contains(jogador)) {
                achou = true;
            } else {
                achou = false;
            }
        }
        assertTrue(achou);
    }
    
    /**
     * Test of rodar method, of class ControllerRodaRoda.
     */
    @Test
    public void testRodar() {
        System.out.println("rodar");
        ControllerJogador jogador = new ControllerJogador("teste"
                , new ContainerJogador());
        jogador.numeroRodadas = new Random().nextInt(3);
        ControllerRodaRoda instance = new ControllerRodaRoda();
        Object[] expResult = null;
        Object[] result = instance.rodar(jogador);
        Integer resultado = new Integer((int) result[1]);
        if(jogador.numeroRodadas != 2)
            assertEquals(0, resultado, 1000);
        else{
            assertFalse((boolean) result[0]);
            assertEquals(0, resultado.intValue());
            }
    }
}
