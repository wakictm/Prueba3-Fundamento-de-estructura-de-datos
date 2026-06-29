

package com.mycompany.grupo_2;

import java.util.Scanner;

/**
 *
 * @author wakictm
 */
public class Grupo_2 {

    public static void main(String[] args) {
        
        int opcion = 0;
        
        //Se instancian las estructuras lineales(pila y cola) y no lineales(Arbol AVL)
        //y ademas nuestra clase para ordenar con los sort
        Cola cola = new Cola();
        PilaHistorial ph = new PilaHistorial();
        AlgoritmosOrdenamientos AO = new AlgoritmosOrdenamientos();
        ArbolReclamos AR = new ArbolReclamos();
        
        //Datos precargados para probar las opciones del menú
        cola.agregar(new Reclamo(1, "Juan Fuentes", "12/06/2026", "Vecinos ruidosos", "15/12/2026", "Vecinos", 3, "descripcion"));
        cola.agregar(new Reclamo(2, "Guille Donoso", "18/06/2026", "se echo fisíca", "05/05/2026", "no pase fisica", 3, "descripcion"));
        cola.agregar(new Reclamo(3, "Pepe Rodríguez", "18/06/2026", "Solo soy un dato", "14/02/2027", "quien soy yo", 3, "descripcion"));
        cola.agregar(new Reclamo(4, "Juan Carlos Bodoque", "18/06/2026", "Tulio no me presta plata", "28/06/2026", "Porque tulio es tan tacaño", 3, "descripcion"));
        cola.agregar(new Reclamo(5, "Felipe Diaz", "18/06/2026", "Ser yo", "10/12/2026", "AAA", 1, "descripcion"));
        
        //for each para cargar todos los reclamos al arbol
        for(Reclamo reclamo : cola.getReclamos()){
        
            AR.insertar(reclamo);
        }
        
        
        
        Scanner sc = new Scanner(System.in);
        
        //resuelve los problemas con tilde no se me va olvidar mas(o si?)
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        
     
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
                            
                        /**Llama metodos para buscar el reclamo más urgente para cambiar el estado
                         como resuelto en la cola y desaparecerlo del arbol, ya que no es urgente
                         si ya esta resuelto*/
                            
                        Reclamo auxReclamo = AR.obtenerMasIzquierda();
                        auxReclamo.setEstadoReclamo(true);
                        System.out.println(auxReclamo);
                        
                        int indiceReclamo = 0;
                        for(int i = 0; i<cola.tamaño();i++){
                        
                            if(auxReclamo.getRut()==cola.getReclamos()[i].getRut()){
                            
                                indiceReclamo = i;
                            
                            }
                        
                        }
                        
                        cola.getReclamos()[indiceReclamo].setEstadoReclamo(true);
                        
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
                            
                            /*Aca las mil cosas que podrias modificar de un reclamo, para luego
                              agregarlo a la pila como historial de modificaciones*/
                            
                            case 1:
                                
                                int indice = buscarRut(cola, sc);
                                
                                System.out.println("Ingrese el nuevo nombre del reclamo");
                                String nombreReclamoNuevo = sc.next();
                                
                                Reclamo aux = cola.getReclamos()[indice];
                                //se añade en la pila como historial de los reclamos sin modificar
                                ph.apilar(new Reclamo(aux.getRut(),aux.getNombreCiudadano(),aux.getFechaIngreso()
                                        ,aux.getNombreReclamo(),aux.getFechaLimite(),aux.getTipoReclamo()
                                        ,aux.getNivelPrioridad(),aux.getDescripcion()));
                                cola.getReclamos()[indice].setNombreReclamo(nombreReclamoNuevo);
                                
                                break;

                            case 2:
                                
                                indice = buscarRut(cola, sc);
                                
                                System.out.println("Ingrese la nueva fecha límite (DD/MM//AAAA)");
                                String fechaLimiteNuevo = sc.next();
                                aux = cola.getReclamos()[indice];
                                //se añade en la pila como historial de los reclamos sin modificar
                                ph.apilar(new Reclamo(aux.getRut(),aux.getNombreCiudadano(),aux.getFechaIngreso()
                                        ,aux.getNombreReclamo(),aux.getFechaLimite(),aux.getTipoReclamo()
                                        ,aux.getNivelPrioridad(),aux.getDescripcion()));
                                cola.getReclamos()[indice].setFechaLimite(fechaLimiteNuevo);
                                
                                
                                break;
                            case 3:
                                
                                indice = buscarRut(cola, sc);
                                
                                System.out.println("Ingrese el nueva tipo reclamo");
                                String tipoReclamoNuevo = sc.next();
                                aux = cola.getReclamos()[indice];
                                //se añade en la pila como historial de los reclamos sin modificar
                                ph.apilar(new Reclamo(aux.getRut(),aux.getNombreCiudadano(),aux.getFechaIngreso()
                                        ,aux.getNombreReclamo(),aux.getFechaLimite(),aux.getTipoReclamo()
                                        ,aux.getNivelPrioridad(),aux.getDescripcion()));
                                
                                cola.getReclamos()[indice].setTipoReclamo(tipoReclamoNuevo);
                                
                                break;
                                
                            case 4:
                                
                                indice = buscarRut(cola, sc);
                                
                                System.out.println("Ingrese el nuevo nivel prioridad");
                                int nivelPrioridadNuevo = sc.nextInt();
                                
                                aux = cola.getReclamos()[indice];
                                //se añade en la pila como historial de que fue modificada
                                ph.apilar(new Reclamo(aux.getRut(),aux.getNombreCiudadano(),aux.getFechaIngreso()
                                        ,aux.getNombreReclamo(),aux.getFechaLimite(),aux.getTipoReclamo()
                                        ,aux.getNivelPrioridad(),aux.getDescripcion()));
                                cola.getReclamos()[indice].setNivelPrioridad(nivelPrioridadNuevo);
                                
                                break;
                                
                            case 5:
                                
                                indice = buscarRut(cola, sc);
                                
                                System.out.println("Ingrese la nueva descripcion");
                                String descripcionNuevo = sc.next();
                                aux = cola.getReclamos()[indice];
                                //se añade en la pila como historial de que fue modificada
                                ph.apilar(new Reclamo(aux.getRut(),aux.getNombreCiudadano(),aux.getFechaIngreso()
                                        ,aux.getNombreReclamo(),aux.getFechaLimite(),aux.getTipoReclamo()
                                        ,aux.getNivelPrioridad(),aux.getDescripcion()));
                                cola.getReclamos()[indice].setDescripcion(descripcionNuevo);
                                
                                break;
                            
                            default:
                                
                                System.out.println("Opcion invalida ingrese otro");
                        
                        }
                                
