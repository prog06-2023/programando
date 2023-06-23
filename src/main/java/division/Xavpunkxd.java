package division;

public class Xavpunkxd {
     public static void main(String[] args){
        double dividendo = 10;
        double resultado=0;
        double contador= 0;

        while (resultado < dividendo){
            resultado = (2*contador);
            contador++;            
        }

         if (resultado != dividendo){
                 System.out.println("el resultado de la divicion es impar por lo que  incluye decimales");
             }else{
                 System.out.print(contador-1);
             }
     }
}