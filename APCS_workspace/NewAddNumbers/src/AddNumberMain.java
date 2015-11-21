import java.util.Scanner;


public class AddNumberMain {

	public static void main(String[] args) {
		takeUserInput();
	}
	
	private static void takeUserInput() {
		Scanner userInput  = new Scanner(System.in);
		String firstNumber;
		String secondNumber;
		
		System.out.print("Enter the first big number: ");
		firstNumber = userInput.nextLine();
		
		System.out.print("Enter the second big number: ");
		secondNumber = userInput.nextLine();
		
		int howMuchBigger = Math.max(firstNumber.length(), secondNumber.length());
		
		int[] firstNumberArray = new int[howMuchBigger + 1];
		int[] secondNumberArray = new int[howMuchBigger + 1];
		int[] sumArray = new int[howMuchBigger + 1];
		
		fillArray(firstNumberArray, firstNumber);
		fillArray(secondNumberArray, secondNumber);
		
		doMath(firstNumberArray, secondNumberArray, sumArray);
		
		printArray(sumArray);
		
	}
	
	private static void fillArray(int[] array, String number) {
		array[0] = 0;
		
		for(int i = 1; i < array.length; i++) {
			int charAt = number.charAt(i - 1) - '0';
			array[i] = charAt;
		}
		
	}
	
	private static void doMath(int[] firstNumber, int[] secondNumber, int[] sumArray) {
		int carryAdder = 0;
		
		for (int i = sumArray.length - 1; i >= 0; i--) {
			int sum = firstNumber[i] + secondNumber[i] + carryAdder;
			
			if (sum > 9) {
				sumArray[i] = sum % 10;
				carryAdder = sum / 10;
			} else {
				sumArray[i] = sum;
				carryAdder = 0;
			}
		}
		
	}
	
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
	
}
