package varias_tareas.fernando;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal
 *
 * @version 1.1
 * @author Fernando García Cano
 *
 */

public class Main {
    static ArrayList<Tarea> db = new ArrayList<Tarea>();

    public static void main(String[] args) {
        String input = "";
        Scanner entrada = new Scanner(System.in);
        Persona persona = new Persona("Fernando", "García");

        while(!input.equals("Q")){
            mostrarMenu();
            input = entrada.next();
            input = input.toUpperCase();
            switch (input){
                case "A":
                    Tarea.agregarTarea(entrada, db);
                    break;
                case "M":
                    Tarea.modificarTarea(entrada, db);
                    break;
                case "D":
                    Tarea.eliminarTarea(entrada, db);
                    break;
                case "Q":

                    System.out.println(persona.getNombre() + " " + persona.getApellido() + " " + "tareas actuales: ");
                    Tarea.mostrarTareasActuales(db);
                    break;
                default:
                    System.out.println("Elija una opcion valida");
            }
            System.out.println();
        }
        entrada.close();

    }

    /**
     * Este metodo nos ayuda a mostrar el menu con las opciones que el usuario puede
     */
    public static void mostrarMenu(){
        System.out.println("==============================================");
        System.out.println("Bienvenido al Administrador de Tareas");
        System.out.println("Elija una opcion valida");
        System.out.println("A - agregar tarea");
        System.out.println("M - modificar tarea");
        System.out.println("D - eliminar tarear");
        System.out.println("Q - salir");
        System.out.println("==============================================");
    }
}
