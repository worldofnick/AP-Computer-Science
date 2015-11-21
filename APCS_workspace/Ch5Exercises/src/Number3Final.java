import java.util.*;
public class Number3Final {

	public static void main(String[] args) {
		toBinary();

	}
	
	private static void toBinary(){
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter a number to be converted to binary");
		int userNumber = userInput.nextInt();
		String convertedNumber = "";
		String temp;
		StringBuffer sBuf = new StringBuffer();
		
		while (userNumber > 0) {
			temp = Integer.toString(userNumber % 2);
			 convertedNumber += temp;
			 userNumber = userNumber / 2;
		}
		System.out.println(convertedNumber);
		userInput.close();
	}
}
