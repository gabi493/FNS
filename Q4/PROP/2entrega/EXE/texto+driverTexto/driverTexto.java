/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 *
 * @author gabriel
 */
public class driverTexto {
	public static void main (String[] args) {
        String nombreclase = "Texto";
        System.out.print("Driver" + nombreclase);
        
        texto text = new texto();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
			/*	System.out.println("Elige una opicion:");
				System.out.println("\t 1) texto()");
				System.out.println("\t 2) texto(idioma, titulo, numeroCaracteres)");
				
				System.out.println("\t 3) setIdioma(idioma)");
				System.out.println("\t 4) getIdioma()");
				System.out.println("\t 5) setTitulo(titulo)");
				System.out.println("\t 6) getTitulo()");
				System.out.println("\t 7) setNumeroCaracteres(numeroCaracteres)");
				System.out.println("\t 8) getNumeroCaracteres()");
				System.out.println("\t 0) Salir");
			*/
				System.out.println();
				
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
                            text = new texto();
                            break;
                        case "2":
                            text = new texto(palabras[1], palabras[2], Integer.parseInt(palabras[3]));
                            break;
                        case "3":   //setIdioma
                            text.setIdioma(palabras[1]);
                            break;
                        case "4":   //getIdioma
                            System.out.println("Idioma del texto = " + text.getIdioma());
                            break;
                        case "5":   //setTitulo
                            text.setTitulo(palabras[1]);
                            break;
                        case "6":   //getTitulo
                            System.out.println("Titulo del texto = " + text.getTitulo());
                            break;
						case "7":   //setNumeroCaracteres
                            text.setNumeroCaracteres(Integer.parseInt(palabras[1]));
                            break;
                        case "8":   //getNumeroCaracteres
                            System.out.println("Numero de caracteres del texto = " + text.getNumeroCaracteres());
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
