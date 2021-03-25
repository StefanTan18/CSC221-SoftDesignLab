/**
 * The MorseCode class stores the character and its corresponding encoding. This information
 * will be use to convert text into Morse Code in the MorseCodeConvert class and the
 * TestMorseConverter class.
 * 
 * @author Stefan Tan
 */
public class MorseCode {

    // private char variable member holding a character values of ASCII codes between 32 and 90 
    private char character;

    // private String variable member holding the corresponding encoding for the character
    private String encoding;

    /**
     * This is the non-default constructor of the MorseCode class and is called when the MorseCode
     * class is instantiated with the parameters provided. It checks that the parameters provided is
     * valid and meets the requirements stated.
     * @param character The member variable character will be set to this char value if it's valid.
     * @param encoding The member variable encoding will be set to this String value if it's valid.
     * @throws Exception This is thrown when the parameters provided do not meet the requirements.
     */
    public MorseCode(char character, String encoding) throws Exception {
        // The character values of ASCII codes must be between 32 and 90
        // The encoding value cannot be NULL and must be of length at least 1
        if (character >= 32 && character <= 90 && encoding != null && encoding.length() >= 1) {
            this.character = character;
            this.encoding = encoding;
        }
        // Otherwise throw an Exception with a message
        else {
            String message = String.format("The character %c is not a supported Morse character", character);
            throw new Exception(message);
        }
    }

    /**
     * This is the accessor method for the member variable character. It returns the current char value
     * stored in the member variable character.
     * @return char Returns the current char stored in the member variable character.
     */
    public char getCharacter() {
        return character;
    }

    /**
     * This is the mutator method for the member variable character. It sets the member variable
     * character to the parameter provided.
     * @param character The member variable character will be set to this char value.
     */
    public void setCharacter(char character) {
        this.character = character;
    }

    /**
     * This is the accessor method for the member variable encoding. It returns the current String value
     * stored in the member variable encoding.
     * @return String Returns the current String stored in the member variable encoding.
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * This is the mutator method for the member variable encoding. It sets the member variable encoding
     * to the parameter provided.
     * @param encoding The member variable encoding will be set to this String value.
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

}