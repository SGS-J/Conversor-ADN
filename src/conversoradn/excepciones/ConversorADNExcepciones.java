package conversoradn.excepciones;

import java.io.IOException;
import java.io.Serializable;

public class ConversorADNExcepciones extends IOException implements Serializable{

    private static final long serialVersionUID = 102L;
    
    String NOMBRE_EXCEPCION;
    
    public ConversorADNExcepciones() {
        this("");
    }

    public ConversorADNExcepciones(String message) {
        super(message);
    }

    public void setNombreExcepcion(final String NOMBRE_EXCEPCION) {
        this.NOMBRE_EXCEPCION = NOMBRE_EXCEPCION;
    }

    @Override
    public String getMessage() {
        return super.getMessage().equals("") ? "Error en la logica" : super.getMessage();
    }
    
    /**
     * Reporta el error como un dialogo de tipo {@code JOptionPane}
     * el cual contiene el nombre de la excepcion arrojada y el mensaje
     * en detalle especificado en el lanzamiento de la misma, en caso
     * de que no haya un mensaje(se haya lanzado con el constructor por defecto)
     * el detalle se mostrara como "Error en la logica".
     */
    public void reportarError() {
        javax.swing.JOptionPane.showMessageDialog(null, "Error inesperado: " + NOMBRE_EXCEPCION +
                "\n" + getMessage(), "Un error ha ocurrido!",
                javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Invoca al metodo {@code reportarError()} y finaliza el programa con
     * retorno -1.
     * @see #reportarError() 
     */
    public void reportarYSalir() {
        reportarError();
        System.exit(-1);
    }

}
