import java.util.Scanner;

public class TestBMI {

    public static String classifyBMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        else if (bmi < 25) {
            return "Normal Weight";
        }
        else if (bmi < 30) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PersonInfo person1 = new PersonInfo();

        System.out.printf("\nFirst Instance Prompts\n");
        System.out.printf("Enter person's name: ");
        String name1 = scanner.nextLine();
        System.out.printf("Enter person's year of birth: ");
        int yearOfBirth1 = scanner.nextInt();
        System.out.printf("Enter person's height in meters: ");
        double height1 = scanner.nextDouble();
        System.out.printf("Enter person's weight in kilograms: ");
        double weight1 = scanner.nextDouble();

        person1.setName(name1);
        person1.setYearOfBirth(yearOfBirth1);
        person1.setHeight(height1);
        person1.setWeight(weight1);

        System.out.printf("\nSecond Instance Prompts\n");
        System.out.printf("Enter person's name: ");
        scanner.nextLine(); // Gets rid of the new line input left by scanner.nextDouble()
        String name2 = scanner.nextLine();
        System.out.printf("Enter person's year of birth: ");
        int yearOfBirth2 = scanner.nextInt();
        System.out.printf("Enter person's height in meters: ");
        double height2 = scanner.nextDouble();
        System.out.printf("Enter person's weight in kilograms: ");
        double weight2 = scanner.nextDouble();

        PersonInfo person2 = new PersonInfo(name2, yearOfBirth2, height2, weight2);

        System.out.printf("\n1st instance Output\n");
        System.out.printf("%16s%s%n", "Full Name: ", person1.getName());
        System.out.printf("%16s%d%n", "Age: ", person1.calculateAge());
        System.out.printf("%16s%.2f%n", "Height: ", person1.getHeight());
        System.out.printf("%16s%.2f%n", "Weight: ", person1.getWeight());
        System.out.printf("%16s%s%n", "Classification: ", classifyBMI(person1.calculateBMI()));

        System.out.printf("\n2nd instance Output\n");
        System.out.printf("%16s%s%n", "Full Name: ", person2.getName());
        System.out.printf("%16s%d%n", "Age: ", person2.calculateAge());
        System.out.printf("%16s%.2f%n", "Height: ", person2.getHeight());
        System.out.printf("%16s%.2f%n", "Weight: ", person2.getWeight());
        System.out.printf("%16s%s%n%n", "Classification: ", classifyBMI(person2.calculateBMI()));

        scanner.close();
    }
}