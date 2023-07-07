package Formularios;

import Entidades.Libro;
import Entidades.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormularioBuscarLibro extends JFrame {

    private JPanel PanelBuscar;
    private JTextField campoIsbnBuscar;
    private JButton buscarButton;
    private JTextArea textArea1;
    private JButton volverButton;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<LibrosReservas> listaReservas;
    private int posicion;
    private FormularioMenu menu;

    public FormularioBuscarLibro (ArrayList<Libro> listaLibros, ArrayList<Usuario> listaUsuarios, int posicion, ArrayList<LibrosReservas> listaReservas) {
        this.listaLibros = listaLibros;
        this.listaUsuarios = listaUsuarios;
        this.listaReservas = listaReservas;
        this.posicion = posicion;
        setContentPane(PanelBuscar);
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
    }

    public void buscar() {
        textArea1.setText("");
        String isbnBuscar = campoIsbnBuscar.getText();
        boolean verificador = false;
        if (!isbnBuscar.isEmpty()) {
            for(Libro auxLibro : listaLibros) {
                if (isbnBuscar.equals(auxLibro.getIsbn())) {
                    textArea1.append("ISBN: " + auxLibro.getIsbn() + "\n");
                    textArea1.append("Título: " + auxLibro.getTitulo() + "\n");
                    textArea1.append("Autor: " + auxLibro.getAutor() + "\n");
                    textArea1.append("Genero: " + auxLibro.getGenero() + "\n");
                    textArea1.append("Número de copias: " + auxLibro.getCopias() + "\n");
                    textArea1.append("\n");
                    textArea1.append("¡Ingrese otro ISBN para buscar otro libro!");
                    verificador = true;
                    campoIsbnBuscar.setText("");
                }
            }
            if (!verificador) {
                JOptionPane.showMessageDialog(PanelBuscar, "¡ISBN no encontrado, por favor intente nuevamente");
                campoIsbnBuscar.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(PanelBuscar,"¡Por favor, rellene los campos correspondientes!");
        }
    }

    public void volver() {
        dispose();
        this.menu = new FormularioMenu(listaLibros,listaUsuarios,posicion,listaReservas);
    }
}
