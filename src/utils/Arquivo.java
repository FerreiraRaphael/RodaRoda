/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/** Esta Classe serve para mexer com os arquivos .txt que serão usados no projeto.
 *
 * @author raphael
 */
public class Arquivo extends Utils {

    private String caminho;
    private File file;
    /** Este método retornara o arquivo File
     * 
     * @return File
     */
    public File getFile() {
        return file;
    }
    /** Este método serve para escolher o arquivo que será lido.
     * 
     * @param caminho String - Demonstra o caminho até o arquivo.
     */
    public void escolherArquivo(String caminho) {
        caminho = System.getProperty("user.dir") + caminho;
        file = new File(caminho);
        file = file.listFiles()[aleatorio(0, file.list().length - 1)];
    }
    /** Este método lê o arquivo.
     * 
     * @param file File - Onde será colocado o arquivo.
     * @return ArrayList - Será retornado um ArrayList.
     * @throws IOException 
     */
    public ArrayList lerArquivo(File file) throws IOException {
        ArrayList lista = new ArrayList();
        try {
            FileReader arq;
            arq = new FileReader(file);

            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            int i = 0;

            while (linha != null) {
                lista.add(linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
                i++;
            }
            arq.close();
            return lista;
        } catch (FileNotFoundException ex) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    ex.getMessage());
            return lista;
        }
    }
    /** Este método serve para retornar o nome do arquivo.
     * 
     * @return String - Nome do Arquivo.
     */
    public String getName(){
            return file.getName();
        }
}
