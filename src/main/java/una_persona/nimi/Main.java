package una_persona.nimi;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.setNombre("Daniel");
        persona.setApellido("Ledesma");
        persona.setFechaNacimiento("23/05/1995");

        System.out.println(persona);
        System.out.println("Edad: " + persona.calcularEdad());


        int diasParaCumple = persona.diasParaCumple();

        if (diasParaCumple == 0){
            System.out.println("Feliz Cumpleaños!!");
        }else{
            System.out.printf("Faltan %s dias para tu cumpleaños%n", diasParaCumple);
        }

    }
}
