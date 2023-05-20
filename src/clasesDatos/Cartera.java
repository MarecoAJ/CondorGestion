/*
 *
 */
package clasesDatos;

public class Cartera {
    
    private int _iuCartera;
    private int _iuTipoCartera;
    private String _dniOCuit;
    private String _nombCompleto;
    private String _direccionCartera;

    public Cartera() {
    }

    public int getIuCartera() {
        return _iuCartera;
    }

    public void setIuCartera(int _iuCartera) {
        this._iuCartera = _iuCartera;
    }

    public int getIuTipoCartera() {
        return _iuTipoCartera;
    }

    public void setIuTipoCartera(int _iuTipoCartera) {
        this._iuTipoCartera = _iuTipoCartera;
    }

    public String getDniOCuit() {
        return _dniOCuit;
    }

    public void setDniOCuit(String _dniOCuit) {
        this._dniOCuit = _dniOCuit;
    }

    public String getNombCompleto() {
        return _nombCompleto;
    }

    public void setNombCompleto(String _nombCompleto) {
        this._nombCompleto = _nombCompleto;
    }

    public String getDireccionCartera() {
        return _direccionCartera;
    }

    public void setDireccionCartera(String _direccionCartera) {
        this._direccionCartera = _direccionCartera;
    }
    
    
}
