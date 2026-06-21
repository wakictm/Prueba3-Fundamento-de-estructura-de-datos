
//
// Me base en una diapositiva del profe, si hay que cambiar algo me dicen
//
package com.mycompany.grupo_2;

import java.util.LinkedList;

public class PilaHistorial {
    private LinkedList<String> elementos;
    
    public PilaHistorial(){
        elementos = new LinkedList<>();
    }
    
    public void apilar(String cambio){
        elementos.addFirst(cambio);        
    }
    
    public String desapilar(){
        if (Vacia()){
            throw new IllegalStateException("Historial vacio");        
        }
        return elementos.removeFirst();
    }

public String cima(){
    if(Vacia()){
        throw new IllegalStateException("Historial vacio");        
    }
    return elementos.getFirst();   
}

public boolean Vacia(){
    return elementos.isEmpty();
}
}
