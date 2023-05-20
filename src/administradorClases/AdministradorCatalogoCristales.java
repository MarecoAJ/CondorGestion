/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.CatalogoCristales;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import controladorBD.ConectorMySql;
import static controladorBD.ConectorMySql.desconectarMySql;
import static controladorBD.ConectorMySql.getConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class AdministradorCatalogoCristales extends ConectorMySql{

    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;
    private String _resultFiltrar= " codigoCristal DESC";
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia2;
    private final AdministradorMarcaVehiculo _administradorMarcaVehiculo;
    private final AdministradorModeloVehiculo _administradorModeloVehiculo;
    private final AdministradorMarcasCristales _administradorMarcasCristales;
    
    private int cantBusqTotal;
    
    public AdministradorCatalogoCristales() {
        _modeloJList = new DefaultListModel<>();  
        _administradorMarcaVehiculo = new AdministradorMarcaVehiculo();
        _administradorModeloVehiculo = new AdministradorModeloVehiculo();
        _administradorMarcasCristales = new AdministradorMarcasCristales();
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
            
            case "Marca cristal": 
               _resultFiltrar = " iuMarcaCris ASC"; 
            break;
            
            case "Modelo vehiculo": 
               _resultFiltrar = " codModeloVeh ASC"; 
            break;
            
        }
    
        return _resultFiltrar;
    }

