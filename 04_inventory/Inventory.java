import java.text.SimpleDateFormat; // used to format the Date object when printing it out
import java.util.ArrayList; // used to store multiple Screen objects

/**
 * The Inventory class is used to represent an inventory system. It holds multiple Screen objects and is
 * able to list ComputerMonitors and SmartTVs and print the inventory along with the number of screens in the
 * inventory.
 * 
 * @author Stefan Tan
 */
public class Inventory {

    // private final ArrayList holding objects of type Screen 
    private final ArrayList<Screen> listInventory;

    // private static final String members that hold the header and separator that are used to print out the inventory
    private static final String SEPARATOR = "+-------------+-------------+-------------+------------+--------------+----------+-------+------------+";
    private static final String HEADER = "|    Type     |     ID      |    Price    | Make Date  | Manufacturer | Model    | Glass |     OS     |";

    /**
     * This is the default constructor of the Inventory class and is called when the Inventory class
     * is instantiated without any parameters. When called it instantiates an empty ArrayList listInventory.
     */
    public Inventory() {
        listInventory = new ArrayList<Screen>();
    }

    /**
     * This method returns the number of Screen objects in the ArrayList listInventory.
     * @return int This returns the number of Screen objects in listInventory.
     */
    public int inventoryCount() {
        return listInventory.size();
    }

    /**
     * This method takes in a Screen object and checks to see if it a similar instance already
     * exists in listInventory. If there is, then an Exception is thrown. If not, then the object
     * is added to listInventory and true is returned.
     * @param screen The Screen object that will be added to listInventory.
     * @return boolean true is returned if the object is added to listInventory successfully.
     * @throws Exception This is thrown along with a message when a duplicate of the object is found in
     * listInventory.
     */
    public boolean addToInventory(Screen screen) throws Exception {
        // Checks to see if there's a similar instance of screen in listInventory
        if (listInventory.contains(screen)) {
            // Throws exception along with message if duplicate is found
            throw new Exception("The inventory contains a similar Screen object");
        }
        // Otherwise, adds the object to listInventory
        listInventory.add(screen);
        return true;
    }

    /**
     * This method returns a new list containing instances of the type ComputerMonitor from
     * listInventory.
     * @return ArrayList<ComputerMonitor> An ArrayList of ComputerMonitor objects is returned.
     */
    public ArrayList<ComputerMonitor> listComputerMonitor() {
        ArrayList<ComputerMonitor> computerMonitors = new ArrayList<ComputerMonitor>();
        // Loops through listInventory
        for (Screen screen : listInventory) {
            // Checks to see if the object in listInventory is of type ComputerMonitor
            if (screen instanceof ComputerMonitor) {
                ComputerMonitor computerMonitor = (ComputerMonitor) screen;
                computerMonitors.add(computerMonitor);
            }
        }
        return computerMonitors;
    }

    /**
     * This method returns a new list containing instances of the type SmartTV from
     * listInventory.
     * @return ArrayList<SmartTV> An ArrayList of SmartTV objects is returned.
     */
    public ArrayList<SmartTV> listSmartTV() {
        ArrayList<SmartTV> smartTVs = new ArrayList<SmartTV>();
        // Loops through listInventory
        for (Screen screen : listInventory) {
            // Checks to see if the object in listInventory is of type SmartTV
            if (screen instanceof SmartTV) {
                SmartTV smartTV = (SmartTV) screen;
                smartTVs.add(smartTV);
            }
        }
        return smartTVs;
    }

    /**
     * This method prints a table containing the information from listInventory.
     */
    public void printInventory() {
        // Heading is first printed out
        System.out.println(SEPARATOR);
        System.out.println(HEADER);
        System.out.println(SEPARATOR);
        // Loops through listInventory
        for (Screen screen : listInventory) {
            String type = screen.toString();
            
            // Allows the Date object to be formatted correctly
            String pattern = "MM/dd/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String makeDate = simpleDateFormat.format(screen.getMakeDate());
            switch (type) {
                // If the object is of type SmartTV then it also prints out the operating system
                case "SmartTV (2)":
                    SmartTV smartTV = (SmartTV) screen;
                    System.out.printf("| %-11s | %-11d | $%-10.2f | %-9s | %-12s | %-8s |       | %-10s |%n", type, smartTV.getId(), smartTV.getPrice(), makeDate, smartTV.getManufacturer(), smartTV.getModel(), smartTV.getOperatingSystem());
                    System.out.println(SEPARATOR);
                    break;
                // If the object is of type CRT then it also prints out the glass thickness
                case "CRT (3)":
                    CRT crt = (CRT) screen;
                    System.out.printf("| %-11s | %-11d | $%-10.2f | %-9s | %-12s | %-8s | %-5.2f |            |%n", type, crt.getId(), crt.getPrice(), makeDate, crt.getManufacturer(), crt.getModel(), crt.getThickness());
                    System.out.println(SEPARATOR);
                    break;
                // Otherwise, nothing is printed out for the operating system and glass thickness
                default:
                    System.out.printf("| %-11s | %-11d | $%-10.2f | %-9s | %-12s | %-8s |       |            |%n", type, screen.getId(), screen.getPrice(), makeDate, screen.getManufacturer(), screen.getModel());
                    System.out.println(SEPARATOR);
                    break;
            }
        }
    }
}
