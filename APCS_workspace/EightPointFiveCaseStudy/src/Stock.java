
public class Stock {
	
	private String stockSymbol;
	private int totalShares;
	private double totalCost;

	public Stock(String stockSymbol) {
		if (stockSymbol == null) {
			throw new NullPointerException();
		}
		setStockSymbol(stockSymbol.toUpperCase());
	}
	
	public Stock(int shares, int cost) {
		if (shares < 0 || cost < 0) {
			throw new NullPointerException();
		}
		setTotalShares(shares);
		setTotalCost(cost);
	}
	
	public String toString() {
		return String.format("Stock Symbol: %s Shares: %d Total Cost: %.2f", stockSymbol, totalShares, totalCost);
	}
	
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol.toUpperCase();
	}
	
	public void setTotalShares(int totalShares) {
		this.totalShares += totalShares;
	}
	
	public void setTotalCost(double totalCost) {
		this.totalCost += totalCost;
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public int getTotalShares() {
		return totalShares;
	}
	
	public double calcNet(double currentCost) {
		double net;
		double newCostOfAllStocks = currentCost * this.totalShares;
		net = newCostOfAllStocks - this.totalCost;
		return net;
	}
	
}
