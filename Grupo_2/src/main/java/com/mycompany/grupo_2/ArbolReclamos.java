/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_2;

import java.util.ArrayList;

/**
 *
 * @author guill
 */
public class ArbolReclamos {
    private NodoReclamos raiz;

    private int altura(NodoReclamos nodo){
        return (nodo == null)? 0 : nodo.getAlturanodo();
    }

    private int balance(NodoReclamos nodo){
        return (nodo == null)? 0 : altura(nodo.getIzquierdo())-altura(nodo.getDerecho());
    }

    private void actualizarAltura(NodoReclamos nodo){
        if(nodo!=null){
            int altIzquierdo = (nodo.getIzquierdo() == null) ? 0 : nodo.getIzquierdo().getAlturanodo();
            int altDerecho = (nodo.getDerecho() == null) ? 0 : nodo.getDerecho().getAlturanodo();
            if(altIzquierdo > altDerecho){
                nodo.setAlturanodo(altIzquierdo +1);
            }else{
                nodo.setAlturanodo(altDerecho+1);
            }
        }
    }

    private NodoReclamos rotarDerecha(NodoReclamos y){
        NodoReclamos x = y.getIzquierdo();
        NodoReclamos T2 = x.getDerecho();
        
        x.setDerecho(y);
        y.setIzquierdo(T2);
        
        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    private NodoReclamos rotarIzquierdo(NodoReclamos x){
        NodoReclamos y = x.getDerecho();
        NodoReclamos T2 = y.getIzquierdo();
        
        y.setIzquierdo(x);
        x.setDerecho(T2);
        
        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    public void insertar(Reclamo nuevoReclamo){
        raiz = insertarRec(raiz , nuevoReclamo);
    }

private NodoReclamos insertarRec(NodoReclamos nodo, Reclamo nuevoReclamo){
    if(nodo == null){
        return new NodoReclamos(nuevoReclamo);
    }
    
    int prioridadNueva = nuevoReclamo.getNivelPrioridad();
    int prioridadNodo = nodo.getReclamo().getNivelPrioridad();
    
   
    if (prioridadNueva < prioridadNodo) {
       
        nodo.setDerecho(insertarRec(nodo.getDerecho(), nuevoReclamo));
    } 
    else if (prioridadNueva > prioridadNodo) {
       
        nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), nuevoReclamo));
    } 
    else {
        
        String fechaNueva = nuevoReclamo.getFechaLimite();
        String fechaNodo = nodo.getReclamo().getFechaLimite();
        
        
        if (compararFechas(fechaNueva, fechaNodo)) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), nuevoReclamo));
        } else {
           
            nodo.setDerecho(insertarRec(nodo.getDerecho(), nuevoReclamo));
        }
    }
    

    actualizarAltura(nodo);
    int balance = balance(nodo);
    
    if (balance > 1) {
        
        if (balance(nodo.getIzquierdo()) >= 0) {
            return rotarDerecha(nodo);
        } else {
            nodo.setIzquierdo(rotarIzquierdo(nodo.getIzquierdo()));
            return rotarDerecha(nodo);
        }
    }

    if (balance < -1) {
       
        if (balance(nodo.getDerecho()) <= 0) {
            return rotarIzquierdo(nodo);
        } else {
            nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
            return rotarIzquierdo(nodo);
        }
    }

    return nodo;
}
    
    private boolean compararFechas(String fecha1, String fecha2) {
        
        String aux1 = "";
        String aux2 = "";
        ArrayList<Integer> fechas = new ArrayList<Integer>();
        
        for(int i = 0; i < fecha1.length(); i++){
           
            if(fecha1.charAt(i)!= '/'){
                aux1 += fecha1.charAt(i);
                aux2 += fecha2.charAt(i);
            
                if(fecha1.length() == (i+1)){
                    
                    fechas.add(Integer.valueOf(aux1));
                    fechas.add(Integer.valueOf(aux2));
                    
                }
            }
            
            else{
                fechas.add(Integer.valueOf(aux1));
                fechas.add(Integer.valueOf(aux2));
                aux1 = "";
                aux2 = "";
                
            }
                    
        }
        
        for(int i = fechas.size()-1; i >= 0; i-=2){
        
            if(fechas.get(i) > fechas.get(i-1)){
            
                //System.out.println(fechas.get(i)+" - "+fechas.get(i-1));
                return true;
            }
            else  if(fechas.get(i) < fechas.get(i-1)){
            
                return false;
            }
            
        }
        return false;
             
    }
    
    //Recorrido recursivo hasta que no existan mas reclamos que recorrer
    public void mostrarInOrden() {
        if(raiz == null){
            System.out.println("No existen reclamos en el árbol.");
        } else {
            inOrden(raiz);
        }
    }     
        
    private void inOrden(NodoReclamos nodo) {
        //recorrido recursivo de manera IRD(izquierda, raiz, derecha)
        if(nodo != null){
            inOrden(nodo.getIzquierdo());
            System.out.println(nodo.getReclamo()); 
            inOrden(nodo.getDerecho());
        }
    }
    /*Ordenamos de tal manera que el mas de la izquierda es prioridad por
    /fecha limite y nivel prioridad por lo tanto obteniendo este nodo sabemos 
    que reclamo es el mas urgente con recursividad*/
    public Reclamo obtenerMasIzquierda() {
    if (raiz == null) {
        System.out.println("El árbol está vacío.");
        return null;
    }
    return buscarMasIzquierda(raiz);
}

/*Ira lo mas posible a la izquierda hasta que el siguiente 
    sea un null, o sea llegamos al reclamo mas urgente*/
private Reclamo buscarMasIzquierda(NodoReclamos nodo) {
    
    while (nodo.getIzquierdo() != null) {
        nodo = nodo.getIzquierdo();
    }
   
    return nodo.getReclamo();
}


public Reclamo buscar(String fecha, int rut) {
        /* TODO: Buscar reclamo con busqueda binaria 
        utilizando rut y la fecha limite para encontrarla
        ya que solo con el rut no basta, porque nuestro arbol
        ordenada por fecha mas cercana.*/
        
        //en caso se que no exista ningun reclamo
        if(raiz == null){
        
            System.out.println("No existe ningun reclamo");
        
        }     
        
        NodoReclamos actual = raiz; 
        
        while(actual != null){
            
            //Si la fecha limite y rut son iguales al nodo actual devolveremos la variable abstracta
            if(actual.getReclamo().getFechaLimite().equals(fecha) && rut == actual.getReclamo().getRut()){
                System.out.println("Se encontro el reclamo");
                System.out.println(actual.getReclamo());
                return actual.getReclamo();
                
            }
            
            if (compararFechas(fecha, actual.getReclamo().getFechaLimite())) {
                actual = actual.getIzquierdo();
            } 

            else {
                actual = actual.getDerecho();
            }
        
        }
        
        System.out.println("No se encontro el reclamo");
        return null;
    }
    
}