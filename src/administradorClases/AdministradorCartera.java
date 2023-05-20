/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.Cartera;
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


public class AdministradorCartera extends ConectorMySql{
       
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;  
    private String _resultFiltrar= "fechaInsercion DESC";
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia2;
    
    public AdministradorCartera() {
        _modeloJList = new DefaultListModel<>();
    }
    
// se pasa el valor de orden y acomoda los datos por ese tipo        
    public String ordenarTabla(String valor){
 
        switch(valor){
    
            case "Primeros agregados" : 
                _resultFiltrar = " fechaInsercion ASC";
            break;
            
            case "Seleccionar":
                _resultFiltrar = "iuCartera ASC";
            break; 
            
            case "Ultimos agregados":
                _resultFiltrar = " fechaInsercion DESC";
            break;
            
            case "Alfabeticos":
                _resultFiltrar = " nombCompleto ASC";
            break;
        }
    
        return _resultFiltrar;
    }

// este metodo carga los jTable en caso de ser vacio devuelve null    
    public DefaultTableModel cargarJTabla(){
        String [] titulosTabla = {"N° de reg.", "Tipo de cartera", "Dni o CUIT", "Nombre", "Direccion"};
        String [] registros = new String[5];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();        
        _mySqlSentencia = "SELECT cartera.iuCartera, cartera.iuTipoCartera, cartera.dniOCuit, cartera.nombCompleto, cartera.direccionCartera, cartera.fechaInsercion, cartera.estadoEliminacion, tipoCartera.descrTipoCartera FROM cartera INNER JOIN tipoCartera ON cartera.iuTipoCartera = tipoCartera.iuTipoCartera ORDER BY " + _resultFiltrar + "";

    try {
// se obtiene los datos de la db y se carga el modelo
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
      
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuCartera");
                registros[1] = rsMySql.getString("descrTipoCartera"); 
                registros[2] = rsMySql.getString("dniOCuit") ;
                registros[3] = rsMySql.getString("nombCompleto") ;
                registros[4] = rsMySql.getString("direccionCartera") ;
   
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
        String [] titulosTabla = {"N° de reg.", "Tipo de cartera", "Dni o CUIT", "Nombre", "Direccion"};
        String [] registros = new String[5];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
// la doblesentencia corresponde a que el usuario piede buscar por marca 
        _mySqlSentencia = "SELECT iuCartera, iuTipoCartera, dniOCuit, nombCompleto, direccionCartera, estadoEliminacion FROM cartera WHERE iuCartera LIKE '%"+ busqueda+"%' OR iuTipoCartera LIKE '%"+ busqueda+"%' OR dniOCuit LIKE '%"+ busqueda+"%' OR nombCompleto LIKE '%"+ busqueda+"%' OR direccionCartera LIKE '%"+ busqueda+"%'";     
        String _mySqlSentenciaFK1 = "SELECT iuTipoCartera, descrTipoCartera, estadoEliminacion FROM tipoCartera"; 
     
    try {
// se obtiene los datos de la db y se carga el modelo     
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();  
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentenciaFK1);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuCartera");
              
                while(rsMySqlFK1.next()){
                    if(rsMySqlFK1.getInt("estadoEliminacion") == 1 ){ 
                    if(rsMySqlFK1.getString("iuTipoCartera").equals(rsMySql.getString("iuTipoCartera")) ){
                   
                        registros[1] = rsMySqlFK1.getString("descrTipoCartera") ;
                    } 
                    }
                }
                
                registros[2] = rsMySql.getString("dniOCuit") ;
                registros[3] = rsMySql.getString("nombCompleto") ;
                registros[4] = rsMySql.getString("direccionCartera") ;
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
    public boolean insertarTablaCartera( Cartera obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "INSERT INTO cartera( iuTipoCartera, dniOCuit, nombCompleto, direccionCartera) VALUES( ?, ?, ?, ?)";
    try {
// se prepara la insercion y se inyecta los datos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, obj.getIuTipoCartera());
        _mySqlPreparaSentencia.setString(2, obj.getDniOCuit());
        _mySqlPreparaSentencia.setString(3,obj.getNombCompleto());
        _mySqlPreparaSentencia.setString(4, obj.getDireccionCartera());
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
    public boolean actualizarTablaCartera(Cartera obj ){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE cartera SET  iuTipoCartera = ?, dniOCuit = ?, nombCompleto = ?, direccionCartera = ?  WHERE iuCartera = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, obj.getIuTipoCartera());
        _mySqlPreparaSentencia.setString(2, obj.getDniOCuit());
        _mySqlPreparaSentencia.setString(3, obj.getNombCompleto());
        _mySqlPreparaSentencia.setString(4, obj.getDireccionCartera());
        _mySqlPreparaSentencia.setInt(5, obj.getIuCartera());
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
    public boolean eliminarTablaCartera(Cartera obj ){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE cartera SET  estadoEliminacion = ?  WHERE iuCartera = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getIuCartera() );
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
    public int obtenerIuCartera(String busqueda){
        int aux = 0;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuCartera, dniOCuit FROM Cartera WHERE  dniOCuit = '"+ busqueda+"' OR iuCartera = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = Integer.parseInt(rsMySql.getString("iuCartera"));
        }
            
            return aux;
    } catch (SQLException e) {
            
        return -1;
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
        _mySqlSentencia = "SELECT iuCartera, dniOCuit, estadoEliminacion FROM Cartera WHERE iuCartera LIKE '%"+ busqueda+"%' OR dniOCuit LIKE '%"+ busqueda+"%' ";
        _mySqlSentencia2 = "SELECT iuCartera, dniOCuit,  estadoEliminacion FROM Cartera ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("dniOcuit")); 
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("dniOCuit"));
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
    public DefaultListModel cargarLista2(String busqueda){      
// se genera la coneccion y el query de consulta        
        ArrayList<String> registros = new ArrayList<>();
        _modeloJList.clear();
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuCartera, nombCompleto, estadoEliminacion FROM Cartera WHERE iuCartera LIKE '%"+ busqueda+"%' OR nombCompleto LIKE '%"+ busqueda+"%' ";
        _mySqlSentencia2 = "SELECT iuCartera, nombCompleto,  estadoEliminacion FROM Cartera ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("nombCompleto")); 
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("nombCompleto"));
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
    public String obtenerDniOCuit(int busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuCartera, dniOCuit FROM Cartera WHERE iuCartera = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("dniOCuit");
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
    public String obtenerNombCompleto(int busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuCartera, nombCompleto FROM Cartera WHERE iuCartera = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("nombCompleto");
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
    public int obtenerIuCartera2(String busqueda){
        int aux = 0;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuCartera, nombCompleto FROM Cartera WHERE  nombCompleto = '"+ busqueda+"' OR iuCartera = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = Integer.parseInt(rsMySql.getString("iuCartera"));
        }
            
            return aux;
    } catch (SQLException e) {
            
        return -1;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();       
    }
    }
    
}
