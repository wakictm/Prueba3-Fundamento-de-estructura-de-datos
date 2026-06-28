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
    
    
   public Cola Bubblesort(Cola cola){
        
       if(cola.tamaño() == 0){
       
           return null;
       
       }
       
          
       Reclamo temp;
       for(int i = 0; i<cola.tamaño()-1;i++){
            
            for(int j = 0; j< cola.tamaño()-i-1;j++){
            if(cola.getReclamos()[j].getNivelPrioridad() < cola.getReclamos()[j+1].getNivelPrioridad()){
            
                temp = cola.getReclamos()[j];
                cola.getReclamos()[j] = cola.getReclamos()[j+1];
                cola.getReclamos()[1+j] = temp;
            }
            }
            
        }
        
        return cola;
    
    
    }
   
   public Cola QuickSort(Cola cola) {
    if (cola == null || cola.tamaño() == 0) {
        return null;
    }


    Reclamo[] arr = cola.getReclamos();
    
  
    quickSort(arr, 0, cola.tamaño() - 1);
    
    return cola;
}


private void quickSort(Reclamo arr[], int begin, int end) {
    if (begin < end) {
        int partitionIndex = partition(arr, begin, end);

        
        quickSort(arr, begin, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, end);
    }
}


private int partition(Reclamo arr[], int begin, int end) {
   
    int pivotPriority = arr[end].getNivelPrioridad();
    int i = (begin - 1);

    for (int j = begin; j < end; j++) {
     
        if (arr[j].getNivelPrioridad() >= pivotPriority) {
            i++;

          
            Reclamo swapTemp = arr[i];
            arr[i] = arr[j];
            arr[j] = swapTemp;
        }
    }

   
    Reclamo swapTemp = arr[i + 1];
    arr[i + 1] = arr[end];
    arr[end] = swapTemp;

    return i + 1;
}
   
    
   
}
