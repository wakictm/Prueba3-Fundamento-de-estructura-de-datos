

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
        PilaHistorial ph = new PilaHistorial();
        AlgoritmosOrdenamientos AO = new AlgoritmosOrdenamientos();
        ArbolReclamos AR = new ArbolReclamos();
        
        cola.agregar(new Reclamo(1, "Juan Fuentes", "12/06/2026", "Vecinos ruidosos", "15/12/2026", "Vecinos", 3, "descripcion"));
        cola.agregar(new Reclamo(2, "Guille Donoso", "18/06/2026", "se echo fisíca", "05/05/2026", "no pase fisica", 3, "descripcion"));
        cola.agregar(new Reclamo(3, "Pepe Rodríguez", "18/06/2026", "Solo soy un dato", "14/02/2027", "quien soy yo", 3, "descripcion"));
        cola.agregar(new Reclamo(4, "Juan Carlos Bodoque", "18/06/2026", "Tulio no me presta plata", "28/06/2026", "Porque tulio es tan tacaño", 3, "descripcion"));
        cola.agregar(new Reclamo(5, "Felipe Diaz", "18/06/2026", "Ser yo", "10/12/2026", "AAA", 1, "descripcion"));
        
        for(Reclamo reclamo : cola.getReclamos()){
        
            AR.insertar(reclamo);
        }
        
        
        
        Scanner sc = new Scanner(System.in);
        
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        
        AR.mostrarInOrden();
        do{
            
            mostrarMenu();
            System.out.print("\nIngresa una opcion: ");
            
            opcion = sc.nextInt();
            
            switch(opcion){
                    
                    case 1:
                        if(cola.tamaño()==0){
                            
                            System.out.println("No hay reclamos pendientes");
                            break;
                        }
                        else{
                            
                        /**Llama metodos para buscar el reclamo más urgente para agregarlo a la pila historial,
                           y luego eliminarlo de la cola para finalmente actualizar el arbol AVL*/
                            
                        Reclamo auxReclamo = AR.obtenerMasIzquierda();
                        auxReclamo.setEstadoReclamo(true);
                        System.out.println(auxReclamo);
                        
                        int indiceReclamo = 0;
                        for(int i = 0; i<cola.tamaño();i++){
                        
                            if(auxReclamo.getRut()==cola.getReclamos()[i].getRut()){
                            
                                indiceReclamo = i;
                            
                            }
                        
                        }
                        
                        cola.eliminar(indiceReclamo);
                        
                        System.out.println("Reclamo terminado correctamente");
                        AR = actualizarArbol(AR,cola);
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
                        
                        Reclamo nuevoReclamo = new Reclamo(rut, nombre
                                , fechaIngreso, nombreReclamo, fechaLimite
                                , tipoReclamo, nivelPrioridad, descripcion);
                        
                        cola.agregar(nuevoReclamo);
                        AR.insertar(nuevoReclamo);
                        
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
                                ph.apilar(cola.getReclamos()[indice]);
                                break;

                            case 2:
                                
                                indice = buscarRut(cola, sc);
                                
                                System.out.println("Ingrese la nueva fecha límite (DD/MM//AAAA)");
                                String fechaLimiteNuevo = sc.next();
                                
                                cola.getReclamos()[indice].setFechaLimite(fechaLimiteNuevo);
                                ph.apilar(cola.getReclamos()[indice]);
                                
                                break;
                            case 3:
                                
                                indice = buscarRut(cola, sc);
                                
                                System.out.println("Ingrese el nueva tipo reclamo");
                                String tipoReclamoNuevo = sc.next();
                                
                                cola.getReclamos()[indice].setTipoReclamo(tipoReclamoNuevo);
                                ph.apilar(cola.getReclamos()[indice]);
                                break;
                                
                            case 4:
                                
                                indice = buscarRut(cola, sc);
                                
                                System.out.println("Ingrese el nuevo nivel prioridad");
                                int nivelPrioridadNuevo = sc.nextInt();
                                
                                cola.getReclamos()[indice].setNivelPrioridad(nivelPrioridadNuevo);
                                ph.apilar(cola.getReclamos()[indice]);
                                break;
                                
                            case 5:
                                
                                indice = buscarRut(cola, sc);
                                
                                System.out.println("Ingrese la nueva descripcion");
                                String descripcionNuevo = sc.next();
                                
                                cola.getReclamos()[indice].setDescripcion(descripcionNuevo);
                                ph.apilar(cola.getReclamos()[indice]);
                                break;
                            
                            default:
                                
                                System.out.println("Opcion invalida ingrese otro");
                        
                        }
                                
                                
                        }while(opc2 < 1 && opc2 > 5);}
                        
                        else{
                            
                            System.out.println("No hay ningún reclamo registrado");
                            break;
                        }
                        
                        AR = actualizarArbol(AR, cola);
                        break;
                        
                    case 4:
                        int indice = buscarRut(cola, sc);
                        
                        cola.eliminar(indice);
                        AR = actualizarArbol(AR, cola);
                        
                        break;
                        
                        
                    case 5:
                        
                        int opc = 0;
                        
                        do{
                            
                            System.out.println("1. Mostrar todos los reclamps pendientes"
                                    + "\n2. Mostrar todos los reclamos modificados"
                                    + "\n3. Mostrar reclamos por orden de prioridad"
                                    + "\n4. Mostrar segun arbol AVL");
                            System.out.print("Ingrese una opcion: ");
                            opc = sc.nextInt();
                            
                            switch(opc){
                            
                                case 1:
                                    cola.mostrarReclamos();
                                    break;
                                
                                case 2:
                                    ph.mostrarPila();
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
                                
                                case 4:
                                    
                                    AR.mostrarInOrden();
                                    break;
                                    
                                default:
                                    System.out.println("\nOpcion invalida ingrese otra opcion\n");
                                    break;
                            
                            }
                        
                        }while(opc < 1 || opc > 4);
                        
                        break;
            
        
            }
        
        }while(opcion != 8);
        
        
        
    }

    public static void mostrarMenu() {
        
        System.out.println("1. Actualizar el estado del reclamo(el más urgente)\n2. Agregar reclamos\n3. "
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
    
    public static ArbolReclamos actualizarArbol(ArbolReclamos AR, Cola cola){
    
        AR = new ArbolReclamos();
                        
                        for (int i = 0; i < cola.tamaño(); i++) {
                            Reclamo reclamoAct = cola.getReclamos()[i];


                            if (reclamoAct != null) {
                                AR.insertar(reclamoAct);
                            }
                        }
                        
        return AR;
    }
        
        
   }
    
