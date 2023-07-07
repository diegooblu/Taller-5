import Entidades.Libro;
import Entidades.LibrosReservas;
import Entidades.Usuario;
import Formularios.FormularioInicioSesion;
import Utils.Util;

import java.util.ArrayList;

public class SistemaImpl implements Sistema{

    private ArrayList<Usuario> listaUsuario;
    private ArrayList<Libro> listaLibro;
    private ArrayList<LibrosReservas> listaReservas;
    private FormularioInicioSesion inicioSesion;

    public SistemaImpl() {
        this.listaUsuario = new ArrayList<>();
        this.listaLibro = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
        Util.leerArchivoUsuarios(listaUsuario);
        Util.leerArchivoLibros(listaLibro);
        Util.leerArchivosReservas(listaReservas);
    }

    public void IniciarSistema() {
        this.inicioSesion = new FormularioInicioSesion(listaUsuario,listaLibro,listaReservas);
    }
}
