package una_persona.fernando;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Clase principal
 *
 * @version 1.1
 * @date 09/07/2023
 */
public class Main extends Persona{
    public static void main(String[] args){
        String[] datos = new String[3];

        System.out.println("Ingrese sus datos: nombre,ocupacion y fecha de nacimiento (dd/MM/yyyy)");
        for (int i = 0; i < 3; i++){
            Scanner entrada = new Scanner(System.in);
            datos[i] = entrada.next();
        }
        Persona persona = new Persona(datos[0], datos[1], datos[2]);
        persona.setFechaNacimiento(persona.validacionFormato(persona.getFechaNacimiento()));
        LocalDate fechaNacimiento = persona.convertToLocalDate(persona.getFechaNacimiento());
        System.out.println(persona.toString(fechaNacimiento));

    }
}