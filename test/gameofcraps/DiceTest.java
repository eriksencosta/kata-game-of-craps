package gameofcraps;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DiceTest {

    @Test
    public void diceRandomValidTest() {
        boolean diceValidSum = true;
        for (int i = 0; i < 50; i++) {
            Dice dice = new Dice();
            dice.roll();
            if (5 <= dice.getSumOfFaces() && 12 >= dice.getSumOfFaces()){
            }else{
                diceValidSum = false;
            }
            assertTrue(diceValidSum);
        }
    }
}
