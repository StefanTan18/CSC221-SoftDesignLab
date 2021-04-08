import java.util.Date; // used for the Date object in this class

/**
 * The SmartTV class inherits from the Screen class and stores important information of smart TVs including the same
 * information from Screen with the additional information of the operating system. This class will be used by the
 * Inventory class.
 * 
 * @author Stefan Tan
 */
public class SmartTV extends Screen {

    // private member variable holding the operating system of the smart TV as a String
    private String operatingSystem;

    /**
     * This the non-default constructor of the SmartTV class and is called when the SmartTV class is
     * instantiated with parameters provided. When called, it sets the member variables, operatingSystem, 
     * id, price, makeDate, manufacturer, and model to their respective value that was provided.
     * @param operatingSystem The member variable operatingSystem will be set to this String value.
     * @param id The member variable id will be set to this long value.
     * @param price The member variable price will be set to this double value.
     * @param makeDate The member variable makeDate will be set to this Date object.
     * @param manufacturer The member variable manufacturer will be set to this String value.
     * @param model The member variable model will be set to this String value.
     */
    public SmartTV(String operatingSystem, long id, double price, Date makeDate, String manufacturer, String model) {
        super(id, price, makeDate, manufacturer, model);
        this.operatingSystem = operatingSystem;
    }

    /**
     * This method compares if this instance and an object are equal. They are equal if the two objects have the same
     * id, price, and model.
     * @param other The object that this instance is being compared to.
     * @return boolean This returns true if they are equal and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        // They are equal if this instance and the other object are the same
        if (this == other) { // checks to see if they are pointing to the same instance
            return true;
        }
        // Makes sure the other object is not null and avoids possible ClassCastException
        if (other != null && other instanceof SmartTV) {
            SmartTV smartTV = (SmartTV) other;
            return (this.getId() == smartTV.getId() && this.getPrice() == smartTV.getPrice() && this.getModel().compareTo(smartTV.getModel()) == 0);
        }
        return false;
    }

    /**
     * This is the accessor method for the member variable operatingSystem. It returns the String value
     * stored in the member variable operatingSystem.
     * @return String This returns the current String value stored in the member variable operatingSystem.
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * This is the mutator method for the member variable operatingSystem. It sets the member variable operatingSystem to
     * what is provided in the parameter.
     * @param operatingSystem The member variable operatingSystem will be set to this String value.
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * This method returns a String that represents the instance.
     * @return String This returns the String "SmartTV (2)".
     */
    @Override
    public String toString() {
        return "SmartTV (2)";
    }
}