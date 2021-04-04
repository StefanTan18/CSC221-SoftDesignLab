
/**
 * Test file for Assignment #4.
 * <p>
 * Please do not modify
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TestA4 {

    // Used for date parsing to convert from String to Date. It also formats Date into a String
    private static final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private static final String INPUT_FILE_NAME = "Inventory.dat";


    public static void main(String[] args) throws Exception {

        Inventory inventoryList = new Inventory();

        try (Scanner scanner = new Scanner(new File(INPUT_FILE_NAME))) {

            // skips the file's header
            String line = scanner.nextLine();

            while (scanner.hasNextLine()) {

                line = scanner.nextLine();

                String[] arrLine = line.split(",");


                try {

                    Screen screen;

                    if (arrLine.length == 6) // lines with 6 parts are assumed of type CRT
                        screen = new CRT(Double.parseDouble(arrLine[5]), Long.parseLong(arrLine[0]), Double.parseDouble(arrLine[1]), formatter.parse(arrLine[2]), arrLine[3], arrLine[4]);
                    else if (arrLine.length == 7) // lines with 6 parts are assumed of type SmartTV
                        screen = new SmartTV(arrLine[6], Long.parseLong(arrLine[0]), Double.parseDouble(arrLine[1]), formatter.parse(arrLine[2]), arrLine[3], arrLine[4]);
                    else  // all else are assumed of type LED
                        screen = new LED(Long.parseLong(arrLine[0]), Double.parseDouble(arrLine[1]), formatter.parse(arrLine[2]), arrLine[3], arrLine[4]);

                    if (!inventoryList.addToInventory(screen)) // add and check for failure
                        System.err.println(String.format("Failed to add to inventory, skipping: %s", line));
                } catch (Exception ex) {

                    // Uncomment this line when debugging your code to see the full stack trace
                    // ex.printStackTrace();

                    System.err.printf("Duplicate inventory, skipping: %s%n", line);
                }
            }

            System.out.printf("There are %d Screens in the inventory%n", inventoryList.inventoryCount());

            ArrayList<ComputerMonitor> listComputerMonitor = inventoryList.listComputerMonitor();
            System.out.printf("There are %d Computer Monitors%n", listComputerMonitor.size());

            ArrayList<SmartTV> listSmartTV = inventoryList.listSmartTV();
            System.out.printf("There are %d Smart TVs%n", listSmartTV.size());

            inventoryList.printInventory();
        } catch (FileNotFoundException fnfe) {

            System.err.println("Failed to open file: " + Paths.get(INPUT_FILE_NAME));
            fnfe.printStackTrace();
        }
    }
}