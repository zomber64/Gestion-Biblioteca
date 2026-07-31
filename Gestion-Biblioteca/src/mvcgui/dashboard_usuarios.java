/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mvcgui;

import controlador.usuariosController;

/**
 *
 * @author DAMA
 */
public class dashboard_usuarios extends javax.swing.JFrame {

    private usuariosController control;

    public dashboard_usuarios() {
        initComponents();
        // Conectamos el controlador con esta vista
        control = new usuariosController(this);
        // Cargamos los datos en la tabla al abrir la ventana
        control.listar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCedulaUsu = new javax.swing.JTextField();
        txtNombreUsu = new javax.swing.JTextField();
        txtApellidoUsu = new javax.swing.JTextField();
        txtCorreoUsu = new javax.swing.JTextField();
        txtDireccionUsu = new javax.swing.JTextField();
        txtCelularUsu = new javax.swing.JTextField();
        cbxGeneroUsu = new javax.swing.JComboBox<>();
        cbxEstadoUsu = new javax.swing.JComboBox<>();
        btnRegresarUsu = new javax.swing.JButton();
        btnInsertarUsu = new javax.swing.JButton();
        btnActualizarUsu = new javax.swing.JButton();
        btnEliminarUsu = new javax.swing.JButton();
        btnLimpiarUsu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Usuarios");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("GESTIÓN DE USUARIOS");

        jLabel2.setText("CÉDULA:");
        jLabel3.setText("NOMBRE:");
        jLabel4.setText("APELLIDO:");
        jLabel5.setText("GÉNERO:");
        jLabel9.setText("CORREO:");
        jLabel7.setText("DIRECCIÓN:");
        jLabel8.setText("CELULAR:");
        jLabel6.setText("ESTADO:");

        cbxGeneroUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cbxEstadoUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        btnRegresarUsu.setText("REGRESAR");

        btnInsertarUsu.setText("INSERTAR");
        btnInsertarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarUsuActionPerformed(evt);
            }
        });

        btnActualizarUsu.setText("ACTUALIZAR");
        btnActualizarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarUsuActionPerformed(evt);
            }
        });

        btnEliminarUsu.setText("ELIMINAR");
        btnEliminarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuActionPerformed(evt);
            }
        });

        btnLimpiarUsu.setText("LIMPIAR");
        btnLimpiarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarUsuActionPerformed(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "CÉDULA", "NOMBRE", "APELLIDO", "GÉNERO", "EMAIL", "DIRECCIÓN", "CELULAR", "ESTADO", "USUARIO", "ROL"
            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCedulaUsu)
                                    .addComponent(txtNombreUsu)
                                    .addComponent(txtApellidoUsu)
                                    .addComponent(cbxGeneroUsu, 0, 160, Short.MAX_VALUE)
                                    .addComponent(txtCorreoUsu)
                                    .addComponent(txtDireccionUsu)
                                    .addComponent(txtCelularUsu)
                                    .addComponent(cbxEstadoUsu, 0, 160, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsertarUsu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(btnActualizarUsu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(btnLimpiarUsu)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminarUsu)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegresarUsu)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCedulaUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApellidoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxGeneroUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCorreoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtDireccionUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCelularUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbxEstadoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertarUsu)
                    .addComponent(btnActualizarUsu)
                    .addComponent(btnLimpiarUsu)
                    .addComponent(btnEliminarUsu)
                    .addComponent(btnRegresarUsu))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarUsuActionPerformed
        control.insertar();
    }//GEN-LAST:event_btnInsertarUsuActionPerformed

    private void btnActualizarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarUsuActionPerformed
        control.editar();
    }//GEN-LAST:event_btnActualizarUsuActionPerformed

    private void btnEliminarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuActionPerformed
        control.eliminar();
    }//GEN-LAST:event_btnEliminarUsuActionPerformed

    private void btnLimpiarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarUsuActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarUsuActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        int fila = tblUsuarios.getSelectedRow();
        if (fila != -1) {
            txtCedulaUsu.setText(tblUsuarios.getValueAt(fila, 1).toString());
            txtNombreUsu.setText(tblUsuarios.getValueAt(fila, 2).toString());
            txtApellidoUsu.setText(tblUsuarios.getValueAt(fila, 3).toString());
            cbxGeneroUsu.setSelectedItem(tblUsuarios.getValueAt(fila, 4).toString());
            txtCorreoUsu.setText(tblUsuarios.getValueAt(fila, 5).toString());
            txtDireccionUsu.setText(tblUsuarios.getValueAt(fila, 6).toString());
            txtCelularUsu.setText(tblUsuarios.getValueAt(fila, 7).toString());
            cbxEstadoUsu.setSelectedItem(tblUsuarios.getValueAt(fila, 8).toString());
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void limpiarCampos() {
        txtCedulaUsu.setText("");
        txtNombreUsu.setText("");
        txtApellidoUsu.setText("");
        txtCorreoUsu.setText("");
        txtDireccionUsu.setText("");
        txtCelularUsu.setText("");
        cbxGeneroUsu.setSelectedIndex(0);
        cbxEstadoUsu.setSelectedIndex(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new dashboard_usuarios().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarUsu;
    public javax.swing.JButton btnEliminarUsu;
    public javax.swing.JButton btnInsertarUsu;
    public javax.swing.JButton btnLimpiarUsu;
    public javax.swing.JButton btnRegresarUsu;
    public javax.swing.JComboBox<String> cbxEstadoUsu;
    public javax.swing.JComboBox<String> cbxGeneroUsu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblUsuarios;
    public javax.swing.JTextField txtApellidoUsu;
    public javax.swing.JTextField txtCedulaUsu;
    public javax.swing.JTextField txtCelularUsu;
    public javax.swing.JTextField txtCorreoUsu;
    public javax.swing.JTextField txtDireccionUsu;
    public javax.swing.JTextField txtNombreUsu;
    // End of variables declaration//GEN-END:variables
}