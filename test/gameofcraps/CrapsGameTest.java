package gameofcraps;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CrapsGameTest {

    @Test
    public void winsIfComingOutRollIsSeven() {
        CrapsGame game = new CrapsGame(new SpecificDice(7));
        game.play();

        assertTrue(game.getWin());
        assertThat(game.getNumRolls(), equalTo(1));
    }

    @Test
    public void winsIfComingOutRollIsEleven() {
        CrapsGame game = new CrapsGame(new SpecificDice(11));
        game.play();

        assertTrue(game.getWin());
        assertThat(game.getNumRolls(), equalTo(1));
    }

    @Test
    public void loosesIfComingOutRollIsTwo() {
        CrapsGame game = new CrapsGame(new SpecificDice(2));
        game.play();

        assertTrue(!game.getWin());
        assertThat(game.getNumRolls(), equalTo(1));
    }

    @Test
    public void loosesIfComingOutRollIsThree() {
        CrapsGame game = new CrapsGame(new SpecificDice(3));
        game.play();

        assertTrue(!game.getWin());
        assertThat(game.getNumRolls(), equalTo(1));
    }

    @Test
    public void loosesIfComingOutRollIsTwelve() {
        CrapsGame game = new CrapsGame(new SpecificDice(12));
        game.play();

        assertTrue(!game.getWin());
        assertThat(game.getNumRolls(), equalTo(1));
    }

    @Test
    public void resetNumberOfRolls() {
        CrapsGame game = new CrapsGame(new SequencedDice(3, 4, 3, 9));
        game.play();
        game.reset();

        assertThat(game.getNumRolls(), equalTo(0));
    }

    @Test
    public void resetWinToDefault() {
        CrapsGame game = new CrapsGame(new SpecificDice(7));
        game.play();
        game.reset();

        assertTrue(!game.getWin());
    }

}
