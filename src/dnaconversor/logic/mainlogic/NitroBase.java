package adnconversor.logic.mainlogic;

import adnconversor.exceptions.*;

/**
 * Represents a <strong>Nitrogenous Bases</strong> of
 * a codon string in Nucleic Acids(DNA & RNA)
 * 
 * @author SGS-J
 */
public enum NitroBase {

    ADENINE('A'), GUANINE('G'),
    THYMINE('T'), CYTOSINE('C'),
    URACIL('U');

    private final char value;

    private NitroBase(char value) {
        this.value = value;
    }

    public static char toChar(NitroBase nitroBaseValues) {
        char letterOfNitroBase = ' ';
        switch (nitroBaseValues) {
            case ADENINE:
                letterOfNitroBase = 'A';
                break;
            case GUANINE:
                letterOfNitroBase = 'G';
                break;
            case THYMINE:
                letterOfNitroBase = 'T';
                break;
            case CYTOSINE:
                letterOfNitroBase = 'C';
                break;
            case URACIL:
                letterOfNitroBase = 'U';
                break;
        }
        return letterOfNitroBase;
    }

    public static NitroBase parse(char nitroBaseLetter) {
        try {
            Character.toUpperCase(nitroBaseLetter);
            switch (nitroBaseLetter) {
                case 'A':
                    return NitroBase.ADENINE;
                case 'G':
                    return NitroBase.GUANINE;
                case 'T':
                    return NitroBase.THYMINE;
                case 'C':
                    return NitroBase.CYTOSINE;
                case 'U':
                    return NitroBase.URACIL;
                default:
                    throw new ParseNitroBaseException("Error in the parse");
            }
        } catch (ParseNitroBaseException e) {
            e.printAndExit();
            return null;
        }
    }

    public static NitroBase[] parse(char[] nitroBaseLetter) {
        // create a NitroBase array to add to codon
        NitroBase[] nitroBaseAdder = new NitroBase[3];
        try {
            // verify the char array, and throw exception if is necessary
            if (nitroBaseLetter.length > 3) {
                throw new IllegalNitroBaseLenghtException(
                        "Invalid codon lenght!"
                );
            }

            // iterator for the already said object NitroBase
            int i = 0;
            for (char letterOfNitroBase : nitroBaseLetter) {
                // convert to Upper case if is necessary
                Character.toUpperCase(letterOfNitroBase);
                switch (letterOfNitroBase) {
                    case 'A':
                        nitroBaseAdder[i] = NitroBase.ADENINE;
                        break;
                    case 'G':
                        nitroBaseAdder[i] = NitroBase.GUANINE;
                        break;
                    case 'T':
                        nitroBaseAdder[i] = NitroBase.THYMINE;
                        break;
                    case 'C':
                        nitroBaseAdder[i] = NitroBase.CYTOSINE;
                        break;
                    case 'U':
                        nitroBaseAdder[i] = NitroBase.URACIL;
                        break;
                    default:
                        // The value is invalid, throw an exception
                        throw new IncompatibleCodonCharException(
                                "Incompatible chars typed in the codon"
                        );
                }
                i++;
            }
            
            return nitroBaseAdder;
        } catch (IncompatibleCodonCharException
                | IllegalNitroBaseLenghtException e) {
            e.printAndExit();
            return null;
        }
    }

    public char getCharValue() {
        return value;
    }

}
