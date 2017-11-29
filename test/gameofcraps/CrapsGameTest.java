package gameofcraps;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class CrapsGameTest {

    @Test
    public void winsIfComingOutRollIsSeven() {
        CrapsGame game = new CrapsGame(new SequencedDice((7)));

        game.play();

        assertTrue(game.getWin());
    }

    @Test
    public void winsIfComingOutRollIsEleven() {
        CrapsGame game = new CrapsGame(new SequencedDice((11)));

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
        CrapsGame game = new CrapsGame(new SequencedDice((2)));

        game.play();

        assertTrue(game.getLose());
    }

    @Test
    public void lossesIfComingOutRollIsThree() {
        CrapsGame game = new CrapsGame(new SequencedDice((3)));

        game.play();

        assertTrue(game.getLose());
    }

    @Test
    public void lossesIfComingOutRollIsTwelve() {
        CrapsGame game = new CrapsGame(new SequencedDice((12)));

        game.play();

        assertTrue(game.getLose());
    }


}
