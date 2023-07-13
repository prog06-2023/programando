package una_persona.martin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        persona.setNombre(nombre);

        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        persona.setApellido(apellido);

        int intentos = 3;
        boolean fechaValida = false;

        do {
            System.out.print("Ingrese fecha de nacimiento (dd/MM/yyyy): ");
            String fechaNacimiento = scanner.nextLine();

            if (validarFormatoFecha(fechaNacimiento)) {
                persona.setFechaNacimiento(fechaNacimiento);
                fechaValida = true;
            } else {
                intentos--;
                System.out.println("Formato de fecha incorrecto. Intentos restantes: " + intentos);
            }

            if (intentos == 0) {
                System.out.println("Ponele voluntad, volvé a correr el código ahora... GIL");
                return;
            }
        } while (!fechaValida);

        System.out.println("Datos de la persona:");
        System.out.println(persona.toString());
        int edad = persona.calcularEdad();
        System.out.println("Edad: " + edad + " años");

        int diasFaltantes = persona.obtenerDiasParaCumpleanios();

        if (diasFaltantes == 0) {
            System.out.println("¡Tu cumpleaños es hoy! ¡Feliz cumpleaños! 😄");
        } else {
            System.out.println("Faltan " + diasFaltantes + " días para tu cumpleaños");
        }
    }

    public static boolean validarFormatoFecha(String fecha) {
        String formatoFecha = "\\d{2}/\\d{2}/\\d{4}";
        return fecha.matches(formatoFecha);
    }
}
