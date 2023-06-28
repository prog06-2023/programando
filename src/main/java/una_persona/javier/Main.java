package una_persona.javier;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Juan", "Perez", 12345678, 1945);
        System.out.println(persona1.toString() + " Tiene: "
                + persona1.calcularEdad(persona1.getAnhoNacimiento())
                + " años");

    }
}
