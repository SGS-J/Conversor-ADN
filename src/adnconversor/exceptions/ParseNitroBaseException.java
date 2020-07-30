/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adnconversor.exceptions;

/**
 *
 * @author usuario
 */
public class ParseNitroBaseException extends IncompatibleCodonCharException{

    public ParseNitroBaseException() {
    }

    public ParseNitroBaseException(String message) {
        super(message);
    }
    
}
