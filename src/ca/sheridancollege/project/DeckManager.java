/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * The DeckManager class handles the creation and management of a deck of cards in a game. It provides functionality to
 * create a shuffled deck, distribute cards among players, and allow players to draw cards from the deck.
 *
 * @author Gurleen Kaur Student ID:991717085 Date 5 April 2024
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckManager {

    private List<Card> deck;

    /**
     * An empty constructor
     */
    public DeckManager() {
        deck = new ArrayList<>();
    }

    /**
     * Creates a standard deck of 52 cards and distributes them equally among the players.
     *
     * @param players the list of players to distribute cards to
     */
    public void createDeck(List<Player> players) {
        initializeDeck();
        shuffleDeck();
        distributeCards(players);
    }

    /**
     * Initializes the deck with a standard set of 52 cards.
     */
    private void initializeDeck() {
        deck.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Shuffles the deck using the Collections.shuffle() method.
     */
    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    /**
     * Distributes cards equally among the players and handles any remaining cards.
     *
     * @param players the list of players to distribute cards to
     */
    private void distributeCards(List<Player> players) {
        int numPlayers = players.size();
        int cardsPerPlayer = deck.size() / numPlayers;
        int remainingCards = deck.size() % numPlayers;
        int cardIndex = 0;

        for (Player player : players) {
            List<Card> playerCards = new ArrayList<>();
            for (int i = 0; i < cardsPerPlayer; i++) {
                playerCards.add(deck.get(cardIndex++));
            }
            player.addCards(playerCards);
        }

        // Distribute remaining cards
        for (int i = 0; i < remainingCards; i++) {
            players.get(i).addCard(deck.get(cardIndex++));
        }
    }

    /**
     * Draws a card from the deck.
     *
     * @return the drawn card
     * @throws IllegalStateException if the deck is empty
     */
    public Card drawCard() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("Deck is empty. Cannot draw card.");
        }
        return deck.remove(0);
    }

    /**
     * Gets the current size of the deck.
     *
     * @return the number of cards remaining in the deck
     */
    public int getDeckSize() {
        return deck.size();
    }
}
