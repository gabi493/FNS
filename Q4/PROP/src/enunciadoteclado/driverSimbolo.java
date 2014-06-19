/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enunciadoteclado;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



/**
 *
 * @author josep
 */
public class driverSimbolo {
    
    public static void main (String[] args) {
        String nombreclase = "simbolo";
        System.out.print("Driver" + nombreclase + ".");
        
        //simbolo c = new simbolo();
        char dr; 
        String aux;     
        
             
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) simbolo()");
                System.out.println("\t 2) simbolo(char newc)");
                System.out.println("\t 3) simbolo(simbolo original)");
                System.out.println("\t 4) char Info()");
                System.out.println("\t 5) void ModificarCaracter(char newchar)");
                System.out.println("\t 0) Salir");
                
                String linea;
                String palabras[];
                String opcion;

                linea = buffer.readLine();
                palabras = linea.split(" ");
                opcion = palabras[0];
                
                try {
                    System.out.println("Opcion " + opcion + " seleccionada.");
                    switch (opcion) {
                        case "1": 
                            simbolo c = new simbolo();
                            break;
                        case "2":
                            simbolo d = new simbolo(palabras[1].charAt(0));  
                            System.out.println("Se ha creado el simbolo que contiene "+ d.getInfo());
                            break;
                        case "3":
                            simbolo auxi = new simbolo(palabras[1].charAt(0));
                            simbolo e = new simbolo(auxi);
                            System.out.println("Simbolo original: " + auxi.getInfo());
                            System.out.println("Simbolo copia: " + e.getInfo());
                            break;
                        case "4": 
                            simbolo f = new simbolo(palabras[1].charAt(0));
                            System.out.println("Caracter que contiene el simbolo: " + f.getInfo() + ".");
                            break;
                        case "5":
                            simbolo prueba = new simbolo('p');
                            System.out.println("Contenido del simbolo original: " + prueba.getInfo());
                            prueba.setInfo(palabras[1].charAt(0));
                            System.out.println("Contenido del simbolo modificado: " + prueba.getInfo());
                            break;
                        case "0":
                            out = true;
                            break;
                        default: 
                            System.out.println("La opcion elegida no existe.");
                            break;
                    }
                } 
                catch (Exception e) { 
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Fin del driver");
        }
        catch (Exception e) { 
            System.out.println(e.getMessage());
        }
    }
}
