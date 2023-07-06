import Entidades.Libro;
import Entidades.Usuario;
import Formularios.FormularioInicioSesion;
import Utils.Util;

import java.util.ArrayList;

public class SistemaImpl implements Sistema{

    private ArrayList<Usuario> listaUsuario;
    private ArrayList<Libro> listaLibro;
    private FormularioInicioSesion inicioSesion;

    public SistemaImpl() {
        this.listaUsuario = new ArrayList<>();
        this.listaLibro = new ArrayList<>();
        Util.leerArchivoUsuarios(listaUsuario);
        Util.leerArchivoLibros(listaLibro);
    }

    public void IniciarSistema() {
        this.inicioSesion = new FormularioInicioSesion(listaUsuario,listaLibro);
    }
}
