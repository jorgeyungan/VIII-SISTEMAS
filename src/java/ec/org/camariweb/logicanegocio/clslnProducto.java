
package ec.org.camariweb.logicanegocio;

import ec.org.camariweb.entidades.clsProducto;
import ec.org.camariweb.funciones.crudProducto;
import java.util.ArrayList;

public class clslnProducto {
    public boolean actualizastock (int idproducto, int nuevostock){
        boolean resultado = false;
        clsProducto prod = new clsProducto();
        prod =  crudProducto.findbyId(idproducto);
        prod.setStock(prod.getStock()-nuevostock);
        resultado = crudProducto.update(prod);
        return resultado;
        
    }

    public boolean actualizarprecio (int idproducto, double porcentaje){
        boolean resultado =  false;
        clsProducto prod = new clsProducto();
        prod = crudProducto.findbyId(idproducto);
        prod.setPrecioventa(prod.getPrecioventa()+prod.getPrecioventa()*porcentaje/100);
        resultado =crudProducto.update(prod);
        return resultado;
    }
    
    public boolean actualizarprecios(double porcentaje){
        boolean resultado = false;
        ArrayList<clsProducto> prods = new ArrayList<>();
        prods = crudProducto.findbyAll();
        for (clsProducto prod : prods) {
            prod.setPrecioventa(prod.getPrecioventa()+prod.getPrecioventa()*porcentaje/100);
        resultado =crudProducto.update(prod);
        }
        
        return resultado;
    }
    public ArrayList<clsProducto> alertamnor5(){
        ArrayList<clsProducto> alerta=new ArrayList<>();
        ArrayList<clsProducto> prods=new ArrayList<>();
        prods = crudProducto.findbyAll();
        for (clsProducto prod : prods) {
            if (prod.getStock()<5) {
                alerta.add(prod);
                
            }
            
        }
        return alerta;
    }
}
        
    