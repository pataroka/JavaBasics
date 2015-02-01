import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class P6_RandomHandsOf5Cards {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Card> cardsList = createDeck();
		for (int j = 0; j < n; j++) {
		    Card[] hand = randomHand(cardsList);
		    for (Card card : hand) {
			System.out.printf("%s%c ", card.getFace(), card.getSuit());
		    }
		    System.out.println();
		}
		in.close();
    }

    private static Card[] randomHand(ArrayList<Card> cardsList) {
		Random random = new Random();
		Card[] hand = new Card[5];
		for (int i = 0; i < hand.length; i++) {
		    int index = random.nextInt(cardsList.size());
		    hand[i] = cardsList.remove(index);
		}
		return hand;
    }

    private static ArrayList<Card> createDeck() {
		String[] faces = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
			"Q", "K", "A" };
		char[] suits = { '♣', '♦', '♥', '♠' };
		Card[] cards = new Card[52];
		ArrayList<Card> cardsList = new ArrayList<>();
		int x = 0;
		for (int i = 0; i < suits.length; i++) {
		    for (int j = 0; j < faces.length; j++) {
			cards[x] = new Card(faces[j], suits[i]);
			cardsList.add(cards[x]);
			x++;
		    }
		}
		return cardsList;
    }

}