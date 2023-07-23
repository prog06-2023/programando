package varias_tareas.fernando;

import java.util.Scanner;

/**
 * Clase principal
 *
 * @version 1.0
 * @author Fernando García Cano
 *
 */

public class Main {
    static Tarea[] db = new Tarea[10];

    public static void main(String[] args) {
        String input = "";
        Scanner entrada = new Scanner(System.in);
        Persona persona = new Persona("Fernando", "García");

        while(!input.equals("Q")){
            Tarea.mostrarMenu();
            input = entrada.next();
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
                    for (int i = 0; i < db.length; i++){
                        if (db[i] != null){
                            db[i].display();
                        }
                    }
                    break;
                default:
                    System.out.println("Elija una opcion valida");
            }
            System.out.println();
        }
        entrada.close();

    }
}
