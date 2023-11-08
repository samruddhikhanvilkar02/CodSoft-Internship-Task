import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int Attempts = 5;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nRound " + (rounds + 1) + ":");
            System.out.println("Guess the number between " + min + " and " + max + ".");

            while (attempts < Attempts) {
                System.out.print("Enter your guess (attempt " + (attempts + 1) + "/" + Attempts + "): ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + "attempts.");
                    score += Attempts - attempts + 1;
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }

            rounds++;
        } while (true);

        System.out.println("Thanks for playing! Your final score: " + score);

    }
}
