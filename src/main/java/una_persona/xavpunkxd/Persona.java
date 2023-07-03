package una_persona.xavpunkxd;

public class Persona {
    //atributos de la persona
    private String name;
    private String lastname;
    private String born_mounth;
    private long bornyear;
    private long actualyear;

    //constructor con parametros
    public  Persona (String name,String lastname,String born_mounth,long bornyear,long actualyear) {
        this.name=name;
        this.lastname=lastname;
        this.born_mounth=born_mounth;
        this.bornyear=bornyear;
        this.actualyear=actualyear;       
    }

    //constructor sin parametros
    public Persona(){
        name="Francisco";
        lastname="Villa";
        born_mounth="febrero";
        bornyear=1980;
        actualyear=2023;
    }

    //getters and setters
    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 
    
    //lastname
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //born mounth
    public String getBorn_mounth() {
        return born_mounth;
    }

    public void setBorn_mounth(String born_mounth) {
        this.born_mounth = born_mounth;
    }

    //born year
    public long getBornyear() {
        return bornyear;
    }

    public void setBornyear(long bornyear) {
        this.bornyear = bornyear;
    }

    //actual year
    public long getActualyear() {
        return actualyear;
    }

    public void setActualyear(long actualyear) {
        this.actualyear = actualyear;
    }

     //tostring
     @Override
     public String toString(){
        return "Nombre: " + this.name + "," + " Apehído: "+this.lastname + "," +" Año de nacimiento: " +
         this.bornyear + "," +" Mes de nacimiento: " + this.born_mounth + "," +" Año actual: "+this.actualyear;
     }

    //metodo para calcular la edad de las personas
    public long calcularedad(){
        return actualyear-bornyear;
    }

    

    

    

}
