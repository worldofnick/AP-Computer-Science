import java.math.BigInteger;
import java.util.Scanner;

public class AddNumbersMain {

	// Nick Porter
	public static void main(String[] args) {
		takeUserInput();
		
	}

	private static void takeUserInput() {
		Scanner userInput = new Scanner(System.in);
		boolean allDone = true;

		while (allDone) { // Extra Credit

			System.out.print("Enter the first big number: ");
			String firstNumber = userInput.nextLine();

			if (firstNumber.equalsIgnoreCase("quit")) {
				System.out.println("Goodbye");
				break;
			}
			
			// Checks if the input is only numeric
			if (checkValid(firstNumber)) {
				continue;
			}
			
			// Lets me handle very large numbers.
			BigInteger firstBigNumber = new BigInteger(firstNumber);

			// Converts to string to get length.
			int firstNumberLength = firstNumber.length();

			System.out.print("Enter the second big number: ");
			String secondNumber = userInput.nextLine();

			if (checkValid(secondNumber)) {
				continue;
			}

			BigInteger secondBigNumber = new BigInteger(secondNumber);

			int secondNumberLength = secondNumber.length();
			

			/*
			 * I do this so I can add the appropriate amount of 0's at the
			 * beginning of either number, making it easy to line up the
			 * corresponding number place. Ex: 1's, 10's, 100's
			 */
			int howMuchBigger = Math.abs(firstNumberLength - secondNumberLength);

			/*
			 * These if statements check for the larger number, which ever is
			 * smaller gets howMuchBigger 0's added to it. If howMuchBigger is =
			 * to 4 then four zeros will be added to the beginning of the
			 * shorter number.
			 */

			if (firstNumberLength > secondNumberLength) {

				for (int i = 0; i < howMuchBigger; i++) {
					secondNumber = "0" + secondNumber;
				}

				/*Since 0's are being added to the number the length needs to be updated, 
				 * so the array is created with the right amount of elements.*/	
				secondNumberLength = secondNumber.length();

			} else if (firstNumberLength < secondNumberLength) {

				for (int i = 0; i < howMuchBigger; i++) {
					firstNumber = "0" + firstNumber;
				}

				/* 
				* Since 0's are being added to the number the length needs to
				* be updated, so the array is created with the right amount of elements.
				*/
				
				firstNumberLength = firstNumber.length();
			}

			// If all goes well the Arrays should have an equal length.
			int arrayLength = Math.max(firstNumberLength, secondNumberLength);
			int[] firstNumberArray = new int[arrayLength + 1];
			int[] secondNumberArray = new int[arrayLength + 1];
			
			// .compareTo will return -1, 0 or 1 as this BigInteger is numerically less than, equal to, or greater than.
			
			if (firstBigNumber.compareTo(secondBigNumber) == 1) {

				fillArray(firstNumber, firstNumberArray);
				fillArray(secondNumber, secondNumberArray);
			} else if (firstBigNumber.compareTo(secondBigNumber) == -1) {

				fillArray(secondNumber, secondNumberArray);
				fillArray(firstNumber, firstNumberArray);
			} else {

				fillArray(firstNumber, firstNumberArray);
				fillArray(secondNumber, secondNumberArray);
			}

			printSum(doMath(firstNumberArray, secondNumberArray));

		}

		userInput.close();

	}

	private static void fillArray(String BigNumber, int[] array) {
		/*
		 * Adds a 0 to the beginning of the number/array so that it will be the
		 * same length as array sum in the next method.
		 */
		array[0] = 0;

		// I start at 1 because the first element has already been filled.
		for (int i = 1; i < array.length; i++) {
			char number = BigNumber.charAt(i - 1);
			int integerNumber = number - '0';
			array[i] = integerNumber;
		}

	}

	private static int[] doMath(int[] firstNumber, int[] secondNumber) {
		int[] sum = new int[firstNumber.length];
		int carryAdder = 0;
		
		/*
		 * Adds the elements in the arrays and deals with carrying.
		 * If carry is true then it takes the second char from the sum and puts it in the array.
		 * Then it takes the first and stores it so it can add it up with the next elements.
		 * CarryAdder is reset in each statement, this is key.
		 */
		
		for (int i = sum.length - 1; i >= 0; i--) {
			int newSum = carryAdder + firstNumber[i] + secondNumber[i];

			if (newSum / 10 > 0) {
				sum[i] = newSum % 10;
				carryAdder = newSum / 10;
			} else {
				sum[i] = newSum;
				carryAdder = 0;
			}
		}

		return sum;
	}

	private static void printSum(int[] sum) {

		/*
		 * Extra Credit.
		 * First loop checks for zeros, if there are it removes them then prints the sum.
		 * Second loop runs if there are no zeros at the beginning of the sum.
		 */
		
		if (sum[0] == 0) {
			System.out.print("Sum: ");
			for (int i = 1; i < sum.length; i++) {
				System.out.print(sum[i]);
			}

		} else {
			System.out.print("Sum: ");
			for (int i = 0; i < sum.length; i++) {
				System.out.print(sum[i]);
			}
		}

		System.out.println();

	}

	private static boolean checkValid(String number) {

		if (!number.matches("\\d+")) {
			System.out.println("You have entered a non-numeric value, please try again.");
			System.out.println();
			return true;
		}
		return false;

	}

}

/*
Enter the first big number: 7894561232123654569874525856667622326465465465465465654
Enter the second big number: 6549878977897895613246568975643126465895643489494664
Sum: 7901111111101552465487772425643265452931361108954960318  
// I checked this on WolframAlpha, its right!
Enter the first big number: 9876543210
Enter the second big number: 12345
Sum: 9876555555
Enter the first big number: quit
Goodbye
*/
