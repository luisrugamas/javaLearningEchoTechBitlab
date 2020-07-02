/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author rgluis
 */
public class ConnectionDB {
    
//    private static final String URL = "jdbc:mysql://35.238.225.77:3306/employees";
//    private static final String USER = "echouser";
//    private static final String PASSWORD = "EchoBitlabPass$$";
//    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:postgresql://35.238.225.77:5432/postgres";
    private static final String USER = "echouser";
    private static final String PASSWORD = "EchoBitlab2020$$";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final ConnectionDB main = new ConnectionDB();
    private BasicDataSource basicDataSource;
    
    private ConnectionDB(){
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(DRIVER);
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASSWORD);
        basicDataSource.setUrl(URL);
        basicDataSource.setInitialSize(4); //The initial number of connections that are created when the pool is started. 
        basicDataSource.setMaxTotal(10); //The maximum number of active connections that can be allocated from this pool at the same time, or negative for no limit.
        basicDataSource.setMaxIdle(8);
    }
    
    public static ConnectionDB getInstance(){
        return main;
    }
    
    
    public Connection openConnection() throws ClassNotFoundException, SQLException{
//         Class.forName(DRIVER);
//         return DriverManager.getConnection(URL, USER, PASSWORD);
            return basicDataSource.getConnection();
    }
    
    public static void closeConnection(Connection con) throws SQLException{
        if(con!=null && !con.isClosed())
            con.close();
    }
    
}
