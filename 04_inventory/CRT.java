import java.util.Date;

public class CRT extends ComputerMonitor {

    private double glassThickness;

    public CRT(double glassThickness, long id, double price, Date makeDate, String manufacturer, String model) {
        super(id, price, makeDate, manufacturer, model);
        this.glassThickness = glassThickness;
    }

    public double getThickness() {
        return glassThickness;
    }

    public void setGlassThickness(double glassThickness) {
        this.glassThickness = glassThickness;
    }

    @Override
    public String toString() {
        return "CRT (3)";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && other instanceof CRT) {
            CRT crt = (CRT) other;
            return (this.getId() == crt.getId() && this.getModel().compareTo(crt.getModel()) == 0);
        }
        return false;
    }
}