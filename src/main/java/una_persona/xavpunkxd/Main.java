package una_persona.xavpunkxd;

public class Main {
    public static void main(String[] args) {
        
        //constructor con parametros
        Persona persona2 = new Persona("Esteban","Juarez",03,1997,1);
        
        System.out.println("\n" +"Hola "+persona2.getName()+" "+persona2.getLastname()); 
        System.out.println("tu fecha de nacimiento es el dia: "+persona2.getBirthday()+ " del mes "+ persona2.getBorn_mounth() + " del año "+persona2.getBornyear());
        persona2.calculateBirthay();

        //imprimiendo usando el toString
        //si cambias la fecha se actualiza ;)
        Persona persona3 = new Persona("Jorge","Perez",07,1996,3);

        System.out.println("\nImprimiendo con el uso de toString: ");
        System.out.println(persona3.toString()+"\n");
        persona3.calculateBirthay();
    }

}
