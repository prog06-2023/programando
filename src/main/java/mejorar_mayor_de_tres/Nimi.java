package mejorar_mayor_de_tres;

import java.util.Scanner;

class Nimi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nro1;
        int copyNro1;
        int nro2;

        System.out.print("Ingrese el número que desea dividir: ");
        nro1 = scanner.nextInt();
        copyNro1 = nro1;

        System.out.print("Ingrese por cuanto desea dividirlo: ");
        nro2 = scanner.nextInt();
        
        scanner.close();

        System.out.println(nro1);
        System.out.println(nro2);

        int resultado = 0;
        while (nro1 >= nro2) {
            nro1 = nro1 - nro2;
            resultado++;
        }

        int resto = nro1;

        System.out.println("El resultado de " + copyNro1 + "/" + nro2 + " es: " + resultado + ". El resto: " + resto);

    }
}