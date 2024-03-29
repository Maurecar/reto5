/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import accessDAO.AutorDAO;
import controller.InitialData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AutorModel;

/**
 *
 * @author marco
 */
public class jpAutor extends javax.swing.JPanel {

    private InitialData datos = new InitialData();

    /**
     * Creates new form jpAutor
     */
    public jpAutor() {
        initComponents();
        setListaAutores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtAutor = new javax.swing.JTable();
        jlAutor = new javax.swing.JLabel();
        jtIdAutor = new javax.swing.JTextField();
        jlAutor1 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jlAutor2 = new javax.swing.JLabel();
        jtApellido = new javax.swing.JTextField();
        jlAutor3 = new javax.swing.JLabel();
        jtNacionalidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbEliminar = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtAutor.setBackground(new java.awt.Color(0, 102, 102));
        jtAutor.setForeground(new java.awt.Color(153, 255, 255));
        jtAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtAutor);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, 200));

        jlAutor.setForeground(new java.awt.Color(204, 255, 255));
        jlAutor.setText("ID Autor: ");
        add(jlAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));
        add(jtIdAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 90, -1));

        jlAutor1.setForeground(new java.awt.Color(204, 255, 255));
        jlAutor1.setText("Nombre:");
        add(jlAutor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));
        add(jtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 90, -1));

        jlAutor2.setForeground(new java.awt.Color(204, 255, 255));
        jlAutor2.setText("Apellido: ");
        add(jlAutor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));
        add(jtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 90, -1));

        jlAutor3.setForeground(new java.awt.Color(204, 255, 255));
        jlAutor3.setText("Nacionalidad:");
        add(jlAutor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));
        add(jtNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 90, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("CRUD AUTOR");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 80, -1));

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });
        add(jbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 80, -1));

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });
        add(jbActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        String id = this.jtIdAutor.getText();
        String nombre = this.jtNombre.getText();
        String apellido = this.jtApellido.getText();
        String nacionalidad = this.jtNacionalidad.getText();
        if (id.equals("") || nombre.equals("") || apellido.equals("") || nacionalidad.equals("")) {
            JOptionPane.showMessageDialog(null, "Es necesario llenar las casillas de id, nombre, apellido o nacionalidad");
        } else {
            int id_aut = Integer.parseInt(id);

            AutorModel autor = new AutorModel(id_aut, nombre, apellido, nacionalidad);

            AutorDAO autorDAO = new AutorDAO();
            autorDAO.insertAutor(autor);
        }
        setListaAutores();
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        String id = this.jtIdAutor.getText();
        String nombre = this.jtNombre.getText();
        String apellido = this.jtApellido.getText();
        String nacionalidad = this.jtNacionalidad.getText();
        if (id.equals("") || nombre.equals("") || apellido.equals("") || nacionalidad.equals("")) {
            JOptionPane.showMessageDialog(null, "Es necesario llenar las casillas de id, nombre, apellido o nacionalidad");
        } else {
            int id_aut = Integer.parseInt(id);

            AutorModel autor = new AutorModel(id_aut, nombre, apellido, nacionalidad);

            AutorDAO autorDAO = new AutorDAO();
            autorDAO.updateAutor(autor);
        }
        setListaAutores();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        String id = this.jtIdAutor.getText();

        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Es necesario llenar las casillas de id");
        } else {
            int id_aut = Integer.parseInt(id);

            AutorDAO autorDAO = new AutorDAO();
            autorDAO.deleteAuotr(id_aut);
        }
        setListaAutores();
    }//GEN-LAST:event_jbEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JLabel jlAutor;
    private javax.swing.JLabel jlAutor1;
    private javax.swing.JLabel jlAutor2;
    private javax.swing.JLabel jlAutor3;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTable jtAutor;
    private javax.swing.JTextField jtIdAutor;
    private javax.swing.JTextField jtNacionalidad;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
String[] headers = {"ID", "Nombre", "Apellido", "Nacionalidad"};

    public void setListaAutores() {
        ArrayList<AutorModel> autores = datos.getAutoresLista();
        this.jtAutor.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.jtAutor.setModel(tableModel);
        for (int i = 0; i < autores.size(); i++) {
            tableModel.addRow(autores.get(i).toArray());
        }
        this.jtAutor.setModel(tableModel);
    }
}
