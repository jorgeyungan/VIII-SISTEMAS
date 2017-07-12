package ec.org.camariweb.accesodatos;

public final  class Global {    
    public final static String URL;
    public final static String DRIVER;
    public final static String USER;
    public final static String PASS;
    static{
        URL=getValor("url");
        DRIVER=getValor("driver");
        USER=getValor("usuario");
        PASS=getValor("clave");        
    }
     public static String getValor(String clave) {
        java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("ec.org.camariweb.accesodatos.database");
        return  Configuracion.getString(clave);
     }    
}
