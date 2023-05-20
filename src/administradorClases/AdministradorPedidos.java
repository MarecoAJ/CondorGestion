/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.Pedidos;
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


public class AdministradorPedidos {

    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;
    private String _mySqlSentencia2;
    private String _resultFiltrar= "fechaPedido DESC";
    private final DefaultListModel _modeloJList;
    
    public AdministradorPedidos() {
    
        _modeloJList = new DefaultListModel();
                
    
    }
    
// se pasa el valor de orden y acomoda los datos por ese tipo        
    public String ordenarTabla(String valor){
 
        switch(valor){
    
            case "Primeros agregados" : 
                _resultFiltrar = " fechaInsercion ASC";
            break;
            
            case "Seleccionar":
                _resultFiltrar = "codigoCristal ASC";
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
        String [] titulosTabla = {"Fecha del pedido","Cod. cristal","Modelo", "Marca","Cantidad"};
        String [] registros = new String[5];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();  
        _mySqlSentencia = "SELECT  pedidos.fechaPedido, pedidos.codigoCristal, pedidos.codModeloVeh, pedidos.iuMarcaCris, pedidos.cantidadPieza, pedidos.estadoEliminacion, marcacristales.iuMarcaCris, marcacristales.descrMarcaCris FROM pedidos INNER JOIN marcacristales ON pedidos.iuMarcaCris = marcacristales.iuMarcaCris ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo         
        Statement stMySql = (Statement) _conectarSql.createStatement();
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("fechaPedido");
                registros[1] = rsMySql.getString("codigoCristal");
                String _mySqlSentenciaFK1 = "SELECT codModeloVeh, descrModeloVeh FROM modelovehiculo WHERE codModeloVeh = "+rsMySql.getString("codModeloVeh")+" ";
                ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentenciaFK1);
                while(rsMySqlFK1.next()){
                    registros[2] = rsMySqlFK1.getString("descrModeloVeh") ;
                }
                 
                registros[3] = rsMySql.getString("descrMarcaCris") ; 
                registros[4] = rsMySql.getString("cantidadPieza") ;  
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
        String [] titulosTabla = {"Fecha del pedido","Cod. cristal","Modelo", "Marca","Cantidad"};
        String [] registros = new String[5];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
        _mySqlSentencia = "SELECT fechaPedido, codigoCristal, codModeloVeh, iuMarcaCris, cantidadPieza, estadoEliminacion FROM pedidos WHERE fechaPedido LIKE '%"+ busqueda+"%' OR codigoCristal LIKE '%"+ busqueda+"%' ";
        String _mySqlSentenciaFK1 = "SELECT iuMarcaCris, descrMarcaCris, estadoEliminacion FROM marcacristales"; 
        String _mySqlSentenciaFK2 = "SELECT codModeloVeh, descrModeloVeh, estadoEliminacion FROM modeloVehiculo";
       
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();
        Statement stMySqlFK2 = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentenciaFK1);
        ResultSet rsMySqlFK2 = stMySqlFK2.executeQuery(_mySqlSentenciaFK2);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("fechaPedido");
                registros[1] = rsMySql.getString("codigoCristal"); 
                while(rsMySqlFK2.next()){
                    if(rsMySqlFK2.getInt("estadoEliminacion") == 1 ){ 
                        if(rsMySqlFK2.getString("codModeloVeh").equals(rsMySql.getString("codModeloVeh")) ){
                   
                         registros[2] = rsMySqlFK2.getString("descrModeloVeh") ;
                        
                        } 
                    }
                   
                }
              
