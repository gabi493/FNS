


import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public class gilmore {
    
    private int[][] estadisticas;
    private int[][] distancia;
    
    public gilmore(){};
    public gilmore(int [][] estadistica, int [][] distancia){
        this.estadisticas = estadistica;
        this.distancia = distancia;
        System.out.println("Inicializo el gilmore");

    }
    
    public double g(int[] asignado) {
        double cost = 0;
        for(int i=0; i < asignado.length; ++i) {
            for(int j=0; j < asignado.length; ++j) {
                if(asignado[i] != -1 && asignado[j]!= -1) cost += estadisticas[i][j]*distancia[asignado[j]][asignado[i]];
            }
            
        }
        return cost;
    }
    
    public double[][] termino2(Vector<Integer> pendiente, int[] asignado, int pos, double costeFijo) {
        System.out.println("Entra en el termino 2");
        double [][] matriz2 = new double [pendiente.size()][pendiente.size()];
        System.out.println("Numero de pendientes " + pendiente.size());
        System.out.println("Numero de asignado " + asignado.length);
        int l = 0;
        for(int i =0; i < pendiente.size();++i) {
            for(int j = 0; j < asignado.length; ++j) {
                if(asignado[j] == -1 ) {
                    asignado[j] = pendiente.get(i);
                    double cost = g(asignado);
                    matriz2[i][l] = cost - costeFijo;
                    ++l;
                    asignado[j] = -1;
                }
                
            }
            l = 0;
            
            
            
           /* for(int j = 0; j < pendiente.size();++j){
                   for(int k = 0; k <= pos; ++k) {
                       matriz2[i][j] += estadisticas[k][pendiente.get(i)] * distancia[asignado[k]][j+pos+1];
                   } 
            }*/
        }
        System.out.println("Matriz creada del termino 2");
        return matriz2;
    }
    
    public double[][] termino3 (Vector<Integer> pendiente, int[] asignado, int pos) {
        System.out.println("Entra en el termino 3");
        double [][] matriz3 = new double[pendiente.size()][pendiente.size()];
        int [][] flujo = new int [pendiente.size()][pendiente.size()];
        int [][] distancias = new int [pendiente.size()] [pendiente.size()];
        for(int i=0; i < pendiente.size();++i) {
            for(int j = 0; j < pendiente.size();++j) {
<<<<<<< HEAD
                flujo[i][j] = estadisticas[i][j];
                distancias[i][j] = distancia [i+pos+1][j+pos+1];
=======
                flujo[i][j] = estadisticas[pendiente.get(i)][pendiente.get(j)];
                distancias[i][j] = distancia [asignado[i+pos+1]][asignado[j+pos+1]];
>>>>>>> 348fa33f76f4529a5e33ca76e02182807ac4651e
            }
        }

        Comparator<Integer> comparator = Collections.reverseOrder();
        for(int k=0; k < pendiente.size();++k) {
            Vector<Integer> flux = new Vector<Integer> ();
            Vector<Integer> distancia = new Vector<Integer> ();
            for(int i=0; i < pendiente.size();++i) {
                for( int j = 0; j < pendiente.size();++j) {
                    flux.add(flujo[i][j]);
                    distancia.add(distancias[j][i]);
                }
                Collections.sort(flux);
                Collections.sort(distancia,comparator);
                for(int j=0; j < pendiente.size();++j) {
                     matriz3[k][i] += flux.get(j) * distancia.get(j);
                }
               
            }
            
           
        }
        System.out.println("Matriz creada termino 3");
        return matriz3;
        
    }
    
    
    
    
    public double h(Vector<Integer> pendiente, int[] asignado, int pos,double costeFijo) {
        double [][] matriz2 = termino2 (pendiente,asignado,pos,costeFijo);
        double [][] matriz3 = termino3 (pendiente,asignado,pos);
        System.out.println("Mida de la matriz "+ matriz2.length);
        double [][] matriz = new double[matriz2[0].length][matriz2[0].length];
        for(int i = 0; i < matriz2[0].length; ++i) {
            for(int j = 0; j < matriz2[0].length;++j) {
                matriz[i][j] = matriz2[i][j]+ matriz3[i][j];
            }
        }
        System.out.println("Calculo del hungariano ");
        hungar hungaro = new hungar();
        double cost = hungaro.eje(matriz);
        System.out.println("Salgo del calculo"+cost);

        
        
        return cost;
    }
    
    
    public double calcularCoste(Vector<Integer> pendiente, int[] asignado, int pos) {
        double costeReal = g(asignado); 
        double costeAprox=0;
        if(!pendiente.isEmpty()) costeAprox = h(pendiente,asignado,pos,costeReal);   
        System.out.println("Calculo del node "+ costeReal+" "+ costeAprox);
        return costeReal+costeAprox;
    }
}
