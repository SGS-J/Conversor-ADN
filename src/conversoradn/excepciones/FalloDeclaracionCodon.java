package conversoradn.excepciones;

public class FalloDeclaracionCodon extends ConversorADNExcepciones{
    
    public FalloDeclaracionCodon() {
        this("");
    }

    public FalloDeclaracionCodon(String message) {
        super(message);
        setNombreExcepcion("FalloDeclaracionCodon");
    }
    
}
