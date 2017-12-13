package gameofcraps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;


@RunWith(Parameterized.class)
public class CrapsGameLosingSequencesTest {

    private Dice sequence;

    @Parameterized.Parameters

    public static Collection<SequencedDice> losingSequencedDices() {
        return Arrays.asList(
                new SequencedDice(4, 7),
                new SequencedDice(4, 5, 6, 7),
                new SequencedDice(4, 5, 6, 8, 7),
                new SequencedDice(4, 5, 6, 8, 9, 7),
                new SequencedDice(4, 5, 6, 8, 9, 10, 7),
                new SequencedDice(10, 7),
                new SequencedDice(10, 9, 7),
                new SequencedDice(10, 9, 5, 7),
                new SequencedDice(10, 9, 5, 9, 7),
                new SequencedDice(5, 2, 7),
                new SequencedDice(5, 3, 7),
                new SequencedDice(5, 12, 7),
                new SequencedDice(4, 5, 6, 8, 9, 10, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8,
                        9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 7)
        );
    }

    public CrapsGameLosingSequencesTest(Dice sequence) {
        this.sequence = sequence;
    }

    @Test
    public void lossesIfNthRollIsEqualsToComingOutRoll() {
        CrapsGame game = new CrapsGame(this.sequence);

        game.play();

        assertFalse(game.getWin());
    }


}
