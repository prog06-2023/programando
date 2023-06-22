package mayor_de_tres;

import java.util.Scanner;

public class EdgarT {
    public static void main(String[] args) {
        int num1, num2, num3, mayor;


        Scanner lector = new Scanner(System.in);
        System.out.println("ingrese 3 numeros");
        num1 = lector.nextInt();
        num2 = lector.nextInt();
        num3 = lector.nextInt();

        if (num1>num2){
            mayor = num1;
        }else{
            mayor = num2;
        }
        if (num3>num2){
            mayor = num3;
        }

        if ((num3==num1) && (num2==num3)){
            System.out.println("Todos los numeros son iguales");
        }else{
            System.out.println("mayor = " + mayor);
        }



    }
}
