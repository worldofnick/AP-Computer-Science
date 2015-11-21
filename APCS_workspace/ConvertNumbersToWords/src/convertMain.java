import java.util.Scanner;

public class convertMain {

	static String errorMessage = "Please check your input, it has caused an error";
	
	public static void main(String[] args) {
		toWords(takeUserNumber());
	}
	
	private static double takeUserNumber(){
		boolean done = false;
		double userNumber = 0;
		while (done == false) {
			
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Type 1 to convert to words.");
		System.out.println("Type 2 to convert to currency.");
		System.out.println("Type 3 to convert to check writing.");
		System.out.print("> ");
		
		String userWordType = userInput.nextLine();
		
		int userValidSelection;
		if (userWordType.equalsIgnoreCase("quit")) {
			System.out.println("goodbye");
			break;
		} else
			userValidSelection = Integer.parseInt(userWordType);
		
			if (userValidSelection > 3 || userValidSelection < 1) {
			System.out.println("Please enter a valid conversion. Please try again");
			System.out.println();
			continue;
		}
			userNumber = userInput.nextDouble();	
	}
		return userNumber;
  }
	
	private static String toWords(double userNumber){
		String userStringNumber = Double.toString(userNumber);
		String convertedNumber = null;
		char firstDigit;
		char secDigit;
		char thirdDigit;
		char fourthDigit;
		char fifthDigit;
		char sixDigit;
		char seventhDigit;
		char eightDigit;
		char nineDigit;
		
		if (userStringNumber.indexOf(".") == -1) {
			// there are no decimal places in the number
			if (userStringNumber.length() == 9) {
				// for numbers over 99,999,999 :/
				firstDigit = userStringNumber.charAt(0);
				secDigit = userStringNumber.charAt(1);
				thirdDigit = userStringNumber.charAt(2);
				fourthDigit = userStringNumber.charAt(3);
				fifthDigit = userStringNumber.charAt(4);
				sixDigit = userStringNumber.charAt(5);
				seventhDigit = userStringNumber.charAt(6);
				eightDigit = userStringNumber.charAt(7);
				nineDigit = userStringNumber.charAt(8);
				
				switch (firstDigit) {                 
	            case 1: convertedNumber = "one hundred";
                break;
                
	            case 2: convertedNumber = "two hundred";
                break;
                
	            case 3: convertedNumber = "three hundred";
	            break;
	            
	            case 4: convertedNumber = "four hundred";
				break;
				
	            case 5: convertedNumber = "five hundred";
	            break;
	            
	            case 6: convertedNumber = "six hundred";
				break;
				
	            case 7: convertedNumber = "seven hundred";
	            break;
	            
	            case 8: convertedNumber = "eight hundred";
				break;
				
	            case 9: convertedNumber = "three hundred";
	            break;
	            
	            default:	System.out.println(errorMessage); 
				} 
				
				if (secDigit == 1 && thirdDigit == 1) {
					convertedNumber = convertedNumber + " eleven,";
				} else if (secDigit == 1 && thirdDigit == 2) {
					convertedNumber = convertedNumber + " twelve,";
				} else if (secDigit == 1 && thirdDigit == 3) {
					convertedNumber = convertedNumber + " thirteen,";
				} else if (secDigit == 1 && thirdDigit == 4) {
					convertedNumber = convertedNumber + " fourteen,";
				} else if (secDigit == 1 && thirdDigit == 5) {
					convertedNumber = convertedNumber + " fifteen,";
				} else if (secDigit == 1 && thirdDigit == 6) {
					convertedNumber = convertedNumber + " sixteen,";
				} else if (secDigit == 1 && thirdDigit == 7) {
					convertedNumber = convertedNumber + " seventeen,";
				} else if (secDigit == 1 && thirdDigit == 8) {
					convertedNumber = convertedNumber + " eighteen,";
				} else if (secDigit == 1 && thirdDigit == 9) {
					convertedNumber = convertedNumber + " nineteen,";
				} else {
					
					switch (secDigit) {
					case 0: convertedNumber= convertedNumber;
					break;
					
					case 1: convertedNumber = convertedNumber + " ten-,";
	                break;
	                
		            case 2: convertedNumber = convertedNumber + " twenty-,";;
	                
		            case 3: convertedNumber = convertedNumber + " thirty-,";
		            break;
		            
		            case 4: convertedNumber = convertedNumber + " fourty-,";
					break;
					
		            case 5: convertedNumber = convertedNumber + " fifty-,";
		            break;
		            
		            case 6: convertedNumber = convertedNumber + " sixty-,";
					break;
					
		            case 7: convertedNumber = convertedNumber + " seventy-,";
		            break;
		            
		            case 8: convertedNumber = convertedNumber + " eighty-,";
					break;
					
		            case 9: convertedNumber = convertedNumber + " ninety-,";
		            break;
		            
		            default:	System.out.println(errorMessage); 
					}
				}
				 System.out.println(convertedNumber);
			}
		}
		
		return convertedNumber;
		
	}
	
}
