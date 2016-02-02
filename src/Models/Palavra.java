/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author raphael
 */
public class Palavra implements Model {
    private final List<Object> categorias;
    private final List<Object> palavras;
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
        //System.out.println(this.palavraSelecionada);
    }

    public List<Object> getCategorias() {
        return categorias;
    }

    public List<Object> getPalavras() {
        return palavras;
    }
    
    public Palavra() {
        this.categorias = new ArrayList<>();
        this.palavras = new ArrayList<>();
    }

}
