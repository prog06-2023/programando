package varias_tareas.nimi;

import java.util.Scanner;

public class Main {


    Scanner scanner = new Scanner(System.in);
    Persona persona = new Persona("Daniel", "Ledesma");

    public static void main(String[] args) {
        new Main().menu();
    }

    private void menu(){
        String opcion = "";
        do {
            System.out.println("------------Menu-------------");
            System.out.println(" A-Agregar Tarea             ");
            System.out.println(" M-Modificar Tarea           ");
            System.out.println(" D-Eliminar Tarea            ");
            System.out.println(" Q-Salir                     ");
            System.out.println("");
            System.out.println(" Tareas Actuales:            ");
            Tarea.mostrarTareas(persona.getTareas());
            System.out.println("-----------------------------");
            System.out.println("Seleccion opcion");
            opcion = scanner.next();

            if (opcion.equalsIgnoreCase("A")) {
                String rta;
                System.out.println("-------------------");
                System.out.println(" Ingresando Tareas ");
                System.out.println("-------------------");
                System.out.println("");
                do {
                    Tarea tarea = new Tarea();
                    boolean exists;
                    do {
                        exists = false;
                        System.out.println("Ingrese ID");
                        tarea.setId(scanner.next());

                        for (Tarea value : persona.getTareas()) {
                            if (value.getId().equals(tarea.getId())){
                                System.out.println("Id de tarea ya existe ("+value.getDescripcion()+")");
                                exists = true;
                                break;
                            }
                        }
                    }while (exists);

                    System.out.println("Ingrese Descripcion");
                    tarea.setDescripcion(scanner.next());

                    persona.setTareas(Tarea.agregarTarea(persona.getTareas(), tarea));

                    System.out.println("Desea ingresar otra tarea si/no");
                    rta = scanner.next();
                } while (rta.equalsIgnoreCase("si"));

            } else if (opcion.equalsIgnoreCase("M")) {

                if (persona.getTareas().isEmpty()){
                    System.out.println("Sin tareas asignadas");
                }else {
                    System.out.println("-------------------");
                    System.out.println(" Modificando Tarea ");
                    System.out.println("-------------------");
                    System.out.println("Ingresa el Numero de tarea a modificar");

                    Tarea tarea = new Tarea();
                    tarea.setId(scanner.next());

                    for (Tarea value : persona.getTareas()) {
                        if (value.getId().equals(tarea.getId())){
                            System.out.println("Va a modificar: " + value.getId() + "-" + value.getDescripcion());
                            System.out.println("Ingrese Nueva Descripcion");
                            tarea.setDescripcion(scanner.next());
                            Tarea.modificarTarea(persona.getTareas(), tarea);
                            break;
                        }
                    }
                }
            } else if (opcion.equalsIgnoreCase("D")) {

                String rta = "";
                if (persona.getTareas().isEmpty()){
                    System.out.println("Sin tareas asignadas");
                }else {
                    System.out.println("------------------");
                    System.out.println("*Eliminando Tarea*");
                    System.out.println("------------------");
                    System.out.println("Ingresa el Numero de tarea a eliminar");

                    Tarea tarea = Tarea.findTareaById(persona.getTareas(), scanner.next());
                    if (tarea != null){
                        System.out.println("Va a Eliminar: " + tarea.getId() + "-" + tarea.getDescripcion() + " desea continuar? si/no");
                        rta = scanner.next();
                        if (rta.equals("si")) {
                            Tarea.elimiarTarea(persona.getTareas(), tarea);
                            System.out.println("Tarea Eliminada");
                        } else if (rta.equals("no")) {
                            System.out.println("Sin cambios en tareas");
                        }
                    }else{
                        System.out.println("No Existe la tarea");
                    }

                }
            }
        } while(!(opcion.equalsIgnoreCase("Q")));

        System.out.println("Adios " + persona.getNombre());
    }
}
