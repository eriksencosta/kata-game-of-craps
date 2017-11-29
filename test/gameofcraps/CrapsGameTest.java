package gameofcraps;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class CrapsGameTest {

    @Test
    public void checkWinningInComingOutRoll() {
        // Mock dice class.
        Dice winningDice = mock(Dice.class);

        // Overwrite roll method.
        when(winningDice.roll()).thenReturn(7);

        // We win because we got 7.
        CrapsGame game = new CrapsGame(winningDice);
        game.play();

        assertTrue(game.getWin());
    }

}
