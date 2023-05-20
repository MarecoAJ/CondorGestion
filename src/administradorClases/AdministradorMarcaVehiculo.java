/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.MarcaVehiculo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import controladorBD.ConectorMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class AdministradorMarcaVehiculo extends ConectorMySql{
// atributos y variables      
    private  Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia;
    private String _mySqlSentencia2;
    private String _resultFiltrar= "fechaInsercion DESC";
    
    public AdministradorMarcaVehiculo() {
        _modeloJList = new DefaultListModel<>();
    }
 
// se pasa un valor de orden y acomoda los datos por ese tipo    
    public String ordenarTabla(String valor){
 
    switch(valor){
    
        case "Primeros agregados" : 
            _resultFiltrar = " fechaInsercion ASC";
        break;
        
        case "Seleccionar":
            _resultFiltrar = "codMarcaVeh ASC";
        break; 
        
        case "Ultimos agregados":
            _resultFiltrar = " fechaInsercion DESC";
        break;
        
        case "Alfabeticos":
            _resultFiltrar = " descrMarcaVeh ASC";
        break;                
    }
    
    return _resultFiltrar;
    }
 
// este metodo carga los jTable en caso de ser vacio devuelve null 
    public DefaultTableModel cargarJTabla(){
// se crea el modelo de jtable     
        String [] titulosTabla = {"Cod. marca", "Descripcion"};
        String [] registros = new String[2];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codMarcaVeh, descrMarcaVeh, estadoEliminacion FROM marcavehiculo ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo    
        Statement stMySql = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("codMarcaVeh");
                registros[1] = rsMySql.getString("descrMarcaVeh");          
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
        String [] titulosTabla = {"Cod. marca", "Descripcion"};
        String [] registros = new String[2];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codMarcaVeh, descrMarcaVeh, estadoEliminacion FROM marcaVehiculo WHERE codMarcaVeh LIKE '%"+ busqueda+"%' OR descrMarcaVeh LIKE '%"+ busqueda+"%' ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                registros[0] = rsMySql.getString("codMarcaVeh");
                registros[1] = rsMySql.getString("descrMarcaVeh");
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
    public boolean insertarTablaMarcaVehiculo(MarcaVehiculo obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();  
        _mySqlSentencia = "SELECT estadoEliminacion FROM marcaVehiculo WHERE codMarcaVeh = "+obj.getCodMarcaVeh()+"";
    try {
// se prepara la insercion y se inyecta los datos
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            if(rsMySql.next() == true){
                if(rsMySql.getInt("estadoEliminacion")==0){
                    _mySqlSentencia = "UPDATE marcaVehiculo SET  descrMarcaVeh = ?, estadoEliminacion = ?  WHERE codMarcaVeh = ?";    
                    PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
                    _mySqlPreparaSentencia.setString(1, obj.getDescrMarcaVeh());
                    _mySqlPreparaSentencia.setInt(2, 1);
                    _mySqlPreparaSentencia.setString(3, obj.getCodMarcaVeh());  
                    resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa                
                    if(resultadoInsercion != 0)verdad= true;
                } else{
                
                    verdad = false;
                }
            } else if(rsMySql.next()== false) {
                _mySqlSentencia = "INSERT INTO marcaVehiculo ( codMarcaVeh, descrMarcaVeh) VALUES( ?, ?)";
                PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia); 
                _mySqlPreparaSentencia.setString(1, obj.getCodMarcaVeh());
                _mySqlPreparaSentencia.setString(2, obj.getDescrMarcaVeh());
                resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa 
                if(resultadoInsercion != 0)verdad= true;
            }    

            return verdad;
               
    } catch (SQLException e) {
               
        return verdad;    
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();     
    }     
    }
    
// se modifican los datos  en la db  
    public boolean actualizarTablaMarcaVehiculo(MarcaVehiculo obj, String antModCodMarcaVeh){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();            
        _mySqlSentencia = "UPDATE marcaVehiculo SET  codMarcaVeh=?, descrMarcaVeh = ?  WHERE codMarcaVeh = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos          
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getCodMarcaVeh());
        _mySqlPreparaSentencia.setString(2, obj.getDescrMarcaVeh());
        _mySqlPreparaSentencia.setString(3, antModCodMarcaVeh);  
        resultadoActualizacion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa                
        if(resultadoActualizacion != 0)verdad= true;
           
            return verdad;
               
    }catch (SQLException e) {
               
        return verdad;         
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();    
    }       
    }

// eliminan los datos del sistema no de la db
    public boolean eliminarTablaMarcaVehiculo( MarcaVehiculo obj,String antModCodMarcaVeh ){
        boolean verdad = false;
        int resultadoEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
        _mySqlSentencia = "UPDATE marcaVehiculo SET  codMarcaVeh = ?,estadoEliminacion = ?  WHERE codMarcaVeh = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos        
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getCodMarcaVeh());
        _mySqlPreparaSentencia.setInt(2, 0);
        _mySqlPreparaSentencia.setString(3, antModCodMarcaVeh ); 
        resultadoEliminacion = _mySqlPreparaSentencia.executeUpdate();
               
        if(resultadoEliminacion != 0)verdad= true;
           
            return verdad;
               
    }catch (SQLException e) {
               
        return verdad;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();       
    }      
    }       

// este metodo busca lo ingresado y muetra el resultado    
    public String obtenerCodMarcaVeh(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codMarcaVeh, descrMarcaVeh FROM marcaVehiculo WHERE  descrMarcaVeh = '"+ busqueda+"' OR codMarcaVeh = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("codMarcaVeh");
        }
            
            return aux;
    } catch (SQLException e) {
            
        return null;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();       
    }
    }
    
// este metodo busca lo ingresado y muetra el resultado    
    public DefaultListModel cargarLista(String busqueda){      
// se genera la coneccion y el query de consulta        
        ArrayList<String> registros = new ArrayList<>();
        _modeloJList.clear();
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codMarcaVeh, descrMarcaVeh, estadoEliminacion FROM marcaVehiculo WHERE codMarcaVeh LIKE '%"+ busqueda+"%' OR descrMarcaVeh LIKE '%"+ busqueda+"%' ";
        _mySqlSentencia2 = "SELECT codMarcaVeh, descrMarcaVeh, estadoEliminacion FROM marcavehiculo ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("descrMarcaVeh")); 
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("descrMarcaVeh"));
                }    
            }
        } 
            for (int i = 0; i < registros.size(); i++) {
                _modeloJList.add(i,registros.get(i));
            }
            return _modeloJList;
    } catch (SQLException e) {
            
        return null;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();       
    }
    }
    
// este metodo busca lo ingresado y muetra el resultado    
    public String obtenerDescrMarcaVeh(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codMarcaVeh, descrMarcaVeh FROM marcaVehiculo WHERE codMarcaVeh = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("descrMarcaVeh");
        }
            
            return aux;
    } catch (SQLException e) {
            
        return null;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();       
    }
    }
}
