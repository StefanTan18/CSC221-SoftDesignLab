import java.util.Date; // used for the Date object in this class

/**
 * The CRT class inherits from the ComputerMonitor class and stores important information of CRTs including the same
 * information from ComputerMonitor with the additional information of the glass thickness. This class will be used by the
 * Inventory class.
 * 
 * @author Stefan Tan
 */
public class CRT extends ComputerMonitor {

    // private member variable holding the glass thickness of the CRT as a double
    private double glassThickness;

    /**
     * This the non-default constructor of the CRT class and is called when the CRT class is
     * instantiated with parameters provided. When called, it sets the member variables, glassThickness, 
     * id, price, makeDate, manufacturer, and model to their respective value that was provided.
     * @param glassThickness The member variable glassThickness will be set to this double value.
     * @param id The member variable id will be set to this long value.
     * @param price The member variable price will be set to this double value.
     * @param makeDate The member variable makeDate will be set to this Date object.
     * @param manufacturer The member variable manufacturer will be set to this String value.
     * @param model The member variable model will be set to this String value.
     */
    public CRT(double glassThickness, long id, double price, Date makeDate, String manufacturer, String model) {
        super(id, price, makeDate, manufacturer, model);
        this.glassThickness = glassThickness;
    }

    /**
     * This is the accessor method for the member variable glassThickness. It returns the double value
     * stored in the member variable glassThickness.
     * @return double This returns the current double value stored in the member variable glassThickness.
     */
    public double getThickness() {
        return glassThickness;
    }

    /**
     * This is the mutator method for the member variable glassThickness. It sets the member variable glassThickness to
     * what is provided in the parameter.
     * @param glassThickness The member variable glassThickness will be set to this double value.
     */
    public void setGlassThickness(double glassThickness) {
        this.glassThickness = glassThickness;
    }

    /**
     * This method returns a String that represents the instance.
     * @return String This returns the String "CRT (3)".
     */
    @Override
    public String toString() {
        return "CRT (3)";
    }

    /**
     * This method compares if this instance and an object are equal. They are equal if the two objects have the same
     * id and model.
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
        if (other instanceof CRT && super.equals(other)) {
            return this.getModel().equals(((CRT) other).getModel());
        }
        return false;
    }
}