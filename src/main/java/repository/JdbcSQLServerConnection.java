/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thunv
 */
public class JdbcSQLServerConnection {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
 
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
        try {
            String dbURL = "jdbc:sqlserver://DESKTOP-U2G7BLG;databaseName=KT01;integratedSecurity=false";
            conn = DriverManager.getConnection(dbURL,"sa1","1");
            return conn;
 
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
