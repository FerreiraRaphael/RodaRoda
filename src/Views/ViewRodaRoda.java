/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ControllerJogador;
import Controllers.ControllerPalavra;
import Controllers.ControllerRodaRoda;
import java.util.List;
import org.json.simple.JSONObject;

/**
 *
 * @author raphael
 */
public class ViewRodaRoda extends View{

    private ControllerRodaRoda controllerRodaRoda;
    private final ControllerPalavra controllerPalavra;
    private List<ControllerJogador> jogadores;
    private final JSONObject palavra;
    private String palavraSecreta;
    private final StringBuilder linha;
    private String erros;

    public ViewRodaRoda(ControllerPalavra controllerPalavra) {
        this.controllerPalavra = controllerPalavra;
        palavra = controllerPalavra.getJSON();
        linha = new StringBuilder();
    }

    public void setJogadores(List<ControllerJogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void telaInicial() {
        clearConsole();
        System.out.println("Palavra da Categoria :" + palavra.get("categoria"));
        palavraSecreta = (String) palavra.get("palavra");
        for (ControllerJogador jogador : jogadores) {
            System.out.println("::Jogador       :" + jogador.get("nome"));
            System.out.println("::----Pontos   :" + jogador.get("pontos"));
        }
        System.out.println(linha.toString());
        System.out.println("Letras Erradas : "+palavra.get("erros"));
    }
    
    public String adicionarJogador() {
        clearConsole();
        System.out.println("Qual o nome do jogador ?");
        String saida = scan.next();
        return saida;
    }
    
    public void fazerUmaTentativa(ControllerJogador jogador){
        clearConsole();
        System.out.println("Digite uma letra ou escreva uma palavra para tentar acertar a palavra secreta");
        String tentativa = scan.next().toLowerCase();
       
        if(tentativa.length() == 1){
            if(controllerPalavra.compararLetra(tentativa.charAt(0)))
                palavraSecreta = (String) controllerPalavra.get("palavraSecreta");
            else
                erros = (String) controllerPalavra.get("erros");
        }
        else{
            System.out.println("Tem certeza que deseja tentar a palavra : "+tentativa);
            System.out.println("sim|s ou nao|n");
            String saida = scan.next().toLowerCase(); 
            if(saida.equals("sim") || saida.equals("s"))
                if(controllerPalavra.compararPalavra(tentativa))
                    System.out.println("OMG VC ACERTOU, QUE LOUCURA !!!");
                else
                    System.out.println("MAIS SORTE DA PROXIMA VEZ LOOSER !!!");
            else
                fazerUmaTentativa(jogador);
        }    
    }
}
