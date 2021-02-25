import java.util.GregorianCalendar; // used to get the current year

/**
 * The PersonInfo class stores important information about a person including the 
 * name, year of birth, height, and weight. This information will be used to calculate 
 * the BMI of the person. This along with the BMI classification and the rest of the 
 * information will be printed out through the TestBMI class.
 * 
 * @author Stefan Tan
 */
public class PersonInfo {

    private String name; // private variable member holding the person's name as a String
    private int yearOfBirth; // private variable member holding the person's year of birth as an int
    private double height; // private variable member holding the person's height as a double
    private double weight; // private variable member holding the person's weight as a double

    /**
     * This is the default constructor of the PersonInfo class and is called when the
     * PersonInfo class is instantiated without any parameters provided. When called, it
     * sets the member variables, name to an empty string, and yearOfBirth, height, and weight
     * to zero.
     */
    public PersonInfo() {
        this("", 0, 0, 0);
    }

    /**
     * This is the non-default constructor of the PersonInfo class and is called when the
     * PersonInfo class is instantiated with parameters provided. When called, it
     * sets the member variables, name, yearOfBirth, height, and weight to their respective
     * values that were provided.
     * @param name The member variable name will be set to this String value.
     * @param yearOfBirth The member variable yearOfBirth will be set to this int value.
     * @param height The member variable height will be set to this double value.
     * @param weight The member variable weight will be set to this double value.
     */
    public PersonInfo(String name, int yearOfBirth, double height, double weight) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.height = height;
        this.weight = weight;
    }

    /**
     * This is the accessor method for the member variable name. It returns the String value
     * stored in the member variable name.
     * @return String This returns the current String stored in the member variable name.
     */
    public String getName() {
        return name;
    }

    /**
     * This is the mutator method for the member variable name. It sets the member variable name to
     * what is provided in the parameter.
     * @param name The member variable name will be set to this String value.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is the accessor method for the member variable yearOfBirth. It returns the int value
     * stored in the member variable yearOfBirth.
     * @return int This returns the current int stored in the member variable yearOfBirth.
     */
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * This is the mutator method for the member variable yearOfBirth. It sets the member variable yearOfBirth 
     * to what is provided in the parameter.
     * @param yearOfBirth The member variable yearOfBirth will be set to this int value.
     */
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * This is the accessor method for the member variable height. It returns the double value
     * stored in the member variable height.
     * @return double This returns the current double stored in the member variable height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * This is the mutator method for the member variable height. It sets the member variable height 
     * to what is provided in the parameter.
     * @param height The member variable height will be set to this double value.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * This is the accessor method for the member variable weight. It returns the double value
     * stored in the member variable weight.
     * @return double This returns the current double stored in the member variable weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * This is the mutator method for the member variable weight. It sets the member variable weight 
     * to what is provided in the parameter.
     * @param weight The member variable weight will be set to this double value.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * This method is used to calculate the age of the person using the member variable yearOfBirth
     * and the current year.
     * @return int This returns the age of the person.
     */
    public int calculateAge() {
        int currentYear = new GregorianCalendar().get(GregorianCalendar.YEAR); // used to get current year
        int age = currentYear - yearOfBirth; // age is calculated by subtracting current year and year of birth
        return age;
    }

    /**
     * This method is used to calculate the BMI of the person using the member variables weight
     * and height. The formula used to calculate the BMI is the weight divided by the height squared.
     * @return double This returns the BMI of the person.
     */
    public double calculateBMI() {
        double bmi = weight / (height * height); // BMI is calculated by dividing the weight by the height squared
        return bmi;
    }
}