

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
        
        cola.agregar(new Reclamo(1,"Juan", "12/06/2026", "nombre problema", "25/06/2026", "tipo de problema", 3, "descripcion"));
        cola.agregar(new Reclamo(2,"Guille", "18/06/2026", "nombre problema", "30/06/2026", "LAS NOTAS", 3, "descripcion"));
        
        Scanner sc = new Scanner(System.in);
        
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        
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
                        
                        System.out.print("Ingresar fecha ingreso (DD/MM//AAA): ");
                        String fechaIngreso = sc.next();
                        
                        sc.nextLine();
                        System.out.print("Nombre del reclamo: ");
                        String nombreReclamo = sc.nextLine();
                        System.out.print("Ingrese la fecha limite (DD/MM//AAA): ");
                        String fechaLimite = sc.next();
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
