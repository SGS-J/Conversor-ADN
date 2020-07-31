package conversoradn.excepciones;

public class ErrorParserNitroBase extends CaracterCodonInvalido{

    public ErrorParserNitroBase() {
        this("");
    }

    public ErrorParserNitroBase(String message) {
        super(message);
        setNombreExcepcion("ErrorParserNitroBase");
    }
    
}
