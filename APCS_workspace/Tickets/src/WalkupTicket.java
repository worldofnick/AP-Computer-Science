
public class WalkupTicket extends Ticket{
	// Nick Porter
	WalkupTicket(int ticketNumber) {
		super(ticketNumber);
		super.setTicketType("Walkup");
		super.setSalePrice(super.getBasePrice());
	}

}
