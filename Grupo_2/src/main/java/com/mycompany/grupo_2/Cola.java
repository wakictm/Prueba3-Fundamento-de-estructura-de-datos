/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_2;


//Cola dinamica vamoooooooooooooooooo

public class Cola {
    
    //Atributos de mi cola
    private Reclamo[] reclamos;
    private int fin, inicio;
    
    //Para obtener la lista de reclamos cuando 
    //necesitemos hacer busqueda secuencial
    public Reclamo[] getReclamos() {
        return reclamos;
    }
    

 
    //Constructor
    public Cola(){
    
        this.reclamos = new Reclamo[0];
        this.fin = -1;
        this.inicio = 0;
    }
    
    //Para clonar la cola al utilizar un algoritmo de 
    //ordenamiento sin afectar a la original
    public Cola(Cola cola){
    
        if (cola.getReclamos() != null) {
        this.reclamos = cola.getReclamos().clone(); 
    }
    

        this.fin = cola.getFin();
        this.inicio = cola.getInicio();
    
    }

    public int getFin() {
        return fin;
    }

    public int getInicio() {
        return inicio;
    }

    
    //Agregar en la cola de forma dinamica, o sea jamas llegaremos a un tope :)
    public void agregar(Reclamo reclamo){
    
       
            Reclamo[] temp = reclamos;
            
            reclamos = new Reclamo[reclamos.length+1];
            
            for( int i = 0; i < temp.length; i++){
            
                reclamos[i] = temp[i];
            
            }
            
        
        
        reclamos[++fin] = reclamo;
        
    }
    //no se si lo utilizamos pero eliminara el ultimo reclamo de la cola
    public Reclamo eliminar(){
    
        if(fin == -1){
            
            System.out.println("No hay elementos en la cola");
            return null;
    }
        
        return reclamos[++inicio];

}
    //Mostrara todos los reclamos de la cola utilizando un for each
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
    
    //Devolver el tamaño de la cola utilizando su atrivuto fin
    public int tamaño(){
    
        return (fin+1);
    
    }
    
    //Eliminar un elemento en especifico de la cola utilizando el indice
    
    public void eliminar(int indice){
    
        if(tamaño() != 0){
            
            /*Empezaremos desde el indice donde se guardara el siguiente
            en su posicion, o sea que correremos la cola un espacio a la
            izquierda sin tomar en cuenta el reclamo que deseamos eliminar*/
            for(int i = indice; i < tamaño()-1; i++){
            
                reclamos[i] = reclamos[i+1];
            
            }
            reclamos[fin] = null;
            fin--;
            System.out.println("Se elimino el reclamo correctamente");
            return;
            
        }
        
        else{
        
            System.out.println("La cola de reclamos esta vacia");
        
        }
        
    
    
    }


}


    
    
    
