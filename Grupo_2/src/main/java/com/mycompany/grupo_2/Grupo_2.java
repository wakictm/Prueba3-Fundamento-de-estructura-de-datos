

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
        
        AlgoritmosOrdenamientos AO = new AlgoritmosOrdenamientos();
        
        
        cola.agregar(new Reclamo(1,"Juan Fuentes", "12/06/2026", "nombre problema", "25/06/2026", "tipo de problema", 1, "descripcion"));
        cola.agregar(new Reclamo(2,"Guille Donoso", "18/06/2026", "nombre problema", "30/06/2026", "LAS NOTAS", 3, "descripcion"));
        
        Scanner sc = new Scanner(System.in);
        
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        
        do{
            
            mostrarMenu();
            System.out.print("\nIngresa una opcion: ");
            
            opcion = sc.nextInt();
            
            switch(opcion){
                    
                    case 1:
                        if(cola.tamaño() == 0){
                            
                            System.out.println("No existen reclamos pendientes");
                 
                        }
                        
                        else{
                        
                            
                        
                        }
                        
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
                        
                        
                        cola.agregar(new Reclamo(rut, nombre, fechaIngreso, nombreReclamo, fechaLimite, tipoReclamo, nivelPrioridad, descripcion));
                        
                        
                        break;
                    
                    case 3:
                        if(cola.tamaño()!=0){
                            
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
                                
                                cola.getReclamos()[indice].setTipoReclamo(tipoReclamoNuevo);
                                
                                break;
                                
                            case 4:
                                
                                indice = buscarRut(cola, sc);
                                
                                System.out.println("Ingrese el nuevo nivel prioridad");
                                int nivelPrioridadNuevo = sc.nextInt();
                                
                                cola.getReclamos()[indice].setNivelPrioridad(nivelPrioridadNuevo);
                                
                                break;
                                
                            case 5:
                                
                                indice = buscarRut(cola, sc);
                                
                                System.out.println("Ingrese la nueva descripcion");
                                String descripcionNuevo = sc.next();
                                
                                cola.getReclamos()[indice].setDescripcion(descripcionNuevo);
                                
                                break;
                            
                            default:
                                
                                System.out.println("Opcion invalida ingrese otro");
                        
                        }
                                
                                
                        }while(opc2 < 1 && opc2 > 5);}
                        
                        else{
                            
                            System.out.println("No hay ningún reclamo registrado");
                        
                        }
                        
                        break;
                        
                    case 4:
                        int indice = buscarRut(cola, sc);
                        
                        cola.eliminar(indice);
                        
                        break;
                        
                        
                    case 5:
                        
                        int opc = 0;
                        
                        do{
                            
                            System.out.println("1. Mostrar todos los reclamps pendientes"
                                    + "\n2. Mostrar todos los reclamos resueltos"
                                    + "\n3. Mostrar reclamos por orden de prioridad");
                            System.out.print("Ingrese una opcion: ");
                            opc = sc.nextInt();
                            
                            switch(opc){
                            
                                case 1:
                                    cola.mostrarReclamos();
                                    break;
                                
                                case 2:
                                    
                                    break;
                                    
                                case 3:
                                    int opcAO = 0;
                                    do{
                                        System.out.println("1. Ordenar por Bubblesort"
                                                + "\n2. Ordenar por QUicksort");
                                        Cola colaordenada = new Cola(cola);
                                        opcAO = sc.nextInt();
                                        switch(opcAO){
                                          
                                            case 1:
                                               
                                                AO.Bubblesort(colaordenada);
                                                colaordenada.mostrarReclamos();
                                                break;
                                            case 2:
                                               
                                                AO.QuickSort(colaordenada);
                                                colaordenada.mostrarReclamos();
                                                break;
                                        
                                        
                                        }
                                    
                                    
                                    }while(opcAO < 1 || opcAO > 2);
                                    
                                    break;
                                
                                default:
                                    System.out.println("\nOpcion invalida ingrese otra opcion\n");
                                    break;
                            
                            }
                        
                        }while(opc < 1 || opc > 3);
                        
                        break;
            
        
            }
        
        }while(opcion != 8);
        
        
        
    }

    public static void mostrarMenu() {
        
        System.out.println("1. Gestionar reclamos\n2. Agregar reclamos\n3. "
                + "Modificar información de un reclamo existente\n4. Eliminar "
                + "reclamos\n5. Consultar reclamos registrados");
        
    }
    
    public static void menuModificarReclamo(){
    
        System.out.println("1. Modificar el nombre del reclamo\n2. Modificar "
                + "fecha limite\n3. Modificar tipo de reclamo\n4. Modificar "
                + "nivel de prioridad\n5. Modificar descripcion del reclamo\n");
    
    
    }
    
    public static int buscarRut(Cola cola, Scanner sc){
        
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
     
    }
        
        
   }
    
