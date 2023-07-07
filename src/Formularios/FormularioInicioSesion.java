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
    private ArrayList<Usuario> listaUsuario;
    private ArrayList<Libro> listaLibro;
    private ArrayList<LibrosReservas> listaReservas;
    private FormularioMenu menu;

    public FormularioInicioSesion (ArrayList<Usuario> listaUsuario, ArrayList<Libro> listaLibro, ArrayList<LibrosReservas> listaReservas) {
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

    public void iniciarSesion() {
        try {
            String rut = campoRut.getText();
            String verificador = camporRutVerificador.getText();
            String rutCompleto = rut + "-" + verificador;
            String contrasenia = campoContrasenia.getText();
            int posicionUsuario = -1;
            if (!rut.isEmpty() && !contrasenia.isEmpty()) {
                for (Usuario auxUsuario : listaUsuario) {
                    posicionUsuario++;
                    if (rutCompleto.equalsIgnoreCase(auxUsuario.getRut())) {
                        if (contrasenia.equals(auxUsuario.getContrasenia())) {
                            this.menu = new FormularioMenu(listaLibro,listaUsuario,posicionUsuario,listaReservas);
                            dispose();
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(PanelInicioSesion, "¡Datos ingresados erroneos, por favor intente nuevamente!");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(PanelInicioSesion,"¡Por favor rellene todos los campos!");
                limpiar();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(PanelInicioSesion,"¡Datos ingresados erroneos, por favor intente nuevamente!");
            limpiar();
        }
    }

    public void cerrarSistema() {
        Util.escrituraArchivosReservas(listaReservas);
        Util.escrituraLibros(listaLibro);
        dispose();
    }

    public void limpiar() {
        campoRut.setText("");
        camporRutVerificador.setText("");
        campoContrasenia.setText("");
    }
}
