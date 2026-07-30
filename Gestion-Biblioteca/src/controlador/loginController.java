package controlador;

import dao.usuariosDAO;
import javax.swing.JOptionPane;
import modelo.usuarios;
import mvcgui.login;
import mvcgui.principal;

public class loginController {

    private login vista;
    private usuariosDAO dao;

    public loginController(login vista) {

    this.vista = vista;
    this.dao = new usuariosDAO();

    this.vista.btnIngresar.addActionListener(e -> ingresar());
    this.vista.btnSalir.addActionListener(e -> System.exit(0));

    // Iniciar sesión al presionar Enter en la contraseña
    this.vista.txtPassword.addActionListener(e -> ingresar());

}

    private void ingresar() {

        String usuario = vista.txtUsuario.getText().trim();
        String password = String.valueOf(vista.txtPassword.getPassword());

        if (usuario.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese el usuario y la contraseña.");
            return;

        }

        usuarios user = dao.login(usuario, password);

        if (user != null) {

            JOptionPane.showMessageDialog(null, "Bienvenido " + user.getNombre());

            principal p = new principal();

            p.lblUsuario.setText("Usuario: " + user.getNombre());
            p.lblRol.setText("Rol: " + user.getRol());

            p.setLocationRelativeTo(null);
            p.setVisible(true);

            vista.dispose();

        } else {

            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");

        }

    }

}