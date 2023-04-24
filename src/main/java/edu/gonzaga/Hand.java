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

    public void setInHand(int index, int num){
        inHand[index] = num;
    }

    public void printHandIndex(int index){
        System.out.println("Die at " + index + " is " + inHand[index]);
    }
}
