import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Inventory {

    private final ArrayList<Screen> listInventory;

    private static final String SEPARATOR = "+-------------+-------------+-------------+------------+--------------+----------+-------+------------+";
    private static final String HEADER = "|    Type     |     ID      |    Price    | Make Date  | Manufacturer | Model    | Glass |     OS     |";

    public Inventory() {
        listInventory = new ArrayList<Screen>();
    }

    public int inventoryCount() {
        return listInventory.size();
    }

    public boolean addToInventory(Screen screen) throws Exception {
        if (listInventory.contains(screen)) {
            throw new Exception("The inventory contains a similar Screen object");
        }
        listInventory.add(screen);
        return true;
    }

    public ArrayList<ComputerMonitor> listComputerMonitor() {
        ArrayList<ComputerMonitor> computerMonitors = new ArrayList<ComputerMonitor>();
        for (Screen screen : listInventory) {
            if (screen instanceof ComputerMonitor) {
                ComputerMonitor computerMonitor = (ComputerMonitor) screen;
                computerMonitors.add(computerMonitor);
            }
        }
        return computerMonitors;
    }

    public ArrayList<SmartTV> listSmartTV() {
        ArrayList<SmartTV> smartTVs = new ArrayList<SmartTV>();
        for (Screen screen : listInventory) {
            if (screen instanceof SmartTV) {
                SmartTV smartTV = (SmartTV) screen;
                smartTVs.add(smartTV);
            }
        }
        return smartTVs;
    }

    public void printInventory() {
        System.out.println(SEPARATOR);
        System.out.println(HEADER);
        System.out.println(SEPARATOR);
        for (Screen screen : listInventory) {
            String type = screen.toString();
            
            String pattern = "MM/dd/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String makeDate = simpleDateFormat.format(screen.getMakeDate());
            switch (type) {
                case "SmartTV (2)":
                    SmartTV smartTV = (SmartTV) screen;
                    System.out.printf("| %-11s | %-11d | $%-10.2f | %-9s | %-12s | %-8s |       | %-10s |%n", type, smartTV.getId(), smartTV.getPrice(), makeDate, smartTV.getManufacturer(), smartTV.getModel(), smartTV.getOperatingSystem());
                    System.out.println(SEPARATOR);
                    break;
                case "CRT (3)":
                    CRT crt = (CRT) screen;
                    System.out.printf("| %-11s | %-11d | $%-10.2f | %-9s | %-12s | %-8s | %-5.2f |            |%n", type, crt.getId(), crt.getPrice(), makeDate, crt.getManufacturer(), crt.getModel(), crt.getThickness());
                    System.out.println(SEPARATOR);
                    break;
                default:
                    System.out.printf("| %-11s | %-11d | $%-10.2f | %-9s | %-12s | %-8s |       |            |%n", type, screen.getId(), screen.getPrice(), makeDate, screen.getManufacturer(), screen.getModel());
                    System.out.println(SEPARATOR);
                    break;
            }
        }
    }
}
