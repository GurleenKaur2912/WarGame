/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * The Runner class serves as the entry point for the game. It allows players to register, log in, set up the game, play
 * rounds, and determine the final winner.
 *
 * This class interacts with the Game class to orchestrate the game flow and user interactions.
 *
 * @author Gurleen Kaur Student ID:991717085 Date 5 April 2024
 */
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        // Register players
        System.out.print("Do you want to register? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter a username: ");
            String username = scanner.nextLine().trim();
            System.out.print("Enter a password: ");
            String password = scanner.nextLine().trim();

            if (username.isEmpty() || password.isEmpty()) {
                System.out.println("You cannot proceed without entering a username and password. Please enter a valid username and password.");
                return; // Exit the program
            }

            game.registerPlayer(username, password);
        } else {
            System.out.println("Sorry, you cannot play the game without registering.");
            return; // Exit the program
        }

        // Login
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("\nPlease log in to start playing.");
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            loggedIn = game.login(username, password);
            if (!loggedIn) {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        // Game setup
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            game.addPlayer(playerName);
        }
        game.createDeckAndDistribute(game.getPlayers());

        // Start game
        boolean playAgain = true;
        while (playAgain) {
            game.playRound();
            game.showScoreboard();
            Player roundWinner = game.getRoundWinner();
            System.out.println("Winner of this round: " + (roundWinner != null ? roundWinner.getName() : "No winner"));
            game.resetScores();
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAnotherRound = scanner.nextLine();
            playAgain = playAnotherRound.equalsIgnoreCase("yes");
        }

        // Final winner
        Player finalWinner = game.getRoundWinner();
        System.out.println("Final Winner: " + (finalWinner != null ? finalWinner.getName() : "No winner"));
    }
}
