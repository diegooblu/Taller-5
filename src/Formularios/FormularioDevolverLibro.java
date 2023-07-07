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
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;
    private FormularioMenu menu;

    public FormularioDevolverLibro (ArrayList<Libro> listaLibros, ArrayList<Usuario> listaUsuarios) {
        this.listaLibros = listaLibros;
        this.listaUsuarios = listaUsuarios;
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
}
