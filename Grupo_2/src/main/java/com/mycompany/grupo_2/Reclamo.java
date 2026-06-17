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
    private int fechaIngreso;
    private String nombreReclamo;
    private int fechaLimite;
    private String tipoReclamo;
    private boolean estadoReclamo;
    private int nivelPrioridad;
    private String descripcion;

    public Reclamo(int rut, String nombreCiudadano, int fechaIngreso, String nombreReclamo, int fechaLimite, String tipoReclamo, boolean estadoReclamo, int nivelPrioridad, String descripcion) {
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

    public int getFechaIngreso() {
        return fechaIngreso;
    }

    public String getNombreReclamo() {
        return nombreReclamo;
    }

    public int getFechaLimite() {
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

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setNombreCiudadano(String nombreCiudadano) {
        this.nombreCiudadano = nombreCiudadano;
    }

    public void setFechaIngreso(int fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setNombreReclamo(String nombreReclamo) {
        this.nombreReclamo = nombreReclamo;
    }

    public void setFechaLimite(int fechaLimite) {
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
        return "Reclamo{" + "Rut: " + rut +"|"
                + "Nombre del Ciudadano: " + nombreCiudadano +"|"
                + "Fecha de Ingreso: " + fechaIngreso +"|"+
                "Nombre del Reclamo: " + nombreReclamo +"|"+
                "Fecha Limite: " + fechaLimite +"|"+
                "Tipo Reclamo: " + tipoReclamo +"|"+
                "Estado Reclamo: " + estadoReclamo+"|"
                + "Nivel de Prioridad: " + nivelPrioridad +"|"+
                "Descripcion: " + descripcion + '}';
    }
    

   
    
    
    
}
