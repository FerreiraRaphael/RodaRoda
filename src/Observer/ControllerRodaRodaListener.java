/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

/**
 *
 * @author raphael
 */
public interface ControllerRodaRodaListener extends java.util.EventListener{
    void acertou(ControllerRodaRodaEvent evento);
    void errou(ControllerRodaRodaEvent evento);
    void acertouPalavra(ControllerRodaRodaEvent evento);
    void errouPalavra(ControllerRodaRodaEvent evento);
    void gameover(ControllerRodaRodaEvent evento);
    void acabouEtapa(ControllerRodaRodaEvent evento);
    void iniciouEtapa(ControllerRodaRodaEvent evento);
}
