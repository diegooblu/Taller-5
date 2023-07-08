package Entidades;

public class Libro {

    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String genero;
    private int copias;
    private final int precio;

    public Libro(String isbn, String titulo, String autor, String genero, int copias, int precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.copias = copias;
        this.precio = precio;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getCopias() {
        return copias;
    }

    public int getPrecio() {
        return precio;
    }
}
