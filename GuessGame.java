import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    Random random = new Random();                                   // Generate Random Number.
    Scanner input = new Scanner(System.in);                         // Create Scanner object to take user input.
    int user_guess;                                                 // Variable declared to accept user input.

    int number = random.nextInt(100) + 1;                     // Store generated value in number variable.
    final int GUESS_LIMIT = 5;                                      // Guess limits while playing the game.
    int count = 0;                                                  // No of tries required to guess correct number.

    public void guessNumber() {
        System.out.println("Number: " + number);
        while (count < GUESS_LIMIT) {                               //This loop will run until the count is not equal to set limit.
            System.out.print("Enter number from 1 to 100: ");
            user_guess = input.nextInt();

            if (user_guess == number) {                             //If user guess is correct.
                count++;
                System.out.println("Congratulations! You guessed the correct number in " + count + " guesses.");
                break;
            } else if (user_guess > number) {                       //If user guess is higher than generated number.
                count++;
                System.out.println("Guess a lower number.");
            } else {                                                //If user guess is lower than generated number.
                count++;
                System.out.println("Guess a higher number.");
            }

            if (count == GUESS_LIMIT) {
                System.out.println("Sorry! you've reached maximum number of attempts." + "\nThe Correct Number was: " + number);
                System.out.println("--------------------------------");
            }
        }
        playAgain();
    }

    private void playAgain(){
        System.out.print("Would you like to play again (Y/N)?: ");
        String choice = input.next();
        if (choice.equals("y")) {
            resetGame();
            guessNumber();
        }
        else{
            System.out.println("Thank you for playing the game.!");
        }
    }

    private void resetGame(){
        number = random.nextInt(100) + 1;
        count = 0;
        System.out.println("New number generated: "+number);
    }  
}
