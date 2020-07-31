package conversoradn.excepciones;

public class ErrorParserAcidoNucleico extends FalloDeclaracionCodigoGenetico{

    public ErrorParserAcidoNucleico() {
        this("");
    }

    public ErrorParserAcidoNucleico(String message) {
        super(message);
        setNombreExcepcion("ErrorParserAcidoNucleico");
    }
    
}
