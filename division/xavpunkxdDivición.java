public class xavpunkxdDivición {
     public static void main(String[] args){
        int dividendo = 13;
        int resultado=0;
        int contador= 0;

        while (resultado < dividendo){
            resultado = (2*contador);
            contador++;            
        }

        System.out.print(contador-1);
     }
}