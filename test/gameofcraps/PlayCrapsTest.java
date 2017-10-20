package gameofcraps;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class PlayCrapsTest {
    @Test
    public void playingCrapsGeneratesGameStatistics() {
        final int numGames = 1;
        PlayCraps playing = new PlayCraps();

        GameStatistics statistics = playing.play(numGames);
    }



}