// este metodo carga los jTable en caso de ser vacio devuelve null     
    public DefaultTableModel cargarJTabla(){
// se crea el modelo de jtable  
        String [] titulosTabla = {"Cod. cristal", "Descripcion","Marca", "Modelo", "Marca", "Cant. fija", "Cant. en stock", "Precio"};
        String [] registros = new String[8];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT catalogocristales.codigoCristal, catalogocristales.descrCristal, catalogocristales.codModeloVeh, catalogocristales.iuMarcaCris, catalogocristales.cantidadMinima, catalogocristales.cantidadExistencia, catalogocristales.precioPieza, catalogocristales.fechaInsercion, catalogocristales.estadoEliminacion, marcacristales.descrMarcaCris FROM catalogocristales INNER JOIN marcacristales ON catalogocristales.iuMarcaCris = marcacristales.iuMarcaCris ORDER BY " + _resultFiltrar + "";
        
    try {
// se obtiene los datos de la db y se carga el modelo         
        Statement stMySql = (Statement) _conectarSql.createStatement();
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("codigoCristal");
                registros[1] = rsMySql.getString("descrCristal");
              
// se carga la marca pa mas esterica
                String auxUno = _administradorModeloVehiculo.obtenercodMarcaVeh(rsMySql.getString("codModeloVeh"));
                String auxDos = _administradorMarcaVehiculo.obtenerDescrMarcaVeh(auxUno);
                registros[2] = auxDos;
                
                String _mySqlSentenciaFK1 = "SELECT codModeloVeh, descrModeloVeh FROM modelovehiculo WHERE codModeloVeh = "+rsMySql.getString("codModeloVeh")+" ";
                ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentenciaFK1);
                while(rsMySqlFK1.next()){
                    registros[3] = rsMySqlFK1.getString("descrModeloVeh") ;
                }
                 
                registros[4] = rsMySql.getString("descrMarcaCris") ; 
                registros[5] = rsMySql.getString("cantidadMinima") ; 
                registros[6] = rsMySql.getString("cantidadExistencia") ;
                String auxDecimal =rsMySql.getString("precioPieza");
                registros[7] = auxDecimal;

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
        String [] titulosTabla = {"Cod. cristal", "Marca", "Descripcion", "Modelo", "Marca", "Cant. fija", "Cant. en stock", "Precio"};
        String [] registros = new String[8];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();  
        
        if(_administradorModeloVehiculo.obtenerCodModeloVeh(busqueda).length()!=0 &&  _administradorMarcasCristales.obtenerIuMarcaCris(busqueda).length()!=0 ){
        
            _mySqlSentencia = "SELECT codigoCristal, descrCristal, codModeloVeh, iuMarcaCris, cantidadMinima, cantidadExistencia, precioPieza, estadoEliminacion FROM catalogocristales WHERE codigoCristal LIKE '%"+ busqueda+"%' OR descrCristal LIKE '%"+ busqueda+"%' OR codModeloVeh LIKE '%"+ _administradorModeloVehiculo.obtenerCodModeloVeh(busqueda) +"%' OR iuMarcaCris LIKE '%"+_administradorMarcasCristales.obtenerIuMarcaCris(busqueda)+"%'";     
        
        
        } else if(_administradorModeloVehiculo.obtenerCodModeloVeh(busqueda).length()!=0 ){
        
            _mySqlSentencia = "SELECT codigoCristal, descrCristal, codModeloVeh, iuMarcaCris, cantidadMinima, cantidadExistencia, precioPieza, estadoEliminacion FROM catalogocristales WHERE codigoCristal LIKE '%"+ busqueda+"%' OR descrCristal LIKE '%"+ busqueda+"%' OR codModeloVeh LIKE '%"+ _administradorModeloVehiculo.obtenerCodModeloVeh(busqueda) +"%'";     
        
        
        } else if( _administradorMarcasCristales.obtenerIuMarcaCris(busqueda).length()!=0 ){
            
            _mySqlSentencia = "SELECT codigoCristal, descrCristal, codModeloVeh, iuMarcaCris, cantidadMinima, cantidadExistencia, precioPieza, estadoEliminacion FROM catalogocristales WHERE codigoCristal LIKE '%"+ busqueda+"%' OR descrCristal LIKE '%"+ busqueda+"%' OR iuMarcaCris LIKE '%"+_administradorMarcasCristales.obtenerIuMarcaCris(busqueda)+"%'";     
        
        } else{
        
            _mySqlSentencia = "SELECT codigoCristal, descrCristal, codModeloVeh, iuMarcaCris, cantidadMinima, cantidadExistencia, precioPieza, estadoEliminacion FROM catalogocristales WHERE codigoCristal LIKE '%"+ busqueda+"%' OR descrCristal LIKE '%"+ busqueda+"%'";     
        
        }
      
          
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
                
                registros[0] = rsMySql.getString("codigoCristal");
                registros[1] = rsMySql.getString("descrCristal"); 
                // se carga la marca pa mas esterica
                String auxUno = _administradorModeloVehiculo.obtenercodMarcaVeh(rsMySql.getString("codModeloVeh"));
                String auxDos = _administradorMarcaVehiculo.obtenerDescrMarcaVeh(auxUno);
                registros[2] = auxDos;
                while(rsMySqlFK2.next()){
                    if(rsMySqlFK2.getInt("estadoEliminacion") == 1 ){ 
                        if(rsMySqlFK2.getString("codModeloVeh").equals(rsMySql.getString("codModeloVeh")) ){
                   
                         registros[3] = rsMySqlFK2.getString("descrModeloVeh") ;
                        
                        } 
                    }
                   
                }
              
                while(rsMySqlFK1.next()){
                   if(rsMySqlFK1.getInt("estadoEliminacion") == 1 ){ 
                   if(rsMySqlFK1.getString("iuMarcaCris").equals(rsMySql.getString("iuMarcaCris")) ){
                   
                         registros[4] = rsMySqlFK1.getString("descrMarcaCris") ;
                        
                   } 
                   }
                   
               }
                registros[5] = rsMySql.getString("cantidadMinima"); 
                registros[6] = rsMySql.getString("cantidadExistencia");
                String auxDecimal =rsMySql.getString("precioPieza");
//                if(Integer.parseInt(auxDecimal)%1 == 0){
//                
//                    registros[6] =  auxDecimal + ".00";
//                }else{
                
                    registros[7] = auxDecimal;
//                }
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
    public boolean insertarTablaCatalogoCristal(CatalogoCristales obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();  
        _mySqlSentencia = "SELECT estadoEliminacion FROM catalogoCristales WHERE codigoCristal = "+obj.getCodigoCristal()+" AND codModeloVeh = "+obj.getCodModeloVeh()+" AND iuMarcaCris = "+obj.getIuMarcaCris()+"";
    try {
// se prepara la insercion y se inyecta los datos
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            if(rsMySql.next() == true){
                if(rsMySql.getInt("estadoEliminacion")==0){
                    _mySqlSentencia = "UPDATE catalogoCristales SET   descrCristal = ?,  cantidadMinima = ?, cantidadExistencia = ?, precioPieza = ?, estadoEliminacion = ?  WHERE codigoCristal = ? AND codModeloVeh = ? AND iuMarcaCris = ?";    
                    PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
                    _mySqlPreparaSentencia.setString(1, obj.getDescrCristal()); 
                    _mySqlPreparaSentencia.setInt(2, obj.getCantidadMinima());
                    _mySqlPreparaSentencia.setInt(3, obj.getCantidadExistencia());
                    _mySqlPreparaSentencia.setDouble(4, obj.getPrecioPieza());
                    _mySqlPreparaSentencia.setInt(5, 1 ); 
                    _mySqlPreparaSentencia.setString(6, obj.getCodigoCristal());
                    _mySqlPreparaSentencia.setString(7, obj.getCodModeloVeh());
                    _mySqlPreparaSentencia.setInt(8, obj.getIuMarcaCris());
                    resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa                
                    if(resultadoInsercion != 0)verdad= true;
                } else{
                
                    verdad = false;
                }
            } else if(rsMySql.next()== false) {
                _mySqlSentencia = "INSERT INTO catalogocristales ( codigoCristal, descrCristal, codModeloVeh, iuMarcaCris, cantidadMinima, cantidadExistencia, precioPieza ) VALUES( ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia); 
                _mySqlPreparaSentencia.setString(1, obj.getCodigoCristal());
                _mySqlPreparaSentencia.setString(2, obj.getDescrCristal());
                _mySqlPreparaSentencia.setString(3, obj.getCodModeloVeh());
                _mySqlPreparaSentencia.setInt(4, obj.getIuMarcaCris());
                _mySqlPreparaSentencia.setInt(5, obj.getCantidadMinima());
                _mySqlPreparaSentencia.setInt(6, obj.getCantidadExistencia());
                _mySqlPreparaSentencia.setDouble(7, obj.getPrecioPieza());
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
    public boolean actualizarTablaCatalogoCristal(CatalogoCristales obj){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE catalogoCristales SET descrCristal = ?, cantidadMinima = ?, cantidadExistencia = ?, precioPieza = ? WHERE codigoCristal = ? AND codModeloVeh = ? AND iuMarcaCris = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getDescrCristal());
        _mySqlPreparaSentencia.setInt(2, obj.getCantidadMinima());
        _mySqlPreparaSentencia.setInt(3, obj.getCantidadExistencia());
        _mySqlPreparaSentencia.setDouble(4, obj.getPrecioPieza());
        _mySqlPreparaSentencia.setString(5, obj.getCodigoCristal());
        _mySqlPreparaSentencia.setString(6, obj.getCodModeloVeh());
        _mySqlPreparaSentencia.setInt(7, obj.getIuMarcaCris());
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
    public boolean eliminarTablaCatalogoCristal(CatalogoCristales obj){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE catalogoCristales SET  estadoEliminacion = ?  WHERE codigoCristal = ? AND codModeloVeh = ? AND iuMarcaCris = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setString(2, obj.getCodigoCristal() );
        _mySqlPreparaSentencia.setString(3, obj.getCodModeloVeh() );
        _mySqlPreparaSentencia.setInt(4, obj.getIuMarcaCris() );
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
    public String obtenerCodigoCristal(String busqueda){
        
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codigoCristal, codModeloVeh, iuMarcaCris, descrCristal FROM catalogoCristales WHERE  descrCristal = '"+ busqueda+"' ";

    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("codigoCristal");
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
    public String obtenerDescrCristal(String busqueda){
        
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codigoCristal, codModeloVeh, iuMarcaCris, descrCristal FROM catalogoCristales WHERE  codigoCristal = '"+ busqueda+"' ";

    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("descrCristal");
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
    public String obtenerDescrCristal(String cc, String cmv, String imc){
        
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codigoCristal, codModeloVeh, iuMarcaCris, descrCristal FROM catalogoCristales WHERE  codigoCristal = '"+ cc+"' AND codModeloVeh = '"+ cmv+"' AND iuMarcaCris = '"+ imc+"' ";

    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("descrCristal");
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
    public DefaultListModel cargarListaCodigoCristal(String busqueda){      
// se genera la coneccion y el query de consulta        
        ArrayList<String> registros = new ArrayList<>();
        _modeloJList.clear();
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codigoCristal, descrCristal, estadoEliminacion FROM catalogoCristales WHERE codigoCristal LIKE '%"+ busqueda+"%' OR descrCristal LIKE '%"+ busqueda+"%' ";
        _mySqlSentencia2 = "SELECT codigoCristal, descrCristal, estadoEliminacion FROM catalogoCristales ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("descrCristal")); 
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("descrCristal"));
                }    
            }
        } 

// quita los valores duplicados
            Set hs = new HashSet<>();
            hs.addAll(registros); 
            registros.clear();
            registros.addAll(hs);
            
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

//// este metodo busca lo ingresado y muetra el resultado    
//    public DefaultListModel cargarListaCodigoCristal(String cmv, String cc){      
//// se genera la coneccion y el query de consulta        
//        ArrayList<String> registros = new ArrayList<>();
//        _modeloJList.clear();
//        _conectarSql = getConection();
//        _mySqlSentencia = "SELECT codigoCristal, codModeloVeh, descrCristal, estadoEliminacion FROM catalogoCristales WHERE codigoCristal = '%"+ cc+"%' AND codModeloVeh = '%"+ cmv+"%'  ";
//        _mySqlSentencia2 = "SELECT codigoCristal, descrCristal, estadoEliminacion FROM catalogoCristales WHERE codModeloVeh = '%"+ cmv+"%' ";
//    try {
//// se obtiene los datos de la db y se carga el modelo  
//        if(cmv.length()!=0){
//            System.err.println("a");
//            Statement stMySql = (Statement) _conectarSql.createStatement(); 
//            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
//            while(rsMySql.next()){
//                if(rsMySql.getInt("estadoEliminacion") == 1 ){
//                  
//                    registros.add(rsMySql.getString("descrCristal")); 
//                }    
//            }
//        } else{
//            System.err.println("b");
//            Statement stMySql = (Statement) _conectarSql.createStatement(); 
//            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
//            while(rsMySql.next()){
//                
//                if(rsMySql.getInt("estadoEliminacion") == 1 ){
//                  
//                    registros.add(rsMySql.getString("descrCristal"));
//                    
//                }    
//            }
//        } 
//
//// quita los valores duplicados
//            Set hs = new HashSet<>();
//            hs.addAll(registros); 
//            registros.clear();
//            registros.addAll(hs);
//            
//            for (int i = 0; i < registros.size(); i++) {
//
//                _modeloJList.add(i,registros.get(i));
//            }
//            return _modeloJList;
//    } catch (SQLException e) {
//            
//        return null;
//    } finally{
//// se cierra la conexion con la db
//        _conectarSql = desconectarMySql();       
//    }
//    }
    
// aca obtner codigo de modelo y marca cristal
    public String obtenerCodModeloVeh(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT codigoCristal, descrCristal, codModeloVeh FROM catalogoCristales WHERE  descrCristal = '"+ busqueda+"' OR codigoCristal = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("codModeloVeh");
        }
            
            return aux;
    } catch (SQLException e) {
            
        return null;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();       
    }
    } 
    
// contador de registros
    public int cantRegCatalogoCristales(){
    
        int total = 0;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT estadoEliminacion FROM catalogoCristales ORDER BY " + _resultFiltrar + "";
// se obtiene los datos de la db y se carga el modelo   
        Statement stMySql;
        try {
            stMySql = (Statement) _conectarSql.createStatement();
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            
            while (rsMySql.next()){
                if(rsMySql.getString("estadoEliminacion").equals("1")){
                
                    total++;
                }
            }
            return total;
            
        } catch (SQLException e) {
        
            return 0;
        } finally{
// se cierra la conexion con la db
            _conectarSql = desconectarMySql();
        }
    }
    
// este metodo busca lo ingresado y muetra el resultado   
    public ArrayList cargarListaTotal(){

        ArrayList listaTotal = new ArrayList();
        String[] registros = new String[8];
        
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
  _mySqlSentencia = "SELECT catalogocristales.codigoCristal, catalogocristales.descrCristal, catalogocristales.codModeloVeh, catalogocristales.iuMarcaCris, catalogocristales.cantidadMinima, catalogocristales.cantidadExistencia, catalogocristales.precioPieza, catalogocristales.fechaInsercion, catalogocristales.estadoEliminacion, marcacristales.descrMarcaCris FROM catalogocristales INNER JOIN marcacristales ON catalogocristales.iuMarcaCris = marcacristales.iuMarcaCris ORDER BY " + _resultFiltrar + "";
        
    try {
// se obtiene los datos de la db y se carga el modelo         
        Statement stMySql = (Statement) _conectarSql.createStatement();
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("codigoCristal");
                registros[1] = rsMySql.getString("descrCristal");
              
// se carga la marca pa mas esterica
                String auxUno = _administradorModeloVehiculo.obtenercodMarcaVeh(rsMySql.getString("codModeloVeh"));
                String auxDos = _administradorMarcaVehiculo.obtenerDescrMarcaVeh(auxUno);
                registros[2] = auxDos;
                
                String _mySqlSentenciaFK1 = "SELECT codModeloVeh, descrModeloVeh FROM modelovehiculo WHERE codModeloVeh = "+rsMySql.getString("codModeloVeh")+" ";
                ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentenciaFK1);
                while(rsMySqlFK1.next()){
                    registros[3] = rsMySqlFK1.getString("descrModeloVeh") ;
                }
                 
                registros[4] = rsMySql.getString("descrMarcaCris") ; 
                registros[5] = rsMySql.getString("cantidadMinima") ; 
                registros[6] = rsMySql.getString("cantidadExistencia") ;
                String auxDecimal =rsMySql.getString("precioPieza");
                if(Integer.parseInt(auxDecimal)%1 == 0){
                
                    registros[7] =  auxDecimal + ".00";
                }else{
                
                    registros[7] = auxDecimal;
                }
                  
              listaTotal.add(registros[0] + " - "+registros[1] + " - "+registros[2] + " - "+registros[3] + " - "+registros[4] + " - "+registros[5] + " - "+registros[6] + " - "+registros[7] );
                 
            }
        }
        
        return listaTotal;     
    } catch (SQLException e) {
             
        return null;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();
    }
    }

