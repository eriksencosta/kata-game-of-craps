package gameofcraps;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class PlayCrapsTest {
    @Test
    public void playingCrapsGeneratesGameStatistics() {
        final int numberOfGames = 1;
        PlayCraps playing = new PlayCraps();

        GameStatistics statistics = playing.play(numberOfGames);

        assertTrue(statistics != null);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void playingCannotStartWithNumberOfGamesLessThanOne() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("numberOfGames must be at least one");

        final int numberOfGames = -1;
        PlayCraps playing = new PlayCraps();

        playing.play(numberOfGames);
    }

}