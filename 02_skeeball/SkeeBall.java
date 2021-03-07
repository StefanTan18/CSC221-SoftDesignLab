import java.security.SecureRandom;
import java.util.Scanner;

public class SkeeBall {

    private static final int MAX_PLAYS = 8;

    public void simulatePlay(int play) {
        SecureRandom sRand = new SecureRandom();
        int rand = sRand.nextInt(100) + 1;
        System.out.printf("Rolling ball #%d. Landed in %d%n", play, assignHallValue(rand));
    }

    public int assignHallValue(int num) {
        if (num <= 5) {
            return 80;
        }
        else if (num <= 15) {
            return 60;
        }
        else if (num <= 30) {
            return 40;
        }
        else if (num <= 45) {
            return 20;
        }
        else if (num <= 65) {
            return 10;
        }
        else {
            return 0;
        }
    }

    public void displayStats() {
        System.out.printf("+-------+-------+%n");
        System.out.printf("%7s %7s%n", "Play #", "Score");
        System.out.printf("+-------+-------+%n");
        
    }
    
    public static void main(String[] args) {

        SkeeBall game = new SkeeBall();
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter the number of plays (1-8)? ");
        int numOfPlays = scanner.nextInt();

        while (numOfPlays < 1 || numOfPlays > MAX_PLAYS) {
            System.err.println("Invalid input. Please enter a number between 1 and 8.");
            System.out.printf("Enter the number of plays (1-8)? ");
            numOfPlays = scanner.nextInt();
        }

        for (int i = 1; i <= numOfPlays; i++) {
            game.simulatePlay(i);
        }

        scanner.close();    // Closes scanner
    }
}