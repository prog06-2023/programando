package facturador.fernando;

import facturador.DataProducts;

import java.util.List;

/**
 * Esta clase sirve para usar metodos auxiliares para el codigo
 * @version 1.0
 * @author Fernando García Cano
 */

public class Helpers {
    public Helpers(){

    }
    /**
     * Este metodo nos ayuda avalidar que la entrada del usuario solo sean numeros
     *
     * @param valor
     * @return
     */
    public static boolean validarId(String valor){
        String validar = "^[0-9]*";
        return valor.matches(validar);
    }

    public static int encontraId(List<DataProducts> db, String valor){
        int idEncontrado = -1;
        for (DataProducts dataProducts : db){
            if (Integer.toString(dataProducts.getId()).equals(valor)){
                idEncontrado = Integer.parseInt(valor);
                return idEncontrado;
            }
        }
        return idEncontrado;
    }
}
