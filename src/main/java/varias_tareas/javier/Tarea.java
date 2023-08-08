/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package varias_tareas.javier;

import java.util.ArrayList;

/**
 *
 * @author schja
 */
public class Tarea {

    public static int totales = 0;

    private String nombre;

    private String descripcion;
    private String realizada;
    private int idTarea;

    public Tarea() {
    }

    public Tarea(String nombre, String descripcion, String realizada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.realizada = realizada;
        Tarea.totales++;
        this.idTarea = Tarea.totales;
    }

    public Tarea(int id, String nombre, String descripcion, String realizada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.realizada = realizada;
        this.idTarea = id;
    }

    public int getId() {
        return this.idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String isRealizada() {
        return realizada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRealizada(String realizada) {
        this.realizada = realizada;
    }

    @Override
    public String toString() {
        return "Tarea nro: " + this.idTarea
                + " Titulo: " + this.nombre
                + " Descripcion: " + this.descripcion
                + " Estado: " + this.realizada;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        Tarea aComparar = (Tarea) obj;
        return this.nombre.compareTo(aComparar.nombre) == 0;

    }

}
