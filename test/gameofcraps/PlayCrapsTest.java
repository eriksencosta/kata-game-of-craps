package gameofcraps;

import org.junit.Test;

public class PlayCrapsTest {
    @Test
    public void playingCrapsGeneratesGameStatistics() {
        // Arrange
        final int numGames = 1;
        PlayCraps playing = new PlayCraps();

        // Act
        GameStatistics statistics = playing.play(numGames);

        // Assert

    }
}