package Utils;

import Entidades.Libro;
import Entidades.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Marcelo Céspedes.
 */

public class Util {

    /* Para la correcta lectura de los archivos, estos deben estan en la carpeta del proyecto, fuera
    de la carpeta "src". */

    /**
     * Método encargado de leer el archivo de "libros.txt".
     */
    public static void leerArchivoLibros(ArrayList<Libro> listaLibros) {

        // Leer el archivo "libros.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String isbn = chain[0];
                String title = chain[1];
                String author = chain[2];
                String category = chain[3];
                int copies = Integer.parseInt(chain[4]);
                int price = Integer.parseInt(chain[5]);

                //TODO: Eliminar los print, solo están de prueba para saber si el archivo se leyó correctamente.
                /*
                System.out.println("ISBN: " + isbn);
                System.out.println("Título: " + title);
                System.out.println("Autor: " + author);
                System.out.println("Categoría: " + category);
                System.out.println("Número de copias: " + copies);
                System.out.println("Precio: " + price);
                System.out.println("-----------------------------");
                */

                //TODO: Guardar el libro en algúna estructura de datos.
                Libro libro = new Libro(isbn,title,author,category,copies,price);
                listaLibros.add(libro);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Método encargado de leer el archivo de "usuarios.txt".
     */
    public static void leerArchivoUsuarios(ArrayList<Usuario> listaUsuario) {

        // Leer el archivo "usuarios.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String rut = chain[0];
                String name = chain[1];
                String lastname = chain[2];
                String password = chain[3];

                /*
                //TODO: Eliminar los print, solo están de prueba para saber si el archivo se leyó correctamente.
                System.out.println("RUT: " + rut);
                System.out.println("Nombre: " + name);
                System.out.println("Apellido: " + lastname);
                System.out.println("Contraseña: " + password);
                System.out.println("-----------------------------");
                 */

                //TODO: Guardar el usuario en algúna estructura de datos.
                Usuario usuario = new Usuario(rut,name,lastname,password);
                listaUsuario.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}