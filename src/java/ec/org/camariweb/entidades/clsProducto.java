
package ec.org.camariweb.entidades;

public class clsProducto {
    private int _id;
    private String _nombre;
    private int _stock;
    private Double _precioventa;

    public clsProducto() {
    }

    public clsProducto(int _id, String _nombre, int _stock, Double _precioventa) {
        this._id = _id;
        this._nombre = _nombre;
        this._stock = _stock;
        this._precioventa = _precioventa;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int getStock() {
        return _stock;
    }

    public void setStock(int _stock) {
        this._stock = _stock;
    }

    public Double getPrecioventa() {
        return _precioventa;
    }

    public void setPrecioventa(Double _precioventa) {
        this._precioventa = _precioventa;
    }

    @Override
    public String toString() {
        return "clsProducto{" + "_id=" + _id + ", _nombre=" + _nombre + ", _stock=" + _stock + ", _precioventa=" + _precioventa + '}';
    }

    
}
