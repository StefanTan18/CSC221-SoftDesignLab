import java.util.Date;

public class SmartTV extends Screen {

    private String operatingSystem;

    public SmartTV(String operatingSystem, long id, double price, Date makeDate, String manufacturer, String model) {
        super(id, price, makeDate, manufacturer, model);
        this.operatingSystem = operatingSystem;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && other instanceof SmartTV) {
            SmartTV smartTV = (SmartTV) other;
            return (this.getId() == smartTV.getId() && this.getPrice() == smartTV.getPrice() && this.getModel().compareTo(smartTV.getModel()) == 0);
        }
        return false;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "SmartTV (2)";
    }
}