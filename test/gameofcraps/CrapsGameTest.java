package gameofcraps;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CrapsGameTest {

    @Test
    public void winsIfComingOutRollIsSeven() {
        CrapsGame game = new CrapsGame(new SpecificDice(7));
        game.play();

        assertTrue(game.getWin());
    }

    @Test
    public void winsIfComingOutRollIsEleven() {
        CrapsGame game = new CrapsGame(new SpecificDice(11));
        game.play();

        assertTrue(game.getWin());
    }

    @Test
    public void loosesIfComingOutRollIsTwo() {
        CrapsGame game = new CrapsGame(new SpecificDice(2));
        game.play();

        assertTrue(!game.getWin());
    }

    @Test
    public void loosesIfComingOutRollIsThree() {
        CrapsGame game = new CrapsGame(new SpecificDice(3));
        game.play();

        assertTrue(!game.getWin());
    }

    @Test
    public void loosesIfComingOutRollIsTwelve() {
        CrapsGame game = new CrapsGame(new SpecificDice(12));
        game.play();

        assertTrue(!game.getWin());
    }

}
