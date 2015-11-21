import java.util.Scanner;

public class CountLettersMain {

	// Nick Porter
	private static int[] alphabetArray = new int [26];

	private static char[] alphabetChar = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static void main(String[] args) {
		findIndex(takeInput());
	}
	

	// Takes the users string(s) will take strings until the user enters a blank line.
	private static String takeInput() {
		Scanner userInput = new Scanner(System.in);

		System.out.println("Enter some text. Enter a blank line to quit.");
		boolean quit = true;
		String userString = "";

		// Loop runs until the user enters a blank line.
		while (quit) {

			String newString = userInput.nextLine();

			// Adds all the users strings into one string for easy handling.
			userString += newString;

			// Checks for a blank line, meaning the user wants to quit.
			if (newString.length() == 0) {
				quit = false;
			}
		}
		userString = userString.toUpperCase();
		
		// Takes out all the whitespace so we can get proper numbers when doing (parsedString[i] - 'A').
		String strippedInput = userString.replaceAll("\\W", "");
		userInput.close();
		return strippedInput;
	}

	/*
	 * Every time a letter is used the corresponding index in alphabetArray will
	 * be incremented once. The second loop runs through alphabetArray to find
	 * all the elements that have been incremented. All the elements that have
	 * been incremented will be put into the alphabetChar[] to find out what
	 * letter their index matches up with. To find out how many times a letter
	 * has been used we go to the corresponding element that was incremented in the first loop.
	 */
	private static void findIndex(String strippedInput) {

		char parsedString[] = new char[strippedInput.length()];
		String errorMessage = "You have entered non alphabetical values, all non-alphabetical " +
				"values have been ignored.";

		// This loop increments each time a letter is used.
		for (int i = 0; i < parsedString.length; i++) {
			parsedString[i] = strippedInput.charAt(i);
			int indexAdder = (parsedString[i] - 'A');
			try {
				alphabetArray[indexAdder]++;
			} catch (Exception e) {
				System.out.println(errorMessage);
				break;
			}
		}
		
		for (int i = 0; i < alphabetArray.length; i++) {

			// This ensures that only elements that have been incremented will be used.
			if (alphabetArray[i] > 0) {
				
					System.out.println(alphabetChar[i] + "		"
							+ alphabetArray[i]);
			}
		}
	}

}

/*
Enter some text. Enter a blank line to quit.
Go Timberwolves!
Go Golden Tigers!

B		1
D		1
E		4
G		4
I		2
L		2
M		1
N		1
O		4
R		2
S		2
T		2
V		1
W		1

------------------------------------------------ NEW RUN

Enter some text. Enter a blank line to quit.
I am going to break you!!!!!! %^ 54

You have entered a non alphabetical value, all non-alphabetical values have been ignored.
A		2
B		1
E		1
G		2
I		2
K		1
M		1
N		1
O		3
R		1
T		1
U		1
Y		1

*/

