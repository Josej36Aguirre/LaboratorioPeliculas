
package mx.com.gm.peliculas.datos.negocio;

import java.util.ArrayList;
import java.util.List;

import mx.com.gm.peliculas.datos.AccesosDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;


public class CatalogoPeliculasImpl implements ICatalogoPeliculas{
    
    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos =new  AccesosDatosImpl();
    }
    
    

    @Override
    public void agregraPelicula(String nombrePelicula) {
        try {
            Pelicula nombrePeli = new Pelicula(nombrePelicula);
            boolean anexar = false;
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(nombrePeli, NOMBRE_RECURSO, anexar);
                      
        } catch (AccesoDatosEx ex) {
            System.out.println("Agregar pelicula - error en acceso adatos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            List<Pelicula> list = new ArrayList();
            list =  this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : list) {
                System.out.println("Pelicula = "+pelicula);   
            }
           
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos en listarPeliculas");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void inicarArchivo() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de pelikculas");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPeliculas(String nombrePelicula) {
         String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, nombrePelicula);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos en buscarPeliculas: ");
            ex.printStackTrace(System.out);
        }
        System.out.println("Pelicula no encontrada = " + resultado);
    }
    
}
