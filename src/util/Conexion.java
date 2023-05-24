
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String driver, user, password, bdName, url;
    private Connection conexion;
    
    public Conexion(){
        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "";
        bdName = "session2";
        url = "jdbc:mysql://localhost:3306/" + bdName;
        
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión a la base de datos '"+bdName+"' es correcta.");            
        } catch (Exception e) {
            System.out.println("Conexión a la base de datos '"+bdName+"' erronea, error de tipo: " + e.toString());
        }   
    }
    
    public Connection obtenerConexion() {
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException {
        if(!conexion.isClosed()){
            conexion.close();
            conexion = null;
        }        
        return conexion;
    }
    
    
  
}
