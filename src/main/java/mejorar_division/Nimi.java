package mejorar_division;

import java.util.Scanner;

class Nimi {
    public static void main(String[] args) {
        int nro1 = 0;
        int nro2 = 0;

        int dividendo = 0;
        int divisor = 0;
        int cociente = 0;
        int resto = 0;

        boolean reintentar = true;
        while (reintentar){
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Ingrese el número que desea dividir: ");
                nro1 = scanner.nextInt();

                System.out.print("Ingrese por cuanto desea dividirlo: ");
                nro2 = scanner.nextInt();

                scanner.close();

                dividendo = nro1;
                divisor = nro2;

                reintentar = false;
            }catch (Exception e){
                System.out.print("Solo se pueden dividir numeros");
            }
        }

        if (divisor == 0){
            System.out.print("No se puede dividir entre cero");
            return;
        }

        cociente = 0;
        while (dividendo >= divisor) {
            dividendo = dividendo - divisor;
            cociente++;
        }

        resto = dividendo;

        System.out.println(nro1 + "/" + nro2 + " = " + cociente + ". El resto: " + resto);

    }
}