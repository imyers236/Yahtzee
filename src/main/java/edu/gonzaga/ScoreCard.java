/* (C)2021 */
package edu.gonzaga;

/*
* Class for a the score of a game used in Yahtzee.
*/

import java.util.Random;
import java.util.Scanner;

/** Class to store the scores of a the dies each round. */
public class ScoreCard {
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
     * print the total score for every slot on the scorecard
     * 
     * @param hand is the array of dice that gets inputted
     * DICE_IN_PLAY is the number of dice the game is using
     * dieNumber is for every die
     * currentCount is the count of the number of die with a certain value
     */
    public String printTotalScore(Integer[] hand)
    { String out = "";
        sortArray(hand, DICE_IN_PLAY);
        out = out +"Here is your sorted hand : ";
        for (Integer dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
            {
                out = out +hand[dieNumber] + " ";
            }
            

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
     * prints the possible scores and total score for every slot on the scorecard
     * then asks the user to pick a slot to put their hand
     * 
     * @param hand is the array of dice that gets inputted
     * @param user takes in the user's input
     * DICE_IN_PLAY is the number of dice the game is using
     * dieNumber is for every die
     * currentCount is the count of the number of die with a certain value
     */
    public void storeCard(Integer[] hand, Scanner user)
    {
        String keep = "";
        sortArray(hand, DICE_IN_PLAY);
        System.out.print("Here is your sorted hand : ");
        for (Integer dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
            {
                System.out.print(hand[dieNumber] + " ");
            }
            System.out.println();
            

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
                if((line1 == 0))
                {
                    System.out.println("Score " + dieValue * currentCount + " on the " + dieValue + " line");
                    line1Save = dieValue * currentCount; 
                }
                else
                    System.out.println("Score " + line1 + " on the " + dieValue + " line (closed)");
            }
            else if((dieValue == 2))
            {
                if((line2 == 0))
                {
                    System.out.println("Score " + dieValue * currentCount + " on the " + dieValue + " line");
                    line2Save = dieValue * currentCount;
                }
                else
                    System.out.println("Score " + line2 + " on the " + dieValue + " line (closed)");
            }
            else if((dieValue == 3))
            {
                if((line3 == 0))
                {
                    System.out.println("Score " + dieValue * currentCount + " on the " + dieValue + " line");
                    line3Save = dieValue * currentCount;
                }
                else
                    System.out.println("Score " + line3 + " on the " + dieValue + " line (closed)");
            }
            if((dieValue == 4))
            {
                if((line4 == 0))
                {
                    System.out.println("Score " + dieValue * currentCount + " on the " + dieValue + " line");
                    line4Save = dieValue * currentCount;
                }
                else
                    System.out.println("Score " + line4 + " on the " + dieValue + " line (closed)");
            }
            if((dieValue == 5))
            {
                if((line5 == 0))
                {
                    System.out.println("Score " + dieValue * currentCount + " on the " + dieValue + " line");
                    line5Save = dieValue * currentCount;
                }
                else
                    System.out.println("Score " + line5 + " on the " + dieValue + " line (closed)");
            }
            if((dieValue == 6))
            {
                if((line6 == 0))
                {
                    System.out.println("Score " + dieValue * currentCount + " on the " + dieValue + " line");
                    line6Save = dieValue * currentCount;
                }
                else
                    System.out.println("Score " + line6 + " on the " + dieValue + " line (closed)");
            }
        }
        if((line1 + line2 + line3 + line4 + line5 + line6) >= 63 )
        {
            upperBonus = 35;
            System.out.println("Upper scoreboard over 63 Score " + upperBonus + " on the Upper Bonus line");
        }
        //lower scorecard
        if (maxOfAKindFound(hand) >= 3 && (kline3 == 0))
        {
            System.out.println("Score " + totalAllDice(hand) + " on the 3 of a Kind line");
        }
        else if(maxOfAKindFound(hand) >= 3 && !(kline3 == 0))
            System.out.println("Score " + kline3 + " on the 3 of a Kind line (closed)");
        else
        {
            System.out.println("Score 0 on the 3 of a Kind line");
        }
            

        if (maxOfAKindFound(hand) >= 4 && (kline4 == 0))
        {
            System.out.println("Score " + totalAllDice(hand) + " on the 4 of a Kind line");
        }
        else if(maxOfAKindFound(hand) >= 4 && !(kline4 == 0))
            System.out.println("Score " + kline4 + " on the 4 of a Kind line (closed)");
        else 
        {
            System.out.println("Score 0 on the 4 of a Kind line");
        }

        if (fullHouseFound(hand) && (fhline == 0))
        {
            System.out.println("Score 25 on the Full House line");
        }  
        else if(fullHouseFound(hand) && !(fhline == 0))
            System.out.println("Score 25 on the Full House line (closed)"); 
        else
        {
            System.out.println("Score 0 on the Full House line");
        }  

        if (maxStraightFound(hand) >= 4 && (smsline == 0))
        {
            System.out.println("Score 30 on the Small Straight line");
        } 
        else if(maxStraightFound(hand) >= 4 && !(smsline == 0))
            System.out.println("Score 30 on the Small Straight line (closed)"); 
        else
        {
            System.out.println("Score 0 on the Small Straight line");
        }
            
        if (maxStraightFound(hand) >= 5 && (lgsline == 0))
        {
            System.out.println("Score 40 on the Large Straight line");
        } 
        else if(maxStraightFound(hand) >= 5 && !(lgsline == 0))
            System.out.println("Score 40 on the Large Straight line (closed)");  
        else
        {
            System.out.println("Score 0 on the Large Straight line");
        }   
        if (maxOfAKindFound(hand) >= 5 && (yline == 0))
        {
            System.out.println("Score 50 on the Yahtzee line");
        }
        else if(maxOfAKindFound(hand) >=5 && !(yline == 0))
            System.out.println("Score 50 on the Yahtzee line (closed)");
        else
        {
            System.out.println("Score 0 on the Yahtzee line");
        }

        if(cline == 0)
            System.out.println("Score " + totalAllDice(hand) + " on the Chance line");
        else
            System.out.println("Score " + cline + " on the Chance line (closed)");
        totalScore = line1 + line2 + line3 + line4 + line5 + line6 + kline3 + kline4 + fhline + smsline + lgsline + yline + cline + upperBonus;
        System.out.println("Current total score: " + totalScore);
        System.out.println();
        // Saving score
        System.out.println("For One's type 1S");
        System.out.println("For Two's type 2S");
        System.out.println("For Three's type 3S");
        System.out.println("For Four's type 4S");
        System.out.println("For Five's type 5S");
        System.out.println("For Six's type 6S");
        System.out.println("For Three of a Kind type 3K");
        System.out.println("For Four of a Kind type 4K");
        System.out.println("For Full House type FH");
        System.out.println("For Small Straight type SS");
        System.out.println("For Large Straight type LS");
        System.out.println("For Yahtzee type YH");
        System.out.println("For Chance type CH");
        slotUsed = false;
        while(!slotUsed)
        {
            System.out.println("Please select enter what open slot to save your score: ");
            keep = user.nextLine();
            if(keep.equals("1S"))
            {
                if((line1 == 0))
                {
                    line1 = line1Save;
                    slotUsed = true;
                }
                else
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("2S"))
            {
                if((line2 == 0))
                {
                    line2 = line2Save;
                    slotUsed = true;
                }
                else 
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("3S"))
            {
                if((line3 == 0))
                {
                    line3 = line3Save;
                    slotUsed = true;
                }
                else 
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("4S"))
            {
                if((line4 == 0))
                {
                    line4 = line4Save;
                    slotUsed = true;
                }
                else 
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("5S"))
            {
                if((line5 == 0))
                {
                    line5 = line5Save;
                    slotUsed = true;
                }
                else 
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("6S"))
            {
                if((line6 == 0))
                {
                    line6 = line6Save;
                    slotUsed = true;
                }
                else 
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("3K"))
            {
                if((kline3 == 0))
                {
                    kline3 = totalAllDice(hand);
                    slotUsed = true;
                }
                else 
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("4K"))
            {
                if((kline4 == 0))
                {
                    kline4 = totalAllDice(hand);
                    slotUsed = true;
                }
                else 
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("FH"))
            {
                if((fhline == 0))
                {
                    fhline = 25;
                    slotUsed = true;
                }
                else 
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("SS"))
            {
                if((smsline == 0))
                {
                    smsline = 30;
                    slotUsed = true;
                }
                else 
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("LS"))
            {
                if((lgsline == 0))
                {
                    lgsline = 40;
                    slotUsed = true;
                }
                else 
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("YH"))
            {
                yline = 50;
                slotUsed = true;
            }
            else if(keep.equals("CH"))
            {
                if((cline == 0))
                {
                    cline = totalAllDice(hand);
                    slotUsed = true;
                }
                else 
                {
                    System.out.println("This slot has already been used");
                }
            }
            else if(keep.equals("q"))
                slotUsed = true;
        }
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
