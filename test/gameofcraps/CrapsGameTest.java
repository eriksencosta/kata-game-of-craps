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

}
