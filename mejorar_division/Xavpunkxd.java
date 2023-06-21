package mejora_de_la_divicion;

import java.util.Scanner;

public class Xavpunkxd {
     /**
     * @param args
     */
    public static void main(String[] args){
        
       Scanner scanner = new Scanner(System.in);
        double numero;
        double resto=0;
        

        System.out.print("Ingresa un número: ");

        // Verificar si el input es un número (entero o decimal)
        if (scanner.hasNextDouble()) {
            numero = scanner.nextDouble();

            // Utilizar el número en el bucle while
            int contador = 1;
            int resultado=0;
            
            while (resultado < numero) {
                resultado = (2*contador);
                contador++; 
            }

            if(resultado != numero){
                resto = resultado - numero;
                System.out.print("el resultado de la divición es: "+(contador-1)+"y me sobra: "+ resto);    
            }else{
                System.out.print("el resultado de la divición es: "+(contador-1)+"y me sobra: "+ resto);
            }

            
             
        } else {
            System.out.println("El input no es un número válido.");
        }
        
       

        scanner.close();
     }
}
