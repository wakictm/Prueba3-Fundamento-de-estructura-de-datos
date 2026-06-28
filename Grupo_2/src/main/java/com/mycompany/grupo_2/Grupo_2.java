

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
        
        cola.agregar(new Reclamo(1,"Juan Fuentes", "12/06/2026", "nombre problema", "25/06/2026", "tipo de problema", 3, "descripcion"));
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
                        
                        while(opc > 0 && opc < 4){
                        
                            System.out.println("1. Mostrar todos los reclamps pendientes"
                                    + "\n2. Mostrar todos los reclamos resueltos"
                                    + "\n3. Mostrar reclamos por orden de prioridad");
                            
                            switch(opc){
                            
                                case 1:
                                    cola.mostrarReclamos();
                                    break;
                                
                                case 2:
                                    
                                    break;
                                    
                                case 3:
                                    
                                    
                                    break;
                            
                            
                            }
                        
                        }
                        
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
    
