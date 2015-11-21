
public class StudentTicket extends AdvanceTicket{
	// Nick Porter
	StudentTicket(int ticketNumber) {
		super(ticketNumber);
		super.setTicketType(super.getTicketType() + " Student");
		super.setSalePrice(super.getBasePrice() * (37.5 / 100.0));
	}

	public String toString() {
		return super.toString() + " (ID Required)";
	}
}
