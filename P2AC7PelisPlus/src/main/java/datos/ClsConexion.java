/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

/**
 *
 * @author Emily Barrientos
 */
public class ClsConexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/dbpelis?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PWD="BarrientoS12";
    
     //crear el metodo para conexion
    public static Connection getConnetion() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PWD);
        
    }
    
    //cerrar la conexion
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (Exception e) {
        }
    }
    
    
    public static void close(Connection cn){
        try {
            cn.close();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}
