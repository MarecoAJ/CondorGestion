/*
* Esta clase es el molde de la tabla modelo vehiculo
*/
package clasesDatos;

public class ModeloVehiculo extends MarcaVehiculo{
// atributos y variables    
    private String _codModeloVeh;
    private String _descrModeloVeh;

    public ModeloVehiculo() {}
// metodos de la clase
    public String getCodModeloVeh() {
        return _codModeloVeh;
    }

    public void setCodModeloVeh(String _codModeloVeh) {
        this._codModeloVeh = _codModeloVeh;
    }

    public String getDescrModeloVeh() {
        return _descrModeloVeh;
    }

    public void setDescrModeloVeh(String _descrModeloVeh) {
        this._descrModeloVeh = _descrModeloVeh;
    } 
}
