package gameofcraps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class CrapsGamePlayTest {

    private Integer[] sequence;
    private boolean expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {

            // Wins.
            { new Integer[]{4, 4}, true },
            { new Integer[]{4, 5, 4}, true },
            { new Integer[]{10, 10}, true },
            { new Integer[]{10, 9, 10}, true },
            { new Integer[]{10, 9, 5, 10}, true },
            { new Integer[]{10, 9, 5, 9, 10}, true },
            { new Integer[]{4, 2, 4 }, true },
            { new Integer[]{4, 3, 4 }, true },
            { new Integer[]{4, 12, 4 }, true },
            { new Integer[]{4, 5, 6, 8, 9, 10, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9,
                    5, 6, 8, 9, 5, 6, 8, 9, 4}, true },


            // Loses.
            { new Integer[]{4, 7}, false },
            { new Integer[]{4, 5, 6, 7}, false },
            { new Integer[]{4, 5, 6, 8, 7}, false },
            { new Integer[]{4, 5, 6, 8, 9, 7}, false },
            { new Integer[]{4, 5, 6, 8, 9, 10, 7}, false },
            { new Integer[]{10, 7}, false },
            { new Integer[]{10, 9, 7}, false },
            { new Integer[]{10, 9, 5, 7}, false },
            { new Integer[]{10, 9, 5, 9, 7}, false },
            { new Integer[]{5, 2, 7}, false },
            { new Integer[]{5, 3, 7}, false },
            { new Integer[]{5, 12, 7}, false },
            { new Integer[]{4, 5, 6, 8, 9, 10, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9,
                    5, 6, 8, 9, 5, 6, 8, 9, 7}, false }

        });

    }

    public CrapsGamePlayTest(Integer[] sequence, boolean expected) {
        this.sequence = sequence;
        this.expected = expected;
    }

    @Test
    public void test() {
        CrapsGame game = new CrapsGame(new SequencedDice(this.sequence));

        game.play();

        assertEquals(game.getWin(), this.expected);
    }


}
