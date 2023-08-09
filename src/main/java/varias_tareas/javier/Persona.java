/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package varias_tareas.javier;

import java.util.ArrayList;

/**
 *
 * @author schja
 */
public class Persona {

    private String nombre;
    private String apellido;
    private ArrayList<Tarea> tareas;

    /**
     * Constructor con parametros.
     *
     * @param nombre
     * @param apellido
     */
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tareas = new ArrayList();
    }

    /**
     * contructor sin parametros
     */
    public Persona() {
    }

    // Getters y Setters
    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Tarea tarea) {
        this.tareas.add(tarea);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return nombre y apellido de la persona con sus tareas.
     */
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Apellido: " + this.apellido + " Lista de Tareas: " + this.tareas.toString();

    }

    public void agregarTareas(Tarea tarea, ArrayList tareas){ 
        tareas.add(tarea);
    }

    public Tarea getTareaPorId(int id, ArrayList<Tarea> tareas) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                return tarea;
            }
        }
        return null;

    }
    
    public void eliminarTarea(int id, ArrayList<Tarea> tareas){
        int indiceTarea = id - 1;
        tareas.remove(indiceTarea);
    
    }

    public void modificarTarea(int id, ArrayList<Tarea> tareas, Tarea tarea) {
        Tarea tareaModificada = new Tarea(id, tarea.getNombre(), tarea.getDescripcion(), tarea.isRealizada());
        
        for (Tarea tar : tareas) {
            if (this.getTareaPorId(id, tareas) != null) {
                tar = tareaModificada;
                
            }       
        }
        tareas.add(id - 1, tareaModificada);
        this.eliminarTarea(id, tareas);
    }
}
