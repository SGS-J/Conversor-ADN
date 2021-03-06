package conversoradn.logic.mainlogic;

import conversoradn.logic.mainlogic.functions.NucleicAcidParser;
import conversoradn.logic.mainlogic.functions.ParserFunction;
import conversoradn.excepciones.ErrorParserAcidoNucleico;
import java.util.ArrayList;

public class RNA extends NucleicAcid {

    private static NucleicAcidParser parser;

    public RNA(){
        super();
        super.getCodons().add(
                Codon.createWithThreeBases(
                        NitroBase.ADENINE, NitroBase.URACIL, NitroBase.GUANINE));
    }
    
    public RNA(Codon... codons) {
        super(codons);
    }

    public RNA(ArrayList<Codon> codons) {
        super(codons);
    }

    public static RNA createWithDNA(DNA dna) {
        return new RNA(dna.getCodons());
    }

    @Override
    public RNA replicate() {
        RNA rnaReplicated = new RNA();

        for (Codon codon : this.getCodons()) {
            int i = 0;
            ArrayList<NitroBase> nitRepList = new ArrayList<>();

            for (NitroBase base : codon.getNitroBases()) {
                switch (base) {
                    case ADENINE:
                        nitRepList.add(NitroBase.THYMINE);
                        break;
                    case URACIL:
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
            //** Creando un y añadiendo el Codon replicado **//
            NitroBase[] nitRep = new NitroBase[nitRepList.size()];
            nitRep = nitRepList.toArray(nitRep);
            Codon codonRep = Codon.createWithArray(nitRep);
            rnaReplicated.addCodon(codonRep);
        }

        return rnaReplicated;
    }
    
    public static RNA parse(String strRNA) {
        try {
            if (strRNA.contains("T")) {
                throw new ErrorParserAcidoNucleico("The string value of DNA is invalid!!!");
            }
        } catch (ErrorParserAcidoNucleico e) {
            return null;
        }
        parser = ParserFunction.GenerateFunction();
        return new RNA(parser.parse(strRNA));
    }

}
