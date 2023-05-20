/*
 *
 */
package clasesDatos;

public class DetallesDeCaja {
    
    private int _iuCaja;
    private int _iuDetalleCaja;
    private int _iuTipoPago;
    private Double _subTotal;

    public DetallesDeCaja() {}

    public int getIuCaja() {
        return _iuCaja;
    }

    public void setIuCaja(int _iuCaja) {
        this._iuCaja = _iuCaja;
    }

    public int getIuDetalleCaja() {
        return _iuDetalleCaja;
    }

    public void setIuDetalleCaja(int _iuDetalleCaja) {
        this._iuDetalleCaja = _iuDetalleCaja;
    }

    public int getIuTipoPago() {
        return _iuTipoPago;
    }

    public void setIuTipoPago(int _iuTipoPago) {
        this._iuTipoPago = _iuTipoPago;
    }

    public Double getSubTotal() {
        return _subTotal;
    }

    public void setSubTotal(Double _subTotal) {
        this._subTotal = _subTotal;
    }  
}
