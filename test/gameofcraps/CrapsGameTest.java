package gameofcraps;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


/**
 * Created by wilson on 11/29/17.
 */
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
    public void loosesIfComingOutRollIsTwo(){
        CrapsGame game = new CrapsGame(new SequencedDice(2));

        game.play();

        assertTrue(!game.getWin());
    }

    @Test
    public void loosesIfComingOutRollIsThree(){
        CrapsGame game = new CrapsGame(new SequencedDice(3));

        game.play();

        assertTrue(!game.getWin());
    }

    public void loosesIfComingOutRollIsTwelve(){
        CrapsGame game = new CrapsGame(new SequencedDice(12));

        game.play();

        assertTrue(!game.getWin());
    }

    @Test
    public void winsIfNthRollIsEqualsToComingOutRoll() {
        CrapsGame game = new CrapsGame(new SequencedDice(4, 5, 4));

        game.play();

        assertTrue(game.getWin());
    }

    @Test
    public void loosesIfNthRollIsSevenBeforeIsEqualsToComingOutRoll() {
        CrapsGame game = new CrapsGame(new SequencedDice(4, 5, 7));

        game.play();

        assertTrue(!game.getWin());
    }
}
