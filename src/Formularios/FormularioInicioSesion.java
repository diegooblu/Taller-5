package Formularios;

import Entidades.LibrosReservas;
import Entidades.Usuario;
import Entidades.Libro;
import Utils.Util;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormularioInicioSesion extends JFrame {

    private JPanel PanelInicioSesion;
    private JTextField campoRut;
    private JTextField campoContrasenia;
    private JButton iniciarSesionButton;
    private JButton cerrarSistemaButton;
    private JTextField camporRutVerificador;
    private final ArrayList<Usuario> listaUsuario;
    private final ArrayList<Libro> listaLibro;
    private final ArrayList<LibrosReservas> listaReservas;
    private FormularioMenu menu;

    /**
     * Constructor de la clase, que ademas iniciaria el formulario de inicioSesion.
     * @param listaUsuario usado para poder traspasar informacion del usuario medianto los formularios.
     * @param listaLibro usado para poder llevar la informacion de los libros a travez de los formularios.
     * @param listaReservas que contendra los libros que hayan sido prestados o devueltos con anterioridad.
     */
    public FormularioInicioSesion (ArrayList<Usuario> listaUsuario, ArrayList<Libro> listaLibro,
                                   ArrayList<LibrosReservas> listaReservas) {
        this.listaUsuario = listaUsuario;
        this.listaLibro = listaLibro;
        this.listaReservas = listaReservas;
        setContentPane(PanelInicioSesion);
        setTitle("Formulario de inicio sesion.");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
        cerrarSistemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarSistema();
            }
        });
    }

    /**
     * Subprograma que permitira al usuario ingresar al sistema y hacer uso de sus acciones, si es
     * que tiene las credenciales correspondientes.
     */
    public void iniciarSesion() {
        try {
            String rut = campoRut.getText();
            String verificador = camporRutVerificador.getText();
            String rutCompleto = rut + "-" + verificador;
            String contrasenia = campoContrasenia.getText();
            //Se usa la variable posicionUsuario para tener en cuenta donde encontrar en la lista al usuario correspondiente.
            int posicionUsuario = -1;
            if (!rut.isEmpty() && !contrasenia.isEmpty()) {
                for (Usuario auxUsuario : listaUsuario) {
                    posicionUsuario++;
                    if (rutCompleto.equalsIgnoreCase(auxUsuario.getRut())) {
                        if (contrasenia.equals(auxUsuario.getContrasenia())) {
                            JOptionPane.showMessageDialog(PanelInicioSesion,auxUsuario.getNombre() +
                                    " " + auxUsuario.getApellido(),"¡Bienvenido!", JOptionPane.PLAIN_MESSAGE);
                            this.menu = new FormularioMenu(listaLibro,listaUsuario,posicionUsuario,listaReservas);
                            dispose();
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(PanelInicioSesion,"¡Datos ingresados erroneos," +
                        " por favor intente nuevamente!","ERROR", JOptionPane.ERROR_MESSAGE);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(PanelInicioSesion,"¡Por favor rellene todos los campos!",
                        "CUIDADO", JOptionPane.WARNING_MESSAGE);
                limpiar();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(PanelInicioSesion,"¡Por favor rellene todos los campos!",
                    "CUIDADO", JOptionPane.WARNING_MESSAGE);
            limpiar();
        }
    }

    /**
     * Metodo que seleccionara el usuario, el cual da fin al programa, realizando una escritura de los datos
     * correspondientes antes del cierre total del mismo.
     */
    public void cerrarSistema() {
        Util.escrituraArchivosReservas(listaReservas);
        Util.escrituraLibros(listaLibro);
        dispose();
    }

    /**
     * Metodo el cual podra ocupar el usuario para limpiar la informacion del formulario si asi lo desea.
     */
    public void limpiar() {
        campoRut.setText("");
        camporRutVerificador.setText("");
        campoContrasenia.setText("");
    }
}
