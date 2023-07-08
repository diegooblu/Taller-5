package Utils;

import Entidades.Libro;
import Entidades.LibrosReservas;
import Entidades.Usuario;
import ucn.ArchivoSalida;
import ucn.Registro;
import java.io.*;
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
                //TODO: Guardar el usuario en algúna estructura de datos.
                Usuario usuario = new Usuario(rut,name,lastname,password);
                listaUsuario.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Metodo encargado de leer el archivo de "reservas.txt".
     * @param listaLibrosReservados donde estaran los datos a leer.
     */
    public static void leerArchivosReservas(ArrayList<LibrosReservas> listaLibrosReservados) {
        // Leer el archivo "usuarios.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("reservas.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String rut = chain[0];
                String name = chain[1];
                String lastname = chain[2];
                String isbn = chain[3];
                String titulo = chain[4];
                String accion = chain[5];
                LibrosReservas libroReservado = new LibrosReservas(rut,name,lastname,isbn,titulo,accion);
                listaLibrosReservados.add(libroReservado);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Metodo encargado de realizar la escritura del archivo "reservas.txt".
     * @param listaReservas donde estaran los datos a reescribir en .txt.
     */
    public static void escrituraArchivosReservas(ArrayList<LibrosReservas> listaReservas) {
        try {
            //Utilizamos el metodo de ArchivoSalida, esto por algunoss problemas con BufferedWriter
            ArchivoSalida archSal = new ArchivoSalida("reservas.txt");
            for (LibrosReservas auxReserva : listaReservas) {
                Registro regSal = new Registro(6);
                regSal.agregarCampo(auxReserva.getRut());
                regSal.agregarCampo(auxReserva.getNombre());
                regSal.agregarCampo(auxReserva.getApellido());
                regSal.agregarCampo(auxReserva.getISBN());
                regSal.agregarCampo(auxReserva.getTitulo());
                regSal.agregarCampo(auxReserva.getAccion());
                archSal.writeRegistro(regSal);
            }
        }
        catch (IOException e) {
            System.out.println("¡Ha ocurrido un error al modificar un archivo!");
            e.printStackTrace();
        }
    }

    /**
     * Metodo encargado de la escritura del archivo "libros.txt".
     * @param listaLibros con los datos a escribir en .txt.
     */
    public static void escrituraLibros(ArrayList<Libro> listaLibros){
        try {
            //Utilizamos el metodo de ArchivoSalida, esto por algunoss problemas con BufferedWriter
            ArchivoSalida archSal = new ArchivoSalida("libros.txt");
            for (Libro auxLibro : listaLibros) {
                Registro regSal = new Registro(6);
                regSal.agregarCampo(auxLibro.getIsbn());
                regSal.agregarCampo(auxLibro.getTitulo());
                regSal.agregarCampo(auxLibro.getAutor());
                regSal.agregarCampo(auxLibro.getGenero());
                regSal.agregarCampo(auxLibro.getCopias());
                regSal.agregarCampo(auxLibro.getPrecio());
                archSal.writeRegistro(regSal);
            }
        }
        catch (IOException e){
            System.out.println("¡Ha ocurrido un error al modificar un archivo!");
            e.printStackTrace();
        }
    }
}