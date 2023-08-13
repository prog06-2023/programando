package facturador.javier;

import facturador.DataProducts; 

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javier
 * @version 1.0
 */
public class Factura {

    private int nro_factura;
    private ArrayList<Producto> productos;

    public Factura() {
    }

    public Factura(int nro_factura) {
        this.nro_factura = nro_factura;
        this.productos = new ArrayList<>();
    }
//    
//    public Factura(int nro_factura, List<DataProducts> productos){
//        this.nro_factura = nro_factura;
//        this.productos = productos;
//    }

    public int getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(int nro_factura) {
        this.nro_factura = nro_factura;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        String nroFactura = Integer.toString(this.nro_factura);
        String listado = this.productos.toString();
        return nroFactura + listado;

    }

    //metodos para manejar las facturas
    public boolean addFactura(ArrayList<Factura> listaFacturas, Factura factura) {
        return listaFacturas.add(factura);
    }

    public String showFacturas(ArrayList<Factura> listaFacturas) {
        return listaFacturas.toString();

    }

    public void deleteFactura(int id, ArrayList<Factura> listaFacturas) {
        listaFacturas.remove(id);

    }

    public static double totalFactura(Factura factura) {
        double total = 0;
        for (Producto producto : factura.getProductos()) {
            total = total + (producto.getPrecio() * producto.getCantidad());
        }
        return total;
    }

    public static double totalTodasFacturas(ArrayList<Factura> listaFacturas) {
        double total = 0;
        for (Factura factura : listaFacturas) {
            total = total + factura.totalFactura(factura);
        }

        return total;
    }

    public static Factura getFacturaPorNro(int nroFactura, ArrayList<Factura> listaFacturas) {
        for (Factura factura : listaFacturas) {
            if (factura.getNro_factura() == nroFactura) {
                return factura;

            }
        }
        return null;
    }
}
