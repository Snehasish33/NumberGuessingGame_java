import java.util.Random;
import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound);
            System.out.println("You have " + maxAttempts + " attempts.");

            for (int attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please enter a number within the specified range.");
                    continue;
                }

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += (maxAttempts - attempts + 1);
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Try a higher number. Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Try a lower number. Attempts left: " + (maxAttempts - attempts));
                }

                if (attempts == maxAttempts) {
                    System.out.println("Out of attempts. The correct number was: " + numberToGuess);
                }
            }

            System.out.println("Your current score: " + score);
            System.out.print("Play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thank you for playing! Your final score: " + score);
                break;
            }

            numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        }

        scanner.close();
    }
}
