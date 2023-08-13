/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facturador.javier;

import facturador.DataProducts;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author javier
 * @version 1.0
 */
public class Producto {

    private int id;
    private String descripcion;
    private double precio;
    private int cantidad;

    public Producto() {
    }

    public Producto(int id, String descripcion, double precio, int cantidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        String numero = Integer.toString(this.id);
        String valorProducto = Double.toString(this.precio);
        return numero + " " + descripcion + " " + valorProducto + " " + cantidad;
    }

//metodo qu everifica si el producto esta en la factura
    public boolean existe(Factura factura, Producto producto) {
        return factura.getProductos().contains(producto);
    }

//metodo para agregar un producto
    public static void addProducto(ArrayList<Producto> listaProductos, Producto producto) {
        listaProductos.add(producto);

    }

    //metodo para modificar la cantidad de productos de una factura
    //parametros una factura y el producto a modificar y una cantidad
    //devuelve la lista de productos de la factura modificada.
//    public int updateCantidad(Factura factura, Producto producto, int cantidad) {
//        
//        ArrayList<Producto> listaProductos = factura.getProductos();
//        int nuevaCantidad = 0;
//        
//        if (!existe(factura, producto)) {
//            System.out.println("El producto no existe en la Factura");
//        } else {
//            for (Producto prod : listaProductos) {
//                if (prod.getId() == producto.getId()) {
//                    prod.setCantidad(cantidad);
//                    nuevaCantidad = prod.getCantidad();
//                }
//            }
//
//        }
//        return nuevaCantidad;
//    }
//    
    public static int updateCantidad(ArrayList<Producto> listaProductos, int idProducto, int cantidad) {

        int nuevaCantidad = 0;
        for (Producto producto : listaProductos) {
            if (producto.getId() == idProducto) {
                producto.setCantidad(cantidad);
                nuevaCantidad = producto.getCantidad();
            }
        }
            return nuevaCantidad;
        }
    
    
    
    public static void removeProducto(ArrayList<Producto> listaProductos, int idProducto) {
        
        Iterator<Producto> iterator = listaProductos.iterator();
                
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if (producto.getId() == idProducto){
                iterator.remove();
                
            }
        }

    }

    public static String masVendido(ArrayList<Factura> listaFacturas) {
        String masVendido = "";
        int cantidadMax = 0;

        for (Factura factura : listaFacturas) {
            for (Producto producto : factura.getProductos()) {
                if (producto.getCantidad() > cantidadMax) {
                    cantidadMax = producto.getCantidad();
                    masVendido = producto.getDescripcion();
                }
            }
        }
        return masVendido;

    }

}
