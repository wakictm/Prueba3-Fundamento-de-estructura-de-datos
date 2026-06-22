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
        ArbolReclamos arbol = new ArbolReclamos(); 
        
        // Se crean los reclamos de prueba originales
        Reclamo p1 = new Reclamo(1,"Juan", "12/06/2026", "nombre problema", "25/06/2026", "tipo de problema", 3, "descripcion");
        Reclamo p2 = new Reclamo(2,"Guille", "18/06/2026", "nombre problema", "30/06/2026", "LAS NOTAS", 3, "descripcion");
        
        // Se agregan a la cola original
        cola.agregar(p1);
        cola.agregar(p2);
        
        // Se cargan los reclamos de prueba en el árbol también
        arbol.insertar(p1);
        arbol.insertar(p2);
        
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
                        
                        System.out.print("Ingresar fecha ingreso (DD/MM//AAAA): ");
                        String fechaIngreso = sc.next();
                        
                        sc.nextLine();
                        System.out.print("Nombre del reclamo: ");
                        String nombreReclamo = sc.nextLine();
                        System.out.print("Ingrese la fecha limite (DD/MM//AAAA): ");
                        String fechaLimite = sc.next();
                        sc.nextLine();
                        System.out.print("Ingrese el tipo de reclamo: ");
                        String tipoReclamo = sc.nextLine();
                        
                        System.out.print("Ingrese el nivel de prioridad: ");
                        int nivelPrioridad = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Agrega una descripcion del reclamo: ");
                        String descripcion = sc.nextLine();
                        
                        Reclamo nuevoReclamo = new Reclamo(rut, nombre, fechaIngreso, nombreReclamo, fechaLimite, tipoReclamo, nivelPrioridad, descripcion);
                        
                        cola.agregar(nuevoReclamo); 
                        arbol.insertar(nuevoReclamo); 
                        
                        break;
                    
                    case 3:
                        menuModificarReclamo();
                        System.out.println("Ingrese la opcion a modificar");
                        int opc2 = 0;
                        do{
                        
                            opc2 = sc.nextInt();
                                
                            switch(opc2){
                                
                                case 1:
                                    int indice = buscarRut(cola, sc);
                                    System.out.println("Ingrese el nuevo nombre del reclamo");
                                    String nombreReclamoNuevo = sc.next();
                                    cola.getReclamos()[indice].setNombreReclamo(nombreReclamoNuevo);
                                    break;

                                case 2:
                                    indice = buscarRut(cola, sc);
                                    System.out.println("Ingrese la nueva fecha límite (DD/MM//AAAA)");
                                    String fechaLimiteNuevo = sc.next();
                                    cola.getReclamos()[indice].setFechaLimite(fechaLimiteNuevo);
                                    break;
                                    
                                case 3:
                                    indice = buscarRut(cola, sc);
                                    System.out.println("Ingrese el nueva tipo reclamo");
                                    String tipoReclamoNuevo = sc.next();
                                    cola.getReclamos()[indice].setFechaLimite(tipoReclamoNuevo);
                                    break;
                                    
                                case 4:
                                    // CORREGIDO AQUÍ: El actualizador debe ir en la opción de modificar prioridad
                                    indice = buscarRut(cola, sc);
                                    
                                    if (indice != -1) {
                                        System.out.println("Ingrese el nuevo nivel prioridad");
                                        int nivelPrioridadNuevo = sc.nextInt();
                                        
                                        // 1. Modifica en memoria interna de la lista
                                        cola.getReclamos()[indice].setNivelPrioridad(nivelPrioridadNuevo);
                                        
                                        // 2. Destruye y reconstruye el árbol con el orden nuevo
                                        arbol = new ArbolReclamos();
                                        for(int i = 0; i < cola.tamaño(); i++){
                                            arbol.insertar(cola.getReclamos()[i]);
                                        }
                                        System.out.println("¡Prioridad modificada y árbol reconstruido con éxito!");
                                    }
                                    break;
                                    
                                case 5:
                                    indice = buscarRut(cola, sc);
                                    System.out.println("Ingrese la nueva descripcion");
                                    String descripcionNuevo = sc.next();
                                    cola.getReclamos()[indice].setDescripcion(descripcionNuevo);
                                    break;
                                
                                default:
                                    System.out.println("Opcion invalida ingrese otra");
                            }
                                    
                        } while(opc2 < 1 || opc2 > 5); // CORREGIDO: Se usa || para validar correctamente el rango
                        
                        break;
                        
                    case 4:
                        // Menú principal: Opción para eliminar (quedará libre para tu lógica futura)
                        System.out.println("Opción para eliminar reclamos (Próximamente).");
                        break;
                        
                    case 5:
                        System.out.println("\n=== RECLAMOS EN COLA (Orden de llegada) ===");
                        cola.mostrarReclamos(); 
                        
                        System.out.println("\n=== RECLAMOS EN ÁRBOL AVL (Ordenados por Prioridad) ===");
                        arbol.mostrarInOrden(); 
                        break;
            }
        
        }while(opcion != 8);
        
    }

    public static void mostrarMenu() {
        System.out.println("\n1. Gestionar reclamos\n2. Agregar reclamos\n3. "
                + "Modificar información de un reclamo existente\n4. Eliminar "
                + "reclamos\n5. Consultar reclamos registrados");
    }
    
    public static void menuModificarReclamo(){
        System.out.println("1. Modificar el nombre del reclamo\n2. Modificar "
                + "fecha limite\n3. Modificar tipo de reclamo\n4. Modificar "
                + "nivel de prioridad\n5. Modificar descripcion del reclamo\n");
    }
    
    public static int buscarRut(Cola cola, Scanner sc){
        if(cola.tamaño() != 0){
            while(true){
                System.out.println("Ingrese el rut del reclamo a buscar");
                int rutBuscar = sc.nextInt();
            
                for(int i = 0; i < cola.tamaño(); i++){
                    if(rutBuscar == cola.getReclamos()[i].getRut()){
                        System.out.println(cola.getReclamos()[i]);
                        return i;
                    }
                }
                System.out.println("No se encontro el reclamo intente con otro rut");
            }
        } else {
            System.out.println("No hay reclamos registrados");
            return -1;
        }
   }
}