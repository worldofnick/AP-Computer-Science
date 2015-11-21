import java.util.*;

// Nick Porter

public class ReverseMain {
	
	public static void main(String[] args) {
		takeUserInput();
	}

	private static void takeUserInput() {
		Scanner myScanner = new Scanner(System.in);
		System.out.print("Enter some text, and I'll reverse it: ");
		String userInput = myScanner.nextLine();
		System.out.println("Reversed: " + reverseString(userInput));
		myScanner.close();
	}
	
	private static String reverseString(String userInput){
	   	String reversedInput = "";
		for( int backwards = userInput.length() - 1; backwards >= 0; backwards--){
			reversedInput = reversedInput + userInput.charAt(backwards);
		
		}
				return reversedInput;
	}

}

/*
Enter some text, and I'll reverse it: Hello Tyler
Reversed: relyT olleH
 */
