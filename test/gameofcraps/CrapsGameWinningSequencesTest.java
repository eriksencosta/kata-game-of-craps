package gameofcraps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class CrapsGameWinningSequencesTest {

    private Dice sequence;
    private int nummberOfRolls;

    @Parameterized.Parameters

    public static Collection<Object[]> winningSequencedDices() {
        return Arrays.asList(new Object[][]{
                {new SequencedDice(4, 4), 2},
                {new SequencedDice(4, 5, 4), 3},
                {new SequencedDice(4, 5, 6, 4), 4},
                {new SequencedDice(10, 10), 2},
                {new SequencedDice(10, 9, 10), 3},
                {new SequencedDice(10, 9, 5, 10), 4},
                {new SequencedDice(10, 9, 5, 9, 10), 5},
                {new SequencedDice(4, 2, 4), 3},
                {new SequencedDice(4, 3, 4), 3},
                {new SequencedDice(4, 12, 4), 3},
                {new SequencedDice(4, 5, 6, 8, 9, 10, 5, 6, 8, 9, 5, 6, 8,
                        9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 4), 39}
        });
    }

    public CrapsGameWinningSequencesTest(Dice sequence, int numberOfRolls) {
        this.sequence = sequence;
        this.nummberOfRolls = numberOfRolls;
    }

    @Test
    public void winsIfNthRollIsEqualsToComingOutRoll() {
        CrapsGame game = new CrapsGame(this.sequence);

        game.play();

        assertTrue(game.getWin());
        assertEquals(game.getNumberOfRolls(), this.nummberOfRolls);
    }

}
