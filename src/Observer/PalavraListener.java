/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

/**
 *
 * @author raphael
 */
public interface PalavraListener extends java.util.EventListener{
    void acertou(String palavra, String restante);
    void errou(String erros, String restante ,boolean errouPalavra);
    void palavraDescoberta();
}
