package gameofcraps;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class DiceTest {

    @Test
    public void sumOfFacesIsWithinValidRange() {
        Dice dice = new Dice();

        for (int i = 0; i < 100; i++) {
            dice.roll();
            int roll = dice.sumOfFaces();
            assertThat(roll, allOf(greaterThanOrEqualTo(2), lessThanOrEqualTo(12)));
        }


    }
}
