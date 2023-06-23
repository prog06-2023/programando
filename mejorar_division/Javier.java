// Autor: Javier

import java.util.InputMismatchException;
import java.util.Scanner;

public class Javier {
    public static void main(String[] args) {
       
            Scanner scanner = new Scanner(System.in);
            int miNumero;
            int divisor;
            int dividendo;
            int resto = 0;
            int cociente = 0;
            boolean seguir = true;
           
            while (seguir) {
            try {
                seguir = false;
                System.out.println("Por favor ingrese el nro. a dividir: ");
                miNumero = scanner.nextInt();
                dividendo = miNumero;
                System.out.println("Por Favor ingrese el nro. divisor: ");
                divisor = scanner.nextInt();

                while (dividendo >= divisor) {
                    dividendo = dividendo - divisor;
                    resto = dividendo;
                    cociente++;
                    }
                System.out.println("El resultado de " + miNumero + " dividido " + divisor + " es: " + cociente + " y su resto es: " + resto);
                
                }
            catch (InputMismatchException exception){
                System.out.println("Se deben ingresar SOLO nros. enteros! Intentelo nuevamente:");
                scanner.next();
                seguir = true;
            }
            }
        }
}
