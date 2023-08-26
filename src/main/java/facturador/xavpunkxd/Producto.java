package facturador.xavpunkxd;
import java.util.*;
//import facturador.DataProducts;

public class Producto {
    private int id;
    private String description;
    private float cost;
    private int amount;
    
    public Producto(){
    }

    public Producto(int id,String description,float cost,int amount){
        this.id=id;
        this.description=description;
        this.cost=cost;
        this.amount=amount;
    }

    public static Producto validID(int id,  List<Producto> productList){
        for (Producto producto : productList) {
            if(producto.getID()==id){
                return producto;
            }
        }
        return null;
    }

    public static void addproduct(Producto product, List<Producto> productList){
        productList.add(product);
    }

    public static void modifiedproduct(int amount, int id,List<Producto> productList){
        Iterator<Producto> iterator = productList.iterator();

        while (iterator.hasNext()) {
            Producto producto = iterator.next();        
            if (producto.getID() == id) {
                producto.setAmount(amount);
                break;
            }else{
                System.out.println("Producto no encontrado");
            }
        }
    }

    public static void deleteproduct( int id,List<Producto> productList){
        Iterator<Producto> iterator = productList.iterator();

        while (iterator.hasNext()) {
            Producto producto = iterator.next();        
            if (producto.getID() == id) {
                iterator.remove();
                break;
            }
        }
    }

    //getters to:
    //id
    public int getID(){
        return id;
    }

    //description
    public String getDescription(){
        return description;
    }
    
    //cost
    public float getCost(){
        return cost;
    }

    //getters and setter to amount
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
