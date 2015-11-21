
public class Number15 {

	static final int DASHES = 5;
	static final int MAX_NUMBER = 9;
	static final int STARTING_NUMBER = 1;
	
	public static void main(String[] args) {
		printDesign();
		
	}
	private static void printDesign(){
		int dashIncrement = 1;
		for (int outputDigits = STARTING_NUMBER; outputDigits <= MAX_NUMBER; outputDigits = outputDigits + 2) {  // controls number output
			
			for (int innerDashes = dashIncrement; innerDashes <= DASHES; innerDashes++)  {     // inner dashes
				System.out.print("-");
			}
			
				for (int digits = 1; digits <= outputDigits; digits++) {           // prints the number x amount of times
					System.out.print(outputDigits);
				}
					for (int outerDashes = dashIncrement; outerDashes <= DASHES; outerDashes++) {  // outer dashes
						System.out.print("-");
					}
			System.out.println();
			dashIncrement++;
		}

	}
}

