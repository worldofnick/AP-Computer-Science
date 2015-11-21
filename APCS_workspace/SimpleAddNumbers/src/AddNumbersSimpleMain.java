import java.util.Scanner;


public class AddNumbersSimpleMain {

	public static void main(String[] args) {
		takeInput();
	}
	
	private static void takeInput() {
		boolean keepGoing = true;
		while (keepGoing) {
			Scanner console = new Scanner(System.in);
			String stringNumber1 = null;
			String stringNumber2 = null;
			System.out.print("Enter the first big number: ");
			stringNumber1 = console.nextLine();
			
			if (stringNumber1.equalsIgnoreCase("quit")) {
				System.out.println("Goodbye");
				break;
			}
			
			System.out.print("Enter the second big number: ");
			stringNumber2 = console.nextLine();
			
			if (!stringNumber1.matches("\\d+")
					|| !stringNumber2.matches("\\d+")) {
				System.out.println("You have entered an invalid input type.");
				continue;
			} else 
			
			console.close();
			int arrayLength = Math.max(stringNumber1.length(),
					stringNumber2.length());
			
			int[] firstNumber = new int[arrayLength];
			int[] secondNumber = new int[arrayLength];
			
			fillArray(stringNumber1, firstNumber);
			fillArray(stringNumber2, secondNumber);
			printArray(doMath(firstNumber, secondNumber));
		}
	}
	
	private static void fillArray(String number, int[] array) {
		int indexOf = 0;
		for (int i = array.length - number.length(); i < array.length; i++) {
			int numberAt = number.charAt(indexOf) - '0';
			indexOf++;
			array[i] = numberAt;
		}
	}
	
	private static int[] doMath(int[] firstNumber, int[] secondNumber) {
		int[] sumArray = new int[firstNumber.length + 1];
		int carryAdder = 0;
		
		for (int i = sumArray.length - 2; i >= 0; i--) {
			int sum = firstNumber[i] + secondNumber[i] + carryAdder;
			
			if (sum / 10 > 0) {
				sumArray[i + 1] = sum % 10;
				carryAdder = sum / 10;
			} else {
				sumArray[i + 1] = sum;
				carryAdder = 0;
			}
			
		}
		
		return sumArray;
	}
	
	private static void printArray(int[] sum) {
		System.out.print("Sum: ");
		if (sum[0] == 0) {
			for (int i = 1; i < sum.length; i++) {
				System.out.print(sum[i]);
			}
		} else {
			for (int i = 0; i < sum.length; i++) {
				System.out.print(sum[i]);
			}
		}
	}

}
