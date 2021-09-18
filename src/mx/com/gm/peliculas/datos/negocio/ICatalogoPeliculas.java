
package mx.com.gm.peliculas.datos.negocio;


public interface ICatalogoPeliculas {
    public void agregraPelicula(String nombrePelicula, String nombreArchivo);
    public void listarPeliculas(String nombreArchivo, String buscar);
    public void inicarArchivo(String nombbreArchivo);
}
