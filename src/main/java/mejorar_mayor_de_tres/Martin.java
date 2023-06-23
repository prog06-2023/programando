import java.util.Scanner;

public class Martin {
    public static void main(String[]args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresar un numero que represente la cantidad de numeros de la cual desea saber cual es el mayor.");
        int cantidadNumeros = teclado.nextInt();
        int mayor = 0;
        int i = 0;
        
        
        while (i < cantidadNumeros) {
            System.out.println("Ingrese el número #" + (i + 1) + ": ");
            int numero = teclado.nextInt();
            if (numero > mayor) {
                mayor = numero;
            } //Si "numero" es mayor que "mayor" el valor de "mayor" se actualiza a el nuevo "numero" ingresado
            i++;
        }

        System.out.println("El número mayor es: " + mayor);

        teclado.close();
    }
}