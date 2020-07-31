package conversoradn.excepciones;

public class CaracterCodonInvalido extends FalloDeclaracionCodon{
    
    public CaracterCodonInvalido() {
        this("");
    }

    public CaracterCodonInvalido(String message) {
        super(message);
        setNombreExcepcion("CaracterCodonInvalido");
    }
    
}
