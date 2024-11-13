import java.util.LinkedList;

/**
 * Class that creates the game of ERS
 */

public class Game {
    private LinkedList<Player> players;
    private LinkedList<Card> pile;
    private Dealer dealer;
    private String[] patterns;
    private boolean faceOff;

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public LinkedList<Card> getPile() {
        return pile;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public String[] getPatterns() {
        return patterns;
    }

    /**
     * Default Constructor for a game of 2 players
     */
    public Game() {
        this.players = new LinkedList<Player>();
        this.pile = new LinkedList<Card>();
        this.dealer = new Dealer();
        this.patterns = new String[] { "doubles", "top bottom", "sandwich" };
        for (int i = 1; i <= 2; i++) {
            players.add(new Player(i, dealer.deals(26), patterns[(int) (Math.random() * patterns.length)]));

        }
        this.faceOff = false;
    }

    /**
     * Overloaded Constructor for a game of how many players you input in the main
     * class
     * 
     * @param numPlayers integer value for number of players in the ERS game
     */
    public Game(int numPlayers) {
        this.players = new LinkedList<Player>();
        this.pile = new LinkedList<Card>();
        this.dealer = new Dealer();
        this.patterns = new String[] { "doubles", "top bottom", "sandwich" };
        for (int i = 1; i <= numPlayers; i++) {
            players.add(
                    new Player(i, dealer.deals(52 / numPlayers), patterns[(int) (Math.random() * patterns.length)]));

        }
        this.faceOff = false;
    }

    /**
     * Takes care of the overall gameplay and calls most functions
     * 
     */
    public int play() {
        while (players.size() > 1) {
            Player currentPlayer = players.getFirst();
            if (currentPlayer.getHand().isEmpty()) {
                System.out.println(currentPlayer + " ran out of cards and is out of the game! ");
                players.remove(currentPlayer);
                continue;
            }
            Card currentCard = currentPlayer.playCard();
            pile.addLast(currentCard);
            System.out.println(currentPlayer + " plays " + currentCard);

            if (faceCardCheck(currentCard)) {
                ifFaceCard(currentPlayer);
            } else {
                ifNormalCard();
            }

        }
        return 1;
    }

    /**
     * Function for when a face card is placed
     * Initiates a face card duel
     * 
     * @param currentPlayer Player object that represents the Player who is
     *                      currently on turn
     */
    private void ifFaceCard(Player currentPlayer) {
        if (pile.isEmpty()) {
            return;
        }

        int duels = faceCardDuel(currentPlayer);
        int currentDuel = 0;

        faceOff = true;

        while (currentDuel < duels) {
            Player nextPlayer = nextPlayer();
            if (nextPlayer.getHand().isEmpty()) {
                System.out.println(nextPlayer + " ran out of cards and is out of the game! ");
                players.remove(nextPlayer);
                break;
            }
            Card nextCard = nextPlayer.playCard();
            pile.addLast(nextCard);
            System.out.println(nextPlayer + " plays " + nextCard);
            currentDuel++;

            if (faceCardCheck(nextCard)) {
                currentPlayer = nextPlayer;
                duels = faceCardDuel(currentPlayer);
                currentDuel = 0;
            }
        }
        currentPlayer.getHand().addAll(pile);
        pile.clear();

        faceOff = false;

    }

    /**
     * Function that determines what happens when a normal card is placed in the
     * pile
     */
    private void ifNormalCard() {
        LinkedList<Player> slappingPlayers = new LinkedList<>();

        for (Player player : players) {
            if (player.slaps(pile)) {
                slappingPlayers.add(player);

            }
        }
        if (!slappingPlayers.isEmpty()) {
            Player slappingPlayer = getSlappingPlayer(slappingPlayers);
            System.out.println(slappingPlayer + " slaps and takes the card pile!");
            slappingPlayer.getHand().addAll(pile);
            pile.clear();
        }
    }

    /**
     * This checks if multiple people are able to slap, therefore getting one person
     * to "slap it first"
     * 
     * @param players Linked List of the players
     * @return Player object that slaps the pile
     */
    private Player getSlappingPlayer(LinkedList<Player> players) {
        return players.get((int) (Math.random() * players.size()));
    }

    /**
     * Checks if the card placed is a face Card
     * 
     * @param card
     * @return true or false depending on if the card is a face Card
     */
    private boolean faceCardCheck(Card card) {
        return card != null && (card.getValue() == Card.JACK || card.getValue() == Card.QUEEN ||
                card.getValue() == Card.KING || card.getValue() == Card.ACE);
    }

    /**
     * Determins the number of cards the next player has to draw from their hand
     * based on the face card placed by the previous player
     * 
     * @param player
     * @return integer of the number of cards the next player has to place
     */
    private int faceCardDuel(Player player) {
        if (pile.getLast().getValue() == Card.JACK) {
            return 1;
        } else if (pile.getLast().getValue() == Card.QUEEN) {
            return 2;
        } else if (pile.getLast().getValue() == Card.KING) {
            return 3;
        } else if (pile.getLast().getValue() == Card.ACE) {
            return 4;
        } else {
            return 0;
        }

    }

    public Player nextPlayer(Player currentPlayer) {
        int i = players.indexOf(currentPlayer);
        int iNext = (i + 1) % players.size();
        return players.get(iNext);
    }

    /**
     * Method that returns the player that is next in turn
     * 
     * @return Player next in turn
     */
    public Player nextPlayer() {
        int i = players.indexOf(players.getFirst());
        int iNext = (i + 1) % players.size();
        return players.get(iNext);
    }

    /**
     * Static methods for all 3 types of slaps
     * 
     * @param pile
     * @return boolean whether the pile is slappable depending on the rules
     */
    static boolean doubles(LinkedList<Card> pile) {
        return pile.size() >= 2 && pile.get(pile.size() - 1).equals(pile.get(pile.size() - 2));
    }

    static boolean sandwich(LinkedList<Card> pile) {
        return pile.size() >= 3 && pile.get(pile.size() - 1).equals(pile.get(pile.size() - 3)) &&
                !(pile.get(pile.size() - 1).equals(pile.get(pile.size() - 2)));
    }

    static boolean topBottom(LinkedList<Card> pile) {
        return pile.size() >= 2 && pile.get(pile.size() - 1).equals(pile.get(0));
    }

}
