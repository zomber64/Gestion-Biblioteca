package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import mvcgui.dashboard_autor;
import mvcgui.dashboard_categoria;
import mvcgui.dashboard_libros;
import mvcgui.dashboard_prestamos;
import mvcgui.dashboard_usuarios;
import mvcgui.login;
import mvcgui.principal;

public class principalController {

    private principal vista;

    public principalController(principal vista) {

        this.vista = vista;

        this.vista.btnUsuarios.addActionListener(e -> abrirUsuarios());
        this.vista.btnCategorias.addActionListener(e -> abrirCategorias());
        this.vista.btnAutores.addActionListener(e -> abrirAutores());
        this.vista.btnLibros.addActionListener(e -> abrirLibros());
        this.vista.btnPrestamos.addActionListener(e -> abrirPrestamos());
        this.vista.btnCerrarSesion.addActionListener(e -> cerrarSesion());

        iniciarReloj();
    }

    private void abrirUsuarios() {
        dashboard_usuarios ventana = new dashboard_usuarios();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void abrirCategorias() {
        dashboard_categoria ventana = new dashboard_categoria();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void abrirAutores() {
        dashboard_autor ventana = new dashboard_autor();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void abrirLibros() {
        dashboard_libros ventana = new dashboard_libros();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void abrirPrestamos() {
        dashboard_prestamos ventana = new dashboard_prestamos();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void cerrarSesion() {

    int opcion = javax.swing.JOptionPane.showConfirmDialog(
            vista,
            "¿Está seguro de que desea cerrar la sesión?",
            "Cerrar Sesión",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE);

    if (opcion == javax.swing.JOptionPane.YES_OPTION) {

        login l = new login();
        l.setLocationRelativeTo(null);
        l.setVisible(true);

        vista.dispose();

    }

}

    private void iniciarReloj() {

        Timer timer = new Timer(1000, e -> {

            Date fecha = new Date();

            vista.lblHora.setText(new SimpleDateFormat("HH:mm:ss").format(fecha));
            vista.lblFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(fecha));

        });

        timer.start();
    }
}