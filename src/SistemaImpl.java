import Entidades.Libro;
import Entidades.LibrosReservas;
import Entidades.Usuario;
import Formularios.FormularioInicioSesion;
import Utils.Util;

import java.util.ArrayList;

public class SistemaImpl implements Sistema{

    private final ArrayList<Usuario> listaUsuario;
    private final ArrayList<Libro> listaLibro;
    private final ArrayList<LibrosReservas> listaReservas;
    private FormularioInicioSesion inicioSesion;

    /**
     *Subprograma base, se crean e inician los arreglos a utilizar, ademas de leer los archivos
     * necesarios para la implementacion del codigo.
     */
    public SistemaImpl() {
        this.listaUsuario = new ArrayList<>();
        this.listaLibro = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
        Util.leerArchivoUsuarios(listaUsuario);
        Util.leerArchivoLibros(listaLibro);
        Util.leerArchivosReservas(listaReservas);
    }

    /**
     *Subprograma que inicia el formulario de inicio de sesion, el cual da paso a todos los siguientes, donde
     * el usuario podra navegar y realizar acciones.
     */
    @Override
    public void iniciarSistema() {
        this.inicioSesion = new FormularioInicioSesion(listaUsuario,listaLibro,listaReservas);
    }
}
