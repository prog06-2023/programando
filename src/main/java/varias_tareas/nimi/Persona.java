package varias_tareas.nimi;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.1
 * @author Edgar Tuyarot
 */
public class Persona {

    private String nombre;
    private String apellido;
    private List<Tarea> tareas;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tareas = new ArrayList<>();
    }

    public Persona() {
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

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return "La persona se llama " + nombre +" "+ apellido + " y sus tareas son: " + tareas;
    }

}
