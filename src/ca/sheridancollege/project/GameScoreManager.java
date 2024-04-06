/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * The GameScoreManager class manages the scoring system for the game, tracking player's scores, determining round
 * winners, and resetting scores for new rounds. It provides methods for adding scores, getting scores, determining the
 * round winner, and resetting scores.
 *
 * @author Gurleen Kaur Student ID:991717085 Date 5 April 2024
 */
import java.util.HashMap;
import java.util.Map;

public class GameScoreManager {

    private Map<Player, Integer> scores;

    /**
     * Constructs a GameScoreManager with an empty scoreboard.
     */
    public GameScoreManager() {
        scores = new HashMap<>();
    }

    /**
     * Adds a player to the scoreboard with an initial score of 0.
     *
     * @param player -the player to add to the scoreboard
     */
    public void addPlayer(Player player) {
        scores.put(player, 0);
    }

    /**
     * Adds points to the score of a specific player.
     *
     * @param player -the player whose score to update
     * @param points -the points to add to the player's score
     */
    public void addScore(Player player, int points) {
        scores.put(player, scores.get(player) + points);
    }

    /**
     * Retrieves the scores of all players.
     *
     * @return a map containing players as keys and their corresponding scores as values
     */
    public Map<Player, Integer> getScores() {
        return scores;
    }

    /**
     * Retrieves the score of a specific player.
     *
     * @param player -the player whose score to retrieve
     * @return the score of the player, or 0 if the player is not found
     */
    public int getScore(Player player) {
        return scores.getOrDefault(player, 0);
    }

    /**
     * Determines the round winner based on the highest score.
     *
     * @return the player who wins the round, or null if no winner is found
     */
    public Player getRoundWinner() {
        Player roundWinner = null;
        int highestScore = Integer.MIN_VALUE;

        for (Map.Entry<Player, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > highestScore) {
                highestScore = entry.getValue();
                roundWinner = entry.getKey();
            }
        }

        return roundWinner;
    }

    /**
     * Resets all player scores to 0 for a new round.
     */
    public void resetScores() {
        scores.replaceAll((player, score) -> 0);
    }
}
