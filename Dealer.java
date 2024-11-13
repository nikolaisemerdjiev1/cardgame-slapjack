import java.util.LinkedList;

/**
 * This class represents a Dealer
 * that has a deck and can deal cards to players
 * of a card game
 * 
 * @author Nikolai Semerdjiev
 * @version 1.0
 */

public class Dealer {
    private Deck m_deck; // Deck Object that represents the deck of the dealer

    /**
     * Default Constructor that creates a default 52 card deck for the dealer
     */
    public Dealer() {
        this.m_deck = new Deck();
    }

    /**
     * A method that returns a new deck containing cards removed from the dealer's
     * original deck
     * 
     * @param n an Integer that represents the number of cards dealt
     * @return a Linked List that represents the cards dealt
     */
    public LinkedList<Card> deals(int n) {
        LinkedList<Card> newDeck = new LinkedList<Card>();
        if (this.m_deck.size() == 0) {
            return newDeck;
        }

        for (int i = 0; i < n; i++) {
            Card card = this.m_deck.deal();
            if (card != null) {
                newDeck.add(card);
            }
        }
        return newDeck;
    }

    /**
     * A method that returns the size of the dealer's deck
     * 
     * @return
     */
    public int size() {
        return this.m_deck.size();
    }

    /**
     * Display for Dealers with a cool outline
     */
    public String toString() {
        return this.m_deck.toString();
    }
}
