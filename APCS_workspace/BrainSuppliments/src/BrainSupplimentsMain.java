import java.util.Scanner;

public class BrainSupplimentsMain {

	// Nick Porter
	public static void main(String[] args) {
		returnResults(enterScores());

	}

	private static double[] enterScores() {  // Returns a double type array.
		Scanner userInput = new Scanner(System.in);

		System.out.print("How many mice were tested? ");
		int numOfMice = userInput.nextInt();

		// Creates an Array with numOfMice spaces
		double[] scoreHolder = new double[numOfMice];

		System.out.println("Enter Scores:");

		// Asks for each score, then puts it in the array.
		for (int i = 0; i < scoreHolder.length; i++) {
			System.out.printf("\tMouse #%d ", i + 1);
			double mouseTime = userInput.nextDouble();
			scoreHolder[i] = mouseTime;
		}
		System.out.println();
		userInput.close();
		return scoreHolder;
	}

	private static void returnResults(double[] scoreHolder) {
		double calcAverage = 0.0;

		// Adds all the numbers in the array up and then calculates the average.
		for (int i = 0; i < scoreHolder.length; i++) {
			calcAverage += scoreHolder[i];
		}
		calcAverage /= scoreHolder.length;

		System.out.printf("Results:    Average time: %.2f\n", calcAverage);
		System.out.println("	Mouse  Time  Diff.");
		System.out.println("	-----  -----  -----");

		// Prints the results
		for (int i = 0; i < scoreHolder.length; i++) {
			System.out.printf("\t%4d  %4.2f  %4.2f\n", i + 1, scoreHolder[i],
					scoreHolder[i] - calcAverage);
		}
	}

}

/*
How many mice were tested? 3
Enter Scores:
	Mouse #1 5
	Mouse #2 7
	Mouse #3 9

Results:    Average time: 7.00
	Mouse  Time  Diff.
	-----  -----  -----
	   1  5.00  -2.00
	   2  7.00  0.00
	   3  9.00  2.00
*/

