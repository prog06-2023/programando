package varias_tareas.xavpunkxd;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTareas {
    Scanner scanner;//creating the scanner
    String action;//this variable is to save the input from action
    String ask="si";

    
    
    public void SelectAction(){
        //loop in case of the user don´t select an option valid
        while(ask.equals("si")){
             //A-add M-Modified D-delete Q-quit
            System.out.println( "Opciones: \n"+
                                "A -añadir tarea \n" + "M -modificar tarea por id \n" +
                                "D -eliminar tarea \n" + "Q -salir \n"+
                                "S -mostrar la lista de tareas \n");

            //calling the scanner for action
            scanner = new Scanner(System.in);            
            action = scanner.nextLine();
            
            //Menu to select acction
            switch (action.toLowerCase()){
                case "a":
                actionA();                
                break;
            
                case "m" :
                actionM();               
                break;
            
                case "d" :
                   actionD();             
                break;
                
                case "s":
                    actionS();
                break;
            
                case "q" :
                System.out.println("ending the loop");
                ask="no";
                break;

                default:
                System.out.println("letra no valida, Por favor ingresa una letra valida \n");
                
            }
        }
    }

    /*--the methods using the arraylist */
    private ArrayList<Tarea> ListTask ;//

    public ListaDeTareas() {
        this.ListTask = new ArrayList<>();
    }

    //add task
    private void actionA(){
        int id;
        boolean existent=false;//variable to check if the id it´s repited
        String description;
        System.out.println("Porfavor ingresa un ID para tu nueva tarea");
        id = scanner.nextInt();
        scanner.nextLine();//consumming the las character of the buffer in scanner

        if(ListTask.isEmpty()){
            System.out.println("añade una descripción");
            description= scanner.nextLine();
        
            ListTask.add(new Tarea(id, description));
            /*creating a new task to the list with id and description*/
            System.out.println("nueva tarea añadida \n");
        
        }else{
            for (Tarea allTask : ListTask) {                
                if(allTask.getId() == id){//check if the id already exists
                    System.out.println("esta id es de la tarea "+ allTask.getDescription());
                    existent=true;
                    break;
                }                    
            }

            if (!existent){//add the task if the id is not repeted
                System.out.println("añade una descripción: ");
                description= scanner.nextLine();
                
                ListTask.add(new Tarea(id, description));
                /*creating a new task to the list with id and description*/
                System.out.println("nueva tarea añadida ");
            } 
        }
    }

    //modified task
    private void actionM(){
        boolean found=false;
        int modifId;
        System.out.println("Selecciona por ID el elemento que deseas modificar");
        modifId= scanner.nextInt();

        for (Tarea elementToModif : ListTask) {//foud the id
            if (modifId==elementToModif.getId()){
                found=true;
                //to change the id 
                System.out.println("inserta un nuevo id para la tarea: "+ elementToModif.getDescription());
                int newid= scanner.nextInt();
                scanner.nextLine();
                elementToModif.setId(newid);

                //to change the description
                System.out.println("inserta una nueva descripción para la tarea");
                String newdesc = scanner.nextLine();
                elementToModif.setDescription(newdesc);
                
                System.out.println("tarea modificada con exito! :) \n");
                break;
            }
        }

        if(!found){
                System.out.println();
            }
    }

    //delete task
    private void actionD() {
        int deleteById;
        String confirm;
        boolean found = false;//to confirm the id exist
    
        System.out.println("Selecciona por ID el elemento que deseas eliminar:");
        deleteById = scanner.nextInt();
    
        for (Tarea elementList : ListTask) {
            if (deleteById == elementList.getId()) {
                found = true;
                System.out.println("¿Confirma que deseas eliminar la tarea " + elementList.getDescription() + "? (s/n)");
                confirm = scanner.next();
    
                if (confirm.equalsIgnoreCase("s")) {
                    ListTask.remove(elementList);//delete the element selected by id
                    System.out.println("Tarea eliminada correctamente. \n");
                    break;
                }
            }
        }
    
        if (!found) {
            System.out.println("No se encontró ninguna tarea con el ID especificado.\n");
        }
    }
    

    //show the array filled
    private void actionS(){
        if (ListTask.isEmpty()) {
            System.out.println("La lista de tareas está vacía. \n");
        } else {
            System.out.println("Lista de tareas: \n");
            for (Tarea task : ListTask) {
                System.out.println(task.getId() + "-" + task.getDescription()+"\n");
            }
        }
    }
}
