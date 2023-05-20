/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.Caja;
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

public class AdministradorCaja {
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;  
    private String _resultFiltrar= "fechaInsercion DESC";
    private String _mySqlSentencia2;
    private final DefaultListModel _modeloJList;
    private final AdministradorTipoCaja _administradorTipoCaja;
    private final AdministradorTipoFactura _administradorTipoFactura;
    
    public AdministradorCaja() {
          
        _modeloJList = new DefaultListModel();
        _administradorTipoCaja = new AdministradorTipoCaja();
        _administradorTipoFactura = new AdministradorTipoFactura();
    }
   
// se pasa el valor de orden y acomoda los datos por ese tipo        
    public String ordenarTabla(String valor){
 
        switch(valor){
    
            case "Primeros agregados" : 
                _resultFiltrar = " fechaInsercion ASC";
            break;
            
            case "Seleccionar":
                _resultFiltrar = "iuCaja ASC";
            break; 
            
            case "Ultimos agregados":
                _resultFiltrar = " fechaInsercion DESC";
            break;
            
            case "Alfabeticos":
                _resultFiltrar = " descrCaja ASC";
            break;
        }
    
        return _resultFiltrar;
    }

// este metodo carga los jTable en caso de ser vacio devuelve null    
    
    public DefaultTableModel cargarJTabla(){
// se crea el modelo de jtable        
        String [] titulosTabla = {"Nº registro", "Tipo de caja", "Factura", "Fecha de caja", "Fecha de fac.", "A nombre", "Nº fac.", "Descripcion", "Total"};
        String [] registros = new String[9];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();        
        _mySqlSentencia = "SELECT caja.iuCaja, caja.iuTipoCaja, caja.iuTipoFactura, caja.fechaCaja, caja.fechaFactura, caja.aNombreDe, caja.numFactura, caja.descrCaja, caja.totalCaja, caja.fechaInsercion, caja.estadoEliminacion, tipocaja.descrTipoCaja FROM caja INNER JOIN tipocaja ON caja.iuTipoCaja = tipocaja.iuTipoCaja ORDER BY " + _resultFiltrar + "";
        _mySqlSentencia2 = "SELECT iuTipoFactura, descrTipoFactura, estadoEliminacion FROM tipofactura";
    try {
        
// se obtiene los datos de la db y se carga el modelo
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();  
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentencia2);
      
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuCaja");
                registros[1] = rsMySql.getString("descrTipoCaja"); 

                while(rsMySqlFK1.next()){
                    if(rsMySqlFK1.getInt("estadoEliminacion") == 1 ){ 
                    if(rsMySqlFK1.getString("iuTipoFactura").equals(rsMySql.getString("iuTipoFactura")) ){
                   
                        registros[2] = rsMySqlFK1.getString("descrTipoFactura") ;
                    } 
                    }
                }
                
                registros[3] = rsMySql.getString("fechaCaja");
                registros[4] = rsMySql.getString("fechaFactura");
                registros[5] = rsMySql.getString("aNombreDe");
                registros[6] = rsMySql.getString("numFactura");
                registros[7] = rsMySql.getString("descrCaja");
                registros[8] = rsMySql.getDouble("totalCaja") + "";

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
        String [] titulosTabla = {"Nº registro", "Tipo de caja", "Factura", "Fecha de caja", "Fecha de fac.", "A nombre", "Nº fac.", "Descripcion", "Total"};
        String [] registros = new String[9];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
// la doblesentencia corresponde a que el usuario piede buscar por marca 
        _mySqlSentencia = "SELECT iuCaja, iuTipoCaja, iuTipoFactura, fechaCaja, fechaFactura, aNombreDe, numFactura, descrCaja, totalCaja, estadoEliminacion FROM caja WHERE iuCaja LIKE '%"+ busqueda+"%' OR descrCaja LIKE '%"+ busqueda+"%' OR aNombreDe LIKE '%"+ busqueda+"%' OR numFactura LIKE '%"+ busqueda+"%' OR fechaCaja LIKE '%"+ busqueda+"%' OR fechaFactura LIKE '%"+ busqueda+"%'";     
        
    try {
// se obtiene los datos de la db y se carga el modelo     
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);

        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuCaja");
                registros[1] = _administradorTipoCaja.obtenerIuTipoCaja( rsMySql.getString("iuTipoCaja")) ;
                registros[2] = _administradorTipoFactura.obtenerDescrTipoFactura(rsMySql.getString("iuTipoFactura") );
                registros[3] = rsMySql.getString("fechaCaja");
                registros[4] = rsMySql.getString("fechaFactura");
                registros[5] = rsMySql.getString("aNombreDe");
                registros[6] = rsMySql.getString("numFactura");
                registros[7] = rsMySql.getString("descrCaja");
                registros[8] = rsMySql.getDouble("totalCaja") + "";

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
    public boolean insertarTablaCajas(Caja obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "INSERT INTO Caja( iuTipoCaja, iuTipoFactura, fechaCaja, fechaFactura, aNombreDe, numFactura, descrCaja, totalCaja) VALUES( ?, ?, ?, ?, ?, ?, ?, ? )";
    try {
// se prepara la insercion y se inyecta los datos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, obj.getIuTipoCaja());
        _mySqlPreparaSentencia.setInt(2, obj.getIuTipoFactura());
        _mySqlPreparaSentencia.setString(3, obj.getFechaCaja());
        _mySqlPreparaSentencia.setString(4, obj.getFechaFactura());
        _mySqlPreparaSentencia.setString(5, obj.getANombreDe());
        _mySqlPreparaSentencia.setInt(6, obj.getNumFactura());
        _mySqlPreparaSentencia.setString(7, obj.getDescrCaja());
        _mySqlPreparaSentencia.setDouble(8, obj.getTotalCaja());
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
    public boolean actualizarTablaCajas( Caja obj){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
        _mySqlSentencia = "UPDATE Caja SET  iuTipoCaja = ?, iuTipoFactura = ?, fechaCaja = ?, fechaFactura = ?, aNombreDe = ?, numFactura = ?, descrCaja = ?, totalCaja = ?  WHERE iuCaja = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
         _mySqlPreparaSentencia.setInt(1, obj.getIuTipoCaja());
        _mySqlPreparaSentencia.setInt(2, obj.getIuTipoFactura());
        _mySqlPreparaSentencia.setString(3, obj.getFechaCaja());
        _mySqlPreparaSentencia.setString(4, obj.getFechaFactura());
        _mySqlPreparaSentencia.setString(5, obj.getANombreDe());
        _mySqlPreparaSentencia.setInt(6, obj.getNumFactura());
        _mySqlPreparaSentencia.setString(7, obj.getDescrCaja());
        _mySqlPreparaSentencia.setDouble(8, obj.getTotalCaja());
        _mySqlPreparaSentencia.setInt(9, obj.getIuCaja());
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
    public boolean eliminarTablaCajas( Caja obj){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE  caja SET estadoEliminacion = ? WHERE iuCaja = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getIuCaja());
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
            _mySqlSentencia = "SELECT MAX(iuCaja) FROM caja";
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
    
    public String obtenerIuCaja(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuCaja, descrCaja FROM caja WHERE  iuCaja = '"+ busqueda+"' ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("iuCaja");
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
        _mySqlSentencia = "SELECT iuCaja, estadoEliminacion FROM caja WHERE iucaja LIKE '%"+busqueda+"%' ";
        _mySqlSentencia2 = "SELECT iuCaja, estadoEliminacion FROM caja ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("iuCaja")); 
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("iuCaja"));
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
