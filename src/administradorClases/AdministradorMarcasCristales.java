/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.MarcasCristales;
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

public class AdministradorMarcasCristales extends ConectorMySql {      
// atributos y variables  
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;
    private String _resultFiltrar= "fechaInsercion DESC";
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia2;
    
    public AdministradorMarcasCristales() {
        _modeloJList = new DefaultListModel<>();
    }

// se pasa el valor de orden y acomoda los datos por ese tipo        
    public String ordenarTabla(String valor){
 
        switch(valor){
    
            case "Primeros agregados" : 
                _resultFiltrar = " fechaInsercion ASC";
            break;
            
            case "Seleccionar":
                _resultFiltrar = "iuMarcaCris ASC";
            break; 
            
            case "Ultimos agregados":
                _resultFiltrar = " fechaInsercion DESC";
            break;
            
            case "Alfabeticos":
                _resultFiltrar = " descrMarcaCris ASC";
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
        _mySqlSentencia = "SELECT iuMarcaCris, descrMarcaCris, estadoEliminacion FROM marcaCristales ORDER BY " + _resultFiltrar + "";
    
    try {
// se obtiene los datos de la db y se carga el modelo   
        Statement stMySql = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1){
                    
                registros[0] = rsMySql.getString("iuMarcaCris");
                registros[1] = rsMySql.getString("descrMarcaCris");  
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
        _mySqlSentencia = "SELECT iuMarcaCris, descrMarcaCris, estadoEliminacion FROM marcaCristales WHERE iuMarcaCris LIKE '%"+ busqueda+"%' OR descrMarcaCris LIKE '%"+ busqueda+"%' ";

    try {
// se obtiene los datos de la db y se carga el modelo        
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1){
                      
                registros[0] = rsMySql.getString("iuMarcaCris");
                registros[1] = rsMySql.getString("descrMarcaCris");
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
    public boolean insertarTablaMarcaCristales(MarcasCristales obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "INSERT INTO marcaCristales( descrMarcaCris) VALUES( ?)";
    try {
// se prepara la insercion y se inyecta los datos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getDescrMarcaCris());
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
    public boolean actualizarTablaMarcaCristales(MarcasCristales obj){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
        _mySqlSentencia = "UPDATE marcaCristales SET   descrMarcaCris = ?  WHERE iuMarcaCris = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getDescrMarcaCris());
        _mySqlPreparaSentencia.setInt(2, obj.getIuMarcaCris());
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
    public boolean eliminarTablaMarcaCristales(MarcasCristales obj){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE  marcaCristales SET estadoEliminacion = ? WHERE iuMarcaCris = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getIuMarcaCris());
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
    public String obtenerIuMarcaCris(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuMarcaCris, descrMarcaCris FROM marcaCristales WHERE  descrMarcaCris = '"+ busqueda+"' OR iuMarcaCris = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("iuMarcaCris");
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
    public String obtenerDescrMarcaCris(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuMarcaCris, descrMarcaCris FROM marcaCristales WHERE iuMarcaCris = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("descrMarcaCris");
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
        _mySqlSentencia = "SELECT iuMarcaCris, descrMarcaCris, estadoEliminacion FROM marcacristales WHERE iuMarcaCris LIKE '%"+ busqueda+"%' OR descrMarcaCris LIKE '%"+ busqueda+"%' ";
        _mySqlSentencia2 = "SELECT iuMarcaCris, descrMarcaCris, estadoEliminacion FROM marcacristales ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                    registros.add(rsMySql.getString("descrMarcaCris")); 
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                    
                    registros.add(rsMySql.getString("descrMarcaCris"));
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
