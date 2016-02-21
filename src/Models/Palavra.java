/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;



/** Classe para Objetos do tipo Palavra, onde será contido valores e métodos para o mesmo.
 *
 * @author raphael
 */
public class Palavra {
    private String categoriaSelecionada;
    private String palavraSelecionada;

 /** Método getCategoriaSelecionada serve para retornar a categoria da palavra selecionada.
 * @author Nikolas Matias
 * @return String - Será retornado o valor da Categoria Selecionada.
 */
    public String getCategoriaSelecionada() {
        return categoriaSelecionada;
    }
/** Método setCategoriaSelecionada irá modificar o valor da Categoria Selecionada para esta palavra.
 * 
 * @param categoriaSelecionada String - O valor que irá modificar a Categoria Selecionada já existente.
 */
    public void setCategoriaSelecionada(String categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
        //System.out.println(this.categoriaSelecionada);
    }
/** Método getPalavraSelecionada irá retornar a palavra selecionada pelo usuário
 * @author Nikolas Matias
 * @return String - Será retornado a palavra selecionada.
 */
    public String getPalavraSelecionada() {
        return palavraSelecionada;
    }
/** Método setPalavraSelecionada que irá modificar a palavra selecionada.
 * @author Nikolas Matias
 * @param palavraSelecionada String - Parametro que irá modificar a Palavra selecionada já existente.
 */
    public void setPalavraSelecionada(String palavraSelecionada) {
        this.palavraSelecionada = palavraSelecionada;
    }
/** Construtor onde será instanciado a classe Palavra.
 * 
 */
    public Palavra() {
        this.categoriaSelecionada = "";
        this.palavraSelecionada = "";
    }
}
