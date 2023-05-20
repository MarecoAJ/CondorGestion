
package administradorClases;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import controladorBD.ConectorMySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdministradorPanelMovimientos {

    private final ConectorMySql _conectorMySql;
    private final Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;
    private String _resultFiltrar= " codigoCristal DESC";
    
    public AdministradorPanelMovimientos() {
        _conectorMySql = new ConectorMySql();
        _conectarSql = _conectorMySql.getConection();
    }
    
       
    public DefaultTableModel cargarJTabla(){
        String iuPresupuesto =  " ";
        String codModeloVeh =  " ";
        String numPoliza=" ";
        String numSiniestro = " ";
        
        String [] titulosTabla = {"Reg. movimiento", "Poliza", "Siniestro", "Dominio", "Cristal", "Modelo", "Seguro", "Fecha cobro", "Reg. venta"};
        String [] registros = new String[9];
        
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
        _mySqlSentencia = "SELECT movimientoseguros.iuMovimientoSeguros, movimientoseguros.iuVentas, movimientoseguros.numPoliza, movimientoseguros.numSiniestro, movimientoseguros.fechaAproxCobro, movimientoseguros.fechaInsercion, movimientoseguros.estadoEliminacion, ventaslocal.iuVentas, ventaslocal.iuPresupuesto  FROM movimientoseguros INNER JOIN ventaslocal ON movimientoseguros.iuVentas = ventaslocal.iuVentas   ORDER BY " + _resultFiltrar + "";
          
        try {
            
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuMovimientoSeguros");
                numPoliza = rsMySql.getString("numPoliza");
                registros[1] = numPoliza;
                numSiniestro = rsMySql.getString("numSiniestro");
                registros[2] = numSiniestro;
            //muestra presupuesto
              iuPresupuesto = rsMySql.getString("iuPresupuesto") ;
              String _mySqlSentencia2 = "SELECT presupuestos.iuPresupuesto, presupuestos.dominioVeh, presupuestos.codigoCristal, presupuestos.estadoEliminacion, vehiculos.dominioVeh, vehiculos.codModeloVeh FROM presupuestos INNER JOIN vehiculos ON presupuestos.dominioVeh = vehiculos.dominioVeh WHERE iuPresupuesto LIKE '%"+ iuPresupuesto +"%' ";
              Statement stMySql2 = (Statement) _conectarSql.createStatement(); 
              ResultSet rsMySql2 = stMySql2.executeQuery(_mySqlSentencia2); 
              rsMySql2.next();
              codModeloVeh = rsMySql2.getString("codModeloVeh");
              registros[3] = rsMySql2.getString("dominioVeh");
              registros[4] = rsMySql2.getString("codigoCristal");
              
            // muestra modelo
               String _mySqlSentencia3 = "SELECT codModeloVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo WHERE codModeloVeh LIKE '%"+ codModeloVeh +"%'";
               Statement stMySql3 = (Statement) _conectarSql.createStatement(); 
               ResultSet rsMySql3 = stMySql3.executeQuery(_mySqlSentencia3); 
               rsMySql3.next();   
               registros[5] = rsMySql3.getString("descrModeloVeh");
               
            //muestra seguro  
              String _mySqlSentencia4 = "SELECT polizaSiniestro.numPoliza, polizaSiniestro.numSiniestro, polizaSiniestro.iuSeguros, polizaSiniestro.estadoEliminacion, seguros.iuSeguros, seguros.nombSeguro FROM polizaSiniestro INNER JOIN seguros ON polizaSiniestro.iuSeguros = seguros.iuSeguros WHERE (numPoliza  LIKE '%"+ numPoliza +"%') AND ( numSiniestro LIKE '%"+ numSiniestro +"%')";
              Statement stMySql4 = (Statement) _conectarSql.createStatement(); 
              ResultSet rsMySql4 = stMySql4.executeQuery(_mySqlSentencia4);
              rsMySql4.next();

                registros[6] = rsMySql4.getString("nombSeguro");  
                registros[7] = rsMySql.getString("fechaAproxCobro") ; 
                registros[8] = rsMySql.getString("iuVentas") ;
                
                 _modeloJTabla.addRow(registros);
                 
                 } 
            }
        return _modeloJTabla;
            
  } catch (Exception e) {
            
        JOptionPane.showConfirmDialog(null, e);
        return null;
        
        }
    }
    
    public String filtrarTabla(String valor){
 
        switch(valor){
    
       case "Primeros agregados" : 
           _resultFiltrar = "fechaInsercion ASC";
           break;
       case "Seleccionar":
            _resultFiltrar = "iuMovimientoSeguros DESC";
           break; 
       case "Ultimos agregados":
            _resultFiltrar = "fechaInsercion DESC";
           break;

        }
    
    return _resultFiltrar;
    }
    
    public DefaultComboBoxModel cargarFiltrarPorSeguro(){
     // carga el combobox filtrar x seguro
     
      DefaultComboBoxModel listaMarcas = new DefaultComboBoxModel();
      _mySqlSentencia = "SELECT nombSeguro, estadoEliminacion FROM  seguros ";
   
        try {
            
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
            
             listaMarcas.addElement(rsMySql.getString("nombSeguro"));
            }
                
        }
        } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
     
     return listaMarcas;
     }
     
    public DefaultTableModel buscarEnTablaPorPolizaSiniestro(String busqueda){
        String iuPresupuesto =  "";
        String codModeloVeh =  "";
        String numPoliza="";
        String numSiniestro = "";
        
        String [] titulosTabla = {"Reg. movimiento", "Poliza", "Siniestro", "Dominio", "Cristal", "Modelo", "Seguro", "Fecha cobro", "Reg. venta"};
        String [] registros = new String[9];
        
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
        _mySqlSentencia = "SELECT movimientoseguros.iuMovimientoSeguros, movimientoseguros.iuVentas, movimientoseguros.numPoliza, movimientoseguros.numSiniestro, movimientoseguros.fechaAproxCobro, movimientoseguros.fechaInsercion, movimientoseguros.estadoEliminacion, ventaslocal.iuVentas, ventaslocal.iuPresupuesto  FROM movimientoseguros INNER JOIN ventaslocal ON movimientoseguros.iuVentas = ventaslocal.iuVentas  WHERE (numPoliza  LIKE '%"+ busqueda +"%') OR (numSiniestro  LIKE '%"+ busqueda +"%')";
          
        try {
            
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuMovimientoSeguros");
                numPoliza = rsMySql.getString("numPoliza");
                registros[1] = numPoliza;
                numSiniestro = rsMySql.getString("numSiniestro");
                registros[2] = numSiniestro;
            //muestra presupuesto
              iuPresupuesto = rsMySql.getString("iuPresupuesto") ;
              String _mySqlSentencia2 = "SELECT presupuestos.iuPresupuesto, presupuestos.dominioVeh, presupuestos.codigoCristal, presupuestos.estadoEliminacion, vehiculos.dominioVeh, vehiculos.codModeloVeh FROM presupuestos INNER JOIN vehiculos ON presupuestos.dominioVeh = vehiculos.dominioVeh WHERE iuPresupuesto LIKE '%"+ iuPresupuesto +"%' ";
              Statement stMySql2 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql2 = stMySql2.executeQuery(_mySqlSentencia2); 
              rsMySql2.next();
              codModeloVeh = rsMySql2.getString("codModeloVeh");
              registros[3] = rsMySql2.getString("dominioVeh");
              registros[4] = rsMySql2.getString("codigoCristal");
              
            // muetra modelo
               String _mySqlSentencia3 = "SELECT codModeloVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo WHERE codModeloVeh LIKE '%"+ codModeloVeh +"%'";
               Statement stMySql3 = (Statement) _conectarSql.createStatement(); // para marcaveh
               ResultSet rsMySql3 = stMySql3.executeQuery(_mySqlSentencia3); 
               rsMySql3.next();   
               registros[5] = rsMySql3.getString("descrModeloVeh");
               
            //muestra seguro  
              String _mySqlSentencia4 = "SELECT polizaSiniestro.numPoliza, polizaSiniestro.numSiniestro, polizaSiniestro.iuSeguros, polizaSiniestro.estadoEliminacion, seguros.iuSeguros, seguros.nombSeguro FROM polizaSiniestro INNER JOIN seguros ON polizaSiniestro.iuSeguros = seguros.iuSeguros WHERE (numPoliza  LIKE '%"+ numPoliza +"%') AND ( numSiniestro LIKE '%"+ numSiniestro +"%')";
              Statement stMySql4 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql4 = stMySql4.executeQuery(_mySqlSentencia4);
              rsMySql4.next();

                registros[6] = rsMySql4.getString("nombSeguro");   
                registros[7] = rsMySql.getString("fechaAproxCobro") ; 
                registros[8] = rsMySql.getString("iuVentas") ;
                
                 _modeloJTabla.addRow(registros);
                 
                 } 
            }
       
        return _modeloJTabla;
         
  } catch (Exception e) {
            
        JOptionPane.showConfirmDialog(null, e);
        return null;
        
        }
    }
      
    public DefaultTableModel buscarEnTablaPorSeguro(String busqueda){
      
      
        String iuPresupuesto =  "";
        String codModeloVeh =  "";
        String numPoliza="";
        String numSiniestro = "";
        String aux = ""; 
        
        ArrayList<String> auxPol ;
        auxPol = new  ArrayList<>();
        ArrayList<String> auxSin ;
        auxSin = new  ArrayList<>();
        
        String [] titulosTabla = {"Reg. movimiento", "Poliza", "Siniestro", "Dominio", "Cristal", "Modelo", "Seguro", "Fecha cobro", "Reg. venta"};
        String [] registros = new String[9];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
        
        // compara la busqueda con lista de seguros para obtener id
          String _mySqlSentenciaSeguro = "SELECT iuSeguros, nombSeguro FROM seguros WHERE nombSeguro LIKE '%"+ busqueda+"%'  ";
         try{
           Statement stMySqlSeg = (Statement) _conectarSql.createStatement(); // mirara xq cast
           ResultSet rsMySqlSeg = stMySqlSeg.executeQuery(_mySqlSentenciaSeguro);
         
           rsMySqlSeg.next();
           aux = rsMySqlSeg.getString("iuSeguros");
         
         } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
         // con id anterior obtiene lista de polizaSiniestros 
          String _mySqlSentenciaPolSin = "SELECT numPoliza, numSiniestro, iuSeguros FROM polizasiniestro WHERE iuSeguros LIKE '%"+ aux +"%'  ";
         try{
          Statement stMySqlPolSin = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySqlPolSin = stMySqlPolSin.executeQuery(_mySqlSentenciaPolSin);
         
         while(rsMySqlPolSin.next()){
         auxPol.add( rsMySqlPolSin.getString("numPoliza"));
         auxSin.add(rsMySqlPolSin.getString("numSiniestro"));
         }    
         } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }

        // carga tabla con polizaSiniestros == a la lista obtenida antes    
         try{
           for (int i = 0; i < auxPol.size(); i++) {
                
         _mySqlSentencia = "SELECT movimientoseguros.iuMovimientoSeguros, movimientoseguros.iuVentas, movimientoseguros.numPoliza, movimientoseguros.numSiniestro, movimientoseguros.fechaAproxCobro, movimientoseguros.fechaInsercion, movimientoseguros.estadoEliminacion, ventaslocal.iuVentas, ventaslocal.iuPresupuesto  FROM movimientoseguros INNER JOIN ventaslocal ON movimientoseguros.iuVentas = ventaslocal.iuVentas WHERE (numPoliza  LIKE '%"+ auxPol.get(i) +"%') AND ( numSiniestro LIKE '%"+ auxSin.get(i) +"%') ";
                
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuMovimientoSeguros");
                numPoliza = rsMySql.getString("numPoliza");
                registros[1] = numPoliza;
                numSiniestro = rsMySql.getString("numSiniestro");
                registros[2] = numSiniestro;
            //muestra presupuesto
              iuPresupuesto = rsMySql.getString("iuPresupuesto") ;
              String _mySqlSentencia2 = "SELECT presupuestos.iuPresupuesto, presupuestos.dominioVeh, presupuestos.codigoCristal, presupuestos.estadoEliminacion, vehiculos.dominioVeh, vehiculos.codModeloVeh FROM presupuestos INNER JOIN vehiculos ON presupuestos.dominioVeh = vehiculos.dominioVeh WHERE iuPresupuesto LIKE '%"+ iuPresupuesto +"%' ";
              Statement stMySql2 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql2 = stMySql2.executeQuery(_mySqlSentencia2); 
              rsMySql2.next();
              codModeloVeh = rsMySql2.getString("codModeloVeh");
              registros[3] = rsMySql2.getString("dominioVeh");
              registros[4] = rsMySql2.getString("codigoCristal");
              
            // muestra modelo
                String _mySqlSentencia3 = "SELECT codModeloVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo WHERE codModeloVeh LIKE '%"+ codModeloVeh +"%'";
               Statement stMySql3 = (Statement) _conectarSql.createStatement(); // para marcaveh
               ResultSet rsMySql3 = stMySql3.executeQuery(_mySqlSentencia3); 
               rsMySql3.next();   
               registros[5] = rsMySql3.getString("descrModeloVeh");
               
            //muestra seguro  
                String _mySqlSentencia4 = "SELECT polizaSiniestro.numPoliza, polizaSiniestro.numSiniestro, polizaSiniestro.iuSeguros, polizaSiniestro.estadoEliminacion, seguros.iuSeguros, seguros.nombSeguro FROM polizaSiniestro INNER JOIN seguros ON polizaSiniestro.iuSeguros = seguros.iuSeguros WHERE (numPoliza  LIKE '%"+ numPoliza +"%') AND ( numSiniestro LIKE '%"+ numSiniestro +"%')";
                Statement stMySql4 = (Statement) _conectarSql.createStatement(); // para marcaveh
                ResultSet rsMySql4 = stMySql4.executeQuery(_mySqlSentencia4);
                rsMySql4.next();

                registros[6] = rsMySql4.getString("nombSeguro");    
                registros[7] = rsMySql.getString("fechaAproxCobro") ; 
                registros[8] = rsMySql.getString("iuVentas") ;
                
                 _modeloJTabla.addRow(registros);
                 
                 } 
            }
       
           }
           
             return _modeloJTabla;
         }catch (Exception e) {
            
        JOptionPane.showConfirmDialog(null, e);
        return null;
        
        }
 
      }
      
    public DefaultTableModel buscarEnTablaPorDominio(String busqueda){
      
        String iuPresupuesto =  "";
        String codModeloVeh =  "";
        String numPoliza="";
        String numSiniestro = "";
       
        ArrayList<String> aux ;
        aux = new  ArrayList<>();
        ArrayList<String> auxVen ;
        auxVen = new  ArrayList<>();
        
        String [] titulosTabla = {"Reg. movimiento", "Poliza", "Siniestro", "Dominio", "Cristal", "Modelo", "Seguro", "Fecha cobro", "Reg. venta"};
        String [] registros = new String[9];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
        
        // obtengo lista de presupuestos
          String _mySqlSentenciaPresupuesto = "SELECT iuPresupuesto, dominioVeh FROM presupuestos WHERE dominioVeh LIKE '%"+ busqueda+"%'  ";
         try{
          Statement stMySqlPre = (Statement) _conectarSql.createStatement(); // mirara xq cast
          ResultSet rsMySqlPre = stMySqlPre.executeQuery(_mySqlSentenciaPresupuesto);
         
        while(rsMySqlPre.next()){
         aux.add( rsMySqlPre.getString("iuPresupuesto"));
         }

         } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
         
          // obtengo lista de ventas
           for(int i =0; i<aux.size();i++){
               
              String _mySqlSentenciaVenta = "SELECT iuVentas, iuPresupuesto FROM ventaslocal WHERE iuPresupuesto LIKE '%"+ aux.get(i) +"%'  ";
        
               try{
                 Statement stMySqlVen = (Statement) _conectarSql.createStatement(); // mirara xq cast
                 ResultSet rsMySqlVen = stMySqlVen.executeQuery(_mySqlSentenciaVenta);
         
         while(rsMySqlVen.next()){
         auxVen.add( rsMySqlVen.getString("iuVentas"));
        
         }
         } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
        
          }
           
                // carga de tabla                  
       try{
           for (int i = 0; i < auxVen.size(); i++) {
                
         _mySqlSentencia = "SELECT movimientoseguros.iuMovimientoSeguros, movimientoseguros.iuVentas, movimientoseguros.numPoliza, movimientoseguros.numSiniestro, movimientoseguros.fechaAproxCobro, movimientoseguros.fechaInsercion, movimientoseguros.estadoEliminacion, ventaslocal.iuVentas, ventaslocal.iuPresupuesto  FROM movimientoseguros INNER JOIN ventaslocal ON movimientoseguros.iuVentas = ventaslocal.iuVentas WHERE movimientoseguros.iuVentas  LIKE '%"+ auxVen.get(i) +"%' ";
       
          Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
          ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuMovimientoSeguros");
                numPoliza = rsMySql.getString("numPoliza");
                registros[1] = numPoliza;
                numSiniestro = rsMySql.getString("numSiniestro");
                registros[2] = numSiniestro;
            //muestra presupuesto
              iuPresupuesto = rsMySql.getString("iuPresupuesto") ;
              String _mySqlSentencia2 = "SELECT presupuestos.iuPresupuesto, presupuestos.dominioVeh, presupuestos.codigoCristal, presupuestos.estadoEliminacion, vehiculos.dominioVeh, vehiculos.codModeloVeh FROM presupuestos INNER JOIN vehiculos ON presupuestos.dominioVeh = vehiculos.dominioVeh WHERE iuPresupuesto LIKE '%"+ iuPresupuesto +"%' ";
              Statement stMySql2 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql2 = stMySql2.executeQuery(_mySqlSentencia2); 
              rsMySql2.next();
              codModeloVeh = rsMySql2.getString("codModeloVeh");
              registros[3] = rsMySql2.getString("dominioVeh");
              registros[4] = rsMySql2.getString("codigoCristal");
              
            // muestra modelo
                String _mySqlSentencia3 = "SELECT codModeloVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo WHERE codModeloVeh LIKE '%"+ codModeloVeh +"%'";
                Statement stMySql3 = (Statement) _conectarSql.createStatement(); // para marcaveh
                ResultSet rsMySql3 = stMySql3.executeQuery(_mySqlSentencia3); 
                rsMySql3.next();   
                registros[5] = rsMySql3.getString("descrModeloVeh");
               
            //muestra seguro  
                String _mySqlSentencia4 = "SELECT polizaSiniestro.numPoliza, polizaSiniestro.numSiniestro, polizaSiniestro.iuSeguros, polizaSiniestro.estadoEliminacion, seguros.iuSeguros, seguros.nombSeguro FROM polizaSiniestro INNER JOIN seguros ON polizaSiniestro.iuSeguros = seguros.iuSeguros WHERE (numPoliza  LIKE '%"+ numPoliza +"%') AND ( numSiniestro LIKE '%"+ numSiniestro +"%')";
                Statement stMySql4 = (Statement) _conectarSql.createStatement(); // para marcaveh
                ResultSet rsMySql4 = stMySql4.executeQuery(_mySqlSentencia4);
                rsMySql4.next();

                registros[6] = rsMySql4.getString("nombSeguro");   
                registros[7] = rsMySql.getString("fechaAproxCobro") ; 
                registros[8] = rsMySql.getString("iuVentas") ;
                
                 _modeloJTabla.addRow(registros);
                 
                 } 
            }

           }
           
             return _modeloJTabla;
         }catch (Exception e) {
            
        JOptionPane.showConfirmDialog(null, e);
        return null;
        
        }

      }
      
    public DefaultTableModel buscarEnTablaPorModelo(String busqueda){
  
        String iuPresupuesto =  "";
        String codModeloVeh =  "";
        String numPoliza="";
        String numSiniestro = "";
        String aux = "";
        
        ArrayList<String> auxVeh ;
        auxVeh = new  ArrayList<>();
        ArrayList<String> auxPresu ;
        auxPresu = new  ArrayList<>();
        ArrayList<String> auxVen ;
        auxVen = new  ArrayList<>();
        
        String [] titulosTabla = {"Reg. movimiento", "Poliza", "Siniestro", "Dominio", "Cristal", "Modelo", "Seguro", "Fecha cobro", "Reg. venta"};
        String [] registros = new String[9];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
        
        // buscar codigo modelo pa obtener listado de dominios 
          String _mySqlSentenciaModelo = "SELECT codModeloVeh, descrModeloVeh FROM modelovehiculo WHERE descrModeloVeh LIKE '%"+ busqueda+"%'  ";
         try{
            Statement stMySqlMod = (Statement) _conectarSql.createStatement(); // mirara xq cast
            ResultSet rsMySqlMod = stMySqlMod.executeQuery(_mySqlSentenciaModelo);
            rsMySqlMod.next();
            aux = rsMySqlMod.getString("codModeloVeh");
         
         } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
         
    // listado de dominios pa obtener listado de presupuestos
          String _mySqlSentenciaVehiculos = "SELECT dominioVeh, codModeloVeh FROM vehiculos WHERE codModeloVeh LIKE '%"+ aux +"%'  ";
         try{
          Statement stMySqlVeh = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySqlVeh = stMySqlVeh.executeQuery(_mySqlSentenciaVehiculos);
  
         while(rsMySqlVeh.next()){
         auxVeh.add( rsMySqlVeh.getString("dominioVeh"));
         }
         
         } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
        //listado de presupuestos para obtener listado de ventas
         for(int i =0; i<auxVeh.size();i++){
            String _mySqlSentenciaPresupuesto = "SELECT iuPresupuesto, dominioVeh FROM presupuestos WHERE dominioVeh LIKE '%"+ auxVeh.get(i)+"%'  ";
         try{
            Statement stMySqlPre = (Statement) _conectarSql.createStatement(); // mirara xq cast
           ResultSet rsMySqlPre = stMySqlPre.executeQuery(_mySqlSentenciaPresupuesto);
         
         while(rsMySqlPre.next()){
         auxPresu.add( rsMySqlPre.getString("iuPresupuesto"));
        
         }
         } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
        
          }
         
         //listado de ventas pa obtener listado de movimientos      
           for(int i =0; i<auxPresu.size();i++){
             String _mySqlSentenciaVentas = "SELECT iuVentas, iuPresupuesto FROM ventaslocal WHERE iuPresupuesto LIKE '%"+ auxPresu.get(i)+"%'  ";
         try{
            Statement stMySqlVen = (Statement) _conectarSql.createStatement(); // mirara xq cast
           ResultSet rsMySqlVen = stMySqlVen.executeQuery(_mySqlSentenciaVentas);
         
         while(rsMySqlVen.next()){
         auxVen.add( rsMySqlVen.getString("iuVentas"));
        
         }
         } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
        
          }
        
       //cargar tabla
         try{
           for (int i = 0; i < auxVen.size(); i++) {
                
           _mySqlSentencia = "SELECT movimientoseguros.iuMovimientoSeguros, movimientoseguros.iuVentas, movimientoseguros.numPoliza, movimientoseguros.numSiniestro, movimientoseguros.fechaAproxCobro, movimientoseguros.fechaInsercion, movimientoseguros.estadoEliminacion, ventaslocal.iuVentas, ventaslocal.iuPresupuesto  FROM movimientoseguros INNER JOIN ventaslocal ON movimientoseguros.iuVentas = ventaslocal.iuVentas WHERE movimientoseguros.iuVentas  LIKE '%"+ auxVen.get(i) +"%' ";
                    
           Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
            ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("iuMovimientoSeguros");
                numPoliza = rsMySql.getString("numPoliza");
                registros[1] = numPoliza;
                numSiniestro = rsMySql.getString("numSiniestro");
                registros[2] = numSiniestro;
            //muestra presupuesto
              iuPresupuesto = rsMySql.getString("iuPresupuesto") ;
              String _mySqlSentencia2 = "SELECT presupuestos.iuPresupuesto, presupuestos.dominioVeh, presupuestos.codigoCristal, presupuestos.estadoEliminacion, vehiculos.dominioVeh, vehiculos.codModeloVeh FROM presupuestos INNER JOIN vehiculos ON presupuestos.dominioVeh = vehiculos.dominioVeh WHERE iuPresupuesto LIKE '%"+ iuPresupuesto +"%' ";
              Statement stMySql2 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql2 = stMySql2.executeQuery(_mySqlSentencia2); 
              rsMySql2.next();
              codModeloVeh = rsMySql2.getString("codModeloVeh");
              registros[3] = rsMySql2.getString("dominioVeh");
              registros[4] = rsMySql2.getString("codigoCristal");
              
            //muestra modelo
                String _mySqlSentencia3 = "SELECT codModeloVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo WHERE codModeloVeh LIKE '%"+ codModeloVeh +"%'";
                Statement stMySql3 = (Statement) _conectarSql.createStatement(); // para marcaveh
                ResultSet rsMySql3 = stMySql3.executeQuery(_mySqlSentencia3); 
                rsMySql3.next();   
                registros[5] = rsMySql3.getString("descrModeloVeh");
               
            //mostrar seguro  
                String _mySqlSentencia4 = "SELECT polizaSiniestro.numPoliza, polizaSiniestro.numSiniestro, polizaSiniestro.iuSeguros, polizaSiniestro.estadoEliminacion, seguros.iuSeguros, seguros.nombSeguro FROM polizaSiniestro INNER JOIN seguros ON polizaSiniestro.iuSeguros = seguros.iuSeguros WHERE (numPoliza  LIKE '%"+ numPoliza +"%') AND ( numSiniestro LIKE '%"+ numSiniestro +"%')";
                Statement stMySql4 = (Statement) _conectarSql.createStatement(); // para marcaveh
                ResultSet rsMySql4 = stMySql4.executeQuery(_mySqlSentencia4);
                rsMySql4.next();

                registros[6] = rsMySql4.getString("nombSeguro");   
                registros[7] = rsMySql.getString("fechaAproxCobro") ; 
                registros[8] = rsMySql.getString("iuVentas") ;
                
                 _modeloJTabla.addRow(registros);
                 
                 } 
            }

           }
           
             return _modeloJTabla;
         }catch (Exception e) {
            
        JOptionPane.showConfirmDialog(null, e);
        return null;
        
        }
      
      }
    
}