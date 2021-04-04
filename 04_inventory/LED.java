import java.util.Date;

public class LED extends ComputerMonitor {

    public LED(long id, double price, Date makeDate, String manufacturer, String model) {
        super(id, price, makeDate, manufacturer, model);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && other instanceof LED) {
            LED led = (LED) other;
            return (this.getId() == led.getId() && this.getPrice() == led.getPrice());
        }
        return false;
    }

    @Override
    public String toString() {
        return "LED (3)";
    }
}