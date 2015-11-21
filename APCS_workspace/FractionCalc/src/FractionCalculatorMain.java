import java.util.Scanner;

public class FractionCalculatorMain {
	// Nick Porter
		public static void main(String[] args) {
			mainLoop();
		}
		
		private static void mainLoop(){
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
			
					int wholeNumber1 = 0;
					if (extra.length() > 0) {
						System.out.println(errorMessage);
					} else
						// parses the fraction apart
					wholeNumber1 = parseWholeNumber(firstFrac);
					int numerator1 = parseNumerator(firstFrac);
					int denominator1 = parseDenominator(firstFrac);           
					int wholeNumber2 = parseWholeNumber(secondFrac);
					int numerator2 = parseNumerator(secondFrac);
					int denominator2 = parseDenominator(secondFrac);
					
					if (denominator1 == 0 || denominator2 == 0) {
						System.out.println("Cannot divide by 0"); // checks for an invalid fraction
						continue;
					}
					// converts the fractions to improper fractions
					int improperNum1 = wholeNumber1 * denominator1 + numerator1;          
					int improperNum2 = wholeNumber2 * denominator2 + numerator2;
					int LCMDenom = LCM(denominator1, denominator2);
					int factor1 = LCMDenom / denominator1;
					int factor2 = LCMDenom / denominator2;
					improperNum1 = improperNum1 * factor1;
					improperNum2 = improperNum2 * factor2;
					denominator1 = LCM(denominator1, denominator2);
					denominator2 = LCM(denominator1, denominator2);
					
					if (improperNum1 + improperNum2 >= denominator1) { 
						System.out.println((improperNum1 + improperNum2) / denominator1);
						continue;
					}
					int calcNum = 0;
					int calcDenom = 0;
						       
					switch (operator) {                 // checks which operation the user used and does the math
		            case "/": calcNum = improperNum1 * denominator2;
		            		  calcDenom = improperNum2 * denominator1;
	                break;
		            case "*": calcNum = improperNum1 * improperNum2; 
		                      calcDenom = denominator1 * denominator2;
	                break;
		            case "+": calcNum = improperNum1 + improperNum2;
		                      calcDenom = denominator1;
		            break;
		            case "-": calcNum = improperNum1 - improperNum2; 
		                      calcDenom = denominator1;
					break;
		            default:	System.out.println(errorMessage); 
					}
					
					 // reduces both the numerator and the denominator
					 int reducedNum = calcNum / GCD(calcNum, calcDenom); 
					 int reducedDenom = calcDenom / GCD(calcNum, calcDenom); 
					 // finds the whole number
					 int wholeNumber = reducedNum / reducedDenom;
					 // determines the numerator after the wholenumber has been made
					 reducedNum = reducedNum % reducedDenom;
					 
					 if (wholeNumber == 0) {                // checks if the calculated fraction has a wholenumber or not
						System.out.println("   " + reducedNum + "/" + reducedDenom);
					} else {
						System.out.println("   " + wholeNumber + "_" + reducedNum + "/" + reducedDenom);
					} 
				}
			}
			System.out.println("Goodbye");
			userInput.close();
		}
		
		private static int parseDenominator(String fraction){
			String Denominator = fraction.substring(fraction.indexOf("/") + 1);
			int pharsedDenominator = Integer.parseInt(Denominator);
			
			return pharsedDenominator;	
		}
		
		private static int parseWholeNumber(String fraction) {
			String wholeNumber;
			if (fraction.indexOf("_") == -1) {
				wholeNumber = "0";
			} else {
				wholeNumber = fraction.substring(0, fraction.indexOf("_"));
			}
			int pharsedWholeNumber = Integer.parseInt(wholeNumber);
			
			return pharsedWholeNumber;
		}
		
		private static int parseNumerator(String fraction) {
			String numerator;
			if (fraction.indexOf("/") == 3) {
				numerator = fraction.substring(2, fraction.indexOf("/"));
				
			} else {
				numerator = fraction.substring(0, fraction.indexOf("/"));
			}
			int pharsedNumerator = Integer.parseInt(numerator);
			
			return pharsedNumerator;
		}
	
		@SuppressWarnings("unused")
		private static String parseTogether(int whole, int num, int denom){
			String parsedString = null;
			if (whole > 0) {
				parsedString = Integer.toString(whole) + "_" + Integer.toString(num) + "/" + Integer.toString(denom);
			} else {
				parsedString = Integer.toString(num) + "/" + Integer.toString(denom);
			}
			return parsedString;
			
		}
		
		private static int GCD(int a, int b){
			a = Math.abs(a);
			b = Math.abs(b);
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			while (a > 0) {
				int x = b % a;
				b = a;
				a = x;
			}
			return b;
		}
		private static int LCM(int a, int b){
			int LCM = Math.abs(a * b) / GCD(a, b);
			return LCM;	
		}
}

/*Welcome to the Fraction Calculator!
Please enter a fraction expression, such as '2_3/4 + 7/8'
> 2_1/4 + 1_1/2
   3_3/4
> 2_3/4 - 1_1/4
   1_1/2
> 3/4 * 1/2
   3/8
> 3/4 / 1/2
   1_1/2
> 1/4 - 1/2
   -1/4
> 1/4 + 3/4
1
> 3_4/0 + 1/6
Cannot divide by 0
> quit
Goodbye*/

