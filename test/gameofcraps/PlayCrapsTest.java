package gameofcraps;

import org.junit.Test;

public class PlayCrapsTest {
    @Test
    public void playingCrapsGeneratesGameStatistics() {
        final String[] numGames = {"1000"};
        PlayCraps.main(numGames);
    }
}