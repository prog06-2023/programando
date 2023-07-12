package varias_tareas.edgarT;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @version 1.1
 * @author Edgar Tuyarot
 */
public class Persona {
    private ArrayList<Tarea> tareas;
    private String nombre;
    private String apellido;

    /**
     * @param nombre String
     * @param apellido String
     */
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tareas =  new ArrayList<Tarea>();
    }
    public Persona(){
        this.nombre="";
        this.apellido="";
        this.tareas= new ArrayList<Tarea>();
    }
    @Override
    public String toString() {
        return "La persona se llama " + nombre +" "+ apellido + " y sus tareas son: " + tareas;
    }
    public String getNombre() {return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private void mostrarTareas(){
        if(tareas.isEmpty()){
            System.out.println(" sin Tareas Asignadas");
        }else{
            for (Tarea tarea : tareas) {
                System.out.println(" "+tarea.getId()+"-"+ tarea.getDescripcion());
            }
        }
    }
    private void agregarTarea(){
        Scanner scanner = new Scanner(System.in);
        int id ;
        String rta = "si";
        String descripcion = "";
        System.out.println("-------------------");
        System.out.println(" Ingresando Tareas ");
        System.out.println("-------------------");
        System.out.println("");
        while (rta.equals("si")){
            System.out.println("Ingrese ID");
            id = scanner.nextInt();
            System.out.println("Ingrese Descripcion");
            descripcion = scanner.next();
            if (tareas.isEmpty()){
                tareas.add(new Tarea(id,descripcion));
            }else{
                for (Tarea tarea:tareas) {
                    if (tarea.getId() == id){
                        System.out.println("Id de tarea ya existe ("+tarea.getDescripcion()+")");
                        id = -1;
                        break;
                    }
                }
                if (id == -1){
                    continue;
                }else{
                    tareas.add(new Tarea(id,descripcion));
                }
            }
            System.out.println("Desea ingresar otra tarea si/no");
            rta = scanner.next();
        }


    }
    private void modificarTarea(){
        Scanner scanner = new Scanner(System.in);
        String descripcion = "";
        //Verificamos que la persona tenga tareas
        if (tareas.isEmpty()){
            System.out.println("Sin tareas asignadas");
        }else {
            System.out.println("-------------------");
            System.out.println(" Modificando Tarea ");
            System.out.println("-------------------");
            System.out.println("Ingresa el Numero de tarea a modificar");
            int idTarea = scanner.nextInt();

            for (int i = 0; i < tareas.size(); i++) {
                if (tareas.get(i).getId() == idTarea) {
                    System.out.println("Va a modificar: " + tareas.get(i).getId() + "-" + tareas.get(i).getDescripcion());
                    System.out.println("Ingrese Nueva Descripcion");
                    descripcion = scanner.next();
                    tareas.get(i).setDescripcion(descripcion);
                    break;
                }
            }
            if (descripcion == "") {
                System.out.println("No Existe la tarea");
            }


        }
    }
    private void elimiarTarea(){
        Scanner scanner = new Scanner(System.in);
        String rta = "";
        //Verificamos que la persona tenga tareas
        if (tareas.isEmpty()){
            System.out.println("Sin tareas asignadas");
        }else {
            System.out.println("------------------");
            System.out.println("*Eliminando Tarea*");
            System.out.println("------------------");
            System.out.println("Ingresa el Numero de tarea a eliminar");
            int idTarea = scanner.nextInt();

            for (int i = 0; i < tareas.size(); i++) {
                if (tareas.get(i).getId() == idTarea) {
                    System.out.println("Va a Eliminar: " + tareas.get(i).getId() + "-" + tareas.get(i).getDescripcion() + " desea continuar? si/no");
                    rta = scanner.next();
                    if (rta.equals("si")) {
                        tareas.remove(i);
                        System.out.println("Tarea Eliminada");
                        break;
                    }

                }
            }
            if (rta.equals("")) {
                System.out.println("No Existe la tarea");
            } else if (rta.equals("no")) {
                System.out.println("Sin cambios en tareas");
            }
        }
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        String opcion = "";
        while(!(opcion.toUpperCase().equals("Q"))) {
            System.out.println("------------Menu-------------");
            System.out.println(" A-Agregar Tarea             ");
            System.out.println(" M-Modificar Tarea           ");
            System.out.println(" D-Eliminar Tarea            ");
            System.out.println(" Q-Salir                     ");
            System.out.println("");
            System.out.println(" Tareas Actuales:            ");
            mostrarTareas();
            System.out.println("-----------------------------");
            System.out.println("Seleccion opcion");
            opcion = scanner.next();

            if (opcion.toUpperCase().equals("A")) {
                agregarTarea();
            } else if (opcion.toUpperCase().equals("M")) {
                    modificarTarea();
                        } else if (opcion.toUpperCase().equals("D")) {
                            elimiarTarea();
                        }
        }
    }

}
