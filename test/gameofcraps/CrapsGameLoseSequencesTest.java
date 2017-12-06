package gameofcraps;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CrapsGameLoseSequencesTest {

    @Parameterized.Parameters
    public static Collection<SequencedDice> data() {
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
                        9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 7));
    }

    @Parameterized.Parameter
    public SequencedDice sequenceDice;

    @Test
    public void RunSequenceLoseTests() {
        CrapsGame game = new CrapsGame(sequenceDice);
        game.play();
        assertTrue(!game.getWin());
    }

}
