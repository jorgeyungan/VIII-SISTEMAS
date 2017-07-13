/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.controlador;


import ec.org.camariweb.entidades.clsCliente;
import ec.org.camariweb.entidades.clsDfacpro;
import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.entidades.clsProducto;
import ec.org.camariweb.funciones.crudDfacpro;
import ec.org.camariweb.funciones.crudFactura;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class cFacturas {
    private List<clsFactura> lista;
    private clsFactura newfactura;//ingrese un priente nuevo
    private clsFactura selectedfactura;//cuando seleccione un cliente para borrar o actualizar
    private clsCliente selectedCliente;

    public cFacturas() {
        newfactura = new clsFactura();
        cargardatos();
    }
    
    private void cargardatos(){
        lista = crudFactura.findbyAll();
    }
    public void insertar(){
        newfactura.setIdcliente(selectedCliente);
        
        if (crudFactura.save(newfactura)) {
            
            newfactura = new clsFactura();
            cargardatos();
        }
        else{
            //mostrar un mensaje de no guardado
        }
    }
    
    public void eliminar(){
        if (crudFactura.delete(selectedfactura)) {
            newfactura = new clsFactura();//prepara el contructor de un posible nuevo cliente
            cargardatos();//refresca el data grid
            //mostrar un mensaje
        }
        else{
            //mostrar un mensaje de no guardado
        }
    }
    
    public void actualizar(){
        if (crudFactura.delete(selectedfactura)) {
            newfactura = new clsFactura();//prepara el contructor de un posible nuevo cliente
            cargardatos();//refresca el data grid
            //mostrar un mensaje
        }
        else{
            //mostrar un mensaje de no guardado
        }
    }

    public List<clsFactura> getLista() {
        return lista;
    }

    public void setLista(List<clsFactura> lista) {
        this.lista = lista;
    }

    public clsFactura getNewfactura() {
        return newfactura;
    }

    public void setNewfactura(clsFactura newfactura) {
        this.newfactura = newfactura;
    }

    public clsFactura getSelectedfactura() {
        return selectedfactura;
    }

    public void setSelectedfactura(clsFactura selectedfactura) {
        this.selectedfactura = selectedfactura;
    }

    public clsCliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(clsCliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    
    

    
}
