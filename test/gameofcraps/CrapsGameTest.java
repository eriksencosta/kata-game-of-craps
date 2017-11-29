package gameofcraps;

import org.junit.Test;
import static org.junit.Assert.*;

public class CrapsGameTest {

    @Test
    public void winsIfComingOutRollIsSeven() {
        CrapsGame game = new CrapsGame(new SequencedDice(7));

        game.play();

        assertTrue(game.getWin());
    }

    @Test
    public void winsIfComingOutRollIsEleven() {
        CrapsGame game = new CrapsGame(new SequencedDice(11));

        game.play();

        assertTrue(game.getWin());
    }

    @Test
    public void winsIfNthRollIsEqualsToComingOutRoll() {
        CrapsGame game = new CrapsGame(new SequencedDice(4, 5, 4));

        game.play();

        assertTrue(game.getWin());
    }

    @Test
    public void loseIfComingOutRollIsTwo() {
        CrapsGame game = new CrapsGame(new SequencedDice(2));

        game.play();

        assertFalse(game.getWin());
    }

    @Test
    public void loseIfComingOutRollIsThree() {
        CrapsGame game = new CrapsGame(new SequencedDice(3));

        game.play();

        assertFalse(game.getWin());
    }

    @Test
    public void loseIfComingOutRollIsTwelve() {
        CrapsGame game = new CrapsGame(new SequencedDice(12));

        game.play();

        assertFalse(game.getWin());
    }
}
