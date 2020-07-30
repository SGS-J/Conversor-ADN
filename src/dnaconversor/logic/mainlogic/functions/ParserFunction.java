package adnconversor.logic.mainlogic.functions;

import adnconversor.logic.mainlogic.Codon;
import adnconversor.logic.mainlogic.NitroBase;
import java.util.ArrayList;

public class ParserFunction implements NucleicAcidParser{

    private ParserFunction () {
    }
    
    public static ParserFunction GenerateFunction () {
        return new ParserFunction();
    }
    
    @Override
    public ArrayList<Codon> parse(String stringNucleicAcid) {
        // Create the List to add int the nucleic acid
        ArrayList<Codon> codonsForNucleicAcid = new ArrayList<>();

        // Create a charArray without spaces
        char[] arrayOfLettersDNA = stringNucleicAcid.toCharArray();

        // Create an initial Codon instance to work with it
        Codon parseCodon = new Codon();

        int len = arrayOfLettersDNA.length;
        for (int i = 0; i < len + 1; i++) {

            if (parseCodon.isCompleteCodon()) {
                codonsForNucleicAcid.add(parseCodon);
                parseCodon = new Codon();
                if (i == len) {
                    break;
                }
            } else if (i == len) {
                codonsForNucleicAcid.add(parseCodon);
                break;
            }

            parseCodon.getNitroBases().add(NitroBase
                    .parse(arrayOfLettersDNA[i]));
        }
        return codonsForNucleicAcid;
    }
    
}
