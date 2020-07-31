package dnaconversor.logic.mainlogic;

import dnaconversor.exceptions.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Esta clase representa Codones de cadenas de ADN.<p>
 * <strong>Recordar!</strong> Para instanciar la clase debes usar los
 * siguientes metodos estaticos <code>
 * createWithChars,
 * createWithArray,
 * createWithOneBase,
 * createWithTwoBases </code> y
 * <code>createWithThreeBases
 * </code>
 * 
 * @author SGS-J
 */
public class Codon {

    private ArrayList<NitroBase> nitroBases;
    private boolean isCompleteCodon;
    
    // Constructor por defecto activado, el resto es privado.
    public Codon() {
       nitroBases = new ArrayList<>();
    }

    private Codon(NitroBase... nitrogenousBases) {
        try {
            if (nitrogenousBases.length > 3 || nitrogenousBases.length == 0) {
                throw new IllegalNitroBaseLenghtException();
            }
        } catch (IllegalNitroBaseLenghtException e) {
            e.reportAndExit();
        }
        if(nitrogenousBases.length < 3){
            isCompleteCodon = false;
        }
        
        nitroBases = new ArrayList<>();
        nitroBases.addAll(Arrays.asList(nitrogenousBases));
    }

    private Codon(NitroBase firstBase) {
        nitroBases = new ArrayList<>();
        nitroBases.add(firstBase);
        isCompleteCodon = false;
    }

    private Codon(NitroBase firstBase, NitroBase secondBase) {
        this(firstBase);
        nitroBases.add(secondBase);
    }

    private Codon(NitroBase firstBase, NitroBase secondBase, NitroBase thirdBase) {
        this(firstBase, secondBase);
        nitroBases.add(thirdBase);
        isCompleteCodon = true;
    }

    private Codon(char[] charNitroBase){
        NitroBase adder[] = NitroBase.parse(charNitroBase);
        nitroBases = new ArrayList<>(Arrays.asList(adder));
        isCompleteCodon = adder.length == 3;
    }
    
    // ----- Metodos para crear el objeto ----- 
    public static Codon createWithArray(NitroBase[] nitrogenousBases) {
        return new Codon(nitrogenousBases);
    }

    public static Codon createWithOneBase(NitroBase firstBase) {
        return new Codon(firstBase);
    }

    public static Codon createWithTwoBases(NitroBase firstBase, NitroBase secondBase) {
        return new Codon(firstBase, secondBase);
    }

    public static Codon createWithThreeBases(NitroBase firstBase, NitroBase secondBase, NitroBase thirdBase) {
        return new Codon(firstBase, secondBase, thirdBase);
    }
    
    public static Codon createWithChars(char[] charNitroBase) {
        return new Codon(charNitroBase);
    }
    // ----- Fin declararcion de metodos de instanciacion -----

    public ArrayList<NitroBase> getNitroBases() {
        return nitroBases;
    }

    public void setNitroBases(ArrayList<NitroBase> nitroBases) {
        this.nitroBases = nitroBases;
    }

    public boolean isCompleteCodon() {
        return isCompleteCodon = getNitroBases().size() == 3;
    }
    
    public static Codon parse (String codonString){
        return Codon.createWithChars(codonString.toCharArray());
    }
    
    @Override
    public String toString() {
        String strConvert = "";
        for (NitroBase nitroBase : nitroBases) {
            strConvert += nitroBase.getCharValue();
        }
        return strConvert;
    }

}
