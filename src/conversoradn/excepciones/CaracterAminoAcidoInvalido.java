package conversoradn.excepciones;

public class CaracterAminoAcidoInvalido extends FalloDeclaracionCodigoGenetico{

    public CaracterAminoAcidoInvalido() {
        this("");
    }

    public CaracterAminoAcidoInvalido(String message) {
        super(message);
        setNombreExcepcion("CaracterAminoAcidoInvalido");
    }
    
}
