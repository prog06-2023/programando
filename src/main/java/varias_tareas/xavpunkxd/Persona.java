package varias_tareas.xavpunkxd;


public class Persona {
    private String name;
    private String lastname;
    private String user;

    //constructores
    public Persona(){
    }

    public Persona(String name,String lastname, String user){
        this.name=name;        
        this.lastname=lastname;
        this.user=user;        
    }

    //getters and setters
    public String getname(){
        return name;
    }

    public void setname(String name){
        this.name=name;
    } 

     public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUser() {
        return user;
    }


    public void setUser(String user) {
        this.user = user;
    }
}
