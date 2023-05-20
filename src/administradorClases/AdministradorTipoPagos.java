package administradorClases;

import clasesDatos.TipoPagos;
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

public class AdministradorTipoPagos {
    
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia;
    private String _mySqlSentencia2;
    private String _resultFiltrar= "iuTipoPago DESC";
    
    public AdministradorTipoPagos() {
    
        _modeloJList = new DefaultListModel();
    }
           
    public String ordenarTabla(String valor){

        switch(valor){
    
            case "Primeros agregados" : 
                _resultFiltrar = " fechaInsercion ASC";
            break;
            
            case "Seleccionar":
                _resultFiltrar = "iuTipoPago ASC";
            break; 
            
            case "Ultimos agregados":
                _resultFiltrar = " fechaInsercion DESC";
            break;
            
            case "Alfabeticos":
                _resultFiltrar = " descrTipoPago ASC";
            break;
        }
    
        return _resultFiltrar;
    }
   
    public DefaultTableModel cargarJTabla(){
 
        String [] titulosTabla = {"Nº registro", "Descripcion"};
        String [] registros = new String[2];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuTipoPago, descrTipoPago, fechaInsercion, estadoEliminacion FROM tipopagos ORDER BY " + _resultFiltrar + "";
    
    try {
        
        Statement stMySql = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            
            if(rsMySql.getInt("estadoEliminacion") == 1){
                    
                registros[0] = rsMySql.getString("iuTipoPago");
                registros[1] = rsMySql.getString("descrTipoPago");  
                _modeloJTabla.addRow(registros);      
            }
        }
   
        return _modeloJTabla; 
    } catch (SQLException e) {
             
        return null;
    } finally{

        _conectarSql = desconectarMySql();
    }     
    }    
        
    public DefaultTableModel buscarEnTabla(String busqueda){

        String [] titulosTabla = {"Nº registro", "Descripcion"};
        String [] registros = new String[2];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);       
        _conectarSql = getConection();   
        _mySqlSentencia = "SELECT iuTipoPago, descrTipoPago, estadoEliminacion FROM tipopagos WHERE iuTipoPago LIKE '%"+ busqueda+"%' OR descrTipoPago LIKE '%"+ busqueda+"%' ";

    try {
      
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            
            if(rsMySql.getInt("estadoEliminacion") == 1){
                      
                registros[0] = rsMySql.getString("iuTipoPago");
                registros[1] = rsMySql.getString("descrTipoPago");
                _modeloJTabla.addRow(registros);       
            }
        }
        
        return _modeloJTabla;
    } catch (SQLException e) {
         
        return null;
    } finally{
        
        _conectarSql = desconectarMySql();        
    }    
    }    

    public boolean insertarTablaTiposPagos(TipoPagos obj){
        boolean verdad = false;
        int resultadoInsercion;       
        _conectarSql = getConection();
        _mySqlSentencia = "INSERT INTO tipopagos ( DescrTipoPago ) VALUES( ? )";
    try {

        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getDescrTiposPagos());
        resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
     
        if(resultadoInsercion != 0) verdad= true; 
           
            return verdad;           
    } catch (SQLException e) {
                  
        return verdad;      
    } finally{

        _conectarSql = desconectarMySql();         
    }       
    }

    public boolean actualizarTablaTiposPagos(TipoPagos obj){
        boolean verdad = false;
        int resultadoActualizacion;       
        _conectarSql = getConection(); 
        _mySqlSentencia = "UPDATE tipopagos SET  descrTipoPago = ? WHERE iuTipoPago = ?";
    try {

        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getDescrTiposPagos());
        _mySqlPreparaSentencia.setInt(2, obj.getIuTiposPagos());
        resultadoActualizacion = _mySqlPreparaSentencia.executeUpdate();
             
        if(resultadoActualizacion != 0) verdad= true;
           
            return verdad;          
    } catch (SQLException e) {

        return verdad;      
    } finally{

        _conectarSql = desconectarMySql();         
    }
    }

    public boolean eliminarTablaTiposPagos(TipoPagos obj){
        boolean verdad = false;
        int resultadosEliminacion;     
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE tipopagos SET estadoEliminacion = ? WHERE iuTipoPago = ?";
        
    try {
 
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getIuTiposPagos());
        resultadosEliminacion = _mySqlPreparaSentencia.executeUpdate();
               
        if(resultadosEliminacion != 0) verdad= true;  
           
            return verdad;        
    } catch (SQLException e) {

           return verdad;
    } finally{
        
        _conectarSql = desconectarMySql();         
    }
    }   
 
    public String obtenerDescrTipoPago(String busqueda){
        String aux = "";     
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuTipoPago, descrTipoPago FROM tipoPagos WHERE iuTipoPago = '"+busqueda+"'  ";
    
    try {
  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

            aux = rsMySql.getString("descrTipoPago");
        }
            
        return aux;
    } catch (SQLException e) {
            
        return null;
    } finally{

        _conectarSql = desconectarMySql();       
    }
    }

    public String obtenerIuTipoPago(String busqueda){
        String aux = "";     
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuTipoPago, descrTipoPago FROM tipoPagos WHERE descrTipoPago = '"+busqueda+"'  ";
    
    try {
 
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

            aux = rsMySql.getString("iuTipoPago");
        }
            
        return aux;
    } catch (SQLException e) {
            
        return null;
    } finally{

        _conectarSql = desconectarMySql();       
    }
    }
 
    public DefaultListModel cargarLista(String busqueda){      
     
        ArrayList<String> registros = new ArrayList<>();
        _modeloJList.clear();
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuTipoPago, descrTipoPago, estadoEliminacion FROM tipopagos WHERE iuTipoPago LIKE '%"+busqueda+"%' OR descrTipoPago LIKE '%"+busqueda+"%'";
        _mySqlSentencia2 = "SELECT iuTipoPago, descrTipoPago, estadoEliminacion FROM tipopagos ORDER BY " + _resultFiltrar + "";
    
    try {
 
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            
            while(rsMySql.next()){
                
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("descrTipoPago")); 
                }    
            }
        } else{
            
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("descrTipoPago"));
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

        _conectarSql = desconectarMySql();       
    }
    }
}
