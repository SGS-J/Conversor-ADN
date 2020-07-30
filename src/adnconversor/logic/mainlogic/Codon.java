package adnconversor.logic.mainlogic;

import adnconversor.exceptions.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class that represents a Codon of DNA strings.<p>
 * <strong>REMEMBER!</strong> To instantiate this class you must use the static
 * methods <code>
 * createWithChars,
 * createWithArray,
 * createWithOneBase,
 * createWithTwoBases </code> and
 * <code>createWithThreeBases
 * </code> methods(keep it in mind you can instantiate with a default constructor).
 * 
 * @author SGS-J
 */
public class Codon {

    private ArrayList<NitroBase> nitroBases;
    private boolean isCompleteCodon;
    
    /*
      Sets a private access to the all constructors(except default),
      the object Codon can be created with the static predefined methods
      below the constructors.
     */
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
    
    // ----- Methods declarated to create this object ----- 
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
    // ----- End of create object methods declaration -----

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
