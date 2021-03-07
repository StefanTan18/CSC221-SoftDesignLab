import java.security.SecureRandom;  // used to generate random integers
import java.util.Scanner;   // used to read user's inputs

/**
 * The SkeeBall class simulates the popular arcade game of SkeeBall. Users are
 * allowed enter the number of plays within a given range and based on the random
 * number generated, the scores of each play will be determined with smaller chances
 * of getting a high score and higher chances of getting a low score. The score of each
 * roll will be outputted along with the total score.
 * 
 * @author Stefan Tan
 */
public class SkeeBall {

    private static final int MAX_PLAYS = 8; // static and final member that holds the max number of plays
    private int[] scores;   // private member array that holds the the scores for each roll

    /**
     * This is the non-static method that generates a random number to simulate the throw of the
     * ball. A hall value is assigned to it and that along with the current ball number is 
     * printed out.
     * @param playNum This is an int value used to determine the current ball number that the program is on.
     */
    public void simulatePlay(int playNum) {
        SecureRandom sRand = new SecureRandom();
        int rand = sRand.nextInt(100) + 1;  // a random number from 1-100 is generated
        int points = assignHallValue(rand); // a hall value is assigned
        scores[playNum - 1] = points;   // the hall value is stored in an array
        // the ball number along with the points are printed out 
        System.out.printf("Rolling ball #%d. Landed in %d%n", playNum, points);
    }

    /**
     * This is a non-static method that assigns the hall value based on the randNum that is
     * generated. If the number is between 1 and 5 then it is assigned 80 points, if the number
     * is between 6 and 15, then it is assigned 60 points, if the number is between 16 and 30, then
     * it is assigned 40 points, if the number is between 31 and 45, the 20 points is assigned, if
     * the number is between 46 and 65, then 10 points is assigned, and if the number is between 66 and
     * 100, then 0 points is assigned.
     * @param randNum This int value is used to determine what points is assigned to it.
     * @return int This is the points assigned to the number that was given.
     */
    public int assignHallValue(int randNum) {
        int n;
        if (randNum <= 5) { // randNum is between 1 and 5 inclusive
            n = 0;
        }
        else if (randNum <= 15) {   // randNum is between 6 and 15 inclusive
            n = 1;
        }
        else if (randNum <= 30) {   // randNum is between 16 and 30 inclusive
            n = 2;
        }
        else if (randNum <= 45) {   // randNum is between 31 and 45 inclusive
            n = 3;
        }
        else if (randNum <= 65) {   // randNum is between 46 and 65 inclusive
            n = 4;
        }
        else {  // randNum is between 66 and 100 inclusive
            n = 5;
        }

        int result = 0;
        // Assigns Hall value based on which range does randNum lie in
        switch (n) {
            // 80 points is assigned for randNum of 1-5
            case 0:
                result = 80;
                break;
            // 60 points is assigned for randNum of 6-15
            case 1:
                result = 60;
                break;
            // 40 points is assigned for randNum of 16-30
            case 2:
                result = 40;
                break;
            // 20 points is assigned for randNum of 31-45
            case 3:
                result = 20;
                break;
            // 10 points is assigned for randNum of 46-65
            case 4:
                result = 10;
                break;
            // 0 points is assigned for randNum of 66-100
            case 5:
                break;
        }
        return result;
    }

    /**
     * This is a non-static method prints the results of the simulated plays along with the 
     * total points.
     * @param playNum This is an int value used to represent the ball number and to retrieve the
     * corresponding points associated with the ball number.
     */
    public void displayStats(int playNum) {
        System.out.printf("+-------+-------+%n");
        System.out.printf("%8s %8s%n", "Play #", "Score");
        System.out.printf("+-------+-------+%n");
        for (int play = 1; play <= playNum; play++) {
            System.out.printf("%6d %6d%n", play, scores[play - 1]);
        }

        int total = 0;

        // Total score is determined using the private member array
        for (int s : scores) {
            total += s;
        }

        System.out.printf("%nTotal: %d%n", total);
    }
    
    /**
     * This the main method that contains the flow of the game. An instance of SkeeBall
     * is created and user is prompted to enter the number of plays. Based on the input, 
     * the scores for each ball is printed along with the total score.
     * @param args This is an array holding the command line arguments. It is not used in this case.
     */
    public static void main(String[] args) {

        // Instantiating scanner so that it readsd the user's inputs
        Scanner scanner = new Scanner(System.in);

        // Creating an instance of SkeeBall
        SkeeBall game = new SkeeBall();

        // Prompts the user to enter the number of plays
        System.out.printf("Enter the number of plays (1-8)? ");
        int numOfPlays = scanner.nextInt();

        // Loop prompts the user again if the number entered is not between 1 and MAX_PLAYS
        while (numOfPlays < 1 || numOfPlays > MAX_PLAYS) {
            System.err.println("Invalid input. Please enter a number between 1 and 8.");
            System.out.printf("Enter the number of plays (1-8)? ");
            numOfPlays = scanner.nextInt();
        }

        System.out.printf("%n");    // Printing a new line for clarity

        // Dynamically allocated array to store the scores
        game.scores = new int[numOfPlays];

        // simulatePlay() is invoked based on the valid input
        for (int i = 1; i <= numOfPlays; i++) {
            game.simulatePlay(i);
        }

        System.out.printf("%n");    // Printing a new line for clarity

        // Summary of results is printed
        game.displayStats(numOfPlays);

        scanner.close();    // Closes scanner
    }
}