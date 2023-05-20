/*
 * Esta clase es el molde la tabla seguros
 */
package clasesDatos;

public class Seguros {
// atributos y variables    
    private int _iuSeguros;
    private String _descrSeguros;

    public Seguros() {}
// metodos de la clase 
    public int getIuSeguros() {
        return _iuSeguros;
    }

    public void setIuSeguros(int _iuSeguros) {
        this._iuSeguros = _iuSeguros;
    }

    public String getDescrSeguros() {
        return _descrSeguros;
    }

    public void setDescrSeguros(String _descrSeguros) {
        this._descrSeguros = _descrSeguros;
    }
}
