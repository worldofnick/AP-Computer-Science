package newSorter;

import java.util.Scanner;

public class SorterMain1 {
	// Nick Porter
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		Sorter1 sorter = createSorter();
		boolean quit = false;
		
		while(!quit) {
			System.out.print("> ");
			sorter.takeInput(userInput.nextLine().toLowerCase());
			
		}
		userInput.close();
		
	}
	
	private static Sorter1 createSorter() {
		Scanner userInput = new Scanner(System.in);
		Sorter1 sorter = null;
		System.out.print("Enter array size: ");
		
		try {
			int arraySize = userInput.nextInt();
			if (arraySize <= 0) {
				userInput.close();
				throw new IllegalArgumentException("The array size must be positive");
			}
			sorter = new Sorter1(arraySize);
		} catch (Exception e) {
			System.out.println("Please enter a valid numeric value above 0.");
			createSorter();
		}

		return sorter;
	}

}

