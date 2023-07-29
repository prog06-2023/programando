package varias_tareas.fernando;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal
 *
 * @version 1.2
 * @author Fernando García Cano
 *
 */

public class Main {
    static ArrayList<Tarea> db = new ArrayList<Tarea>();

    public static void main(String[] args) {
        String input = "";
        String  valor;
        int idEncontrado;
        Scanner entrada = new Scanner(System.in);
        Persona persona = new Persona("Fernando", "García");

        while(!input.equals("Q")){
            mostrarMenu();
            input = entrada.next();
            input = input.toUpperCase();
            switch (input){
                case "A":
                    String[] datosTarea = new String[3];
                    System.out.println("==============================================");
                    System.out.println("Ingrese el nombre de la tarea: ");
                    datosTarea[0] = entrada.next();
                    System.out.println("Ingrese descripcion de la tarea: ");
                    datosTarea[1] = entrada.next();
                    datosTarea[2] = String.valueOf(Tarea.getId());
                    System.out.println("==============================================");
                    Tarea tarea = new Tarea(datosTarea[0], datosTarea[1], datosTarea[2]);
                    Tarea.agregarTarea(tarea, db);
                    break;
                case "M":
                    System.out.println("==============================================");
                    System.out.println("Ingrese el id de la tarea a modificar: ");
                    valor = entrada.next();
                    if(!Tarea.validarId(valor)){
                        do {
                            System.out.println("Valor no aceptado");
                            valor = entrada.next();

                        } while (!Tarea.validarId(valor));
                    }
                    idEncontrado = Tarea.encontraId(db, valor);
                    if (idEncontrado == -1){
                        do {
                            System.out.println("Id de tarea no encontrado porfavor digite un id valido");
                            valor = entrada.next();
                            idEncontrado = Tarea.encontraId(db, valor);

                        } while (idEncontrado == -1 && !Tarea.validarId(valor));
                    }
                    System.out.println("Ingrese el nombre de la tarea: ");
                    db.get(idEncontrado).setNombreTarea(entrada.next());
                    System.out.println("Ingrese descripcion de la tarea: ");
                    db.get(idEncontrado).setDescripcion(entrada.next());
                    Tarea.mostrarTareasActuales(db);

                    break;
                case "D":
                    System.out.println("==============================================");
                    System.out.println("Ingrese el id de la tarea a eliminar: ");
                    valor = entrada.next();
                    if(!Tarea.validarId(valor)){
                        do {
                            System.out.println("Valor no aceptado");
                            valor = entrada.next();

                        } while (!Tarea.validarId(valor));
                    }
                    idEncontrado = Tarea.encontraId(db, valor);
                    if (idEncontrado == -1){
                        do {
                            System.out.println("Id de tarea no encontrado porfavor digite un id valido");
                            valor = entrada.next();
                            idEncontrado = Tarea.encontraId(db, valor);

                        } while (idEncontrado == -1 && !Tarea.validarId(valor));
                    }
                    Tarea.eliminarTarea(idEncontrado, db);
                    break;
                case "Q":

                    System.out.println(persona.getNombre() + " " + persona.getApellido() + " " + "tareas actuales: ");
                    Tarea.mostrarTareasActuales(db);
                    entrada.close();
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
