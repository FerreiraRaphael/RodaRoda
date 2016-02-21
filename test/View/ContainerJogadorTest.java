/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controllers.ControllerJogador;
import java.util.Random;
import javafx.scene.layout.Border;
import javax.swing.border.TitledBorder;
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
public class ContainerJogadorTest {
    
    public ContainerJogadorTest() {
    }
    
    /**
     * Test of jogadorCriado method, of class ContainerJogador.
     */
    @Test
    public void testJogadorCriado() {
        System.out.println("jogadorCriado");
        ContainerJogador instance = new ContainerJogador();
        ControllerJogador jogador = new ControllerJogador("teste", instance);
        instance.jogadorCriado(jogador);
        assertEquals(jogador.nome, instance.getNome());
        
    }

    /**
     * Test of jogadorSomouPontos method, of class ContainerJogador.
     */
    @Test
    public void testJogadorSomouPontos() {
        System.out.println("jogadorSomouPontos");
        int pontos = new Random().nextInt();
        int pontosNaRoda = new Random().nextInt();
        ContainerJogador instance = new ContainerJogador();
        instance.jogadorSomouPontos(pontos, pontosNaRoda);
        assertEquals(String.valueOf(pontos), instance.getPontos());
        assertEquals(String.valueOf(pontosNaRoda), instance.getPontosNaRoda());
    }

    /**
     * Test of jogadorPassouVez method, of class ContainerJogador.
     */
    @Test
    public void testJogadorPassouVez() {
        System.out.println("jogadorPassouVez");
        ContainerJogador instance = new ContainerJogador();
        instance.jogadorPassouVez();
        boolean tipo = instance.getBorder() instanceof TitledBorder;
        assertFalse(tipo);
        
    }

    /**
     * Test of vezDoJogador method, of class ContainerJogador.
     */
    @Test
    public void testVezDoJogador() {
        System.out.println("vezDoJogador");
        ContainerJogador instance = new ContainerJogador();
        instance.vezDoJogador();
        boolean tipo = instance.getBorder() instanceof TitledBorder;
        assertTrue(tipo);
    }
    
}
