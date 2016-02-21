/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

/** Esta interface servirá como padrão para todos os Listeners de Palavra. De acorco com o Padrão de Projeto Observer.
 *
 * @author raphael
 */
public interface PalavraListener extends java.util.EventListener{
    /** O método acertou vai dizer quando um jogador acerta uma palavra ou letra.
     * 
     * @param palavra String - palavra ou letra.
     * @param restante String - Restante.
     */
    void acertou(String palavra, String restante);
    /** O método errou servirá como padrão futuras implementações de como a classe irá tratar quando o usuário errou.
     * 
     * @param erros String - Mostra o erro.
     * @param restante String - Restante.
     * @param errouPalavra boolean - Demonstra se errou com um true e um false.
     */
    void errou(String erros, String restante ,boolean errouPalavra);
    /** Mostra o que a classe irá fazer caso a palavra tenha sido descoberta.
     * 
     */
    void palavraDescoberta();
}
