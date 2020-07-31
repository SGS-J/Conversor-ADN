package conversoradn.excepciones;

public class LongitudNitroBaseInvalida extends FalloDeclaracionCodon {
    
    public LongitudNitroBaseInvalida() {
        this("");
    }

    public LongitudNitroBaseInvalida(String message) {
        super(message);
        setNombreExcepcion("LongitudNitroBaseInvalida");
    }

}
