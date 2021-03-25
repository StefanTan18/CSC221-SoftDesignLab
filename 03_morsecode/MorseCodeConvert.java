import java.io.FileInputStream; // used to read file inputs
import java.io.FileNotFoundException; // used to catch FileNotFound exceptions
import java.util.ArrayList; // used to store a collection of MorseCodes
import java.util.Scanner; // used to read inputs

/**
 * The MorseCodeConvert class stores the collection of characters and their corresponding encoding
 * to encode text. It takes in user inputs through either through the terminal or a file and outputs the input coded in
 * Morse code. It uses the MorseCode class as the object being stored in the ArrayList.
 * 
 * @author Stefan Tan 
 */
public class MorseCodeConvert {

    // private ArrayList of MorseCodes holding all the valid characters and their coresponding encoding
    private ArrayList<MorseCode> listCodes = new ArrayList<MorseCode>();

    /**
     * This is the non-default constructor that takes in a file name as a constructor and attempts to open
     * the file. If it fails, then an exception is thrown along with a message. If successful, then it reads all
     * the lines in the file and adds each valid line into the ArrayList. If an invalid line is encountered, then
     * it throws an exception from MorseCode and moves onto the next line in the file.
     * @param fileName This is file name that's going to be read and is stored as a String.
     * @throws Exception This is thrown along with a message when the constructor fails to open the file.
     */
    public MorseCodeConvert(String fileName) throws Exception {
        // Attempts to open the file and throws an exception along with a message if it fails
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            // Reads the file line by line until the end of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // If the line is empty then ignore it and continue to the next line
                if (line.isEmpty()) {
                    continue;
                }
                // Divides the line into multiple Strings by the tab in between 
                String codes[] = line.split("\t");
                // Checks to see if the line is valid, if not then it moves onto the next line
                if (codes.length != 2 || codes[0].length() != 1) {
                    System.out.printf("Invalid line: %s%n", line);
                    continue;
                }
                // Tries to add MorseCode to ArrayList listCodes but if an exception occurs then
                // it prints the exception message and continues onto the next line
                try {
                    MorseCode mCode = new MorseCode(codes[0].charAt(0), codes[1]);
                    listCodes.add(mCode);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            String message = String.format("Failed to open file: %s", fileName);
            throw new Exception(message);
        }
    }

    /**
     * This method prints the entire content of the ArrayList listCodes.
     */
    public void printEncodingList() {
        // Loops through listCodes and prints out the character along with the encoding
        for (MorseCode mCode : listCodes) {
            System.out.printf("('%c', %s)%n", mCode.getCharacter(), mCode.getEncoding());
        }
    }

    /**
     * This method takes in a string parameter and prints out the corresponding Morse code for
     * the string parameter. For invalid character, '?' is printed.
     * @param str The corresponding Morse code for str will be printed out.
     */
    public void encodeString(String str) {
        // String that holds that Morse code that will be printed
        String coded = "";
        // Prints new line when cases where the parameter is null or empty 
        if (str == null || str.isEmpty()) {
            System.out.print("\n");
        }
        else {
            // Converts the String to Morse code by looping character by character
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                // If the character is a whitespace, then move on to the next character
                if (c == ' ') {
                    continue;
                }
                // Converts the character to uppercase as encodings are only available for uppercase characters
                char upperCase = Character.toUpperCase(c);
                // Looks for the corresponding Morsecode of the character
                MorseCode mCode = find(upperCase);
                // Checks to see if the character is the last character of the string
                if (i == str.length() - 1) {
                    // Prints out '?' for the conversion of invalid characters
                    if (mCode == null) {
                        coded += '?';
                    }
                    // The corresponding encoding is added to the String coded
                    else {
                        coded += mCode.getEncoding();
                    }
                }
                // The character is not the last character of the String so a space must be added
                else {
                    // Prints out '?' for the conversion of invalid characters
                    if (mCode == null) {
                        coded += '?' + " ";
                    }
                    // The corresponding encoding is added to the String coded
                    else {
                        coded += mCode.getEncoding() + " ";
                    }
                }
            }
            // The Morse code conversion of the String is printed out
            System.out.println(coded);
        }
    }

    /**
     * This helper method takes in a character parameter and looks for the corresponding encoding
     * in the ArrayList listCodes.
     * @param character The corresponding Morse code of this chracter will be returned. 
     * @return MorseCode Returns the corresponding Morse code of the character. If not found, the null
     * is returned.
     */
    private MorseCode find(char character) {
        // Loops through the ArrayList listCodes
        for (int i = 0; i < listCodes.size(); i++) {
            // Returns the corresponding Morse code when the character is found in listCodes
            if (listCodes.get(i).getCharacter() == character) {
                return listCodes.get(i);
            }
        }
        // If character is not found then null is returned
        return null;
    }

    /**
     * This method takes in a file name as a parameter and prints out the corresponding Morse code
     * for the entire file's content. If the file is unable to be opened, then an exception is thrown
     * For invalid characters, '?' is printed.
     * @param fileName This is the name of the file that will be converted to Morse code.
     * @throws Exception This is thrown when along with a message when the file fails to open.
     */
    public void encodeFile(String fileName) throws Exception {
        // Attempts to open the file. If it fails, then an exception is thrown
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            // Reads and encodes the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                encodeString(line);
            }
        } catch (FileNotFoundException e) {
            String message = String.format("Failed to open file: %s", fileName);
            throw new Exception(message);
        }
    }
}