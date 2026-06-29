/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_2;

/**
 *
 * @author guill
 */
public class NodoReclamos {
    
    //Atrivutos del nodo reclamo
    private Reclamo reclamo;
    private NodoReclamos izquierdo;
    private NodoReclamos derecho;
    private int alturanodo;
    
    //Constructor del nodo reclamo
    public NodoReclamos(Reclamo reclamo) {
        this.reclamo = reclamo;
        this.izquierdo = null;
        this.derecho = null;
        this.alturanodo = 1;
    }
    
    //Getter y setter necesarios para moverse e insertar en el Arbol AVL

    public Reclamo getReclamo() {
        return reclamo;
    }

    public NodoReclamos getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoReclamos izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoReclamos getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoReclamos derecho) {
        this.derecho = derecho;
    
    }

    public int getAlturanodo() {
        return alturanodo;
    }

    public void setAlturanodo(int alturanodo) {
        this.alturanodo = alturanodo;
    }
    
}

