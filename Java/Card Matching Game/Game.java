import java.util.ArrayList;

/**
 * This class handles the game elements of the program
 * 
 * @author Priyesh Patel 
 * @version 26/03/2016
 */
public class Game
{
    private int pairs;
    private final int DEFAULT_PAIRS = 10;
    private final int DEFAULT_CARD_VALUE = -1;
    private ArrayList <Integer> cardNumbers;
    private int score;
    private int card1Value;
    private int card2Value;
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        cardNumbers = new ArrayList<Integer>();
        pairs = DEFAULT_PAIRS;
        score = 0;
        card1Value = DEFAULT_CARD_VALUE;
        card2Value = DEFAULT_CARD_VALUE;
        initializeCardNumbers();
    }

    /**
     * Populates the cardNumber arraylist with 2 of each number from 0 upto but not including the number
     * of pairs.
     * pre-condtion: pairs is greater than 0.
     */
    private void initializeCardNumbers()
    {
        if(pairs>0){
            for (int i=0; i<pairs; i++){
                cardNumbers.add(i);
                cardNumbers.add(i);
            }
        }
    }

    /**
     * returns the field cardNumbers.
     * @returns the field cardNumbers.
     */
    public ArrayList<Integer> getCardNumbers()
    {
        return cardNumbers;
    }

    /**
     * returns the field score.
     * @returns the field score.
     */
    public int getScore()
    {
        return score;
    }

    /**
     * returns true if score equals the number of pairs and flase if otherwise.
     * @returns true if score equals the number of pairs and flase if otherwise.
     */
    public boolean hasWon()
    {
        if(score == pairs){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Checks if card values are equal, if they are then score is increased and
     * card values are reset to the default then returns true.
     * if they don't equal then card values are reset and false is returned
     * @returns true if card values are equal and flase if otherwise.
     */
    public boolean attemptPairing()
    {
        if(card1Value==card2Value){
            score = score + 1;
            card1Value = DEFAULT_CARD_VALUE;
            card2Value = DEFAULT_CARD_VALUE;
            return true;
        }
        else{
            card1Value = DEFAULT_CARD_VALUE;
            card2Value = DEFAULT_CARD_VALUE;
            return false;
        }
    }

    /**
     * Assigns values to card1value and card2value to make sure they are ready
     * to check for pairing, returns true if assigned to card1value and flase
     * if assigned to card2value.
     * @param value the number that is to be assigned to the suitable card value field.
     * @returns returns true if assigned to card1value and flase if assigned to card2value.
     */
    public boolean prepareToPair(int value)
    {
        if(card1Value == DEFAULT_CARD_VALUE && card2Value == DEFAULT_CARD_VALUE){
            card1Value = value;
            return true;
        }
        else if(card1Value != DEFAULT_CARD_VALUE && card2Value == DEFAULT_CARD_VALUE){
            card2Value = value;
        }
        return false;
    }

    /**
     * Checks that both card1Value and card2Value don't equal the default card value
     * hence have been assigned values and is ready to pair. returns true if ready and
     * false otherwise.
     * @returns true if ready to pair (both card values have been assigned) and false otherwise.
     */
    public boolean isReadyToPair()
    {
        if(card1Value != DEFAULT_CARD_VALUE && card2Value != DEFAULT_CARD_VALUE){
            return true;
        }
        else{
            return false;
        }
    }
}
