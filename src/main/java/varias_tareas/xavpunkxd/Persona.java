package varias_tareas.xavpunkxd;
import java.util.Scanner;

public class Persona {
    //variables 
    private Scanner TellName;
    private String name;
    
    //this method is asking for a name of the user 
    public void AskName(){
        System.out.println("Bienvenido usuario! Por favor ingresa tu nombre ");
        
        //calling the scanner fot name
        TellName = new Scanner(System.in);
        name = TellName.nextLine();

        System.out.println("Hola "+ name + " Selecciona la acción que desear hacer\n");

        //calling method Task
        Tasks();
    }

    public void Tasks(){
        //here is creating a new objet to use the method selection of task
        ListaDeTareas nuevatask = new ListaDeTareas();
        nuevatask.SelectAction();
    }
    
    //closing the first Scanner
    public void Closeall(){
        TellName.close();
    }

    
}
