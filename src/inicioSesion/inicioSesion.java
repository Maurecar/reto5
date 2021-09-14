package inicioSesion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import utils.connectionDB;
import view.menuPrincipal;

/**
 * Esta interfaz fue diseñada para darle un nivel de seguridad a nuestro
 * programa.
 *
 * @author Marco
 */
public class inicioSesion extends javax.swing.JFrame {

    private Connection conecta = null;

    public inicioSesion() {
        initComponents();
        this.setLocationRelativeTo(null);//posicionamiento de la ventana

    }

    @SuppressWarnings("unchecked")//tuve varios problemas al subir en los retos, con esta línea lo corregia
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtContrasena = new javax.swing.JPasswordField();
        jbIniciarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(1, 22, 67));
        jButton1.setForeground(new java.awt.Color(153, 255, 255));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Contraseña:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 183, 120, 20));

        jtUsuario.setBackground(new java.awt.Color(1, 22, 67));
        jtUsuario.setForeground(new java.awt.Color(153, 255, 255));
        getContentPane().add(jtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 220, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("Usuario:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 80, 20));

        jtContrasena.setBackground(new java.awt.Color(1, 22, 67));
        jtContrasena.setForeground(new java.awt.Color(153, 255, 255));
        getContentPane().add(jtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 202, 220, -1));
        jtContrasena.getAccessibleContext().setAccessibleName("");

        jbIniciarSesion.setBackground(new java.awt.Color(1, 22, 67));
        jbIniciarSesion.setForeground(new java.awt.Color(153, 255, 255));
        jbIniciarSesion.setText("Iniciar Sesión");
        jbIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(jbIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 220, -1));

        jLabel2.setBackground(new java.awt.Color(1, 22, 67));
        jLabel2.setForeground(new java.awt.Color(1, 22, 67));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Reto V Ciclo II - Presentado por Marco Carrillo - Profesora  Cecilia Avila.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);//accion para cerrar la ventana
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarSesionActionPerformed
        String user = jtUsuario.getText();//tomando valor de usuario para envio a peticion
        String pass = jtContrasena.getText();//tomando valor de password para envio a peticion
        if (user.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(this, "El Usuario y Contraseña son necesarios");
        } else {
            try {

                if (conecta == null) {
                    conecta = connectionDB.getConnection();//conexion a la base de datos
                }

                Statement statement = conecta.createStatement();
                String peticion = "select se_id, se_usuario, se_pass from sesion where se_usuario= '" + user + "' and se_pass='" + pass + "'";//linea que ejecuta en la base de datos
                ResultSet result = statement.executeQuery(peticion);
                if (result.next()) {//verificando si pasa la opción
                    JOptionPane.showMessageDialog(this, "Te damos la bienvendia " + user);
                    setVisible(false);
                    menuPrincipal menu = new menuPrincipal();
                    menu.setVisible(true);
                } else {//muestra error si la clave o usuario no estan en la base de datos
                    JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrecta");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());//muestra error si existe algun problema en la base de datos
            }
        }
    }//GEN-LAST:event_jbIniciarSesionActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>//use el constructor visual de java asumo que esto se genera por eso.

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicioSesion().setVisible(true);//llamado para que sea la primera ventana.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbIniciarSesion;
    private javax.swing.JPasswordField jtContrasena;
    private javax.swing.JTextField jtUsuario;
    // End of variables declaration//GEN-END:variables
}
