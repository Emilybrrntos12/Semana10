/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pelisplus;

import dominio.ClsPeliculas;
import dominio.ClsPeliculasJDBC;
import java.util.*;
//import java.util.Scanner;
//import negocio.CatalogoPeliculas;
//import negocio.CatalogoPeliculasImpl;

/**
 *
 * @author Emily Barrientos
 */
public class PeliculasPlus {
    
    public static void inicio(){
    }
    
    
    public static void main(String[] args) {
        ClsPeliculasJDBC peliculasJDBC = new ClsPeliculasJDBC();
        List<ClsPeliculas> todos =peliculasJDBC.seleccion();
        ClsPeliculas peli = new ClsPeliculas();
        peli.setCodigo(4);
        
        
        //INSERTAR
//        peli.setNombre("Aprueba de Fuego");
//        peli.setAño(2010);
//        peliculasJDBC.insert(peli);
        
        //ACTUALIZAR
//        peli.setNombre("Burbujas");
//        peli.setAño(2021);
//        peliculasJDBC.actualizar(peli);

        //ELIMINAR
        //peliculasJDBC.eliminar(peli);
        
        for(ClsPeliculas pelicula : todos){
            
            System.out.println("Peliculas: "+pelicula.getNombre() +" Año: "+pelicula.getAño());
            
        }
        
        
    }
    

    
//    private static final Scanner scanner = new Scanner (System.in);
//    private static int opcion = -1;
////    private static final String nombreArchivo = "C:\\Users\\emibr\\OneDrive\\Documentos\\Clase8\\mispelis.txt";
////    private static final CatalogoPeliculas catalogoPeli = new CatalogoPeliculasImpl();
//    
//    ClsPeliculasJDBC peliculasJDBC = new ClsPeliculasJDBC();
//    List<ClsPeliculas> todos =peliculasJDBC.seleccion();
//    ClsPeliculas peli = new ClsPeliculas();
//    
//    
//    public static void main(String[] args) {
//          //Mientras la opcion elegida sea 0, preguntamos al usuario
//        while (opcion != 0) {
//            try {
//                System.out.println("Elige opcion:\n1.- Ver listado de peliculas"
//                        + "\n2.- Insertar pelicula\n"
//                        + "3.- Actualizar Peliculas\n"
//                        + "4.- Eliminar Pelicula\n"
//                        + "0.- Salir");
//
//                opcion = Integer.parseInt(scanner.nextLine());
//
//                //Ejemplo de switch case en Java
//                switch (opcion) {
//                    case 1:
//
//                        ClsPeliculasJDBC peliculasJDBC = new ClsPeliculasJDBC();
//                        peliculasJDBC.seleccion();
//                        break;
//                    case 2:
//                        
//                        
//                        //2. agregar informacion archivo
//                        System.out.println("Introduce el nombre de una pelicula a agregar:");
//                        String nombre = scanner.nextLine();
//                        System.out.println("Ingrese el año de la pelicula");
//                        int año = scanner.nextInt();
//                        peliculasJDBC.insert(peli);
//                        catalogoPeli.agregarPeliculas(nombre, nombreArchivo);
//                        break;
//                    case 3:
//                        //3. listar catalogo completo
//                        catalogoPeli.listarPeliculas(nombreArchivo);
//                        break;
//                    case 4:
//                        //4. Buscar pelicula
//                        System.out.println("Introduce el nombre de una pelicula a buscar:");
//                        String buscar = scanner.nextLine();
//                        catalogoPeli.buscarPeliculas(nombreArchivo, buscar);
//                        break;
//                    case 0:
//                        System.out.println("!Hasta pronto!");
//                        break;
//                    default:
//                        System.out.println("Opcion no reconocida");
//                        break;
//                }
//                System.out.println("\n");
//
//            } catch (Exception e) {
//                System.out.println("Error!");
//            }
//        }
//    }
}
