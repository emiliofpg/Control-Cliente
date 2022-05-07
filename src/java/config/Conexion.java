
package config;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;



public class Conexion {
    private static Connection con=null;
    private static final String URL = "jdbc:mysql://localhost:3306/control_clientes";
    private static final String USER = "root";
    private static final String PASS = "";
   
    public static Connection Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error"+e);
        }
            return con;
      
    }
       
}
