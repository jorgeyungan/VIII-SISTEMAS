
package ec.org.camariweb.controlador;

import ec.org.camariweb.entidades.clsDfacpro;
import ec.org.camariweb.funciones.crudDfacpro;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class cDfacPro {
    private List<clsDfacpro> lista;
    private clsDfacpro newdetalle;
    private clsDfacpro selecteddetalle;
    

    public cDfacPro() {
        newdetalle = new clsDfacpro();
        cargardatos();
    }
    private void cargardatos(){
        lista = crudDfacpro.findbyAll();
    }
    private void insertar(){
        if (crudDfacpro.save(newdetalle)) {//guarda el cliente
            newdetalle = new clsDfacpro();//prepara el contructor de un posible nuevo cliente
            cargardatos();//refresca el datagrid con los cambios (aparrece el nuevo cliente)
            //mostrar un mensaje
        }
        else{
            //mostrar un mensaje de no guardado
        }
    }
    
    private void eliminar(){
        if (crudDfacpro.delete(selecteddetalle)) {
            newdetalle = new clsDfacpro();//prepara el contructor de un posible nuevo cliente
            cargardatos();//refresca el data grid
            //mostrar un mensaje
        }
        else{
            //mostrar un mensaje de no guardado
        }
    }
    
    private void actualizar(){
        if (crudDfacpro.delete(selecteddetalle)) {
            newdetalle = new clsDfacpro();//prepara el contructor de un posible nuevo cliente
            cargardatos();//refresca el data grid
            //mostrar un mensaje
        }
        else{
            //mostrar un mensaje de no guardado
        }
    }

    public clsDfacpro getNewdetalle() {
        return newdetalle;
    }

    public void setNewdetalle(clsDfacpro newdetalle) {
        this.newdetalle = newdetalle;
    }

    public clsDfacpro getSelecteddetalle() {
        return selecteddetalle;
    }

    public void setSelecteddetalle(clsDfacpro selecteddetalle) {
        this.selecteddetalle = selecteddetalle;
    }

    public List<clsDfacpro> getLista() {
        return lista;
    }

    public void setLista(List<clsDfacpro> lista) {
        this.lista = lista;
    }
    
    
}
