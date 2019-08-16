/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DriverDB {
    private static final String BDNAME = "EscuelaDeFutbolTP";
    private static final String USER = "luisk";
    private static final String PASSWORD = "lmuairsy001993";
    private static final String URL = "jdbc:sqlserver://localhost;databaseName=" +
            BDNAME + ";user=" + USER + ";password=" + PASSWORD + ";";
    
    
    static{
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        } catch (Exception ex) {
            Logger.getLogger(co.escuelatp.database.DriverDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private DriverDB() {
    }
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            Logger.getLogger(co.escuelatp.database.DriverDB.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        
        return null;
    } 
}
