/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Gurleen Kaur Student ID:991717085 Date 5 April 2024
 *
 * The Game class orchestrates the flow of the game, managing players, the deck of cards, scoring, communication, and
 * registration. It provides methods for adding players, creating and distributing the deck, playing rounds, displaying
 * the scoreboard, and managing player registration.
 *
 */
public class Game {

    private List<Player> players;
    private DeckManager deckManager;
    private GameScoreManager scoreManager;
    private CommunicationManager communicationManager;
    private RegistrationManager registrationManager;

    /**
     * Constructs a Game object with initializations of players, deck manager, score manager, communication manager, and
     * registration manager.
     */
    public Game() {
        players = new ArrayList<>();
        deckManager = new DeckManager();
        scoreManager = new GameScoreManager();
        registrationManager = new RegistrationManager();
        communicationManager = new CommunicationManager();
    }

    /**
     * Adds a player to the game.
     *
     * @param name -the name of the player to be added
     */
    public void addPlayer(String name) {
        Player player = new Player(name);
        players.add(player);
        scoreManager.addPlayer(player);
    }

    /**
     * Creates a deck of cards and distributes them among the players.
     */
    public void createDeckAndDistribute(List<Player> players) {
        deckManager.createDeck(players);
    }

    /**
     * Method to play a round of the game.
     */
    public void playRound() {
        for (Player player : players) {
            scoreManager.addScore(player, 0);
        }

        boolean gameOn = true;
        while (gameOn) {
            for (Player player : players) {
                Scanner scanner = new Scanner(System.in);
                System.out.println(player.getName() + ", press enter to draw a card...");
                scanner.nextLine();
                Card drawnCard = deckManager.drawCard();
                System.out.println(player.getName() + " drew: " + drawnCard);
                scoreManager.addScore(player, drawnCard.getRank().getValue());
                if (scoreManager.getScore(player) >= 21) {
                    gameOn = false;
                    break;
                }
            }
        }
    }

    /**
     * Method to display the scoreboard.
     */
    public void showScoreboard() {
        communicationManager.displayScoreboard(scoreManager.getScores());
    }

    /**
     * Method to reset player scores for a new round.
     */
    public void resetScores() {
        scoreManager.resetScores();
        for (Player player : players) {
            player.resetHand();
        }
    }

    /**
     * Method to determine the winner of the round based on total scores.
     *
     * @return the player who wins the round
     */
    public Player getRoundWinner() {
        return scoreManager.getRoundWinner();
    }

    /**
     * Method to register a new player.
     *
     * @param username -the username of the new player
     * @param password -the password of the new player
     */
    public void registerPlayer(String username, String password) {
        registrationManager.register(username, password);
    }

    /**
     * Method to log in a player.
     *
     * @param username -the username of the player
     * @param password -the password of the player
     * @return true if login is successful, false otherwise
     */
    public boolean login(String username, String password) {
        return registrationManager.login(username, password);
    }

    /**
     * Method to retrieve the list of players.
     *
     * @return the list of players
     */
    public List<Player> getPlayers() {
        return players;
    }
}
