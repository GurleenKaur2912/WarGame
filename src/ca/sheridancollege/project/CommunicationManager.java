/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Map;

/**
 * This class is responsible for handling communication tasks within a game, including displaying messages, scoreboards,
 * and announcing winners, adhering to the Single Responsibility Principle.
 *
 * @author Gurleen Kaur Student ID:991717085 Date 5 April 2024
 */
public class CommunicationManager {

    /**
     * Displays a message to the user.
     *
     * @param message - the message to be displayed
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays the scoreboard based on the provided map of players and their scores.
     *
     * @param scores -a map containing players and their corresponding scores
     */
    public void displayScoreboard(Map<Player, Integer> scores) {
        displayMessage("\nScoreboard:");
        for (Player player : scores.keySet()) {
            displayMessage(player.getName() + ": " + scores.get(player));
        }
    }

    /**
     * Announces the winner of the round.
     *
     * @param roundWinner -the player who wins the round
     */
    public void announceRoundWinner(Player roundWinner) {
        displayMessage("Winner of this round: " + (roundWinner != null ? roundWinner.getName() : "No winner"));
    }

    /**
     * Announces the final winner of the game.
     *
     * @param finalWinner -the player who wins the game
     */
    public void announceFinalWinner(Player finalWinner) {
        displayMessage("Final Winner: " + (finalWinner != null ? finalWinner.getName() : "No winner"));
    }
}
