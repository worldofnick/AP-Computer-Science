import java.util.Scanner;


public class SorterMain {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Sorter sorter = createSorter();
		boolean quit = false;
		
		while(!quit) {
			System.out.print("> ");
			sorter.takeInput(userInput.nextLine());
			
		}
		userInput.close();
	}
	
	private static Sorter createSorter() {
		Scanner userInput = new Scanner(System.in);
		Sorter sorter = null;
		System.out.print("Enter array size: ");
		
		try {
			int arraySize = userInput.nextInt();
			if (arraySize <= 0) {
				userInput.close();
				throw new IllegalArgumentException("The array size must be positive");
			}
			sorter = new Sorter(arraySize);
		} catch (Exception e) {
			System.out.println("Please enter a valid numeric value above 0.");
			createSorter();
		}

		return sorter;
	}

	

}
