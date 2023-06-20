package mejorar_mayor_de_tres;

import java.util.Scanner;

class Nimi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese cantidad de numeros a comparar");
        int cantidad = scanner.nextInt();
        int mayor = Integer.MIN_VALUE;

        while (cantidad != 0) {
            System.out.println("Agregue un numero para comparar: ");
            int nroIngresado = scanner.nextInt();

            if (nroIngresado > mayor) {
                mayor = nroIngresado;
            }

            cantidad--;
        }
        System.out.println("El mayor de todos los nros. ingresados es: " + mayor);

    }
}