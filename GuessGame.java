import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    Random random = new Random();                                   // Generate Random Number.
    Scanner input = new Scanner(System.in);                         // Create Scanner object to take user input.
    int user_guess;                                                 // Variable declared to accept user input.
    int number;                                                     // Variable to store generated number.
    int guessLimit;                                                 // Variable for guess limits.
    int count = 0;                                                  // No of tries required to guess the correct number.
    int score = 0;                                                  // Player's score.

    public void chooseDifficulty() {
        System.out.println("Choose Difficulty Level:");
        System.out.println("1. Easy (1-50, 10 guesses)");
        System.out.println("2. Medium (1-100, 7 guesses)");
        System.out.println("3. Hard (1-200, 5 guesses)");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                number = random.nextInt(50) + 1;
                guessLimit = 10;
                break;
            case 2:
                number = random.nextInt(100) + 1;
                guessLimit = 7;
                break;
            case 3:
                number = random.nextInt(200) + 1;
                guessLimit = 5;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Medium.");
                number = random.nextInt(100) + 1;
                guessLimit = 7;
                break;
        }
        guessNumber();
    }

    public void guessNumber() {
        System.out.println("I have chosen a number. Try to guess it!");
        while (count < guessLimit) {
            System.out.print("Enter your guess: ");
            user_guess = input.nextInt();
            count++;

            if (user_guess == number) {
                score += 10;  // Add points for correct guess
                System.out.println("Congratulations! You guessed the correct number in " + count + " guesses.");
                System.out.println("Your score is: " + score);
                break;
            } else if (user_guess > number) {
                System.out.println("Guess a lower number.");
            } else {
                System.out.println("Guess a higher number.");
            }

            // Provide a hint after 3 incorrect guesses
            if (count == 3) {
                if (number % 2 == 0) {
                    System.out.println("Hint: The number is even.");
                } else {
                    System.out.println("Hint: The number is odd.");
                }
            }

            if (count == guessLimit) {
                System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was: " + number);
                System.out.println("Your score is: " + score);
            }
        }
        playAgain();
    }

    private void playAgain() {
        System.out.print("Would you like to play again (Y/N)?: ");
        String choice = input.next();
        if (choice.equalsIgnoreCase("y")) {
            resetGame();
            chooseDifficulty();
        } else {
            System.out.println("Thank you for playing! Your final score is: " + score);
        }
    }

    private void resetGame() {
        count = 0;
    }
}
