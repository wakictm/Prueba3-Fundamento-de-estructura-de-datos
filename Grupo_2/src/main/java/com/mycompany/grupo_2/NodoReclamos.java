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
    
    private Reclamo reclamo;
    private NodoReclamos izquierdo;
    private NodoReclamos derecho;
    private int alturanodo;

    public NodoReclamos(Reclamo reclamo) {
        this.reclamo = reclamo;
        this.izquierdo = null;
        this.derecho = null;
        this.alturanodo = 1;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public NodoReclamos getIzquierdo() {
        return izquierdo;
    }
    //Nuevo hijo izquierdo
    public void setIzquierdo(NodoReclamos izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoReclamos getDerecho() {
        return derecho;
    }
    //Nuevo hijo derecho
    public void setDerecho(NodoReclamos derecho) {
        this.derecho = derecho;
    
    }
    //Obteniene la altura
    public int getAlturanodo() {
        return alturanodo;
    }
    //Actualiza la altura
    public void setAlturanodo(int alturanodo) {
        this.alturanodo = alturanodo;
    }
    
}

