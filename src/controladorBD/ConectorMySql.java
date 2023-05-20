/*
Esta clase maneja la conexion a la base de datos
*/
package controladorBD;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectorMySql {
// parametros para la conexion    
    private static Connection _conectarMySql; 
    private static final String _driverMySql = "com.mysql.jdbc.Driver";
// seguridad de la base de datos    
    private static final String _userMysql = "root"; 
    private static final String _passMysql = "";
//link a la base de datos   
    private static final  String _urlMySql = "jdbc:mysql://localhost:3306/dbeldoradoparabrisas?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8";

    public ConectorMySql() {}
    
    // se realiza la coneccion y se  advierte de no realizarse
    public static Connection getConection(){
        _conectarMySql = null;
        try {
            Class.forName(_driverMySql);
            _conectarMySql = (Connection) DriverManager.getConnection(_urlMySql,_userMysql, _passMysql);
 
        } catch (ClassNotFoundException | SQLException e) {
              _conectarMySql = null;
        } 
    return _conectarMySql;
    }
    
    // desconexion de base de datos
    public static  Connection desconectarMySql(){
        try { 
            _conectarMySql.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectorMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
          return _conectarMySql;
    }
    
}
