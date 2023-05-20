/*
 * Esta clase es el molde la tabla tipo cartera
 */
package clasesDatos;

public class TipoCartera {
// atributos y variables    
    private int _iuTipoCartera;
    private String _descrTipoCartera;

    public TipoCartera() {}
//metodos de la clase

    public int getIuTipoCartera() {
        return _iuTipoCartera;
    }

    public void setIuTipoCartera(int _iuTipoCartera) {
        this._iuTipoCartera = _iuTipoCartera;
    }

    public String getDescrTipoCartera() {
        return _descrTipoCartera;
    }

    public void setDescrTipoCartera(String _descrTipoCartera) {
        this._descrTipoCartera = _descrTipoCartera;
    }
   
}
