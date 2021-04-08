import java.util.Date; // used for the Date object in this class

/**
 * The Screen class is an abstract class that stores important information of screens
 * including the ID, price, make date, manufacturer, and model. This information will be
 * used by the Inventory class and classes that inherit from this class.
 * 
 * @author Stefan Tan
 */
public abstract class Screen {
    
    // private variable member holding the id of the screen as a long
    private long id;

    // private variable member holding the price of the screen as a double
    private double price;

    // private variable member holding the make date of the screen as a Date object
    private Date makeDate;

    // private variable member holding the manufacturer of the screen as a String
    private String manufacturer;

    // private variable member holding the holding the model of the screen as a String
    private String model;

    /**
     * This the non-default constructor of the Screen class and is called when the Screen class is
     * instantiated with parameters provided. When called, it sets the member variables, id, price,
     * makeDate, manufacturer, and model to their respective value that was provided.
     * @param id The member variable id will be set to this long value.
     * @param price The member variable price will be set to this double value.
     * @param makeDate The member variable makeDate will be set to this Date object.
     * @param manufacturer The member variable manufacturer will be set to this String value.
     * @param model The member variable model will be set to this String value.
     */
    public Screen(long id, double price, Date makeDate, String manufacturer, String model) {
        this.id = id;
        this.price = price;
        this.makeDate = makeDate;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    /**
     * This is an abstract method that will defined in classes that inherit from this class.
     * @param other The object that is being compared to this instance.
     * @return boolean This returns true or false based on the implementation in the subclasses.
     */
    @Override
    public abstract boolean equals(Object other);

    /**
     * This is the accessor method for the member variable id. It returns the long value
     * stored in the member variable id.
     * @return long This returns the current long value stored in the member variable id.
     */
    public long getId() {
        return id;
    }

    /**
     * This is the mutator method for the member variable id. It sets the member variable id to
     * what is provided in the parameter.
     * @param id The member variable id will be set to this long value.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * This is the accessor method for the member variable price. It returns the double value
     * stored in the member variable price.
     * @return double This returns the current double value stored in the member variable price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * This is the mutator method for the member variable price. It sets the member variable price to
     * what is provided in the parameter.
     * @param price The member variable price will be set to this double value.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This is the accessor method for the member variable makeDate. It returns the Date value
     * stored in the member variable makeDate.
     * @return Date This returns the current Date value stored in the member variable makeDate.
     */
    public Date getMakeDate() {
        return makeDate;
    }

    /**
     * This is the mutator method for the member variable makeDate. It sets the member variable makeDate to
     * what is provided in the parameter.
     * @param makeDate The member variable makeDate will be set to this Date object.
     */
    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

    /**
     * This is the accessor method for the member variable manufacturer. It returns the String value
     * stored in the member variable manufacturer.
     * @return String This returns the current String value stored in the member variable manufacturer.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * This is the mutator method for the member variable manufacturer. It sets the member variable manufacturer to
     * what is provided in the parameter.
     * @param manufacturer The member variable manufacturer will be set to this String value.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * This is the accessor method for the member variable model. It returns the String value
     * stored in the member variable model.
     * @return String This returns the current String value stored in the member variable model.
     */
    public String getModel() {
        return model;
    }

    /**
     * This is the mutator method for the member variable model. It sets the member variable model to
     * what is provided in the parameter.
     * @param model The member variable model will be set to this String value.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * This method returns a String that represents the instance.
     * @return String This returns the String "Screen (1)".
     */
    @Override
    public String toString() {
        return "Screen (1)";
    }
}