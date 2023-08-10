package facturador.fernando;

import facturador.DataProducts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal
 *
 * @version 1.0;
 * @author Fernado García
 */

public class Main {
    static ArrayList<Factura> db = new ArrayList<>();

    public static void main(String[] args) {
        String input = "";
        String index;
        String rta;
        int idEncontrado;
        int idEncontrado2;
        Scanner entrada = new Scanner(System.in);
        List<DataProducts> inventario = DataProducts.getProductList();

        while (!input.equals("Q")) {
            mostrarMenu();
            input = entrada.next();
            input = input.toUpperCase();
            switch (input) {
                case "F":
                    do {
                        ArrayList<Producto> productos = new ArrayList<>();
                        Producto.agregarInventario(productos, inventario);

                        do {
                            System.out.println("==============================================");
                            System.out.println("Ingrese el id del producto que desea agregar a la factura: ");
                            System.out.println(DataProducts.getProductList());
                            index = entrada.next();
                            idEncontrado = Helpers.encontraId(inventario, index);

                            if (idEncontrado == -1) {
                                do {
                                    System.out.println("Id de producto no encontrado porfavor digite un id valido");
                                    index = entrada.next();
                                    idEncontrado = Helpers.encontraId(inventario, index);

                                } while (idEncontrado == -1 && !Helpers.validarId(index));
                            }
                            System.out.println("Digite la cantidad que desea del producto: ");
                            index = entrada.next();
                            if (!Helpers.validarId(index)) {
                                do {
                                    System.out.println("Valor no aceptado");
                                    index = entrada.next();

                                } while (!Helpers.validarId(index));
                            }
                            Producto.agregarProducto(productos, idEncontrado, Integer.parseInt(index));
                            System.out.println("Desea ingresar otra producto a la factura si/no");
                            rta = entrada.next();
                        } while (rta.equalsIgnoreCase("si"));
                        System.out.println("Productos ingresados a la Factura:");
                        Producto.eliminarProductoVacio(productos);
                        System.out.println(productos);
                        Factura.agregarFactura(db, new Factura(productos));
                        System.out.println("Desea ingresar otra factura si/no");
                        rta = entrada.next();
                    } while (rta.equalsIgnoreCase("si"));
                    System.out.println("Facturas actuales: " + '\n' + db);
                    break;
                case "A":
                    do {
                        System.out.println("==============================================");
                        System.out.println("Ingrese el id de la factura la cual quiere agregar un producto: ");
                        index = entrada.next();
                        idEncontrado = Factura.encontraId(db, index);
                        if (idEncontrado == -1) {
                            do {
                                System.out.println("Id de Factura no encontrado porfavor digite un id valido");
                                index = entrada.next();
                                idEncontrado = Factura.encontraId(db, index);

                            } while (idEncontrado == -1 && !Helpers.validarId(index));
                        }
                        Producto.agregarInventario(db.get(idEncontrado).getProducto(), inventario);
                        db.get(idEncontrado).getProducto().sort((Producto p1, Producto p2) -> Integer.compare(p1.getId(), p2.getId()));
                        System.out.println(inventario);
                        do {
                            System.out.println("Ingrese el id del producto que quiere agregar: ");
                            index = entrada.next();
                            idEncontrado2 = Producto.encontraId(db.get(idEncontrado).getProducto(), index);
                            if (idEncontrado2 == -1) {
                                do {
                                    System.out.println("Id de producto no encontrado porfavor digite un id valido");
                                    index = entrada.next();
                                    idEncontrado2 = Producto.encontraId(db.get(idEncontrado).getProducto(), index);

                                } while (idEncontrado2 == -1 && !Helpers.validarId(index));
                            }
                            System.out.println("Digite la cantidad que desea del producto: ");
                            index = entrada.next();
                            if (!Helpers.validarId(index)) {
                                do {
                                    System.out.println("Valor no aceptado");
                                    index = entrada.next();

                                } while (!Helpers.validarId(index));
                            }
                            Producto.agregarProducto(db.get(idEncontrado).getProducto(), idEncontrado2, Integer.parseInt(index));
                            System.out.println("Desea ingresar otro producto si/no");
                            rta = entrada.next();
                        } while (rta.equalsIgnoreCase("si"));
                        Producto.eliminarProductoVacio(db.get(idEncontrado).getProducto());
                        System.out.println(db.get(idEncontrado).getProducto());
                        System.out.println("Desea agregar mas productos a otra factura si/no");
                        rta = entrada.next();
                    } while (rta.equalsIgnoreCase("si"));
                    System.out.println("Facturas actuales: " + '\n' + db);
                    break;
                case "M":
                    do {
                        System.out.println("==============================================");
                        System.out.println("Ingrese el id de la factura la cual quiere modificar: ");
                        index = entrada.next();
                        idEncontrado = Factura.encontraId(db, index);
                        if (idEncontrado == -1) {
                            do {
                                System.out.println("Id de Factura no encontrado porfavor digite un id valido");
                                index = entrada.next();
                                idEncontrado = Factura.encontraId(db, index);

                            } while (idEncontrado == -1 && !Helpers.validarId(index));
                        }
                        System.out.println(db.get(idEncontrado).getProducto());
                        do {
                            System.out.println("Ingrese el id del producto que quiere modificar: ");
                            index = entrada.next();
                            idEncontrado2 = Producto.encontraId(db.get(idEncontrado).getProducto(), index);
                            if (idEncontrado2 == -1) {
                                do {
                                    System.out.println("Id de producto no encontrado porfavor digite un id valido");
                                    index = entrada.next();
                                    idEncontrado2 = Producto.encontraId(db.get(idEncontrado).getProducto(), index);

                                } while (idEncontrado2 == -1 && !Helpers.validarId(index));
                            }
                            System.out.println("Digite la cantidad que desea modificar del producto: ");
                            index = entrada.next();
                            if (!Helpers.validarId(index)) {
                                do {
                                    System.out.println("Valor no aceptado");
                                    index = entrada.next();

                                } while (!Helpers.validarId(index));
                            }
                            Producto.modificarProducto(db.get(idEncontrado).getProducto(), idEncontrado2, Integer.parseInt(index));
                            System.out.println("Desea modificar otro producto si/no");
                            rta = entrada.next();
                        } while (rta.equalsIgnoreCase("si"));
                        Producto.eliminarProductoVacio(db.get(idEncontrado).getProducto());
                        System.out.println(db.get(idEncontrado).getProducto());
                        System.out.println("Desea modificar mas productos de otra factura si/no");
                        rta = entrada.next();
                    } while (rta.equalsIgnoreCase("si"));
                    System.out.println("Facturas actuales: " + '\n' + db);
                    break;
                case "D":
                    do {
                        System.out.println("==============================================");
                        System.out.println("Ingrese el id de la factura: ");
                        index = entrada.next();
                        idEncontrado = Factura.encontraId(db, index);
                        if (idEncontrado == -1) {
                            do {
                                System.out.println("Id de Factura no encontrado porfavor digite un id valido");
                                index = entrada.next();
                                idEncontrado = Factura.encontraId(db, index);

                            } while (idEncontrado == -1 && !Helpers.validarId(index));
                        }
                        System.out.println(db.get(idEncontrado).getProducto());
                        do {
                            System.out.println("Ingrese el id del producto que quiere eliminar: ");
                            index = entrada.next();
                            idEncontrado2 = Producto.encontraId(db.get(idEncontrado).getProducto(), index);
                            if (idEncontrado2 == -1) {
                                do {
                                    System.out.println("Id de producto no encontrado porfavor digite un id valido");
                                    index = entrada.next();
                                    idEncontrado2 = Producto.encontraId(db.get(idEncontrado).getProducto(), index);

                                } while (idEncontrado2 == -1 && !Helpers.validarId(index));
                            }
                            if (idEncontrado2 != 0){
                                Producto.eliminarProducto(db.get(idEncontrado).getProducto(),idEncontrado2);
                                System.out.println("NOTA: en caso de que la factura no conenga productos se procedera a su eliminacion");
                                System.out.println(db.get(idEncontrado).getProducto());
                                System.out.println("Desea eliminar otro producto si/no");
                            }
                            if (idEncontrado2 == 0){
                                System.out.println("Actualmente no tienes productos para eliminar");
                                System.out.println("Deseas salir presione cualquier tecla");
                            }
                            rta = entrada.next();
                        } while (rta.equalsIgnoreCase("si") && idEncontrado2 != 0);
                        System.out.println("Desea Eliminar mas productos de otra factura si/no");
                        Factura.eliminarFactura(db, idEncontrado);
                        rta = entrada.next();
                    }while (rta.equalsIgnoreCase("si"));
                    System.out.println("Facturas actuales: " + '\n' + db);
                    break;
                case "RFE":
                    do {
                        System.out.println("==============================================");
                        System.out.println("Ingrese el id de la factura: ");
                        index = entrada.next();
                        idEncontrado = Factura.encontraId(db, index);
                        if (idEncontrado == -1) {
                            do {
                                System.out.println("Id de Factura no encontrado porfavor digite un id valido");
                                index = entrada.next();
                                idEncontrado = Factura.encontraId(db, index);

                            } while (idEncontrado == -1 && !Helpers.validarId(index));
                        }
                        System.out.println(db.get(idEncontrado));
                        System.out.println("Total de la factura es: " + Factura.totalFactura(db.get(idEncontrado)) + "$");
                        System.out.println("Quieres saber la cantidad total de otra factura si/no");
                        rta = entrada.next();
                    }while (rta.equalsIgnoreCase("si"));

                    break;
                case "RTF":
                    System.out.println("Facturas actuales con su total: ");
                    for (Factura factura : db){
                        System.out.println("Factura " + "( id: " + factura.getNumeroFactura() + ") = " + Factura.totalFactura(factura) + "$" );
                    }
                    System.out.println("El total de todas tus facturas es: " + Factura.totalFacturas(db) + "$");
                    break;
                case "RP" :
                    ArrayList<Producto> productos = new ArrayList<>();
                    Producto.agregarInventario(productos, inventario);

                    Factura.cantidadTotalPorProducto(db,productos);

                    System.out.println("El producto mas vendido es: " + Factura.masVendido(productos));
                    break;

                case "Q":
                    System.out.println("adios");
                    entrada.close();
                    break;
                default:
                    System.out.println("Elija una opcion valida");

                    System.out.println();
            }
        }
    }
       // entrada.close();

    public static void mostrarMenu(){
        System.out.println("==============================================");
        System.out.println("Bienvenido al Administrador de Facturas");
        System.out.println("Elija una opcion valida");
        System.out.println("F - Agregar factura");
        System.out.println("A - Agregar producto a factura");
        System.out.println("M - Modificar factura");
        System.out.println("D - Eliminar producto de factura");
        System.out.println("RFE - Total de una factura");
        System.out.println("RTF - Total");
        System.out.println("RP - Producto mas vendido");
        System.out.println("Q - Salir");
        System.out.println("==============================================");
    }}





