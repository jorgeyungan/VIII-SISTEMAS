
package ec.org.camariweb.entidades;


public class clsFactura {
    private int _no;
    private clsCliente _idcliente;
    private Double _subtotal;
    private Double _iva;
    private Double _total;

    public clsFactura() {
    }

    public clsFactura(int _no, clsCliente _idcliente, Double _subtotal, Double _iva, Double _total) {
        this._no = _no;
        this._idcliente = _idcliente;
        this._subtotal = _subtotal;
        this._iva = _iva;
        this._total = _total;
    }

    public int getNo() {
        return _no;
    }

    public void setNo(int _no) {
        this._no = _no;
    }

    public clsCliente getIdcliente() {
        return _idcliente;
    }

    public void setIdcliente(clsCliente _idcliente) {
        this._idcliente = _idcliente;
    }

    public Double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(Double _subtotal) {
        this._subtotal = _subtotal;
    }

    public Double getIva() {
        return _iva;
    }

    public void setIva(Double _iva) {
        this._iva = _iva;
    }

    public Double getTotal() {
        return _total;
    }

    public void setTotal(Double _total) {
        this._total = _total;
    }
    
}
