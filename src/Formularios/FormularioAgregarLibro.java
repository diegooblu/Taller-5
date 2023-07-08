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
    private final ArrayList<Libro> listaLibro;
    private final ArrayList<Usuario> listaUsuario;
    private final ArrayList<LibrosReservas> listaReservas;
    private final int posicion;
    private FormularioMenu menu;

    /**
     * Constructor de la clase, donde tambien se inicia el formulario para agregar libro.
     * @param listaLibros donde se guardaran los datos ingresados si es que se ingresa un nuevo libro.
     * @param listaUsuario usado para poder traspasar informacion del usuario medianto los formularios.
     * @param posicion usado para poder traspasar la posicion del usuario mediante los formularios.
     * @param listaReservas usado para traspasar la informacion mediante los formularios.
     */
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

    /**
     * Subprograma que podra hacer que el usuario agregue un libro al inventario de la biblioteca.
     */
    public void agregarLibro() {
        String isbn = campoIsbn.getText();
        String titulo = campoTitulo.getText();
        String autor = campoAutor.getText();
        String genero = campoGenero.getText();
        String numeroCopias = campoNCopias.getText();
        String precio = campoPrecio.getText();
        if (!isbn.isEmpty() && !titulo.isEmpty() && !autor.isEmpty() && !genero.isEmpty() && !numeroCopias.isEmpty() && !precio.isEmpty()) {
            int copias = 0;
            int preciolibro = 0;
            //try catch para poder verificar el ingreso de datos en los campos copias y precioLibro.
            try {
                copias = Integer.parseInt(numeroCopias);
                preciolibro = Integer.parseInt(precio);
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(PanelAgregarLibro,"¡En los datos: Numero de Copias y Precio," +
                        " utilizar caracteres numericos!", "CUIDADO", JOptionPane.WARNING_MESSAGE);
                limpiar();
                return;
            }
            //Variable creada para su posterior uso, para poder ver si se realizo o no la accion.
            boolean verificar = false;
            for (Libro auxLibro : listaLibro) {
                if (isbn.equals(auxLibro.getIsbn())) {
                    verificar = true;
                    break;
                }
            }
            //Se evalua la variable y se mensaje de exito o fallo.
            if (!verificar) {
                Libro nuevoLibro = new Libro(isbn, titulo, autor, genero, copias, preciolibro);
                listaLibro.add(nuevoLibro);
                JOptionPane.showMessageDialog(PanelAgregarLibro, "¡Libro registrado con éxito!");
            } else {
                JOptionPane.showMessageDialog(PanelAgregarLibro,"¡No se pudo registrar el libro," +
                        " por favor intente nuevamente!","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(PanelAgregarLibro,"¡Por favor rellene los campos correspondientes!",
                    "CUIDADO", JOptionPane.WARNING_MESSAGE);
            limpiar();
        }
    }

    /**
     * Metodo que sirve para limpiar el formulario, lo puede accionar el usuario o el mismo sistema.
     */
    public void limpiar() {
        campoIsbn.setText("");
        campoTitulo.setText("");
        campoAutor.setText("");
        campoGenero.setText("");
        campoNCopias.setText("");
        campoPrecio.setText("");
    }

    /**
     * Metodo con el cual el usuario puede volver al formulario anterior si asi lo desea.
     */
    public void volver() {
        dispose();
        this.menu = new FormularioMenu(listaLibro,listaUsuario,posicion,listaReservas);
    }
}
