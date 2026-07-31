/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.autoresDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.autores;
import mvcgui.dashboard_autor;

public class autoresController {

    private dashboard_autor vista;
    private autoresDAO dao;

    public autoresController(dashboard_autor vista){

        this.vista = vista;
        dao = new autoresDAO();

    }

    public void insertar(){

        autores a = new autores();

        a.setNombre(vista.txtNombreAut.getText());
        a.setNacionalidad(vista.txtNacionalidadAut.getText());
        a.setEstado(vista.cbxEstadoAut.getSelectedItem().toString());

        if(dao.insertarAutor(a)!=null){
            JOptionPane.showMessageDialog(null, "autor registrado");
        }else{
            JOptionPane.showMessageDialog(null, "error");
        }

    }

    public void listar(){

        DefaultTableModel modelo = (DefaultTableModel) vista.tblAutor.getModel();

        modelo.setRowCount(0);

        List<autores> lista = dao.listarAutor();

        for(autores a : lista){

            modelo.addRow(new Object[]{

                a.getId(),
                a.getNombre(),
                a.getNacionalidad(),
                a.getEstado()

            });

        }

    }

    public void eliminar(){

        int fila = vista.tblAutor.getSelectedRow();

        if(fila==-1){

            JOptionPane.showMessageDialog(null,"debe seleccionar un registro");
            return;

        }else{

            int opc = JOptionPane.showConfirmDialog(null,
                    "DESEA ELIMINAR ESTE REGISTRO?",
                    "CONFIRMAR ACCION",
                    JOptionPane.YES_NO_OPTION);

            if(opc!=JOptionPane.YES_OPTION){
                return;
            }

            int id = Integer.parseInt(vista.tblAutor.getValueAt(fila,0).toString());

            if(dao.eliminarAutor(id)){

                JOptionPane.showMessageDialog(null,"eliminado con exito");
                listar();

            }

        }

    }

    public void editar(){

        int fila = vista.tblAutor.getSelectedRow();

        if(fila==-1){

            JOptionPane.showMessageDialog(null,"debe seleccionar un registro");
            return;

        }

        autores a = new autores();

        a.setId(Integer.parseInt(vista.tblAutor.getValueAt(fila,0).toString()));
        a.setNombre(vista.txtNombreAut.getText());
        a.setNacionalidad(vista.txtNacionalidadAut.getText());
        a.setEstado(vista.cbxEstadoAut.getSelectedItem().toString());

        if(dao.actualizarAutor(a)){

            JOptionPane.showMessageDialog(null,"autor actualizado");
            listar();

        }else{

            JOptionPane.showMessageDialog(null,"error al actualizar");

        }

    }
    public void limpiar(){

        vista.txtNombreAut.setText("");
        vista.txtNacionalidadAut.setText("");
        vista.cbxEstadoAut.setSelectedIndex(0);
    }
}


