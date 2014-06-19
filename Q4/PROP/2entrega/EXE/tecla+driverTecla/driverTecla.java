/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package enunciadoteclado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author gabriel
 */
public class driverTecla {
    public static void main (String[] args) {
        String nombreclase = "Tecla";
        System.out.print("Driver" + nombreclase);
        
        tecla tec = new tecla();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
			/*	System.out.println("Elige una opicion:");
				System.out.println("\t 1) tecla()");
				System.out.println("\t 2) tecla(nombre, fila, columna");
				System.out.println("\t 3) setNombre(nombre)");
				System.out.println("\t 4) getNombre()");
				System.out.println("\t 5) setFila(fila)");
				System.out.println("\t 6) getFila()");
				System.out.println("\t 7) setColumna(columna)");
				System.out.println("\t 8) getColumna()");
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
                            tec = new tecla();
                            break;
                        case "2":
                            String aux = palabras[1];
                            char nombre = aux.charAt(0);
                            tec = new tecla(nombre, Integer.parseInt(palabras[2]), Integer.parseInt(palabras[3]));
                            break;
                        case "3":   //setNombre
                            String ax = palabras[1];
                            char name = ax.charAt(0);
                            tec.setNombre(name);
                            break;
                        case "4":   //getNombre
                            System.out.println("Nombre tecla = " + tec.getNombre());
                            break;
                        case "5":   //setFila
                            tec.setFila(Integer.parseInt(palabras[1]));
                            break;
                        case "6":   //getFila
                            System.out.println("Tamano fila = " + tec.getFila());
                            break;
                        case "7":   //setColumna
                            tec.setColumna(Integer.parseInt(palabras[1]));
                            break;
                        case "8":   //getColumna
                            System.out.println("Tamano columna = " + tec.getColumna());
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
