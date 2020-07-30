package adnconversor.logic.mainlogic.functions;

import adnconversor.logic.mainlogic.GeneticCode;
import java.util.Arrays;

public class LetterVerificator implements Verificator {

    private String strToWork;
    private char letter;
    private String codeAdded;
    private GeneticCode genCodeCreated;

    public LetterVerificator() {
        codeAdded = "";
    }

    @Override
    public void setStringToWork(String strToWork) {
        this.strToWork = strToWork;
    }

    @Override
    public String verifyLetters() {
        deleteActualCode();
        verifyFirstLetter();
        verifySecondLetter();
        verifyThirdLetter();
        return codeAdded;
    }

    private void deleteActualCode() {
        if (codeAdded != null) {
            codeAdded = "";
        }
    }

    private void verifyFirstLetter() {
        verifyLettter(strToWork.charAt(0));
        codeAdded += letter;
    }

    private void verifySecondLetter() {
        verifyLettter(strToWork.charAt(1));
        codeAdded += letter;
    }

    private void verifyThirdLetter() {
        verifyLettter(strToWork.charAt(2));
        codeAdded += letter;
    }

    private void verifyLettter(char letter) {
        switch (letter) {
            case 'U':
                this.letter = 'U';
                break;
            case 'C':
                this.letter = 'C';
                break;
            case 'A':
                this.letter = 'A';
                break;
            case 'G':
                this.letter = 'G';
                break;
        }
    }

}
