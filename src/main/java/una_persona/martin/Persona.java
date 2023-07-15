package una_persona.martin;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
public class Persona {
     private String nombre;
    private String apellido;
    private String fechaNacimiento;

    public Persona(String nombre, String apellido, String fechaNacimiento){
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechaNacimiento=fechaNacimiento;
    }
    //getter and setter
    public Persona(){
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Fecha de Nacimiento: " + fechaNacimiento;
    }

    public int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fechaNacimiento = LocalDate.parse(this.fechaNacimiento, formatter);

        Period periodo = Period.between(fechaNacimiento, fechaActual);

        return periodo.getYears();
    }

    //No logré entender como contar los días del resto del año, solo me contaba del mes así que... Copie esta parte :/
    public int obtenerDiasParaCumpleanios() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNac = LocalDate.parse(fechaNacimiento,formatter);

            int faltan = fechaNac.getDayOfYear() - LocalDate.now().getDayOfYear();

            if (faltan < 0) {
                faltan = (365 - LocalDate.now().getDayOfYear()) + fechaNac.getDayOfYear();
            }
            return faltan;
        }
}
