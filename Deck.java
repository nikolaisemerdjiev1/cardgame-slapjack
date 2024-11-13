import java.util.LinkedList;
import java.util.Random;

/**
 * This class represents a Deck
 * It contains the 52 Cards of a Deck
 * It also allows you to deal cards from the deck
 * 
 * @author Nikolai Semerdjiev
 * @version 1.0
 */
public class Deck {
    private LinkedList<Card> m_cards = new LinkedList<Card>(); // Linked List of cards that represent the deck

    /**
     * Default Constructor that creates a default deck of 52 cards
     */
    public Deck() {
        int valCount;
        int suitCount;
        for (suitCount = 0; suitCount <= 3; suitCount++) {
            for (valCount = 2; valCount <= 14; valCount++) {
                m_cards.add(new Card(valCount, suitCount));
            }
        }
    }

    /**
     * Non-Default Copy Constructor that allows creation of an identical Deck
     * Availablity is also copied
     * 
     * @param d Deck to be copied
     */
    public Deck(Deck d) {
        m_cards = new LinkedList<Card>(d.m_cards);
    }

    /**
     * Display for Decks with a cool outline
     */
    public String toString() {
        String strDeck = "~~~~~~~~~~~~~~~~\n";

        for (int i = 0; i < m_cards.size(); i++) {
            strDeck += m_cards.get(i).toString();
        }

        return strDeck + "~~~~~~~~~~~~~~~~\n";
    }

    /**
     * Method that returns the size of the deck
     * 
     * @return integer that represents the size of the deck
     */
    public int size() {
        return m_cards.size();
    }

    /**
     * A method that deals a card from the deck
     * 
     * @return a random Card from the deck
     */
    public Card deal() {
        Random randy = new Random();
        int randIndex = randy.nextInt(m_cards.size());
        Card randCard = m_cards.remove(randIndex);
        return randCard;

    }
}
