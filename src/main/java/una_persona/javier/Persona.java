package una_persona.javier;

import java.util.Calendar;

public class Persona {

    private String nombre;
    private String apellido;
    private int numeroDocumento;
    private int anhoNacimiento;

//    constructor con argumentos 
    public Persona(String nombre, String apellido, int nroDocumento, int anhoNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = nroDocumento;
        this.anhoNacimiento = anhoNacimiento;

    }

//    construcctor sin argumentos
    public Persona() {
    }

//    getters and setters
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

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getAnhoNacimiento() {
        return anhoNacimiento;
    }

    public void setAnhoNacimiento(int anhoNacimiento) {
        this.anhoNacimiento = anhoNacimiento;
    }

// toString
    @Override
    public String toString() {

        return "Nombre: " + this.nombre + " Apellido: " + this.apellido + " Nacido en: "
                + this.anhoNacimiento + " Nro. de Documento: " + this.numeroDocumento;
    }

//metodo para calcular la edad
    public int calcularEdad(int anhoNacimiento) {
        Calendar calendario = Calendar.getInstance();
        int anhoActual = calendario.get(Calendar.YEAR);

        return anhoActual - anhoNacimiento;
    }

}
