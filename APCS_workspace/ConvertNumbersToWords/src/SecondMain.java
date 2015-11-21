import java.util.Scanner;


public class SecondMain {
	
	private static final String[] lowNames = {
		   "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
		   "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

		private static final String[] tensNames = {
		   "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

		private static final String[] bigNames = {
		   "thousand", "million", "billion"};

	public static void main(String[] args) {
		takeUserNumber();

	}
	
	private static int takeUserNumber(){
		boolean done = false;
		int userNumber = 0;
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
			
			if (userWordType.equals("1")) {
				System.out.println("You have chosen to convert to word form");
				System.out.print(">");
				userNumber = userInput.nextInt();
				if (userNumber <= 999) {
				convert999(userNumber);
				} else if (userNumber < 100) {
				convert99(userNumber);
				}
		   }
	}
		return userNumber;
  }
	
	private static String convert99(int userNumber) {
		if (userNumber < 20) {
			return lowNames[userNumber];
		}
		
		String s = tensNames[userNumber / 10 - 2];
		if (userNumber % 10 == 0) {
			return s;
		}
		return s + "-" + lowNames[userNumber % 10];
	}

	private static String convert999(int userNumber){
		String s1 = lowNames[userNumber / 100] + "hundred";
		String s2 = convert99(userNumber % 100);
		if (userNumber <= 99) {
			System.out.println(s2);
			return s2;
		} else if (userNumber % 100 == 0) {
			System.out.println(s1);
			return s1;
		} else {
			System.out.println(s1 + " " + s2);
			return s1 + " " + s2;
		}
		
	}

}
