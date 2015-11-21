import java.util.Scanner;


public class Number3 {

	public static void main(String[] args) {
		toBinary();

	}

	private static void toBinary() {
		Scanner myScanner = new Scanner(System.in);
		System.out.print("Enter a number to be converted to binary:");
		int userNumber = myScanner.nextInt();
		String convertedNumber = "";
		String temp;
		while (userNumber != 0) {
			if (userNumber % 2 == 1) {
				temp = "1";
				convertedNumber += temp;
				userNumber = userNumber / 2;
			} else if (userNumber % 2 == 0){
				temp = "0";
				convertedNumber += temp;
				userNumber = userNumber / 2;
			}
		}
		System.out.println(convertedNumber);
		myScanner.close();
	}
}