                while(rsMySqlFK1.next()){
                   if(rsMySqlFK1.getInt("estadoEliminacion") == 1 ){ 
                   if(rsMySqlFK1.getString("iuMarcaCris").equals(rsMySql.getString("iuMarcaCris")) ){
                   
                         registros[3] = rsMySqlFK1.getString("descrMarcaCris") ;
                        
                   } 
                   }
                   
               }
                registros[4] = rsMySql.getString("cantidadPieza"); 

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
    public boolean insertarTablaPedidos(Pedidos obj){
           boolean verdad = false;
           int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();  
        _mySqlSentencia = "SELECT estadoEliminacion FROM pedidos WHERE fechaPedido = "+obj.getFechaPedido()+" AND codigoCristal = "+obj.getCodigoCristal()+" AND codModeloVeh = "+obj.getCodModeloVeh()+" AND iuMarcaCris = "+obj.getIuMarcaCris()+"";
    try {
// se prepara la insercion y se inyecta los datos
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            if(rsMySql.next() == true){
                if(rsMySql.getInt("estadoEliminacion")==0){
                    System.err.println("encontro");
                    _mySqlSentencia = "UPDATE pedidos SET   cantidadPieza = ?, estadoEliminacion = ?  WHERE fechaPedido = ? AND codigoCristal = ? AND codModeloVeh = ? AND iuMarcaCris = ?";    
                    PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
                    _mySqlPreparaSentencia.setInt(1, obj.getCantidadPiezas());
                    _mySqlPreparaSentencia.setInt(2, 1 ); 
                    _mySqlPreparaSentencia.setString(3, obj.getFechaPedido());
                    _mySqlPreparaSentencia.setString(4, obj.getCodigoCristal());
                    _mySqlPreparaSentencia.setString(5,obj.getCodModeloVeh());
                    _mySqlPreparaSentencia.setInt(6,obj.getIuMarcaCris());
                    resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa                
                    if(resultadoInsercion != 0)verdad= true;
                } else{
                 System.err.println("encontro en 1");
                    verdad = false;
                }
            } else if(rsMySql.next()== false) {
                 
                _mySqlSentencia = "INSERT INTO pedidos ( fechaPedido, codigoCristal, codModeloVeh, iuMarcaCris, cantidadPieza ) VALUES( ?, ?, ?, ?, ?)";
                PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia); 
                _mySqlPreparaSentencia.setString(1, obj.getFechaPedido());
                _mySqlPreparaSentencia.setString(2, obj.getCodigoCristal());
                _mySqlPreparaSentencia.setString(3, obj.getCodModeloVeh());
                _mySqlPreparaSentencia.setInt(4, obj.getIuMarcaCris());
                _mySqlPreparaSentencia.setInt(5, obj.getCantidadPiezas());
                
                resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
                System.err.println("nuevo");
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
    public boolean actualizarTablaPedidos(Pedidos obj){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
           _mySqlSentencia = "UPDATE pedidos SET cantidadPieza=? WHERE fechaPedido = ? AND  codigoCristal = ? AND codModeloVeh = ? AND iuMarcaCris = ?";
   try {
// se prepara la actualizacion y se inyecta los datos nuevos
               PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
               _mySqlPreparaSentencia.setInt(1, obj.getCantidadPiezas());
               _mySqlPreparaSentencia.setString(2, obj.getFechaPedido());
               _mySqlPreparaSentencia.setString(3, obj.getCodigoCristal());
               _mySqlPreparaSentencia.setString(4, obj.getCodModeloVeh());
               _mySqlPreparaSentencia.setInt(5, obj.getIuMarcaCris()); 
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
    public boolean eliminarTablaPedidos(Pedidos obj){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE pedidos SET  estadoEliminacion = ?  WHERE fechaPedido = ? AND codigoCristal = ? AND codModeloVeh = ? AND iuMarcaCris = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setString(2, obj.getFechaPedido());
        _mySqlPreparaSentencia.setString(3, obj.getCodigoCristal());
        _mySqlPreparaSentencia.setString(4, obj.getCodModeloVeh());
        _mySqlPreparaSentencia.setInt(5, obj.getIuMarcaCris());
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
    public DefaultListModel cargarListaFecha(String busqueda, int marca){      
// se genera la coneccion y el query de consulta        
        ArrayList<String> registros = new ArrayList<>();
        _modeloJList.clear();
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT fechaPedido, iuMarcaCris, estadoEliminacion FROM pedidos WHERE fechaPedido LIKE '%"+ busqueda+"%' OR iuMarcaCris LIKE '%"+ marca+"%' ";
        _mySqlSentencia2 = "SELECT fechaPedido, iuMarcaCris, estadoEliminacion FROM pedidos ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    if(  marca == rsMySql.getInt("iuMarcaCris")){
                        
                        registros.add(rsMySql.getString("fechaPedido"));
                    }
                     
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                    
                    registros.add(rsMySql.getString("fechaPedido"));
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

