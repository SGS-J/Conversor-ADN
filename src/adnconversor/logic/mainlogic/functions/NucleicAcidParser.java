package adnconversor.logic.mainlogic.functions;

import adnconversor.logic.mainlogic.Codon;

public interface NucleicAcidParser {
    java.util.ArrayList<Codon> parse(String stringNucleicAcid);
}
