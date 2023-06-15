import java.util.Scanner;

class EjercicioDivision {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ingrese el número que desea dividir: ");
			
	        int dividendo = scanner.nextInt();
	        
	    System.out.print("Ingrese por cuanto desea dividirlo: ");
	        int divisor = scanner.nextInt();
	        
	        int cociente = 0;
		        while (dividendo >= divisor) {
		            dividendo -= divisor;
		            cociente++;
		        }
	        
	        int residuo = dividendo;
	        
	        System.out.println("Cociente: " + cociente);
	        System.out.println("Residuo: " + residuo);
	        scanner.close();
	    }
	}
