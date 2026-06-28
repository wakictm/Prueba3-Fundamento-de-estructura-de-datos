
//
// Me base en una diapositiva del profe, si hay que cambiar algo me dicen
//
package com.mycompany.grupo_2;

import java.util.LinkedList;

public class PilaHistorial {
    private LinkedList<Reclamo> reclamos;
    
    public PilaHistorial(){
        reclamos = new LinkedList<>();
    }
    
    public void apilar(Reclamo cambio){
        reclamos.addFirst(cambio);        
    }
    
    public Reclamo desapilar(){
        if (Vacia()){
            throw new IllegalStateException("Historial vacio");        
        }
        return reclamos.removeFirst();
    }

public Reclamo cima(){
    if(Vacia()){
        throw new IllegalStateException("Historial vacio");        
    }
    return reclamos.getFirst();   
}

public boolean Vacia(){
    return reclamos.isEmpty();
}

public void mostrarPila() {
        // TODO: mostrar todas las reservas desde el tope hacia el fondo
        if(reclamos.isEmpty()){
        
            System.out.println("No hay reclamos modificados");
            return;
        
        }
        
        for( int i = reclamos.size()-1; i >= 0; i--){
        
            System.out.println(reclamos.get(i));
        
        }
        
    }
}
