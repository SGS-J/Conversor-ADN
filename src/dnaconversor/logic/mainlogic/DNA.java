package dnaconversor.logic.mainlogic;

import dnaconversor.logic.mainlogic.functions.NucleicAcidParser;
import dnaconversor.logic.mainlogic.functions.ParserFunction;
import java.util.ArrayList;
import dnaconversor.exceptions.NucleicAcidParseException;

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
            //** Creando y añadiendo el Codon replicado **//
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
            // Si no contiene la letra T simplemente retorna el objeto
            return dnaTranscribed = RNA.parse(dnaTranscribed.toString()
                    .replace(" ", ""));
        } else {
            // Caso contrario la remplaza por una U
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
