import java.util.Date; // used for the Date object in this class

/**
 * The LED class inherits from the ComputerMonitor class and stores important information of LEDs including the same
 * information from ComputerMonitor. This class will be used by the Inventory class.
 * 
 * @author Stefan Tan
 */
public class LED extends ComputerMonitor {

    /**
     * This the non-default constructor of the LED class and is called when the LED class is 
     * instantiated with parameters provided. When called, it sets the member variables, 
     * id, price, makeDate, manufacturer, and model to their respective value that was provided.
     * @param id The member variable id will be set to this long value.
     * @param price The member variable price will be set to this double value.
     * @param makeDate The member variable makeDate will be set to this Date object.
     * @param manufacturer The member variable manufacturer will be set to this String value.
     * @param model The member variable model will be set to this String value.
     */
    public LED(long id, double price, Date makeDate, String manufacturer, String model) {
        super(id, price, makeDate, manufacturer, model);
    }

    /**
     * This method compares if this instance and an object are equal. They are equal if the two objects have the same
     * id and price.
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
        if (other != null && other instanceof LED) {
            LED led = (LED) other;
            return (this.getId() == led.getId() && this.getPrice() == led.getPrice());
        }
        return false;
    }

    /**
     * This method returns a String that represents the instance.
     * @return String This returns the String "LED (3)".
     */
    @Override
    public String toString() {
        return "LED (3)";
    }
}