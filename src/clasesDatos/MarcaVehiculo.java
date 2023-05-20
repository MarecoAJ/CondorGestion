/*
* Esta clase es el molde de la tabla marca vehiculo
*/
package clasesDatos;

public class MarcaVehiculo {
// atributos y variables  
    private String _codMarcaVeh;
    private String _descrMarcaVeh;

    public MarcaVehiculo() {}
// metodos de la clase
    public String getCodMarcaVeh() {
        return _codMarcaVeh;
    }

    public void setCodMarcaVeh(String _codMarcaVeh) {
        this._codMarcaVeh = _codMarcaVeh;
    }
    
    public String getDescrMarcaVeh() {
        return _descrMarcaVeh;
    }

    public void setDescrMarcaVeh(String _descrMarcaVeh) {
        this._descrMarcaVeh = _descrMarcaVeh;
    }  
}
