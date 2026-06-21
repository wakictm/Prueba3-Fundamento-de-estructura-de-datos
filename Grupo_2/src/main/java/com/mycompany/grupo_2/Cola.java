/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_2;


//Cola dinamica vamoooooooooooooooooo

public class Cola {
    

    private Reclamo[] reclamos;
    private int fin, inicio;
    

    public Reclamo[] getReclamos() {
        return reclamos;
    }
    

 
    
    public Cola(){
    
        reclamos = new Reclamo[0];
        fin = -1;
        inicio = 0;
    }
    
    public void agregar(Reclamo reclamo){
    
       
            Reclamo[] temp = reclamos;
            
            reclamos = new Reclamo[reclamos.length+1];
            
            for( int i = 0; i < temp.length; i++){
            
                reclamos[i] = temp[i];
            
            }
            
        
        
        reclamos[++fin] = reclamo;
        
    }
    
    public Reclamo eliminar(){
    
        if(fin == -1){
            
            System.out.println("No hay elementos en la cola");
            return null;
    }
        
        return reclamos[++inicio];

}
    
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
    
    public int tamaño(){
    
        return (fin+1);
    
    }
    
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


    
    
    
