package gameofcraps;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class CrapsGameLosingSequencesTest {


    @Parameterized.Parameters
    public static Collection<Object[]> listOfSequencedDices() {
        return Arrays.asList(
                new Object[][] {

                        { new SequencedDice(4, 7), 2 },
                        { new SequencedDice(4, 5, 6, 7), 4 },
                        { new SequencedDice(4, 5, 6, 8, 7), 5 },
                        { new SequencedDice(4, 5, 6, 8, 9, 7), 6 },
                        { new SequencedDice(4, 5, 6, 8, 9, 10, 7), 7 },
                        { new SequencedDice(10, 7), 2 },
                        { new SequencedDice(10, 9, 7), 3 },
                        { new SequencedDice(10, 9, 5, 7), 4 },
                        { new SequencedDice(10, 9, 5, 9, 7), 5 },
                        { new SequencedDice(5, 2, 7), 3 },
                        { new SequencedDice(5, 3, 7), 3 },
                        { new SequencedDice(5, 12, 7), 3 },
                        { new SequencedDice(4, 5, 6, 8, 9, 10, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9,
                                5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 7), 39 },
                }
        );
    }

    @Parameterized.Parameter(0)
    public Dice losingDice;

    @Parameterized.Parameter(1)
    public int expectedNumberOfRolls;


    @Test
    public void losesIfNthRollIsEqualsToSeven() {
        CrapsGame game = new CrapsGame(losingDice);

        game.play();

        assertFalse(game.getWin());
        assertEquals(game.getNumRolls(), expectedNumberOfRolls);
    }
}
