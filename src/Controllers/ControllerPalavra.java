/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Palavra;
import Observer.PalavraListener;
import java.io.IOException;
import java.util.ArrayList;
import utils.Arquivo;

/**
 *
 * @author raphael
 */
public final class ControllerPalavra {

    private final ArrayList<PalavraListener> listeners;
    private final boolean diferentesCategorias;
    private final int numeroPalavras;
    private final Palavra palavra;
    private final Arquivo arquivo;
    private ArrayList<String> categoriasSelecionadas;
    private ArrayList<String> palavrasSelecionadas;
    private StringBuilder letrasRestantes;
    private StringBuilder palavraSecreta;
    private String categoriaSelecionada;
    private String palavraSelecionada;
    private String erros;

    public ControllerPalavra(int numeroPalavras, boolean diferentesCategorias) {
        this.listeners = new ArrayList<>();
        this.arquivo = new Arquivo();
        this.palavra = new Palavra();
        this.diferentesCategorias = diferentesCategorias;
        this.numeroPalavras = numeroPalavras;
        this.palavraSelecionada = null;
        this.categoriaSelecionada = null;
        this.palavraSecreta = null;
    }

    public void addListener(PalavraListener listener) {
        listeners.add(listener);
    }

    public void removeListener(PalavraListener listener) {
        listeners.remove(listener);
    }

    public StringBuilder getLetrasRestantes() throws IOException {
        if (letrasRestantes == null) {
            escolherPalavras();
        }
        return letrasRestantes;
    }

    public String getCategoria() throws IOException {
        if (categoriaSelecionada == null) {
            escolherPalavras();
        }
        return categoriaSelecionada;
    }

    public String getPalavra() throws IOException {
        if (palavraSecreta == null) {
            escolherPalavras();
        }
        return palavraSecreta.toString();
    }

    public String getErros() {
        return erros;
    }

    private void escolherPalavras() throws IOException {
        categoriasSelecionadas = new ArrayList<>();
        palavrasSelecionadas = new ArrayList<>();
        setarPalavras();
        categoriaSelecionada = arquivo.unirString(categoriasSelecionadas);
        palavraSelecionada = arquivo.unirString(palavrasSelecionadas);
        setarPalavraSecreta();
        letrasRestantes = new StringBuilder("a b c d e f g h i j k l m n o p q r t s v u x w y z ç");
        erros = "";
        palavra.setCategoriaSelecionada(categoriaSelecionada);
        palavra.setPalavraSelecionada(palavraSelecionada);
    }

    private void setarPalavraSecreta() {
        palavraSecreta = new StringBuilder();
        String sepador = arquivo.separador.trim();
        for (int i = 0; i < palavraSelecionada.length(); i++) {
            if (palavraSelecionada.charAt(i) == ' ' || String.valueOf(palavraSelecionada.charAt(i)).equals(String.valueOf(sepador))) {
                palavraSecreta.append(palavraSelecionada.charAt(i));
            } else {
                palavraSecreta.append("-");
            }
        }
    }

    private String selecionarPalavra() throws IOException {
        arquivo.escolherArquivo("/Categorias");
        ArrayList<String> palavras = arquivo.lerArquivo(arquivo.getFile());
        String selecionada = palavras.get(arquivo.aleatorio(0, palavras.size() - 1)).toLowerCase();
        return selecionada;
    }

    private void setarPalavras() throws IOException {
        if (numeroPalavras == 1) {
            palavrasSelecionadas.add(selecionarPalavra());
            categoriasSelecionadas.add(arquivo.getName());
        } else {
            String selecionada;
            selecionada = selecionarPalavra();
            if (diferentesCategorias) {
                for (int i = 0; i < numeroPalavras; i++) {
                    while (palavrasSelecionadas.contains(selecionada)) {
                        selecionada = selecionarPalavra();
                    }
                    palavrasSelecionadas.add(selecionada);
                    categoriasSelecionadas.add(arquivo.getName());
                }
            } else {
                ArrayList<String> palavras = arquivo.lerArquivo(arquivo.getFile());
                categoriasSelecionadas.add(arquivo.getName());
                for (int i = 0; i < numeroPalavras; i++) {
                    while (palavrasSelecionadas.contains(selecionada)) {
                        selecionada = palavras.get(arquivo.aleatorio(0, palavras.size() - 1)).toLowerCase();
                    }
                    palavrasSelecionadas.add(selecionada);
                }
            }
        }
    }

    public boolean compararLetra(char c) {
        String palavra = palavraSelecionada;
        ArrayList<Integer> indices = new ArrayList<>();
        boolean acertou = false;
        if (palavra.indexOf(c) != -1) {
            int fromIndex = 0;
            while (fromIndex != -1) {
                fromIndex = palavra.indexOf(c, fromIndex);
                if (fromIndex != -1) {
                    palavraSecreta.setCharAt(fromIndex, c);
                    fromIndex++;
                }
            }
            acertou = true;
        } else {
            if (erros.equals("")) {
                erros = erros + c;
            } else {
                erros = erros + ", " + c;
            }
            acertou = false;
        }
        retirarLetra(String.valueOf(c));
        if (acertou) {
            acertou();
            verificarPalavraSecreta();
        } else {
            errou(false);
        }
        return acertou;
    }

    public boolean compararPalavra(String palavra) {
        palavra = tratarTentativa(palavra);
        if (palavraSelecionada.toLowerCase().equals(palavra.toLowerCase())) {
            palavraSecreta = new StringBuilder(palavra.toLowerCase());
            acertou();
            palavraDescoberta();
            return true;
        } else {
            errou(true);
            return false;
        }
    }

    private String tratarTentativa(String tentativa) {
        StringBuilder tent = new StringBuilder(tentativa);
        int fromIndex = 0;
        while (fromIndex != -1) {
            fromIndex = palavraSelecionada.indexOf(arquivo.separador, fromIndex);
            if (fromIndex != -1) {
                tent.deleteCharAt(fromIndex);
                tent.insert(fromIndex, arquivo.separador);
                fromIndex += arquivo.separador.length();
            }
        }
        return tent.toString();
    }

    public void verificarPalavraSecreta() {
        if (palavraSecreta.toString().toLowerCase().equals(palavraSelecionada.toLowerCase())) {
            palavraDescoberta();
        }
    }

    private void retirarLetra(String s) {
        int indice = letrasRestantes.indexOf(s);
        letrasRestantes.deleteCharAt(indice);
        if (indice > 0) {
            letrasRestantes.deleteCharAt(indice - 1);
        }
    }

    public void acertou() {
        listeners.forEach((listener) -> {
            listener.acertou(palavraSecreta.toString(), letrasRestantes.toString());
        });
    }

    public void errou(boolean errouPalavra) {
        listeners.forEach((listener) -> {
            listener.errou(erros, letrasRestantes.toString(), errouPalavra);
        });
    }

    public void palavraDescoberta() {
        palavraSecreta = null;
        categoriaSelecionada = null;
        letrasRestantes = null;
        erros = "";
        listeners.forEach((listener) -> {
            listener.palavraDescoberta();
        });
    }
}
