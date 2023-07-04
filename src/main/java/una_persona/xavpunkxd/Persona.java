/*
 * @version 1.0 
 * @date 04/07/2023
 */

package una_persona.xavpunkxd;

import java.util.Calendar;

public class Persona {
    //atributos de la persona
    private String name;
    private String lastname;
    private int born_mounth;
    private int born_day;
    private int bornyear;//esta es la variable para fecha de nacimiento 
    protected int diasfaltantes;

    //constructor con parametros
    public  Persona (String name,String lastname,int born_mounth,int bornyear, int born_day) {
        this.name=name;
        this.lastname=lastname;
        this.born_mounth=born_mounth;
        this.bornyear=bornyear;     
        this.born_day=born_day;
    }

    //constructor sin parametros
    public Persona(){
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
    public int getBorn_mounth() {
        return born_mounth;
    }

    public void setBorn_mounth(int born_mounth) {
        this.born_mounth = born_mounth;
    }

    //born year
    public int getBornyear() {
        return bornyear;
    }

    public void setBornyear(int bornyear) {
        this.bornyear = bornyear;
    }

     public int getBirthday() {
        return born_day;
    }

    public void setBirthday(int birthday) {
        this.born_day = birthday;
    }

    

     //tostring
     @Override
     public String toString(){
        return "Nombre: " + this.name + "," + " Apehído: "+this.lastname + "," +" Año de nacimiento: " +
         this.bornyear + "," +" Mes de nacimiento: " + this.born_mounth;
     }

    //metodo para calcular la edad de las personas
    public long calcularedad(int bornyear){
        //llamando al metodo getInstance() para poder obtener el año actual
        Calendar calendario = Calendar.getInstance();
        //obteniendo el año actual
        int actualyear = calendario.get(Calendar.YEAR);        
        return actualyear-bornyear;
    }

    public long calcularcumpleaños(){
        
        Calendar day=Calendar.getInstance();
        int mes = day.get(Calendar.MONTH) + 1;
        int dia=day.get(Calendar.DAY_OF_MONTH);
        
        if(born_mounth > mes  && born_day < dia){
        
            diasfaltantes= ((born_mounth*31)+ born_day) - day.get(Calendar.DAY_OF_YEAR);
            System.out.println("faltan " +  diasfaltantes +" dias para tu cumpleaños");
        
        }else if(born_mounth == mes && born_day == dia){
            System.out.println("Hoy cumples años, feliciades!");
        } else {
            System.out.println("tu cumpleaños ya paso, tienes: " + calcularedad(bornyear) + " años");
        }
        
        return diasfaltantes;
    }

    

    

    

}
