package nz.otot.UrPhase1.model;

/**
 * Created by Main on 30-Jan-18.
 * Rolls the dice to determine how far the player can move.
 * In the real game the dice are tetrahedrons with two corners marked.
 * This gives them a 50-50 chance of rolling 0 or 1.
 * Four dice are rolled giving a value between 0 and 4.
 * This is equivalent to 4d2 - 4  in gaming terms.
 */
public class Dice {
    public static int roll(){
        int sum = 0;
        int nDice = 4;
        for (int i = 0; i < nDice; i++){
            if(Math.random() >= 0.5) sum++;
        }
        return sum;
    }
}
