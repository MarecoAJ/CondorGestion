
package administradorClases;

import clasesDatos.Presupuestos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static controladorBD.ConectorMySql.desconectarMySql;
import static controladorBD.ConectorMySql.getConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class AdministradorPresupuesto {
       
    private Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private final DefaultListModel _modeloJList;
    private String _mySqlSentencia;
    private String _mySqlSentencia2;
    private String _resultFiltrar= "iuPresupuesto DESC";
    private final AdministradorModeloVehiculo _administradorModeloVehiculo;
    private final AdministradorCatalogoCristales _administradorCatalogoCristales;
    private final AdministradorMarcasCristales _administradorMarcasCristales; 
    private final AdministradorServiciosPrestados  _administradorServiciosPrestados;
    
    public AdministradorPresupuesto() {
    
        _modeloJList = new DefaultListModel();
        _administradorModeloVehiculo = new AdministradorModeloVehiculo();
        _administradorCatalogoCristales = new AdministradorCatalogoCristales();
        _administradorMarcasCristales = new AdministradorMarcasCristales();
        _administradorServiciosPrestados = new AdministradorServiciosPrestados();
    }
    
    public String ordenarTabla(String valor){

    switch(valor){
    
        case "Primeros agregados" : 
           _resultFiltrar = " fechaInsercion ASC";
           break;
        case "Seleccionar":
           _resultFiltrar = " iuPpresupuesto DESC";
           break; 
        case "Ultimos argegados":
           _resultFiltrar = " fechaInsercion DESC";
           break;
           
   }
    
    return _resultFiltrar;
    
    }

// este metodo carga los jTable en caso de ser vacio devuelve null    
    public DefaultTableModel cargarJTabla(){
        String [] titulosTabla = {"N° de reg.", "Fecha", "Tipo", "Dirigido a", "Modelo", "Patente", "Cristal", "Marca", "Servicio", "Descripcion", "Total"};
        String [] registros = new String[11];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta 
        _conectarSql = getConection();        
        _mySqlSentencia = "SELECT presupuesto.iuPresupuesto, presupuesto.fechaPresup, presupuesto.tipoPresup, presupuesto.dirigidoA, presupuesto.codModeloVeh, presupuesto.patenteVeh, presupuesto.codigoCristal, presupuesto.iuMarcaCris,presupuesto.iuServicios, presupuesto.descrPresup, presupuesto.totalPresup, presupuesto.fechaInsercion, presupuesto.estadoEliminacion, serviciosprestados.descrServicios FROM presupuesto INNER JOIN serviciosprestados ON presupuesto.iuServicios = serviciosprestados.iuServicios ORDER BY " + _resultFiltrar + "";

    try {
// se obtiene los datos de la db y se carga el modelo
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
      
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuPresupuesto");
                registros[1] = rsMySql.getString("fechaPresup"); 
                registros[2] = rsMySql.getString("tipoPresup") ;
                registros[3] = rsMySql.getString("dirigidoA") ;
                registros[4] = _administradorModeloVehiculo.obtenerDescrModeloVeh(rsMySql.getString("codModeloVeh"));
                registros[5] = rsMySql.getString("patenteVeh");    
                registros[6] = _administradorCatalogoCristales.obtenerDescrCristal(rsMySql.getString("codigoCristal"),rsMySql.getString("codModeloVeh"),rsMySql.getString("iuMarcaCris"));               
                registros[7] = _administradorMarcasCristales.obtenerDescrMarcaCris(rsMySql.getString("iuMarcaCris"));
                registros[8] = rsMySql.getString("descrServicios");
                registros[9] = rsMySql.getString("descrPresup");
                registros[10] = rsMySql.getString("totalPresup");
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
        String [] titulosTabla = {"N° de reg.", "Fecha", "Tipo", "Dirigido a", "Modelo", "Patente", "Cristal", "Marca", "Servicio", "Descripcion", "Total"};
        String [] registros = new String[11];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection(); 
        _mySqlSentencia = "SELECT iuPresupuesto, fechaPresup, tipoPresup, dirigidoA, codModeloVeh,patenteVeh, codigoCristal, iuMarcaCris, iuServicios, descrPresup, totalPresup, fechaInsercion, estadoEliminacion FROM presupuesto WHERE iuPresupuesto LIKE '%"+ busqueda+"%' OR dirigidoA LIKE '%"+ busqueda+"%' OR patenteVeh LIKE '%"+ busqueda+"%' ";     
  
    try {
// se obtiene los datos de la db y se carga el modelo     
        Statement stMySql = (Statement) _conectarSql.createStatement();   
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
               
                registros[0] = rsMySql.getString("iuPresupuesto");
                registros[1] = rsMySql.getString("fechaPresup"); 
                registros[2] = rsMySql.getString("tipoPresup") ;
                registros[3] = rsMySql.getString("dirigidoA") ;
                registros[4] = _administradorModeloVehiculo.obtenerDescrModeloVeh(rsMySql.getString("codModeloVeh"));
                registros[5] = rsMySql.getString("patenteVeh");    
                registros[6] = _administradorCatalogoCristales.obtenerDescrCristal(rsMySql.getString("codigoCristal"),rsMySql.getString("codModeloVeh"),rsMySql.getString("iuMarcaCris"));               
                registros[7] = _administradorMarcasCristales.obtenerDescrMarcaCris(rsMySql.getString("iuMarcaCris"));
                registros[8] = _administradorServiciosPrestados.obtenerDescrServicio(rsMySql.getString("iuServicios"));
                registros[9] = rsMySql.getString("descrPresup");
                registros[10] = rsMySql.getString("totalPresup");
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
    public boolean insertarTablaPresupuesto( Presupuestos obj){
        boolean verdad = false;
        int resultadoInsercion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "INSERT INTO presupuesto ( fechaPresup, tipoPresup, dirigidoA, codModeloVeh, patenteVeh, codigoCristal, iuMarcaCris, iuServicios, descrPresup, totalPresup ) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
// se prepara la insercion y se inyecta los datos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setString(1, obj.getFechaPresu());
        _mySqlPreparaSentencia.setString(2, obj.getTipoPresu());
        _mySqlPreparaSentencia.setString(3, obj.getDirigidoA());
        _mySqlPreparaSentencia.setString(4,obj.getCodModeloVeh());
        _mySqlPreparaSentencia.setString(5, obj.getPatenteVeh());
        _mySqlPreparaSentencia.setString(6, obj.getCodigoCristal());
        _mySqlPreparaSentencia.setInt(7, obj.getIuMarcaCris());
        _mySqlPreparaSentencia.setInt(8,obj.getIuServicios());
        _mySqlPreparaSentencia.setString(9, obj.getDescrPresup());
        _mySqlPreparaSentencia.setDouble(10, obj.getTotalPresu());
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
    public boolean actualizarTablaPresupuestos( Presupuestos obj ){
        boolean verdad = false;
        int resultadoActualizacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE presupuesto SET codModeloVeh = ?, patenteVeh = ?, codigoCristal = ?, iuMarcaCris = ?, iuServicios = ?, descrPresup = ?, totalPresup = ? WHERE iuPresupuesto = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
         _mySqlPreparaSentencia.setString(1, obj.getCodModeloVeh());
        _mySqlPreparaSentencia.setString(2, obj.getPatenteVeh());
        _mySqlPreparaSentencia.setString(3, obj.getCodigoCristal());
        _mySqlPreparaSentencia.setInt(4,obj.getIuMarcaCris());
        _mySqlPreparaSentencia.setInt(5, obj.getIuServicios());
        _mySqlPreparaSentencia.setString(6, obj.getDescrPresup());
        _mySqlPreparaSentencia.setDouble(7, obj.getTotalPresu());
        _mySqlPreparaSentencia.setDouble(8, obj.getIuPresupuesto());
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
    public boolean eliminarTablaPresupuestos(Presupuestos obj){
        boolean verdad = false;
        int resultadosEliminacion;
// se genera la coneccion y el query de consulta        
        _conectarSql = getConection();
        _mySqlSentencia = "UPDATE presupuesto SET  estadoEliminacion = ?  WHERE iuPresupuesto = ?";
    try {
// se prepara la actualizacion y se inyecta los datos nuevos   
        PreparedStatement _mySqlPreparaSentencia = _conectarSql.prepareStatement(_mySqlSentencia);
        _mySqlPreparaSentencia.setInt(1, 0);
        _mySqlPreparaSentencia.setInt(2, obj.getIuPresupuesto() );
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
        _mySqlSentencia = "SELECT iuPolizaSiniestro, numPoliza, numSiniestro FROM polizasiniestro WHERE numPoliza = '"+part1+"' AND numSiniestro = '"+part2+"'  ";
    try {
// se obtiene los datos de la db y se carga el modelo  
        Statement stMySql = (Statement) _conectarSql.createStatement(); 
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        while(rsMySql.next()){

                aux = rsMySql.getString("iuPolizaSiniestro");
        }
            
            return aux;
    } catch (SQLException e) {
            
        return null;
    } finally{
// se cierra la conexion con la db
        _conectarSql = desconectarMySql();       
    }
    }

    public String obtenerUltimoId(){
    
        String aux;
        
        try {
            _conectarSql = getConection(); 
            _mySqlSentencia = "SELECT MAX(iuPresupuesto) FROM presupuesto";
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
    
}
