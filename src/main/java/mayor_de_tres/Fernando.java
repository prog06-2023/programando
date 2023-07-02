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

    public static float validacion(Scanner entrada){
        if (!entrada.hasNextFloat()){
            System.out.println("Entrada no valida");
            ingresarValor();
            return 0;
        }else {
            return entrada.nextFloat();
        }

    }
    public static float ingresarValor(){
        float num;
        Scanner entrada = new Scanner(System.in);
        num = validacion(entrada);
        return num;
    }
}
