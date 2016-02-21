/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Configuracoes.ControllerConfiguracao;
import Controllers.ControllerJogador;
import Controllers.ControllerPalavraTest;
import java.io.IOException;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Utils;

/**
 *
 * @author raphael
 */
public class ViewRodaRodaTest {
    ViewRodaRoda instance;

    public ViewRodaRodaTest() throws IOException {
        ControllerConfiguracao controllerConfiguracoes = new ControllerConfiguracao();
        controllerConfiguracoes.setDiferentesCategorias(new Random().nextBoolean());
        controllerConfiguracoes.setNumeroEtapas(new Utils().aleatorio(1, 
                controllerConfiguracoes.getLimiteNumeroEtapas()));
        controllerConfiguracoes.setNumeroJogadores(new Utils().aleatorio(1,
                controllerConfiguracoes.getLimiteNumeroJogadores()));
        controllerConfiguracoes.setNumeroPalavras(new Utils().aleatorio(1, 
                controllerConfiguracoes.getLimiteNumeroPalavras()));
        this.instance = new ViewRodaRoda(new ViewInicial());
    }
    /**
     * Test of acertou method, of class ViewRodaRoda.
     */
    @Test
    public void testAcertou() {
        System.out.println("acertou");
        String palavra = new ControllerPalavraTest().randomString("teste", true);
        String restante = new ControllerPalavraTest().randomString("teste", true);
        instance.acertou(palavra, restante);
        assertEquals(palavra, instance.getPalavra());
        assertEquals(restante, instance.getLetrasRestantes());
    }

    /**
     * Test of errou method, of class ViewRodaRoda.
     */
    @Test
    public void testErrou() {
        System.out.println("errou");
        String erros = new ControllerPalavraTest().randomString("teste", true);
        String restante = new ControllerPalavraTest().randomString("teste", true);
        boolean errouPalavra = new Random().nextBoolean();
        instance.errou(erros, restante, errouPalavra);
        assertEquals(erros, instance.getErros());
        assertEquals(restante, instance.getLetrasRestantes());
    }

    /**
     * Test of gameover method, of class ViewRodaRoda.
     */
    @Test
    public void testGameover() {
        System.out.println("gameover");
        int random = new Random().nextInt(20);
        ControllerJogador vencedor;
        if(random <= 10)
             vencedor = null;
        else
            vencedor = new ControllerJogador("teste", new ContainerJogador());
        instance.gameover(vencedor);
        assertFalse(instance.isVisible());
    }

    /**
     * Test of iniciouEtapa method, of class ViewRodaRoda.
     */
    @Test
    public void testIniciouEtapa() {
        System.out.println("iniciouEtapa");
        String palavra = new ControllerPalavraTest().randomString("teste", true);
        String categoria = new ControllerPalavraTest().randomString("teste", true);
        String restante = new ControllerPalavraTest().randomString("teste", true);
        instance.iniciouEtapa(palavra, categoria, restante);
        assertEquals(restante, instance.getLetrasRestantes());
        assertEquals(categoria, instance.getCategoria());
        assertEquals(palavra, instance.getPalavra());
    }
    
}
