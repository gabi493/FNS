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
public class driverDistanciaCluster {
    public static void main (String[] args) {
        String nombreclase = "Distancia";
        System.out.print("Driver" + nombreclase);
        
        distanciaCluster dist = new distanciaCluster();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false; 
            while (!out) {
			/*	System.out.println("Elige una opicion:");
				System.out.println("\t 1) distancia()");
				System.out.println("\t 2) distancia(numeroFilas, numeroColumnas, numeroPosiciones)");
				System.out.println("\t 3) setNumeroFilas(numeroFilas)");
				System.out.println("\t 4) getNumeroFilas()");
				System.out.println("\t 5) setNumeroColumnas(numeroColumnas)");
				System.out.println("\t 6) getNumeroColumnas()");
				System.out.println("\t 7) setNumeroPosiciones(numeroPosiciones)");
				System.out.println("\t 8) getNumeroPosiciones()");
				System.out.println("\t 9) setDistanciaMatriz(posicionA, posicionB, distancia)");
				System.out.println("\t 10) getDistanciaMatriz(posicionA, posicionB)");
				System.out.println("\t 11) setTodasDistanciasMatriz(v[numeroPosiciones] = [...])");
				System.out.println("\t 12) getTodasDistanciasMatriz()");
				System.out.println("\t 0) Salir");
              */
				System.out.println();
				
				String linea;
				String palabras[];
				String opcion;

				linea = buffer.readLine();
				palabras = linea.split(" ");
				opcion = palabras[0];

				int i = 0;

                try {
                    System.out.println("Opcion " + opcion + " seleccionada.");
                    switch (opcion) {
                        case "1": 
                            dist = new distanciaCluster();
                            break;
                        case "2":
                            dist = new distanciaCluster(Integer.parseInt(palabras[1]), Integer.parseInt(palabras[2]), Integer.parseInt(palabras[3]));
                            break;
                        case "3":   //setNumeroFilas
                            dist.setNumeroFilas(Integer.parseInt(palabras[1]));
                            break;
                        case "4":   //getNumeroFilas
                            System.out.println("Numero de filas = " + dist.getNumeroFilas());
                            break;
						case "5":   //setNumeroColumnas
                            dist.setNumeroColumnas(Integer.parseInt(palabras[1]));
                            break;
                        case "6":   //getNumeroColumnas
                            System.out.println("Numero de columnas = " + dist.getNumeroColumnas());
                            break;
						case "7":   //setNumeroPosiciones
                            dist.setNumeroPosiciones(Integer.parseInt(palabras[1]));
                            break;
                        case "8":   //getNumeroPosiciones
                            System.out.println("Numero de posiciones = " + dist.getNumeroPosiciones());
                            break;
						case "9":   //setDistanciaMatriz
                            dist.setDistanciaMatriz(Integer.parseInt(palabras[1]), Integer.parseInt(palabras[2]), Integer.parseInt(palabras[3]));
                            break;
                        case "10":   //getDistanciaMatriz
							System.out.println("Numero de filas = " + dist.getDistanciaMatriz(Integer.parseInt(palabras[1]), Integer.parseInt(palabras[2])));
							break;
						case "11":   //setTodasDistanciasMatriz
						    int p = dist.getNumeroPosiciones();
						    for (int j = 0; j < p; ++j) {
								for (int k = 0; k < p; ++k) {
								    dist.setDistanciaMatriz(j, k, Integer.parseInt(palabras[j*p + k + 1]));
								}
						    }
                            break;
						case "12":   //getTodasDistanciasMatriz
						    int np = dist.getNumeroPosiciones();
						    System.out.println("Distancias matriz: ");
						    for (int j = 0; j < np; ++j) {
								for (int k = 0; k < np; ++k) {
								    System.out.print( dist.getDistanciaMatriz(j, k) + " ");
								}
								System.out.println();
						    }
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
