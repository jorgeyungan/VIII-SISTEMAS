/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsDfacpro;
import java.util.ArrayList;


public class crudDfacpro {
    public static boolean save(clsDfacpro dfacpro)
    {
        boolean r = false;
        String sql = "INSERT INTO public.dfacpro (nofactura,idproducto,cantidad,subtotal)"
                + "values (?,?,?,?)";
        ArrayList<Parametro> lst =new ArrayList<>();
        lst.add(new Parametro(1, dfacpro.getNofactura().getNo()));
        lst.add(new Parametro(2, dfacpro.getIdproducto().getId()));
        lst.add(new Parametro(3, dfacpro.getCantidad()));
        lst.add(new Parametro(4, dfacpro.getSubtotal()));
        try {
            r = AccesoDatos.ejecutaComando(sql, lst);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return r;
    }
    public static boolean delete(clsDfacpro dfacpro)
    {
        boolean r = false;
        String sql = "delete from public.dfacpro where id=?";
        ArrayList<Parametro> lst =new ArrayList<>();
        lst.add(new Parametro(1, dfacpro.getId()));
        try {
            r = AccesoDatos.ejecutaComando(sql, lst);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
    public static boolean update(clsDfacpro dfacpro)
    {
        boolean r = false;
        String sql = "update public.dfacpro"
                + "set nofactura=?,idproducto=?, cantidad=?, subtotal=?"
                + "where id=?";
        ArrayList<Parametro> lst =new ArrayList<>();
        lst.add(new Parametro(1, dfacpro.getNofactura().getNo()));
        lst.add(new Parametro(2, dfacpro.getIdproducto().getId()));
        lst.add(new Parametro(3, dfacpro.getCantidad()));
        lst.add(new Parametro(4, dfacpro.getSubtotal()));
        lst.add(new Parametro(5, dfacpro.getId()));
        try {
            r = AccesoDatos.ejecutaComando(sql, lst);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
    public static ArrayList<clsDfacpro> findbyAll() {
        ArrayList<clsDfacpro> listado = new ArrayList<>();
        String sql = "SELECT id,nofactura,idproducto,cantidad,subtotal "+
                "FROM public.dfacpro";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDfacpro facpro = null;
            while (cres.next())
            {
                facpro = new clsDfacpro();
                facpro.setId(cres.getInt("id"));
                facpro.setNofactura(crudFactura.findbyId(cres.getInt("nofactura")));
                facpro.setIdproducto(crudProducto.findbyId(cres.getInt("idproducto")));
                facpro.setCantidad(cres.getInt("cantidad"));
                facpro.setSubtotal(cres.getDouble("subtotal"));
                listado.add((facpro));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    public static clsDfacpro FindbyId(clsDfacpro dfacp) {
        clsDfacpro dfp = null;
        String sql = "SELECT id,nofactura,idproducto,cantidad,subtotal FROM public.dfacpro WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, dfacp.getId()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                dfp = new clsDfacpro();
                dfp.setId(cres.getInt("id"));
                dfp.setNofactura(crudFactura.findbyId(cres.getInt("nofactura")));
                dfp.setIdproducto(crudProducto.findbyId(cres.getInt("idproducto")));
                dfp.setCantidad(cres.getInt("cantidad"));
                dfp.setSubtotal(cres.getDouble("subtotal"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dfp;
    }
    public static clsDfacpro findbyId(int dfacp) {
        clsDfacpro dfp = null;
        String sql = "SELECT id,nofactura,idproducto,cantidad,subtotal FROM public.dfacpro WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,dfacp));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                dfp = new clsDfacpro();
                dfp.setId(cres.getInt("id"));
                dfp.setNofactura(crudFactura.findbyId(cres.getInt("nofactura")));
                dfp.setIdproducto(crudProducto.findbyId(cres.getInt("idproducto")));
                dfp.setCantidad(cres.getInt("cantidad"));
                dfp.setSubtotal(cres.getDouble("subtotal"));           
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dfp;
    }
}
