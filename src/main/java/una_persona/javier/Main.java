package una_persona.javier;

/**
 * Clase principal
 *
 * @version 04/07/2023/B
 */
public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Juan", "Perez", 12345678, "04/07/1945");
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
