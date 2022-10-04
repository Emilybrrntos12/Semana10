/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import datos.ClsConexion;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Emily Barrientos
 */
public class ClsPeliculasJDBC {
    private static final String SQL_SELECT = "SELECT * FROM TB_PELICULAS";
    private static final String SQL_INSERT= "insert into tb_peliculas(nombre,año) values (?,?)";//
    private static final String SQL_UPDATE = "update tb_peliculas set nombre=?, año=? where id=?";
    private static final String SQL_DELETE = "delete from tb_peliculas where id=?";
    
     public List<ClsPeliculas> seleccion(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClsPeliculas pelicula = null;
        List<ClsPeliculas> peliculas = new ArrayList<ClsPeliculas>();
        
        try {
            conn = ClsConexion.getConnetion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int año = rs.getInt("año");
                
                
                pelicula = new ClsPeliculas();
                pelicula.setCodigo(id);
                pelicula.setNombre(nombre);
                pelicula.setAño(año);
                peliculas.add(pelicula);
            }
            
        } catch (SQLException ex) {
            System.out.println("Hay clavo"+ex.getMessage());
        }finally{
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return peliculas;
    }
     
     public int insert(ClsPeliculas pelicula){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnetion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pelicula.getNombre());
            stmt.setInt(2, pelicula.getAño());
            rows = stmt.executeUpdate();
            System.out.println("Registos afectados= "+rows);
        } catch (SQLException ex) {
            System.out.println("Error insertar: "+ex.getMessage());
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;
    }
     
     public int actualizar(ClsPeliculas pelicula){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnetion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pelicula.getNombre());
            stmt.setInt(2, pelicula.getAño());
            stmt.setInt(3, pelicula.getCodigo());
            
            rows = stmt.executeUpdate();
            System.out.println("Registos afectados= "+rows);
        } catch (SQLException ex) {
            System.out.println("Error insertar: "+ex.getMessage());
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;
    }
     
     public int eliminar(ClsPeliculas pelicula){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnetion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pelicula.getCodigo());
            
            rows = stmt.executeUpdate();
            System.out.println("Registos afectados= "+rows);
        } catch (SQLException ex) {
            System.out.println("Error insertar: "+ex.getMessage());
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;
    }
}
