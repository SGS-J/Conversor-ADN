package dnaconversor.exceptions;

public class ParseNitroBaseException extends IncompatibleCodonCharException{

    public ParseNitroBaseException() {
    }

    public ParseNitroBaseException(String message) {
        super(message);
    }
    
}
