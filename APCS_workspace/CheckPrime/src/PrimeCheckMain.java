import java.util.Scanner;

public class PrimeCheckMain {
	Scanner userInput = new Scanner( System.in );
	
	public static void main(String[] args) {
		checkPrime();

	}

	static void checkPrime(){
		
		Scanner userInput = new Scanner( System.in );
		
		String userNumber;
		System.out.print("Enter a number to check whether it is prime or not!: ");  // Asks for input from user
		userNumber = userInput.next();
		
		int test = Integer.parseInt(userNumber) % 2;  // runs the calculation
		
		if (test == 1){
			System.out.println( userNumber + " is a prime number!");
		}else {
			System.out.println(userNumber + " is not a prime number.");
		}
		
		userInput.close();
		
		// if user input % is 1 it is a prime number 
	}
}
