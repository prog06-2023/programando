package mayor_de_tres;

import java.util.Scanner;

public class Xavpunkxd {
     public static void main(String[] args){

        double first=0;
        double middle=0;
        double last=0;
        
        // Create a Scanner object to read input from the console.
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their numbers.
        System.out.println("please insert three numbers");
        
        // Read the user's numbers from the console.
        System.out.println("please insert number 1");
        double num1 = scanner.nextDouble();

        System.out.println("please insert number 2");
        double num2 = scanner.nextDouble();

        System.out.println("please insert number 3");
        double num3 = scanner.nextDouble();

        if (num1>num2 && num1>num3){
            
            first = num1;            
            if(num2>num3){
                middle=num2;
                last=num3;
            }else{
                middle=num3;
                last=num2;
            }

        }else if(num1<num2 && num1<num3){
            
            last=num1;      
            if(num2>num3){
                first=num2;
                middle=num3;
            }else{
                first=num3;
                middle=num2;
            }

        }else if(num1>num2 && num1<num3 || num1>num3 && num1<num2){

            middle=num1;
            if(num2>num3){
                first=num2;
                last=num3;
            }else{
                first=num3;
                last=num2;
            }
        }

        // Print a greeting to the user.
        System.out.print("el valor mayor es:"+ first+"\n");
        System.out.print("el valor mediano es:"+ middle+"\n");
        System.out.print("el valor menor es:"+ last+"\n");

        //close the objet scanner
        scanner.close();      
     }
}