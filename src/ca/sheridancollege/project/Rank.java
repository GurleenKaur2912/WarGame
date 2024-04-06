/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * The Rank enum represents the ranks of playing cards in a standard deck. Each rank is associated with an integer value
 * representing its numerical or face value in the game.
 *
 * This enum follows principles of encapsulation, providing private access to the value associated with each rank. It
 * also ensures consistency in naming conventions and readability in representing card ranks.
 *
 * Each enum constant represents a specific rank, and its associated value cannot be modified after initialization. The
 * getValue() method provides a public interface to retrieve the value of each rank.
 *
 * @author Gurleen Kaur Student ID:991717085 Date 5 April 2024
 */
public enum Rank {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

    private final int value;

    /**
     * Constructs a Rank enum constant with the specified value.
     *
     * @param value the numerical value associated with the rank
     */
    Rank(int value) {
        this.value = value;
    }

    /**
     * Retrieves the value associated with the rank.
     *
     * @return the numerical value associated with the rank
     */
    public int getValue() {
        return value;
    }
}
