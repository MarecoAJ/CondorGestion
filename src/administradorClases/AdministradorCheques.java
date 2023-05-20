/*
* esta clase hereda de ConectorMySql y contiene ABM + buscar y cargar tabla del frame
*/
package administradorClases;

import clasesDatos.Cheques;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import controladorBD.ConectorMySql;
import static controladorBD.ConectorMySql.desconectarMySql;
import static controladorBD.ConectorMySql.getConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class AdministradorCheques extends ConectorMySql{
       
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;  
    private String _resultFiltrar= "fechaInsercion DESC";
    private final DefaultListModel _modeloJList;
    private final AdministradorCartera _administradorCartera;
    
    public AdministradorCheques() {
        _modeloJList = new DefaultListModel<>();
        _administradorCartera = new AdministradorCartera();
    }
    
// se pasa el valor de orden y acomoda los datos por ese tipo        
    public String ordenarTabla(String valor){
 
        switch(valor){
    
            case "Primeros agregados" : 
                _resultFiltrar = " fechaInsercion ASC";
            break;
            
            case "Seleccionar":
                _resultFiltrar = "numCheque ASC";
            break; 
            
            case "Ultimos agregados":
                _resultFiltrar = " fechaInsercion DESC";
            break;
        }
    
        return _resultFiltrar;
    }

// este metodo carga los jTable en caso de ser vacio devuelve null    
    public DefaultTableModel cargarJTabla(){
        String [] titulosTabla = {"Nº cheque", "Tipo", "Fecha cheque", "Fecha cobro", "Banco", "Sucursal", "Caja", "Detalle", "Cartera", "Monto"};
        String [] registros = new String[10];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();        
        _mySqlSentencia = "SELECT cheques.numCheque, cheques.iuCaja, cheques.iuDetalleCaja, cheques.fechaCheque, cheques.fechaCobro, cheques.bancoEmisor, cheques.sucursalBanco, cheques.montoCheque, cheques.tipoCheque, cheques.fechaInsercion, cheques.estadoEliminacion, cheques.iuCartera, cartera.nombCompleto  FROM cheques INNER JOIN cartera ON cheques.iuCartera = cartera.iuCartera ORDER BY " + _resultFiltrar + "";

    try {
// se obtiene los datos de la db y se carga el modelo
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
      
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("numCheque");
                registros[1] = rsMySql.getString("tipoCheque"); 
                registros[2] = rsMySql.getString("fechaCheque") ; 
                registros[3] = rsMySql.getString("fechaCobro") ; 
                registros[4] = rsMySql.getString("bancoEmisor") ; 
                registros[5] = rsMySql.getString("sucursalBanco") ; 
                registros[6] = rsMySql.getString("iuCaja") ; 
                registros[7] = rsMySql.getString("iuDetalleCaja") ; 
                registros[8] = rsMySql.getString("nombCompleto") ; 
                registros[9] = rsMySql.getString("montoCheque") ; 
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
        String [] titulosTabla = {"Nº cheque", "Tipo", "Fecha cheque", "Fecha cobro", "Banco", "Sucursal", "Caja", "Detalle", "Cartera", "Monto"};
        String [] registros = new String[10];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
// la doblesentencia corresponde a que el usuario piede buscar por marca 
        _mySqlSentencia = "SELECT  numCheque, iuCaja, iuDetalleCaja, fechaCheque, fechaCobro,  bancoEmisor, sucursalBanco, montoCheque, tipoCheque, iuCartera, fechaInsercion, estadoEliminacion FROM cheques WHERE numCheque LIKE '%"+ busqueda+"%' OR bancoEmisor LIKE '%"+ busqueda+"%' OR tipoCheque LIKE '%"+ busqueda+"%'";     
     
    try {
// se obtiene los datos de la db y se carga el modelo     
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);

       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("numCheque");
                registros[1] = rsMySql.getString("tipoCheque"); 
                registros[2] = rsMySql.getString("fechaCheque") ; 
                registros[3] = rsMySql.getString("fechaCobro") ; 
                registros[4] = rsMySql.getString("bancoEmisor") ; 
                registros[5] = rsMySql.getString("sucursalBanco") ; 
                registros[6] = rsMySql.getString("iuCaja") ; 
                registros[7] = rsMySql.getString("iuDetalleCaja") ; 
                registros[8] = rsMySql.getString(_administradorCartera.obtenerNombCompleto(rsMySql.getInt("iuCartera"))) ; 
                registros[9] = rsMySql.getString("montoCheque") ; 
                
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
    public boolean insertarTablaCheques(Cheques obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();  
        _mySqlSentencia = "SELECT estadoEliminacion FROM cheques WHERE numCheque = "+obj.getNumCheque()+"";
    try {
// se prepara la insercion y se inyecta los datos
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            if(rsMySql.next() == true){
                if(rsMySql.getInt("estadoEliminacion")==0){
                    _mySqlSentencia = "UPDATE cheques SET iuCaja = ?, iuDetalleCaja = ?, fechaCheque = ?, fechaCobro = ?,  bancoEmisor = ?, sucursalBanco = ?, montoCheque = ?, tipoCheque = ?, iuCartera = ?, estadoEliminacion = ?  WHERE numCheque = ?";    
                    PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
                    _mySqlPreparaSentencia.setInt(1, obj.getIuCaja());
                    _mySqlPreparaSentencia.setInt(2, obj.getIuDetalleCaja());
                    _mySqlPreparaSentencia.setString(3, obj.getFechaCheque());
                    _mySqlPreparaSentencia.setString(4,obj.getFechaCobro());
                    _mySqlPreparaSentencia.setString(5, obj.getBancoEmisor());
                    _mySqlPreparaSentencia.setString(6,obj.getSucursalBanco());
                    _mySqlPreparaSentencia.setString(9, obj.getTipoCheque());
                    _mySqlPreparaSentencia.setDouble(8,obj.getMontoCheque());
                    _mySqlPreparaSentencia.setInt(10, obj.getIuCartera());
                    _mySqlPreparaSentencia.setInt(11, 1);
                    _mySqlPreparaSentencia.setInt(12,obj.getNumCheque());
                    resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa                
                    if(resultadoInsercion != 0)verdad= true;
                } else{
                
                    verdad = false;
                }
            } else if(rsMySql.next()== false) {
                _mySqlSentencia = "INSERT INTO  cheques ( numCheque, iuCaja, iuDetalleCaja, fechaCheque, fechaCobro,  bancoEmisor, sucursalBanco, montoCheque, tipoCheque, iuCartera ) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia); 
                _mySqlPreparaSentencia.setInt(1,obj.getNumCheque());
                _mySqlPreparaSentencia.setInt(2, obj.getIuCaja());
                _mySqlPreparaSentencia.setInt(3, obj.getIuDetalleCaja());
                _mySqlPreparaSentencia.setString(4, obj.getFechaCheque());
                _mySqlPreparaSentencia.setString(5,obj.getFechaCobro());
                _mySqlPreparaSentencia.setString(6, obj.getBancoEmisor());
                _mySqlPreparaSentencia.setString(7,obj.getSucursalBanco());
                _mySqlPreparaSentencia.setString(9, obj.getTipoCheque());
                _mySqlPreparaSentencia.setDouble(8,obj.getMontoCheque());
                _mySqlPreparaSentencia.setInt(10, obj.getIuCartera());
                
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
    public boolean actualizarTablaCheques(Cheques obj ){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE cheques SET numCheque = ?, iuCaja = ?, iuDetalleCaja = ?, fechaCheque = ?, fechaCobro = ?,  bancoEmisor = ?, sucursalBanco = ?, montoCheque = ?, tipoCheque = ?, iuCartera = ?  WHERE numCheque = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, obj.getNumCheque());
        _mySqlPreparaSentencia.setInt(2, obj.getIuCaja());
        _mySqlPreparaSentencia.setInt(3, obj.getIuDetalleCaja());
        _mySqlPreparaSentencia.setString(4, obj.getFechaCheque());
        _mySqlPreparaSentencia.setString(5,obj.getFechaCobro());
        _mySqlPreparaSentencia.setString(6, obj.getBancoEmisor());
        _mySqlPreparaSentencia.setString(7,obj.getSucursalBanco()); 
        _mySqlPreparaSentencia.setDouble(8,obj.getMontoCheque());
        _mySqlPreparaSentencia.setString(9, obj.getTipoCheque());
        _mySqlPreparaSentencia.setInt(10, obj.getIuCartera());
        _mySqlPreparaSentencia.setInt(11,obj.getNumCheque());
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
    public boolean eliminarTablaCheques(Cheques obj ){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE cheques SET  estadoEliminacion = ?  WHERE numCheque = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getNumCheque() );
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

}
