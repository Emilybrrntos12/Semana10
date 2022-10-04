/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emily Barrientos
 */
public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File (nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        List<Pelicula> peliculas = new ArrayList();
        try {
            BufferedReader entrada = null;
            File archivo = new File(nombreArchivo);
            entrada = new BufferedReader (new FileReader(archivo));
            String linea= null;
            linea = entrada.readLine();
            while(linea != null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra nada");
        }catch(IOException ex){
            System.out.println("Clavos al abrir el arvhivo");
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anaxar) throws EscrituraDatosEx {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo,anaxar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.print("Se ha registrado la pelicula ");
        } catch (Exception e) {
            
        }
    }

    @Override
    public String Buscar(String nombreArchivo, String buscar) throws EscrituraDatosEx {
        
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);
            
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i=1;
            linea = entrada.readLine();
            
            while(linea != null){
                if (buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Peli: "+linea+" encontrada en la linea= "+i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }
            entrada.close();
                    
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro"+ex.getMessage());
        }catch(IOException ex){
            System.out.println("Problema en el archivo"+ex.getMessage());
        }finally{
            try {
                entrada.close();
            } catch (Exception e) {
                System.out.println("Eror al cerrar al archivo");
            }
        }
        
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
       PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            System.out.println("Problema al crear el archivo"+ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("El archivo se elimino");
    }

}
