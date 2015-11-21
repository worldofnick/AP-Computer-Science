import java.util.Random;

public class CardMain {
	// Nick Porter
	static String[] rankValues = {
			"1", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "Jack", "King", "Queen"
	};
	
	static String[] suits = {
			"Spades", "Clubs", "Hearts", "Diamonds"
	};

	public static void main(String[] args) {
		
		Card[] deckOfCards = new Card[52];
		
		fillDeck(deckOfCards);
		deckOfCards = shuffleDeck(deckOfCards);
		printArray(deckOfCards);
	}
	
	private static Card[] fillDeck(Card[] deck) {
		int offsetOfCard = 0;
		for (int suit = 0; suit < 4; suit++) {
			
			for (int rank = 0; rank < 13; rank++) {
				deck[offsetOfCard] = new Card(rankValues[rank], suits[suit]);
				offsetOfCard++;
			}
		}
		
		return deck;
	}
	
	private static void printArray(Card[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	private static Card[] shuffleDeck(Card[] deck) {
		Random random = new Random();
		
		for(int i = 0; i < deck.length; i++) {
			int randomCard = random.nextInt(deck.length);
			Card temp = deck[i];
			deck[i] = deck[randomCard];
			deck[randomCard] = temp;
		}
		
		return deck;
	}

}

/*2 of Spades
10 of Spades
10 of Clubs
King of Spades
4 of Diamonds
7 of Spades
9 of Clubs
4 of Hearts
4 of Spades
1 of Spades
4 of Diamonds
10 of Spades
King of Diamonds
10 of Spades
4 of Hearts
10 of Hearts
9 of Clubs
1 of Diamonds
Queen of Hearts
6 of Diamonds
4 of Spades
1 of Spades
4 of Spades
8 of Clubs
7 of Diamonds
King of Hearts
3 of Spades
3 of Spades
Jack of Hearts
2 of Spades
9 of Diamonds
7 of Clubs
King of Clubs
7 of Clubs
Jack of Hearts
9 of Diamonds
9 of Diamonds
6 of Hearts
4 of Spades
6 of Diamonds
5 of Spades
4 of Spades
10 of Clubs
King of Spades
6 of Clubs
5 of Clubs
9 of Diamonds
3 of Diamonds
King of Clubs
1 of Hearts
9 of Hearts
2 of Hearts*/
