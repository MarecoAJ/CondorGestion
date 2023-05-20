/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.ContactoCartera;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import controladorBD.ConectorMySql;
import static controladorBD.ConectorMySql.desconectarMySql;
import static controladorBD.ConectorMySql.getConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class AdministradorContactoCartera extends ConectorMySql{
       
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;  
    private String _resultFiltrar= "fechaInsercion DESC";
    private final AdministradorCartera _administradorCartera;
    
    public AdministradorContactoCartera() {
        _administradorCartera = new AdministradorCartera();
    }
    
// se pasa el valor de orden y acomoda los datos por ese tipo        
    public String ordenarTabla(String valor){
 
        switch(valor){
    
            case "Primeros agregados" : 
                _resultFiltrar = " fechaInsercion ASC";
            break;
            
            case "Seleccionar":
                _resultFiltrar = "iuContactoCartera ASC";
            break; 
            
            case "Ultimos agregados":
                _resultFiltrar = " fechaInsercion DESC";
            break;
        }
    
        return _resultFiltrar;
    }

// este metodo carga los jTable en caso de ser vacio devuelve null    
    public DefaultTableModel cargarJTabla(){
        String [] titulosTabla = {"N° de reg.","Dni o CUIT",  "Telefono", "celular", "Correo"};
        String [] registros = new String[5];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();        
        _mySqlSentencia = "SELECT contactoCartera.iuContactoCartera, contactoCartera.iuCartera, contactoCartera.telefonoContacto, contactoCartera.celularContacto, contactoCartera.correoContacto, contactoCartera.fechaInsercion, contactoCartera.estadoEliminacion, Cartera.dniOCuit FROM contactoCartera INNER JOIN Cartera ON contactoCartera.iuCartera = Cartera.iuCartera ORDER BY " + _resultFiltrar + "";

    try {
// se obtiene los datos de la db y se carga el modelo
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
      
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuContactoCartera");
                registros[1] = rsMySql.getString("dniOCuit"); 
                registros[2] = rsMySql.getString("telefonoContacto") ;
                registros[3] = rsMySql.getString("celularContacto") ;
                registros[4] = rsMySql.getString("correoContacto") ;
   
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
         String [] titulosTabla = {"N° de reg.","Dni o CUIT",  "Telefono", "celular", "Correo"};
        String [] registros = new String[5];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
// la doblesentencia corresponde a que el usuario piede buscar por marca 

         int aux = _administradorCartera.obtenerIuCartera(busqueda);

        _mySqlSentencia = "SELECT iuContactoCartera, iuCartera, telefonoContacto, celularContacto, correoContacto, estadoEliminacion FROM contactoCartera WHERE iuContactoCartera LIKE '%"+ busqueda+"%' OR telefonoContacto LIKE '%"+ busqueda+"%' OR celularContacto LIKE '%"+ busqueda+"%' OR correoContacto LIKE '%"+ busqueda+"%' OR iucartera LIKE '%"+ aux +"%'";     
        String _mySqlSentenciaFK1 = "SELECT iuCartera, dniOCuit, estadoEliminacion FROM Cartera"; 
     
       
        
    try {
// se obtiene los datos de la db y se carga el modelo     
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();  
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentenciaFK1);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuContactoCartera");
              
                while(rsMySqlFK1.next()){
                    if(rsMySqlFK1.getInt("estadoEliminacion") == 1 ){ 
                    if(rsMySqlFK1.getString("iuCartera").equals(rsMySql.getString("iuCartera")) ){
                   
                        registros[1] = rsMySqlFK1.getString("dniOCuit") ;
                    } 
                    }
                }
                
                registros[2] = rsMySql.getString("telefonoContacto") ;
                registros[3] = rsMySql.getString("celularContacto") ;
                registros[4] = rsMySql.getString("correoContacto") ;
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
    public boolean insertarTablaContactoCartera( ContactoCartera obj){
        boolean verdad = false;
        int resultadoInsercion;
        int auxCartera = 0;
        
        auxCartera = obj.getIuCartera(); 
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuCartera, estadoEliminacion FROM contactocartera WHERE iuCartera = '"+ auxCartera+"' ";
        Statement stMySql; 
        try {
            stMySql = (Statement) _conectarSql.createStatement();
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            
            if(rsMySql.next()==true){
            
                if(rsMySql.getInt("estadoEliminacion")==0){

// se genera la coneccion y el query de consulta        
                    _mySqlSentencia = "INSERT INTO contactocartera( iuContactoCartera, iuCartera, telefonoContacto, celularContacto, correoContacto) VALUES( ?, ?, ?, ?, ?)";

// se prepara la insercion y se inyecta los datos
                    PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
                    _mySqlPreparaSentencia.setInt(1, obj.getIuContactoCartera());
                    _mySqlPreparaSentencia.setInt(2, obj.getIuCartera());
                    _mySqlPreparaSentencia.setString(3, obj.getTelefonoContacto());
                    _mySqlPreparaSentencia.setString(4,obj.getCelularContacto());
                    _mySqlPreparaSentencia.setString(5, obj.getCorreoContacto());
                    resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa        
                    if(resultadoInsercion != 0) verdad= true; 
                }else {
                
                    verdad = false;
                }
                
            } else{
            
// se genera la coneccion y el query de consulta        
                    _mySqlSentencia = "INSERT INTO contactocartera( iuContactoCartera, iuCartera, telefonoContacto, celularContacto, correoContacto) VALUES( ?, ?, ?, ?, ?)";

// se prepara la insercion y se inyecta los datos
                    PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
                    _mySqlPreparaSentencia.setInt(1, obj.getIuContactoCartera());
                    _mySqlPreparaSentencia.setInt(2, obj.getIuCartera());
                    _mySqlPreparaSentencia.setString(3, obj.getTelefonoContacto());
                    _mySqlPreparaSentencia.setString(4,obj.getCelularContacto());
                    _mySqlPreparaSentencia.setString(5, obj.getCorreoContacto());
                    resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa        
                    if(resultadoInsercion != 0) verdad= true;
            }
            
        } catch (SQLException e) {
                  
            return verdad;      
        } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();         
    
        }  

        return verdad;     
    }
    
// se actualiza datos en la db   
    public boolean actualizarTablaContactoCartera(ContactoCartera obj ){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE contactocartera SET   telefonoContacto = ?, celularContacto = ?, correoContacto = ? WHERE iuContactoCartera = ? AND iuCartera = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        
        _mySqlPreparaSentencia.setString(1, obj.getTelefonoContacto());
        _mySqlPreparaSentencia.setString(2, obj.getCelularContacto());
        _mySqlPreparaSentencia.setString(3, obj.getCorreoContacto());
        _mySqlPreparaSentencia.setInt(4, obj.getIuContactoCartera());
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
    public boolean eliminarTablaContactoCartera(ContactoCartera obj ){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE contactoCartera SET  estadoEliminacion = ?  WHERE iuContactoCartera = ? AND iuCartera = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getIuContactoCartera() );
        _mySqlPreparaSentencia.setInt(3, obj.getIuCartera() );
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
    
    public int generadorIuContactoCartera(){
        int iuCC = 0;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT * FROM contactoCartera ";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentencia);
        
        while (rsMySqlFK1.next()) {
            iuCC++;  
        }
           
            return iuCC;
    } catch (SQLException e) {

           return iuCC;
           
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();         
    }
    }
    
}
