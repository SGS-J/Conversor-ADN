package dnaconversor.logic.mainlogic;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class NucleicAcid{
    
    private ArrayList<Codon> codons;
    private boolean isPerfectString;
    
    public NucleicAcid() {
        this.codons = new ArrayList<>();
    }

    public NucleicAcid(Codon... codons) {
        this(new ArrayList(Arrays.asList(codons)));
    }

    public NucleicAcid(ArrayList<Codon> codons) {
        this.codons = new ArrayList<>(codons);
        isPerfectString = this.codons.get(this.codons.size() - 1).isCompleteCodon();
    }
    
    public abstract NucleicAcid replicate();
    
    public boolean isPerfectString() {
        return isPerfectString = getCodons()
                .get(getCodons().size() - 1)
                .isCompleteCodon();
    }
    
    public void setIsPerfectString(boolean isPerfectString) {
        this.isPerfectString = isPerfectString;
    }
    
    public ArrayList<Codon> getCodons() {
        return codons;
    }

    public void addCodon(Codon codon) {
        codons.add(codon);
    }
    
    public void setCodonsWithList(ArrayList<Codon> codons) {
        this.codons = codons;
    }
    
    public void setCodonsWithArray(Codon[] codons){
        this.codons = (ArrayList) Arrays.asList(codons);
    } 
     
    @Override
    public String toString() {
        String str = "";
        for (Codon codon : codons) {
            str += codon.toString();
            if (codon.isCompleteCodon()) {
                str += " ";
            }
        }
        return str;
    }
    
}
