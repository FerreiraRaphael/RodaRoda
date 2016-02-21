/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracoes;

/**
 *
 * @author raphael
 */
public final class ControllerConfiguracao {

    private final Configuracao configuracao;
    private final int limiteNumeroJogadores;
    private final int limiteNumeroPalavras;
    private final int limiteNumeroEtapas;
    /** Construtor que implementará o ControllerConfiguracao
     * 
     */
    public ControllerConfiguracao() {
        this.configuracao = Configuracao.getInstance();
        this.limiteNumeroJogadores = 3;
        this.limiteNumeroPalavras = 3;
        this.limiteNumeroEtapas = 7;
    }
    /** Este método retorna o limite do número de jogadores.
     * 
     * @return int : limite número de jogareos.
     */
    public int getLimiteNumeroJogadores() {
        return limiteNumeroJogadores;
    }
    /** Este método retorna o limite do número de palavras.
     * 
     * @return int - Limite do número de jogadores.
     */
    public int getLimiteNumeroPalavras() {
        return limiteNumeroPalavras;
    }
    /** Este método retorna o limite do número de Etapas.
     * 
     * @return int - Limite Número Etapas.
     */
    public int getLimiteNumeroEtapas() {
        return limiteNumeroEtapas;
    }
    /** Este método modificará o número de jogadores.
     * 
     * @param numero int - Valor que irá modificar.
     */
    public void setNumeroJogadores(int numero) {
        configuracao.setNumeroJogadores(numero);
    }
    /** Este método modificará o número de palavras.
     * 
     * @param numero int - Valor que irá modificar.
     */
    public void setNumeroPalavras(int numero) {
        configuracao.setNumeroPalavras(numero);
    }
    /** Este método modificará o número de Etapas.
     * 
     * @param numero int - Valor que irá modificar.
     */
    public void setNumeroEtapas(int numero) {
        configuracao.setNumeroEtapas(numero);
    }
    /** Este método modificará o número de Diferentes Categorias.
     * 
     * @param check boolean - Valor que irá modificar.
     */
    public void setDiferentesCategorias(boolean check) {
        configuracao.setDiferentesEtapas(check);
    }

}
