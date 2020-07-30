package adnconversor.logic.mainlogic;

import adnconversor.logic.mainlogic.functions.LetterVerificator;
import adnconversor.logic.mainlogic.functions.Verificator;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class GeneticCode {

    private ArrayList<AminoAcid> aminoAcids;
    
    private ArrayList<Codon> codonsToTranslate;
    private String codonChars;
    private Verificator verificator;

    public GeneticCode() {
        this(new RNA());
    }

    public GeneticCode(RNA transcription) {
        codonsToTranslate = new ArrayList<>(transcription.getCodons());
        aminoAcids = new ArrayList<>();
        verificator = new LetterVerificator();
        translate();
    }

    @Override
    public String toString() {
        String strForm = "";
        for (AminoAcid aminoAcid : aminoAcids) {
            strForm += aminoAcid.name() + " ";
        }
        return strForm;
    }
     
    private void translate() {
        loopArrayAndSetAminoAcids();
    }
    
    private void loopArrayAndSetAminoAcids() {
        for (Codon codon : codonsToTranslate) {
            if(!codon.isCompleteCodon())
                break;
            verificator.setStringToWork(codon.toString());
            codonChars = verificator.verifyLetters();
            initAminoAcids();
        }
    }
    
    private void initAminoAcids () {
        AminoAcid aminoAcid = AminoAcid.getAminoAcidWithACodon(Codon.parse(codonChars));
        aminoAcids.add(aminoAcid);
    }
    
}
