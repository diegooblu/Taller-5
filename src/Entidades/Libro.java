package Entidades;

public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private String genero;
    private int copias;
    private double precio;

    public Libro(String isbn, String titulo, String autor, String genero, int copias, double precio) {
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

    public double getPrecio() {
        return precio;
    }
}
