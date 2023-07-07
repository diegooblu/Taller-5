package Formularios;

import Entidades.Libro;
import Entidades.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormularioDevolverLibro extends JFrame {

    private JPanel PanelDevolverLibro;
    private JTextField campoIsbn;
    private JTextArea textArea1;
    private JButton devolucionButton;
    private JButton volverButton;
    private JButton limpiarButton;
    private JButton buscarButton;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<LibrosReservas> listaReservas;
    private int posicion;
    private FormularioMenu menu;

    public FormularioDevolverLibro (ArrayList<Libro> listaLibros, ArrayList<Usuario> listaUsuarios,
                                    int posicion, ArrayList<LibrosReservas> listaReservas) {
        this.listaLibros = listaLibros;
        this.listaUsuarios = listaUsuarios;
        this.listaReservas = listaReservas;
        this.posicion = posicion;
        setContentPane(PanelDevolverLibro);
        setTitle("Formulario para devolver un libro.");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        devolucionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolucion();
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
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });
    }

    public void devolucion() {

    }

    public void limpiar() {
        campoIsbn.setText("");
        textArea1.setText("");
    }

    public void volver() {
        dispose();
        this.menu = new FormularioMenu(listaLibros,listaUsuarios);
    }

    public void buscar() {
        textArea1.setText("");
        String isbnBuscar = campoIsbn.getText();
        boolean verificador = false;
        if (!isbnBuscar.isEmpty()) {
            for(Libro auxLibro : listaLibros) {
                if (isbnBuscar.equals(auxLibro.getIsbn())) {
                    textArea1.append("ISBN: " + auxLibro.getIsbn() + "\n");
                    textArea1.append("Título: " + auxLibro.getTitulo() + "\n");
                    textArea1.append("Autor: " + auxLibro.getAutor() + "\n");
                    textArea1.append("Genero: " + auxLibro.getGenero() + "\n");
                    textArea1.append("Número de copias: " + auxLibro.getCopias() + "\n");
                    verificador = true;
                }
            }
            if (!verificador) {
                JOptionPane.showMessageDialog(PanelDevolverLibro, "¡ISBN no encontrado, por favor intente nuevamente");
                campoIsbn.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(PanelDevolverLibro,"¡Por favor, rellene los campos correspondientes!");
        }
    }
}
