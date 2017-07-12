package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsDfacpro;
import ec.org.camariweb.entidades.clsFactura;


import java.util.ArrayList;

public class clsReportes {
//    listado de todos los clientes con compras mayores a 1000
//    mostrar la nofactura, fecha, total y el nombre del cliente y el ruc
    
    public static ArrayList<clsFactura> clientefacturamayormil() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT \"public\".factura.\"no\",\"public\".factura.fecha,\n" +
"\"public\".factura.total,\"public\".cliente.id,\"public\".cliente.ruc,\"public\".cliente.nombre\n" +
"FROM \"public\".cliente INNER JOIN \"public\".factura \n" +
"ON \"public\".factura.clienteid = \"public\".cliente.\"id\"\n" +
"WHERE \"public\".factura.total > '1000.00'";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNo(cres.getInt("no"));
//                fac.setFecha(cres.getDate("fecha"));
                fac.setTotal(cres.getDouble("total"));
                fac.setIdcliente(crudCliente.findbyid(cres.getInt("id")));                
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    //ejercico 1
    public static ArrayList<clsFactura> sumacompras() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "\"public\".cliente.\"id\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Sum(\"public\".factura.total) AS \"Total\"\n" +
                    "FROM\n" +
                    "\"public\".cliente\n" +
                    "INNER JOIN \"public\".factura ON \"public\".factura.clienteid = \"public\".cliente.\"id\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setTotal(cres.getDouble("total"));
                fac.setIdcliente(crudCliente.findbyid(cres.getInt("id")));                
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    //ejercicio 2
    public static ArrayList<clsFactura> numerocompras() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "\"public\".cliente.\"id\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Count(\"public\".factura.no) AS \"TotalFacturas\"\n" +
                    "FROM\n" +
                    "\"public\".factura\n" +
                    "INNER JOIN \"public\".cliente ON \"public\".factura.clienteid = \"public\".cliente.\"id\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNo(cres.getInt("TotalFacturas"));
                fac.setIdcliente(crudCliente.findbyid(cres.getInt("id")));                
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    //ejercicio 3
    public static ArrayList<clsFactura> numerocomprasytotal() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "\"public\".cliente.\"id\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Count(\"public\".factura.no) AS \"TotalFactura\",\n" +
                    "Sum(\"public\".factura.total) AS \"Valor\"\n" +
                    "FROM\n" +
                    "\"public\".factura\n" +
                    "INNER JOIN \"public\".cliente ON \"public\".factura.clienteid = \"public\".cliente.\"id\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNo(cres.getInt("TotalFactura"));
                fac.setIdcliente(crudCliente.findbyid(cres.getInt("id")));
                fac.setTotal(cres.getDouble("Valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    //ejercicio 4
    public static ArrayList<clsFactura> clientemascompras() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "\"public\".cliente.\"id\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Count(\"public\".factura.no) AS \"N° Facturas\",\n" +
                    "Sum(\"public\".factura.total) AS valor\n" +
                    "FROM\n" +
                    "\"public\".cliente\n" +
                    "INNER JOIN \"public\".factura ON \"public\".factura.clienteid = \"public\".cliente.\"id\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre\n" +
                    "ORDER BY\n" +
                    "\"N° Facturas\" DESC\n" +
                    "LIMIT 1" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNo(cres.getInt("N° Facturas"));
                fac.setIdcliente(crudCliente.findbyid(cres.getInt("id")));
                fac.setTotal(cres.getDouble("valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    //ejercicio 5
    public static ArrayList<clsFactura> clientemenoscompras() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "\"public\".cliente.\"id\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Count(\"public\".factura.no) AS \"N° Facturas\",\n" +
                    "Sum(\"public\".factura.total) AS valor\n" +
                    "FROM\n" +
                    "\"public\".cliente\n" +
                    "INNER JOIN \"public\".factura ON \"public\".factura.clienteid = \"public\".cliente.\"id\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre\n" +
                    "ORDER BY\n" +
                    "\"N° Facturas\" ASc\n" +
                    "LIMIT 1" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNo(cres.getInt("N° Facturas"));
                fac.setIdcliente(crudCliente.findbyid(cres.getInt("id")));
                fac.setTotal(cres.getDouble("valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    //ejercicio 6
    public static ArrayList<clsFactura> promediocompras() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "Count(\"public\".factura.no) AS \"N° Facturas\",\n" +
                    "Sum(\"public\".factura.total) AS valor\n" +
                    "FROM\n" +
                    "\"public\".factura\n" +
                    "ORDER BY\n" +
                    "\"N° Facturas\" ASC" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNo(cres.getInt("N° Facturas"));
                fac.setTotal(cres.getDouble("valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    //ejericcio 7
    public static ArrayList<clsDfacpro> productomasvendido() {
        ArrayList<clsDfacpro> listado = new ArrayList<>();
        String sql = "SELECT\n" +
"\"public\".producto.\"id\",\n" +
"\"public\".producto.nombre,\n" +
"Sum(\"public\".\"DFacturaProducto\".cantidad) AS cantidad,\n" +
"Sum(\"public\".\"DFacturaProducto\".subtotal) AS valor\n" +
"FROM\n" +
"\"public\".producto\n" +
"INNER JOIN \"public\".\"DFacturaProducto\" ON \"public\".\"DFacturaProducto\".idproducto = \"public\".producto.\"id\"\n" +
"GROUP BY\n" +
"\"public\".producto.\"id\",\n" +
"\"public\".producto.nombre\n" +
"ORDER BY\n" +
"cantidad DESC\n" +
"LIMIT 1" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDfacpro pro = null;
            while (cres.next())
            {
                pro = new clsDfacpro();
                pro.setCantidad(cres.getInt("cantidad"));
                pro.setIdproducto(crudProducto.findbyId(cres.getInt("id")));
                pro.setSubtotal(cres.getDouble("valor"));
                listado.add((pro));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
    public static ArrayList<clsDfacpro> productomenosvendido() {
        ArrayList<clsDfacpro> listado = new ArrayList<>();
        String sql = "SELECT\n" +
"\"public\".producto.\"id\",\n" +
"\"public\".producto.nombre,\n" +
"Sum(\"public\".\"DFacturaProducto\".cantidad) AS cantidad,\n" +
"Sum(\"public\".\"DFacturaProducto\".subtotal) AS valor\n" +
"FROM\n" +
"\"public\".producto\n" +
"INNER JOIN \"public\".\"DFacturaProducto\" ON \"public\".\"DFacturaProducto\".idproducto = \"public\".producto.\"id\"\n" +
"GROUP BY\n" +
"\"public\".producto.\"id\",\n" +
"\"public\".producto.nombre\n" +
"ORDER BY\n" +
"cantidad ASC\n" +
"LIMIT 1" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDfacpro pro = null;
            while (cres.next())
            {
                pro = new clsDfacpro();
                pro.setCantidad(cres.getInt("cantidad"));
                pro.setIdproducto(crudProducto.findbyId(cres.getInt("id")));
                pro.setSubtotal(cres.getDouble("valor"));
                listado.add((pro));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
    public static ArrayList<clsDfacpro> ventasporproducto() {
        ArrayList<clsDfacpro> listado = new ArrayList<>();
        String sql = "SELECT\n" +
"\"public\".producto.\"id\",\n" +
"\"public\".producto.nombre,\n" +
"Sum(\"public\".\"DFacturaProducto\".cantidad) AS cantidad,\n" +
"Sum(\"public\".\"DFacturaProducto\".subtotal) AS valor\n" +
"FROM\n" +
"\"public\".producto\n" +
"INNER JOIN \"public\".\"DFacturaProducto\" ON \"public\".\"DFacturaProducto\".idproducto = \"public\".producto.\"id\"\n" +
"GROUP BY\n" +
"\"public\".producto.\"id\",\n" +
"\"public\".producto.nombre" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDfacpro pro = null;
            while (cres.next())
            {
                pro = new clsDfacpro();
                pro.setCantidad(cres.getInt("cantidad"));
                pro.setIdproducto(crudProducto.findbyId(cres.getInt("id")));
                pro.setSubtotal(cres.getDouble("valor"));
                listado.add((pro));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
}
