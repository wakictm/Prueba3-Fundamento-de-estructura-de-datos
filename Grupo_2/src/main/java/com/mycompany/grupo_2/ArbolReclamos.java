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
    //Arbol AVL
public class ArbolReclamos {
    private NodoReclamos raiz;
    //Revisa la altura del arbol en caso de ser 0 retorna un null 
    private int altura(NodoReclamos nodo){
        return (nodo == null)? 0 : nodo.getAlturanodo();
    }
    //Calcula el balanceo del arbol 
    private int balance(NodoReclamos nodo){
        return (nodo == null)? 0 : altura(nodo.getIzquierdo())-altura(nodo.getDerecho());
    }
    //Actualizar Altura tomando la altura de los hijos 
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
    //Rotar hacia la derecho , se usa cuando el arbol izquierdo esta desbalanceado

    private NodoReclamos rotarDerecha(NodoReclamos y){
        NodoReclamos x = y.getIzquierdo();
        NodoReclamos T2 = x.getDerecho();
        
        x.setDerecho(y);
        y.setIzquierdo(T2);
        
        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }
    //Rotar hacia la izquierda , se usa cuando el arbol derecho esta desbalanceado
    private NodoReclamos rotarIzquierdo(NodoReclamos x){
        NodoReclamos y = x.getDerecho();
        NodoReclamos T2 = y.getIzquierdo();
        
        y.setIzquierdo(x);
        x.setDerecho(T2);
        
        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }
    
    //Metodo publico de insertar 
    public void insertar(Reclamo nuevoReclamo){
        raiz = insertarRec(raiz , nuevoReclamo);
    }
    //Insertar de manera Recursiva 
    private NodoReclamos insertarRec(NodoReclamos nodo, Reclamo nuevoReclamo){
        //Caso base en caso de estar vacio 
        if(nodo==null){
            return new NodoReclamos(nuevoReclamo);
        }
        //Insertar por nivel de prioridad 
        if(nuevoReclamo.getNivelPrioridad() < nodo.getReclamo().getNivelPrioridad()){
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), nuevoReclamo));
        }else if(nuevoReclamo.getNivelPrioridad() > nodo.getReclamo().getNivelPrioridad()){
            nodo.setDerecho(insertarRec(nodo.getDerecho(), nuevoReclamo));
        }else{
            nodo.setDerecho(insertarRec(nodo.getDerecho(), nuevoReclamo));
        }
        
        actualizarAltura(nodo);
        
        int balance = balance(nodo);
        
        if (balance > 1 && nuevoReclamo.getNivelPrioridad() < nodo.getIzquierdo().getReclamo().getNivelPrioridad()) {
            return rotarDerecha(nodo);
        }

        if (balance < -1 && nuevoReclamo.getNivelPrioridad() > nodo.getDerecho().getReclamo().getNivelPrioridad()) {
            return rotarIzquierdo(nodo);
        }

        if (balance > 1 && nuevoReclamo.getNivelPrioridad() > nodo.getIzquierdo().getReclamo().getNivelPrioridad()) {
            nodo.setIzquierdo(rotarIzquierdo(nodo.getIzquierdo()));
            return rotarDerecha(nodo);
        }

        if (balance < -1 && nuevoReclamo.getNivelPrioridad() < nodo.getDerecho().getReclamo().getNivelPrioridad()) {
            nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
            return rotarIzquierdo(nodo);
        }

        return nodo;
    }
    //Comparar de manera dd/mm/aaaa 
    private boolean compararFechas(String fecha1, String fecha2) {
        
        String aux1 = "";
        String aux2 = "";
        ArrayList<Integer> fechas = new ArrayList<Integer>();
        
        for(int i = 0; i < fecha1.length(); i++){
           
            if(fecha1.charAt(i)!= '/'){
                aux1 += fecha1.charAt(i);
                aux2 += fecha2.charAt(i);
                //System.out.println(fecha1.charAt(i));
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
        //Comparar por fechas 
        for(int i = fechas.size()-1; i >= 0; i-=2){
        
            if(fechas.get(i) > fechas.get(i-1)){
            
                //System.out.println(fechas.get(i)+" - "+fechas.get(i-1));
                return true;
            }
            
        }
        return false;
             
    }
    //Mostrar en InOrden
    public void mostrarInOrden() {
        if(raiz == null){
            System.out.println("No existen reclamos en el árbol.");
        } else {
            inOrden(raiz);
        }
    }     
        //Recorrer en InOrden de manera recursiva 
    private void inOrden(NodoReclamos nodo) {
        if(nodo != null){
            inOrden(nodo.getIzquierdo());
            System.out.println(nodo.getReclamo()); 
            inOrden(nodo.getDerecho());
        }
    }
    
}