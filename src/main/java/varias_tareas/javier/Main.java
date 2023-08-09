package varias_tareas.javier;

import java.util.Scanner;

/**
 *
 * @author javier
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saludos! Por Favor para comenzar necesito tomarle sus datos...");
        System.out.println("Comenzemos -> Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.println("Aguarde un minuto estamos creandole un usuario! :)");
        Persona usuario = new Persona(nombre, apellido);
        String opcion;
        String opcionDos = "";
        int id;
        
        do {

            menuPrincipal(usuario);
            opcion = scanner.nextLine().toUpperCase();

            switch (opcion) {

                case "A":
                    System.out.println("Ingrese el nombre de la tarea: ");
                    String nombreTarea = scanner.nextLine();
                    System.out.println("Ingrese una descipcion: ");
                    String descripcion = scanner.nextLine();
                    System.out.println("Ingrese el estado su tarea ( Realizada / No Realizada )");
                    String realizada = scanner.nextLine();
                    
                    Tarea nuevaTarea = new Tarea(nombreTarea, descripcion, realizada);
                    
                    if (usuario.getTareas().contains(nuevaTarea)) {
                        System.out.println("La tarea ya se encuentra registrada...");
                        
                    } else {
                        usuario.getTareas().add(nuevaTarea);
                        System.out.println("Muy Bien, agregando su tarea a continuancion....");
                        System.out.println("Tarea Agregada!");
                    }
                    System.out.println("Desea hacer algo mas? (S / N)");
                    opcionDos = scanner.nextLine().toUpperCase();
                    break;

                case "L":
                    if (usuario.getTareas().isEmpty()) { 
                        System.out.println("No hay tareas en la lista de tareas! :(");
                        break;
                    }else {
                    
                    System.out.println("Aca tiene una lista de las tareas...");
                    System.out.println(usuario.getTareas().toString());
                    System.out.println("Desea hacer algo mas? (S / N)");
                    opcionDos = scanner.nextLine().toUpperCase();
                    break;
                    }
                    
                case "M":
                    String nombreTareaMod;
                    String descripcionTareaMod;
                    String estadoTareaMod;

                    if (usuario.getTareas().isEmpty()) {
                        System.out.println("No hay tareas en la lista de tareas! :(");
                        break;

                    } else {

                        System.out.println("Aca tiene una lista de las tareas...");
                        System.out.println(usuario.getTareas().toString());
                        System.out.println("Ingrese el numero de la tarea que quiere modificar: ");
                        id = scanner.nextInt();
                        System.out.println("Ingrese el nombre de la tarea: ");
                        nombreTareaMod = scanner.nextLine();
                        System.out.println("Ingrese una descipcion: ");
                        descripcionTareaMod = scanner.nextLine();
                        System.out.println("Ingrese el estado su tarea ( Realizada / No Realizada )");
                        estadoTareaMod = scanner.nextLine();

                        Tarea tareaAModificar = new Tarea(nombreTareaMod, descripcionTareaMod, estadoTareaMod);

                        usuario.modificarTarea(id, usuario.getTareas(), tareaAModificar);
                        System.out.println("Desea hacer algo mas? (S / N)");
                        opcionDos = scanner.nextLine().toUpperCase();
                        break;
                    }

                case "D":
                   if (usuario.getTareas().isEmpty()) {
                        System.out.println("No hay tareas para borrar! :(");
                        break;
                   }else{
                    System.out.println("Aca tiene una lista de las tareas...");
                    System.out.println(usuario.getTareas().toString());
                    System.out.println("Ingrese el numero de la tarea que quiere borrar: ");
                    id = scanner.nextInt();
                    usuario.eliminarTarea(id, usuario.getTareas());
                    System.out.println("Tarea Elimiinada");
                    System.out.println("Desea hacer algo mas? (S / N)");
                    opcionDos = scanner.nextLine().toUpperCase();
                    break;
                   }
            }

        } while  (!opcion.equals("Q") && !opcionDos.equals("N") );

        scanner.close();
        String salida = usuario.toString();
        System.out.println(salida);
           
    }

    public static void menuPrincipal(Persona usuario) {
        System.out.println("-------------------------------------------------");
        System.out.println("----------- BIENVENIDO " + usuario.getNombre() + " ------------");
        System.out.println("-------ELIJA UNA DE LAS SIGUIENTES OPCIONES------");
        System.out.println("------ A -> PARA AGREGAR UNA TAREA  -------------");
        System.out.println("------ L -> PARA LISTAR TODAS LAS TAREAS --------");
        System.out.println("------ M -> PARA MODIFICAR UNA TAREA  -----------");
        System.out.println("------ D -> PARA BORRAR UNA TAREA  --------------");
        System.out.println("------ Q -> PARA SALIR --------------------------");
        System.out.println("-------------------------------------------------");

    }

}
