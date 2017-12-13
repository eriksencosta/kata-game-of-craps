package gameofcraps;

import org.junit.Test;
import static org.junit.Assert.*;


public class CrapsGameTest {

    @Test
    public void winsIfComingOutRollIsSeven() {
        CrapsGame game = new CrapsGame(new DeterministicDice((7)));

        game.play();

        assertTrue(game.getWin());
        assertEquals(game.getNumRolls(), 1);
    }

    @Test
    public void winsIfComingOutRollIsEleven() {
        CrapsGame game = new CrapsGame(new DeterministicDice((11)));

        game.play();

        assertTrue(game.getWin());
        assertEquals(game.getNumRolls(), 1);
    }

    @Test
    public void lossesIfComingOutRollIsTwo() {
        CrapsGame game = new CrapsGame(new DeterministicDice((2)));

        game.play();

        assertFalse(game.getWin());
        assertEquals(game.getNumRolls(), 1);
    }

    @Test
    public void lossesIfComingOutRollIsThree() {
        CrapsGame game = new CrapsGame(new DeterministicDice((3)));

        game.play();

        assertFalse(game.getWin());
        assertEquals(game.getNumRolls(), 1);
    }

    @Test
    public void lossesIfComingOutRollIsTwelve() {
        CrapsGame game = new CrapsGame(new DeterministicDice((12)));

        game.play();

        assertFalse(game.getWin());
        assertEquals(game.getNumRolls(), 1);
    }

    @Test
    public void resetSetsWinsToFalseAndNumRollsToZero() {
        CrapsGame game = new CrapsGame(new DeterministicDice((7)));

        game.play();
        game.reset();

        assertFalse(game.getWin());
        assertEquals(game.getNumRolls(), 0);
    }

}
