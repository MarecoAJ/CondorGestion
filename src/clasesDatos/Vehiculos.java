/*
* Esta clase es el molde de la tabla vehiculos
*/
package clasesDatos;


public class Vehiculos {
// atributos y variables 
    private String _dominioVeh;
    private String _codModeloVeh;
    private int _anioVeh;

    public Vehiculos() {}
// metodos de la clase
    public String getDominioVeh() {
        return _dominioVeh;
    }

    public void setDominioVeh(String _dominioVeh) {
        this._dominioVeh = _dominioVeh;
    }

    public String getCodModeloVeh() {
        return _codModeloVeh;
    }

    public void setCodModeloVeh(String _codModeloVeh) {
        this._codModeloVeh = _codModeloVeh;
    }

    public int getAnioVeh() {
        return _anioVeh;
    }

    public void setAnioVeh(int _anioVeh) {
        this._anioVeh = _anioVeh;
    }
    
    
    
}
