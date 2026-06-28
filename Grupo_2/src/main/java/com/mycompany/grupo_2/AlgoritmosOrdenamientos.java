/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_2;

/**
 *
 * @author wakictm
 */
public class AlgoritmosOrdenamientos {
    
    
   public static int[] Bubblesort(int[] arreglo){
    
        int temp;
        for(int i = 0; i<arreglo.length-1;i++){
            
            for(int j = 0; j< arreglo.length-i-1;j++){
            if(arreglo[j] > arreglo[j+1]){
            
                temp = arreglo[j];
                arreglo[j] = arreglo[j+1];
                arreglo[1+j] = temp;
            }
            }
            
        }
        
        return arreglo;
    
    
    }
    
   
}
