import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Unit test class for MorseCodeConvert.java
 * Class assumes that MorseCodes.txt is in the classpath, if not update the path accordingly
 *
 * @author Ayman Zeidan
 */
public class TestMorseConverter {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            MorseCodeConvert morseCodeConvert = new MorseCodeConvert("MorseCodes.txt");

            int choice = 0;
            // show menu and prompt for option selection
            while (choice != 4) {

                System.out.println("Select one of the following choices: ");
                System.out.printf("%2s1. Print conversion codes.%n", "");
                System.out.printf("%2s2. Convert string.%n", "");
                System.out.printf("%2s3. Convert file.%n", "");
                System.out.printf("%2s4. Exit.%n", "");
                System.out.print("Choice (1-4): ");

                String userInput = scanner.next();

                choice = 0;

                // input range validation
                if (userInput.length() == 1 && userInput.charAt(0) >= '1' && userInput.charAt(0) <= '4')
                    choice = Character.getNumericValue(userInput.charAt(0));

                // clear input buffer
                scanner.nextLine();

                String fileName = "";

                try {

                    switch (choice) {
                        case 1: // option 1 prints the char-to-Morse code conversion table
                            morseCodeConvert.printEncodingList();
                            break;
                        case 2: // option 2 prompts for a line and converts it to Morse code
                            // ensures the convertString method can handle null and empty string inputs
                            morseCodeConvert.encodeString(null);
                            morseCodeConvert.encodeString("");

                            System.out.print("Enter line to convert: ");
                            String line = scanner.nextLine();
                            morseCodeConvert.encodeString(line);
                            break;
                        case 3: // option 3 prompts for a file and converts its content to Morse code
                            System.out.print("Enter file name: ");
                            fileName = scanner.nextLine();
                            morseCodeConvert.encodeFile(fileName);
                            break;
                        case 4: // option 4 is to exit the program
                            break;
                        default: // invalid input received
                            System.err.printf("%n\"%s\" is not a valid option. Try again!%n%n", userInput);
                    }
                } catch (FileNotFoundException fnfe) {
                    System.err.println("Failed to open file: " + Paths.get(fileName));
                } catch (Exception ex) {
                    System.err.println(ex.toString());
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println("\nProgram terminated");
    }
}