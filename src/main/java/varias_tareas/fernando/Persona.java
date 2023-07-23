package varias_tareas.fernando;

/**
 * Esta clase sirve para instanciar a un objeto de tipo persona
 * @version 1.0
 * @author Fernando García Cano
 */
public class Persona {
    private String nombre;
    private String apellido;

    /**
     * Instancia una nueva persona sin parametros
     */
    public Persona(){

    }

    /**
     * Instancia una nueva persona con parametros
     * @param nombre
     * @param apellido
     */
    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
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
}
