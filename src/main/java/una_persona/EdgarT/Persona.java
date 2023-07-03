package una_persona.EdgarT;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase persona, donde se adminte nombre apellido nacionalidad y fecha de nacimiento en formato "dd/mm/yyyy"
 * @author: Edgar Tuyarot
 * @version: 03/07/2023B
 */

public class Persona {

    private String nombre;
    private String apellido;
    private String pais;
    private String fechaNacimiento;

    /**
     * @param nombre String, nombre de la persona
     * @param apellido String, apellido de la persona
     * @param pais String,Pais de nacimiento de la persona
     * @param fechaNacimiento String, Fecha de nacimiento: formato dd/MM/yyyy
     */
    public Persona(String nombre, String apellido, String pais, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.pais = "";
        this.fechaNacimiento = "";
    }
    @Override
    public String toString() {
        return "La persona se llama " + nombre +" "+ apellido + " es de "+ pais + ". Nacio el "+fechaNacimiento;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPais() {
        return pais;
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

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Metodo para calcular edad segun fecha de nacimiento
     * @return Entero, con la edad de la persona
     */
    public Integer calcularEdad(){
        //Setear formato
        DateTimeFormatter isoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Setear la variable fechaNac con el string de fecha
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento,isoFecha);

        //Verificar si ya cumplio años, en el año en curso
        if (LocalDate.now().getDayOfYear() >= fechaNac.getDayOfYear()){

            System.out.println("Edad: " +(LocalDate.now().getYear()-fechaNac.getYear()));
            return (LocalDate.now().getYear()-fechaNac.getYear());

        }else{
            System.out.println("Edad: " + (( LocalDate.now().getYear()-fechaNac.getYear())- 1));
            return  (( LocalDate.now().getYear()-fechaNac.getYear())- 1);
        }

    }


    /**
     * Retorna los dias faltantes para un nuevo cumpleños o 0 si es el cumpleaños
     * @return Integer
     */
    public Integer diasParaElCumple(){
        //Setear formato
        DateTimeFormatter isoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Setear la variable fechaNac con el string de fecha
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento,isoFecha);

        //Restar dias
        int diasCumeple =   fechaNac.getDayOfYear() - LocalDate.now().getDayOfYear();

        if(diasCumeple>=0){
            return diasCumeple;
        }else{
            diasCumeple = (365 - LocalDate.now().getDayOfYear())+fechaNac.getDayOfYear();
            return diasCumeple;
        }

    }
}
