
package administradorClases;

import clasesDatos.Turnos;
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


public class AdministradorTurnos {
       
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia;
    private String _mySqlSentencia2;
    private String _resultFiltrar= " fechaInsercion DESC";
    private final AdministradorVehiculos _administradorVehiculos;
    
    
public AdministradorTurnos() {
    
    _modeloJList = new DefaultListModel<>();
    _administradorVehiculos = new AdministradorVehiculos();
 }
    
// se pasa un valor de orden y acomoda los datos por ese tipo    
    public String ordenarTabla(String valor){
 
    switch(valor){
    
        case "Primeros agregados" : 
            _resultFiltrar = " fechaInsercion ASC";
        break;
        
        case "Seleccionar":
            _resultFiltrar = "dominioVeh ASC";
        break; 
        
        case "Ultimos agregados":
            _resultFiltrar = " fechaInsercion DESC";
        break;
        
        case "Alfabeticos":
            _resultFiltrar = " dominioVeh ASC";
        break;                
    }
    
    return _resultFiltrar;
    }
    
// este metodo carga los jTable en caso de ser vacio devuelve null 
    public DefaultTableModel cargarJTabla(){
// se crea el modelo de jtable   
        String [] titulosTabla = {"Fecha del turno","Dominio", "Hora del turno"};
        String [] registros = new String[3];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT fechaTurno, dominioVeh, horaTurno, estadoEliminacion FROM turnos ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo   
        Statement stMySql = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("fechaTurno");
                registros[1] = rsMySql.getString("dominioVeh"); 
                registros[2] = rsMySql.getString("horaTurno") ;  
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
        String [] titulosTabla = {"Fecha del turno","Dominio", "Hora del turno"};
        String [] registros = new String[3];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT fechaTurno, dominioVeh, horaTurno, estadoEliminacion FROM turnos WHERE fechaTurno LIKE '%"+ busqueda+"%' OR dominioVeh LIKE '%"+ busqueda+"%'  OR horaTurno LIKE '%"+ busqueda+"%'";
    try {
// se obtiene los datos de la db y se carga el modelo 
        Statement stMySql = (Statement) _conectarSql.createStatement();  
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("fechaTurno");
                registros[1] = rsMySql.getString("dominioVeh");
                registros[2] = rsMySql.getString("horaTurno");
                
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
    public boolean insertarTablaTurnos(Turnos obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();  
        _mySqlSentencia = "SELECT estadoEliminacion FROM turnos WHERE fechaTurno = '"+obj.getFechaTurno()+"' AND dominioVeh = '"+obj.getDominioVeh()+"' ";
    try {
// se prepara la insercion y se inyecta los datos
  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
      
            if(rsMySql.next() == true){
                
                if(rsMySql.getInt("estadoEliminacion")==0){
                    
                    _mySqlSentencia = "UPDATE turnos SET horaTurno = ?, estadoEliminacion = ?  WHERE fechaTurno = ? AND dominioVeh = ?";    
                    PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
                    _mySqlPreparaSentencia.setString(1, obj.getHoraTurno()); 
                    _mySqlPreparaSentencia.setInt(2, 1);
                    _mySqlPreparaSentencia.setString(3, obj.getFechaTurno());
                    _mySqlPreparaSentencia.setString(4, obj.getDominioVeh());
                    resultadoInsercion = _mySqlPreparaSentencia.executeUpdate();
// se verifica la insercion exitosa                
                    if(resultadoInsercion != 0)verdad= true;
                } else{
                
                    verdad = false;
                }
            } else if(rsMySql.next()== false) {
                
                _mySqlSentencia = "INSERT INTO turnos ( fechaTurno, dominioVeh, horaTurno) VALUES ( ?, ?, ?)";
                PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia); 
                _mySqlPreparaSentencia.setString(1, obj.getFechaTurno());
                _mySqlPreparaSentencia.setString(2, obj.getDominioVeh());
                _mySqlPreparaSentencia.setString(3, obj.getHoraTurno());
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
    public boolean actualizarTablaTurnos(Turnos obj){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE turnos SET  fechaTurno = ?, dominioVeh = ?, horaTurno = ? WHERE fechaTurno = ? AND dominioVeh = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getFechaTurno());
        _mySqlPreparaSentencia.setString(2, obj.getDominioVeh());
        _mySqlPreparaSentencia.setString(3, obj.getHoraTurno());
        _mySqlPreparaSentencia.setString(4, obj.getFechaTurno());
        _mySqlPreparaSentencia.setString(5, obj.getDominioVeh());
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
    public boolean eliminarTablaTurnos(Turnos obj){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE Turnos SET  estadoEliminacion = ?  WHERE fechaTurno = ? AND dominioVeh = ?";
        
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setString(2,obj.getFechaTurno());
        _mySqlPreparaSentencia.setString(3, obj.getDominioVeh() );
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

// este metodo carga los jTable en caso de ser vacio devuelve null 
    public DefaultListModel cargarListaTotal(){

        int index = 0;
//Crear un objeto DefaultListModel
        DefaultListModel listModel = new DefaultListModel();     
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT fechaTurno, dominioVeh, horaTurno, estadoEliminacion FROM turnos ORDER BY " + _resultFiltrar + "";
       
    try {
// se obtiene los datos de la db y se carga el modelo   
        Statement stMySql = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
              
                
                
                listModel.add(index, rsMySql.getString("fechaTurno") + " -- " + _administradorVehiculos.obtenerModeloVeh(rsMySql.getString("dominioVeh")) + " -- " + rsMySql.getString("dominioVeh") + " -- " + rsMySql.getString("horaTurno"));  
                index++;
            }
        }
        
        return listModel;      
    } catch (SQLException e) {
        
        return null;   
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();
    }
    }
   
// este metodo busca lo ingresado y muetra el resultado   
    public ArrayList cargarListaHoy(String busqueda){

        
        int index = 0;
        ArrayList _listaAux = new ArrayList();
        
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT fechaTurno, dominioVeh, horaTurno, estadoEliminacion FROM turnos WHERE fechaTurno LIKE '%"+ busqueda+"%' ";
    try {
// se obtiene los datos de la db y se carga el modelo   
        Statement stMySql = (Statement) _conectarSql.createStatement();
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
              
                _listaAux.add( rsMySql.getString("fechaTurno") + " -- " + _administradorVehiculos.obtenerModeloVeh(rsMySql.getString("dominioVeh")) + " -- " + rsMySql.getString("dominioVeh") + " -- " + rsMySql.getString("horaTurno") );
                index++; 
            }
            
        }
        
        return _listaAux;
    } catch (SQLException e) {
    
        _listaAux.add("No se pudo obtener los turnos. Revise la base de datos");
        return _listaAux;
    } finally{
        
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();
    }
    }  
    
}
