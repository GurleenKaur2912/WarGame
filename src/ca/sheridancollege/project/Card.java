/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Gurleen Kaur Student ID:991717085 Date 5 April 2024
 *
 * The Card class represents a playing card with a specific rank and suit. It encapsulates the rank and suit of the card
 * and provides methods to retrieve them. This class follows principles of encapsulation, single responsibility, and
 * open/closed principle.
 *
 * Encapsulation: Private data members (rank and suit) are encapsulated, and access is provided through public getter
 * methods. Single Responsibility: The primary responsibility of this class is to represent a playing card. Open/Closed
 * Principle: While it's not directly applicable in this class, it can be extended to accommodate new functionalities
 * without modifying existing code.
 */
public class Card {

    private Rank rank;
    private Suit suit;

    /**
     * Constructs a Card object with the specified rank and suit.
     *
     * @param rank the rank of the card
     * @param suit the suit of the card
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Retrieves the rank of the card.
     *
     * @return the rank of the card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Retrieves the suit of the card.
     *
     * @return the suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns a string representation of the card, including its rank and suit.
     *
     * @return a string representation of the card
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

}
