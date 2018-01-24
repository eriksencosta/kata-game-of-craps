package gameofcraps;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DiceTest {

    @Test
    public void rangeBetweenOneAndSix() {
        Dice dice = new Dice();

        for(int i = 0; i < 100; i++){
            dice.roll();
            assertThat(dice.getSumOfFaces(), allOf(greaterThan(1), lessThan(13)));
        }

    }

}
