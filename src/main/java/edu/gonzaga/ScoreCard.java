/* (C)2021 */
package edu.gonzaga;

/*
* Class for a the score of a game used in Yahtzee.
*/

import java.util.Random;
import java.util.Scanner;

/** Class to store the scores of a the dies each round. */
public class ScoreCard {
    private String[] keep = new String[16];
    private String[] actual = new String[16];
    private Integer DICE_IN_PLAY;//is the number of dice the game is using
    private Integer line1; // 1 line
    private Integer line2; // 2 line
    private Integer line3; // 3 line
    private Integer line4; // 4 line
    private Integer line5; // 5 line
    private Integer line6; // 6 line
    private Integer line1Save; // 1 line save from loop
    private Integer line2Save; // 2 line save from loop
    private Integer line3Save; // 3 line save from loop
    private Integer line4Save; // 4 line save from loop
    private Integer line5Save; // 5 line save from loop
    private Integer line6Save; // 6 line save from loop
    private Integer upperBonus; // upper bonus
    private Integer kline3; // 3 of a kind line
    private Integer kline4; // 4 of a kind line
    private Integer fhline; // full house line
    private Integer smsline; // small straight line
    private Integer lgsline; // large straight line
    private Integer yline; // yahtzee line
    private Integer cline; // chance line
    private Integer totalScore; // total score
    private Boolean slotUsed; // Checks whether the user has selected a slot

    
    
    public ScoreCard()
    {
        DICE_IN_PLAY = 5;
        line1 = 0; 
        line2 = 0;
        line3 = 0; 
        line4 = 0;
        line5 = 0; 
        line6 = 0; 
        line1Save = 0; 
        line2Save = 0; 
        line3Save = 0; 
        line4Save = 0; 
        line5Save = 0; 
        line6Save = 0; 
        upperBonus = 0; 
        kline3 = 0; 
        kline4 = 0; 
        fhline = 0; 
        smsline = 0;
        lgsline = 0; 
        yline = 0; 
        cline = 0; 
        totalScore = 0; 
        slotUsed = false; 
        for(int i = 0; i < 16; i++)
        {
            keep[i] = String.valueOf(0);
            actual[i] = String.valueOf(0);
        }
    }

    /**
     * this function returns total score
     * @return totalScore integer
     */
    public Integer returnTotal()
    {
        return totalScore;
    }

