/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rgluis
 */
public class ConnectionDB {
    
    private static final String URL = "jdbc:mysql://35.238.225.77:3306/employees";
    private static final String USER = "echouser";
    private static final String PASSWORD = "EchoBitlabPass$$";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    
    public static Connection openConnection() throws ClassNotFoundException, SQLException{
         Class.forName(DRIVER);
         return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void closeConnection(Connection con) throws SQLException{
        if(con!=null && !con.isClosed())
            con.close();
    }
    
}
