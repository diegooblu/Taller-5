package Entidades;

public class Usuario {
    private final String rut;
    private final String nombre;
    private final String apellido;
    private final String contrasenia;

    public Usuario(String rut, String nombre, String apellido, String contrasenia) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
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

    public String getContrasenia() {
        return contrasenia;
    }
}
