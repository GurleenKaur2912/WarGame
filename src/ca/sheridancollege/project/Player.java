/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Gurleen Kaur Student ID:991717085 Date 5 April 2024
 *
 * The Player class represents a player in the game, managing the player's name, hand of cards, scoring, and hand
 * resetting. It provides methods for accessing player information, adding cards to the player's hand, calculating
 * scores, and resetting the hand.
 *
 * @author hp
 */
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> hand;

    /**
     * Constructs a Player object with a specified name and an empty hand.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    /**
     * Retrieves the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the player's hand of cards.
     *
     * @return the list of cards in the player's hand
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * Adds a list of cards to the player's hand.
     *
     * @param cards the list of cards to add to the player's hand
     */
    public void addCards(List<Card> cards) {
        hand.addAll(cards);
    }

    /**
     * Adds a card to the player's hand.
     *
     * @param card the card to add to the player's hand
     */
    public void addCard(Card card) {
        hand.add(card);
    }

    /**
     * Calculates the player's score based on the values of the cards in the hand.
     *
     * @return the total score of the player
     */
    public int getScore() {
        int score = 0;
        for (Card card : hand) {
            score += card.getRank().getValue();
        }
        return score;
    }

    /**
     * Resets the player's hand by clearing all cards.
     */
    public void resetHand() {
        hand.clear();
    }
}
