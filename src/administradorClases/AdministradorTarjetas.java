
package administradorClases;


import clasesDatos.Tarjetas;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static controladorBD.ConectorMySql.desconectarMySql;
import static controladorBD.ConectorMySql.getConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class AdministradorTarjetas {
       
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;
    private String _resultFiltrar= "iuTarjetas DESC";
    private final AdministradorEmisoresDeTarjetas _administradorEmisoresDeTarjetas;
    
    public AdministradorTarjetas() {
        
        _administradorEmisoresDeTarjetas = new AdministradorEmisoresDeTarjetas();
    }
    
    public String ordenarTabla(String valor){
 
    switch(valor){
    
        case "Primeros agregados" : 
           _resultFiltrar = " fechaInsercion ASC";
           break;
        case "Seleccionar":
           _resultFiltrar = " iuTarjetas DESC";
           break; 
        case "Ultimos argegados":
           _resultFiltrar = " fechaInsercion DESC";
           break;
           
   }
    
    return _resultFiltrar;
    
    }

// este metodo carga los jTable en caso de ser vacio devuelve null    
    public DefaultTableModel cargarJTabla(){
        String [] titulosTabla = {"N° de reg.", "Tarjeta", "Caja", "Detalle", "Nº tajeta", "Nº comprobante", "Lote", "Total"};
        String [] registros = new String[8];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();        
        _mySqlSentencia = "SELECT tarjetas.iuTarjetas, tarjetas.iuEmisoresDeTarjetas, tarjetas.iuCaja, tarjetas.iuDetalleCaja, tarjetas.numTarjeta, tarjetas.numComprobante, tarjetas.lote, tarjetas.totalTarjeta, tarjetas.fechaInsercion,tarjetas.estadoEliminacion, emisoresdetarjetas.descrEmisor FROM tarjetas INNER JOIN emisoresdetarjetas ON tarjetas.iuEmisoresDeTarjetas = emisoresdetarjetas.iuEmisoresDeTarjetas ORDER BY " + _resultFiltrar + "";

    try {
// se obtiene los datos de la db y se carga el modelo
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
      
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuTarjetas");
                registros[1] = rsMySql.getString("descrEmisor"); 
                registros[2] = rsMySql.getString("iuCaja") ;
                registros[3] = rsMySql.getString("iuDetalleCaja") ;
                registros[4] = rsMySql.getString("numTarjeta");
                registros[5] = rsMySql.getString("numComprobante");
                registros[6] = rsMySql.getString("lote");
                registros[7] = rsMySql.getString("totalTarjeta");
   
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
        String [] titulosTabla = {"N° de reg.", "Tarjeta", "Caja", "Detalle", "Nº tajeta", "Nº comprobante", "Lote", "Total"};
        String [] registros = new String[8];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
// la doblesentencia corresponde a que el usuario piede buscar por marca 
     _mySqlSentencia = "SELECT iuTarjetas, iuEmisoresDeTarjetas, iuCaja, iuDetalleCaja, numTarjeta, numComprobante, lote, totalTarjeta, estadoEliminacion FROM tarjetas WHERE iuTarjetas LIKE '%"+ busqueda+"%' OR numTarjeta LIKE '%"+ busqueda+"%' OR numComprobante LIKE '%"+ busqueda+"%' OR iuCaja LIKE '%"+ busqueda +"%' OR iuDetalleCaja LIKE '%"+ busqueda +"%'";     

        
    try {
// se obtiene los datos de la db y se carga el modelo     
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuTarjetas");
                registros[1] = rsMySql.getString(_administradorEmisoresDeTarjetas.obtenerDescrEmisor("iuEmisoresDeTarjetas")); 
                registros[2] = rsMySql.getString("iuCaja") ;
                registros[3] = rsMySql.getString("iuDetalleCaja") ;
                registros[4] = rsMySql.getString("numTarjeta");
                registros[5] = rsMySql.getString("numComprobante");
                registros[6] = rsMySql.getString("lote");
                registros[7] = rsMySql.getString("totalTarjeta");
                
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
    public boolean insertarTablaTarjetas( Tarjetas obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "INSERT INTO tarjetas ( iuEmisoresDeTarjetas, iuCaja, iuDetalleCaja, numTarjeta, numComprobante, lote, totalTarjeta ) VALUES( ?, ?, ?, ?, ?, ?, ?)";
    try {
// se prepara la insercion y se inyecta los datos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, obj.getIuEmisoresDeTarjetas());
        _mySqlPreparaSentencia.setInt(2, obj.getIuCaja());
        _mySqlPreparaSentencia.setInt(3, obj.getIuDetalleCaja());
        _mySqlPreparaSentencia.setInt(4,obj.getNumTarjeta());
        _mySqlPreparaSentencia.setInt(5, obj.getNumComprobante());
        _mySqlPreparaSentencia.setInt(6,obj.getLote());
        _mySqlPreparaSentencia.setDouble(7, obj.getTotalTarjeta());
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
    
// se actualiza datos en la db   
    public boolean actualizarTablaTarjetas( Tarjetas obj ){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE tarjetas SET  iuEmisoresDeTarjetas = ?, iuCaja = ?, iuDetalleCaja = ?, numTarjeta = ?, numComprobante = ?, lote = ?, totalTarjeta = ? WHERE iuTarjetas = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, obj.getIuEmisoresDeTarjetas());
        _mySqlPreparaSentencia.setInt(2, obj.getIuCaja());
        _mySqlPreparaSentencia.setInt(3, obj.getIuDetalleCaja());
        _mySqlPreparaSentencia.setInt(4,obj.getNumTarjeta());
        _mySqlPreparaSentencia.setInt(5, obj.getNumComprobante());
        _mySqlPreparaSentencia.setInt(6,obj.getLote());
        _mySqlPreparaSentencia.setDouble(7, obj.getTotalTarjeta());
        _mySqlPreparaSentencia.setInt(8, obj.getIuTajetas());
        resultadoActualizacion= _mySqlPreparaSentencia.executeUpdate();
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
    public boolean eliminarTablaTarjetas( Tarjetas obj ){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE tarjetas SET  estadoEliminacion = ?  WHERE iuTarjetas = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getIuTajetas() );
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
