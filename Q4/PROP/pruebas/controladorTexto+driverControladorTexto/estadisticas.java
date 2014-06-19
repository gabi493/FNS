





import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public class estadisticas extends afinidad {
    
    int mida;
    
    /**
     * Constructora por defecto
     */
    public estadisticas() {
        super(0);
        this.mida = 0;
    }
    
    
    /**
     * Constructora por defecto 
     * @param mida Mida de la matriz de estadisticas
     */
    public estadisticas(int mida) {
        super(mida);
        this.mida = mida;
    }
  
    /**
     * Inserta un valor de similitud en la posicion [i][j] de la matriz 
     * @param i posicion en la matriz 
     * @param j posicion en la matriz 
     * @param similitud valor que tomara la posicion [i][j] de la matriz 
     */
    public void insertarEstadistica (int i,int j,double similitud) {
      System.out.println("Se a insertado en la posicion "+ i + "   " +j );
      insertarAfinidad(i,j,similitud);
      
    }

    /**
     * Consulta las estadisticas de una posicion [i][j] de la matriz 
     * @param i posicion de la matriz 
     * @param j posicion de la matriz 
     * @return devuelve el valor que toma la posicion [i][j]
     */
    public double consultarEstadistica (int i,int j) throws IOException{
      return consultarAfinidad(i,j);
    
    }

    /**
     * Escribe por pantalla la matriz 
     * @throws IOException Cuando hay error en la salida
     */
    public void leerMatriz() throws IOException {
        for(int i=0; i < mida; ++i) {
            for (int j=0; j < mida; ++j) {
                System.out.print (consultarEstadistica(i,j) + " ");
            }
            System.out.println("");
        }
    }
    
}
