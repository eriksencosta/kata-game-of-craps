package gameofcraps;

import org.junit.Test;
import static org.junit.Assert.*;


public class CrapsGameTest {

    @Test
    public void winsIfComingOutRollIsSeven() {
        CrapsGame game = new CrapsGame(new DeterministicDice((7)));

        game.play();

        assertTrue(game.getWin());
    }

    @Test
    public void winsIfComingOutRollIsEleven() {
        CrapsGame game = new CrapsGame(new DeterministicDice((11)));

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
    public void lossesIfComingOutRollIsTwo() {
        CrapsGame game = new CrapsGame(new DeterministicDice((2)));

        game.play();

        assertFalse(game.getWin());
    }

    @Test
    public void lossesIfComingOutRollIsThree() {
        CrapsGame game = new CrapsGame(new DeterministicDice((3)));

        game.play();

        assertFalse(game.getWin());
    }

    @Test
    public void lossesIfComingOutRollIsTwelve() {
        CrapsGame game = new CrapsGame(new DeterministicDice((12)));

        game.play();

        assertFalse(game.getWin());
    }


}
