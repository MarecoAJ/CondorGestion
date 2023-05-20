/*
* Esta clase es el molde de la tabla catalogocristales
*/
package clasesDatos;


public class CatalogoCristales {
// atributos y variables  
    private String _codigoCristal;
    private String _codModeloVeh;
    private int _iuMarcaCris;
    private String _descrCristal;
    private int _cantidadMinima;
    private int _cantidadExistencia;
    private Double _precioPieza;

    public CatalogoCristales() {}
// metodos de la clase
    public String getCodigoCristal() {
        return _codigoCristal;
    }

    public void setCodigoCristal(String _codigoCristal) {
        this._codigoCristal = _codigoCristal;
    }

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

    public String getDescrCristal() {
        return _descrCristal;
    }

    public void setDescrCristal(String _descrCristal) {
        this._descrCristal = _descrCristal;
    }

    public Double getPrecioPieza() {
        return _precioPieza;
    }

    public void setPrecioPieza(Double _precioPieza) {
        this._precioPieza = _precioPieza;
    }

    public int getCantidadMinima() {
        return _cantidadMinima;
    }

    public void setCantidadMinima(int _cantidadMinima) {
        this._cantidadMinima = _cantidadMinima;
    }

    public int getCantidadExistencia() {
        return _cantidadExistencia;
    }

    public void setCantidadExistencia(int _cantidadExistencia) {
        this._cantidadExistencia = _cantidadExistencia;
    }
}
