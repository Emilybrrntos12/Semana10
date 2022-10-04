/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Emily Barrientos
 */
public class ClsPeliculas {
    private int id;
    private String nombre;
    private int año;

    @Override
    public String toString() {
        return "ClsPeliculas{" + "codigo=" + getCodigo() + ", nombre=" + getNombre() + ", a\u00f1o=" + getAño() + '}';
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return id;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.id = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the año
     */
    public int getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(int año) {
        this.año = año;
    }
    
    
}
