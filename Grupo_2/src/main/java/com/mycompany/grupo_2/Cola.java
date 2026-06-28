/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_2;


//Cola dinamica 

public class Cola {
    
    //Arreglo que almacena los reclamos
    private Reclamo[] reclamos;
    //fin ultima posicion y inicio primera posicion 
    private int fin, inicio;
    
    //Retornar el arreglo
    public Reclamo[] getReclamos() {
        return reclamos;
    }
    

 
    //Contructor
    public Cola(){
        //Arreglo vacio
        reclamos = new Reclamo[0];
        //No existen elementos 
        fin = -1;
        //Inicio desde el 0
        inicio = 0;
    }
    //Agregar al final de la cola
    public void agregar(Reclamo reclamo){
    
        //Guardar arreglo
            Reclamo[] temp = reclamos;
            //Nuevo arreglo
            reclamos = new Reclamo[reclamos.length+1];
            //Copiar elementos anteriores 
            for( int i = 0; i < temp.length; i++){
            
                reclamos[i] = temp[i];
            
            }
            
        
        
        reclamos[++fin] = reclamo;
        
    }
    //Elimar desde la primera posicion 
    public Reclamo eliminar(){
        //Verificar que este vacio el arreglo
        if(fin == -1){
            
            System.out.println("No hay elementos en la cola");
            return null;
    }
        //Retornar desde el inicio 
        return reclamos[++inicio];

}
    //Mostrar arreglo con los elementos que contiene 
    public void mostrarReclamos(){
     if(tamaño()!=0){
        for( int i = inicio; i <= fin; i++ ){
        
            System.out.println((i+1)+". "+reclamos[i]);
        }
        System.out.println("");
    }
     else{
     
         System.out.println("No hay registros para mostrar");
     
     }
    
    
    }
    //Retornar la cantidad de elementos almacenados
    public int tamaño(){
    
        return (fin+1);
    
    }
    //Eliminar segun indices
    public void eliminar(int indice){
    
        if(tamaño() != 0){
        
            for(int i = indice; i < tamaño()-1; i++){
            
                reclamos[i] = reclamos[i+1];
            
            }
            fin--;
            System.out.println("Se elimino el reclamo correctamente");
            return;
            
        }
        
        else{
        
            System.out.println("La cola de registro esta vacia");
        
        }
        
    
    
    }


}


    
    
    
