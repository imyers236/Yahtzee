/* (C)2021 */
package edu.gonzaga;

/*
* Class for a Die used in Yahtzee.
*/

import java.util.Random;
import java.util.Scanner;

/** Class to store the state of a single die. */
public class Die implements Comparable<Die> {
    private Integer sideUp; // Current die 'value' in range 1..numSides
    private Integer numSides; // Sides on the die (should be 1...INF integer)
    private static final Integer DEFAULT_NUM_SIDES = 6;
    private static final Integer DEFAULT_SIDE_UP = 1;
    private static Integer DICE_IN_PLAY = 5;

    public Die() {
        this.numSides = DEFAULT_NUM_SIDES;
        this.sideUp = DEFAULT_SIDE_UP;
    }

    public Die(Integer numSides) {
        this.numSides = numSides;
        this.sideUp = DEFAULT_SIDE_UP;
    }

    public Die(Integer numSides, Integer startingSide) {
        this.numSides = numSides;
        this.sideUp = startingSide;
    }

    /** Rolls the die once, getting new random value. */
    public void roll() {
        Random rand = new Random();
        this.sideUp = rand.nextInt(this.numSides) + 1;
    }

    /**
    * Returns current die value (the side that's up).
    *
    * @return Integer Current Die's Side Up
    */
    public Integer getSideUp() {
        return this.sideUp;
    }

    /**
    * Returns quantity of sides on the die.
    *
    * @return Integer number of sides on the die
    */
    public Integer getNumSides() {
        return this.numSides;
    }

    /**
     * The function rolls a set number of dice and returns the resulting values as a string.
     * 
     * @param hand An array of Integers representing the values of the dice in the player's hand. The
     * method rolls each die and updates the corresponding element in the array with the new value. The
     * method then returns a String representation of the new values of the dice in the hand.
     * @return The method `defaultHand` returns a `String` representation of the values rolled on
     * `DICE_IN_PLAY` number of dice.
     */
    public String defaultHand(Integer[] hand)
    {
        String dice = "";
        for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
            {
                    roll();
                    hand[dieNumber] = getSideUp();    
                    dice = dice + String.valueOf(getSideUp()) ;
            }
        return dice;
    }

    /**
     * The function simulates rolling dice and updates the hand based on which dice to keep.
     * 
     * @param hand an array of integers representing the current values of the dice in the player's
     * hand
     * @param keep The "keep" parameter is a String that represents which dice the player wants to keep
     * from their current hand. The String contains a sequence of characters, where each character
     * corresponds to a die in the hand. If the character is 'y', it means the player wants to keep
     * that die and not roll
     * @return The method is returning a String representation of the dice values in the hand after
     * rolling and potentially keeping certain dice based on the input String `keep`.
     */
    public String dhand(Integer[] hand, String keep)
    {
        String dice = "";
        for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
            {
                if (keep.charAt(dieNumber) != 'y')
                {
                    roll();
                    hand[dieNumber] = getSideUp();    
                }
                dice = dice + String.valueOf(hand[dieNumber]);
            }
        return dice;
    }
    
    /**
     * Prints the numbers from the roll then inputs the ones kept until out of turns or all dice are kept
     * 
     * @param hand is the array of dice that gets inputted
     * @param user is the users inputs
     * @return keep to tell main function whether it quit
     * keep is the input from user for what is kept
     * turn keeps track of how many turns have been used
     * dieNumber is for every die
     * DICE_IN_PLAY is the number of dice the game is using
     */
    public String dieHand(Integer[] hand, Scanner user, String player1, ScoreCard score)
    {
        
        String keep = "nnnnn"; //setup to roll all dice in the first roll
        String options = "1";
        Integer turn = 1;
        while ((turn < 3) && !(keep.equals("yyyyy")) && !(keep.equals("q")))
        {
            System.out.println("Type 1 to roll");
            System.out.println("Type 2 to see current scorecard");
            System.out.println("Please select an option from above: ");
            options = user.nextLine();
            if(options.equals("2"))
            {
                score.printTotalScore(hand);
            }
            //roll dice not kept
            for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
            {
                if (keep.charAt(dieNumber) != 'y')
                {
                    roll();
                    hand[dieNumber] = getSideUp();
                }
                    
            }
            //output roll
            System.out.print(player1 + " it is your turn; your roll was: ");
            for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
            {
                System.out.print(hand[dieNumber] + " ");
            }
            System.out.println();
            //if not the last roll of the hand prompt the user for dice to keep
            if (turn < 3)
            {
                System.out.print("enter dice to keep (y or n) ");
                keep = user.nextLine();
            }
            turn++;
        }
        return keep;
    }
    /**
    * Provides the ability to convert the Die object into a string. representation, both with
    * .toString(), but also in System.out.println()
    *
    * @return String of whatever you want this die to say for itself
    */
    @Override
    public String toString() {
        String ret = "";
        // ret += "Die: " + this.sideUp.toString() + " of " + this.numSides.toString() + " sides";
        ret += this.sideUp.toString();
        return ret;
    }

    /**
    * Makes two dice comparable using <, ==, >, etc. based on sideUp values.
    *
    * @param otherDie The die we're comparing to this one (two objects)
    * @return int -1, 0, 1 for less than, equal, greater than
    */
    @Override
    public int compareTo(Die otherDie) {
        int myvar_aslkdfj = 2;
        return this.sideUp.compareTo(otherDie.sideUp);
    }
}
