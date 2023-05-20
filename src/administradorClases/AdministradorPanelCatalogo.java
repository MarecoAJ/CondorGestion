
package administradorClases;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import controladorBD.ConectorMySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class AdministradorPanelCatalogo {

    private final ConectorMySql _conectorMySql;
    private final Connection _conectarSql;
    private DefaultTableModel _modeloJTabla;
    private String _mySqlSentencia;
    private String _resultFiltrar= " codigoCristal DESC";
    
    
    public AdministradorPanelCatalogo() {
        
        _conectorMySql = new ConectorMySql();
        _conectarSql = _conectorMySql.getConection();
    
    }
  
    public DefaultTableModel cargarJTabla(){
        String codModeloVeh =  "";
        String codMarcaVeh =  "";
        String [] titulosTabla = {"Cod. cristal", "Descripcion", "Marca", "Modelo", "Marca cristal", "Stock", "Precio"};
        String [] registros = new String[7];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
        _mySqlSentencia = "SELECT catalogocristales.codigoCristal, catalogocristales.descrCristal, catalogocristales.codModeloVeh, catalogocristales.iuMarcaCris, catalogocristales.precioPieza, catalogocristales.fechaInsercion, catalogocristales.estadoEliminacion, marcascristales.descrMarcaCris, modelovehiculo.descrModeloVeh FROM catalogocristales INNER JOIN marcascristales ON catalogocristales.iuMarcaCris = marcascristales.iuMarcaCris INNER JOIN modeloVehiculo ON catalogocristales.codModeloVeh = modelovehiculo.codModeloVeh  ORDER BY " + _resultFiltrar + "";
          
        try {
            
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
       
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("codigoCristal");
                registros[1] = rsMySql.getString("descrCristal"); 
            //mostrar marcaVeh
              codModeloVeh = rsMySql.getString("codModeloVeh") ;
              String _mySqlSentencia2 = "SELECT codModeloVeh, codMarcaVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo WHERE codModeloVeh LIKE '%"+ codModeloVeh +"%'";
              Statement stMySql2 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql2 = stMySql2.executeQuery(_mySqlSentencia2); 
              rsMySql2.next();
              codMarcaVeh = rsMySql2.getString("codMarcaVeh");
                String _mySqlSentencia3 = "SELECT codMarcaVeh, descrMarcaVeh, estadoEliminacion FROM marcavehiculo WHERE codMarcaVeh LIKE '%"+ codMarcaVeh +"%'";
              Statement stMySql3 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql3 = stMySql3.executeQuery(_mySqlSentencia3); 
               rsMySql3.next();   
               registros[2] = rsMySql3.getString("descrMarcaVeh");
                registros[3] = rsMySql.getString("descrModeloVeh") ;
                registros[4] = rsMySql.getString("descrMarcaCris") ; 
              //mostrar stock  
                 String _mySqlSentencia4 = "SELECT codigoCristal, cantidadMovil, estadoEliminacion FROM stockCristales WHERE codigoCristal LIKE '%"+ rsMySql.getString("codigoCristal") +"%'";
              Statement stMySql4 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql4 = stMySql4.executeQuery(_mySqlSentencia4);
              rsMySql4.next();
               if(rsMySql4.getRow() == 0){
               
                registros[5] = "no stock";
               } 
               else{
                registros[5] = rsMySql4.getString("cantidadMovil");
               }   
                registros[6] = rsMySql.getString("precioPieza") ; 
                
                 _modeloJTabla.addRow(registros);
                 
                 }
            }
        return _modeloJTabla;
            
  } catch (Exception e) {
            
        JOptionPane.showConfirmDialog(null, e);
        return null;
        
        }
    }
    
      public DefaultTableModel buscarEnTablaPorCodigoCristal(String busqueda){
      
             String codModeloVeh =  "";
        String codMarcaVeh =  "";
        String [] titulosTabla = {"Cod. cristal", "Descripcion", "Marca", "Modelo", "Marca cristal", "Stock", "Precio"};
        String [] registros = new String[7];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
        _mySqlSentencia = "SELECT catalogocristales.codigoCristal, catalogocristales.descrCristal, catalogocristales.codModeloVeh, catalogocristales.iuMarcaCris, catalogocristales.precioPieza, catalogocristales.fechaInsercion, catalogocristales.estadoEliminacion, marcascristales.descrMarcaCris, modelovehiculo.descrModeloVeh FROM catalogocristales INNER JOIN marcascristales ON catalogocristales.iuMarcaCris = marcascristales.iuMarcaCris INNER JOIN modeloVehiculo ON catalogocristales.codModeloVeh = modelovehiculo.codModeloVeh  WHERE codigoCristal LIKE '%"+ busqueda+"%' ";
     
        
        
     try {
            
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
         
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("codigoCristal");
                registros[1] = rsMySql.getString("descrCristal"); 
            //mostrar marcaVeh
              codModeloVeh = rsMySql.getString("codModeloVeh") ;
              String _mySqlSentencia2 = "SELECT codModeloVeh, codMarcaVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo WHERE codModeloVeh LIKE '%"+ codModeloVeh +"%'";
              Statement stMySql2 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql2 = stMySql2.executeQuery(_mySqlSentencia2); 
              rsMySql2.next();
              codMarcaVeh = rsMySql2.getString("codMarcaVeh");
                String _mySqlSentencia3 = "SELECT codMarcaVeh, descrMarcaVeh, estadoEliminacion FROM marcavehiculo WHERE codMarcaVeh LIKE '%"+ codMarcaVeh +"%'";
              Statement stMySql3 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql3 = stMySql3.executeQuery(_mySqlSentencia3); 
               rsMySql3.next();   
               registros[2] = rsMySql3.getString("descrMarcaVeh");
                registros[3] = rsMySql.getString("descrModeloVeh") ;
                registros[4] = rsMySql.getString("descrMarcaCris") ; 
              //mostrar stock  
                 String _mySqlSentencia4 = "SELECT codigoCristal, cantidadMovil, estadoEliminacion FROM stockCristales WHERE codigoCristal LIKE '%"+ rsMySql.getString("codigoCristal") +"%'";
              Statement stMySql4 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql4 = stMySql4.executeQuery(_mySqlSentencia4);
              rsMySql4.next();
               if(rsMySql4.getRow() == 0){
               
                registros[5] = "no stock";
               } 
               else{
                registros[5] = rsMySql4.getString("cantidadMovil");
               }   
                registros[6] = rsMySql.getString("precioPieza") ; 
                
                 _modeloJTabla.addRow(registros);
                 
                 }
            }
        return _modeloJTabla;
            
  } catch (Exception e) {
            
        JOptionPane.showConfirmDialog(null, e);
        return null;
        
        }

    }
        
     public DefaultTableModel buscarEnTablaPorModelo(String busqueda){
      
             String codModeloVeh =  "";
        String codMarcaVeh =  "";
        String aux = "";
        String [] titulosTabla = {"Cod. cristal", "Descripcion", "Marca", "Modelo", "Marca cristal", "Stock", "Precio"};
        String [] registros = new String[7];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
         String _mySqlSentenciaModelo = "SELECT codModeloVeh, descrModeloVeh FROM modelovehiculo WHERE descrModeloVeh LIKE '%"+ busqueda+"%'  ";
         try{
          Statement stMySqlMod = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySqlMod = stMySqlMod.executeQuery(_mySqlSentenciaModelo);
         
         rsMySqlMod.next();
         aux = rsMySqlMod.getString("codModeloVeh");
         
         } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
        _mySqlSentencia = "SELECT catalogocristales.codigoCristal, catalogocristales.descrCristal, catalogocristales.codModeloVeh, catalogocristales.iuMarcaCris, catalogocristales.precioPieza, catalogocristales.fechaInsercion, catalogocristales.estadoEliminacion, marcascristales.descrMarcaCris, modelovehiculo.descrModeloVeh FROM catalogocristales INNER JOIN marcascristales ON catalogocristales.iuMarcaCris = marcascristales.iuMarcaCris INNER JOIN modeloVehiculo ON catalogocristales.codModeloVeh = modelovehiculo.codModeloVeh  WHERE codigoCristal LIKE '%"+ aux+"%' ";
        String _mySqlSentenciaFK1 = "SELECT cuiCliente, nombreCliente, estadoEliminacion FROM clientes"; 
        
        
     try {
            
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
  
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("codigoCristal");
                registros[1] = rsMySql.getString("descrCristal"); 
            //mostrar marcaVeh
              codModeloVeh = rsMySql.getString("codModeloVeh") ;
              String _mySqlSentencia2 = "SELECT codModeloVeh, codMarcaVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo WHERE codModeloVeh LIKE '%"+ codModeloVeh +"%'";
              Statement stMySql2 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql2 = stMySql2.executeQuery(_mySqlSentencia2); 
              rsMySql2.next();
              codMarcaVeh = rsMySql2.getString("codMarcaVeh");
                String _mySqlSentencia3 = "SELECT codMarcaVeh, descrMarcaVeh, estadoEliminacion FROM marcavehiculo WHERE codMarcaVeh LIKE '%"+ codMarcaVeh +"%'";
              Statement stMySql3 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql3 = stMySql3.executeQuery(_mySqlSentencia3); 
               rsMySql3.next();   
               registros[2] = rsMySql3.getString("descrMarcaVeh");
                registros[3] = rsMySql.getString("descrModeloVeh") ;
                registros[4] = rsMySql.getString("descrMarcaCris") ; 
              //mostrar stock  
                 String _mySqlSentencia4 = "SELECT codigoCristal, cantidadMovil, estadoEliminacion FROM stockCristales WHERE codigoCristal LIKE '%"+ rsMySql.getString("codigoCristal") +"%'";
              Statement stMySql4 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql4 = stMySql4.executeQuery(_mySqlSentencia4);
              rsMySql4.next();
               if(rsMySql4.getRow() == 0){
               
                registros[5] = "no stock";
               } 
               else{
                registros[5] = rsMySql4.getString("cantidadMovil");
               }   
                registros[6] = rsMySql.getString("precioPieza") ; 
                
                 _modeloJTabla.addRow(registros);
                 
                 }
            }
        return _modeloJTabla;
            
  } catch (Exception e) {
            
        JOptionPane.showConfirmDialog(null, e);
        return null;
        
        }

    }  
    
   public DefaultTableModel buscarEnTablaPorMarca(String busqueda){
      
             String codModeloVeh =  "";
        String codMarcaVeh =  "";
        String aux = "";
        String [] titulosTabla = {"Cod. cristal", "Descripcion", "Marca", "Modelo", "Marca cristal", "Stock", "Precio"};
        String [] registros = new String[7];
        _modeloJTabla = new DefaultTableModel(null,titulosTabla);
         String _mySqlSentenciaMarca = "SELECT codMarcaVeh, descrMarcaVeh FROM marcavehiculo WHERE descrMmarcaVeh LIKE '%"+ busqueda+"%'  ";
         try{
          Statement stMySqlMar = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySqlMar = stMySqlMar.executeQuery(_mySqlSentenciaMarca);
         
         rsMySqlMar.next();
         aux = rsMySqlMar.getString("codMarcaVeh");
         
         } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
        _mySqlSentencia = "SELECT catalogocristales.codigoCristal, catalogocristales.descrCristal, catalogocristales.codModeloVeh, catalogocristales.iuMarcaCris, catalogocristales.precioPieza, catalogocristales.fechaInsercion, catalogocristales.estadoEliminacion, marcascristales.descrMarcaCris, modelovehiculo.descrModeloVeh FROM catalogocristales INNER JOIN marcascristales ON catalogocristales.iuMarcaCris = marcascristales.iuMarcaCris INNER JOIN modeloVehiculo ON catalogocristales.codModeloVeh = modelovehiculo.codModeloVeh  WHERE codigoCristal LIKE '%"+ aux+"%' ";
        String _mySqlSentenciaFK1 = "SELECT cuiCliente, nombreCliente, estadoEliminacion FROM clientes"; 
    
     try {
            
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);    
        
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
                
                registros[0] = rsMySql.getString("codigoCristal");
                registros[1] = rsMySql.getString("descrCristal"); 
            //mostrar marcaVeh
              codModeloVeh = rsMySql.getString("codModeloVeh") ;
              String _mySqlSentencia2 = "SELECT codModeloVeh, codMarcaVeh, descrModeloVeh, estadoEliminacion FROM modelovehiculo WHERE codModeloVeh LIKE '%"+ codModeloVeh +"%'";
              Statement stMySql2 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql2 = stMySql2.executeQuery(_mySqlSentencia2); 
              rsMySql2.next();
              codMarcaVeh = rsMySql2.getString("codMarcaVeh");
                String _mySqlSentencia3 = "SELECT codMarcaVeh, descrMarcaVeh, estadoEliminacion FROM marcavehiculo WHERE codMarcaVeh LIKE '%"+ codMarcaVeh +"%'";
              Statement stMySql3 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql3 = stMySql3.executeQuery(_mySqlSentencia3); 
               rsMySql3.next();   
               registros[2] = rsMySql3.getString("descrMarcaVeh");
                registros[3] = rsMySql.getString("descrModeloVeh") ;
                registros[4] = rsMySql.getString("descrMarcaCris") ; 
              //mostrar stock  
                 String _mySqlSentencia4 = "SELECT codigoCristal, cantidadMovil, estadoEliminacion FROM stockCristales WHERE codigoCristal LIKE '%"+ rsMySql.getString("codigoCristal") +"%'";
              Statement stMySql4 = (Statement) _conectarSql.createStatement(); // para marcaveh
              ResultSet rsMySql4 = stMySql4.executeQuery(_mySqlSentencia4);
              rsMySql4.next();
               if(rsMySql4.getRow() == 0){
               
                registros[5] = "no stock";
               } 
               else{
                registros[5] = rsMySql4.getString("cantidadMovil");
               }   
                registros[6] = rsMySql.getString("precioPieza") ; 
                
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
            _resultFiltrar = "codigoCristal DESC";
           break; 
       case "Ultimos agregados":
            _resultFiltrar = "fechaInsercion DESC";
           break;
   
               case "Mayor precio":
            _resultFiltrar = "precioPieza DESC";
           break;
   
           case "Menor precio":
            _resultFiltrar = "precioPieza ASC";
           break;
        }
    
    return _resultFiltrar;
    }
     
     public DefaultComboBoxModel cargarFiltrarPorMarca(){
    
      DefaultComboBoxModel listaMarcas = new DefaultComboBoxModel();
      _mySqlSentencia = "SELECT descrMarcaVeh, estadoEliminacion FROM  marcaVehiculo ";
   
        try {
            
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);
        
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
            
             listaMarcas.addElement(rsMySql.getString("descrMarcaVeh"));
            }
                
        }
        } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
     
     return listaMarcas;
     }
     
        public DefaultComboBoxModel cargarFiltrarPorModelo(){
    
      DefaultComboBoxModel listaModelos = new DefaultComboBoxModel();
      _mySqlSentencia = "SELECT descrModeloVeh, estadoEliminacion FROM  modeloVehiculo ";
        
        
        try {
            
        Statement stMySql = (Statement) _conectarSql.createStatement(); // mirara xq cast
        ResultSet rsMySql = stMySql.executeQuery(_mySqlSentencia);  
        
        while(rsMySql.next()){
            if(rsMySql.getInt("estadoEliminacion") == 1 ){
            
             listaModelos.addElement(rsMySql.getString("descrModeloVeh"));
            }
                
        }
        } catch (SQLException ex) {
              Logger.getLogger(AdministradorPanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
          }
     
     return listaModelos;
     }
  
     
     
     
}
