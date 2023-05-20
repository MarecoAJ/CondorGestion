/*
 * Esta clase es el molde la tabla tipo caja
 */
package clasesDatos;


public class TipoCaja {
// atributos y variables
    private int _iuTipoCaja;
    private String _descrTipoCaja;

    public TipoCaja() {}
//metodos de la clase
    public int getIuTipoCaja() {
        return _iuTipoCaja;
    }

    public void setIuTipoCaja(int _iuTipoCaja) {
        this._iuTipoCaja = _iuTipoCaja;
    }

    public String getDescrTipoCaja() {
        return _descrTipoCaja;
    }

    public void setDescrTipoCaja(String _descrTipoCaja) {
        this._descrTipoCaja = _descrTipoCaja;
    }  
}
