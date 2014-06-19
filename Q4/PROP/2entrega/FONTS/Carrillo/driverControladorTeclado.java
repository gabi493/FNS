/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package enunciadoteclado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*enum TipoTeclado {
    rectangular,
    hexagonal,
    dosHexagonos,
}*/

/**
 *
 * @author gabriel
 */
public class driverControladorTeclado {
    public static void main (String[] args) {
        String nombreclase = "Teclado";
        System.out.print("Driver" + nombreclase);
        
        teclado tec = null;
        controladorTeclado cTec = new controladorTeclado();
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false;
            boolean out1 = false;
            while (!out) {
				/*System.out.println("Elige una opicion:");
				System.out.println("\t 1) crearTeclado(formaTeclado, numeroFilas, numeroColumnas, numeroPosiciones, teclas4Lados)");
				System.out.println("\t 2) cambiarForma(tipoTeclado)");
				System.out.println("\t 3) consultarForma()");
				System.out.println("\t 4) cambiarNumeroFilas(tamano)");
				System.out.println("\t 5) consultarNumeroFilas()");
				System.out.println("\t 6) cambiarNumeroColumnas(tamano)");
				System.out.println("\t 7) consultarNumeroColumnas()");
				System.out.println("\t 8) cambiarTeclasDe4Lados(b)");
				System.out.println("\t 9) consultarTeclasDe4Lados()");
				System.out.println("\t 10) cambiarNumeroPosiciones(numeroPosiciones)");
				System.out.println("\t 11) consultarNumeroPosiciones()");
				System.out.println("\t 0) Salir");*/
				
				
				System.out.println();
				
				String linea;
				String palabras[];
				String opcion;

				linea = buffer.readLine();
				palabras = linea.split(" ");
				opcion = palabras[0];

				try {
					System.out.println("Opcion " + opcion + " seleccionada.");
                                        String formaTeclado = "noSeleccionado";
                                        int numeroFilas = 0;
                                        int numeroColumnas = 0;
                                        int numeroPosiciones = 0;
                                        boolean teclas4Lados = false;
                                        
					switch (opcion) {
                                                
                                                
						case "1": //formaTeclado, numeroFilas, numeroColumnas, numeroPosiciones, teclas4Lados
                                                        if (!out && !out1) {
                                                            System.out.println("Escoger forma del teclado: ");
                                                            System.out.println("\t 1) rectangular");
                                                            System.out.println("\t 2) hexagonal");
                                                            System.out.println("\t 0) SALIR");
                                                            
                                                            linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];

                                                            try {
                                                                switch(palabras[0]) {
                                                                        case "1":   //rectangular
                                                                                formaTeclado = "rectangular";
                                                                                out1 = true;
                                                                                break;
                                                                        case "2":   //hexagonal
                                                                                formaTeclado = "hexagonal";
                                                                                out1 = true;
                                                                                break;
                                                                        case "0":   //SALIR
                                                                                System.out.print("SALIENDO...");
                                                                                out = out1 = true;
                                                                                break;
                                                                        default: 
                                                                                System.out.println("La opcion elegida no existe.");
                                                                                break;
                                                                }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                            //linea = buffer.readLine();
                                                            //palabras = linea.split(" ");
                                                            //opcion = palabras[0];
                                                        }
                                                        if (!out) System.out.println("formaTeclado = " + formaTeclado);


                                                        out1 = false;
                                                        int n = 0;
                                                        if (!out && !out1) {
                                                            System.out.println("Introducir numero de filas del teclado: ");
                                                            System.out.println("\t 0) SALIR");
                                                            
                                                            linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];

                                                            try {
                                                                    switch(palabras[0]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    n = Integer.parseInt(palabras[0]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                            //linea = buffer.readLine();
                                                            //palabras = linea.split(" ");
                                                            //opcion = palabras[0];
                                                        }
                                                        if (!out) System.out.println("formaTeclado = " + formaTeclado + ", numeroFilas = " + n);


                                                        out1 = false;
                                                        int m = 0;
                                                        if (!out && !out1) {
                                                            System.out.println("Introducir numero de columnas del teclado: ");
                                                            System.out.println("\t 0) SALIR");
                                                            
                                                            linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];

                                                            try {
                                                                    switch(palabras[0]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    m = Integer.parseInt(palabras[0]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                            //linea = buffer.readLine();
                                                            //palabras = linea.split(" ");
                                                            //opcion = palabras[0];
                                                        }
                                                        if (!out) System.out.println("formaTeclado = " + formaTeclado + ", numeroFilas = " + n + ", numeroColumnas = " + m);


                                                        out1 = false;
                                                        int p = 0;
                                                        if (!out && !out1) {
                                                            System.out.println("Introducir numero de posiciones del teclado: ");
                                                            System.out.println("\t 0) SALIR");
                                                            
                                                            linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];

                                                            try {
                                                                    switch(palabras[0]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    p = Integer.parseInt(palabras[0]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                            //linea = buffer.readLine();
                                                            //palabras = linea.split(" ");
                                                            //opcion = palabras[0];
                                                        }
                                                        if (!out) System.out.println("formaTeclado = " + formaTeclado + ", numeroFilas = " + n + ", numeroColumnas = " + m + ", numeroPosiciones = " + p);


                                                        out1 = false;
                                                        boolean b = false;
                                                        if (!out && !out1) {
                                                            System.out.println("Escoger numero de lados del teclado: ");
                                                            System.out.println("\t 4) 4 lados");
                                                            System.out.println("\t 6) 6 lados");
                                                            System.out.println("\t 0) SALIR");
                                                            
                                                            linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];

                                                            try {
                                                                    switch(palabras[0]) {
                                                                            case "4":   //4 lados
                                                                                    b = true;
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "6":   //6 lados
                                                                                    b = false;
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    System.out.println("La opcion elegida no existe.");
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                            /*linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];*/
                                                        }
                                                        if (!out) {
                                                            System.out.println("formaTeclado = " + formaTeclado + ", numeroFilas = " + n + ", numeroColumnas = " + m + ", numeroPosiciones = " + p + ", teclasDe4Lados? = " + b);
                                                            tec = cTec.crearTeclado(formaTeclado, n, m, p, b);
                                                        }
                                                        else System.out.println("Ya he salido");
							break;
						case "2":   //cambiarForma(teclado, tipoTeclado)
                                                        out1 = false;
                                                        if (!out1) {
                                                            System.out.println("Escoger forma del teclado: ");
                                                            System.out.println("\t 1) rectangular");
                                                            System.out.println("\t 2) hexagonal");
                                                            System.out.println("\t 0) SALIR");
                                                            
                                                            linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];

                                                            try {
                                                                    switch(palabras[0]) {
                                                                            case "1":   //rectangular
                                                                                    formaTeclado = "rectangular";
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "2":   //hexagonal
                                                                                    formaTeclado = "hexagonal";
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default: 
                                                                                    System.out.println("La opcion elegida no existe.");
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                            /*linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];*/
                                                        }
                                                        if (!out) {
                                                            System.out.println("formaTeclado = " + formaTeclado);
                                                            cTec.cambiarForma(tec, formaTeclado);
                                                        }
                                                        break;
						case "3":   //consultarForma(teclado)
							System.out.println("Forma = " + tec.getForma());
							break;
						case "4":   //cambiarNumeroFilas(teclado, tamano)
                                                        out1 = false;
                                                        int nF = 0;
                                                        if (!out1) {
                                                            System.out.println("Introducir numero de filas del teclado: ");
                                                            System.out.println("\t 0) SALIR");
                                                            
                                                            linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];

                                                            try {
                                                                    switch(palabras[0]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    nF = Integer.parseInt(palabras[0]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                            /*linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];*/
                                                        }
                                                        if (!out) {
                                                            System.out.println("numeroFilas = " + nF);
                                                            cTec.cambiarNumeroFilas(tec, nF);
                                                        }
                                                        break;
						case "5":   //consultarNumeroFilas(teclado)
							System.out.println("Numero Filas = " + tec.getNumeroFilas());
							break;
						case "6":   //cambiarNumeroColumnas(teclado, tamano)
                                                        out1 = false;
                                                        int mF = 0;
                                                        if (!out1) {
                                                            System.out.println("Introducir numero de columnas del teclado: ");
                                                            System.out.println("\t 0) SALIR");
                                                            
                                                            linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];

                                                            try {
                                                                    switch(palabras[0]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    mF = Integer.parseInt(palabras[0]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                            /*linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];*/
                                                        }
                                                        if (!out) {
                                                            System.out.println("numeroColumnas = " + mF);
                                                            cTec.cambiarNumeroColumnas(tec, mF);
                                                        }
                                                        break;
						case "7":   //consultarNumeroColumnas(teclado)
							System.out.println("Numero Columnas = " + tec.getNumeroColumnas());
							break;
						case "8":   //cambiarTeclasDe4Lados(teclado, b)
                                                        out1 = false;
                                                        boolean bl = false;
                                                        if (!out1) {
                                                            System.out.println("Escoger numero de lados del teclado: ");
                                                            System.out.println("\t 4) 4 lados");
                                                            System.out.println("\t 6) 6 lados");
                                                            System.out.println("\t 0) SALIR");
                                                            
                                                            linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];

                                                            try {
                                                                    switch(palabras[0]) {
                                                                            case "4":   //4 lados
                                                                                    bl = true;
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "6":   //6 lados
                                                                                    bl = false;
                                                                                    out1 = true;
                                                                                    break;
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    System.out.println("La opcion elegida no existe.");
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                            /*linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];*/
                                                        }
                                                        if (!out) {
                                                            System.out.println("teclasDe4Lados? = " + bl);
                                                            cTec.cambiarTeclasDe4Lados(tec, bl);
                                                        }
                                                        break;
                                                        
							//cTec.cambiarTeclasDe4Lados(tec, (palabras[1].equals("1")));
							//break;
						case "9":   //consultarTeclasDe4Lados(teclado)
							System.out.println("Tiene teclas de 4 lados? = " + tec.getTeclasDe4Lados());
							break;
						case "10":   //cambiarNumeroPosiciones(teclado, numeroPosiciones)
                                                        out1 = false;
                                                        p = 0;
                                                        if (!out1) {
                                                            System.out.println("Introducir numero de posiciones del teclado: ");
                                                            System.out.println("\t 0) SALIR");
                                                            
                                                            linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];

                                                            try {
                                                                    switch(palabras[0]) {
                                                                            case "0":   //SALIR
                                                                                    System.out.print("SALIENDO...");
                                                                                    out = out1 = true;
                                                                                    break;
                                                                            default:
                                                                                    p = Integer.parseInt(palabras[0]);
                                                                                    out1 = true;
                                                                                    break;
                                                                    }
                                                            }
                                                            catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                            /*linea = buffer.readLine();
                                                            palabras = linea.split(" ");
                                                            opcion = palabras[0];*/
                                                        }
                                                        if (!out) {
                                                            System.out.println("numeroPosiciones = " + p);
                                                            cTec.cambiarNumeroPosiciones(tec, p);
                                                        }
                                                        break;

							//cTec.cambiarNumeroPosiciones(tec, Integer.parseInt(palabras[1]));
							//break;
						case "11":   //consultarNumeroPosiciones(teclado)
							System.out.println("Numero de Posiciones = " + tec.getNumeroPosiciones());
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
