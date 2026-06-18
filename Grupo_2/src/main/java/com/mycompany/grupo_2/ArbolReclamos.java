/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_2;

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
        if(nodo==null){
            return new NodoReclamos(nuevoReclamo);
        }
        if(nuevoReclamo.getRut()<nodo.getReclamo().getRut()){
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(),nuevoReclamo));
        }else if(nuevoReclamo.getRut()>nodo.getReclamo().getRut()){
            nodo.setDerecho(insertarRec(nodo.getDerecho(),nuevoReclamo));
        }else{
            return nodo;
        }
        return nodo;
    }
}