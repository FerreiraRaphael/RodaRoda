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
public class View {
    public Scanner scan = new Scanner(System.in); 
    
    public static void clearConsole() {
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
