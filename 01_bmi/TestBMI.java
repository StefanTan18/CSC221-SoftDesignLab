import java.util.Scanner; // used Scanner to read user's inputs

/**
 * The TestBMI class is uses the information provided by the user to input the
 * information necessary for the PersonInfo class through the use of the Scanner class. 
 * Using the information provided by the user, TestBMI will classify the BMI as "Underweight", 
 * "Normal Weight", "OverWeight", or "Obese" and print this out along with the rest of the 
 * information given by the user.
 * 
 * @author Stefan Tan
 */
public class TestBMI {

    /**
     * This method is used to classify the person's BMI based on the value of the BMI. If the
     * BMI is less than 18.5, then the person is classified as "Underweight", if the BMI is
     * between 18.5 and 25, then the person is classified as "Normal Weight", if the BMI is 
     * between 25 and 30, then the person is classified as "Overweight", and if the BMI is
     * than 30, then the person is classified as "Obese".
     * @param bmi This double value is used to determine the classification that is returned.
     * @return String This returns the classification based on BMI.
     */
    public static String classifyBMI(double bmi) {
        if (bmi < 18.5) { // BMI is less than 18.5
            return "Underweight";
        }
        else if (bmi < 25) { // BMI is between 18.5 and 25
            return "Normal Weight";
        }
        else if (bmi < 30) { // BMI is between 25 and 30
            return "Overweight";
        }
        else { // BMI is greater than 30
            return "Obese";
        }
    }

    /**
     * This is the main method that creates two instances of the PersonInfo class, one using
     * the default constructor, and the other using the non-default constructor. The user inputs
     * information for these instances through the use of the Scanner class. The person's information 
     * along with the calculated age and classification of BMI are then printed out.
     * @param args This is an array holding the command line arguments. It is not used in this case.
     */
    public static void main(String[] args) {

        // Instantiating scanner so that it reads the user's inputs
        Scanner scanner = new Scanner(System.in);

        // Creating an instance of PersonInfo using the default constructor
        PersonInfo person1 = new PersonInfo();

        // Reads user's inputs for the first instance of PersonInfo
        System.out.printf("%nFirst Instance Prompts%n");
        System.out.printf("Enter person's name: ");
        String name1 = scanner.nextLine();
        System.out.printf("Enter person's year of birth: ");
        int yearOfBirth1 = scanner.nextInt();
        System.out.printf("Enter person's height in meters: ");
        double height1 = scanner.nextDouble();
        System.out.printf("Enter person's weight in kilograms: ");
        double weight1 = scanner.nextDouble();

        // Using mutator methods to set the member variables of the first instance of PersonInfo
        person1.setName(name1);
        person1.setYearOfBirth(yearOfBirth1);
        person1.setHeight(height1);
        person1.setWeight(weight1);

        // Reads user's inputs for the second instance of PersonInfo
        System.out.printf("%nSecond Instance Prompts%n");
        System.out.printf("Enter person's name: ");
        scanner.nextLine(); // Gets rid of the new line input left by scanner.nextDouble()
        String name2 = scanner.nextLine();
        System.out.printf("Enter person's year of birth: ");
        int yearOfBirth2 = scanner.nextInt();
        System.out.printf("Enter person's height in meters: ");
        double height2 = scanner.nextDouble();
        System.out.printf("Enter person's weight in kilograms: ");
        double weight2 = scanner.nextDouble();

        // Creating an instance of PersonInfo using the non-default constructor
        PersonInfo person2 = new PersonInfo(name2, yearOfBirth2, height2, weight2);

        // Prints out information for the first instance of PersonInfo
        System.out.printf("%n1st instance Output%n");
        System.out.printf("%16s%s%n", "Full Name: ", person1.getName());
        System.out.printf("%16s%d%n", "Age: ", person1.calculateAge());
        System.out.printf("%16s%.2f%n", "Height: ", person1.getHeight());
        System.out.printf("%16s%.2f%n", "Weight: ", person1.getWeight());
        System.out.printf("%16s%s%n", "Classification: ", classifyBMI(person1.calculateBMI()));

        // Prints out information for the second instance of PersonInfo
        System.out.printf("%n2nd instance Output%n");
        System.out.printf("%16s%s%n", "Full Name: ", person2.getName());
        System.out.printf("%16s%d%n", "Age: ", person2.calculateAge());
        System.out.printf("%16s%.2f%n", "Height: ", person2.getHeight());
        System.out.printf("%16s%.2f%n", "Weight: ", person2.getWeight());
        System.out.printf("%16s%s%n%n", "Classification: ", classifyBMI(person2.calculateBMI()));

        scanner.close(); // Closes scanner
    }
}