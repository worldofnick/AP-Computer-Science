import java.util.Scanner;


public class HangmanMain {

	public static void main(String[] args) {
		wordToGuess();
	}
	
	private static char[] wordToGuess() {
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Enter a word for your friend to guess! ");
		String userWord = userInput.nextLine();
		char userString [];
		String underScores[] = null;
			
		userString = new char [userWord.length()];
		
		for (int i = 0; i < userString.length; i++) {
			userString[i] = userWord.charAt(i);
			underScores[i] = "_";
		}
		
		for (int i = 0; i < userString.length; i++) {
			System.out.print(underScores[i]);
		}
		
		userInput.close();
		return userString;
	}
	
	private void guessLoop() {
		boolean allDone = true;
		
		while (allDone) {
			System.out.print("Enter a letter to guess");
		}

	}

}
