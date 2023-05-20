
package clasesDatos;


public class ExamenVehiculo {
    
    private int _numExamenVeh;
    private String _nombExaminador;
    private String _dominioVeh;
    private int _iuCartera;
    private String _fechaExamen;
    private String _posibleRetirador;

    public ExamenVehiculo() {
    }

    public int getNumExamenVeh() {
        return _numExamenVeh;
    }

    public void setNumExamenVeh(int _numExamenVeh) {
        this._numExamenVeh = _numExamenVeh;
    }

    public String getNombExaminador() {
        return _nombExaminador;
    }

    public void setNombExaminador(String _nombExaminador) {
        this._nombExaminador = _nombExaminador;
    }

    public int getIuCartera() {
        return _iuCartera;
    }

    public void setIuCartera(int _iuCartera) {
        this._iuCartera = _iuCartera;
    }

    public String getFechaExamen() {
        return _fechaExamen;
    }

    public void setFechaExamen(String _fechaExamen) {
        this._fechaExamen = _fechaExamen;
    }

    public String getPosibleRetirador() {
        return _posibleRetirador;
    }

    public void setPosibleRetirador(String _posibleRetirador) {
        this._posibleRetirador = _posibleRetirador;
    }



    public String getDominioVeh() {
        return _dominioVeh;
    }

    public void setDominioVeh(String _dominioVeh) {
        this._dominioVeh = _dominioVeh;
    }
    
    
}
