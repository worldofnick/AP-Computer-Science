import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Nick Porter
public class PlinkoMain {
	
	// stores all possible slots
	static Double[] slotNumbers = { 
		    0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5, 6.0, 6.5, 7.0, 7.5, 8.0
		};

	public static void main(String[] args) {
		plinko();
	}
	
	private static void plinko(){
	
		Scanner userInput = new Scanner(System.in);
		boolean quit = false;  // ensures the while loop will be entered and is able to be stopped
		int numberOfChips = 0; 
		System.out.println("Welcome to Plinko!");
		
		while (quit == false) {
			
			System.out.println("Please enter a selection");
			System.out.println("1 - Drop one chip into one slot");
			System.out.println("2- Drop multiple chips into one slot");
			System.out.println("3 - quit");
			System.out.print("> ");
			// asks the user to pick either 1 or multiple chips or quit
			int userSelection = userInput.nextInt();
			
			// Checks if the user wants to quit. :(
			if (userSelection == 3) {
				System.out.println("Goodbye");
				break;
				
				// Checks if the user made a invalid selection.
			} else if (userSelection > 3 || userSelection < 0  ) {
				System.out.println("Please enter a valid selection");
				continue;
			} else{
				if (userSelection == 1) {
					numberOfChips = 1;				// Sets the chip number to 1.
					
				} else if (userSelection == 2) {   // User wants multiple chips.
					System.out.println("How many chips do you want to drop?"); // Then asks how many chips.
					System.out.print("> ");
					numberOfChips = userInput.nextInt(); // Stores number of chips.
				}
				System.out.println("Which slot do you want to drop your chips into? Slots are 0 - 8");  
				System.out.print("> ");
				Double userChip = userInput.nextDouble(); // asks the user for the slot they wish to drop the chip into and stores it
				double userChipDouble = userChip;
				
				if (userChipDouble >= 9 || userChipDouble < 0) {  // checks if they dropped the chip in a valid slot
					System.out.println("Please enter a valid slot");
					System.out.println();
					continue;
				} else {
					
					dropChip(slotNumbers, numberOfChips, userChipDouble); // drops the chip
					
			}
		}
	}
		userInput.close();
  }

	private static void dropChip(Double[] slotNumbers, int numberOfChips,
			double userChipDouble) {
		int indexOf;
		int prizeMoney = 0;
		for (int i = 1 ; i <= numberOfChips; i++) {  // this is how i made it compatible with multiple chips
			System.out.print("Chip #" + i + " ");
			int allDone = 0;
			double chipHolder = userChipDouble;
			indexOf = Arrays.binarySearch(slotNumbers, userChipDouble);
			Random random = new Random();  // generate a random boolean 
			userChipDouble = chipHolder;
			System.out.print(slotNumbers[indexOf] + " ");
			
			while (allDone < 12) {
				
				boolean test = random.nextBoolean();	// generates a random boolean to determine whether you wil add or subtract
				indexOf = Arrays.binarySearch(slotNumbers, userChipDouble);
				boolean offBoard = false;
				Double possibleSlot1 = -1.0; // these needed to be -1 because of the possibleslot tests below 
				Double possibleSlot2 = -1.0;
				
				if (indexOf == 0 || possibleSlot1 == 0 || possibleSlot2 == 0) { 	// if chip is at the edge of the board it makes sure it stays in play
					
					possibleSlot1 = slotNumbers[indexOf + 1];
					userChipDouble = possibleSlot1;
					offBoard = true;
					System.out.print(possibleSlot1 + " ");
				} else if (indexOf == 16 || possibleSlot2 == 16 || possibleSlot1 == 16) { // if chip is at the edge of the board it makes sure it stays in play
					possibleSlot2 = slotNumbers[indexOf - 1];
					userChipDouble = possibleSlot2;
					System.out.print(possibleSlot2 + " ");
					offBoard = true;
					
				} else{
				if (test == true && offBoard == false) {
					
					possibleSlot1 = slotNumbers[indexOf + 1]; // tests the random boolean, if true go up 1 in the index or .5
					userChipDouble = possibleSlot1;
					System.out.print(possibleSlot1 + " ");
					
				} else if (test == false && offBoard == false) {
					
					possibleSlot2 = slotNumbers[indexOf - 1]; // tests the random boolean, if false go down 1 in the index or -.5
					userChipDouble = possibleSlot2;
					System.out.print(possibleSlot2 + " ");	
				}
			}
				allDone++; // update for the while loop
		}
			prizeMoney = prizeMoney+ prizeMoney(userChipDouble); // Cumulative algorithm of store the money we have to waste on the user
			System.out.println();
	}
		System.out.println("You won" + " $" + prizeMoney + "!"); // tells them how much money they did not really win
		System.out.println();
  }
	
	private static int prizeMoney(double slotNumber){  // method for calculating the prize money
		int prizeSlot = (int) slotNumber; // converted to int to make sure that it always lands in a whole number.
		int prizeMoney = 0;
		if (prizeSlot == 3 || prizeSlot == 5) {
			prizeMoney = 0;
		} else if (prizeSlot == 0 || prizeSlot == 8) {
			prizeMoney = prizeMoney + 100;
		} else if (prizeSlot == 1 || prizeSlot == 7) {
			prizeMoney = prizeMoney + 500;
		} else if (prizeSlot == 2 || prizeSlot == 6) {
			prizeMoney = prizeMoney + 1000;
		} else if (prizeSlot == 4) {
			prizeMoney = prizeMoney + 10000;
		}
		return prizeMoney;
	}

}

/*How many chips do you want to drop?
>4
Which slot do you want to drop your chip into? Slots are 0 - 8
>6
Chip #1 6.0 5.5 5.0 5.5 6.0 5.5 6.0 5.5 6.0 5.5 6.0 6.5 6.0 
Chip #2 6.0 5.5 5.0 4.5 4.0 4.5 5.0 4.5 5.0 5.5 6.0 6.5 6.0 
Chip #3 6.0 6.5 7.0 6.5 7.0 6.5 6.0 5.5 6.0 5.5 6.0 5.5 6.0 
Chip #4 6.0 5.5 6.0 5.5 6.0 6.5 7.0 7.5 7.0 7.5 7.0 6.5 7.0 
You won $3500!
Please enter a selection
1 - Drop one chip into one slot
2- Drop multiple chips into one slot
3 - quit
>*/


