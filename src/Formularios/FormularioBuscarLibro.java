package Formularios;

import Entidades.Libro;
import Entidades.LibrosReservas;
import Entidades.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FormularioBuscarLibro extends JFrame {

    private JPanel PanelBuscar;
    private JTextField campoIsbnBuscar;
    private JButton buscarButton;
    private JTextArea textArea1;
    private JButton volverButton;
    private final ArrayList<Libro> listaLibros;
    private final ArrayList<Usuario> listaUsuarios;
    private final ArrayList<LibrosReservas> listaReservas;
    private final int posicion;
    private FormularioMenu menu;

    /**
     * Constructor de la clase, en el cual se iniciara el formulario de buscarLibro.
     * @param listaLibros donde se encontrara la informacion de los libros.
     * @param listaUsuarios usado para poder traspasar informacion del usuario medianto los formularios.
     * @param posicion usado para poder traspasar la posicion del usuario mediante los formularios.
     * @param listaReservas usado para traspasar la informacion mediante los formularios.
     */
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

    /**
     * Subprograma que permitira al usuario recibir la informacion del libro a buscar.
     */
    public void buscar() {
        textArea1.setText("");
        String isbnBuscar = campoIsbnBuscar.getText();
        //Variable creada para en su posterioridad saber si se pudo realizar la accion o no.
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
                JOptionPane.showMessageDialog(PanelBuscar,"¡ISBN no encontrado, " +
                        "por favor intente nuevamente!","ERROR", JOptionPane.ERROR_MESSAGE);
                campoIsbnBuscar.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(PanelBuscar,"¡Por favor rellene los campos correspondientes!",
                    "CUIDADO", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Metodo que permitira al usuario volver al formulario anterior si asi lo desea.
     */
    public void volver() {
        dispose();
        this.menu = new FormularioMenu(listaLibros,listaUsuarios,posicion,listaReservas);
    }
}
