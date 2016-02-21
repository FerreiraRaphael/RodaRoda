/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;



/**
 *
 * @author raphael
 */
public class Palavra {
    private String categoriaSelecionada;
    private String palavraSelecionada;

    public String getCategoriaSelecionada() {
        return categoriaSelecionada;
    }

    public void setCategoriaSelecionada(String categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
        //System.out.println(this.categoriaSelecionada);
    }

    public String getPalavraSelecionada() {
        return palavraSelecionada;
    }

    public void setPalavraSelecionada(String palavraSelecionada) {
        this.palavraSelecionada = palavraSelecionada;
    }

    public Palavra() {
        this.categoriaSelecionada = "";
        this.palavraSelecionada = "";
    }
}
