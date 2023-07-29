package varias_tareas.nimi;

import java.util.List;

/**
 * @version 1.0
 * @author Edgar Tuyarot
 *
 */
public class Tarea {

    private String id;
    private String descripcion;

    public Tarea(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Tarea() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static void mostrarTareas(List<Tarea> tareaList){
        if(Helpers.isNullOrEmpty(tareaList)){
            System.out.println("Sin tareas asignadas");
        }else{
            for (Tarea tarea : tareaList) {
                System.out.println(" "+tarea.getId()+"-"+ tarea.getDescripcion());
            }
        }
    }

    public static Tarea findTareaById(List<Tarea> tareaList, String id) {
        for (Tarea value : tareaList) {
            if (value.getId().equals(id)) {
                return value;
            }
        }
        return null;
    }

    public static List<Tarea> agregarTarea(List<Tarea> tareaList, Tarea tarea){
        tareaList.add(tarea);
        return tareaList;
    }

    public static List<Tarea> modificarTarea(List<Tarea> tareaList, Tarea tarea){
        for (Tarea value : tareaList) {
            if (value.getId().equals(tarea.getId())) {
                value.setDescripcion(tarea.getDescripcion());
                break;
            }
        }

        return tareaList;
    }

    public static List<Tarea> elimiarTarea(List<Tarea> tareaList, Tarea tarea){

        for (int i = 0; i < tareaList.size(); i++) {
            if (tareaList.get(i).getId().equals(tarea.getId())) {
                tareaList.remove(i);
                break;
            }
        }

        return tareaList;
    }
}
