/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.ModeloVehiculo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import controladorBD.ConectorMySql;
import static controladorBD.ConectorMySql.desconectarMySql;
import static controladorBD.ConectorMySql.getConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class AdministradorModeloVehiculo extends ConectorMySql{
       
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;  
    private String _resultFiltrar= "fechaInsercion DESC";
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia2;
    
    public AdministradorModeloVehiculo() {
        _modeloJList = new DefaultListModel<>();
    }
    
// se pasa el valor de orden y acomoda los datos por ese tipo        
    public String ordenarTabla(String valor){
 
        switch(valor){
    
            case "Primeros agregados" : 
                _resultFiltrar = " fechaInsercion ASC";
            break;
            
            case "Seleccionar":
                _resultFiltrar = "codModeloVeh ASC";
            break; 
            
            case "Ultimos agregados":
                _resultFiltrar = " fechaInsercion DESC";
            break;
            
            case "Alfabeticos":
                _resultFiltrar = " descrModeloVeh ASC";
            break;
        }
    
        return _resultFiltrar;
    }

// este metodo carga los jTable en caso de ser vacio devuelve null    
    public DefaultTableModel cargarJTabla(){
        String [] titulosTabla = {"Cod. modelo", "Descripcion", "Marca"};
        String [] registros = new String[3];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();        
        _mySqlSentencia = "SELECT modelovehiculo.codModeloVeh, modelovehiculo.codMarcaVeh, modelovehiculo.descrModeloVeh, modelovehiculo.fechaInsercion, modelovehiculo.estadoEliminacion, marcavehiculo.descrMarcaVeh FROM modelovehiculo INNER JOIN marcavehiculo ON modelovehiculo.codMarcaVeh = marcavehiculo.codMarcaVeh ORDER BY " + _resultFiltrar + "";

    try {
// se obtiene los datos de la db y se carga el modelo
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
      
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("codModeloVeh");
                registros[1] = rsMySql.getString("descrModeloVeh"); 
                registros[2] = rsMySql.getString("descrMarcaVeh") ;  
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
        String [] titulosTabla = {"Cod. modelo", "Descripcion", "Marca"};
        String [] registros = new String[3];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
// la doblesentencia corresponde a que el usuario piede buscar por marca 
        _mySqlSentencia = "SELECT codModeloVeh, codMarcaVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo WHERE codModeloVeh LIKE '%"+ busqueda+"%' OR descrModeloVeh LIKE '%"+ busqueda+"%' OR codMarcaVeh LIKE '%"+ busqueda+"%'";     
        String _mySqlSentenciaFK1 = "SELECT codMarcaVeh, descrMarcaVeh, estadoEliminacion FROM marcavehiculo"; 
     
    try {
// se obtiene los datos de la db y se carga el modelo     
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();  
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentenciaFK1);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("codModeloVeh");
                registros[1] = rsMySql.getString("descrModeloVeh"); 
              
                while(rsMySqlFK1.next()){
                    if(rsMySqlFK1.getInt("estadoEliminacion") == 1 ){ 
                    if(rsMySqlFK1.getString("codMarcaVeh").equals(rsMySql.getString("codMarcaVeh")) ){
                   
                        registros[2] = rsMySqlFK1.getString("descrMarcaVeh") ;
                    } 
                    }
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
    public boolean insertarTablaModeloVehiculo(ModeloVehiculo obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();  
        _mySqlSentencia = "SELECT estadoEliminacion FROM modeloVehiculo WHERE codModeloVeh = "+obj.getCodModeloVeh()+"";
    try {
// se prepara la insercion y se inyecta los datos
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            if(rsMySql.next() == true){
                if(rsMySql.getInt("estadoEliminacion")==0){
                    _mySqlSentencia = "UPDATE modeloVehiculo SET   codMarcaVeh = ?, descrModeloVeh = ?, estadoEliminacion = ?  WHERE codModeloVeh = ?";    
                    PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
                    _mySqlPreparaSentencia.setString(1, obj.getCodMarcaVeh());
                    _mySqlPreparaSentencia.setString(2, obj.getDescrModeloVeh());
                    _mySqlPreparaSentencia.setInt(3, 1 ); 
                    _mySqlPreparaSentencia.setString(4, obj.getCodModeloVeh());
                    resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa                
                    if(resultadoInsercion != 0)verdad= true;
                } else{
                
                    verdad = false;
                }
            } else if(rsMySql.next()== false) {
                _mySqlSentencia = "INSERT INTO modeloVehiculo ( codModeloVeh, codMarcaVeh, descrModeloVeh) VALUES( ?, ?, ?)";
                PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia); 
                _mySqlPreparaSentencia.setString(1, obj.getCodModeloVeh());
                _mySqlPreparaSentencia.setString(2, obj.getCodMarcaVeh());
                _mySqlPreparaSentencia.setString(3, obj.getDescrModeloVeh());
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
    public boolean actualizarTablaModeloVehiculo(ModeloVehiculo obj, String antModCodModeloVeh ){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE modeloVehiculo SET  codModeloVeh=?, codMarcaVeh=?, descrModeloVeh = ?  WHERE codModeloVeh = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getCodModeloVeh());
        _mySqlPreparaSentencia.setString(2, obj.getCodMarcaVeh());
        _mySqlPreparaSentencia.setString(3, obj.getDescrModeloVeh());
        _mySqlPreparaSentencia.setString(4, antModCodModeloVeh);
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
    public boolean eliminarTablaModeloVehiculo(ModeloVehiculo obj, String antModCodModeloVeh ){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE modeloVehiculo SET  estadoEliminacion = ?  WHERE codModeloVeh = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setString(2, antModCodModeloVeh );
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
    public String obtenerCodModeloVeh(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codModeloVeh, descrModeloVeh FROM modeloVehiculo WHERE  descrModeloVeh = '"+ busqueda+"' OR codModeloVeh = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("codModeloVeh");
        }
            
            return aux;
    } catch (SQLException e) {
            
        return aux;
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
        _mySqlSentencia = "SELECT codModeloVeh, descrModeloVeh, estadoEliminacion FROM modeloVehiculo WHERE codModeloVeh LIKE '%"+ busqueda+"%' OR descrModeloVeh LIKE '%"+ busqueda+"%' ";
        _mySqlSentencia2 = "SELECT codModeloVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("descrModeloVeh")); 
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("descrModeloVeh"));
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
    public String obtenerDescrModeloVeh(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codModeloVeh, descrModeloVeh FROM modeloVehiculo WHERE codModeloVeh = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("descrModeloVeh");
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
    public String obtenercodMarcaVeh(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codModeloVeh, codMarcaVeh FROM modeloVehiculo WHERE codModeloVeh = '"+busqueda+"'  ";
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
}