    /**
     * This Java function takes an array of integers, sorts it, and returns a string with the sorted
     * values.
     * 
     * @param hand an array of Integers representing a hand of dice
     * @return The method is returning a String that contains the sorted hand of dice.
     */
    public String printSortedArray(Integer[] hand)
    {
        String out = "";
        sortArray(hand, DICE_IN_PLAY);
        out = out +"Here is your sorted hand : ";
        for (Integer dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
            {
                out = out +hand[dieNumber] + " ";
            }
        return out;
    }

    /**
     * print the total score for every slot on the scorecard
     * 
     * @param hand is the array of dice that gets inputted
     * DICE_IN_PLAY is the number of dice the game is using
     * dieNumber is for every die
     * currentCount is the count of the number of die with a certain value
     */
    public String printTotalScore(Integer[] hand)
    { 
        String out = "";

        //upper scorecard
        if((line1 == 0))
            System.out.println("Score 0 on the 1 line");
        else
            System.out.println("Score " + line1 + " on the 1 line (closed)");

        if((line2 == 0))
            System.out.println("Score 0 on the 2 line");
        else
            System.out.println("Score " + line2 + " on the 2 line (closed)");

        if((line3 == 0))
            System.out.println("Score 0 on the 3 line");
        else
            System.out.println("Score " + line3 + " on the 3 line (closed)");

        if((line4 == 0))
            System.out.println("Score 0 on the 4 line");
        else
            System.out.println("Score " + line4 + " on the 4 line (closed)");
        
        if((line5 == 0))
            System.out.println("Score 0 on the 5 line");
        else
            System.out.println("Score " + line5 + " on the 5 line (closed)");

        if((line6 == 0))
            System.out.println("Score 0 on the 6 line");
        else
            System.out.println("Score " + line6 + " on the 6 line (closed)");
        
        if((line1 + line2 + line3 + line4 + line5 + line6) >= 63 )
            System.out.println("Upper scoreboard over 63 Score " + upperBonus + " on the Upper Bonus line");
        //lower scorecard
        if(!(kline3 == 0))
            System.out.println("Score " + kline3 + " on the 3 of a Kind line (closed)");
        else
        {
            System.out.println("Score 0 on the 3 of a Kind line");
        }
            

        if(!(kline4 == 0))
            System.out.println("Score " + kline4 + " on the 4 of a Kind line (closed)");
        else 
        {
            System.out.println("Score 0 on the 4 of a Kind line");
        }

       if(!(fhline == 0))
            System.out.println("Score 25 on the Full House line (closed)"); 
        else
        {
            System.out.println("Score 0 on the Full House line");
        }  

        if(!(smsline == 0))
            System.out.println("Score 30 on the Small Straight line (closed)"); 
        else
        {
            System.out.println("Score 0 on the Small Straight line");
        }
            
        if(!(lgsline == 0))
            System.out.println("Score 40 on the Large Straight line (closed)");  
        else
        {
            System.out.println("Score 0 on the Large Straight line");
        } 

        if(!(yline == 0))
            System.out.println("Score 50 on the Yahtzee line (closed)");
        else
        {
            System.out.println("Score 0 on the Yahtzee line");
        }

        if(cline == 0)
            System.out.println("Score 0 on the Chance line");
        else
            System.out.println("Score " + cline + " on the Chance line (closed)");

        totalScore = line1 + line2 + line3 + line4 + line5 + line6 + kline3 + kline4 + fhline + smsline + lgsline + yline + cline + upperBonus;
        System.out.println("Current total score: " + totalScore);
        return out;
    }

    /**
     * This Java function changes the value of an element in an array based on the input parameters.
     * 
     * @param initial A string that indicates which array to modify. It can be either "a" or "p".
     * @param index The index parameter is an Integer that represents the index of the element in the
     * array that needs to be changed.
     * @param value The value parameter is a String that represents the new value that will be assigned
     * to an element in the actual or keep array, depending on the value of the initial parameter and
     * the index parameter.
     */
    public void changeArray(String initial, Integer index, String value)
    {
        if(initial.equals("a"))
        {
            actual[index] = value;
        }
        else if(initial.equals("p"))
        {
            keep[index] = value;
        }
    }

    /**
     * The function returns a value from either the "actual" or "keep" array based on the input initial
     * and index parameters.
     * 
     * @param initial A string that specifies whether to retrieve a value from the "actual" array or
     * the "keep" array. It can have a value of "a" or "p".
     * @param index The index parameter is an Integer representing the index position of the element in
     * the array that needs to be retrieved.
     * @return The method is returning a String value. The specific String value being returned depends
     * on the input parameters. If the initial parameter is "a", the method returns the value at the
     * index position in the actual array. If the initial parameter is "p", the method returns the
     * value at the index position in the keep array. If the initial parameter is neither "a" nor "p",
     * the method returns
     */
    public String getArrayVal(String initial, Integer index)
    {
        if(initial.equals("a"))
        {
            return actual[index];
        }
        else if(initial.equals("p"))
        {
            return keep[index];
        }
        return "";
    }
    

    /**
     * This function stores the scores of a Yahtzee game in an array based on the dice values rolled.
     * 
     * @param hand an array of integers representing the values of dice in play
     */
    public void storeCard(Integer[] hand)
    {
        sortArray(hand, DICE_IN_PLAY);

        //upper scorecard
        for (Integer dieValue = 1; dieValue <= 6; dieValue++)
        {
            Integer currentCount = 0;
            for (Integer diePosition = 0; diePosition < DICE_IN_PLAY; diePosition++)
            {
                if (hand[diePosition] == dieValue)
                    currentCount++;
            }
            if((dieValue == 1))
            {
                if((Integer.parseInt(actual[0]) == 0))
                {
                    
                    line1Save = dieValue * currentCount; 
                    keep[0] = String.valueOf(line1Save);
                    actual[0] = String.valueOf(0);
                }
                else
                {
                    keep[0] = actual[0];
                }
            }
            else if((dieValue == 2))
            {
                if((Integer.parseInt(actual[1]) == 0))
                {
                    line2Save = dieValue * currentCount;
                    keep[1] = String.valueOf(line2Save);
                    actual[1] = String.valueOf(0);
                }
                else
                {
                    keep[1] = actual[1];
                }
            }
            else if((dieValue == 3))
            {
                if((Integer.parseInt(actual[2]) == 0))
                {
                    line3Save = dieValue * currentCount;
                    keep[2] = String.valueOf(line3Save);
                    actual[2] = String.valueOf(0);
                }
                else
                {
                    keep[2] = actual[2];
                }
            }
            if((dieValue == 4))
            {
                if((Integer.parseInt(actual[3]) == 0))
                {
                    line4Save = dieValue * currentCount;
                    keep[3] = String.valueOf(line4Save);
                    actual[3] = String.valueOf(0);
                }
                else
                {
                    keep[3] = actual[3];
                }
            }
            if((dieValue == 5))
            {
                if((Integer.parseInt(actual[4]) == 0))
                {
                    line5Save = dieValue * currentCount;
                    keep[4] = String.valueOf(line5Save);
                    actual[4] = String.valueOf(0);
                }
                else
                {
                    keep[4] = actual[4];
                }
            }
            if((dieValue == 6))
            {
                if((Integer.parseInt(actual[5]) == 0))
                {
                    line6Save = dieValue * currentCount;
                    keep[5] = String.valueOf(line6Save);
                    actual[5] = String.valueOf(0);
                }
                else
                {
                    keep[5] = actual[5];
                }
            }
        }
        if((Integer.parseInt(actual[0]) + Integer.parseInt(actual[1]) + Integer.parseInt(actual[2]) + Integer.parseInt(actual[3]) + Integer.parseInt(actual[4]) + Integer.parseInt(actual[5])) >= 63 )
        {
            upperBonus = 35;
            keep[6] = String.valueOf(Integer.parseInt(actual[0]) + Integer.parseInt(actual[1]) + Integer.parseInt(actual[2]) + Integer.parseInt(actual[3]) + Integer.parseInt(actual[4]) + Integer.parseInt(actual[5]));
            actual[6] = String.valueOf(Integer.parseInt(actual[0]) + Integer.parseInt(actual[1]) + Integer.parseInt(actual[2]) + Integer.parseInt(actual[3]) + Integer.parseInt(actual[4]) + Integer.parseInt(actual[5]));
            keep[7] = String.valueOf(upperBonus);
            actual[7] = String.valueOf(upperBonus);
        }
        else
        {
            upperBonus = 0;
            keep[6] = String.valueOf(Integer.parseInt(actual[0]) + Integer.parseInt(actual[1]) + Integer.parseInt(actual[2]) + Integer.parseInt(actual[3]) + Integer.parseInt(actual[4]) + Integer.parseInt(actual[5]));
            actual[6] = String.valueOf(0);
            keep[7] = String.valueOf(upperBonus);
            actual[7] = String.valueOf(0);
        }
        //lower scorecard
        if (maxOfAKindFound(hand) >= 3 && (Integer.parseInt(actual[8]) == 0))
        {
            keep[8] = String.valueOf(totalAllDice(hand));
            actual[8] = String.valueOf(0);
        }
        else if(maxOfAKindFound(hand) >= 3 && !(Integer.parseInt(actual[8]) == 0))
        {
            keep[8] = actual[8];
        }
        else
        {
            keep[8] = String.valueOf(0);
        }
            

        if (maxOfAKindFound(hand) >= 4 && (Integer.parseInt(actual[9]) == 0))
        {
            keep[9] = String.valueOf(totalAllDice(hand));
            actual[9] = String.valueOf(0);
        }
        else if(maxOfAKindFound(hand) >= 4 && !(Integer.parseInt(actual[9]) == 0))
        {
            keep[9] = actual[9];
        }
        else 
        {
            keep[9] = String.valueOf(0);
        }

        if (fullHouseFound(hand) && (Integer.parseInt(actual[10]) == 0))
        {
            keep[10] = String.valueOf(25);
            actual[10] = String.valueOf(0);
        }  
        else if(fullHouseFound(hand) && !(Integer.parseInt(actual[10]) == 0))
        {
            keep[10] = actual[10];
        }
        else
        {
            keep[10] = String.valueOf(0);
        }  

        if (maxStraightFound(hand) >= 4 && (Integer.parseInt(actual[11]) == 0))
        {
            keep[11] = String.valueOf(30);
            actual[11] = String.valueOf(0);
        } 
        else if(maxStraightFound(hand) >= 4 && !(Integer.parseInt(actual[11]) == 0))
        {
            keep[11] = actual[11];
        }
        else
        {
            keep[11] = String.valueOf(0);
        }
            
        if (maxStraightFound(hand) >= 5 && (Integer.parseInt(actual[12]) == 0))
        {
            keep[12] = String.valueOf(40);
            actual[12] = String.valueOf(0);
        } 
        else if(maxStraightFound(hand) >= 5 && !(Integer.parseInt(actual[12]) == 0))
        {
            keep[12] = actual[12];
        } 
        else
        {
            keep[12] = String.valueOf(0);
        }   
        if (maxOfAKindFound(hand) >= 5 && (Integer.parseInt(actual[13]) == 0))
        {
            keep[13] = String.valueOf(50);
            actual[13] = String.valueOf(0);
        }
        else if(maxOfAKindFound(hand) >=5 && !(Integer.parseInt(actual[13]) == 0))
        {
            keep[13] = actual[13];
        }
        else
        {
            keep[13] = String.valueOf(0);
        }

        if((Integer.parseInt(actual[14]) == 0))
        {
            keep[14] = String.valueOf(totalAllDice(hand));
            actual[14] = String.valueOf(0);
        }
        else
        {
            keep[14] = actual[14];
        }
        totalScore = Integer.parseInt(actual[0]) + Integer.parseInt(actual[1]) + Integer.parseInt(actual[2]) + Integer.parseInt(actual[3]) + Integer.parseInt(actual[4]) + Integer.parseInt(actual[5]) + Integer.parseInt(actual[7]) + Integer.parseInt(actual[8]) + Integer.parseInt(actual[9]) + Integer.parseInt(actual[10]) + Integer.parseInt(actual[11]) + Integer.parseInt(actual[12]) + Integer.parseInt(actual[13]) + Integer.parseInt(actual[14]);
        keep[15] = String.valueOf(totalScore);
        actual[15] = String.valueOf(totalScore);

    }

    
    /**
     * calculates the number of a kind there is
     * 
     * @param hand is the array of dice that gets inputted
     * @return maxCount of a single number found in hand
     */
    private Integer maxOfAKindFound(Integer hand[])
    {
        Integer  maxCount = 0;
        Integer  currentCount ;
        for (Integer  dieValue = 1; dieValue <=6; dieValue++)
        {
            currentCount = 0;
            for (Integer  diePosition = 0; diePosition < 5; diePosition++)
            {
                if (hand[diePosition] == dieValue)
                    currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }

    /**
     * this function returns the total value of all dice in a hand
     * 
     * @param hand is the array of dice that gets inputted
     * @return total of all the dice
     */
    private Integer totalAllDice(Integer  hand[])
    {
        Integer  total = 0;
        for (Integer  diePosition = 0; diePosition < 5; diePosition++)
        {
            total += hand[diePosition];
        }
        return total;
    }

    /**
     * sorts the given array with bubble sort
     * 
     * @param array is the array of dice that gets inputted
     * @param size gives the size of the array
     * @return void
     */
    private void sortArray(Integer  array[], Integer  size)
    {
    boolean swap;
    Integer  temp;

    do
    {
        swap = false;
        for (Integer  count = 0; count < (size - 1); count++)
        {
            if (array[count] > array[count + 1])
            {
                temp = array[count];
                array[count] = array[count + 1];
                array[count + 1] = temp;
                swap = true;
            }
        }
    } while (swap);
    }

    /**
     * this function returns the length of the longest straight found in a hand
     * 
     * @param hand is the array of dice that gets inputted
     * @return length of the longest straight in hand
     */
    private Integer maxStraightFound(Integer  hand[])
    {
        Integer  maxLength = 1;
        Integer  curLength = 1;
        for(Integer counter = 0; counter < 4; counter++)
        {
            if (hand[counter] + 1 == hand[counter + 1] ) //jump of 1
                curLength++;
            else if (hand[counter] + 1 < hand[counter + 1]) //jump of >= 2
                curLength = 1;
            if (curLength > maxLength)
                maxLength = curLength;
        }
        return maxLength;
    }

    /**
     * this function returns true if the hand is a full house or false if it does not
     * 
     * @param hand is the array of dice that gets inputted
     * @return a bool of wether it is a full house
     */
    private boolean fullHouseFound(Integer  hand[])
    {
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        Integer  currentCount ;
        for (Integer  dieValue = 1; dieValue <=6; dieValue++)
        {
            currentCount = 0;
            for (Integer  diePosition = 0; diePosition < 5; diePosition++)
            {
                if (hand[diePosition] == dieValue)
                    currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
        }
        if (found2K && found3K)
            foundFH = true;
        return foundFH;
    }

    /**
     * this function returns the chance line 
     * 
     * @return chance line integer
     */
    public Integer returnChance()
    {
        return cline;
    }
    }
