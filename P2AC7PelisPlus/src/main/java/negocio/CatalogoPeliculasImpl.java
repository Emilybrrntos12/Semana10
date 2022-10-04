/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.AccesoDatosAdicImpl;
import datos.AccesoDatosImpl;
import datos.IAccesoDatos;
import dominio.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import java.util.List;

/**
 *
 * @author Emily Barrientos
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    //private final IAccesoDatos datos;
    private final datos.AccesoDatosAdicImpl datos;
    
    public CatalogoPeliculasImpl(){
    
        //this.datos = new AccesoDatosImpl();
        this.datos = new AccesoDatosAdicImpl();
    }
    
    
    @Override
    public void agregarPeliculas(String nombrePelicula, String nombreArchivo) {
       Pelicula pelicula = new Pelicula(nombrePelicula);
       boolean anexar = false;
       
        try {
            anexar = datos.existe(nombreArchivo);
            datos.escribir(pelicula, nombreArchivo, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Eror");
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try {
            datos.cargarInformacion(nombreArchivo);
//            List<Pelicula> peliculas = datos.listar(nombreArchivo);
//            System.out.println("====LISTAR PELICULAS====");
//            for(Pelicula peli : peliculas){
//                System.out.println("Peli: "+peli);
//            }
        } catch (Exception e) {
            System.out.println("Clavos con el acceso");
        }
    }

    @Override
    public void buscarPeliculas(String nombreArchivo, String buscar) {
        String resultado = "No se encontro";
        try {
            resultado = datos.Buscar(nombreArchivo, buscar);
        } catch (EscrituraDatosEx ex) {
            System.out.println("Eror al buscar");
        }
        System.out.println("Resultado ="+resultado);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if (datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
            }else{
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx e){
            System.out.println("Error de acceso");
        }
    }
    
}
