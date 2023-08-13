
package facturador.javier;

import facturador.DataProducts; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Facturador
 * @author javier
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Factura> listaFacturas = new ArrayList<>();
        List<DataProducts> ejemploProductos = DataProducts.getProductList();
        

        String opcion;
        String opcionDos = "";
        

        do {

            menuPrincipal();
            opcion = scanner.next().toUpperCase();

            switch (opcion) {

                case "F":
                    System.out.println("A continuación crearemos la factura, necesito el nro de factura: ");
                    int nroFactura = scanner.nextInt();

                    for (Factura factura : listaFacturas) {

                        if (factura.getNro_factura() == nroFactura) {
                            System.out.println("Ya existe una factura con ese numero!");

                        }
                    }
                    Factura factura = new Factura(nroFactura);
                    listaFacturas.add(factura);

                    System.out.println("Listo la factura nro.: " + nroFactura + " Ha sido creada.");
                    break;

                case "A":
                    if (listaFacturas.isEmpty()) {
                        System.out.println("Parece que no hay ninguna factura");

                    } else {
                        System.out.println("A continuación agregaremos un producto a la factura...");
                        System.out.println("Pero primero necesito saber a que factura agragarle el producto...");
                        System.out.println("Aca tiene una lista de las facturas: ");

                        System.out.println(Arrays.toString(listaFacturas.toArray()));

                        System.out.println("Ingrese el nro de factura");

                        nroFactura = scanner.nextInt();
                        Factura facturaAEditar = Factura.getFacturaPorNro(nroFactura, listaFacturas);

                        System.out.println("introduzca el codigo de producto: ");
                        int idProducto = scanner.nextInt();

                        System.out.println("introduzca la descripcion de producto: ");
                        String descripcionProducto = scanner.next();

                        System.out.println("introduzca el precio del producto: ");
                        double precioProducto = scanner.nextDouble();

                        System.out.println("introduzca la cantidad: ");
                        int cantidadProducto = scanner.nextInt();

                        Producto nuevoProducto = new Producto(idProducto, descripcionProducto, precioProducto, cantidadProducto);

                        for (Producto producto : facturaAEditar.getProductos()) {
                            if (producto.getId() == idProducto) {
                                producto.setCantidad(cantidadProducto + producto.getCantidad());
                            }

                        }
                        Producto.addProducto(facturaAEditar.getProductos(), nuevoProducto);

                        System.out.println("Desea hacer algo mas? (S / N)");
                        opcionDos = scanner.nextLine().toUpperCase();
                        break;
                    }

                case "M":
                    if (listaFacturas.isEmpty()) {
                        System.out.println("Parece que no hay ninguna factura");

                    } else {
                        System.out.println("A continuación modificaremos la cantidad de un producto.");
                        System.out.println("Pero primero necesito saber que factura modificar");
                        System.out.println("Aca tiene una lista de las facturas: ");
                        System.out.println(Arrays.toString(listaFacturas.toArray()));
                        System.out.println("Ingrese el nro de factura");

                        nroFactura = scanner.nextInt();
                        Factura facturaAEditar = Factura.getFacturaPorNro(nroFactura, listaFacturas);
                        ArrayList<Producto> listaProductos = facturaAEditar.getProductos();
                        System.out.println("Aca tiene una lista de los productos de la factura: ");
                        System.out.println(facturaAEditar.getProductos().toString());

                        System.out.println("introduzca el codigo de producto: ");
                        int idProducto = scanner.nextInt();

                        System.out.println("introduzca la cantidad: ");
                        int cantidadProducto = scanner.nextInt();

                        int nuevaCantidad = Producto.updateCantidad(listaProductos, idProducto, cantidadProducto);

                        if (nuevaCantidad <= 0) {
                            Producto.removeProducto(listaProductos, idProducto);
                        }

                        System.out.println("Desea hacer algo mas? (S / N)");
                        opcionDos = scanner.next().toUpperCase();
                        break;
                    }

                case "D":
                    System.out.println("A continuación eliminaremos un producto.");
                    System.out.println("Pero primero necesito saber que factura usar");
                    System.out.println("Aca tiene una lista de las facturas: ");
                    System.out.println(Arrays.toString(listaFacturas.toArray()));
                    System.out.println("Ingrese el nro de factura");

                    nroFactura = scanner.nextInt();
                    Factura facturaAEditar = Factura.getFacturaPorNro(nroFactura, listaFacturas);
                    ArrayList<Producto> listaProductos = facturaAEditar.getProductos();
                    System.out.println("Aca tiene una lista de los productos de la factura: ");
                    System.out.println(facturaAEditar.getProductos().toString());

                    System.out.println("introduzca el codigo de producto a eliminar: ");
                    int idProducto = scanner.nextInt();

                    Producto.removeProducto(listaProductos, idProducto);

                case "L":

                    System.out.println("Aca tiene una lista de las facturas: ");
                    System.out.println(Arrays.toString(listaFacturas.toArray()));
                    
                case "RFE":
                    System.out.println("A continuación obtendremos el total de una factura.");
                    System.out.println("Pero primero necesito saber que factura usar");
                    System.out.println("Aca tiene una lista de las facturas: ");
                    System.out.println(Arrays.toString(listaFacturas.toArray()));
                    System.out.println("Ingrese el nro de factura");

                    nroFactura = scanner.nextInt();
                    Factura facturaATotalizar = Factura.getFacturaPorNro(nroFactura, listaFacturas);
                    double total = Factura.totalFactura(facturaATotalizar);
                    
                    System.out.println("El total de la factura nro.: " + nroFactura + " es: " + total);
            
                case "RTE":
                    System.out.println("A continuación obtendremos el total de todas las factura.");
                    
                    double totales = Factura.totalTodasFacturas(listaFacturas);
                    
                    System.out.println("El total de todas las facturas es: " + totales);
            
                case "RP":
                    System.out.println("A continuación obtendremos el producto mas vendido");
                    
                    String productoMasVendido = Producto.masVendido(listaFacturas);
                    
                    System.out.println("El producto mas vendido es: " + productoMasVendido);
                   
            
            }
        } while (!opcion.equals("Q") && !opcionDos.equals("N"));

        scanner.close();
        System.out.println( " Nos vemos :) " );

    }

    public static void menuPrincipal() {
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------- BIENVENIDO AL FACTURADOR ---------------");
        System.out.println("-------- ELIJA UNA DE LAS SIGUIENTES OPCIONES ---------");
        System.out.println("-------------------------------------------------------");
        System.out.println("--- F -> PARA AGREGAR UNA FACTURA ---------------------");
        System.out.println("--- A -> PARA AGREGAR UN PRODUCTO A LA FACTURA  -------");
        System.out.println("--- M -> PARA MODIFICAR LA CANTIDAD DE UN PRODUCTO  ---");
        System.out.println("--- D -> PARA ELIMINAR UN PRODUCTO DE LA FACTURA  -----");
        System.out.println("--- L -> PARA LISTAR TODAS LAS FACTURAS  --------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("--- RFE -> MUESTRA EL TOTAL DE UNA FACTURA ESPECIFICA -");
        System.out.println("--- RTF -> MUESTRA EL TOTAL DE TODAS LAS FACTURAS  ----");
        System.out.println("--- RP -> MUESTRA EL PRODUCTO MAS VENDIDO -------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("------------------ Q -> PARA SALIR --------------------");
        System.out.println("-------------------------------------------------------");

    }

}
