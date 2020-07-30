package dnaconversor.logic.mainlogic;

import dnaconversor.exceptions.IncompatibleAminoAcidCharExc;
import dnaconversor.logic.mainlogic.caseForms.CaseForm;

public enum AminoAcid {

    PHE(CaseForm.PHE_CASE), LEU(CaseForm.LEU_CASE),
    ISO(CaseForm.ISO_CASE), MET(CaseForm.MET_CASE),
    VAL(CaseForm.VAL_CASE), SER(CaseForm.SER_CASE),
    PRO(CaseForm.PRO_CASE), THR(CaseForm.THR_CASE),
    ALA(CaseForm.ALA_CASE), TYR(CaseForm.TYR_CASE),
    HIS(CaseForm.HIS_CASE), GLN(CaseForm.GLN_CASE),
    ASN(CaseForm.ASN_CASE), LYS(CaseForm.LYS_CASE),
    ASP(CaseForm.ASP_CASE), GLU(CaseForm.GLU_CASE),
    CYS(CaseForm.CYS_CASE), TRY(CaseForm.TRY_CASE),
    ARG(CaseForm.ARG_CASE), GLY(CaseForm.GLY_CASE),
    STOP;

    private final String caseForm[];

    private AminoAcid(String... caseForm) {
        this.caseForm = caseForm;
    }

    public String[] getCaseForm() {
        return caseForm;
    }

    public boolean isValidAminoAcid() {
        return caseForm.length == 3;
    }

    public static AminoAcid getAminoAcidWithACodon(Codon codon) {
        try {
            if (codon.toString().contains("T")) {
                throw new IncompatibleAminoAcidCharExc("Error in the getter...");
            }
            AminoAcid acidToReturn = null;
            for (AminoAcid value : AminoAcid.values()) {
                for (String actualCaseForm : value.caseForm) {
                    if(codon.toString().equals(actualCaseForm)){
                        acidToReturn = value;
                        break;
                    }
                }
                if(acidToReturn != null){
                    break;
                }
            }
            if(acidToReturn == null){
                acidToReturn = STOP;
            }
            return acidToReturn;
        } catch (IncompatibleAminoAcidCharExc e) {
            e.allAndExit();
            return null;
        }
    }

}