// este metodo busca lo ingresado y muetra el resultado 
    public ArrayList buscarEnListaTotal(String busqueda){

        int index = 0;
        ArrayList listaTotal = new ArrayList();
        String [] registros = new String[8];

// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();  
        _mySqlSentencia = "SELECT codigoCristal, descrCristal, codModeloVeh, iuMarcaCris, cantidadMinima, cantidadExistencia, precioPieza, estadoEliminacion FROM catalogocristales WHERE codigoCristal LIKE '%"+ busqueda+"%' OR descrCristal LIKE '%"+ busqueda+"%' OR codModeloVeh LIKE '%"+ _administradorModeloVehiculo.obtenerCodModeloVeh(busqueda)+"%'";     
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
                
                registros[0] = rsMySql.getString("codigoCristal");
                registros[1] = rsMySql.getString("descrCristal"); 
                
// se carga la marca pa mas esterica
                String auxUno = _administradorModeloVehiculo.obtenercodMarcaVeh(rsMySql.getString("codModeloVeh"));
                String auxDos = _administradorMarcaVehiculo.obtenerDescrMarcaVeh(auxUno);
                registros[2] = auxDos;
                
                while(rsMySqlFK2.next()){
                    if(rsMySqlFK2.getInt("estadoEliminacion") == 1 ){ 
                        if(rsMySqlFK2.getString("codModeloVeh").equals(rsMySql.getString("codModeloVeh")) ){
                   
                         registros[3] = rsMySqlFK2.getString("descrModeloVeh") ;
                        
                        } 
                    }
                   
                }
              
                while(rsMySqlFK1.next()){
                   if(rsMySqlFK1.getInt("estadoEliminacion") == 1 ){ 
                   if(rsMySqlFK1.getString("iuMarcaCris").equals(rsMySql.getString("iuMarcaCris")) ){
                   
                         registros[4] = rsMySqlFK1.getString("descrMarcaCris") ;
                        
                   } 
                   }
                   
               }
                registros[5] = rsMySql.getString("cantidadMinima"); 
                registros[6] = rsMySql.getString("cantidadExistencia");
                String auxDecimal =rsMySql.getString("precioPieza");
                    registros[7] = auxDecimal;

                
               listaTotal.add(registros[0] + " - "+registros[1] + " - "+registros[2] + " - "+registros[3] + " - "+registros[4] + " - "+registros[5] + " - "+registros[6] + " - "+registros[7] );
                  
            }
        }
        cantBusqTotal = listaTotal.size();
        return listaTotal;    
    } catch (SQLException e) {
         
        return null;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();        
    }    
    }

    public int getCantBusqTotal() {
        return cantBusqTotal;
    }

    public void setCantBusqTotal(int cantBusqTotal) {
        this.cantBusqTotal = cantBusqTotal;
    }
    
    
    
}