                        //Te obligara a escoger una opcion, caso contrario entraras en un bucle hasta que te decidas    
                        }while(opc2 < 1 && opc2 > 5);}
                        
                        else{
                            
                            System.out.println("No hay ningún reclamo registrado");
                            break;
                        }
                        //WUAJAJA FUNCIONAAA MI ACTUALIZAR ARBOL
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
                            
                            System.out.println("1. Mostrar todos los reclamos pendientes"
                                    + "\n2. Mostrar todos los reclamos modificados"
                                    + "\n3. Mostrar reclamos por orden de prioridad"
                                    + "\n4. Mostrar segun arbol AVL"
                                    + "\n5. Buscar reclamo por especifico(con rut y fecha termino)");
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
                                case 5:
                                    if(cola.tamaño()==0){
                                        System.out.println("No hay reclamos registrados");
                                        break;
                                    }
                                    System.out.println("Ingresa la fecha que termino del reclamo(DD/MM/AAAA): ");
                                    String fechaLimiteaux = sc.next();
                                    System.out.println("Ingresa el rut del reclamo a buscar: ");
                                    int rutaux = sc.nextInt();
                                    
                               
                                    
                                    //Se llama metodo de busqueda binaria utilizando la fecha termino y el rut
                                    AR.buscar(fechaLimiteaux, rutaux);
                                    break;
                                    
                                default:
                                    System.out.println("\nOpcion invalida ingrese otra opcion\n");
                                    break;
                            
                            }
                        
                        }while(opc < 1 || opc > 5);
                        
                        break;
            
        
            }
        
        }while(opcion != 6);
        
        System.out.println("Saliendo...");
        
    }

    public static void mostrarMenu() {
        
        System.out.println("1. Actualizar el estado del reclamo(el más urgente)\n2. Agregar reclamos\n3. "
                + "Modificar información de un reclamo existente\n4. Eliminar "
                + "reclamos\n5. Consultar reclamos registrados\n6. Salir");
        
    }
    
    public static void menuModificarReclamo(){
        
        System.out.println("1. Modificar el nombre del reclamo\n2. Modificar "
                + "fecha limite\n3. Modificar tipo de reclamo\n4. Modificar "
                + "nivel de prioridad\n5. Modificar descripcion del reclamo\n");
    
    
    }
    
    public static int buscarRut(Cola cola, Scanner sc){
        /*Busqueda secuencial segun rut para las mil cosas que 
        podemos modificar de un reclamo*/
        while(true){
            if(cola.tamaño() == 0){
                break;
            }
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
     return -1;
    }
    
    public static ArbolReclamos actualizarArbol(ArbolReclamos AR, Cola cola){
        //Obvio para no sufrir actualizando el arbol lo generamos desde 0 :) (soy flojo)
        AR = new ArbolReclamos();
                        
                        for (int i = 0; i < cola.tamaño(); i++) {
                            Reclamo reclamoActual = cola.getReclamos()[i];
                            
                            /*Solo guardara el reclamo si este sigue pendiente en el arbol
                            caso contrario no lo toma en cuenta
                            **/
                            if (reclamoActual != null) {
                                if(reclamoActual.isEstadoReclamo() == false){
                                    AR.insertar(reclamoActual);
                                
                                }
                            }
                        }
                        
        return AR;
    }
        
        
   }
    
