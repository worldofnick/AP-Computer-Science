import java.util.Scanner;


public class NutsAndBoltsMain {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("How many items? ");
		int numberOfItems = userInput.nextInt();
		String[][] firstArray = new String[numberOfItems][2];
		String[][] secondArray = new String[numberOfItems][2];
		
		fillInventory(firstArray);
		System.out.println("Enter in the current prices");
		fillInventory(secondArray);

		comparePrices(firstArray, secondArray);
		userInput.close();

	}
	
	private static String[][] fillInventory(String[][] items) {
		Scanner takeItems = new Scanner(System.in);
		for (int i = 0; i < items.length; i++) {
			items[i][0] = takeItems.next();
			items[i][1] = takeItems.next();
		}
		takeItems.close();
		return items;
		
	}
	
	private static void comparePrices(String[][] firstPrices, String[][] secondPrices) {
		for (int i = 0; i < firstPrices.length; i++) {
			
			if (firstPrices[i][1] != secondPrices[i][2]) {
				int firstPrice = Integer.parseInt(firstPrices[i][1]);
				int secondPrice = Integer.parseInt(firstPrices[i][1]);
				int priceDifference = firstPrice - secondPrice;
				if (priceDifference > 0) {
					System.out.print(firstPrices[i][0] + "+" + priceDifference);
				} else {
					System.out.print(firstPrices[i][0] + priceDifference);
				}
			}
		}
	}

}
