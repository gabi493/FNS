







/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;


/**
 *
 * @author alex
 */
public class driverBranchBound {
    
    public static void main (String[] args) {
        String nombreclase = "BrancBound";
        System.out.println("Driver" + nombreclase + ".");
        /*int estadisticas[][] = { {0,30,20,10},
{30,0,40,20},
{20,40,0,30},
{10,20,30,0}};
            
            
            
            /*{0,90,10,23,43,0,0,0,0,0,0,0},
                                 {90,0,0,0,0,88,0,0,0,0,0,0},
                                 {10,0,0,0,0,0,26,16,0,0,0,0},
                                 {23,0,0,0,0,0,0,0,0,0,0,0},
                                 {43,0,0,0,0,0,0,0,0,0,0,0},
                                 {0,88,0,0,0,0,0,0,1,0,0,0},
                                 {0,0,26,0,0,0,0,0,0,0,0,0},
                                 {0,0,16,0,0,0,0,0,0,96,0,0},
                                 {0,0,0,0,0,1,0,0,0,0,29,0},
                                 {0,0,0,0,0,0,0,96,0,0,0,37},
                                 {0,0,0,0,0,0,0,0,29,0,0,0},
                                 {0,0,0,0,0,0,0,0,0,37,0,0} };*/
        /*int distancia[][] = { {0,1,2,3},
{1,0,1,2},
{2,1,0,1},
{3,2,1,0}
        /*{0,36,54,26,59,72,9,34,79,17,46,95},
                              {36,0,73,35,90,58,30,78,35,44,79,36},
                              {54,73,0,21,10,97,58,66,69,61,54,63},
                              {26,35,21,0,93,12,46,40,37,48,68,85},
                              {59,90,10,93,0,64,5,29,76,16,5,76},
                              {72,58,97,12,64,0,96,55,38,54,0,34},
                              {9,30,58,46,5,96,0,83,35,11,56,37},
                              {34,78,66,40,29,55,83,0,44,12,15,80},
                              {79,35,69,37,76,38,35,44,0,64,39,33},
                              {17,44,61,48,16,54,11,12,64,0,70,86},
                              {46,79,54,68,5,0,56,15,39,70,0,18},
                              {95,36,63,85,76,34,37,80,33,86,18,0}*/
        
        ctrlPersistencia cp = new ctrlPersistencia();
        cp.leerJuegoDePrueba("/dades/josep.mercadal/linux/UPC/PROP/PropGithub/pruebas/PruebaQAP/src/prueba/1");
        BranchBound bb = new BranchBound(cp.getAfin(), cp.getDist());
        for (int i = 0; i < bb.mejorSolucion.teclasAssignadas.length; i++) {
            System.out.print(bb.mejorSolucion.teclasAssignadas[i] + " ");
        }
         System.out.println("");
         System.out.println("cost: "+bb.mejorCost);
        
    }
}
/* 




*/