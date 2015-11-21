
public abstract class Ticket {
// Nick Porter
	private static double basePrice = 10;
	private String ticketType;
	private int ticketNumber;
	private double salePrice;
	
	Ticket(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	public String toString() {
		return String.format("Ticket type: %s, Number: %d, Price: $%.2f", this.ticketType, this.ticketNumber, this.salePrice);
	}

	public static double getBasePrice() {
		return basePrice;
	}

	public static void setBasePrice(double basePrice) {
		Ticket.basePrice = basePrice;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	
}
