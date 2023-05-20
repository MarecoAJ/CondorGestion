/*
 * Esta clase es el molde la tabla tipo pagos
 */
package clasesDatos;

public class TipoPagos {
// atributos y variables    
    private int _iuTipoPago;
    private String _descrTipoPago;

    public TipoPagos() {}
//metodos de la clase
    public int getIuTiposPagos() {
        return _iuTipoPago;
    }

    public void setIuTiposPagos(int _iuTipoPago) {
        this._iuTipoPago = _iuTipoPago;
    }

    public String getDescrTiposPagos() {
        return _descrTipoPago;
    }

    public void setDescrTiposPagos(String _descrTipoPago) {
        this._descrTipoPago = _descrTipoPago;
    }   
}
