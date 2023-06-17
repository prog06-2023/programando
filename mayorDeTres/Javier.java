import java.util.Scanner;

public class Javier {
    public static void main(String[] args) {
        
         Scanner scanner = new Scanner(System.in);
        
        int numerosEntrada[] = new int[3];
        int mayor = 0;
           
        for (int i=0; i < numerosEntrada.length; i++){
            System.out.println("ingrese un numero por favor: ");
            numerosEntrada[i] = scanner.nextInt();
            if (numerosEntrada[i] > mayor){
                mayor = numerosEntrada[i];
                }
            }
        System.out.println(mayor);
        
        scanner.close();
    }

}
    