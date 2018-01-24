package gameofcraps;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class DiceTest {

    @Test
    public void validateRangeOfDicesSum() {
        for (int i = 0; i < 50; i++) {
            Dice dice = new Dice();
            dice.roll();
            int sumOfFaces = dice.getSumOfFaces();
            assertThat(sumOfFaces, allOf(greaterThanOrEqualTo(2),
                    lessThanOrEqualTo(12)));
        }
    }
}
