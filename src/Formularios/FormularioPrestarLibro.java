package Formularios;

import Entidades.Libro;
import Entidades.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormularioPrestarLibro extends JFrame {

    private JPanel PanelPrestarLibro;
    private JTextField campoIsbn;
    private JTextArea textArea1;
    private JButton prestamoButton;
    private JButton volverButton;
    private JButton limpiarButton;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;
    private FormularioMenu menu;

    public FormularioPrestarLibro(ArrayList<Libro> listaLibros, ArrayList<Usuario> listaUsuarios) {
        this.listaLibros = listaLibros;
        this.listaUsuarios = listaUsuarios;
        setContentPane(PanelPrestarLibro);
        setTitle("Formulario para prestar un libro.");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        prestamoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prestamo();
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

    public void prestamo() {

    }

    public void limpiar() {
        campoIsbn.setText("");
        textArea1.setText("");
    }

    public void volver() {
        dispose();
        this.menu = new FormularioMenu(listaLibros,listaUsuarios);
    }
}
