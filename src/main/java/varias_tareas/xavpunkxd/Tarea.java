package varias_tareas.xavpunkxd;
import java.util.ArrayList;


public class Tarea {
    private int id;   
    private String title;
    private String description;

    //constructors
    public Tarea(){

    }

    public Tarea(int id, String title,String description){
        this.id=id;
        this.title=title;
        this.description=description;
    }

    //method to add a new task
    public static void AddTask(Tarea task, ArrayList<Tarea>ListTask){
        ListTask.add(task);
    }

    //method to get the task selected and modify it
    public static Tarea getTaskById(int id, ArrayList<Tarea> listTask) {
        for (Tarea task : listTask) {
            if (task.getId() == id) {
                return task; // Return the task if found
            }
        }
        return null; // Return null if no task with the given ID was found
    }


    //method to remove a task
    public static Tarea DeleteTaskById(int id, ArrayList<Tarea> listTask) {
        for (Tarea task : listTask) {
            if (task.getId() == id) {
                listTask.remove(task); // Return the task if found
            }
        }
        return null; // Return null if no task with the given ID was found
    }

    //getters and setters
     public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
