import java.util.LinkedList;

public class TestCards {
    public static void main(String[] args) {
        Card card1 = new Card();
        System.out.println(card1);

        Card card2 = new Card(Card.KING, Card.DIAMONDS);
        System.out.println(card2);

        System.out.println(card1.equals(card2));

        Deck deck = new Deck();
        System.out.println(deck);
        System.out.println("Size of the deck: " + deck.size());

        Dealer dealer = new Dealer();
        System.out.println(dealer.toString());

        System.out.println(dealer.size());

        LinkedList<Card> dealtCards = dealer.deals(10);
        System.out.println(dealtCards.size() + " dealed");
        for (int i = 0; i < dealtCards.size(); i++) {
            System.out.println(dealtCards.get(i).toString());
        }
        Player player = new Player(1, dealtCards, "test");
        System.out.println(player);

    }
}
