import java.util.Date;

public abstract class ComputerMonitor extends Screen {

    public ComputerMonitor(long id, double price, Date makeDate, String manufacturer, String model) {
        super(id, price, makeDate, manufacturer, model);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && other instanceof ComputerMonitor) {
            ComputerMonitor computerMonitor = (ComputerMonitor) other;
            return (this.getId() == computerMonitor.getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "ComputerMonitor (2)";
    }
}
