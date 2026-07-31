package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion;
import modelo.prestamos;

public class prestamosDAO {

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    // Guardar nuevo préstamo en la BD
    public boolean registrarPrestamo(prestamos p) {
        String sql = "INSERT INTO prestamos (fecha_prestamo, fecha_devolucion, estado_pre, fk_id_usu, fk_id_lib) VALUES (?, ?, 'prestado', ?, ?)";
        try {
            cn = conexion.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setDate(1, p.getFechaPrestamo());
            ps.setDate(2, p.getFechaDevolucion());
            ps.setInt(3, p.getFkIdUsu());
            ps.setInt(4, p.getFkIdLib());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar préstamo: " + e.getMessage());
            return false;
        }
    }

    // Consultar lista de préstamos combinando datos de usuarios y libros
    public List<prestamos> listarPrestamos() {
        List<prestamos> lista = new ArrayList<>();
        String sql = "SELECT p.id_pre, p.fecha_prestamo, p.fecha_devolucion, p.estado_pre, "
                   + "p.fk_id_usu, p.fk_id_lib, u.nombre_usu, u.apellido_usu, l.titulo_lib "
                   + "FROM prestamos p "
                   + "INNER JOIN usuarios u ON p.fk_id_usu = u.id_usu "
                   + "INNER JOIN libros l ON p.fk_id_lib = l.id_lib";
        try {
            cn = conexion.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prestamos p = new prestamos();
                p.setIdPre(rs.getInt("id_pre"));
                p.setFechaPrestamo(rs.getDate("fecha_prestamo"));
                p.setFechaDevolucion(rs.getDate("fecha_devolucion"));
                p.setEstadoPre(rs.getString("estado_pre"));
                p.setFkIdUsu(rs.getInt("fk_id_usu"));
                p.setFkIdLib(rs.getInt("fk_id_lib"));
                p.setNombreUsuario(rs.getString("nombre_usu") + " " + rs.getString("apellido_usu"));
                p.setTituloLibro(rs.getString("titulo_lib"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar préstamos: " + e.getMessage());
        }
        return lista;
    }

    // Actualizar estado a devuelto
    public boolean devolverLibro(int idPrestamo) {
        String sql = "UPDATE prestamos SET estado_pre = 'devuelto' WHERE id_pre = ?";
        try {
            cn = conexion.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idPrestamo);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al devolver libro: " + e.getMessage());
            return false;
        }
    }

    // Validar si el libro ya está ocupado
    public boolean libroEstaPrestado(int idLibro) {
        String sql = "SELECT COUNT(*) FROM prestamos WHERE fk_id_lib = ? AND estado_pre = 'prestado'";
        try {
            cn = conexion.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idLibro);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar estado del libro: " + e.getMessage());
        }
        return false;
    }
}