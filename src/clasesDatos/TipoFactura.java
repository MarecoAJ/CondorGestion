/*
 * Esta clase es el molde la tabla tipo factura
 */
package clasesDatos;


public class TipoFactura {
// atributos y variables
    private int _iuTipoFactura;
    private String _descrTipoFactura;

    public TipoFactura() {}
//metodos de la clase
    public int getIuTipoFactura() {
        return _iuTipoFactura;
    }

    public void setIuTipoFactura(int _iuTipoFactura) {
        this._iuTipoFactura = _iuTipoFactura;
    }

    public String getDescrTipoFactura() {
        return _descrTipoFactura;
    }

    public void setDescrTipoFactura(String _descrTipoFactura) {
        this._descrTipoFactura = _descrTipoFactura;
    }  
}
