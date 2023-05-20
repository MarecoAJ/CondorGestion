/*
* Esta clase es el molde de la tabla marca vehiculo
*/
package clasesDatos;

public class Caja {
// atributos y variables  
    private int _iuCaja;
    private int _iuTipoCaja;
    private int _iuTipoFactura;
    private String _fechaCaja;
    private String _fechaFactura;
    private String _aNombreDe;
    private int _numFactura;
    private String _descrCaja;
    private Double _totalCaja;

    public Caja() {}
// metodos de la clase
    public int getIuCaja() {
        return _iuCaja;
    }

    public void setIuCaja(int _iuCaja) {
        this._iuCaja = _iuCaja;
    }

    public int getIuTipoCaja() {
        return _iuTipoCaja;
    }

    public void setIuTipoCaja(int _iuTipoCaja) {
        this._iuTipoCaja = _iuTipoCaja;
    }

    public int getIuTipoFactura() {
        return _iuTipoFactura;
    }

    public void setIuTipoFactura(int _iuTipoFactura) {
        this._iuTipoFactura = _iuTipoFactura;
    }

    public String getFechaCaja() {
        return _fechaCaja;
    }

    public void setFechaCaja(String _fechaCaja) {
        this._fechaCaja = _fechaCaja;
    }

    public String getFechaFactura() {
        return _fechaFactura;
    }

    public void setFechaFactura(String _fechaFactura) {
        this._fechaFactura = _fechaFactura;
    }

    public String getANombreDe() {
        return _aNombreDe;
    }

    public void setANombreDe(String _aNombreDe) {
        this._aNombreDe = _aNombreDe;
    }

    public int getNumFactura() {
        return _numFactura;
    }

    public void setNumFactura(int _numFactura) {
        this._numFactura = _numFactura;
    }

    public String getDescrCaja() {
        return _descrCaja;
    }

    public void setDescrCaja(String _descrCaja) {
        this._descrCaja = _descrCaja;
    }

    public Double getTotalCaja() {
        return _totalCaja;
    }

    public void setTotalCaja(Double _totalCaja) {
        this._totalCaja = _totalCaja;
    }
}
