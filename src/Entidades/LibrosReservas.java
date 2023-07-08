package Entidades;

public class LibrosReservas {

    private final String rut;
    private final String nombre;
    private final String apellido;
    private final String ISBN;
    private final String titulo;
    private final String accion;

    public LibrosReservas(String rut, String nombre, String apellido, String ISBN, String titulo, String accion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.accion = accion;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAccion() {
        return accion;
    }
}
