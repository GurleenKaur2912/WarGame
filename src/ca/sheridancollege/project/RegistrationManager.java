package ca.sheridancollege.project;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * The RegistrationManager class handles player registration and login functionalities for the game. It encapsulates
 * player information (username and password) and provides methods for registration and login.
 *
 * This class uses a HashMap to store player credentials, associating each username with its corresponding password.
 *
 * @author Gurleen Kaur Student ID:991717085 Date 5 April 2024
 */
import java.util.HashMap;
import java.util.Map;

public class RegistrationManager {

    private Map<String, String> playersInfo; // Store username and password

    /**
     * Constructs a RegistrationManager object with an empty map for storing player credentials.
     */
    public RegistrationManager() {
        playersInfo = new HashMap<>();
    }

    /**
     * Registers a new player with the provided username and password.
     *
     * @param username the username of the new player
     * @param password the password of the new player
     */
    public void register(String username, String password) {
        playersInfo.put(username, password);
    }

    /**
     * Authenticates a player's login by verifying the provided username and password.
     *
     * @param username the username of the player attempting to login
     * @param password the password of the player attempting to login
     * @return true if the provided username exists and the associated password matches, false otherwise
     */
    public boolean login(String username, String password) {
        // Check if the username exists in the map and if the associated password matches
        return playersInfo.containsKey(username) && playersInfo.get(username).equals(password);
    }
}
