/*
*Esta clase es el molde de la tabla marca cristal
*/
package clasesDatos;

public class MarcasCristales {
//atributos y variables de la clase  
    private int _iuMarcaCris;
    private String _descrMarcaCris;

    public MarcasCristales() {}
// metodos de la clase
    public int getIuMarcaCris() {
        return _iuMarcaCris;
    }

    public void setIuMarcaCris(int _iuMarcaCris) {
        this._iuMarcaCris = _iuMarcaCris;
    }

    public String getDescrMarcaCris() {
        return _descrMarcaCris;
    }

    public void setDescrMarcaCris(String _descrMarcaCris) {
        this._descrMarcaCris = _descrMarcaCris;
    }   
}
