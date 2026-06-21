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
    
        for( int i = inicio; i <= fin; i++ ){
        
            System.out.println((i+1)+". "+reclamos[i]);
        }
        System.out.println("");
    }
    
    public int tamaño(){
    
        return (fin+1);
    
    }


}


    
    
    
