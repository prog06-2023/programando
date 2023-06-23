package mayor_de_inputs;

import java.util.Scanner;

public class Xavpunkxd {
    public static void main(String[] args) {
        

        int cont = 0;
        double number;
        double mayor=0;

     // Create a Scanner object to read input from the console.
        Scanner scanner = new Scanner(System.in);
        System.out.println("please insert the amount of the numbers that you want evaluate");
    
        int list = scanner.nextInt();    

        while(cont < list){
            number= scanner.nextDouble();
                if(number > mayor){
                    mayor=number;
                }
            cont++;
        }

        System.out.println("the mayor number in your list is: "+ mayor);
    
        scanner.close();
    }
        
}
