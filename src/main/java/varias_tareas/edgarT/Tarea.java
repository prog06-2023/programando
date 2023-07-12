package varias_tareas.edgarT;

import java.util.Arrays;

/**
 * @version 1.0
 * @author Edgar Tuyarot
 *
 */
public class Tarea {
    private int id;
    private String descripcion;

    /**
     * @param id Entero mayor que 0
     * @param descripcion String
     */
    public Tarea(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Tarea(){
        this.id=0;
        this.descripcion="";
    }
    @Override
    public String toString() {
        return id+"-"+descripcion ;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
