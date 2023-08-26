package facturador.xavpunkxd;
import java.util.*;

class Factura {
    private HashMap<String, List<Producto>> mapProducts;

    public Factura() {
        this.mapProducts = new HashMap<>();
    }

    //add a new facture complete 
    public void agregarProductos(String identificador, List<Producto> productos) {
        mapProducts.put(identificador, productos);
    }

    public HashMap<String, List<Producto>> obtenerMapaProductos() {
        return mapProducts;
    }

    public void imprimirContenido() {
        for (Map.Entry<String, List<Producto>> entry : mapProducts.entrySet()) {
            String identificador = entry.getKey();
            List<Producto> productos = entry.getValue();
            System.out.println("Identificador: " + identificador);
            System.out.println("\nProductos:");

            for (Producto producto : productos) {
                System.out.println("ID: "+producto.getID()+"| Nombre: " + producto.getDescription() +
                                     "| Precio: " + producto.getCost()+ "| Cantidad: " +producto.getAmount());
            }
            System.out.println("------------------------");
        }
    }

    public void ModificarProducto(int amount, int IdProduct, List<Producto> productList) {
        //set a new amout if the id is valid
        Producto.modifiedproduct(amount, IdProduct, productList);
        System.out.println("cantidad actualizada");
    }

    public void eliminarProducto(String identificador, int productoId, List<Producto> productList) {           
        Producto.deleteproduct(productoId, productList);
           
        if(productList.isEmpty()){//check out if the productList is empty to delete 
            mapProducts.remove(identificador);
            System.out.println("Producto eliminado con exito");                
        }
    }

    public float totalDeFactura( List<Producto> productList){
        float totalCost=0;
        for (Producto amProduct : productList) {
            int am= amProduct.getAmount();
            float cost= amProduct.getCost();
            totalCost+=(am*cost);
        }
        return totalCost;
    }
    
    public double totalFacturaS(){
        double totalFct=0;
        float totalProL=0;  for (Map.Entry<String, List<Producto>> entry : mapProducts.entrySet()) {
            List<Producto> Product = entry.getValue();//asign to an array the value of the objects

            for (Producto product : Product) {
                float cost=product.getCost();
                int am=product.getAmount();
                totalProL+=(am*cost);
            }
            totalFct+=totalProL;
        }
        return totalFct;
    }

   public List<Producto> obtenerProductosTotales() {
    HashMap<Integer, Producto> ProductsSing = new HashMap<>(); //adding the values at a new map 

    // look all the values of each bill
    for (List<Producto> productos : mapProducts.values()) {
        
        for (Producto produ : productos) {
            int idProd = produ.getID();

            if (ProductsSing.containsKey(idProd)) {
                //if the product already exist so modified the amount 
                Producto productExi = ProductsSing.get(idProd);
                productExi.setAmount(productExi.getAmount() + produ.getAmount());
        
            } else {
                //if it´s not so just create a new product and add to the Map
                Producto newProd = new Producto(produ.getID(), produ.getDescription(), produ.getCost(), produ.getAmount());
                ProductsSing.put(idProd, newProd);
            }
        }
    }

    //pass the final values at the array 
    return new ArrayList<>(ProductsSing.values());
}


    
    public boolean ValidarFactura(String identificador) {
        if(mapProducts.containsKey(identificador)){
            return true;
        }
        return false;
    }
}
