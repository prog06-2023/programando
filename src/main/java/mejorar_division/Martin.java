package mejorar_division;

import java.util.Scanner;

public class Martin {
    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int dividendo, divisor;
	        boolean esEntero;

	        /* Ingreso del dividendo: Y sí, tuve que investigar más sobre la clase scanner y si, aplique DO WHILE
	        así siento que no lo estudié al pedo*/
	        do {
	            System.out.print("Ingrese el número que desea dividir: ");
	            esEntero = scanner.hasNextInt();
	            if (!esEntero) {
	                System.out.println("¡Ingresar solo números!");
	                scanner.next();
	            }
	        } while (!esEntero);
	        dividendo = scanner.nextInt();

	        // Ingreso del divisor
	        do {
	            System.out.print("Ingrese por cuanto desea dividirlo: ");
	            esEntero = scanner.hasNextInt();
	            if (!esEntero) {
	                System.out.println("¡Ingresar solo números!");
	                scanner.next();
	            }
	        } while (!esEntero);
	        divisor = scanner.nextInt();

	        // Se realiza la división una vez validado los datos ingresados
	        int cociente = 0;
	        while (dividendo >= divisor) {
	            dividendo -= divisor;
	            cociente++;
	        }
	        int residuo = dividendo;

	        // Resultados
	        System.out.println("Cociente: " + cociente);
	        System.out.println("Residuo: " + residuo);

	        scanner.close();
	    }
	}

