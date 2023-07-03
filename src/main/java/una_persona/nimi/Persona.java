package una_persona.nimi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @version: 1
 */

public class Persona {

    private String nombre;
    private String apellido;
    private String fechaNacimiento;

    public Persona(String nombre, String apellido, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.fechaNacimiento = "";
    }
    @Override
    public String toString() {
        String template = """
                    Nombre: %s
                    Apellido: %s
                    Fecha de nacimiento: %s
                """;
        return String.format(template, nombre, apellido, fechaNacimiento);
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public int calcularEdad(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento,formatter);

        if (LocalDate.now().getDayOfYear() >= fechaNac.getDayOfYear()){
            return LocalDate.now().getYear() - fechaNac.getYear();
        }else{
            return LocalDate.now().getYear()-fechaNac.getYear() - 1;
        }
    }

    public int diasParaCumple(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento,formatter);

        int diasCumeple = fechaNac.getDayOfYear() - LocalDate.now().getDayOfYear();

        if (diasCumeple < 0) {
            diasCumeple = (365 - LocalDate.now().getDayOfYear()) + fechaNac.getDayOfYear();
        }
        return diasCumeple;
    }
}

