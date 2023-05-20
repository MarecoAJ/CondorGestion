/*
* Esta clase es el molde de la tabla catalogocristales
*/
package clasesDatos;

public class Pedidos {
// atributos y variables   
    private String _fechaPedido;
    private String _codigoCristal;
    private String _codModeloVeh;
    private int _iuMarcaCris;
    private int _cantidadPiezas;

    public Pedidos() {}
// metodos de la clase
    public String getCodModeloVeh() {
        return _codModeloVeh;
    }

    public void setCodModeloVeh(String _codModeloVeh) {
        this._codModeloVeh = _codModeloVeh;
    }

    public int getIuMarcaCris() {
        return _iuMarcaCris;
    }

    public void setIuMarcaCris(int _iuMarcaCris) {
        this._iuMarcaCris = _iuMarcaCris;
    }

    public String getFechaPedido() {
        return _fechaPedido;
    }

    public void setFechaPedido(String _fechaPedido) {
        this._fechaPedido = _fechaPedido;
    }

    public String getCodigoCristal() {
        return _codigoCristal;
    }

    public void setCodigoCristal(String _codigoCristal) {
        this._codigoCristal = _codigoCristal;
    }

    public int getCantidadPiezas() {
        return _cantidadPiezas;
    }

    public void setCantidadPiezas(int _cantidadPiezas) {
        this._cantidadPiezas = _cantidadPiezas;
    }
}
