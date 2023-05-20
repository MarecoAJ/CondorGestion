
package administradorClases;




import clasesDatos.PolizaSiniestro;
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


public class AdministradorPolizaSiniestro {
       
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia;
    private String _mySqlSentencia2;
    private String _resultFiltrar= "iuPolizaSiniestro DESC";
    private AdministradorSeguros _administradorSeguros;
    
    public AdministradorPolizaSiniestro() {
    
        _modeloJList = new DefaultListModel();
    }

    public String ordenarTabla(String valor){
 
    switch(valor){
    
        case "Primeros agregados" : 
           _resultFiltrar = " fechaInsercion ASC";
           break;
        case "Seleccionar":
           _resultFiltrar = " iuPolizaSiniestro DESC";
           break; 
        case "Ultimos argegados":
           _resultFiltrar = " fechaInsercion DESC";
           break;
           
   }
    
    return _resultFiltrar;
    
    }

// este metodo carga los jTable en caso de ser vacio devuelve null    
    public DefaultTableModel cargarJTabla(){
        String [] titulosTabla = {"N° de reg.", "Seguro", "Poliza", "Siniestro", "Patente", "Asegurado"};
        String [] registros = new String[6];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();        
        _mySqlSentencia = "SELECT polizasiniestro.iuPolizaSiniestro, polizasiniestro.iuSeguros, polizasiniestro.numPoliza, polizasiniestro.numSiniestro, polizasiniestro.dominioVeh, polizasiniestro.nombreAsegurado, polizasiniestro.fechaInsercion, polizasiniestro.estadoEliminacion, seguros.descrSeguros FROM polizasiniestro INNER JOIN seguros ON polizasiniestro.iuSeguros = seguros.iuSeguros ORDER BY " + _resultFiltrar + "";

    try {
// se obtiene los datos de la db y se carga el modelo
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
      
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuPolizaSiniestro");
                registros[1] = rsMySql.getString("descrSeguros"); 
                registros[2] = rsMySql.getString("numPoliza") ;
                registros[3] = rsMySql.getString("numSiniestro") ;
                registros[4] = rsMySql.getString("dominioVeh");
                registros[5] = rsMySql.getString("nombreAsegurado");
   
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
        String [] titulosTabla = {"N° de reg.", "Seguro", "Poliza", "Siniestro", "Patente", "Asegurado"};
        String [] registros = new String[6];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
// la doblesentencia corresponde a que el usuario piede buscar por marca 

        _mySqlSentencia = "SELECT iuPolizaSiniestro, iuSeguros, numPoliza, numSiniestro, dominioVeh, nombreAsegurado, estadoEliminacion FROM polizasiniestro WHERE iuPolizaSiniestro LIKE '%"+ busqueda+"%' OR numPoliza LIKE '%"+ busqueda+"%' OR numSiniestro LIKE '%"+ busqueda+"%' OR dominioVeh LIKE '%"+ busqueda+"%' OR nombreAsegurado LIKE '%"+ busqueda +"%'"; 
        String _mySqlSentenciaFK1 = "SELECT iuSeguros, descrSeguros, estadoEliminacion FROM seguros";   
        
    try {
// se obtiene los datos de la db y se carga el modelo     
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        Statement stMySqlFK1 = (Statement) _conectarSql.createStatement();  
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        ResultSet rsMySqlFK1 = stMySqlFK1.executeQuery(_mySqlSentenciaFK1);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuPolizaSiniestro");
              
                while(rsMySqlFK1.next()){
                    if(rsMySqlFK1.getInt("estadoEliminacion") == 1 ){ 
                    if(rsMySqlFK1.getString("iuSeguros").equals(rsMySql.getString("iuSeguros")) ){
                   
                        registros[1] = rsMySqlFK1.getString("descrSeguros") ;
                    } 
                    }
                }
                registros[2] = rsMySql.getString("numPoliza") ;
                registros[3] = rsMySql.getString("numSiniestro") ;
                registros[4] = rsMySql.getString("dominioVeh") ;
                registros[5] = rsMySql.getString("nombreAsegurado") ;

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
    public boolean insertarTablaPolizaSiniestro( PolizaSiniestro obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "INSERT INTO polizasiniestro ( iuSeguros, numPoliza, numSiniestro, dominioVeh, nombreAsegurado ) VALUES( ?, ?, ?, ?, ?)";
    try {
// se prepara la insercion y se inyecta los datos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, obj.getIuSeguros());
        _mySqlPreparaSentencia.setString(2, obj.getNumPoliza());
        _mySqlPreparaSentencia.setString(3, obj.getNumSiniestro());
        _mySqlPreparaSentencia.setString(4,obj.getDominioVeh());
        _mySqlPreparaSentencia.setString(5, obj.getNombAsegurado());
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
    public boolean actualizarTablaPolizaSiniestro( PolizaSiniestro obj ){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE PolizaSiniestro SET  iuSeguros = ?, numPoliza = ?, numSiniestro = ?, dominioVeh = ?, nombreAsegurado = ? WHERE iuPolizaSiniestro = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
         _mySqlPreparaSentencia.setInt(1, obj.getIuSeguros());
        _mySqlPreparaSentencia.setString(2, obj.getNumPoliza());
        _mySqlPreparaSentencia.setString(3, obj.getNumSiniestro());
        _mySqlPreparaSentencia.setString(4,obj.getDominioVeh());
        _mySqlPreparaSentencia.setString(5, obj.getNombAsegurado());
        _mySqlPreparaSentencia.setInt(6, obj.getIuPolizaSiniestro());
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
    public boolean eliminarTablaPolizaSiniestro( PolizaSiniestro obj ){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE polizasiniestro SET  estadoEliminacion = ?  WHERE iuPolizaSiniestro = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getIuPolizaSiniestro() );
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
    public String obtenerIuPolizaSiniestro(String busqueda){
        
        String aux = "";
        String string = busqueda;
        String part1 = "";
        String part2 = "";
        if(busqueda.length()!=0){
        
            String[] parts = string.split("-");
            part1 = parts[0]; 
            part2 = parts[1];
        }
        
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuPolizaSiniestro, numPoliza, numSiniestro FROM polizasiniestro WHERE numPoliza LIKE '%"+ part1+"%' AND numSiniestro LIKE '%"+ part2+"%'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("iuPolizaSiniestro");
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
    public String obtenerPolizaSiniestro(String busqueda){
        String aux = "";
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "SELECT iuPolizaSiniestro, numPoliza, numSiniestro FROM polizasiniestro WHERE iuPolizaSiniestro = '"+busqueda+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("numPolizaSiniestro")+ "-" +rsMySql.getString("numSiniestro");
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
        _mySqlSentencia = "SELECT iuPolizaSiniestro, numPoliza, numSiniestro, estadoEliminacion FROM polizasiniestro WHERE iuPolizaSiniestro LIKE '%"+busqueda+"%' OR numPoliza LIKE '%"+busqueda+"%' OR numSiniestro LIKE '%"+busqueda+"%' ";
        _mySqlSentencia2 = "SELECT iuPolizaSiniestro, numPoliza, numSiniestro, estadoEliminacion FROM polizasiniestro ORDER BY " + _resultFiltrar + "";
    try {
// se obtiene los datos de la db y se carga el modelo  
        if(busqueda.length()!=0){
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("numPoliza")+ "-" + rsMySql.getString("numSiniestro") ); 
                }    
            }
        } else{
            Statement stMySql = (Statement) _conectarSql.createStatement(); 
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia2);
            while(rsMySql.next()){
                if(rsMySql.getInt("estadoEliminacion") == 1 ){
                  
                    registros.add(rsMySql.getString("numPoliza")+ "-" + rsMySql.getString("numSiniestro") );
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
