
package ec.org.camariweb.entidades;

public class clsDfacpro {
    private int _id;
    private clsFactura _nofactura;
    private clsProducto _idproducto;
    private int _cantidad;
    private Double _subtotal;

    public clsDfacpro() {
    }

    public clsDfacpro(int _id, clsFactura _nofactura, clsProducto _idproducto, int _cantidad, Double _subtotal) {
        this._id = _id;
        this._nofactura = _nofactura;
        this._idproducto = _idproducto;
        this._cantidad = _cantidad;
        this._subtotal = _subtotal;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public clsFactura getNofactura() {
        return _nofactura;
    }

    public void setNofactura(clsFactura _nofactura) {
        this._nofactura = _nofactura;
    }

    public clsProducto getIdproducto() {
        return _idproducto;
    }

    public void setIdproducto(clsProducto _idproducto) {
        this._idproducto = _idproducto;
    }

    public int getCantidad() {
        return _cantidad;
    }

    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    public Double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(Double _subtotal) {
        this._subtotal = _subtotal;
    }

    @Override
    public String toString() {
        return "clsDfacpro{" + "_id=" + _id + ", _nofactura=" + _nofactura + ", _idproducto=" + _idproducto + ", _cantidad=" + _cantidad + ", _subtotal=" + _subtotal + '}';
    }

    
}
