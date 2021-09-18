
package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mx.com.gm.peliculas.domain.Pelicula;


public class AccesosDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) {
        if (nombreArchivo!=null) {
            System.out.println("El archivo ya existe");
            return true;
            
        } else {
            System.out.println("El archivo no existe");
            return false;
        }
  
    }

    @Override
    public List listar(String nombreArchivo) {
        
         File archivo = new File(nombreArchivo);
          List listaLectura = new ArrayList();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
             String lectura = entrada.readLine();
            
            while(lectura != null){
                System.out.println("lectura = " + lectura);
                listaLectura.add(entrada.readLine());
            }
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    return listaLectura;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
         File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado La Pelicula");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        Scanner sc=new Scanner(System.in);
        try {
    do {
        BufferedReader br=new BufferedReader(new FileReader(nombreArchivo));
        System.out.println("Introduzca el nombre de la pelicula a buscar: ");
        buscar="Pelicula: "+sc.nextLine();

        String linea="";
        boolean encontrado = false;
        while ((linea= br.readLine())!=null) {

            if(linea.equalsIgnoreCase(buscar)) {
                System.out.println(linea);

                for(int i=0;i<2;i++) {
                    System.out.println(br.readLine());
                }   
                encontrado = true;
                break;

            }

        }

        if(!encontrado) 
            System.out.println("La pelicula no existe");

            System.out.println("¿Quieres introducir otro nombre?");
            buscar=sc.nextLine();



    }while(buscar.equalsIgnoreCase("si"));
} catch (IOException e) {

    System.out.println("Error");
}
        return buscar;
    }

    @Override
    public void crear(String nombreArchivo) {|
            
            
            
            
            
    }

    @Override
    public void borrar(String nombreArchivo) {
    }
    
}
