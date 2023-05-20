/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.Vehiculos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static controladorBD.ConectorMySql.desconectarMySql;
import static controladorBD.ConectorMySql.getConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class AdministradorVehiculos {
// atributos y variables       
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia;
    private String _mySqlSentencia2;
    private String _resultFiltrar= " fechaInsercion DESC";
    
    public AdministradorVehiculos() {
        _modeloJList = new DefaultListModel<>();
    }
    
// se pasa un valor de orden y acomoda los datos por ese tipo    
    public String ordenarTabla(String valor){
                  
    switch(valor){
    
        case "Primeros agregados" : 
            _resultFiltrar = " fechaInsercion ASC";
        break;
        
        case "Seleccionar":
            _resultFiltrar = "dominioVeh ASC";
        break; 
        
        case "Ultimos agregados":
            _resultFiltrar = " fechaInsercion DESC";
        break;
        
        case "Alfabeticos":
            _resultFiltrar = " dominioVeh ASC";
        break;                
    }
    
    return _resultFiltrar;
    }
 
// este metodo carga los jTable en caso de ser vacio devuelve null 
    public DefaultTableModel cargarJTabla(){
// se crea el modelo de jtable   
        String [] titulosTabla = {"Dominio", "Modelo", "año"};
        String [] registros = new String[3];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT vehiculos.dominioVeh, vehiculos.anioVeh, vehiculos.fechaInsercion, vehiculos.estadoEliminacion, modelovehiculo.descrModeloVeh FROM vehiculos INNER JOIN modelovehiculo ON  vehiculos.codModeloVeh = modelovehiculo.codModeloVeh ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo   
        Statement stMySql = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("dominioVeh");
                registros[1] = rsMySql.getString("descrModeloVeh"); 
                registros[2] = rsMySql.getString("anioVeh") ;  
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
        String [] titulosTabla = {"Dominio", "Modelo", "año"};
        String [] registros = new String[3];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT dominioVeh, codModeloVeh, anioVeh, estadoEliminacion FROM vehiculos WHERE dominioVeh LIKE '%"+ busqueda+"%' OR anioVeh LIKE '%"+ busqueda+"%' OR codModeloVeh LIKE '%"+ busqueda+"%'";     
        String _mySqlSentenciaFK1 = "SELECT codModeloVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo"; 
     
    try {
// se obtiene los datos de la db y se carga el modelo 
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();// mirara xq cast  
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentenciaFK1);
        
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("dominioVeh");
                
                while(rsMySqlFK1.next()){
                    if(rsMySqlFK1.getInt("estadoEliminacion") == 1 ){ 
                        if(rsMySqlFK1.getString("codModeloVeh").equals(rsMySql.getString("codModeloVeh")) ){

                            registros[1] = rsMySqlFK1.getString("descrModeloVeh") ;
                        } 
                    }
                    registros[2] = rsMySql.getString("anioVeh");
                }
                
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
    public boolean insertarTablaVehiculos(Vehiculos obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();  
        _mySqlSentencia = "SELECT estadoEliminacion FROM Vehiculos WHERE dominioVeh = '"+obj.getDominioVeh()+"'";
   
    try {
// se prepara la insercion y se inyecta los datos
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
           
            if(rsMySql.next() == true){

                if(rsMySql.getInt("estadoEliminacion")==0){
                    _mySqlSentencia = "UPDATE Vehiculos SET   dominioVeh = ?, codModeloVeh = ?, anioVeh = ?, estadoEliminacion = ?  WHERE dominioVeh = ?";    
                    PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
                    _mySqlPreparaSentencia.setString(1, obj.getDominioVeh());
                    _mySqlPreparaSentencia.setString(2, obj.getCodModeloVeh());
                    _mySqlPreparaSentencia.setInt(3, obj.getAnioVeh()); 
                    _mySqlPreparaSentencia.setInt(4, 1);
                    _mySqlPreparaSentencia.setString(5, obj.getDominioVeh());
                    resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa                
                    if(resultadoInsercion != 0)verdad= true;
                } else{
                
                    verdad = false;
                }
            } else if(rsMySql.next()== false) {

                _mySqlSentencia = "INSERT INTO Vehiculos ( dominioVeh, codModeloVeh, anioVeh) VALUES( ?, ?, ?)";
                PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia); 
                _mySqlPreparaSentencia.setString(1, obj.getDominioVeh());
                _mySqlPreparaSentencia.setString(2, obj.getCodModeloVeh());
                _mySqlPreparaSentencia.setInt(3, obj.getAnioVeh());
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
    
// se actualiza datos en la db   
    public boolean actualizarTablaVehiculos(Vehiculos obj){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE Vehiculos SET  dominioVeh = ?, codModeloVeh = ?, anioVeh = ? WHERE dominioVeh = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getDominioVeh());
        _mySqlPreparaSentencia.setString(2, obj.getCodModeloVeh());
        _mySqlPreparaSentencia.setInt(3, obj.getAnioVeh());
        _mySqlPreparaSentencia.setString(4, obj.getDominioVeh());
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
    public boolean eliminarTablaVehiculos(Vehiculos obj){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE Vehiculos SET  estadoEliminacion = ?  WHERE dominioVeh = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setString(2, obj.getDominioVeh() );
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

// este metodo busca lo ingresado y muetra el resultado    
    public String obtenerDominioVeh(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT dominioVeh FROM vehiculos WHERE  dominioVeh = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("dominioVeh");
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
        _mySqlSentencia = "SELECT dominioVeh, estadoEliminacion FROM Vehiculos WHERE dominioVeh LIKE '%"+ busqueda+"%' ";
        _mySqlSentencia2 = "SELECT dominioVeh, estadoEliminacion FROM vehiculos ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("dominioVeh")); 
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("dominioVeh"));
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
    public String obtenerModeloVeh(String busqueda){
        
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT dominioVeh, codModeloVeh, anioVeh, estadoEliminacion FROM vehiculos WHERE dominioVeh LIKE '%"+ busqueda+"%' OR anioVeh LIKE '%"+ busqueda+"%' OR codModeloVeh LIKE '%"+ busqueda+"%'";     
        String _mySqlSentenciaFK1 = "SELECT codModeloVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo"; 
     
    try {
// se obtiene los datos de la db y se carga el modelo 
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();// mirara xq cast  
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentenciaFK1);
        
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
 
                while(rsMySqlFK1.next()){
                    if(rsMySqlFK1.getInt("estadoEliminacion") == 1 ){ 
                        if(rsMySqlFK1.getString("codModeloVeh").equals(rsMySql.getString("codModeloVeh")) ){

                            aux = rsMySqlFK1.getString("descrModeloVeh") ;
                        } 
                    }
                }
            }
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
