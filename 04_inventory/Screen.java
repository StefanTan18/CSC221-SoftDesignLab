import java.util.Date;

public abstract class Screen {
    
    private long id;
    private double price;
    private Date makeDate;
    private String manufacturer;
    private String model;

    public Screen(long id, double price, Date makeDate, String manufacturer, String model) {
        this.id = id;
        this.price = price;
        this.makeDate = makeDate;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    @Override
    public abstract boolean equals(Object other);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Screen (1)";
    }
}