import java.util.GregorianCalendar;

public class PersonInfo {

    private String name;
    private int yearOfBirth;
    private double height;
    private double weight;

    public PersonInfo() {
        this("", 0, 0, 0);
    }

    public PersonInfo(String name, int yearOfBirth, double height, double weight) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int calculateAge() {
        int currentYear = new GregorianCalendar().get(GregorianCalendar.YEAR);
        int age = currentYear - yearOfBirth;
        return age;
    }

    public double calculateBMI() {
        double bmi = weight / (height * height);
        return bmi;
    }
}