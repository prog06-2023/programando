package una_persona.xavpunkxd;

public class Main {
    public static void main(String[] args) {
        //imprimiendo persona sin parametros
       /* Persona persona = new Persona();
        
        System.out.println("Hola "+persona.getName()+persona.getLastname()); 
        System.out.println("tu fecha de nacimiento es: "+ persona.getBorn_mounth() + " del año "+persona.getBornyear());
        System.out.println("y el año actual es: "+ persona.getActualyear() + " por lo que tu edad es: " + persona.calcularedad());*/
        
        //constructor con parametros
        Persona persona2 = new Persona("Esteban","Juarez","marzo",1997,2023);
        
        System.out.println("\n" +"Hola "+persona2.getName()+" "+persona2.getLastname()); 
        System.out.println("tu fecha de nacimiento es: "+ persona2.getBorn_mounth() + " del año "+persona2.getBornyear());
        System.out.println("y el año actual es: "+ persona2.getActualyear() + " por lo que tu edad es: " + persona2.calcularedad());

        //imprimiendo usando el toString
        Persona persona3 = new Persona("Jorge","Perez","diciembre",1996, 2023);

        System.out.println("\nImprimiendo con el uso de toString: ");
        System.out.println(persona3.toString()+"\n");
    }

}
