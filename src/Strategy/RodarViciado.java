/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

/** Classe criada para o objeto RodarViciado. Sendo parte do Padrão de Projeto Strategy.
 *
 * @author raphael
 */
public class RodarViciado implements EstrategiaRodar{

    /** Este método serve apenas para retornar um único valor sempre igual. Por isso do nome RodarViciado.
     * 
     * @return int - Retorna um valor padrão inteiro.
     */
    @Override
    public int rodar() {
        return 0;
    }
    
}
