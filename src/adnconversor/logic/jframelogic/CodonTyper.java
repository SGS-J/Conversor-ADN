package adnconversor.logic.jframelogic;

/**
 *
 * @author usuario
 */
public class CodonTyper {

    private static char charOfCodon;

    // Make this class cannot create an instance
    private CodonTyper() {
    }

    public static char getCharOfCodon() {
        return charOfCodon;
    }

    public static boolean charsValid() {
        return charOfCodon == 'A' || charOfCodon == 'C' ||
               charOfCodon == 'T' || charOfCodon == 'G' ||
               charOfCodon == 'a' || charOfCodon == 'c' ||
               charOfCodon == 't' || charOfCodon == 'g';
    }

    public static void verifyLetters(char letter, java.awt.event.KeyEvent e) {
        charOfCodon = letter;
        if (charsValid()) {
            charOfCodon = Character.toUpperCase(letter);
        } else {
            e.consume();
        }
    }

    // To put automatically the capital letter that represents a nitrogeneous base
    public static void verifyLowerCase(java.awt.event.KeyEvent e) {
        if (Character.isLowerCase(e.getKeyChar())) {
            e.setKeyChar(CodonTyper.getCharOfCodon());
        }
    }

    // To put a space in the typerArea when the text equals form "AAA"
    // example: "ATT CCC TGA"
    public static void verifyCodon(String texttoverify, javax.swing.JTextArea textarea) {
        String aux = texttoverify.replace(" ", "");
        if (aux.length() % 3 == 0 && texttoverify.length() != 0) {
            textarea.setText(textarea.getText() + " ");
        }
    }

}
