package ec.org.camariweb.controlador;

import ec.org.camariweb.entidades.clsProducto;
import ec.org.camariweb.funciones.crudProducto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class cProducto {

    public cProducto() {
        newproducto =  new clsProducto();
        cargardatos();
    }
    private clsProducto newproducto;
    private clsProducto selectedproducto;
    private List<clsProducto> lista;
    
    private void cargardatos(){
        lista=crudProducto.findbyAll();
    }

    public clsProducto getNewproducto() {
        return newproducto;
    }

    public void setNewproducto(clsProducto newproducto) {
        this.newproducto = newproducto;
    }

    public clsProducto getSelectedproducto() {
        return selectedproducto;
    }

    public void setSelectedproducto(clsProducto selectedproducto) {
        this.selectedproducto = selectedproducto;
    }

    public List<clsProducto> getLista() {
        return lista;
    }

    public void setLista(List<clsProducto> lista) {
        this.lista = lista;
    }
    
    
}
