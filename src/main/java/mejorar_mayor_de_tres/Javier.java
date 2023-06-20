package mejorar_mayor_de_tres;

import java.util.Scanner;

public class Javier {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Cuantos numeros vamos a comparar?: ");
        int nroDeVeces = teclado.nextInt();
        int iteraciones = 0;
        int mayor = Integer.MIN_VALUE;

        while (iteraciones < nroDeVeces) {
            System.out.println("Agregue un numero para comparar: ");
            int nroIngresado = teclado.nextInt();
            
            if (nroIngresado > mayor) {
                mayor = nroIngresado;
            }

            iteraciones++;

        }
        System.out.println("El mayor de todos los nros. ingresados es: " + mayor);

    }
}
