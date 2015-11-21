
public class TicketMain {
// Nick Porter
	public static void main(String[] args) {
		
		Ticket walkup = new WalkupTicket(456);
		Ticket advance = new AdvanceTicket(431);
		Ticket student = new StudentTicket(741);
		System.out.println("Regular season:");
		System.out.printf("\t%s\n\t%s\n\t%s\n", walkup, advance, student);
		
		Ticket.setBasePrice(12.0);
		Ticket walkupFinals = new WalkupTicket(789);
		Ticket advanceFinals = new AdvanceTicket(654);
		Ticket studentFinals = new StudentTicket(357);
		System.out.println("Playoffs:");
		System.out.printf("\t%s\n\t%s\n\t%s\n", walkupFinals, advanceFinals, studentFinals);
	}

}

/*Regular season:
	Ticket type: Walkup, Number: 456, Price: $10.00
	Ticket type: Advance, Number: 431, Price: $7.50
	Ticket type: Advance, Number: 741, Price: $3.75 (ID Required)
Finals season:
	Ticket type: Walkup, Number: 789, Price: $12.00
	Ticket type: Advance, Number: 654, Price: $9.00
	Ticket type: Advance, Number: 357, Price: $4.50 (ID Required)*/
