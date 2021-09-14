
package reto5;

import inicioSesion.inicioSesion;

/**
 * Reto 5 - Misión TIC 2022
 * @author marco
 */
public class Reto5 {

    
    public static void main(String[] args) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicioSesion().setVisible(true);
            }
        });
       //menuPrincipal menu = new menuPrincipal();
    }//cierra main
    
}//cierra class
