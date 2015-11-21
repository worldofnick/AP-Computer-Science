import java.util.Scanner;

public class FractionLoopMain {
	// Nick Porter
	public static void main(String[] args) {
		fractionCalc();
	}
	
	private static void fractionCalc(){
		Scanner userInput = new Scanner(System.in);
		boolean allDone = false;
		String errorMessage = "Error. Please enter a fraction expression, such as '2_3/4 + 7/8";
		System.out.println("Welcome to the Fraction Calculator!");
		System.out.println("Please enter a fraction expression, such as '2_3/4 + 7/8'");
		
		while (allDone == false) {
			System.out.print("> ");
			String firstFrac = userInput.next();              // reads the first fraction
			
			if (firstFrac.equalsIgnoreCase("quit")) {        // checks if the user wants to quit
				break;
			} else {
				String operator = userInput.next();		     // reads the operator
				String secondFrac = userInput.next();        // reads the second fraction
				String extra = userInput.nextLine();         // checks for too much input
				
				if (extra.length() > 0) {
					System.out.println(errorMessage);
				} else
					parseNumber(firstFrac, secondFrac);
					
				switch (operator) {                 // checks which operation the user uses
	            case "/": operator = "Divison";  
                break;
	            case "*": operator = "Multiply"; 
                break;
	            case "+": operator = "Additon";
	            break;
	            case "-": operator = "Subtraction"; 
				break;
	            default:	System.out.println(errorMessage); 
				}
				System.out.printf("Faction 1: %s Operation: %s Fraction 2: %s\n", firstFrac, operator, secondFrac);
			}
		}
		System.out.println("Goodbye");
		userInput.close();
	}
	
	private static void parseNumber(String firstFrac, String secondFrac){
		String wholeNumber1;
		String denomanator1;
		String numerator1;
		String s1 = firstFrac;
		String wholeNumber2;
		String denomanator2;
		String numerator2;
		String s2 = secondFrac;
		
		if (firstFrac.indexOf("_") == 1) {
			wholeNumber1 = firstFrac.substring(0);
			numerator1 = firstFrac.substring(2);
			denomanator1 = firstFrac.substring(4);
			System.out.printf("\tFraction 1 whole number: %s, numerator: %s, denominator: %s, string: %s\n", wholeNumber1, numerator1, denomanator1, s1);
			
		} else{
			wholeNumber1 = "0";
			numerator1 = firstFrac.substring(0);
			denomanator1 = firstFrac.substring(2);
			System.out.printf("\tFraction 1 whole number: %s, numerator: %s, denominator: %s, string: %s\n", wholeNumber1, numerator1, denomanator1, s1);
		}
		if (firstFrac.substring(1).equals("_") ) {
			wholeNumber2 = firstFrac.substring(0);
			numerator2 = firstFrac.substring(2);
			denomanator2 = firstFrac.substring(4);
			System.out.printf("\tFraction 2 whole number: %s, numerator: %s, denominator: %s, string: %s\n", wholeNumber2, numerator2, denomanator2, s2);
			
		} else{
			wholeNumber2 = "0";
			numerator2 = firstFrac.substring(0);
			denomanator2 = firstFrac.substring(2);
			System.out.printf("\tFraction 2 whole number: %s, numerator: %s, denominator: %s, string: %s\n", wholeNumber2, numerator2, denomanator2, s2);
		}
	}
}


 

