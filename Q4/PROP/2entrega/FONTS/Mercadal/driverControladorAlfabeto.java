/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enunciadoteclado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author josep
 */
public class driverControladorAlfabeto {
    
    public static void main (String[] args) {
        String nombreclase = "alfabeto";
        System.out.print("Driver" + nombreclase + ".");
        
        controladorAlfabeto calf = new controladorAlfabeto();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) alfabeto()");
                System.out.println("\t 2) alfabeto(String idioma, int n)");
                System.out.println("\t 3) alfabeto(alfabeto original)");
                System.out.println("\t 4) addSimbolo (simbolo newsimbolo)");
                System.out.println("\t 5) escribirAlfabeto()");
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
                            calf = new controladorAlfabeto();
                            break;
                        case "2":
                            calf = new controladorAlfabeto((palabras[1]), Integer.parseInt(palabras[2]));
                            for (int i = 0; i < Integer.parseInt(palabras[2]); i++) {                                
                                simbolo a = new simbolo(palabras[i+3].charAt(0));
                                calf.addSimbolo(a);
                            }
                            break;
                        case "3":
                            alfabeto alf = new alfabeto((palabras[1]), Integer.parseInt(palabras[2]));
                            controladorAlfabeto copia = new controladorAlfabeto(alf);
                            System.out.println("La copia del alfabeto es: ");
                            copia.escribirAlfabeto();
                            break;
                        case "4": 
                            simbolo add = new simbolo(palabras[1].charAt(0));
                            calf.addSimbolo(add);
                            break;
                        case "5":
                            calf.escribirAlfabeto();
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
        }
        catch (Exception e) { 
            System.out.println(e.getMessage());
        }
    }
}
