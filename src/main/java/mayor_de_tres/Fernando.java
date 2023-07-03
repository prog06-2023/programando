package mayor_de_tres;
import java.util.Scanner;

public class Fernando {
    public static void main(String[] args) {
        float maxNum = 0;
        float num;
        float numeroComparar;

        System.out.println("Ingresar un numero que represente la cantidad de numeros de la cual desea saber cual es el mayor."
        +'\n'+"Si ingresa numeros negativos se contaran como positivos");
        numeroComparar = ingresarValor();
        if (numeroComparar<0){
            numeroComparar = Math.abs(numeroComparar);
        }
        System.out.println("ingresar numeros");
        for (int i = 0; i < numeroComparar; i++){
            num = ingresarValor();
            if(i==0){
                maxNum = num;
            }
            if (maxNum<=num){
                maxNum = num;
            }
        }
        System.out.println("el mayor es: " + maxNum);
    }

    public static boolean validacion(Scanner entrada){
        return !entrada.hasNextFloat();

    }
    public static float ingresarValor(){
        float num;
        boolean validacion;
        Scanner entrada = new Scanner(System.in);
        validacion = validacion(entrada);
        if (validacion) {
            do {
                System.out.println("no valido");
                entrada = new Scanner(System.in);
                validacion = validacion(entrada);
            } while (validacion);
        }
        num = entrada.nextFloat();

        return num;
    }
}
