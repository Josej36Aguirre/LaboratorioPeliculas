
package mx.com.gm.peliculas.datos.negocio;


public interface ICatalogoPeliculas {
    String NOMBRE_RECURSO = "peliculas.txt";
    public void agregraPelicula(String nombrePelicula);
    public void listarPeliculas();
    public void buscarPeliculas(String nombrePelicula);
    public void inicarArchivo();
}
