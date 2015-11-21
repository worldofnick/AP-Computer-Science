import java.util.Scanner;


public class NewBigAdder {

	public static void main(String[] args) {
		takeUserInput();
	}
	
	private static void takeUserInput() {
		Scanner userInput = new Scanner(System.in);
		String firstNumber;
		String secondNumber;
		
		System.out.print("Enter the first big number:  ");
		firstNumber = userInput.nextLine();
		int number1Length = firstNumber.length();
		
		if (firstNumber.equalsIgnoreCase("quit")) {
			System.out.println("goodbye");
			//break;
		}
		
		System.out.print("Enter the second number:   ");
		secondNumber = userInput.nextLine();
		int number2Length = firstNumber.length();
		
		int maxLength = Math.max(number1Length, number2Length);
		
		int number1[] = new int[maxLength];
		int number2[] = new int[maxLength];
		
	}
	
	private static int[] fillArray(String bigNumber, int length, int maxLength, int[] array) {
		
		if (maxLength > length) {
			int howManyZeros = maxLength - length;
			
			for (int i = 0; i < howManyZeros; i++) {
				bigNumber = "0" + bigNumber;
			}
			
		for (int i = 0; i < array.length; i++) {
			
		}
			
		}
		
		
		
		
		return null;
	}

}
