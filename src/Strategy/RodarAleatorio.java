/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import utils.Utils;

/** Classe criada para o objeto RodarAleatorio. Tendo o objetivo apenas de retornar um valor inteiro para a classe Roda. Está inserido no Padrão de Projeto Strategy.
 *
 * @author raphael
 */
public class RodarAleatorio implements EstrategiaRodar{

    /** Este Método será utilizado para retornar um valor inteiro aleatório para roda.
    * @return int - Será retornado um valor inteiro.
    */
    @Override
    public int rodar() {
        return new Utils().aleatorio(0, 19);
    }
    
}
