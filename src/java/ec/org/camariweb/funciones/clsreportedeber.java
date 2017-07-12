
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsFactura;
import java.util.ArrayList;

public class clsreportedeber {
    //NUMERO DE COMPRAS QUE HIZO EL CLIENTE
 public static ArrayList<clsFactura> numeroCompraCliente() {
 ArrayList<clsFactura> listado = new ArrayList<>();
 String sql = "SELECT "
 + "\"public\".cliente.nombre, "
 + "Count(\"public\".factura.\"no\") AS \"Numero de compras\" "
 + "FROM "
 + "\"public\".cliente, INNER JOIN"
 + "\"public\".factura"
 + "ON"
 + "\"public\".factura.clienteid = \"public\".cliente.\"id\""
 + "GROUP BY"
 + "\"public\".cliente.nombre";

 ArrayList<Parametro> lstPar = new ArrayList<>();
 try {
 ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
 clsFactura factura = null;
 while (cres.next()) {
 factura = new clsFactura();

 factura.setNo(cres.getInt("no"));
 factura.setIdcliente(crudCliente.findbyid(cres.getInt("clienteid")));
 listado.add((factura));
 }
 } catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listado;
 }
// NUMERO DE COMPRAS Y TOTAL
 public static ArrayList<clsFactura> numeroComprasTotal() {
 ArrayList<clsFactura> listado = new ArrayList<>();
 String sql = "SELECT "
 + "Count(\"public\".factura.\"no\") AS NUMERO_COMPRAS "
 + "sum(\"public\".factura.total) AS total"
 + "FROM "
 + "\"public\".factura";

 ArrayList<Parametro> lstPar = new ArrayList<>();
 try {
 ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
 clsFactura factura = null;
 while (cres.next()) {
 factura = new clsFactura();

 factura.setNo(cres.getInt("no"));
 factura.setTotal(cres.getDouble("total"));

 listado.add((factura));
 }
 } catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listado;
 }
// EL PROMEDIO DE COMPRAS
 public static ArrayList<clsFactura> promedioCompra() {
 ArrayList<clsFactura> listado = new ArrayList<>();
 String sql = "SELECT "
 + "AVG(\"public\".factura.total) as Promedio "
 + "FROM "
 + "\"public\".factura";

 ArrayList<Parametro> lstPar = new ArrayList<>();
 try {
 ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
 clsFactura factura = null;
 while (cres.next()) {
 factura = new clsFactura();
 factura.setTotal(cres.getDouble("total"));

 listado.add((factura));
 }
 } catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listado;
 }
}
