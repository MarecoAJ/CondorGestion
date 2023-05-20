
package administradorClases;

import clasesDatos.MovimientoSeguros;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static controladorBD.ConectorMySql.desconectarMySql;
import static controladorBD.ConectorMySql.getConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class AdministradorMovimientoSeguros {
// atributos y variables  
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;
    private String _resultFiltrar= " fechaInsercion DESC";
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia2;
    
    public AdministradorMovimientoSeguros() {
        _modeloJList = new DefaultListModel<>();
    }

// se pasa el valor de orden y acomoda los datos por ese tipo        
    public String ordenarTabla(String valor){
 
        switch(valor){
    
            case "Primeros agregados" : 
                _resultFiltrar = " fechaInsercion ASC";
            break;
            
            case "Seleccionar":
                _resultFiltrar = "iuMovimientoSeg ASC";
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
        String [] titulosTabla = {"Nº registro", "Poliza o siniestro", "Fecha"};
        String [] registros = new String[3];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuMovimientoSeg, iuPolizaSiniestro, fechaAproxCobro, estadoEliminacion FROM movimientoseguros ORDER BY " + _resultFiltrar + "";
        
        
    try {
// se obtiene los datos de la db y se carga el modelo   
        Statement stMySql = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1){
                    
                registros[0] = rsMySql.getString("iuMovimientoSeg");
                _mySqlSentencia2 = "SELECT iuPolizaSiniestro, numPoliza, numSiniestro FROM polizasiniestro WHERE iuPolizaSiniestro = " + rsMySql.getString("iuPolizaSiniestro") + "";
                Statement stMySql1 = (Statement) _conectarSql.createStatement();
                ResultSet rsMySql1 = stMySql1.executeQuery(_mySqlSentencia2);
                while(rsMySql1.next()){
                
                    registros[1] = rsMySql1.getString("numPoliza")+ "-" + rsMySql1.getString("numSiniestro") ;
                
                }
                
                registros[2] = rsMySql.getString("fechaAproxCobro"); 
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
        String [] titulosTabla = {"Nº registro", "Poliza o siniestro", "Fecha"};
        String [] registros = new String[3];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();   
        _mySqlSentencia = "SELECT iuMovimientoSeg, iuPolizaSiniestro, fechaAproxCobro, estadoEliminacion FROM movimientoseguros WHERE iuMovimientoSeg LIKE '%"+ busqueda+"%' OR iuPolizaSiniestro LIKE '%"+ busqueda+"%'";

    try {
// se obtiene los datos de la db y se carga el modelo        
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1){
                      
                registros[0] = rsMySql.getString("iuMovimientoSeg");
                
                _mySqlSentencia2 = "SELECT iuPolizaSiniestro, numPoliza, numSiniestro FROM polizasiniestro WHERE iuPolizaSiniestro = " + rsMySql.getString("iuPolizaSiniestro") + "";
                Statement stMySql1 = (Statement) _conectarSql.createStatement();
                ResultSet rsMySql1 = stMySql1.executeQuery(_mySqlSentencia2);
                while(rsMySql1.next()){
                
                    registros[1] = rsMySql1.getString("numPoliza")+ "-" + rsMySql1.getString("numSiniestro") ;
                
                }
                
                registros[2] = rsMySql.getString("fechaAproxCobro"); 
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
    public boolean insertarTablaMovimientoSeguros(MovimientoSeguros obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "INSERT INTO movimientoseguros ( iuPolizaSiniestro, fechaAproxCobro) VALUES( ?, ?)";
    try {
// se prepara la insercion y se inyecta los datos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getIuPolizaSiniestro());
        _mySqlPreparaSentencia.setString(2, obj.getFechaAproxCobro());
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
    public boolean actualizarTablaMovimientoSeguros(MovimientoSeguros obj){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
        _mySqlSentencia = "UPDATE movimientoseguros SET   iuPolizaSiniestro = ?, fechaAproxCobro = ?  WHERE iuMovimientoSeg = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getIuPolizaSiniestro());
        _mySqlPreparaSentencia.setString(2, obj.getFechaAproxCobro());       
        _mySqlPreparaSentencia.setInt(3, obj.getIuMovimientoSeg());
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
    public boolean eliminarTablaMovimientoSeguros(MovimientoSeguros obj){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE  movimientoseguros SET estadoEliminacion = ? WHERE iuMovimientoSeg = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getIuMovimientoSeg());
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

}
