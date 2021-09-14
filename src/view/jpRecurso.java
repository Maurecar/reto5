/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import accessDAO.RecursoDAO;
import controller.InitialData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.RecursoModel;

/**
 *
 * @author marco
 */
public final class jpRecurso extends javax.swing.JPanel {

    private InitialData datos = new InitialData();

    /**
     * Creates new form jpRecurso
     */
    public jpRecurso() {
        initComponents();
        setListaCursos();
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
        jtRecurso = new javax.swing.JTable();
        jlTituloRec = new javax.swing.JLabel();
        jlIdRec = new javax.swing.JLabel();
        jlrecTit = new javax.swing.JLabel();
        jtRecTitulo = new javax.swing.JTextField();
        jtIdRec = new javax.swing.JTextField();
        jbGuardarRec = new javax.swing.JButton();
        jbUpdateRec = new javax.swing.JButton();
        jbDeleteRec = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));
        setMinimumSize(new java.awt.Dimension(650, 380));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtRecurso.setBackground(new java.awt.Color(0, 102, 102));
        jtRecurso.setForeground(new java.awt.Color(153, 255, 255));
        jtRecurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Recurso", "Titulo"
            }
        ));
        jScrollPane1.setViewportView(jtRecurso);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 370, 200));

        jlTituloRec.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jlTituloRec.setForeground(new java.awt.Color(153, 255, 255));
        jlTituloRec.setText("CRUD RECURSO");
        add(jlTituloRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 160, 40));

        jlIdRec.setForeground(new java.awt.Color(153, 255, 255));
        jlIdRec.setText("ID Recurso: ");
        add(jlIdRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 70, -1));

        jlrecTit.setForeground(new java.awt.Color(153, 255, 255));
        jlrecTit.setText("Titulo Recurso: ");
        add(jlrecTit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, 20));
        add(jtRecTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 150, -1));
        add(jtIdRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 150, -1));

        jbGuardarRec.setText("Guardar");
        jbGuardarRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarRecActionPerformed(evt);
            }
        });
        add(jbGuardarRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        jbUpdateRec.setText("Actualizar");
        jbUpdateRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateRecActionPerformed(evt);
            }
        });
        add(jbUpdateRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        jbDeleteRec.setText("Eliminar");
        jbDeleteRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteRecActionPerformed(evt);
            }
        });
        add(jbDeleteRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarRecActionPerformed
        String id = this.jtIdRec.getText();
        String titulo = this.jtRecTitulo.getText();
        if (id.equals("") || titulo.equals("")) {
            JOptionPane.showMessageDialog(null, "Es necesario llenar las casillas de id o título");
        } else {
            int id_rec = Integer.parseInt((String) this.jtIdRec.getText());

            RecursoModel recurso = new RecursoModel(id_rec, titulo);

            RecursoDAO recursoDAO = new RecursoDAO();
            recursoDAO.insertRecurso(recurso);
        }
        setListaCursos();

    }//GEN-LAST:event_jbGuardarRecActionPerformed

    private void jbUpdateRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateRecActionPerformed
        String id = this.jtIdRec.getText();
        String titulo = this.jtRecTitulo.getText();
        if (id.equals("") || titulo.equals("")) {
            JOptionPane.showMessageDialog(null, "Es necesario llenar las casillas de id o título");
        } else {
            int id_rec = Integer.parseInt((String) this.jtIdRec.getText());

            RecursoModel recurso = new RecursoModel(id_rec, titulo);

            RecursoDAO recursoDAO = new RecursoDAO();
            recursoDAO.updateCurso(recurso);
        }
        setListaCursos();
    }//GEN-LAST:event_jbUpdateRecActionPerformed

    private void jbDeleteRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteRecActionPerformed
        String id = this.jtIdRec.getText();
        String titulo = this.jtRecTitulo.getText();
        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Es necesario llenar las casillas de id del recurso para eliminar");
        }
        else{
            int id_rec = Integer.parseInt((String) this.jtIdRec.getText());

            RecursoDAO recursoDAO = new RecursoDAO();
            recursoDAO.deleteRecurso(id_rec);
        }
        setListaCursos();
    }//GEN-LAST:event_jbDeleteRecActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbDeleteRec;
    private javax.swing.JButton jbGuardarRec;
    private javax.swing.JButton jbUpdateRec;
    private javax.swing.JLabel jlIdRec;
    private javax.swing.JLabel jlTituloRec;
    private javax.swing.JLabel jlrecTit;
    private javax.swing.JTextField jtIdRec;
    private javax.swing.JTextField jtRecTitulo;
    private javax.swing.JTable jtRecurso;
    // End of variables declaration//GEN-END:variables
String[] headers = {"ID Recurso", "Titulo"};

    public void setListaCursos() {
        ArrayList<RecursoModel> recursos = datos.getCursosLista();
        this.jtRecurso.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.jtRecurso.setModel(tableModel);
        for (int i = 0; i < recursos.size(); i++) {
            tableModel.addRow(recursos.get(i).toArray());
        }
        this.jtRecurso.setModel(tableModel);
    }
}
