/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adnconversor.exceptions;

import java.io.IOException;

/**
 *
 * @author usuario
 */
public class ADNConversorExceptions extends IOException {

    public ADNConversorExceptions() {
    }

    public ADNConversorExceptions(String message) {
        super(message);
    }
    
    public void reportError() {
        javax.swing.JOptionPane.showMessageDialog(null, "Unexpected error: " + getMessage(), "",
                javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    public void reportAndExit() {
        reportError();
        System.exit(-1);
    }

    public void printAndExit(){
        System.err.append("Exception type: " + getMessage() + " ");
        System.exit(-1);
    }
    
    public void allAndExit(){
        reportError();
        printAndExit();
    }
    
}
