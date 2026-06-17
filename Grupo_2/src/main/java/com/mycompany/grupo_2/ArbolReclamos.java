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
    private void actualizar(NodoReclamos nodo){
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
}
