
public class Card {
// Nick Porter
	private String rank;
	private String suit;
	
	
	Card(String rank, String suit) {
		setRank(rank);
		setSuit(suit);
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public String getSuit() {
		return suit;
	}


	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public String toString() {
		return this.rank + " of " + this.suit;
	}
	
	
	
}
