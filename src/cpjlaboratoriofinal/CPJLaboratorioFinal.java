package cpjlaboratoriofinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mx.com.gm.peliculas.datos.AccesosDatosImpl;
import mx.com.gm.peliculas.datos.negocio.CatalogoPeliculasImpl;
import mx.com.gm.peliculas.datos.negocio.ICatalogoPeliculas;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class CPJLaboratorioFinal {

    public static void main(String[] args) throws LecturaDatosEx {
        int opcion = -1;
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        
        String nombreArchivo = "c:\\catalogoPeliculas\\películas.txt";
        List listPeliculas = new ArrayList();
        Scanner sc = new Scanner(System.in);

        while (opcion != 0) {
            System.out.println("Elige una opcion\n"
                    + "1. Iniciar catalogo de peliculas\n"
                    + "2. Agregar peliculas\n"
                    + "3. Listar peliculas\n"
                    + "4. Buscar pelicula\n"
                    + "0. Salir");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    catalogo.inicarArchivo();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la pelicula:");
                    String nombrePelicula = sc.nextLine();
                    catalogo.agregraPelicula(nombrePelicula);
                    break;
                case 3:
                   catalogo.listarPeliculas();                    
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la pelicula a buscar");
                    String datoBuscar = sc.nextLine();
                    catalogo.buscarPeliculas(datoBuscar);
                    break;
                case 0:
                    System.out.println("Adios..");
                    break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
            }
        }

    }
}
