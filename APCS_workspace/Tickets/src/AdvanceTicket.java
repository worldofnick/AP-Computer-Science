
public class AdvanceTicket extends Ticket {
	// Nick Porter
	AdvanceTicket(int ticketNumber) {
		super(ticketNumber);
		super.setTicketType("Advance");
		super.setSalePrice(super.getBasePrice() * (75.0 / 100.0));
	}

}
