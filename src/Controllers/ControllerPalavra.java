/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raphael
 */
public class ControllerPalavra {

    List<Object> palavras;
    String categoriaSelecionada;

    public ControllerPalavra() {
        this.palavras = new ArrayList<>();
    }

    int aleatorio(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    private void lerArquivo() throws IOException {
        String caminho;
        FileReader arq;
        try {
            caminho = System.getProperty("user.dir") + "/Categorias";//+ nome;
            File file = new File(caminho);

            file = file.listFiles()[aleatorio(0, file.list().length - 1 )];
            
            arq = new FileReader(file);

            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            int i = 0;
            while (linha != null) {
                this.palavras.add(linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
                i++;
            }
            this.categoriaSelecionada = file.getName();

            arq.close();
        } catch (FileNotFoundException ex) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    ex.getMessage());
        }
    }

    public void setarPalavra() {
        Models.Palavra palavra = new Models.Palavra();
        try {
            lerArquivo();
        } catch (IOException ex) {
            System.out.println("Não foi possível selecionar uma categoria");
            System.out.println(ex);
        }
        String palavraSelecionada = this.palavras.get(aleatorio(0, this.palavras.size())).toString();
        palavra.setCategoriaSelecionada(categoriaSelecionada);
        palavra.setPalavraSelecionada(palavraSelecionada);
    }
}
