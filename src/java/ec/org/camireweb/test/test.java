
package ec.org.camireweb.test;

import ec.org.camariweb.entidades.clsCliente;
import ec.org.camariweb.funciones.crudCliente;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<clsCliente> factura = new ArrayList<>();
    factura = crudCliente.findbyAll();
    System.out.print(factura.toString());
    }
}
