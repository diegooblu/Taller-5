package Formularios;

import Entidades.Libro;
import Entidades.LibrosReservas;
import Entidades.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormularioAgregarLibro extends JFrame {
    private JPanel PanelAgregarLibro;
    private JTextField campoIsbn;
    private JTextField campoTitulo;
    private JTextField campoAutor;
    private JTextField campoGenero;
    private JTextField campoNCopias;
    private JButton agregarButton;
    private JButton limpiarButton;
    private JButton volverButton;
    private JTextField campoPrecio;
    private ArrayList<Libro> listaLibro;
    private ArrayList<Usuario> listaUsuario;
    private ArrayList<LibrosReservas> listaReservas;
    private int posicion;
    private FormularioMenu menu;

    public FormularioAgregarLibro (ArrayList<Libro> listaLibros, ArrayList<Usuario> listaUsuario, int posicion, ArrayList<LibrosReservas> listaReservas) {
        this.listaLibro = listaLibros;
        this.listaUsuario = listaUsuario;
        this.posicion = posicion;
        this.listaReservas = listaReservas;
        setContentPane(PanelAgregarLibro);
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
    }

    public void agregarLibro() {
        String isbn = campoIsbn.getText();
        String titulo = campoTitulo.getText();
        String autor = campoAutor.getText();
        String genero = campoGenero.getText();
        String numeroCopias = campoNCopias.getText();
        String precio = campoPrecio.getText();
        if (!isbn.isEmpty() && !titulo.isEmpty() && !autor.isEmpty() && !genero.isEmpty() && !numeroCopias.isEmpty() && !precio.isEmpty()) {
            int copias = Integer.parseInt(numeroCopias);
            int preciolibro = Integer.parseInt(precio);
            boolean verificar = false;
            for (Libro auxLibro : listaLibro) {
                if (isbn.equals(auxLibro.getIsbn())) {
                    verificar = true;
                    break;
                }
            }
            if (!verificar) {
                Libro nuevoLibro = new Libro(isbn, titulo, autor, genero, copias, preciolibro);
                listaLibro.add(nuevoLibro);
                JOptionPane.showMessageDialog(PanelAgregarLibro, "¡Libro registrado con éxito!");
            } else {
                JOptionPane.showMessageDialog(PanelAgregarLibro, "¡No se pudo registrar el libro, intente nuevamente!");
            }
        } else {
            JOptionPane.showMessageDialog(PanelAgregarLibro,"¡Por favor rellene todos los campos!");
            limpiar();
        }
    }

    public void limpiar() {
        campoIsbn.setText("");
        campoTitulo.setText("");
        campoAutor.setText("");
        campoGenero.setText("");
        campoNCopias.setText("");
        campoPrecio.setText("");
    }

    public void volver() {
        dispose();
        this.menu = new FormularioMenu(listaLibro,listaUsuario,posicion,listaReservas);
    }
}
