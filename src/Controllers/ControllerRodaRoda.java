/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Configuracoes.Configuracao;
import Models.Roda;
import Observer.PalavraAdapter;
import java.io.IOException;
import java.util.ArrayList;
import utils.Utils;
import Strategy.RodarAleatorio;
import Strategy.RodarViciado;
import java.util.logging.Level;
import java.util.logging.Logger;
import Observer.RodaListener;

/**
 *
 * @author raphael
 */
public final class ControllerRodaRoda extends PalavraAdapter{
    
    private final ArrayList<ControllerJogador> jogadores;
    private final ArrayList<RodaListener> listeners;
    private final Utils utils;
    private final Roda roda;
    private final Configuracao configuracao;
    private int numeroEtapas;
    private int atual;
    public final ControllerPalavra controllerPalavra;
    /** Construtor feito para instanciar a classe ControllerRodaRoda
     * 
     */
    public ControllerRodaRoda() {
        this.configuracao = Configuracao.getInstance();
        this.controllerPalavra = new ControllerPalavra(
                this.configuracao.getNumeroPalavras(),
                this.configuracao.isDiferentesEtapas());
        this.roda = new Roda();
        this.utils = new Utils();
        this.numeroEtapas = configuracao.getNumeroEtapas();
        this.jogadores = new ArrayList<>();
        this.listeners = new ArrayList<>();
        this.atual = -1;
    }
    /** Este método serve para quando tem apenas um jogador. Ele verifica caso o jogador tenha errado uma letra ou a palavra toda. Caso seja palavra toda ele perde o jogo.
     * 
     * @param jogador
     * @param errouPalavra
     * @return boolean - Retorna um valor boolean para mostrar se o jogador errou ou não uma palavra ou uma letra.
     */
    public boolean verificarErros(ControllerJogador jogador, boolean errouPalavra){
        boolean perdeu = false;
        if(errouPalavra){
            gameOver(false);
            perdeu = true;
        }
        if(jogador.erros >= 3){
            gameOver(false);
            perdeu = true;
        }
        return perdeu;
        
    }
    /** Serve para passar o comando do jogo para o próximo jogador.
     * 
     * @return ControllerJogador - Retorna o Controler jogador que ficará com o comando.
     */
    public ControllerJogador proximo() {
        ControllerJogador proximo;
        if(atual == -1){
            atual = utils.aleatorio(0, jogadores.size()-1);
            jogadores.get(atual).minhaVez();
            return jogadores.get(atual);
        }
        jogadores.get(atual).passeiVez();
        atual++;
        if (atual >= jogadores.size()) {
            atual = 0;
        }
        jogadores.get(atual).minhaVez();
        return jogadores.get(atual);
    }
    /** Este método servirá para ver se será comparado uma letra ou palavra.
     * 
     * @param tentativa String - Palavra ou letra que será passada para avaliação
     * @param palavra boolean - Verificará se será tentado uma palavra ou apenas uma letra.
     * @throws IOException 
     */
    public void tentar(String tentativa, boolean palavra) throws IOException {
        if(!palavra)
            controllerPalavra.compararLetra(tentativa.charAt(0));
        else
            controllerPalavra.compararPalavra(tentativa);
    }
    /** Será adicionado um jogador no ArrayList de jogadores e será feita uma verificação para saber se já completou o número de jogadores estabelecidos pela configuração. Caso tenha, a etapa será inicializada.
     * 
     * @param jogador ControllerJogador - Jogador que será adicionado à lista.
     * @throws IOException 
     */
    public void addJogador(ControllerJogador jogador) throws IOException {
        jogadores.add(jogador);
        if (jogadores.size() == configuracao.getNumeroJogadores()) {
            iniciarEtapa();
        }
    }
    /** Neste método será adicionado um listener para o Array de listeners. De acordo com o Padrão de Projetos Observer.
     * 
     * @param listener RodaListener - Listener que será adicionado.
     */
    public void addListener(RodaListener listener) {
        listeners.add(listener);
    }
    /** Neste método será removido um listener do Array de listeners. De acordo com o Padrão de Projetos Observer.
     * 
     * @param listener RodaListener - Listener a ser removido.
     */
    public void removeListener(RodaListener listener) {
        listeners.remove(listener);
    }
    /** Este método irá avaliar para ver se o jogador ganhou o perdeu. Caso ganhe ou perca os listeners serão avisados.
     * 
     * @param vencedor boolean - Caso seja true, ganhador ganhou. Sendo false jogador perdeu.
     */
    private void gameOver(boolean vencedor) {
        if(vencedor)
            listeners.forEach((listener) -> {
                listener.gameover(verificarVencedor());
            });
        else
            listeners.forEach((listener) -> {
                listener.gameover(null);
            });
    }
    /** Será feito o processo necessário para o inicio de cada Etapa. Além disso todos os Listeners serão avisados e os valores necessários serão passados para eles.
     * 
     * @throws IOException 
     */
    private void iniciarEtapa() throws IOException {
        for(ControllerJogador jogador : jogadores){
            jogador.numeroRodadas = 0;
        }
        for (RodaListener listener : listeners) {
            listener.iniciouEtapa(controllerPalavra.getPalavra(),controllerPalavra.getCategoria(),controllerPalavra.getLetrasRestantes().toString());
        }
    }
    /** Será feito um decremento no número de etapas restantes. Quando não tiver mais etapas o jogo acabará. Enquanto tiver será inicializado uma nova etapa.
     * 
     * @throws IOException 
     */
    private void finalizarEtapa() throws IOException {
        numeroEtapas--;
        if (numeroEtapas == 0) {
            gameOver(true);
        } else {
            iniciarEtapa();
        }
    }
   
    /** De acordo com o Padrão de Projetos Strategy foi criada esse método. Justamente para poder fazer a seleção de qual maneira de rodar a roda seria utilizada.
     * 
     * @param jogador
     * @return 
     */
    public Object[] rodar(ControllerJogador jogador) {
        Object[] valor;
        jogador.numeroRodadas ++;
        if(jogador.numeroRodadas != 2)
            valor = roda.rodar(new RodarAleatorio());
        else
            valor = roda.rodar(new RodarViciado());
        return valor;
    }

   /** Este método irá verificar quem é o possivel vencedor. Quando ele for chamado irá pegar o jogador com maior pontuação e colocá-lo com Status de vencedor.
    * 
    * @return 
    */
    private ControllerJogador verificarVencedor() {
        ControllerJogador vencedor = null;
        
        for (ControllerJogador jogador : jogadores) {
            if(vencedor == null)
                vencedor = jogador;
            else
                if(vencedor.getPontos() < jogador.getPontos())
                    vencedor = jogador;
        }
        return vencedor;
    }
    /** Caso a palavra seja descoberta este método finalizará a étapa e irá zerar os pontos na roda(pontos por etapa) de todos os jogadores.
     * 
     */
    @Override
    public void palavraDescoberta() {
        jogadores.forEach((jogador)->{jogador.somarPontosNaRoda(0);});
        try {
            this.finalizarEtapa();
        } catch (IOException ex) {
            Logger.getLogger(ControllerRodaRoda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
