package Formularios;

import Entidades.Libro;
import Entidades.Usuario;

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
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;
    private FormularioBuscarLibro buscarLibro;
    private FormularioAgregarLibro agregarLibro;
    private FormularioPrestarLibro prestarLibro;
    private FormularioDevolverLibro devolverLibro;
    private FormularioInicioSesion inicioSesion;

    public FormularioMenu(ArrayList<Libro> listaLibro, ArrayList<Usuario> listaUsuarios) {
        this.listaLibros = listaLibro;
        this.listaUsuarios = listaUsuarios;
        setContentPane(PanelMenu);
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
    public void buscarLibro(){
        this.buscarLibro = new FormularioBuscarLibro(listaLibros,listaUsuarios);
    }
    public void prestarLibro() {
        this.prestarLibro = new FormularioPrestarLibro(listaLibros,listaUsuarios);
    }
    public void agregarLibro(){
        this.agregarLibro = new FormularioAgregarLibro(listaLibros,listaUsuarios);
    }
    public void devolverLibro() {
        this.devolverLibro = new FormularioDevolverLibro(listaLibros,listaUsuarios);
    }
    public void cerrarSesion() {
        this.inicioSesion = new FormularioInicioSesion(listaUsuarios,listaLibros);
    }
}
