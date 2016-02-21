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
public class PalavraAdapter implements PalavraListener
{

    @Override
    public void acertou(String palavra, String restante) {}

    @Override
    public void errou(String erros, String restante, boolean errouPalavra) {}

    @Override
    public void palavraDescoberta() {}
    
}
