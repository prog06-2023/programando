package division;
import java.util.Scanner;

public class Fernando {
    public static void main(String[] args) {
        //variables
        int signo;
        float resultado;
        float cociente2 = 0;
        float cociente = 0;
        float[] valores = new float[3];
        float[] dec = new float[5];
        float decimal = 0;

        System.out.println("Ingrese el dividendo, divisor y numero de decimales que deseé (max. 5) en ese orden");
        for (int i = 0; i < 3;i++){
            valores[i] = ingresarValor();
        }

        //excepcion disivion /0
        while (valores[1] == 0){
            System.out.println("Por favor elija otro numero ya que la division entre cero no se puede");
            valores[1] = ingresarValor();
        }
        //Asignacion de signo
        signo = signo(valores[0], valores[1]);
        valores[0] = absoluto(valores[0]);
        valores[1] = absoluto(valores[1]);

        //Division
        while (valores[0] >= valores[1]) {
            valores[0] = valores[0] - valores[1];
            cociente++;
        }
        if(valores[0]!=0) {
            for (int i = 0; i<valores[2] ; i++) {
                valores[0] = valores[0] * 10;
                while (valores[0] >= valores[1]) {
                    valores[0] = valores[0] - valores[1];
                    cociente2++;
                }
                dec[i] = (float) (cociente2*(Math.pow(0.1,i+1)));
                decimal = decimal + dec[i];
                cociente2 = 0;
            }
        }

        //Resultado de division
        resultado = (cociente + decimal)*signo;

        System.out.println("El resultado de su division es:" + resultado);

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
    public static float absoluto(float num){
        num = Math.abs(num);
        return num;
    }
    public static int signo(float num, float num2){
        int signo;
        if((num < 0 && num2 < 0) || (num > 0 && num2 > 0) ){
            signo = 1;
        } else{
            signo = -1;
        }
        return signo;
    }
}
