package mayor_de_tres;

import java.util.Scanner;
public class Martin {
    public static void main(String[]args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese número");
        int numeroUno = teclado.nextInt();
        System.out.println("Ingrese número");
        int numeroDos = teclado.nextInt();
        System.out.println("Ingrese número");
        int numeroTres = teclado.nextInt();

        if (numeroUno > numeroDos && numeroUno > numeroTres){
            System.out.println("El número mayor es: " + numeroUno);
        }

        if (numeroDos > numeroUno && numeroDos > numeroTres){
            System.out.println("El número mayor es: " + numeroDos);
        }

        if (numeroTres > numeroDos && numeroTres > numeroUno){
            System.out.println("El número mayor es: " + numeroTres);
        }

        teclado.close();
    }

}