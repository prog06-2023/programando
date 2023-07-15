package facturador;

import java.util.ArrayList;
import java.util.List;

public class DataProducts {

    private final int id;
    private final String descripcion;
    private final float precio;

    private DataProducts(int id, String descripcion, float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }

    public static List<DataProducts> getProductList() {
        List<DataProducts> productList = new ArrayList<>();
        productList.add(new DataProducts(1, "Leche", 100));
        productList.add(new DataProducts(2, "Azucar", 150));
        productList.add(new DataProducts(3, "Chocolate", 200));
        productList.add(new DataProducts(4, "Cafe", 350));
        productList.add(new DataProducts(5, "Yerba", 500));
        return productList;
    }
}
