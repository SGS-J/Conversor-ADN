package conversoradn.logic.jframelogic;

import conversoradn.excepciones.CaracterCodonInvalido;

public class CodonCopy {

    private static String textToVerify = "";
    private static boolean validChars;

    // Hace la clase imposible de instanciar
    private CodonCopy() {
    }

    public static String getTextVerified() {
        return textToVerify;
    }

    public static boolean isValidChars() {
        return validChars;
    }

    private static boolean verifyChars() {
        textToVerify = textToVerify.toUpperCase();
        char actualChars[] = textToVerify.toCharArray();
        try {
            for (char actualChar : actualChars) {
                if (actualChar != 'A' && actualChar != 'C'
                        && actualChar != 'T' && actualChar != 'G') {
                    throw new CaracterCodonInvalido(
                            "Error in the verify char method on CodonCopy class");
                }
            }
            return true;
        } catch (CaracterCodonInvalido e) {
            return false;
        }
    }

    public static void verifyCodonCharacters(String text) {
        textToVerify = text;
        validChars = verifyChars();
    }

}
