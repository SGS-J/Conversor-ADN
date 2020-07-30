package dnaconversor.logic.mainlogic.functions;

import dnaconversor.logic.mainlogic.Codon;

public interface NucleicAcidParser {
    java.util.ArrayList<Codon> parse(String stringNucleicAcid);
}
