package una_persona.Fernando;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Esta clase define una persona
 *
 * @version 1.0
 * @date 09/07/2023
 */
public class Persona {
    //variables a utilizar
    private String nombre;
    private String ocupacion;
    private String fechaNacimiento;

    //constructor sin parametros
    public Persona(){
        this.nombre = "Sin especificar";
        this.ocupacion = "Sin especicar";
        this.fechaNacimiento = "1/1/1900";
    }
    //constructor con parametros
    public Persona(String nombre, String ocupacion, String fechaNacimiento){

        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.fechaNacimiento = fechaNacimiento;
    }

    //getters & setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //conversor de string a formato LocalDate
    public LocalDate convertToLocalDate(String fechaNacimiento){

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(fechaNacimiento,formato);

    }
    //Obtencion de la edad y dias restantes acorde a la fecha ingresada
    public int[] getEdad(LocalDate fechaNacimiento){
        int[] edad = new int[2];
        int restantes = fechaNacimiento.getDayOfYear() - LocalDate.now().getDayOfYear();
        edad[1] = restantes;
        if(restantes >= 1){
            edad[0] = LocalDate.now().getYear() - fechaNacimiento.getYear() - 1;
        }else {
            edad[0] = (LocalDate.now().getYear() - fechaNacimiento.getYear());
        }

        return edad;
    }
    //validacion de formato de fecha
    public String validacionFormato(String fechaNacimiento){
        boolean isValid = fechaNacimiento.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}");
        if (!isValid){
            do{
                System.out.println("Formato de fecha no valido porfavor ingrese acorde al estandar dd/MM/yyyy");
                Scanner entrada = new  Scanner(System.in);
                fechaNacimiento = entrada.next();
                isValid = fechaNacimiento.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}");

            }while (!isValid);
        }
        return fechaNacimiento;
    }
    public String toString(LocalDate fechaNacimiento){
        int[] edad;
        String felicitacion = "";
        edad = getEdad(fechaNacimiento);
        if (edad[1]==0){
            felicitacion = "(Happy Birthday!!!)";
        }
        return ("Hola "+ getNombre() + " de ocupacion: " + getOcupacion() + ", acorde a los datos ingresados tienes: " + edad[0] + " y faltan " + edad[1] + " dias " + " para tu siguiente cumpleanos " + felicitacion);
    }

}