package interfazteclado;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author alex
 */
public class controladorTexto {
    File archivo;
    String ruta;
    FileReader fr;
    
    
        
  
    /**
     * Constructora por defecto
     */
    public controladorTexto (){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        ruta = chooser.getCurrentDirectory().getAbsolutePath();
    }
    
    /**
     * Metodo con el que puedes abrir,editar,seleccionar,leer o crar un texto
     * @param accion Opcion que quiere hacer 
     * @param nombre En caso de Opcion == crear, nombre que le quieres dar
     * @throws IOException Cuando hay un problema con la salida o la entrada
     */
    /*public void realizarAccion(String accion,String nombre) throws IOException {
        JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Textos", "txt");
            chooser.setFileFilter(filter);
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Abre,edita,lee");
            //Elegiremos archivos del directorio
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            chooser.setAcceptAllFileFilterUsed(true);
            //Si seleccionamos algún archivo retornaremos su directorio
            if(accion.equalsIgnoreCase("abrir") || accion.equalsIgnoreCase("editar") || accion.equalsIgnoreCase("seleccionar")) {

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Directorio: " + chooser.getCurrentDirectory().getAbsolutePath());
                    File textoSeleccionado = chooser.getSelectedFile();
                    System.out.println(textoSeleccionado);
                    Desktop desktop = null;
                    Desktop.Action action = null;
                    if( Desktop.isDesktopSupported() == true ){
                            desktop = Desktop.getDesktop();
                            if(accion.equalsIgnoreCase( "abrir" ) ){
                                action = Desktop.Action.OPEN;
                            }
                            if(accion.equalsIgnoreCase( "seleccionar" ) ){
                                archivo = textoSeleccionado;
                            }
                            else if(accion.equalsIgnoreCase( "editar" ) ){
                            action = Desktop.Action.EDIT;
                            }
                            
                    }
                    switch(accion){
                        case "abrir" :
                        System.out.println( "DENTRO DE OPCION: OPEN" );
                        desktop.open(textoSeleccionado);
                        break;
                        case "editar" :
                        System.out.println( "DENTRO DE OPCION: EDIT" );
                        desktop.edit(textoSeleccionado);
                        break;
                        
                        

                    }
                }
                else System.out.println("No seleccion ");
            
            }
            else if(accion.equalsIgnoreCase("crear")) {
                String rutaArchivo = ruta + nombre + ".txt";
                System.out.println("La ruta del archivo es "+ rutaArchivo);
                File texto = new File(rutaArchivo);
                if(!texto.exists()) {
                    if(texto.createNewFile()) System.out.println("Se a creado un texto");
                    else System.out.println("No se a podido crear el texto");
                }
                
            }
            else System.out.println("La accion no es possible ");          
            
            
    }
    
    /**
     * Leer cada par de letras de un texto i las inserta en estadisticas
     * @param e Estadistica que quiere modificar 
     * @param c Alfabeto para consultar si los pares de letras son del alfabeto
     * @throws IOException Cuando lee o escribe por pantalla
     */
    public void leerParDeLetras(estadisticas e,alfabeto c) throws IOException {
        if(archivo == null){
           throw new IllegalArgumentException("Error: No tienes ningun archivo abierto.");
        }
        fr = new FileReader(archivo);
        BufferedReader in = new BufferedReader(fr);
        String linia = in.readLine();
        System.out.println("la linia 1 "+ linia);
        linia = in.readLine();
        System.out.println("la linia 2 "+ linia);
       
        while((linia=in.readLine())!=null) {
            for(int i=0;i<linia.length()-1;i++) {
                simbolo a = new simbolo(linia.charAt(i));
                simbolo b = new simbolo(linia.charAt(i+1));
                
                System.out.println(a.getInfo());
                System.out.println(b.getInfo());
                
                if(!c.boolSimbolo(a)) {
                    System.out.println("xivato1" + a.getInfo());
                    if(c.boolSimbolo(b)) a = b;
                    else {
                        while(!c.boolSimbolo(a) && i < linia.length()-1) {
                            a = new simbolo(linia.charAt(i));
                            ++i;
                        }
                        
                    }
                }
                if(!c.boolSimbolo(b)) {
                    System.out.println("xivato2" + b.getInfo());
                    while(!c.boolSimbolo(b) && i < linia.length()) {
                        b = new simbolo(linia.charAt(i));
                        ++i;
                    }  
                }
                if(i<linia.length()) {
                    
                    System.out.println(a.getInfo());
                    System.out.println(b.getInfo());
                    int k = c.getPosicion(a);
                    int j = c.getPosicion(b);
                    e.insertarEstadistica(k,j,1);
                }
            }
                

        }
    }
    
    
    /**
     * Metodo para abrir un archivo
     * @param ruta String con la direccion del archivo que quiero abrir
     */
    public void abrirArchivo(String ruta) throws FileNotFoundException {
        archivo = new File(ruta); 
        if(!archivo.exists()) {
            throw new FileNotFoundException("Error: El archivo no existe");
        }
    }
    
    
    /**
     * Devuelve la ruta del controlador
     * @return el valor de ruta del controlador
     */
    public String getRuta(){
        return ruta;
    }

    /**
     * Devuelve el nombre del titulo del controlador
     * @return el nombre del titulo del archivo
     * @throws IOException si se abre mal el archivo
     */
    public String getTitulo() throws IOException {
        BufferedReader Flee = new BufferedReader(new FileReader(archivo));
        return Flee.readLine();
    }

    /**
     * Devulve el idioma del controlador
     * @return el idioma del controlador
     * @throws IOException si se abre mal el archivo
     */
    public String getIdioma() throws IOException {
        BufferedReader Flee = new BufferedReader(new FileReader(archivo));
        Flee.readLine();
        return Flee.readLine();
    }
    
    /**
     * Metodo que devuelve el texto
     * @return un string con el texto 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String getTexto() throws FileNotFoundException, IOException {
        if(archivo == null) throw new FileNotFoundException("Error: El archivo no existe");
        BufferedReader Flee = new BufferedReader(new FileReader(archivo));
        String linia = null;
        while((linia += Flee.readLine()) != null);
        return linia;
        
    }
    public void crearTexto(texto t,String cuerpoTexto) throws IOException {
            archivo = new File(t.ruta);
            if(!archivo.exists()) archivo.createNewFile();
            BufferedWriter bw = new BufferedWriter (new FileWriter(t.ruta));
            bw.append(t.getTitulo());
            bw.flush();
            bw.newLine();
            bw.newLine();
            bw.append(cuerpoTexto);
            bw.flush();
        
    }
    public boolean existeTexto(String ruta) {
        archivo = new File(ruta);
        System.out.println("Existe texto");
        if(archivo.exists()) return true;
        else return false;
    }
    public void fileCopy(String origen, String destino) {
	System.out.println("Desde: " + origen);
	System.out.println("Hacia: " + destino);

	try {
            
            File inFile = new File(origen);
            File outFile = new File(destino);

            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);
            File eliminar = new File("");
            String ruta = archivo.getAbsolutePath() +"/Textos/.txt";
            eliminar = new File(ruta);
            eliminar.delete();
            System.out.println(ruta);
           
            int c;
            while( (c = in.read() ) != -1)
            out.write(c);

            in.close();
            out.close();
	} 
        catch(IOException e) {
            System.err.println("Hubo un error de entrada/salida!!!");
	}
    }

    
    
}

