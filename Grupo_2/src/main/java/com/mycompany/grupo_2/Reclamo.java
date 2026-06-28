/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_2;

/**
 *
 * @author guill
 */
public class Reclamo {
    
    private int rut;
    private String nombreCiudadano;
    private String fechaIngreso;
    private String nombreReclamo;
    private String fechaLimite;
    private String tipoReclamo;
    private boolean estadoReclamo;
    private int nivelPrioridad;
    private String descripcion;

    public Reclamo(int rut, String nombreCiudadano, String fechaIngreso, String nombreReclamo, String fechaLimite, String tipoReclamo, int nivelPrioridad, String descripcion) {
        this.rut = rut;
        this.nombreCiudadano = nombreCiudadano;
        this.fechaIngreso = fechaIngreso;
        this.nombreReclamo = nombreReclamo;
        this.fechaLimite = fechaLimite;
        this.tipoReclamo = tipoReclamo;
        this.estadoReclamo = false;
        this.nivelPrioridad = nivelPrioridad;
        this.descripcion = descripcion;
    }

    public int getRut() {
        return rut;
    }

    public String getNombreCiudadano() {
        return nombreCiudadano;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getNombreReclamo() {
        return nombreReclamo;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public String getTipoReclamo() {
        return tipoReclamo;
    }

    public boolean isEstadoReclamo() {
        return estadoReclamo;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public void setNombreReclamo(String nombreReclamo) {
        this.nombreReclamo = nombreReclamo;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public void setTipoReclamo(String tipoReclamo) {
        this.tipoReclamo = tipoReclamo;
    }

    public void setEstadoReclamo(boolean estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        
        if(estadoReclamo == false){
        
        return  "Rut: " + rut +"|"
                + "Nombre del Ciudadano: " + nombreCiudadano +"|"
                + "Fecha de Ingreso: " + fechaIngreso +"|"+
                "Nombre del Reclamo: " + nombreReclamo +"|"+
                "Fecha Limite: " + fechaLimite +"|"+
                "Tipo Reclamo: " + tipoReclamo +"|"+
                "Estado Reclamo: " + "Pendiente"+"|"
                + "Nivel de Prioridad: " + nivelPrioridad +"|"+
                "Descripcion: " + descripcion;
        }
        else{
        
                return  "Rut: " + rut +"|"
                + "Nombre del Ciudadano: " + nombreCiudadano +"|"
                + "Fecha de Ingreso: " + fechaIngreso +"|"+
                "Nombre del Reclamo: " + nombreReclamo +"|"+
                "Fecha Limite: " + fechaLimite +"|"+
                "Tipo Reclamo: " + tipoReclamo +"|"+
                "Estado Reclamo: " + "Resuelto"+"|"
                + "Nivel de Prioridad: " + nivelPrioridad +"|"+
                "Descripcion: " + descripcion;
        
        }
    }
     
}
