/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package varias_tareas.javier;

import java.util.ArrayList;

/**
 * 
 * @author schja
 * @version 1.1
 */
public class Tarea {

    public static int totales = 0;

    private String nombre;

    private String descripcion;
    private String realizada;
    private int idTarea;

    public Tarea() {
    }

    public Tarea(String nombre, String descripcion, String realizada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.realizada = realizada;
        Tarea.totales++;
        this.idTarea = Tarea.totales;
    }

    public Tarea(int id, String nombre, String descripcion, String realizada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.realizada = realizada;
        this.idTarea = id;
    }

    public int getId() {
        return this.idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRealizada() {
        return realizada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRealizada(String realizada) {
        this.realizada = realizada;
    }

    @Override
    public String toString() {
        return "Tarea nro: " + this.idTarea
                + " Titulo: " + this.nombre
                + " Descripcion: " + this.descripcion
                + " Estado: " + this.realizada;
    }
    

    /**
     * Metodo que permite agregar una tarea.
     * @param tarea
     * @param tareas
     */
    public void agregarTareas(Tarea tarea, ArrayList tareas) {
        tareas.add(tarea);
    }

    /**
     * Metodo que permite eliminar una tarea.
     * @param id 
     * @param tareas
     */
    public void eliminarTarea(int id, ArrayList<Tarea> tareas) {
        int indiceTarea = id - 1;
        tareas.remove(indiceTarea);

    }

    /**
     * Metodo que permite modificar una tarea.
     * @param tareas
     * @param tarea
     */
    public void modificarTarea(ArrayList<Tarea> tareas, Tarea tarea) {

        for (Tarea tar : tareas) {
            if (tar.getId() == tarea.getId()) {
                tar.setNombre(tarea.getNombre());
                tar.setDescripcion(tarea.getDescripcion());
                tar.setRealizada(tarea.getRealizada());
            }
        }
    }

}
