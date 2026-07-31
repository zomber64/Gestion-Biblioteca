package controlador;

import dao.prestamosDAO;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.prestamos;
import mvcgui.dashboard_prestamos;

public class prestamosController {

    private dashboard_prestamos vista;
    private prestamosDAO dao;

    public prestamosController(dashboard_prestamos vista) {
        this.vista = vista;
        this.dao = new prestamosDAO();

        this.vista.btnRegistar.addActionListener(e -> registrarPrestamo());
        this.vista.btnDevolver.addActionListener(e -> registrarDevolucion());

        listarEnTabla();
    }

    public void listarEnTabla() {
        List<prestamos> lista = dao.listarPrestamos();
        DefaultTableModel model = (DefaultTableModel) vista.tblPrestamos.getModel();
        model.setRowCount(0);

        for (prestamos p : lista) {
            Object[] fila = new Object[]{
                p.getIdPre(),
                p.getNombreUsuario(),
                p.getTituloLibro(),
                p.getFechaPrestamo(),
                p.getFechaDevolucion(),
                p.getEstadoPre()
            };
            model.addRow(fila);
        }
    }

    private void registrarPrestamo() {
        int idUsuario = Integer.parseInt(vista.txtIdUsuario.getText().trim());
        int idLibro = Integer.parseInt(vista.txtIdLibro.getText().trim());

        if (dao.libroEstaPrestado(idLibro)) {
            JOptionPane.showMessageDialog(vista, "El libro ya se encuentra prestado.");
            return;
        }

        prestamos p = new prestamos();
        p.setFkIdUsu(idUsuario);
        p.setFkIdLib(idLibro);
        p.setFechaPrestamo(new Date(System.currentTimeMillis()));
        p.setFechaDevolucion(new Date(System.currentTimeMillis() + (7L * 24 * 60 * 60 * 1000)));

        if (dao.registrarPrestamo(p)) {
            JOptionPane.showMessageDialog(vista, "Préstamo registrado exitosamente.");
            listarEnTabla();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al guardar el préstamo.");
        }
    }

    private void registrarDevolucion() {
        int fila = vista.tblPrestamos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un préstamo de la tabla.");
            return;
        }

        int idPrestamo = Integer.parseInt(vista.tblPrestamos.getValueAt(fila, 0).toString());
        String estado = vista.tblPrestamos.getValueAt(fila, 5).toString();

        if ("devuelto".equalsIgnoreCase(estado)) {
            JOptionPane.showMessageDialog(vista, "Este préstamo ya figura como devuelto.");
            return;
        }

        if (dao.devolverLibro(idPrestamo)) {
            JOptionPane.showMessageDialog(vista, "Devolución registrada correctamente.");
            listarEnTabla();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al registrar la devolución.");
        }
    }
}