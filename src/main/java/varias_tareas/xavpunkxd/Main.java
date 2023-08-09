/**
 * @version 2.0
 * @autor xavpunkxd
 */
package varias_tareas.xavpunkxd;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Scanner;

public class Main {    
    static ArrayList<Tarea>ListTask = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);//this scan make all inputs in the program

        System.out.println("Hola usuario, ingresa tus datos");
        
        System.out.println("nombre: ");
        String namein= scan.nextLine();
        
        System.out.println("\napellido: ");
        String lastnamein= scan.nextLine();
        
        System.out.println("\nusuario: ");
        String userin= scan.nextLine();
        
        Persona user = new Persona(namein, lastnamein, userin);
        System.out.println("Binvenido al administrador de tareas "+ user.getUser());
        String Option= "";

        //variables to create a new task
        int id;
        String title;
        String description;
        //String askMtext;
        //boolean Mtext=false;

        do{
            ShowMenu();//showing the options in the console
            System.out.println("Lista de tareas: \n");
            ShowtaskList();

            Option= scan.nextLine();
            Option= Option.toUpperCase();//pass the input to uppercase to select an option

            switch(Option){
                case "A":
                    System.out.println("Asigna un id a la tarea:");
                    id= scan.nextInt();
                    scan.nextLine();//consuming the buffer of the scanner

                    if(ListTask.isEmpty()){//in case of the List is empty just add the new task
                        System.out.println("Ingresa el titulo de la tarea:");
                        title= scan.nextLine();

                        System.out.println("Ingresa una descripción para la tarea:");
                        description= scan.nextLine();
                        
                        Tarea.AddTask(new Tarea(id, title, description), ListTask);

                    }else{
                        for (Tarea idtask : ListTask) {//if is not do:
                            if(idtask.getId() == id){
                                System.out.println("Este id ya existe en la lista asigna otro id");
                                id=-1;
                            }
                            break;
                        }
                        if(id>-1){//in case that the id not exist
                            System.out.println("Ingresa el titulo de la tarea:");
                            title= scan.nextLine();

                            System.out.println("Ingresa una descripción para la tarea:");
                            description= scan.nextLine();
                        
                            Tarea.AddTask(new Tarea(id, title, description), ListTask);
                        }

                    }
                break;

                case "M":
                    if(ListTask.isEmpty()){
                        System.out.println("Este arreglo esta vacio \n");
                    }else{
                        System.out.println("ingresa el id de la tarea que deseas modificar\n");
                        id=scan.nextInt();//asking for the id to modified the task
                        scan.nextLine();

                        Tarea taskToModify = Tarea.getTaskById(id, ListTask);

                        if(taskToModify!=null){
                            System.out.println("modificando tarea " + taskToModify.getTitle());
                            System.out.println("Ingresa el nuevo ID para la tarea:");
                            int newId = scan.nextInt();
                            scan.nextLine();
                            taskToModify.setId(newId);

                            System.out.println("Ingresa el nuevo título de la tarea:");
                            String newTitle = scan.nextLine();
                            taskToModify.setTitle(newTitle);
                            
                            System.out.println("Ingresa la nueva descripción de la tarea:");
                            String newDescription = scan.nextLine();
                            taskToModify.setDescription(newDescription);
                        }else{
                            System.out.println("La tarea no fue encontrada, porfavor ingresa un id valido");
                        }
                    }
                break;

                case "D":
                    System.out.println("ingresa el id de la tarea que deseas eliminar\n");
                    id=scan.nextInt();//asking for the id to modified the task
                    scan.nextLine();
                    Tarea tasktoDelete =Tarea.DeleteTaskById(id, ListTask);
                    if(tasktoDelete==null){
                        System.out.println("ID no encontrado, comprueva que es el correcto");
                    }else{
                        System.out.println("tarea eliminasa exitosamente");
                    }
                break;

                case "Q":
                System.out.println("Estas son todas las tareas añadidas por el usuario" + user.getUser()+"\n");
                ShowtaskList();
                break;

                default:
                System.out.println("La opción no es valida porfavor ingresa una opción valida");
            }
        }while(!Option.equals("Q"));

        scan.close();
    }

    public static void ShowMenu(){
        System.out.println("\n-----------------------------------------------------");
        System.out.println("Estas son tus posibles opciones a elegir"+"\n");

        System.out.println("presiona A para añadir una tarea "+"\n"+//addTask
                           "presiona M para modificar una tarea "+"\n"+//modifiedTask 
                           "presiona D para eliminar una tarea "+"\n"+//deleteTask
                           "presiona Q para salir... "+"\n");//quit
        System.out.println("-----------------------------------------------------");
    }

    public static void ShowtaskList(){
         if(!ListTask.isEmpty()){//show the tasklist
                for (Tarea taskinfo :ListTask ) {
                                System.out.println("-id: "+taskinfo.getId() +" -title: "+taskinfo.getTitle()
                                +" -description: "+ taskinfo.getDescription());
                            }
            }else{
                System.out.println("Sin tareas asignadas\n");
            }
    }

    
} 
