package una_persona.javier;

/**
 * Clase principal
 *
 * @version 2.0
 * @date 04/07/23
 */
public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Juan", "Perez", 12345678, "04/07/2000");
        System.out.println(persona1.toString() + " Tiene: "
                + persona1.calcularEdad()
                + " años");
        if (persona1.diasParaCumpleanhos() == 0) {
            System.out.println("Hoy es tu compleaños. Feliz cumpleaños!");
        } else {
            System.out.println("Para tu cumpleaños falta: " + persona1.diasParaCumpleanhos());
        }
    }
}
