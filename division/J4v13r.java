public class Javier {
    
    public static void main(String[] args) {
       
            int miNumero = 20;
            int divisor = 2;
            int dividendo = miNumero;
            int resto = 0;
            int cociente = 0;
            
            while (dividendo >= divisor) {
                dividendo = dividendo - divisor;
                resto = dividendo;
                cociente++;
        }
            System.out.println("El resultado de " + miNumero + " dividido " + divisor + " es: " + cociente + " y su resto es: " + resto);
    }
}
