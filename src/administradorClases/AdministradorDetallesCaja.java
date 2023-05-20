/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.Caja;
import clasesDatos.DetallesDeCaja;
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


public class AdministradorDetallesCaja {
// atributos y variables       
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia;
    private String _mySqlSentencia2;
    private String _resultFiltrar= " fechaInsercion DESC";
    private final AdministradorTipoPagos _administradorTipoPagos;
    
    public AdministradorDetallesCaja() {
        _modeloJList = new DefaultListModel<>();
        _administradorTipoPagos = new AdministradorTipoPagos();
    }
    
// se pasa un valor de orden y acomoda los datos por ese tipo    
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
    }
    
    return _resultFiltrar;
    }
 
// este metodo carga los jTable en caso de ser vacio devuelve null 
    public DefaultTableModel cargarJTabla(String iuCaja){
// se crea el modelo de jtable   
        String [] titulosTabla = {"Reg. caja", "Nº de detalle", "Pago", "Subtotal"};
        String [] registros = new String[4];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT detallesdecaja.iuCaja ,detallesdecaja.iuDetalleCaja, detallesdecaja.iuTipoPago,  detallesdecaja.subTotal,  detallesdecaja.fechaInsercion,  detallesdecaja.estadoEliminacion, tipopagos.descrTipoPago FROM  detallesdecaja INNER JOIN tipopagos ON   detallesdecaja.iuTipoPago = tipopagos.iuTipoPago ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo   
        Statement stMySql = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
               
                if(iuCaja.equals(rsMySql.getString("iuCaja"))){
                    
                    registros[0] = rsMySql.getString("iuCaja");
                    registros[1] = rsMySql.getString("iuDetalleCaja"); 
                    registros[2] = rsMySql.getString("descrTipoPago") ;
                    registros[3] = rsMySql.getString("subTotal");
                    _modeloJTabla.addRow(registros);
                }
                 
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
    public DefaultTableModel buscarEnTabla(String busqueda, String iuCaja){
// se crea el modelo de jtable   
        String [] titulosTabla = {"Reg. caja", "Nº de detalle", "Pago", "Subtotal"};
        String [] registros = new String[4];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuCaja , iuDetalleCaja,  iuTipoPago, subTotal, estadoEliminacion FROM detallesdecaja WHERE iuDetalleCaja = '"+ busqueda +"' OR iuTipoPago LIKE '%"+ _administradorTipoPagos.obtenerIuTipoPago(busqueda) +"%'";     
        String _mySqlSentenciaFK1 = "SELECT iuTipoPago, descrTipoPago, estadoEliminacion FROM tipopagos"; 
     
    try {
// se obtiene los datos de la db y se carga el modelo 
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();// mirara xq cast  
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentenciaFK1);
        
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                if(rsMySql.getString("iuCaja").equals(iuCaja)){
                    registros[0] = rsMySql.getString("iuCaja");
                    registros[1] = rsMySql.getString("iuDetalleCaja");
                
                    while(rsMySqlFK1.next()){
                        if(rsMySqlFK1.getInt("estadoEliminacion") == 1 ){ 
                            if(rsMySqlFK1.getString("iuTipoPago").equals(rsMySql.getString("iuTipoPago")) ){

                                registros[2] = rsMySqlFK1.getString("descrTipoPago") ;
                            } 
                        }
                        registros[3] = rsMySql.getString("subTotal");
                    }
                
                 _modeloJTabla.addRow(registros);
                
                }
                
                 
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
    public boolean insertarTablaDetalleCaja(DetallesDeCaja obj){
        boolean verdad = false;
        int resultadoInsercion = 0;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();  
        _mySqlSentencia2 = "SELECT estadoEliminacion FROM caja WHERE iuCaja = '"+obj.getIuCaja()+"'";
   
    try {
// se prepara la insercion y se inyecta los datos
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);

            if(rsMySql.next() == true){
                if(rsMySql.getInt("estadoEliminacion")==1){
                    _mySqlSentencia2 = "SELECT * FROM detallesdecaja"; 
                    Statement stMySql2 = (Statement) _conectarSql.createStatement(); 
                    ResultSet rsMySql2 = stMySql.executeQuery(_mySqlSentencia2); 
                    if(rsMySql2.next()) {

                        _mySqlSentencia = "INSERT INTO detallesdecaja ( iuCaja,iuDetalleCaja, iuTipoPago, subTotal) VALUES( ?, ?, ?, ?)";
                        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia); 
                        _mySqlPreparaSentencia.setInt(1, obj.getIuCaja());
                        _mySqlPreparaSentencia.setInt(2, obtenerUltimoId(obj) +1);
                        _mySqlPreparaSentencia.setInt(3, obj.getIuTipoPago());
                        _mySqlPreparaSentencia.setDouble(4, obj.getSubTotal());
                        resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
                        
                    } else{

                        _mySqlSentencia = "INSERT INTO detallesdecaja ( iuCaja, iuDetalleCaja, iuTipoPago, subTotal) VALUES( ?, ?, ?, ?)";
                        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia); 
                        _mySqlPreparaSentencia.setInt(1, obj.getIuCaja());
                        _mySqlPreparaSentencia.setInt(2,  + 1);
                        _mySqlPreparaSentencia.setInt(3, obj.getIuTipoPago());
                        _mySqlPreparaSentencia.setDouble(4, obj.getSubTotal());
                        resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
                    }
                    
// se verifica la insercion exitosa 
                if(resultadoInsercion != 0)verdad= true;
                
                } else{
                
                    verdad = false;
                }
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
    public boolean actualizarTablaDetalleCaja(DetallesDeCaja obj){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE detallesdecaja SET  iuTipoPago = ?, subTotal = ? WHERE iuCaja = ? AND iuDetalleCaja = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, obj.getIuTipoPago());
        _mySqlPreparaSentencia.setDouble(2, obj.getSubTotal());
        _mySqlPreparaSentencia.setInt(3, obj.getIuCaja());
        _mySqlPreparaSentencia.setInt(4, obj.getIuDetalleCaja());
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
    public boolean eliminarTablaDetalleCaja(DetallesDeCaja obj){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE detallesdecaja SET  estadoEliminacion = ?  WHERE iuCaja = ? AND iuDetalleCaja = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getIuCaja() );
        _mySqlPreparaSentencia.setInt(3, obj.getIuDetalleCaja());
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
    public DefaultListModel cargarListaDetalles(String busqueda){      
// se genera la coneccion y el query de consulta        
        _modeloJList.clear();
        _conectarSql = getConection();
        int aux=0;
        _mySqlSentencia = "SELECT iuCaja, iuDetalleCaja, iuTipoPago, subTotal, estadoEliminacion FROM detallesdecaja WHERE iuCaja LIKE '%"+ busqueda+"%' ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                   _modeloJList.addElement("Nº detalle:  " + rsMySql.getString("iuDetalleCaja") + " -  Pago:  " + _administradorTipoPagos.obtenerDescrTipoPago(rsMySql.getString("iuTipoPago")) + " -  Subtotal:  "+ rsMySql.getString("subTotal"));
                }
            }    
        }
            return _modeloJList;
    } catch (SQLException e) {
            
        return null;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();       
    }
    }
    
    public int obtenerUltimoId(DetallesDeCaja obj){
        
        int aux= 0;
        
        try {
               
            _conectarSql = getConection(); 
            _mySqlSentencia = "SELECT MAX(iuDetalleCaja) FROM detallesdecaja WHERE iuCaja = '"+obj.getIuCaja()+"'";
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            rsMySql.next();
            
            aux = rsMySql.getInt(1);
        } catch (SQLException e) {
         
        return 0;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();        
    }
   
    return aux;
    }
    
    // eliminan los datos del sistema no de la db
    public void eliminarDetalleCajaAutomatico(Caja obj){
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia2 = "SELECT iuCaja , iuDetalleCaja estadoEliminacion FROM detallesdecaja WHERE iuCaja = '"+ obj.getIuCaja() +"' ";
        _mySqlSentencia = "UPDATE detallesdecaja SET  estadoEliminacion = ?  WHERE iuCaja = ? AND iuDetalleCaja = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        Statement stMySql1 = (Statement) _conectarSql.createStatement();// mirara xq cast  
        ResultSet rsMySql1 = stMySql1.executeQuery(_mySqlSentencia2);
         while(rsMySql1.next()){
             
             PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
            _mySqlPreparaSentencia.setInt(1, 0);
            _mySqlPreparaSentencia.setInt(2, obj.getIuCaja() );
            _mySqlPreparaSentencia.setInt(3, rsMySql1.getInt("iuDetalleCaja"));
            _mySqlPreparaSentencia.executeUpdate();
        }
    } catch (SQLException e) {

           
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();         
    }
    }
    
    public String obtenerIuDetalleCaja(String ic, String idc){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuCaja, iuDetalleCaja, estadoEliminacion FROM detallesdecaja WHERE  iuCaja = '"+ ic+"' AND iuDetalleCaja = '"+ idc+"' ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

            if(rsMySql.getInt("estadoEliminacion")==1){
                
                aux = rsMySql.getString("iuDetalleCaja");
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
    
           // este metodo busca lo ingresado y muetra el resultado    
    public DefaultListModel cargarLista(String ic, String idc){      
// se genera la coneccion y el query de consulta        
        ArrayList<String> registros = new ArrayList<>();
        _modeloJList.clear();
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuCaja, iuDetalleCaja, estadoEliminacion FROM detallesdecaja WHERE iucaja LIKE '%"+ic+"%' AND iuDetallecaja LIKE '%"+idc+"%' ";
        _mySqlSentencia2 = "SELECT iuCaja, iuDetalleCaja, estadoEliminacion FROM detallesdecaja WHERE iucaja = '"+ic+"'";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(ic.length()!=0 && idc.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("iuDetalleCaja")); 
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("iuDetalleCaja"));
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
