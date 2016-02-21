/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/** Classe para objetos do tipo Jogador onde serão contidos valores e métodos para o mesmo.
 * 
 * @author raphael
 */
public class Jogador {
    
    
    private int pontos;
    private int pontosNaRoda;
    private String nome;
/** Construtor, onde será instanciado a classe Jogador.
 * @author Nikolas Matias
 * 
 */
    public Jogador() {
        this.nome = "";
        this.pontos = 0;
        this.pontosNaRoda = 0;
    }
    
    public String getNome() {
        return nome;
    }
/** Método setNome irá modificar o nome do jogador.
 * @author Nikolas Matias
 * @param nome String - Novo nome que será usado para modificar o nome do jogador.
 */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /** Método getPontosNaRoda será utilizado para ver os pontos naquela étapa do jogador.
     * @author Nikolas Matias
     * @return int - Será retornado o valor dos pontos na Roda.
     */
    public int getPontosNaRoda() {
        return pontosNaRoda;
    }
/** Método setPontosNaRoda vai alterar o valor dos pontos naquela étapa
 * @author Nikolas Matias
 * @param pontosNaRoda int -  Os pontos que seram usados para sobrescrever os anteriores.
 */
    public void setPontosNaRoda(int pontosNaRoda) {
        this.pontosNaRoda = pontosNaRoda;
    }
    /** Método getPontos serve para mostrar o valor dos Pontos gerais. Aqueles que são acumulados por étapa ganha.
     * @author Nikolas Matias
     * @return int - Retorna os Pontos.
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * Método setPontos modificará o valor que está dentro dos pontos gerais.
     *
     * @param numero int - valor que será usado para alterar o valor de pontos gerais.
     */
    public void setPontos(int numero){
        this.pontos = numero;
    }

}
