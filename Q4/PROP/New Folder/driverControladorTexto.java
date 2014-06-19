

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alex
 */
public class driverControladorTexto {
    public static void main (String[] args) throws IOException {
        String nombreclase = "ControladorTexto";
        System.out.print("Driver" + nombreclase + ".");
        controladorTexto ct = new controladorTexto();
        ct.realizarAccion("seleccionar", "");
        estadisticas e = new estadisticas(3);
        alfabeto alf = new alfabeto();
        simbolo a = new simbolo('a');
        alf.addSimbolo(a);
        simbolo b = new simbolo('b');
        alf.addSimbolo(b);
        simbolo c = new simbolo('c');
        alf.addSimbolo(c);
        System.out.println(alf.getNumCaracteres());
        alf.escribirAlfabeto();
        ct.leerParDeLetras(e,alf);
        e.leerMatriz();
        
        
        
        /*
        
         try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            boolean out = false; 
            while (!out) {
                System.out.println("Elige una opicion:");
                System.out.println("\t 1) controladorTexto()");
                System.out.println("\t 2) realizarAccion");
                System.out.println("\t 3) cerrarTexto()");
                System.out.println("\t 4) leerParDeLetras(estadisticas e,alfabeto c)");
                System.out.println("\t 5) escribirTexto(String SCadena)");
                System.out.println("\t 6) modificarTexto(String Satigualinea,String Snuevalinea)");
                System.out.println("\t 7) leerTexto()");
                System.out.println("\t 8) getRuta()");
                System.out.println("\t 9) getTitulo()");
                System.out.println("\t 10) getIdioma()");
                System.out.println("\t 0) salir");
                
				
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
                            ct = new controladorTexto();
                            break;
                        case "2":
                            ct.abrirTexto(palabras[1]);
                            break;
                        case "3":   //setIdioma
                            ct.cerrarTexto();
                            break;
                        case "4":   //getIdioma
                            
                           // ct.leerParDeLetras(estadisticas e,alfabeto c);
                            break;
                        case "5":   //setTitulo
                            ct.escribirTexto(palabras[1]);
                            break;
                        case "6":   //getTitulo
                            ct.modificarTexto(palabras[1],palabras[2]);
                            break;
						case "7":   //setNumeroCaracteres
                            ct.leerTexto();
                            break;
                        case "8":   //getNumeroCaracteres
                            System.out.println("La ruta del texto es = " + ct.getRuta());
                            break;
                        case "9":   //getNumeroCaracteres
                            System.out.println("El titulo del texto es = " + ct.getTitulo());
                            break;   
                        case "10":   //getNumeroCaracteres
                            System.out.println("El idioma del texto es  = " + ct.getIdioma());
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
        }*/
    }
}