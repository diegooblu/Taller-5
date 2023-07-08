package Formularios;

import Entidades.Libro;
import Entidades.LibrosReservas;
import Entidades.Usuario;
import Utils.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormularioMenu extends JFrame{

    private JPanel PanelMenu;
    private JButton buscarLibroButton;
    private JButton prestarLibroButton;
    private JButton agregarLibroButton;
    private JButton devolverLibroButton;
    private JButton cerrarSesionButton;
    private final ArrayList<Libro> listaLibros;
    private final ArrayList<Usuario> listaUsuarios;
    private final int posicion;
    private final ArrayList<LibrosReservas> listaReservas;
    private FormularioBuscarLibro buscarLibro;
    private FormularioAgregarLibro agregarLibro;
    private FormularioPrestarLibro prestarLibro;
    private FormularioDevolverLibro devolverLibro;
    private FormularioInicioSesion inicioSesion;

    /**
     * Constructor de la clase, que ademas dara inicio al formulario central que seria el menu.
     * @param listaLibro usado para poder llevar la informacion de los libros a travez de los formularios.
     * @param listaUsuarios usado para poder traspasar informacion del usuario medianto los formularios.
     * @param posicion usado para poder traspasar la posicion del usuario mediante los formularios.
     * @param listaReservas que contendra los libros que hayan sido prestados o devueltos con anterioridad.
     */
    public FormularioMenu(ArrayList<Libro> listaLibro, ArrayList<Usuario> listaUsuarios, int posicion, ArrayList<LibrosReservas> listaReservas) {
        this.listaLibros = listaLibro;
        this.listaUsuarios = listaUsuarios;
        this.posicion = posicion;
        this.listaReservas = listaReservas;
        setContentPane(PanelMenu);
        setTitle("Formulario menu principal.");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                buscarLibro();
                dispose();
            }
        });
        prestarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prestarLibro();
                dispose();
            }
        });
        agregarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
                dispose();
            }
        });
        devolverLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolverLibro();
                dispose();
            }
        });
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
                dispose();
            }
        });
    }

    /**
     * Metodo que derivara al usuario al formulario de buscarLibro.
     */
    public void buscarLibro(){
        this.buscarLibro = new FormularioBuscarLibro(listaLibros,listaUsuarios,posicion,listaReservas);
    }

    /**
     * Metodo que derivara al usuario al formulario de prestarLibro.
     */
    public void prestarLibro() {
        this.prestarLibro = new FormularioPrestarLibro(listaLibros,listaUsuarios,posicion,listaReservas);
    }

    /**
     * Metodo que derivara al usuario al formulario de agregarLibro.
     */
    public void agregarLibro(){
        this.agregarLibro = new FormularioAgregarLibro(listaLibros,listaUsuarios,posicion,listaReservas);
    }

    /**
     * Metodo que derivara al usuario al formulario de devolverLirbo.
     */
    public void devolverLibro() {
        this.devolverLibro = new FormularioDevolverLibro(listaLibros,listaUsuarios,posicion,listaReservas);
    }

    /**
     * Metodo que cerrara el formulario de menu y derivara al usuario al formulario de iniciarSesion.
     */
    public void cerrarSesion() {

        this.inicioSesion = new FormularioInicioSesion(listaUsuarios,listaLibros,listaReservas);
    }
}
