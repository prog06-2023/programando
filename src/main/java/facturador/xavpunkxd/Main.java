package facturador.xavpunkxd;
import java.util.*;
import facturador.DataProducts;

public class Main {
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Factura bill = new Factura();
        List<DataProducts> productsAva = DataProducts.getProductList();
        String Option="";
        String des="";
        String idFact="";
        float cost=0;

        do{
            System.out.println("Bienvenido al facturador cliente, elige una opcion para iniciar: \n");
            showmenu();
            Option=scan.nextLine();
            Option=Option.toUpperCase();
            
            //scan.nextLine();
            switch(Option){
                //new bill
                case "F":
                    System.out.println("Ingrese el identificador:");
                    String identificadorAgregar = scan.nextLine();
                        
                    //first let´s to check out if the id already exist or contains letters
                    if(!identificadorAgregar.matches("^[A-Za-z]*")){

                        if (bill.obtenerMapaProductos().containsKey(identificadorAgregar)) {                            
                            System.out.println("¡Error! Ya existe un identificador con esa lista de productos.");
                        } else {    
                            List<Producto> productlist = new ArrayList<>();         
                            while(true){
                                showProducts();                                
                                System.out.println("Selecciona el producto que deseas agregar: ");

                                //variables to add a new product
                                int id=scan.nextInt();
                                scan.nextLine();
                                
                                //choosing the type of data product to create a new product
                                DataProducts producselected = selectProduct(productsAva, id);
                                
                                if(producselected == null){
                                    System.out.println("producto no encontrado");
                                }else{
                                    //getting the product
                                    des=producselected.getDescripcion();
                                    cost=producselected.getPrecio();

                                    int amount = 1;
                                    //in case the product already exist just sum the amount
                                    Producto newproduct= new Producto(id, Option, cost, amount);
                                    
                                    Producto exist= Producto.validID(id, productlist);
                                    //check out if the product already exist
                                    if (exist!=null){
                                        exist.setAmount(exist.getAmount() + newproduct.getAmount());
                                        System.out.println("El producto ya existe en la factura. Cantidad actualizada.");                            
                                    }else{
                                        //creating the arraylist and the product to add
                                        Producto.addproduct(new Producto(id, des, cost,amount), productlist);
                                        System.out.println("Productos agregados exitosamente.");
                                    }
                                    
                                }                      
                                
                                System.out.println("¿Desea agregar otro producto? (sí/no)");
                                String continuar = scan.nextLine();                                
                                if (continuar.equalsIgnoreCase("no")) {
                                    break;
                                }                                
                            }

                            //here is creating the new bill already complete
                            bill.agregarProductos(identificadorAgregar, productlist);
                        }
                    }else{
                        System.out.println("Identificador no valido");
                    }
                break;

                //show all lists
                case"L":
                System.out.println("Facruras completas:\n");
                    bill.imprimirContenido();
                break;
                
                //modified a product
                case"M":
                    System.out.println("Inrese el id de la factura");
                    idFact=scan.nextLine();
                    if(bill.ValidarFactura(idFact)){
                        System.out.println("ingrese el id del producto");
                        int idP=scan.nextInt();
                        scan.nextLine();
                        
                        System.out.println("Ingrese la nueva cantidad");
                        int amount=scan.nextInt();
                        scan.nextLine();

                        bill.ModificarProducto(amount, idP,bill.obtenerMapaProductos().get(idFact));
                        //the element bill.obtenerMapaProductos().get(idFact) select a element in specific usinge the idFact like a key
                    }else{
                    
                        System.out.println("id de factura no encontrado, porfavor ingresa un id valido");
                    
                    }
                break;
                
                //delete a product
                case"D":
                    System.out.println("Ingrese el id de la factura");
                    idFact=scan.nextLine();
                    if(bill.ValidarFactura(idFact)){
                        System.out.println("Ingrese el id del producto");
                        int idp= scan.nextInt();
                        bill.eliminarProducto(idFact, idp, bill.obtenerMapaProductos().get(idFact));
                    }else{
                        System.out.println("id de factura no encontrado, porfavor ingresa un id valido");
                    }                   
                break;
                
                //mostrar el total de una factura
                case"RFE":
                    System.out.println("Ingrese el id de la factura");
                    idFact=scan.nextLine();
                    if(bill.ValidarFactura(idFact)){
                        System.out.println("El total de la factura "+idFact+" es:");
                        System.out.println(bill.totalDeFactura(bill.obtenerMapaProductos().get(idFact)));
                    }else{
                        System.out.println("id de factura no encontrado, porfavor ingresa un id valido");
                    }
                break;

                //mostrar el total de todas las facturas
                case"RTF":
                    double total=bill.totalFacturaS();
                    System.out.println("El total de las facturas es: "+total);
                break;

                //mostrar el producto mas vendido
                case"RP":
                    List<Producto> amp = bill.obtenerProductosTotales();
                    int maxamount=0;
                    int amPro=0;
                    String BeastProd="";
                    for (Producto product : amp) {
                        amPro=product.getAmount();
                        if(amPro>maxamount){
                            maxamount=amPro;
                            BeastProd=product.getDescription();
                        }
                    }

                    System.out.println("El mejor producto en ventas fue: "+ BeastProd + "ya que se vendio: "+ maxamount+" vecesn\n");

                case"Q":
                 System.out.println("saliendo del programa");
                break;
                
                default:
                System.out.println("ingrese una opcion valida");
            }

        }while(!Option.equals("Q"));
        scan.close();
    }   

    //method to select a product in the menu
    public static DataProducts selectProduct(List<DataProducts>ProductsList,int id){
        for (DataProducts idproduct : ProductsList) {
            if(idproduct.getId()==id){
                return idproduct;
            }
        }
        return null;
    }

    public static void showProducts(){
        System.out.println("lista de productos disponibles: \n");
        System.out.println("-----------------------------------\n"+
        DataProducts.getProductList()+"\n"+
        "----------------------------------------");
    }

    public static void showmenu(){
        System.out.println("Opciones: ");
        System.out.println( "presiona F para añadir una nueva Factura "+"\n"+
                            "presiona L para mostrar listas con sus productos "+"\n"+ 
                            "presiona M para modificar cantidad de un producto "+"\n"+
                            "presiona D para eliminar un producto"+"\n"+
                            "presiona RFE para mostrar el total de una factura" +"\n"+ 
                            "presiona RTF para mostrar el total de todas las facturas" +"\n"+
                            "presiona RP para mostrar el producto mas vendido"+"\n"+
                            "presiona Q para salir... "+"\n");
    }
}
