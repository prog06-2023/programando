package mayor_de_tres;

import java.util.Scanner;

class Nimi {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese primer número");
        int numeroUno = teclado.nextInt();
        System.out.println("Ingrese segundo número");
        int numeroDos = teclado.nextInt();
        System.out.println("Ingrese tercer número");
        int numeroTres = teclado.nextInt();

        if (numeroUno > numeroDos && numeroUno > numeroTres){
            System.out.println("El número mayor es: " + numeroUno);
        }else if (numeroDos > numeroTres){
            System.out.println("El número mayor es: " + numeroDos);
        }else{
            System.out.println("El número mayor es: " + numeroTres);
        }

        teclado.close();
    }
}