/* (C)2021 */
package edu.gonzaga;

/*
* Class for a Hand used in Yahtzee.
*/

import java.util.Random;

/** Class to store the state of a all 6 die. */
public class Hand {
    private Integer[] inHand;
    
    public Hand(){
        for(int i = 0; i < 5; i++){
            inHand[i] = 0;
        }
    }

    /**
     * The function sets a specific index of an array to a given integer value.
     * 
     * @param index The index parameter is an integer that represents the position of the element in
     * the array that we want to set the value for. It starts from 0 for the first element and goes up
     * to the length of the array minus one for the last element.
     * @param num The parameter "num" is an integer value that represents the number of cards in a
     * player's hand.
     */
    public void setInHand(int index, int num){
        inHand[index] = num;
    }

    /**
     * This Java function prints the value of an element in an array at a specified index.
     * 
     * @param index index is an integer parameter that represents the index of an element in an array
     * called "inHand". The method "printHandIndex" takes this index as input and prints the value of
     * the element at that index along with its position in the array.
     */
    public void printHandIndex(int index){
        System.out.println("Die at " + index + " is " + inHand[index]);
    }
}
