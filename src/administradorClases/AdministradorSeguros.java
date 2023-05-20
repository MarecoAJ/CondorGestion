/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.Seguros;
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


public class AdministradorSeguros {
// atributos y variables 
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;
    private String _resultFiltrar= " fechaInsercion DESC";
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia2;
    
    public AdministradorSeguros() {
         _modeloJList = new DefaultListModel<>();  
    }
    
// se pasa el valor de orden y acomoda los datos por ese tipo        
    public String ordenarTabla(String valor){
 
        switch(valor){
    
            case "Primeros agregados" : 
                _resultFiltrar = " fechaInsercion ASC";
            break;
            
            case "Seleccionar":
                _resultFiltrar = "iuSeguros ASC";
            break; 
            
            case "Ultimos agregados":
                _resultFiltrar = " fechaInsercion DESC";
            break;
            
            case "Alfabeticos":
                _resultFiltrar = " descrSeguros ASC";
            break;
        }
    
        return _resultFiltrar;
    }

// este metodo carga los jTable en caso de ser vacio devuelve null 
    public DefaultTableModel cargarJTabla(){
// se crea el modelo de jtable  
        String [] titulosTabla = {"Nº registro", "Descripcion"};
        String [] registros = new String[2];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuSeguros, descrSeguros, fechaInsercion, estadoEliminacion FROM seguros ORDER BY " + _resultFiltrar + "";
    
    try {
// se obtiene los datos de la db y se carga el modelo   
        Statement stMySql = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1){
                    
                registros[0] = rsMySql.getString("iuSeguros");
                registros[1] = rsMySql.getString("descrSeguros");  
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
        String [] titulosTabla = {"Nº registro", "Descripcion"};
        String [] registros = new String[2];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();   
        _mySqlSentencia = "SELECT iuSeguros, descrSeguros, fechaInsercion, estadoEliminacion FROM seguros WHERE iuSeguros LIKE '%"+ busqueda+"%' OR descrSeguros LIKE '%"+ busqueda+"%' ";
    try {
// se obtiene los datos de la db y se carga el modelo        
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1){
                      
                registros[0] = rsMySql.getString("iuSeguros");
                registros[1] = rsMySql.getString("descrSeguros");
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
    public boolean insertarTablaSeguros( Seguros obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "INSERT INTO seguros( descrSeguros ) VALUES(?)";    
    try {
// se prepara la insercion y se inyecta los datos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getDescrSeguros());
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
    public boolean actualizarTablaSeguros(Seguros obj){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
        _mySqlSentencia = "UPDATE seguros SET  descrSeguros = ? WHERE iuSeguros = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getDescrSeguros());
        _mySqlPreparaSentencia.setInt(2, obj.getIuSeguros());
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
    public boolean eliminarTablaSeguros(Seguros obj){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE seguros SET estadoEliminacion = ? WHERE iuSeguros = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getIuSeguros());
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
    public String obtenerIuSeguros(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuSeguros, descrSeguros FROM seguros WHERE  descrSeguros = '"+ busqueda+"' OR iuSeguros = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("iuSeguros");
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
        _mySqlSentencia = "SELECT iuSeguros, descrSeguros, estadoEliminacion FROM seguros WHERE iuSeguros LIKE '%"+ busqueda+"%' OR descrSeguros LIKE '%"+ busqueda+"%' ";
        _mySqlSentencia2 = "SELECT iuSeguros, descrSeguros, estadoEliminacion FROM seguros ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("descrSeguros")); 
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("descrSeguros"));
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
}
