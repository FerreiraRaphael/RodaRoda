/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import utils.Arquivo;


/**
 *
 * @author raphael
 */
public final class ControllerPalavra extends Controller implements ControllerAbstrato{
    private final Models.Palavra palavra;
    private final Arquivo arquivo;
    private StringBuilder palavraSecreta;
    private List<String> palavras;
    private String categoriaSelecionada;
    private String palavraSelecionada;
    private String erros;
    
    public ControllerPalavra() {
        this.palavras = new ArrayList<>();
        this.arquivo = new Arquivo();
        palavra = new Models.Palavra();
        inicializarDados();
    }
    
    public void setarPalavra() throws IOException {
        arquivo.escolherArquivo("/Categorias");
        palavras = arquivo.lerArquivo(arquivo.getFile());
        palavraSelecionada = palavras.get(arquivo.aleatorio(0, this.palavras.size())).toLowerCase();
        set("categoriaSelecionada",categoriaSelecionada);
        set("palavraSelecionada",palavraSelecionada);
        atualizarDados();
        for (int i = 0; i < palavraSelecionada.length(); i++) {
            palavraSecreta.append("_");
        }
        set("palavraSecreta", palavraSecreta);
        erros = "";
        set("erros", erros);
    }
    
    public boolean compararLetra(char c){
        String palavra = this.palavra.getPalavraSelecionada();
        List<Integer> indices = null;
        if(palavra.indexOf(c) != -1){
            int fromIndex = 0;
            while ((fromIndex = (palavra.indexOf(c, fromIndex))) != -1){
                palavraSecreta.setCharAt(fromIndex, c);
            }
            set("palavraSecreta", palavraSecreta);
            return true;
            
        }else{
            if(erros.length() == 0)
                erros = erros+c;
            else
                erros = erros + ", " +c;
            set("erros", erros);
            return false;
        }
    }
    
    public boolean compararPalavra(String palavra){
        if(palavraSelecionada.equals(palavra.toLowerCase())){
            palavraSecreta = new StringBuilder(palavra);
            set("palavraSecreta", palavraSecreta);
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean verificarPalavraSecreta(){
        return palavraSecreta.toString().toLowerCase().equals(palavraSelecionada);
    }
    
    @Override
    public void inicializarDados() {
        set("palavra", palavra.getPalavraSelecionada());
        set("categoria", palavra.getCategoriaSelecionada());
    }

    @Override
    public void carregarDados(JSONObject Dados) {
        palavra.setCategoriaSelecionada((String) Dados.get("categoria"));
        palavra.setPalavraSelecionada((String) Dados.get("palavra"));
    }

    @Override
    public void atualizarDados() {
        carregarDados(getJSON());
    }
    
}
