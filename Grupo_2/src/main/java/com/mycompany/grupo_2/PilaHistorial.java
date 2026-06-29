
package com.mycompany.grupo_2;

import java.util.LinkedList;

public class PilaHistorial {
    
    //Atributos de la pila
    private LinkedList<Reclamo> reclamos;
    
    //constructor de la pila
    public PilaHistorial(){
        reclamos = new LinkedList<>();
    }
    
    //añadir un elemento en la pila en la primera posicion
    public void apilar(Reclamo cambio){
        reclamos.addFirst(cambio);        
    }
    
public boolean Vacia(){
    return reclamos.isEmpty();
}

//mostrar todo el historial de modificaciones
public void mostrarPila() {
        // TODO: mostrar todas las reservas desde el tope hacia el fondo
        if(reclamos.isEmpty()){
        
            System.out.println("No hay reclamos modificados");
            return;
        
        }
        int cont = 1;
        for( int i = reclamos.size()-1; i >= 0; i--){
        
            System.out.println((cont)+"." + reclamos.get(i));
            cont++;
        }
        
    }
}
