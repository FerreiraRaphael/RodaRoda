/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rodaroda;

import configurações.Validador;
import configurações.Mensageiro;
import configurações.Scanneador;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author raphael
 */
public class SelecionarPalavras implements Scanneador,Mensageiro,Validador{    
    private final HashMap<String, String []> palavrasMap;
    private String entrada;
    Categoria categoria;
    public SelecionarPalavras(){
        categoria = new Categoria();       
        palavrasMap = new HashMap<>();
    }
    @Override
    public void scan() {        
        Scanner entrar = new Scanner(System.in);        
        HashMap<String,String[]> categorias = categoria.getCategoria();
        System.out.println("Os seguintes Temas estão disponiveis: ");
        categorias.forEach((k,v)-> {
            System.out.println("Tema: "+k+" \n"    + "Palavras :"+Arrays.toString(v));
                });
        System.out.println("Escolha um dos Temas Disponiveis");
        int n = 0;
        for (Entry<String, String[]> entry : categorias.entrySet()) {
            String key = entry.getKey();
            if(palavrasMap.get(key) == null){
                System.out.println(" - "+key);
                n++;
            }                   
        }
        if(n == 0)
            System.out.println("Nenhum tema disponivel");
        System.out.println("Opções:"
                + "Para sair Digite: Sair\n"
                + "Para todos os Temas digite Todos");
                
       entrada = entrar.next();
       if(!entrada.equals("Sair"))
            validar();
       
       if(palavrasMap.isEmpty()){
           System.out.println("Pelo menos um tema deve ser escolhido");
           scan();
       }
    }
    
    @Override
    public void sucesso() {
        if("Todos".equals(entrada))
        {
            categoria.getCategoria().forEach((k,v)->{
                palavrasMap.put(k, v);
            });
        }
        else
        {
            palavrasMap.put(entrada, categoria.getCategoria().get(entrada));
        }
        System.out.println("Tema(s) Escolhido(s) : \n");
        palavrasMap.forEach((k,v)->{
            System.out.println("- "+k);
        });                
        repetir();
    }

    @Override
    public void falha() {
        System.out.println("Tema não existe, tente um existente");
        scan();
    }

    @Override
    public void validar() {
        if(categoria.getCategoria().get(entrada) != null)
            sucesso();
        else
            falha();
    }
    
    private void repetir(){
    Scanner entrar = new Scanner(System.in);
   
    System.out.println("Se desejar adicionar mais algum tema digite: \n"
                + "Sim\n"
                + "Se não \n"
                + "Não");
    
    String entrada = entrar.next();
    
        switch (entrada) {
            case "Sim":
                scan();
                break;
            case "Não":
            case "Nao":
                break;
            default:
                System.out.println("Digite algo valido");
                repetir();
                break;
        }
    }
    public HashMap<String,String[]> getPalavrasMap(){
        return this.palavrasMap;
    }
}
