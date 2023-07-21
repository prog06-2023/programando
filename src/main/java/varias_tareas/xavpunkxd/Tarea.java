package varias_tareas.xavpunkxd;

public class Tarea {
    private int id;
    private String description;

    //constructor with parametters
    public Tarea(int id, String description){
        this.id=id;
        this.description=description;
    }

    //constructor without parametters
     public Tarea(){
        this.id=0;
        this.description=" ";
    } 

    //getter and setter for id
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    //getter and setter for description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
