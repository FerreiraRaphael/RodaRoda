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

/** Classe para o objeto ControllerPalavra. Está servindo de Source para o Padrão de Projetos Observer.
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
    /** Construtor que irá instanciar a classe ControllerPalavra
     * 
     * @param numeroPalavras int - Neste parâmetro será colocado o número de Palavras.
     * @param diferentesCategorias boolean - Será colocado aqui uma opção para caso a pessoa queira ou não diferentes categorias durante o jogo.
     */
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
    /** Neste método, será adicionado os Listeners à lista de Arrays.
     * 
     * @param listener PalavraListener - Os listeners serão colocados aqui para que entrem como parâmetro.
     */
    public void addListener(PalavraListener listener) {
        listeners.add(listener);
    }
    /** Neste método, será removido os Listeners da lista de Arrays.
     * 
     * @param listener PalavraListener - Listener passado como parâmetro para a remoção.
     */
    public void removeListener(PalavraListener listener) {
        listeners.remove(listener);
    }
    /** Este método serve para demonstrar as letras restantes(que o jogador poderá escolher).
     * 
     * @return StringBuilder - Retornará um valor no formato StringBuilder.
     * @throws IOException 
     */
    public StringBuilder getLetrasRestantes() throws IOException {
        if (letrasRestantes == null) {
            escolherPalavras();
        }
        return letrasRestantes;
    }
    /** Este método demonstrará a categoria.
     * 
     * @return String - Será retornado uma String da categoria.
     * @throws IOException 
     */
    public String getCategoria() throws IOException {
        if (categoriaSelecionada == null) {
            escolherPalavras();
        }
        return categoriaSelecionada;
    }
    /** Este método irá mostrar a Palavra secreta.
     * 
     * @return String - Retorna a String da palavra secreta.
     * @throws IOException 
     */
    public String getPalavra() throws IOException {
        if (palavraSecreta == null) {
            escolherPalavras();
        }
        return palavraSecreta.toString();
    }
    /** Este método irá retornar os erros do jogador. Ou seja, as letras que ele usou, mas errou.
     * 
     * @return String - Uma String será retornada.
     */
    public String getErros() {
        return erros;
    }
    /** Este método irá escolher as palavras que serão utilizadas.
     * 
     * @throws IOException 
     */
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
    /** Este método irá dar um set na Palavra Secreta. Fazendo com que ela fique com os traços no lugar certo da(s) palavra(s) selecionada(s).
     * 
     */
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
    /** Este método irá buscar apenas uma palavra nos arquivos.
     * 
     * @return
     * @throws IOException 
     */
    private String selecionarPalavra() throws IOException {
        arquivo.escolherArquivo("/Categorias");
        ArrayList<String> palavras = arquivo.lerArquivo(arquivo.getFile());
        String selecionada = palavras.get(arquivo.aleatorio(0, palavras.size() - 1)).toLowerCase();
        return selecionada;
    }
    /** Este será toda a lógica do SelecionarPalavra. Auxiliando na escolha das palavras caso seja uma ou mais e caso seja de categorias diferentes.
     * 
     * @throws IOException 
     */
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
    /** Este método irá realizar o processo de comparar a letra que o jogador colocou, com a palavra selecionada. Seu objetivo é modificar a palavra secreta colocando no lugar dos - a letra correta caso tenha acertado. Caso tenha errado um processo se seguirá cuidando dos erros.
     * 
     * @param c char - Esta é a letra que será usada neste método.
     * @return boolean - Este retorno serve para mostrar se o usuário acertou a letra ou não.
     */
    public boolean compararLetra(char c) {
        String palavra = palavraSelecionada;
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
    /** Este método tem como objetivo comparar a palavra disponivel pelo jogador e a palavra selecionada pelo jogo. Caso esteja correto a palavra secreta será modificada para a palavra do usuário. Caso contrário, irá tratar o erro.
     * 
     * @param palavra String - Palavra passada para comparação.
     * @return boolean - Caso o usuário tenha acertado retorna true, caso contrário false.
     */
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
    /** Este método serve para adequar a palavra passada pelo usuário com o padrão que o software usa.
     * 
     * @param tentativa String - A palavra que será tratada.
     * @return String - Será retornado a palavra corrigida.
     */
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
    /** Este método irá verificar se a palavra secreta(apresentada para o jogador) é igual a palavra selecionada pelo jogo.
     * 
     */
    public void verificarPalavraSecreta() {
        if (palavraSecreta.toString().toLowerCase().equals(palavraSelecionada.toLowerCase())) {
            palavraDescoberta();
        }
    }
    /** Este método irá retirar uma letra das Letras Restantes(que o jogador pode escolher).
     * 
     * @param s String - Aqui estará a letra selecionada que será retirada.
     */
    private void retirarLetra(String s) {
        int indice = letrasRestantes.indexOf(s);
        letrasRestantes.deleteCharAt(indice);
        if (indice > 0) {
            letrasRestantes.deleteCharAt(indice - 1);
        }
    }
    /** Este método será utilizado para avisar a todos os listeners desta classe que o jogador acertou.
     * 
     */
    public void acertou() {
        listeners.forEach((listener) -> {
            listener.acertou(palavraSecreta.toString(), letrasRestantes.toString());
        });
    }
    /** Este método será utilizado para passar para os listeners que o usuário errou.
     * 
     * @param errouPalavra boolean - Aqui está um boolean explicando caso o usuário tenha errado a palavra toda ou apenas uma letra.
     */
    public void errou(boolean errouPalavra) {
        listeners.forEach((listener) -> {
            listener.errou(erros, letrasRestantes.toString(), errouPalavra);
        });
    }
    /** Este método serve para zerar os atributos para a próxima étapa e avisar os listeners.
     * 
     */
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
