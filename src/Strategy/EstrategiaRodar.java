/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

/** Esta interface está contida no Padrão de Projetos Strategy como interface para que sejam criadas varias maneiras de passar uma estrategia de sorteio de valores para a Classe Roda.
 *
 * @author raphael
 */
public interface EstrategiaRodar {
    /** Este método rodar será definido pelas classes que implementarem esta inteface.
     * 
     * @return int - Retorna um valor inteiro.
     */
    int rodar();
}
