package Formularios;

import Entidades.Libro;
import Entidades.LibrosReservas;
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
    private final ArrayList<Libro> listaLibros;
    private final ArrayList<Usuario> listaUsuarios;
    private final ArrayList<LibrosReservas> listaReservas;
    private final int posicion;
    private FormularioMenu menu;

    /**
     * Constructor de la clase, donde se inicia el formulario devolverLibro.
     * @param listaLibros de la cual se tomara la informacion del libro a devolver.
     * @param listaUsuarios donde se tomara la informacion del usuario que realizo la devolucion.
     * @param posicion del usuario para encontrarlo en la listaUsuarios.
     * @param listaReservas en el cual se guardara el libro que se devolvio con sus datos correspondientes.
     */
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

    /**
     * Subprograma que permitira al usuario realizar una devolucion de un libro si este existe.
     */
    public void devolucion() {
        Usuario auxUsuario = listaUsuarios.get(posicion);
        String isbn = campoIsbn.getText();
        //Variable que se utilizara para poder saber si la accion se llevo a cabo o no.
        boolean verificar = false;
        if (!isbn.isEmpty()){
            for (Libro auxLibro : listaLibros) {
                if(isbn.equals(auxLibro.getIsbn())){
                    auxLibro.setCopias(auxLibro.getCopias()+1);
                    LibrosReservas auxLibroReserva = new LibrosReservas(auxUsuario.getRut(),auxUsuario.getNombre(),
                            auxUsuario.getApellido(),auxLibro.getIsbn(), auxLibro.getTitulo(),"devolucion");
                    listaReservas.add(auxLibroReserva);
                    verificar = true;
                    break;
                }
            }
            if (verificar){
                JOptionPane.showMessageDialog(PanelDevolverLibro,"¡Devolucion exitosa!");
                volver();
            } else {
                //Mensaje de fallo, y se le da una recomendacion al usuario.
                JOptionPane.showMessageDialog(PanelDevolverLibro,"¡Libro no registrado!"
                        + "\n" + "Si desea agregar el libro, dirigase en el menu a la pestaña agreagar.");
            }
        }
        else {
            JOptionPane.showMessageDialog(PanelDevolverLibro,"¡Por favor rellene los campos correspondientes!",
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
        //Variable que se utilizara para poder saber si la accion se llevo a cabo o no.
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
                JOptionPane.showMessageDialog(PanelDevolverLibro,"¡ISBN no encontrado, " +
                        "por favor intente nuevamente!","ERROR", JOptionPane.ERROR_MESSAGE);
                campoIsbn.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(PanelDevolverLibro,"¡Por favor rellene los campos correspondientes!",
                    "CUIDADO", JOptionPane.WARNING_MESSAGE);
        }
    }
}
