package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.usuarios;

public class usuariosDAO {

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public usuarios login(String usuario, String password) {

        usuarios user = null;

        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ? AND estado = 'Activo'";

        try {

            cn = conexion.getConnection();
            ps = cn.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {

                user = new usuarios();

                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setRol(rs.getString("rol"));
                user.setEstado(rs.getString("estado"));

            }

        } catch (SQLException e) {

            System.out.println("Error al iniciar sesión: " + e.getMessage());

        }

        return user;
    }
}