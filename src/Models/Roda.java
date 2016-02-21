/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Strategy.EstrategiaRodar;
import java.util.ArrayList;

/** Classe criada para o Objeto Roda, onde será contido valores e métodos para o mesmo. Dentro dela teremos um processo que irá mexer na sorte e no azar dos jogadores durante o jogo.
 *
 * @author raphael
 */
public class Roda {
    
    private ArrayList<Object[]> valores;
    /**Construtor que irá instanciar a classe Roda. 
     * 
     */
    public Roda() {
        this.valores = new ArrayList<>();
        valores.add(new Object[]{false, 0});
        valores.add(new Object[]{false, 0});
        valores.add(new Object[]{false, 1});
        valores.add(new Object[]{false, 1});
        valores.add(new Object[]{true, 100});
        valores.add(new Object[]{true, 100});
        valores.add(new Object[]{true, 100});
        valores.add(new Object[]{true, 100});
        valores.add(new Object[]{true, 200});
        valores.add(new Object[]{true, 200});
        valores.add(new Object[]{true, 200});
        valores.add(new Object[]{true, 200});
        valores.add(new Object[]{true, 400});
        valores.add(new Object[]{true, 400});
        valores.add(new Object[]{true, 400});
        valores.add(new Object[]{true, 400});
        valores.add(new Object[]{true, 500});
        valores.add(new Object[]{true, 500});
        valores.add(new Object[]{true, 1000});
        valores.add(new Object[]{true, 1000});
    }  
    /** Método rodar será utilizado para pegar apenas um valores contida na roda.
     * 
     * @param estrategia EstragegiaRodar - Será utilizado como um padrão de projeto Strategy. As classes que implementarem o classe Roda, poderam escolher a melhor maneira de utilizar. Mas o principio básico é ser utilizado para escolher um indice para escolher um valor dentro da Roda. 
     * @return Object[] - Retornará um Object[] de dentro da roda.
     */
    public Object[] rodar(EstrategiaRodar estrategia) {
        int indice = estrategia.rodar();
        return valores.get(indice);
    }
}
