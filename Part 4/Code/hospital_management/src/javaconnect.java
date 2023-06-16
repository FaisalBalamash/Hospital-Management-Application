import java.sql.*;
import javax.swing.*;

public class javaconnect
{
    Connection conn = null;

    public static Connection setconnection(){   
        Connection conn = null;                  // NOTE: Servername, Serverport, and sid may differ in another computer
        try{
            String driverName = "oracle.jdbc.driver.OracleDriver";      
            Class.forName(driverName);
            String serverName = "localhost";     
            String serverPort = "1521";  
            String sid = "XE";
            String url = "jbdc:oracle:thin:@" + serverName+ ":" + serverPort + "/" + sid;
            String username = "scott";
            String password = "tiger";
            
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected to database");
            
        }
        catch(ClassNotFoundException e){
            System.out.println("Could not find database driver " + e.getMessage());
        }
        catch(SQLException e){
            System.out.println("could not connect to database " + e.getMessage());
        }
        return conn;
    }
}
