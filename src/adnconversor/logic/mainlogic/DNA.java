package adnconversor.logic.mainlogic;

import adnconversor.logic.mainlogic.functions.NucleicAcidParser;
import adnconversor.logic.mainlogic.functions.ParserFunction;
import java.util.ArrayList;
import adnconversor.exceptions.NucleicAcidParseException;

/**
 *
 * @author usuario
 */
public class DNA extends NucleicAcid {

    private static NucleicAcidParser parser;

    public DNA() {
        super();
    }

    public DNA(Codon... codons) {
        super(codons);
    }

    public DNA(ArrayList<Codon> codons) {
        super(codons);
    }

    @Override
    public DNA replicate() {
        DNA dnaReplicated = new DNA();

        for (Codon codon : this.getCodons()) {
            int i = 0;
            ArrayList<NitroBase> nitRepList = new ArrayList<>();

            for (NitroBase base : codon.getNitroBases()) {
                switch (base) {
                    case ADENINE:
                        nitRepList.add(NitroBase.THYMINE);
                        break;
                    case THYMINE:
                        nitRepList.add(NitroBase.ADENINE);
                        break;
                    case CYTOSINE:
                        nitRepList.add(NitroBase.GUANINE);
                        break;
                    case GUANINE:
                        nitRepList.add(NitroBase.CYTOSINE);
                        break;
                }
                i++;
            }
            //** Creates a replicated Codon form for the dna replicated **//
            NitroBase[] nitRep = new NitroBase[nitRepList.size()];
            nitRep = nitRepList.toArray(nitRep);
            Codon codonRep = Codon.createWithArray(nitRep);
            dnaReplicated.addCodon(codonRep);
        }

        return dnaReplicated;
    }

    public RNA transcribe() {
        RNA dnaTranscribed = RNA.createWithDNA(replicate());

        if (!dnaTranscribed.toString().contains("T")) {
            // If no contains the letter T simply returns the object
            return dnaTranscribed = RNA.parse(dnaTranscribed.toString()
                    .replace(" ", ""));
        } else {
            // Else replace the char T to U and return it
            return dnaTranscribed = RNA.parse(dnaTranscribed.toString()
                    .replace("T", "U").replace(" ", ""));
        }
    }

    public static DNA parse(String strDNA) {
        try {
            if (strDNA.contains("U")) {
                throw new NucleicAcidParseException("The string value of DNA is invalid!!!");
            }
        } catch (NucleicAcidParseException e) {
            return null;
        }
        parser = ParserFunction.GenerateFunction();
        return new DNA(parser.parse(strDNA));
    }

}
