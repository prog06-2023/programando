package varias_tareas.fernando;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase sirve para instanciar a un objeto de tipo Tarea
 * @version 1.2
 * @author Fernando García Cano
 */

public class Tarea {
    private static int id = 0;
    private String idTarea;
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
    public Tarea(String nombreTarea, String descripcion, String idTarea){
        this.descripcion = descripcion;
        this.nombreTarea = nombreTarea;
        this.idTarea = idTarea;
        Tarea.id++;
    }

    /**
     * Este metodo imprime los datos de nuestro objeto tarea
     */

    public void display(){
        System.out.println("Id de la tarea: " + this.idTarea + "/ " + "Nombre de la tarea: " + this.nombreTarea + "/ " + "Descripcion: " + this.descripcion + "/ " + this);
    }

    /**
     * Este metodo sirve para agregar una nueva tarea a nuestra base de datos de nuestro usuario
     * @param entrada
     * @param db
     */
    public static void agregarTarea(Scanner entrada, ArrayList<Tarea> db){
        String[] datosTarea = new String[3];
        System.out.println("==============================================");
        System.out.println("Ingrese el nombre de la tarea: ");
        datosTarea[0] = entrada.next();
        System.out.println("Ingrese descripcion de la tarea: ");
        datosTarea[1] = entrada.next();
        datosTarea[2] = String.valueOf(Tarea.id);
        System.out.println("==============================================");
        Tarea tarea = new Tarea(datosTarea[0], datosTarea[1], datosTarea[2]);
        db.add(tarea);
        mostrarTareasActuales(db);
    }

    /**
     * Este metodo nos ayuda a modificar alguna de nuestras tareas mediante el id de la tarea
     * @param entrada
     * @param db
     */
    public static void modificarTarea(Scanner entrada, ArrayList<Tarea> db){
        String  valor;
        int idEncontrado;
        System.out.println("==============================================");
        System.out.println("Ingrese el id de la tarea a modificar: ");
        valor = entrada.next();
        valor = validarId(valor, entrada);
        idEncontrado = encontraId(db, valor);
        validarIdDentroRango(idEncontrado, valor, entrada, db);
        System.out.println("Ingrese el nombre de la tarea: ");
        db.get(idEncontrado).setNombreTarea(entrada.next());
        System.out.println("Ingrese descripcion de la tarea: ");
        db.get(idEncontrado).setDescripcion(entrada.next());
        mostrarTareasActuales(db);
    }

    /**
     * Este metodo nos ayuda a eliminar alguna tarea del usuario mediante el id de la tarea
     * @param entrada
     * @param db
     */

    public static void eliminarTarea(Scanner entrada, ArrayList<Tarea> db){
        String valor;
        int idEncontrado;
        System.out.println("==============================================");
        System.out.println("Ingrese el id de la tarea a eliminar: ");
        valor = entrada.next();
        valor = validarId(valor, entrada);
        idEncontrado = encontraId(db, valor);
        validarIdDentroRango(idEncontrado, valor, entrada, db);
        db.remove(idEncontrado);
        mostrarTareasActuales(db);
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
                System.out.println("Valor no aceptado");
                valor = entrada.next();

            } while (!valor.matches(validar));
        }
        return valor;
    }

    /**
     * Este metodo nos ayuda a desplegar en consola las tareas que el usuario tiene hasta el momento
     * @param db
     */

    public static void mostrarTareasActuales(ArrayList<Tarea> db){
        for (int i = 0; i < db.size(); i++){
            if (db.get(i) != null){
                db.get(i).display();
            }
        }
    }

    /**
     * Este metodo nos ayuda a encontrar en index en el que se encuentra la tarea a modificar/eliminar en base a su atributo id
     * @param db
     * @param valor
     * @return
     */
    public static int encontraId(ArrayList<Tarea> db, String valor){
        int idEncontrado = -1;
        for (Tarea tarea : db){
            if (tarea.getIdTarea().equals(valor)){
                idEncontrado = db.indexOf(tarea);
                return idEncontrado;
            }
        }
        return idEncontrado;
    }

    /**
     * Este metodo nos ayuda a asegurar que el id ingresado por el usuario este dentro de nuestra base de datos de tareas
     * de otro modo solicitara un valido
     * @param idEncontrado
     * @param valor
     * @param entrada
     * @param db
     * @return
     */
    public static int validarIdDentroRango(int idEncontrado, String valor, Scanner entrada, ArrayList<Tarea> db){
        if (idEncontrado == -1){
            do {
                System.out.println("Id de tarea no encontrado porfavor digite un id valido");
                valor = entrada.next();
                valor = validarId(valor, entrada);
                idEncontrado = encontraId(db, valor);

            } while (idEncontrado == -1);
            return idEncontrado;
        }else {
            return idEncontrado;
        }
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public String getIdTarea() {
        return idTarea;
    }
}
