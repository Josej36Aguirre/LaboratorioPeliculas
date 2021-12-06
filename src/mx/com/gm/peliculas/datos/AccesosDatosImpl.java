package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class AccesosDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archiv = new File(nombreArchivo);
        return archiv.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {

        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();

            while (lectura != null) {
                Pelicula peliculaObj = new Pelicula(lectura);
                peliculas.add(peliculaObj);
                lectura = entrada.readLine();
            }
            entrada.close();
            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas" + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
//        existe(nombreArchivo);
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("La pelicula agregada es: " + pelicula);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al Escribir Peliculas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al Escribir Peliculas" + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {

        File archivo = new File(nombreArchivo);
        BufferedReader entrada;
        String datoEncontrado = null;
        try {
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            
            int indice = 1;
            while (linea !=null) {                
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    datoEncontrado = "Pelicula: "+linea +" encontrada en el indice: "+indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al Buscar pelicula: " + ex.getMessage());
        }catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al Buscar la Pelicula: " + ex.getMessage());
        }

        
        return datoEncontrado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        existe(nombreArchivo);
        File archivo = new File(nombreArchivo);
        PrintWriter salida;
        try {
            salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
             ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al Buscar la Pelicula: " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        existe(nombreArchivo);
        File fichero = new File(nombreArchivo);
        if (fichero.exists()) {
            fichero.delete();
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero no puede ser borrado");
        }
    }
}
