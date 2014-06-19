/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfazteclado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author josep
 */
public class controladorAlfabeto {
    private alfabeto alfabetoControlador;
    private File archivo;
    
    /**
     * Creadoras.
     */
    
    /**
     * Creadora por defecto. Crea un alfabeto cuando el usuario quiere añadir un alfabeto.
     */
    public controladorAlfabeto() {
        alfabetoControlador = new alfabeto();
        archivo = null;
    }
    
    /**
     * Creadora. Crea un alfabeto con el nombre y el numero de caracteres pasados por parametro.
     * @param idioma
     * @param n 
     * @throws IllegalArgumentException.
     */
    public controladorAlfabeto (String idioma) {
        alfabetoControlador = new alfabeto(idioma);
    }
    
    /**
     * Creadora copia. Crea una copia del alfabeto pasado por parametro explícito.
     * @param original 
     */
    public controladorAlfabeto (alfabeto original) {
        alfabetoControlador = new alfabeto(original);
    }
    
    /**
     * Modificadoras.
     */
    
    /**
     * Añadir simbolo. Añadir un nuevo simbolo al alfabeto.
     * @param newsimbolo
     */
    public void addSimbolo (simbolo newsimbolo) {
        alfabetoControlador.addSimbolo(newsimbolo);
    }
    
    public void leerAlfabeto(String alf) {
        for (int i = 0; i < alf.length(); i++) {
            simbolo add = new simbolo(alf.charAt(i));
            alfabetoControlador.addSimbolo(add);
        }
    }
    
    public alfabeto cargarAlfabeto(String nombre) throws FileNotFoundException, IOException {
        alfabeto ret = new alfabeto();
        File archivo = new File("");
        String ruta = archivo.getAbsolutePath() + "/Alfabetos/" + nombre;
        
        archivo = new File(ruta);
        BufferedReader bf = new BufferedReader (new FileReader(archivo));
        String titulo = bf.readLine();
        ret.setNombreAlfabeto(titulo);
        bf.readLine();
        String cuerpo = bf.readLine();
        for (int i = 0; i < cuerpo.length(); i++) {
            simbolo a = new simbolo(cuerpo.charAt(i));
            ret.addSimbolo(a);
        }        
        return ret;
    }
    
    
    /**
     * Escritoras.
     */
    
    /**
     * Escribir Alfabeto. Escribe todos los caracteres del alfabeto por pantalla.
     */
    public void escribirAlfabeto() {
        alfabetoControlador.escribirAlfabeto();
    }
    
    public void crearAlfabeto(String nombreAlf, String ruta, String body) throws FileNotFoundException, IOException {
        archivo = new File(ruta);
        System.out.println(ruta);
        if (!archivo.exists()) {
            archivo.createNewFile();
            System.out.println("archivo creado!");
            BufferedWriter bw = new BufferedWriter (new FileWriter(ruta));
            bw.append(nombreAlf);
            bw.flush();
            bw.newLine();
            bw.newLine();
            bw.append(body);
            bw.flush();
        }
    }
    public boolean existeAlfabeto (String nombre) {
        File archivo = new File("");
        String ruta = archivo.getAbsolutePath() + "/Alfabetos/" + nombre + ".txt";
        System.out.println(ruta);
        archivo = new File(ruta);
        if(archivo.exists()) return true;
        else return false;
    }
    
    
    
}
