import java.util.*;

public class RandomMain {
// Nick Porter

	public static void main(String[] args) {
		randomGuess();
	}

	private static void randomGuess() {
		final int MAX = 100;            
		int numOfGuesses = 0;           
		Random random = new Random();   
		int randomInt = random.nextInt(MAX) + 1; 
		 Scanner userInput = new Scanner(System.in); 
		 
		 System.out.println("I'm thinking of a number between 1 and 100.");
		 System.out.print("Guess a number:");
		 int userGuess = userInput.nextInt();
		 
		while (userGuess != randomInt) {
			numOfGuesses++;
			if (userGuess > randomInt) {
				System.out.println("Too High.");
			}
			if (userGuess < randomInt) {
				System.out.println("Too Low.");
			}
			 System.out.print("Guess another number:");
			userGuess = userInput.nextInt();
		}
		 System.out.printf("That's right! It took you %d guesses.", numOfGuesses);	
		 userInput.close();
	}
	
}
/*
 I'm thinking of a number between 1 and 100.
Guess a number:67
Too High.
Guess another number:44
Too High.
Guess another number:22
Too High.
Guess another number:11
That's right! It took you 3 guesses.
 */
