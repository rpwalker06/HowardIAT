/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implicit;

import implicitForms.testStartForm;
import implicitForms.implicitControlFrame;

/**
 *
 * @author Robert Walker
 */
public class implicitAssociationDriver {
    
    
     public static void main(String args[]) {
     
     java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
        //declare default variables for windows that we need
        implicitControlFrame control;
        testStartForm starter;

        control = new implicitControlFrame();
        control.setVisible(true);
        
            }
        });
    }
    
    
    
    
    
    
    
}
