/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurações;

import java.util.Scanner;

/**
 *
 * @author raphael
 */
public class NumeroPalavras implements Mensageiro, Validador, Scanneador{
    private int maximo = 3;
    private int minimo = 1;
    private int numero;
    
    @Override
    public void sucesso() {
        System.out.println("Número de Palavras: "+numero);
    }

    @Override
    public void falha() {
        System.out.println("Digite um número de Palavras entre "+minimo+" e "+maximo);
        scan();
    }

    @Override
    public void validar() {
        if(numero>=minimo && numero<=maximo)
            sucesso();
        else
            falha();
    }

    @Override
    public void scan() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o número de Palavras que serão usadas por etapa:\n"
                    + "Limite de "+maximo+" Palavras");
        numero = entrada.nextInt();
        validar();
    }
    
    public int getNumero(){
        return numero;
    }
}
