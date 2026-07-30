/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.usuariosDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.usuarios;
import mvcgui.dashboard_usuarios;

/**
 *
 * @author J E S U S
 */

public class usuariosController {
    private dashboard_usuarios vista;
    private usuariosDAO dao;
    public usuariosController(dashboard_usuarios vista){
        this.vista = vista;
        dao = new usuariosDAO();
    }
    public void insertar(){
        usuarios u = new usuarios();
        u.setCedula(vista.txtCedulaUsu.getText());
        u.setNombre(vista.txtNombreUsu.getText());
        u.setApellido(vista.txtApellidoUsu.getText());
        u.setGenero(vista.cbxGeneroUsu.getSelectedItem().toString());
        u.setEmail(vista.txtCorreoUsu.getText());
        u.setDireccion(vista.txtDireccionUsu.getText());
        u.setCelular(vista.txtCelularUsu.getText());
        u.setEstado(vista.cbxEstadoUsu.getSelectedItem().toString());
        //u.setUsuario(vista.txtUsuario.getSelectItem().toString());
        if(dao.insertarUsuario(u)!= null){
            JOptionPane.showMessageDialog(null, "usuario registrado");
        }
        else{
            JOptionPane.showMessageDialog(null, "error");
        }
        
    }
    public void listar(){

    DefaultTableModel modelo = (DefaultTableModel) vista.tblUsuarios.getModel();

    modelo.setRowCount(0);

    List<usuarios> lista = dao.listarUsuarios();

    for(usuarios u : lista){

        modelo.addRow(new Object[]{
            u.getId(),
            u.getCedula(),
            u.getNombre(),
            u.getApellido(),
            u.getGenero(),
            u.getEmail(),
            u.getDireccion(),
            u.getCelular(),
            u.getEstado(),
            u.getUsuario(),
            u.getRol()
        });

    }

}
    public void eliminar() {

    int fila = vista.tblUsuarios.getSelectedRow();

    if (fila == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione un usuario.");
        return;
    }

    int op = JOptionPane.showConfirmDialog(
            null,
            "¿Desea eliminar este usuario?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);

    if (op != JOptionPane.YES_OPTION) {
        return;
    }

    int id = Integer.parseInt(vista.tblUsuarios.getValueAt(fila, 0).toString());

    if (dao.eliminarUsuario(id)) {

        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");

        listar();
    } else {
        JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario.");
    }
}
    public void editar(){

    int fila = vista.tblUsuarios.getSelectedRow();

    if(fila == -1){

        JOptionPane.showMessageDialog(null, "Seleccione un usuario.");

        return;

    }

    usuarios u = new usuarios();

    u.setId(Integer.parseInt(vista.tblUsuarios.getValueAt(fila,0).toString()));
    u.setCedula(vista.txtCedulaUsu.getText());
    u.setNombre(vista.txtNombreUsu.getText());
    u.setApellido(vista.txtApellidoUsu.getText());
    u.setGenero(vista.cbxGeneroUsu.getSelectedItem().toString());
    u.setEmail(vista.txtCorreoUsu.getText());
    u.setCelular(vista.txtCelularUsu.getText());
    u.setDireccion(vista.txtDireccionUsu.getText());
    u.setEstado(vista.cbxEstadoUsu.getSelectedItem().toString());

    if(dao.editarUsuario(u)){

        JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");

        listar();

    }else{
        JOptionPane.showMessageDialog(null, "No se pudo actualizar.");
    }
}   
}