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
    private final ArrayList<Libro> listaLibros;
    private final ArrayList<Usuario> listaUsuarios;
    private final int posicion;
    private final ArrayList<LibrosReservas> listaReservas;
    private FormularioMenu menu;

    /**
     * Constructor de la clase que ademas da inicio al formulario de prestarLibro.
     * @param listaLibros de la cual se tomara la informacion del libro a prestar.
     * @param listaUsuarios donde se tomara la informacion del usuario que realizo el prestamo.
     * @param posicion del usuario para encontrarlo en la listaUsuarios.
     * @param listaReservas en el cual se guardara el libro que se presto con sus datos correspondientes.
     */
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

    /**
     * Subprograma que permitira al usuario realizar la accion de prestamo.
     */
    public void prestamo() {
        Usuario auxUsuario = listaUsuarios.get(posicion);
        String isbn = campoIsbn.getText();
        //Variable que se utilizara para poder saber si la accion se llevo a cabo o no.
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
                volver();
                } else {
                JOptionPane.showMessageDialog(PanelPrestarLibro,"¡ISBN no encontrado, " +
                        "por favor intente nuevamente!","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(PanelPrestarLibro,"¡Por favor rellene los campos correspondientes!",
                    "CUIDADO", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Metodo que servira para limpiar la informacion del formulario, lo puede iniciar el usuario tanto como el sistema.
     */
    public void limpiar() {
        campoIsbn.setText("");
        textArea1.setText("");
    }

    /**
     * Metodo que permitira volver al formulario anterior si asi lo desea el usuario.
     */
    public void volver() {
        dispose();
        this.menu = new FormularioMenu(listaLibros,listaUsuarios,posicion,listaReservas);
    }

    /**
     * Metodo en el cual el usuario podra buscar el libro que quiera buscar, para corroborar la informacion del mismo.
     */
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
                JOptionPane.showMessageDialog(PanelPrestarLibro,"¡ISBN no encontrado, " +
                        "por favor intente nuevamente!","ERROR", JOptionPane.ERROR_MESSAGE);
                campoIsbn.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(PanelPrestarLibro,"¡Por favor rellene los campos correspondientes!",
                    "CUIDADO", JOptionPane.WARNING_MESSAGE);
        }
    }
}
