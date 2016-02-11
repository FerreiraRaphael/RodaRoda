/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controllers.ControllerAbstrato;
import org.json.simple.JSONObject;

/**
 *
 * @author raphael
 */
public interface View {
    void setController(ControllerAbstrato controller);
    JSONObject getDados();
}
