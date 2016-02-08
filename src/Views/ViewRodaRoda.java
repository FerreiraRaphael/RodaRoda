/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ControllerJogador;
import Controllers.ControllerPalavra;
import Controllers.ControllerRodaRoda;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 *
 * @author raphael
 */
public class ViewRodaRoda extends View{

    private ControllerRodaRoda controllerRodaRoda;
    private final ControllerPalavra controllerPalavra;
    private ArrayList<ControllerJogador> jogadores;
    private final JSONObject palavra;

    public ViewRodaRoda(ControllerPalavra controllerPalavra) {
        this.controllerPalavra = controllerPalavra;
        palavra = controllerPalavra.getJSON();
    }
    
    public ViewRodaRoda(ControllerPalavra controllerPalavra, ControllerRodaRoda controllerRodaRoda) {
        this.controllerPalavra = controllerPalavra;
        this.controllerRodaRoda = controllerRodaRoda;
        palavra = controllerPalavra.getJSON();
    }

    public void setJogadores(ArrayList<ControllerJogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void telaInicial() {
        clearConsole();
        System.out.println("Palavra da Categoria :" + palavra.get("categoriaSelecionada"));
        for (ControllerJogador jogador : jogadores) {
            System.out.println("::Jogador               :" + jogador.get("nome"));
            System.out.println("::----Pontos            :" + jogador.get("pontos"));
            System.out.println("::----Pontos na Roda    :" + controllerRodaRoda.get(jogador));
        }
        System.out.println(palavra.get("palavraSecreta").toString());
        System.out.println("Letras Erradas : "+palavra.get("erros"));
    }
    
    public String adicionarJogador() {
        clearConsole();
        System.out.println("Qual o nome do jogador ?");
        String saida = scan.next();
        return saida;
    }
    
    public String escreverTentativa(){
        clearConsole();
        System.out.println("Digite uma letra ou escreva uma palavra para tentar acertar a palavra secreta");
        String tentativa = scan.next().toLowerCase();
        while(scan.hasNext())
            tentativa = tentativa + scan.next().toLowerCase();
        if(tentativa.length() > 1){
            System.out.println("Tem certeza que deseja tentar a palavra : "+tentativa);
            System.out.println("se sim digite sim ou s");
            String saida = scan.next().toLowerCase(); 
                if(!(saida.equals("sim") && saida.equals("s")))
                    return escreverTentativa();
        }
        return tentativa;
 
    }
}
