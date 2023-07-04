package una_persona.javier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Esta clase define una persona
 *
 * @version 2.0
 * @date 04/07/23
 */
public class Persona {

    private String nombre;
    private String apellido;
    private int numeroDocumento;
    private String fechaNacimiento;

    /**
     * Construcctor con argumentos para una persona
     *
     * @param nombre String que define el nombre de la persona
     * @param apellido String que define el apellido de la persona
     * @param nroDocumento entero que define el numero de documento
     * @param fechaNacimiento String que define la fecha de nacimiento, formato
     * DD/MM/AAAA
     */

    public Persona(String nombre, String apellido, int nroDocumento, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = nroDocumento;
        this.fechaNacimiento = fechaNacimiento;

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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

// toString
    @Override
    public String toString() {

        return "Nombre: " + this.nombre + " Apellido: " + this.apellido + " Nacido en: "
                + this.fechaNacimiento + " Nro. de Documento: " + this.numeroDocumento;
    }
/**
 * metodo que convierte el String fechaNacimiento en una fecha del tipo LocalDate
 * @return una fecha de naciemiento 
 */
    public LocalDate fechaDeNacimiento() {
        DateTimeFormatter patronFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(this.fechaNacimiento, patronFecha);
        return fechaNac;
    }

    /**
     * metodo que calcula la edad de la persona
     * @return un entero que representa la edad 
     */
    
    //metodo para calcular la edad
    public int calcularEdad() {
        if (diasParaCumpleanhos() >= 0) {
            return LocalDate.now().getYear() - fechaDeNacimiento().getYear() + 1;
        } else {
            return LocalDate.now().getYear() - fechaDeNacimiento().getYear();
        }
    }

    /**
     * Metodo que calcula la cantidad de dias que faltan para que la persona cumpla años
     * @return int 
     */
    
    public int diasParaCumpleanhos() {
        int diferenciaDias = fechaDeNacimiento().getDayOfYear() - LocalDate.now().getDayOfYear();

        if (diferenciaDias < 0) {
            return diferenciaDias + LocalDate.now().lengthOfYear();
        } else {
            return diferenciaDias;
        }
    }
}
