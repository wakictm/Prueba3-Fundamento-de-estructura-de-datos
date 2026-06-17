/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grupo_2;

import java.util.Scanner;

/**
 *
 * @author wakictm
 */
public class Grupo_2 {

    public static void main(String[] args) {
        
        int opcion = 0;
        
        Cola cola = new Cola();
        
        cola.agregar(new Reclamo(1,"Juan", 10, "nombre problema", 15, "tipo de problema", 3, "descripcion"));
        cola.agregar(new Reclamo(2,"Guille", 10, "nombre problema", 15, "LAS NOTAS", 3, "descripcion"));
        
        Scanner sc = new Scanner(System.in);
        
        do{
            
            mostrarMenu();
            System.out.print("\nIngresa una opcion: ");
            
            opcion = sc.nextInt();
            
            switch(opcion){
                    
                    case 1:
                        
                        break;
                    case 2:
                        System.out.print("Ingrese el rut del ciudadano: ");
                        int rut = sc.nextInt();
                        System.out.print("Ingresa el nombre del ciudadano: ");
                        String nombre = sc.next();
                        
                        System.out.print("Ingresar fecha ingreso: ");
                        int fechaIngreso = sc.nextInt();
                        
                        sc.nextLine();
                        System.out.print("Nombre del reclamo: ");
                        String nombreReclamo = sc.nextLine();
                        System.out.print("Ingrese la fecha limite: ");
                        int fechaLimite = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese el tipo de reclamo: ");
                        String tipoReclamo = sc.nextLine();
                        
                        System.out.print("Ingrese el nivel de prioridad: ");
                        int nivelPrioridad = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Agrega una descripcion del reclamo: ");
                        String descripcion = sc.nextLine();
                        
                        
                        cola.agregar(new Reclamo(rut, nombre, fechaIngreso, nombreReclamo, fechaLimite, tipoReclamo, nivelPrioridad, descripcion));
                        
                        
                        break;
                    
                    case 3:
                        
                        break;
                        
                    case 4:
                        
                        break;
                        
                        
                    case 5:
                    
                        cola.mostrarReclamos();
                        break;
            
        
            }
        
        }while(opcion != 8);
        
        
        
    }

    public static void mostrarMenu() {
        
        System.out.println("1. Gestionar reclamos\n2. Agregar reclamos\n3. Modificar información de un reclamo existente\n4. Eliminar reclamos\n5. Consultar reclamos registrados");
        
    }
}
