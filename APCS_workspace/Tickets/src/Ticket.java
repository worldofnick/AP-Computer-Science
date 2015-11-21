
public class Ticket {

	private double price;
	private int ticketNumber;
	
	Ticket(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String toString() {
		return "Ticket #: " + ticketNumber + "Price: $" + price;
	}
	
}
