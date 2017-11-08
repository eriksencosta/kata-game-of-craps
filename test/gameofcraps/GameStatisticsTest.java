package gameofcraps;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class GameStatisticsTest {

    private static final int GAMES_WON = 10;
    private static final int GAMES_LOST = 20;
    private static final int GAMES_PLAYED = 30;
    private static final int TOTAL_ROLLS = 60;
    private static final double TOLERANCE = 1e-1;
    private static final int LENGTH_OF_LONGEST_GAME = 5;
    private static final int NUMBER_OF_WINS_ON_COMING_OUT_ROLL = 5;
    private static final int NUMBER_OF_LOSSES_ON_COMING_OUT_ROLL = 2;

    private GameStatistics gameStatistics = new GameStatistics(GAMES_WON, GAMES_LOST, LENGTH_OF_LONGEST_GAME, TOTAL_ROLLS, NUMBER_OF_WINS_ON_COMING_OUT_ROLL, NUMBER_OF_LOSSES_ON_COMING_OUT_ROLL);

    @Test
    public void calculateNumberOfWins() {
        assertThat(gameStatistics.numberOfWins, equalTo(GAMES_WON));
    }

    @Test
    public void calculateNumberOfLoses() {
        assertThat(gameStatistics.numberOfLosses, equalTo(GAMES_LOST));
    }

    @Test
    public void calculateNumberOfGames() {
        assertThat(gameStatistics.numberOfGames, equalTo(GAMES_PLAYED));
    }

    @Test
    public void calculateLengthOfLongestGame() {
        assertThat(gameStatistics.lengthOfLongestGame, equalTo(5));
    }

    @Test
    public void calculateWinningProbability() {
        assertThat(gameStatistics.winningProbability, closeTo(0.3, TOLERANCE));
    }

    @Test
    public void calculateNumberOfTotalRolls() {
        assertThat(gameStatistics.numberOfTotalRolls, equalTo(TOTAL_ROLLS));
    }

    @Test
    public void calculateAverageNumRoll() {
        assertThat(gameStatistics.averageNumberOfRolls, equalTo(2.0));
    }

    @Test
    public void calculateNumWinsOnComingOutRoll() {
        assertThat(gameStatistics.numberOfWinsOnComingOutRoll, equalTo(5));
    }

    @Test
    public void calculateWinningOnComingPutRollProbability() {
        assertThat(gameStatistics.winningOnComingPutRollProbability, closeTo(0.16, TOLERANCE));
    }

    @Test
    public void calculateNumLosesOnComingOutRoll() {
        assertThat(gameStatistics.numberOfLosesOnComingOutRoll, equalTo(2));
    }

    @Test
    public void calculateLosingOnComingPutRollProbability() {
        assertThat(gameStatistics.losingOnComingPutRollProbability, closeTo(0.06, TOLERANCE));
    }

    private void assertGameStatisticsException(int numWins, int numLoses, String expectedErrorMessage) {
        try {
            new GameStatistics(numWins, numLoses, 0, 0, 0, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), equalTo(expectedErrorMessage));
        }
    }

    @Test
    public void throwsExceptionWhenNumberOfWinsIsZero() {
        assertGameStatisticsException(0, 1, GameStatistics.NUMBER_WINS_NOT_ZERO);
    }

    @Test
    public void throwsExceptionWhenNumberOfWinsLessThenZero() {
        assertGameStatisticsException(-1, 1, GameStatistics.NUMBER_WINS_NOT_NEGATIVE);
    }

    @Test
    public void throwsExceptionWhenNumberOfLossesIsZero() {
        assertGameStatisticsException(1, 0, GameStatistics.NUMBER_LOSES_NOT_ZERO);
    }

    @Test
    public void throwsExceptionWhenNumberOfLosesLessThenZero() {
        assertGameStatisticsException(1, -1, GameStatistics.NUMBER_LOSES_NOT_NEGATIVE);
    }
}

