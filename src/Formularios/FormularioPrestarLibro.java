package Formularios;

import Entidades.Libro;
import Entidades.LibrosReservas;
import Entidades.Usuario;

import javax.swing.*;
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
    private JButton buscarButton;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;
    private int posicion;
    private ArrayList<LibrosReservas> listaReservas;
    private FormularioMenu menu;

    public FormularioPrestarLibro(ArrayList<Libro> listaLibros, ArrayList<Usuario> listaUsuarios, int posicion, ArrayList<LibrosReservas> listaReservas) {
        this.listaLibros = listaLibros;
        this.listaUsuarios = listaUsuarios;
        this.posicion = posicion;
        this.listaReservas = listaReservas;
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
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });
    }

    public void prestamo() {
        Usuario auxUsuario = listaUsuarios.get(posicion);
        String isbn = campoIsbn.getText();
        boolean verificar = false;
        if (!isbn.isEmpty()) {
            for (Libro auxLibro : listaLibros) {
                if (isbn.equals(auxLibro.getIsbn())) {
                    if (auxLibro.getCopias() > 0){
                        auxLibro.setCopias(auxLibro.getCopias() - 1);
                        LibrosReservas auxLibroReserva = new LibrosReservas(auxUsuario.getRut(), auxUsuario.getNombre(), auxUsuario.getApellido(), auxLibro.getIsbn(), auxLibro.getTitulo(), "prestamo");
                        listaReservas.add(auxLibroReserva);
                        verificar = true;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(PanelPrestarLibro,"¡No quedan mas copias del libro, lo sentimos!");
                    }
                }
            }
            if (verificar) {
                JOptionPane.showMessageDialog(PanelPrestarLibro,"¡Prestamo realizado con éxito!");
                dispose();
                } else {
                JOptionPane.showMessageDialog(PanelPrestarLibro,"¡ISBN no encontrado, por favor intente nuevamente!");
            }
        } else {
            JOptionPane.showMessageDialog(PanelPrestarLibro,"¡Por favor, rellene los campos correspondientes!");
        }
    }

    public void limpiar() {
        campoIsbn.setText("");
        textArea1.setText("");
    }

    public void volver() {
        dispose();
        this.menu = new FormularioMenu(listaLibros,listaUsuarios,posicion,listaReservas);
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
                JOptionPane.showMessageDialog(PanelPrestarLibro, "¡ISBN no encontrado, por favor intente nuevamente");
                campoIsbn.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(PanelPrestarLibro,"¡Por favor, rellene los campos correspondientes!");
        }
    }
}
