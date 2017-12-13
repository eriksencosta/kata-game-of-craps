package gameofcraps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class CrapsGameWinningSequencesTest {

    private Dice sequence;

    @Parameterized.Parameters

    public static Collection<SequencedDice> winningSequencedDices() {
        return Arrays.asList(
                new SequencedDice(4, 4),
                new SequencedDice(4, 5, 4),
                new SequencedDice(4, 5, 6, 4),
                new SequencedDice(10, 10),
                new SequencedDice(10, 9, 10),
                new SequencedDice(10, 9, 5, 10),
                new SequencedDice(10, 9, 5, 9, 10),
                new SequencedDice(4, 2, 4),
                new SequencedDice(4, 3, 4),
                new SequencedDice(4, 12, 4),
                new SequencedDice(4, 5, 6, 8, 9, 10, 5, 6, 8, 9, 5, 6, 8,
                        9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 4)
        );
    }

    public CrapsGameWinningSequencesTest(Dice sequence) {
        this.sequence = sequence;
    }

    @Test
    public void winsIfNthRollIsEqualsToComingOutRoll() {
        CrapsGame game = new CrapsGame(this.sequence);

        game.play();

        assertTrue(game.getWin());
    }

}
