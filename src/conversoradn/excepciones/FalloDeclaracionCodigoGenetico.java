package conversoradn.excepciones;

public class FalloDeclaracionCodigoGenetico extends ConversorADNExcepciones{

    public FalloDeclaracionCodigoGenetico() {
        this("");
    }

    public FalloDeclaracionCodigoGenetico(String message) {
        super(message);
        setNombreExcepcion("FalloDeclaracionCodigoGenetico");
    }
    
}
