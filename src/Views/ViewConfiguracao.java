/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.util.Scanner;

/**
 *
 * @author raphael
 */
public final class ViewConfiguracao {

    Controllers.ControllerConfiguracao controllerConfiguracoes;
    private final Scanner scan;

    public ViewConfiguracao() {
        controllerConfiguracoes = new Controllers.ControllerConfiguracao();
        scan = new Scanner(System.in);
        selecionarNumeroJogadores();
        selecionarNumeroEtapas();
        selecionarNumeroPalavras();
        controllerConfiguracoes.iniciarConfiguracoes();
    }

    public void selecionarNumeroJogadores() {
        clearConsole();
        System.out.println("Escolha o número de jogadores:");
        System.out.println("Limite entre 1 e " + controllerConfiguracoes.getLimiteNumeroJogadores());
        int numero = scan.nextInt();
        if (controllerConfiguracoes.setNumeroJogadores(numero)) {
            clearConsole();
            System.out.println("Número de Jogadores: " + numero);
        } else {
            clearConsole();
            System.out.println("Número de Jogadores invalido, por favor escolha um número entre 0 e " + controllerConfiguracoes.getLimiteNumeroJogadores());
            selecionarNumeroJogadores();
        }
    }

    public void selecionarNumeroPalavras() {
        clearConsole();
        System.out.println("Escolha o número de palavras:");
        System.out.println("Limite entre 1 e " + controllerConfiguracoes.getLimiteNumeroPalavras());
        int numero = scan.nextInt();
        if (controllerConfiguracoes.setNumeroPalavras(numero)) {
            clearConsole();
            System.out.println("Número de Palavras: " + numero);
        } else {
            clearConsole();
            System.out.println("Número de Palavras invalido, por favor escolha um número entre 0 e " + controllerConfiguracoes.getLimiteNumeroPalavras());
            selecionarNumeroPalavras();
        }
    }

    public void selecionarNumeroEtapas() {
        clearConsole();
        System.out.println("Escolha o número de jogadores:");
        System.out.println("Limite entre 1 e " + controllerConfiguracoes.getLimiteNumeroEtapas());
        int numero = scan.nextInt();
        if (controllerConfiguracoes.setNumeroEtapas(numero)) {
            clearConsole();
            System.out.println("Número de Etapas: " + numero);
        } else {
            clearConsole();
            System.out.println("Número de Etapas invalido, por favor escolha um número entre 0 e " + controllerConfiguracoes.getLimiteNumeroEtapas());
            selecionarNumeroEtapas();
        }
    }

    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) 
                Runtime.getRuntime().exec("cls");
             else 
                Runtime.getRuntime().exec("clear");
            System.out.flush();
        } catch (final Exception e) {
            System.out.println("Não foi possível limpar o console");
            System.out.println(e);
        }
    }
}
