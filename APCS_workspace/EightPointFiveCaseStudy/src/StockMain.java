import java.util.Scanner;

public class StockMain {

	public static void main(String[] args) {
		takeUserInput();
	}
	
	private static void takeUserInput() {
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("First Stock's symbol: ");
		Stock firstStock = new Stock(userInput.nextLine());
		double profit1 = calculate(firstStock);
		
		System.out.print("Second stock's symbol: ");
		Stock secondStock = new Stock(userInput.nextLine());
		double profit2 = calculate(secondStock);
		
		if (profit1 > profit2) {
			System.out.printf("%s was more profitable than %s", firstStock.getStockSymbol(), secondStock.getStockSymbol());
		} else if (profit1 < profit2) {
			System.out.printf("%s was more profitable than %s", secondStock.getStockSymbol(), firstStock.getStockSymbol());
		} else {
			System.out.println("The stocks were equal");
		}
		
		userInput.close();
		
	}

	private static double calculate(Stock stock) {
		int purchases;
		double currentPrice;
		Scanner console = new Scanner(System.in);
		System.out.print("How many purchases did you make? ");
		purchases = console.nextInt();
		
		for (int i = 1; i <= purchases; i++) {
			System.out.printf("%d: How many shares, at what price per share? ", i );
			int totalShares = console.nextInt();
			stock.setTotalShares(totalShares);
			Double pricePerStock = console.nextDouble();
			stock.setTotalCost(totalShares * pricePerStock);
			
		}
		
		System.out.print("What is today's price? ");;
		currentPrice = console.nextDouble();
		
		
		System.out.printf("Net profit/loss: $%.2f\n", stock.calcNet(currentPrice));
		System.out.println();
		
		return stock.calcNet(currentPrice);
		
	}

}
