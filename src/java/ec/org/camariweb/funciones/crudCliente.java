package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsCliente;
import java.util.ArrayList;



public class crudCliente {

//    static clsCliente findbyId(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public static boolean save(clsCliente cliente){
        boolean resultado = false;
        String sql = "INSERT INTO public.cliente(ruc,nombre,direccion) "
                + "VALUES(?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getRuc()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getDireccion()));        
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    public static boolean delete(clsCliente cliente) {
        boolean res=false;
        String sql = "DELETE FROM public.cliente WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,cliente.getId()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public static boolean update(clsCliente cliente) {
        boolean res = false;
        String sql = "UPDATE public.cliente " +
                "SET ruc=?,nombre=?,direccion=? " + 
                "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, cliente.getRuc()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getDireccion())); 
        lstPar.add(new Parametro(4,cliente.getId()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public static ArrayList<clsCliente> findbyAll() {
        ArrayList<clsCliente> listado = new ArrayList<>();
        String sql = "SELECT id,ruc,nombre,direccion "+
                "FROM public.cliente";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsCliente cliente = null;
            while (cres.next())
            {
                cliente = new clsCliente();
                cliente.setId(cres.getInt("id"));
                cliente.setRuc(cres.getString("ruc"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setDireccion(cres.getString("direccion"));
                listado.add((cliente));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static clsCliente findbyid(clsCliente cli) {
        clsCliente cliente = null;
        String sql = "SELECT id,ruc,nombre,direccion FROM public.cliente WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cli.getId()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsCliente();
                 cliente.setId(cres.getInt("id"));
                cliente.setRuc(cres.getString("ruc"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setDireccion(cres.getString("direccion"));            
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
    public static clsCliente findbyid(int cli) {
        clsCliente cliente = null;
        String sql = "SELECT id,ruc,nombre,direccion FROM public.cliente WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,cli));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsCliente();
                cliente.setId(cres.getInt("id"));
                cliente.setRuc(cres.getString("ruc"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setDireccion(cres.getString("direccion"));           
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
}
