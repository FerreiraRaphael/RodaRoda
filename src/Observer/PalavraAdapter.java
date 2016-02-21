/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

/** Este método abstrato irá servir funcionar de acordo com o previsto pelo padrão de projetos Observer. Seus filhos irão implementar novamente os métodos que lhe forem convênientes. Os métodos que não forem implementados por eles não farão nada.
 *
 * @author raphael
 */
public abstract class PalavraAdapter implements PalavraListener
{
    /** Método não faz nada(A ser implementado pelas classes filhas).
     * 
     * @param palavra String - Palavra.
     * @param restante String - restante.
     */
    @Override
    public void acertou(String palavra, String restante) {}
    /** Método não faz nada(A ser implementado pelas classes filhas).
     * 
     * @param erros String - Os erros.
     * @param restante String - O que restou.
     * @param errouPalavra boolean - Um boolean que demonstre caso tenha errado ou não.
     */
    @Override
    public void errou(String erros, String restante, boolean errouPalavra) {}
    /** Método não faz nada(A ser implementado pelas classes filhas).
     * 
     */
    @Override
    public void palavraDescoberta() {}
    
}
