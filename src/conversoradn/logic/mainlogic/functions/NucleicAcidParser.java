package conversoradn.logic.mainlogic.functions;

import conversoradn.logic.mainlogic.Codon;

public interface NucleicAcidParser {
    java.util.ArrayList<Codon> parse(String stringNucleicAcid);
}
