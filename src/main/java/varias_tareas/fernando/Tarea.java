package varias_tareas.fernando;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase sirve para instanciar a un objeto de tipo Tarea
 * @version 1.3
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
     * @param tarea
     * @param db
     */
    public static void agregarTarea(Tarea tarea, ArrayList<Tarea> db){
        db.add(tarea);
        mostrarTareasActuales(db);
    }

    public static void modificarTarea(String[] datosTarea, int idEncontrado, ArrayList<Tarea> db) {
        db.get(idEncontrado).setNombreTarea(datosTarea[0]);
        db.get(idEncontrado).setDescripcion(datosTarea[1]);
        Tarea.mostrarTareasActuales(db);

    }


    /**
     * Este metodo nos ayuda a eliminar alguna tarea del usuario mediante el id de la tarea
     * @param idEncontrado
     * @param db
     */

    public static void eliminarTarea(int idEncontrado, ArrayList<Tarea> db){
        db.remove(idEncontrado);
        mostrarTareasActuales(db);
    }

    /**
     * Este metodo nos ayuda avalidar que la entrada del usuario solo sean numeros
     *
     * @param valor
     * @return
     */
    public static boolean validarId(String valor){
        String validar = "^[0-9]*";
        return valor.matches(validar);
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
        if (db.isEmpty()){
            System.out.println("No hay tareas actualmente");
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
        if (db.isEmpty()){
            return idEncontrado = 0;
        }
        return idEncontrado;
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

    public static int getId() {
        return id;
    }
}
