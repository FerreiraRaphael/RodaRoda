/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracoes;

/** Está classe se baseia em um Singleton podendo ser instanciada apenas uma vez. Apenas as classes que estão no mesmo repositório que este e seus filhos poderão acessar seus métodos. Além disso, esta classe irá mexer com as configurações do Software.
 *
 * @author raphael
 */
public class Configuracao {

    private int numeroJogadores;
    private int numeroPalavras;
    private int numeroEtapas;
    private boolean diferentesEtapas;
    private static Configuracao me = null;
    /** Construtor que instancia a classe Configuracao.
     * 
     */
    private Configuracao() {
        this.numeroJogadores = 0;
        this.numeroPalavras = 0;
        this.numeroEtapas = 0;
        this.diferentesEtapas = true;
    }
    /** Método de acordo com o padrão Singleton que servirá para realizar a única instancia da Classe.
     * 
     * @return Configuracao - Retornará a configuração instanciada.
     */
    public static Configuracao getInstance(){
        if(me == null)
            me = new Configuracao();
        return me;
    }
    /** Este método modificará o Diferentes Etapas.
     * 
     * @param diferentesEtapas boolean - valor que modificará.
     */
    protected void setDiferentesEtapas(boolean diferentesEtapas) {
        this.diferentesEtapas = diferentesEtapas;
    }
    /** Este método modificará o número de jogadores.
     * 
     * @param numeroJogadores int - valor que modificará.
     */
    protected void setNumeroJogadores(int numeroJogadores) {
        this.numeroJogadores = numeroJogadores;
    }
    /** Este método modificará o número de palavras
     * 
     * @param numeroPalavras int - Valor que modificará.
     */
    protected void setNumeroPalavras(int numeroPalavras) {
        this.numeroPalavras = numeroPalavras;
    }
    /** Este método irá modificar o número de etapas.
     * 
     * @param numeroEtapas int - Valor que modificará.
     */
    protected void setNumeroEtapas(int numeroEtapas) {
        this.numeroEtapas = numeroEtapas;
    }
    /** Este método retornará o número de jogadores.
     * 
     * @return int - O número de jogadores.
     */
    public int getNumeroJogadores() {
        return numeroJogadores;
    }
    /** Este método retornará o número de palavras.
     * 
     * @return int - Número de palavras.
     */
    public int getNumeroPalavras() {
        return numeroPalavras;
    }
    /** Este método retornará o número de Etapas.
     * 
     * @return int - Número de Etapas.
     */
    public int getNumeroEtapas() {
        return numeroEtapas;
    }
    /** Este método retornará um valor boolean de diferente etapas.
     * 
     * @return boolean - Diferente Etapa.
     */
    public boolean isDiferentesEtapas() {
        return diferentesEtapas;
    }

}
