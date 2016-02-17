/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Palavra;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import utils.Arquivo;

/**
 *
 * @author raphael
 */
public final class ControllerPalavra extends Controller implements ControllerAbstrato {

    private final Palavra palavra;
    private final Arquivo arquivo;
    private StringBuilder palavraSecreta;
    private ArrayList<String> palavras;
    private ArrayList<String> categoriasSelecionadas;
    private ArrayList<String> palavrasSelecionadas;
    private String categoriaSelecionada;
    private String palavraSelecionada;
    private String erros;
    private final int numeroPalavras;
    private final boolean diferentesCategorias;
    
    public ControllerPalavra(int numeroPalavras, boolean diferentesCategorias) {
        palavras = new ArrayList<>();
        arquivo = new Arquivo();
        palavra = new Models.Palavra();
        inicializarDados();
        this.diferentesCategorias = diferentesCategorias;
        this.numeroPalavras = numeroPalavras;
        palavraSelecionada = null;
        categoriaSelecionada = null;
        palavraSecreta = null;
    }
    
    public String getCategoria() throws IOException{
        if(categoriaSelecionada == null)
            escolherPalavras();
        return categoriaSelecionada;
    }
    
    public String getPalavra() throws IOException{
        if(palavraSecreta == null)
            escolherPalavras();
        return palavraSecreta.toString();
    }
    
    public String getErros(){
        return erros;
    }
    
    private void escolherPalavras() throws IOException {
        arquivo.escolherArquivo("/Categorias");
        palavras = arquivo.lerArquivo(arquivo.getFile());
        categoriasSelecionadas = new ArrayList<>();
        palavrasSelecionadas = new ArrayList<>();
        if (numeroPalavras == 1) {
            palavrasSelecionadas.add(palavras.get(arquivo.aleatorio(0, this.palavras.size())).toLowerCase());
            categoriasSelecionadas.add(arquivo.getName());
        } else {
            setarPalavras(numeroPalavras, diferentesCategorias);
        }
        categoriaSelecionada = arquivo.unirString(categoriasSelecionadas);
        palavraSelecionada = arquivo.unirString(palavrasSelecionadas);
        set("categoriaSelecionada", categoriaSelecionada);
        set("palavraSelecionada", palavraSelecionada);
        atualizarDados();
        setarPalavraSecreta();
        set("palavraSecreta", palavraSecreta);
        erros = "";
        set("erros", erros);
    }

    private void setarPalavraSecreta() {
        palavraSecreta = new StringBuilder();
        for (int i = 0; i < palavraSelecionada.length(); i++) {
            if (palavraSelecionada.charAt(i) == ' ') {
                palavraSecreta.append(" ");
            } else {
                palavraSecreta.append("_");
            }
        }
    }

    private void setarPalavras(int numeroPalavras, boolean diferentesCategorias) throws IOException {
        if (diferentesCategorias) {
            for (int i = 0; i < numeroPalavras; i++) {
                arquivo.escolherArquivo("/Categorias");
                palavras = arquivo.lerArquivo(arquivo.getFile());
                palavrasSelecionadas.add(palavras.get(arquivo.aleatorio(0, this.palavras.size() - 1)).toLowerCase());
                categoriasSelecionadas.add(arquivo.getName());
            }
        } else {
            categoriasSelecionadas.add(arquivo.getName());
            for (int i = 0; i < numeroPalavras; i++) {
                palavrasSelecionadas.add(palavras.get(arquivo.aleatorio(0, this.palavras.size() - 1)).toLowerCase());
            }
        }
    }

    public boolean compararLetra(char c) {
        String palavra = (String) get("palavraSelecionada");
        ArrayList<Integer> indices = new ArrayList<>();
        if (palavra.indexOf(c) != -1) {
            int fromIndex = 0;
            while (fromIndex != -1) {
                fromIndex = palavra.indexOf(c, fromIndex);
                if(fromIndex != -1){
                    palavraSecreta.setCharAt(fromIndex, c);
                    fromIndex++;
                }
            }
            set("palavraSecreta", palavraSecreta);
            return true;

        } else {
            if (erros.equals("")) {
                erros = erros + c;
            } else {
                erros = erros + ", " + c;
            }
            set("erros", erros);
            return false;
        }
    }

    public boolean compararPalavra(String palavra) {
        if (palavraSelecionada.toLowerCase().equals(palavra.toLowerCase())) {
            palavraSecreta = new StringBuilder(palavra.toLowerCase());
            set("palavraSecreta", palavraSecreta);
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarPalavraSecreta() {
        return palavraSecreta.toString().toLowerCase().equals(palavraSelecionada.toLowerCase());
    }

    @Override
    public void inicializarDados() {
        set("palavraSelecionada", palavra.getPalavraSelecionada());
        set("categoriaSelecionada", palavra.getCategoriaSelecionada());
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
