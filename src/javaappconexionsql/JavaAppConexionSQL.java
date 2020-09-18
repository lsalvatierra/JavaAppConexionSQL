
package javaappconexionsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JavaAppConexionSQL {

    String url = "jdbc:sqlserver://DESKTOP-VIT2DB8:1433;databaseName=bdnotas";
    String user = "sa";
    String password ="123456";
    Connection conexion;
    
     public Connection conectar(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion= (Connection)DriverManager.getConnection(url, user, password);
            System.out.println("Se conectó a la BD");
        }catch(ClassNotFoundException|SQLException ex){
            System.out.println(ex.getMessage());
        }
        return conexion;
    }
    
    public void desconectar(){
        try{
            conexion.close();
        }catch(SQLException ex){
            System.out.println("No se pudo cerrar la conexión.");
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        JavaAppConexionSQL conexionSQLBD = new JavaAppConexionSQL();
        conexionSQLBD.conectar();        
    }
    
}
