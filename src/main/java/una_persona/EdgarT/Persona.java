package una_persona.EdgarT;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Persona {

    private String nombre;
    private String apellido;
    private String pais;
    private String fechaNacimiento;

    public Persona(String nombre, String apellido, String pais, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona() {
        this.nombre = "nombre";
        this.apellido = "apellido";
        this.pais = "pais";
        this.fechaNacimiento = "01/01/1990";
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

    public void calcularEdad(){
        //Setear formato
        DateTimeFormatter isoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Setear la variable fechaNac con el string de fecha
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento,isoFecha);

        //Verificar si ya cumplio años, en el año en curso
        if (LocalDate.now().getDayOfYear() >= fechaNac.getDayOfYear()){
            System.out.println("Edad: " +(LocalDate.now().getYear()-fechaNac.getYear()));

        }else{
            System.out.println("Edad: " + (( LocalDate.now().getYear()-fechaNac.getYear())- 1));
        }

    }
}
