
//
// Me base en una diapositiva del profe, si hay que cambiar algo me dicen
//
package com.mycompany.grupo_2;

import java.util.LinkedList;
//Pila con LinkedList
public class PilaHistorial {
    private LinkedList<String> elementos;
    //Contructor de la pila
    public PilaHistorial(){
        elementos = new LinkedList<>();
    }
    //Agrega un cambio a la pila
    public void apilar(String cambio){
        elementos.addFirst(cambio);        
    }
    //Elimina el ultimo cambio de la pila
    public String desapilar(){
        if (Vacia()){
            throw new IllegalStateException("Historial vacio");        
        }
        return elementos.removeFirst();
    }
//Obtiene la cima de la pila
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
