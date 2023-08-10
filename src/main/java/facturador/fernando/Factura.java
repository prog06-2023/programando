package facturador.fernando;

import java.util.ArrayList;
/**
 * Esta clase sirve para instanciar a un objeto de tipo Factura
 * @version 1.0
 * @author Fernando García Cano
 */

public class Factura{
    private static int id = 0;
    private int numeroFactura;
    private ArrayList<Producto> producto;

    public Factura(){

    }
    public Factura(ArrayList<Producto> producto){
        this.numeroFactura = id;
        this.producto = producto;
        id++;
    }
    public static void agregarFactura(ArrayList<Factura> db, Factura factura){
        db.add(factura);
    }
    public static int encontraId(ArrayList<Factura> db, String valor){
        int idEncontrado = -1;
        for (Factura factura : db){
            if (Integer.toString(factura.getNumeroFactura()).equals(valor)){
                idEncontrado = db.indexOf(factura);
                return idEncontrado;
            }
        }
        if (db.isEmpty()){
            return idEncontrado = 0;
        }
        return idEncontrado;
    }
    public static void eliminarFactura(ArrayList<Factura> facturas, int index){
        if (facturas.get(index).getProducto().isEmpty()){
            facturas.remove(index);
        }
    }
    public static float totalFactura(Factura factura){
        float cantidadTotal = 0;
        for(Producto producto1 : factura.getProducto()){
            cantidadTotal = cantidadTotal + (producto1.getCantidad() * producto1.getPrecio());
        }
        return cantidadTotal;
    }

    public static float totalFacturas(ArrayList<Factura> facturas){
        float cantidadTotal = 0;
        for (int i = 0; i < facturas.size(); i++){
            for (int j = 0; j < facturas.get(i).getProducto().size(); j++){
                cantidadTotal = cantidadTotal + (facturas.get(i).getProducto().get(j).getPrecio() * facturas.get(i).getProducto().get(j).getCantidad());
            }
        }
        return cantidadTotal;
    }
    public static void cantidadTotalPorProducto(ArrayList<Factura> facturas, ArrayList<Producto> inventario){

        for (int i = 0; i < facturas.size(); i++){
            for (Producto producto1 : inventario){
                for (Producto producto2 : facturas.get(i).getProducto()){
                    if (producto1.getId() == producto2.getId()){
                        float cantidadAnterior = producto1.getCantidad();
                        producto1.setCantidad(cantidadAnterior + producto2.getCantidad());
                    }
                }
            }
        }
    }
    public static String masVendido(ArrayList<Producto> productos){
        String popular = "";
        float max = 0;
        for (Producto producto : productos){
            if (producto.getCantidad() > max){
                max = producto.getCantidad();
                popular = producto.getDescripcion();
            }
        }

        return popular;
    }

    @Override
    public String toString() {
        return " Factura= " + numeroFactura +
                ", productos= " + producto;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Factura.id = id;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public ArrayList<Producto> getProducto() {
        return producto;
    }

}
