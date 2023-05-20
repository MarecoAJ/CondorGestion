/*
 * Esta clase es el molde la tabla servicios pretados
 */
package clasesDatos;


public class ServiciosPrestados {
// atributos y variables    
    private int _iuServicios;
    private String _descrServicios;
    private double _precioServ;

    public ServiciosPrestados() {}
//metodos de la clase
    public int getIuServicios() {
        return _iuServicios;
    }

    public void setIuServicios(int _iuServicios) {
        this._iuServicios = _iuServicios;
    }

    public String getDescrServicio() {
        return _descrServicios;
    }

    public void setDescrServicio(String _descrServicios) {
        this._descrServicios = _descrServicios;
    }

    public double getPrecioServ() {
        return _precioServ;
    }

    public void setPrecioServ(double _precioServ) {
        this._precioServ = _precioServ;
    }  
}
