package adnconversor.exceptions;

import java.io.IOException;

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
