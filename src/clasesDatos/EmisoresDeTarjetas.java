/*
 * Esta clase es el molde la tabla emisores de tarjetas. esta tabla se usa para registrar
 * todas las tarjetas. Ej: naranja
 */
package clasesDatos;


public class EmisoresDeTarjetas {
// atributos y variables    
    private int _iuEmisorDeTarjeta;
    private String _descrEmisor;

    public EmisoresDeTarjetas() {}
// metodos de la clase
    public int getIuEmisorDeTarjeta() {
        return _iuEmisorDeTarjeta;
    }

    public void setIuEmisorDeTarjeta(int _iuEmisorDeTarjeta) {
        this._iuEmisorDeTarjeta = _iuEmisorDeTarjeta;
    }

    public String getDescrEmisor() {
        return _descrEmisor;
    }

    public void setDescrEmisor(String _descrEmisor) {
        this._descrEmisor = _descrEmisor;
    }  
}
