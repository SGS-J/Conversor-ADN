/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adnconversor.logic.mainlogic.caseForms;

/**
 *
 * @author usuario
 */
public @interface CaseForm {
    String PHE_CASE[] = {"UUU", "UUC"};
    String LEU_CASE[] = {"UUA", "UUG", "CUU", "CUC", "CUA", "CUG"};
    String ISO_CASE[] = {"AUU", "AUC", "AUA"};
    String MET_CASE[] = {"AUG"};
    String VAL_CASE[] = {"GUU", "GUC", "GUA", "GUG"};
    String SER_CASE[] = {"UCU", "UCC", "UCA", "UCG", "AGU", "AGC"};
    String PRO_CASE[] = {"CCU", "CCC", "CCA", "CCG"};
    String THR_CASE[] = {"ACU", "ACC", "ACA", "ACG"};
    String ALA_CASE[] = {"GCU", "GCC", "GCA", "GCG"};
    String TYR_CASE[] = {"UAU", "UAC"};
    String HIS_CASE[] = {"CAU", "CAC"};
    String GLN_CASE[] = {"CAA", "CAG"};
    String ASN_CASE[] = {"AAU", "AAC"};
    String LYS_CASE[] = {"AAA", "AAG"};
    String ASP_CASE[] = {"GAU", "GAC"};
    String GLU_CASE[] = {"GAA", "GAG"};
    String CYS_CASE[] = {"UGU", "UGC"};
    String TRY_CASE[] = {"UGG"};
    String ARG_CASE[] = {"CGU", "CGC", "CGA", "CGG", "AGA", "AGG"};
    String GLY_CASE[] = {"GGU", "GGC", "GGA", "GGG"};
}
