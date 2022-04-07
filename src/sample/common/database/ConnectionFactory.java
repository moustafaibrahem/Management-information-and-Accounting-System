package sample.common.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionFactory {
    public static String driver_class;
    public static String url;
    public static String username;
    public static String password;


    static {
        driver_class = "com.mysql.cj.jdbc.Driver";
        url ="jdbc:mysql://localhost/accounting";
        username="root";
        password="";

    }
    public static Connection createConnection () throws SQLException {
       return DriverManager.getConnection(url, username, password);
    }
    
}
