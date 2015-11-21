import java.util.Scanner;


public class AddBigNumbersMain {

	public static void main(String[] args) {
		takeUserInput();
	}

	private static void takeUserInput() {
		Scanner userInput = new Scanner(System.in);

		System.out.print("Enter the first big number: ");
		int firstBigNumber = userInput.nextInt();

		// Converts to string to get length.
		String parseBigNumber1 = Integer.toString(firstBigNumber);
		int firstNumberLength = parseBigNumber1.length();

		System.out.print("Enter the second big number: ");
		int secondBigNumber = userInput.nextInt();

		String parseBigNumber2 = Integer.toString(secondBigNumber);
		int secondNumberLength = parseBigNumber2.length();

		/*
		 * I do this so I can add the appropriate amount of 0's at the beginning
		 * of either number, making it easy to line up the corresponding number
		 * place. Ex: 1's, 10's, 100's
		 */
		int howMuchBigger;

		/*
		 * These if statements check for the larger number, which ever is
		 * smaller gets howMuchBigger 0's added to it. If howMuchBigger is = to
		 * 4 then four zeros will be added to the beginning of the shorter
		 * number. The loops are what add the correct amount of 0's
		 */
		if (firstNumberLength > secondNumberLength) {
			howMuchBigger = firstNumberLength - secondNumberLength;

			for (int i = 0; i < howMuchBigger; i++) {
				parseBigNumber2 = "0" + parseBigNumber2;
			}

			// Since 0's are being added to the number the length needs to be
			// updated, so the array is created with the right amount of
			// elements.
			secondNumberLength = parseBigNumber2.length();

		} else if (firstNumberLength < secondNumberLength) {
			howMuchBigger = firstNumberLength - secondNumberLength;

			for (int i = 0; i < howMuchBigger; i++) {
				parseBigNumber1 = "0" + parseBigNumber1;
			}

			// Since 0's are being added to the number the length needs to be
			// updated, so the array is created with the right amount of
			// elements.
			firstNumberLength = parseBigNumber1.length();
		}

		// If all goes well the Arrays should have an equal length.
		int[] firstNumber = new int[firstNumberLength];
		int[] secondNumber = new int[secondNumberLength];

		fillArray(parseBigNumber1, firstNumber);
		fillArray(parseBigNumber2, secondNumber);

		printSum(doMath(firstNumber, secondNumber));

		userInput.close();

	}

	private static void fillArray(String BigNumber, int[] array) {

		for (int i = 0; i < BigNumber.length(); i++) {
			char number = BigNumber.charAt(i);
			array[i] = (int) number;
		}

	}

	private static int[] doMath(int[] firstNumber, int[] secondNumber) {

		int[] sum = new int[firstNumber.length + 1];
		int sumHolder;
		boolean carry = false;
		String carryHolder = null;

		System.out.println(firstNumber.length);
		System.out.println(secondNumber.length);

		for (int i = sum.length - 1; i >= 1; i--) {

			if (carry) {
				sum[i] = sum[i] + 1;
			}

			if (firstNumber[i - 1] + secondNumber[i - 1] > 9) {
				sumHolder = firstNumber[i - 1] + secondNumber[i - 1];
				carryHolder = Integer.toString(sumHolder);
				sum[i] = carryHolder.charAt(1);
				carry = true;

			} else {
				sum[i] = firstNumber[i - 1] + secondNumber[i - 1];
				carry = false;
			}

		}

		return sum;
	}

	private static void printSum(int[] sum) {
		for (int i = 0; i < sum.length; i++) {

			System.out.print(sum[i]);

		}
	}
	
}
