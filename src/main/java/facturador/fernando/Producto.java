package facturador.fernando;

import facturador.DataProducts;

import java.util.ArrayList;
import java.util.List;
/**
 * Esta clase sirve para instanciar a un objeto de tipo producto
 * @version 1.0
 * @author Fernando García Cano
 */

public class Producto {
    int id;
    String descripcion;
    float precio;
    float cantidad;
    public Producto(){

    }
    public Producto(String descripcion, float precio, int id){
        this.descripcion = descripcion;
        this.precio = precio;
        this.id = id;
        this.cantidad = 0;
    }
    public static void agregarProducto(ArrayList<Producto> productos, int index, int cantidad){
        for (Producto producto : productos){
            if(producto.getId() == index){
                float cantidadAnterior = producto.getCantidad();
                producto.setCantidad(cantidadAnterior + cantidad);
            }
        }
    }
    public static void modificarProducto(ArrayList<Producto> productos, int index, int cantidad){
        for (Producto producto : productos){
            if(producto.getId() == index){
                producto.setCantidad(cantidad);
            }
        }
    }
    public static void agregarInventario(ArrayList<Producto> productos, List<DataProducts> inventario){
        for (DataProducts dataProducts : inventario){
            boolean encontrado = false;
            for (Producto producto : productos){
                if (dataProducts.getId() == producto.getId()){
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado){
                productos.add(new Producto(dataProducts.getDescripcion(), dataProducts.getPrecio(), dataProducts.getId()));
            }
        }
    }
    public static void eliminarProductoVacio(ArrayList<Producto> productos){
//        for (Producto producto : productos){
//            if (producto.getCantidad() == 0){
//                productos.remove(producto);
//            }
//        }
        productos.removeIf(producto -> producto.getCantidad() == 0);
    }
    public static void eliminarProducto(ArrayList<Producto> productos, int index){
        for (Producto producto : productos){
            if(producto.getId() == index){
                productos.remove(producto);
                break;
            }
        }
    }
    public static int encontraId(ArrayList<Producto> db, String valor){
        int idEncontrado = -1;
        for (Producto producto : db){
            if (Integer.toString(producto.getId()).equals(valor)){
                idEncontrado = Integer.parseInt(valor);
                return idEncontrado;
            }
        }
        if (db.isEmpty()){
            return idEncontrado = 0;
        }
        return idEncontrado;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
