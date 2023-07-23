package varias_tareas.fernando;

import java.util.Scanner;

/**
 * Esta clase sirve para instanciar a un objeto de tipo Tarea
 * @version 1.0
 * @author Fernando García Cano
 */

public class Tarea {
    private static int id = 0;
    private String descripcion;
    private String nombreTarea;

    /**
     * Instancia una nueva tarea sin parametros (constructor)
     */

    public Tarea(){

    }

    /**
     * Instancia una nueva tarea con parametros (constructor)
     * @param nombreTarea
     * @param descripcion
     */
    public Tarea(String nombreTarea, String descripcion){
        this.descripcion = descripcion;
        this.nombreTarea = nombreTarea;
        if (Tarea.id >= 10){
            Tarea.id = 0;
        }
        Tarea.id++;
    }

    /**
     * Este metodo imprime los datos de nuestro objeto tarea
     */

    public void display(){
        System.out.println("Id de la tarea: " + Tarea.id + "/ " + "Nombre de la tarea: " + this.nombreTarea + "/ " + "Descripcion: " + this.descripcion);
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

    /**
     * Este metodo sirve para agregar una nueva tarea a nuestra base de datos de nuestro usuario
     * @param entrada
     * @param db
     */
    public static void agregarTarea(Scanner entrada, Tarea[] db){
        String[] datosTarea = new String[3];
        System.out.println("==============================================");
        System.out.println("Ingrese el nombre de la tarea: ");
        datosTarea[0] = entrada.next();
        System.out.println("Ingrese descripcion de la tarea: ");
        datosTarea[1] = entrada.next();
        datosTarea[2] = String.valueOf(Tarea.id);
        System.out.println("==============================================");
        Tarea tarea = new Tarea(datosTarea[0], datosTarea[1]);
        db[Tarea.id - 1] = tarea;
        db[Tarea.id - 1].display();
    }

    /**
     * Este metodo nos ayuda a modificar alguna de nuestras tareas mediante el id de la tarea
     * @param entrada
     * @param db
     */
    public static void modificarTarea(Scanner entrada, Tarea[] db){
        String  valor;
        System.out.println("==============================================");
        System.out.println("Ingrese el id de la tarea a modificar: ");
        valor = entrada.next();
        valor = validarId(valor, entrada);
        System.out.println("Ingrese el nombre de la tarea: ");
        db[Integer.parseInt(valor) - 1].setNombreTarea(entrada.next());
        System.out.println("Ingrese descripcion de la tarea: ");
        db[Integer.parseInt(valor) - 1].setDescripcion(entrada.next());
        db[Integer.parseInt(valor) - 1 ].display();
    }

    /**
     * Este metodo nos ayuda a eliminar alguna tarea del usuario mediante el id de la tarea
     * @param entrada
     * @param db
     */

    public static void eliminarTarea(Scanner entrada, Tarea[] db){
        String valor;
        System.out.println("==============================================");
        System.out.println("Ingrese el id de la tarea a eliminar: ");
        valor = entrada.next();
        valor = validarId(valor, entrada);
        System.out.println("Eliminando: " + db[Integer.parseInt(valor) - 1]);
        db[Integer.parseInt(valor) - 1] = null;
        System.out.println(db[Integer.parseInt(valor) - 1]);
    }

    /**
     * Este metodo nos ayuda avalidar que la entrada del usuario solo sean numeros
     * @param valor
     * @param entrada
     * @return
     */
    public static String validarId(String valor, Scanner entrada){
        String validar = "^[0-9]*";
        if(!valor.matches(validar)){
            do {
                System.out.println();
                valor = entrada.next();

            } while (!valor.matches(validar));
        }
        return valor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }
}
