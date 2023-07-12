package una_persona.edgarT;
public class Main {

    public static void main(String[] args) {
        int edad, diasCumple;

        Persona edgar = new Persona("Edgar","Tuyarot","Argentina","03/07/1989");

        System.out.println(edgar);

        edad = edgar.calcularEdad();

        diasCumple = edgar.diasParaElCumple();

        if (diasCumple == 0){
            System.out.println("Feliz Cumpleaños");
        }else{
            System.out.println("Dias para tu cumple: "+diasCumple);
        }

    }
}
