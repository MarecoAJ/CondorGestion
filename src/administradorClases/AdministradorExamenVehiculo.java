/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static controladorBD.ConectorMySql.desconectarMySql;
import static controladorBD.ConectorMySql.getConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import clasesDatos.ExamenVehiculo;

public class AdministradorExamenVehiculo {
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;  
    private String _resultFiltrar= "fechaInsercion DESC";
    private String _mySqlSentencia2;
    private final DefaultListModel _modeloJList;
    private final AdministradorCartera _administradorCartera;

    public AdministradorExamenVehiculo() {
          
        _modeloJList = new DefaultListModel();
        _administradorCartera = new AdministradorCartera();
    }
   
// se pasa el valor de orden y acomoda los datos por ese tipo        
    public String ordenarTabla(String valor){
 
        switch(valor){
    
            case "Primeros agregados" : 
                _resultFiltrar = " fechaInsercion ASC";
            break;
            
            case "Seleccionar":
                _resultFiltrar = "NumExamenVeh ASC";
            break; 
            
            case "Ultimos agregados":
                _resultFiltrar = " fechaInsercion DESC";
            break;
        }
    
        return _resultFiltrar;
    }

// este metodo carga los jTable en caso de ser vacio devuelve null    
    public DefaultTableModel cargarJTabla(){
// se crea el modelo de jtable        
        String [] titulosTabla = {"Nº Examen","Fecha", "Examinador", "Cartera", "Dominio", "Lo retira"};
        String [] registros = new String[6];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();        
        _mySqlSentencia = "SELECT  examenvehiculo.numExamenVeh, examenvehiculo.nombExaminador, examenvehiculo.iuCartera, examenvehiculo.dominioVeh, examenvehiculo.fechaExamen, examenvehiculo.posibleRetirador, examenvehiculo.fechaInsercion, examenvehiculo.estadoEliminacion, cartera.nombCompleto FROM examenvehiculo INNER JOIN cartera ON examenvehiculo.iuCartera = cartera.iuCartera ORDER BY " + _resultFiltrar + "";
    try {
        
// se obtiene los datos de la db y se carga el modelo
        Statement stMySql = (Statement) _conectarSql.createStatement();  
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
      
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("numExamenVeh");
                registros[1] = rsMySql.getString("fechaExamen");               
                registros[2] = rsMySql.getString("nombExaminador") ;
                registros[3] = rsMySql.getString("nombCompleto");
                registros[4] = rsMySql.getString("dominioVeh");
                registros[5] = rsMySql.getString("posibleRetirador");

                 _modeloJTabla.addRow(registros);
                 
            }
        }
        
        return _modeloJTabla;       
    } catch (SQLException e) {
             
        return null;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();
    }
    }   
    
// este metodo busca lo ingresado y muetra el resultado    
    public DefaultTableModel buscarEnTabla(String busqueda){
// se crea el modelo de jtable     
        String [] titulosTabla = {"Nº Examen","Fecha", "Examinador", "Cartera", "Dominio", "Lo retira"};
        String [] registros = new String[6];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
// la doblesentencia corresponde a que el usuario piede buscar por marca 
        _mySqlSentencia = "SELECT numExamenVeh, nombExaminador, iuCartera, dominioVeh, fechaExamen, posibleRetirador, fechaInsercion, estadoEliminacion FROM examenvehiculo WHERE numExamenVeh LIKE '%"+ busqueda+"%' OR nombExaminador LIKE '%"+ busqueda+"%' OR dominioVeh LIKE '%"+ busqueda+"%' OR iuCartera LIKE '%"+ _administradorCartera.obtenerIuCartera2(busqueda)+"%' ";     
     
    try {
// se obtiene los datos de la db y se carga el modelo     
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);

       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("numExamenVeh");
                registros[1] = rsMySql.getString("fechaExamen");               
                registros[2] = rsMySql.getString("nombExaminador") ;
                registros[3] = _administradorCartera.obtenerNombCompleto(Integer.parseInt(rsMySql.getString("iuCartera")));
                registros[4] = rsMySql.getString("dominioVeh");
                registros[5] = rsMySql.getString("posibleRetirador");

                 _modeloJTabla.addRow(registros);
                 
            }
        }

        return _modeloJTabla;   
    } catch (SQLException e) {
         
        return null;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();        
    }
    }  

// se inserta datos en la db  
    public boolean insertarTablaExamenVehiculo(ExamenVehiculo obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "INSERT INTO examenvehiculo ( nombExaminador, iuCartera, dominioVeh, fechaExamen, posibleRetirador) VALUES( ?, ?, ?, ?, ? )";
    try {
// se prepara la insercion y se inyecta los datos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getNombExaminador());
        _mySqlPreparaSentencia.setInt(2, obj.getIuCartera());
        _mySqlPreparaSentencia.setString(3, obj.getDominioVeh());
        _mySqlPreparaSentencia.setString(4, obj.getFechaExamen());
        _mySqlPreparaSentencia.setString(5, obj.getPosibleRetirador());
        resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa        
        if(resultadoInsercion != 0) verdad= true; 
           
            return verdad;           
    } catch (SQLException e) {
                  
        return verdad;      
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();         
    }       
    }
    
// se modifican los datos  en la db  
    public boolean actualizarTablaExamenVehiculo( ExamenVehiculo obj){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
        _mySqlSentencia = "UPDATE examenvehiculo SET   nombExaminador = ?, iuCartera = ?, dominioVeh = ?, fechaExamen = ?, posibleRetirador = ?  WHERE numExamenVeh = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
         _mySqlPreparaSentencia.setString(1, obj.getNombExaminador());
        _mySqlPreparaSentencia.setInt(2, obj.getIuCartera());
        _mySqlPreparaSentencia.setString(3, obj.getDominioVeh());
        _mySqlPreparaSentencia.setString(4, obj.getFechaExamen());
        _mySqlPreparaSentencia.setString(5, obj.getPosibleRetirador());
        _mySqlPreparaSentencia.setInt(6, obj.getNumExamenVeh());
        resultadoActualizacion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa                
        if(resultadoActualizacion != 0) verdad= true;
           
            return verdad;          
    } catch (SQLException e) {

        return verdad;      
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();         
    }
    }
    
// eliminan los datos del sistema no de la db
    public boolean eliminarTablaExamenVehiculo( ExamenVehiculo obj){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE  examenvehiculo SET estadoEliminacion = ? WHERE numExamenVeh = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getNumExamenVeh());
        resultadosEliminacion = _mySqlPreparaSentencia.executeUpdate();
               
        if(resultadosEliminacion != 0) verdad= true;  
           
            return verdad;        
    } catch (SQLException e) {

           return verdad;
           
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();         
    }
    }    
    
        public String obtenerUltimoId(){
    
        String aux;
        
        try {
            _conectarSql = getConection(); 
            _mySqlSentencia = "SELECT MAX(numExamenVeh) FROM examenvehiculo";
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            rsMySql.next();
            
            aux = rsMySql.getInt(1) + "";
            
        } catch (SQLException e) {
         
        return null;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();        
    }

       
    return aux;
    
    }
    
}
