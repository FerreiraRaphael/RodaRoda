/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import utils.Arquivo;


/**
 *
 * @author raphael
 */
public class ControllerPalavra extends Arquivo implements Controller{
    private List<Object> palavras;
    private String categoriaSelecionada;
    private Models.Palavra palavra;
    public ControllerPalavra() {
        this.palavras = new ArrayList<>();
    }
    
    public void setarPalavra() throws IOException {
        palavra = new Models.Palavra();
        escolherArquivo("/Categorias");
        this.palavras = lerArquivo(getFile(), (ArrayList) palavras);
        String palavraSelecionada = this.palavras.get(aleatorio(0, this.palavras.size())).toString();
        palavra.setCategoriaSelecionada(categoriaSelecionada);
        palavra.setPalavraSelecionada(palavraSelecionada);
    }

    @Override
    public Model getModel() {
        return this.palavra;
    }
    
}
