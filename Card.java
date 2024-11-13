/**
 * This class represents a Card
 * that has a value and suit and
 * can compare different Cards
 * 
 * @author Nikolai Semerdjiev
 * @version 1.0
 */

public class Card {
    private int value; // Integer value that corresponds with a number or face on a card
    private int suit; // Integer value that corresponds with a card's suit

    /**
     * Static values that can be easier accesible
     * and represent the suits and face cards
     */
    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    /**
     * Default Constructor that chooses an Ace of Spades
     */
    public Card() {
        this.value = ACE;
        this.suit = SPADES;
    }

    /**
     * Non-Default Overloaded Constructor that allows a developer
     * to specify the value and suit
     * Availability is always true by default and cannot be overridden
     * 
     * @param value
     * @param suit
     */
    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Non-Default Copy Constructor that allows creation of an identical Card
     * Availability is also copied
     * 
     * @param c Card to be copied
     */
    public Card(Card c) {
        this.value = c.value;
        this.suit = c.suit;
    }

    /**
     * Display for Cards with a cool outline
     * with the value and suit integers being converted
     * either number or face card and suit String
     * 
     */

    public String toString() {
        String strVal;
        String strSuit;

        if (this.value >= 2 && this.value <= 10) {
            strVal = String.valueOf(this.value);
        } else if (this.value == 11) {
            strVal = "Jack";
        } else if (this.value == 12) {
            strVal = "Queen";
        } else if (this.value == 13) {
            strVal = "King";
        } else if (this.value == 14) {
            strVal = "Ace";
        } else {
            strVal = "Invalid input";
        }

        if (this.suit == HEARTS) {
            strSuit = "Hearts";
        } else if (this.suit == SPADES) {
            strSuit = "Spades";
        } else if (this.suit == CLUBS) {
            strSuit = "Clubs";
        } else if (this.suit == DIAMONDS) {
            strSuit = "Diamonds";
        } else {
            strSuit = "Invalid Input";
        }

        return strVal + " of " + strSuit;
    }

    /**
     * Determines if an object is equivalent to this Card
     * Two Cards are equivalent if their values are equal
     * Availability is not considered for equivalency.
     */
    public boolean equals(Object o) {
        if (!(o instanceof Card)) {
            return false;
        } else {
            Card otherCard = (Card) o;
            return this.value == otherCard.value;
        }
    }

    /**
     * Accessors and Mutators for each priminitive
     * (value and suit)
     */

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSuit() {
        return this.suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }
}