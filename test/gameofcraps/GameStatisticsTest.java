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
    public void throwsExceptionWhenNumberOfWinsAndLossesIsZeroSimultaneously() {
        assertGameStatisticsException(0, 0, 0, 0, 5, GameStatistics.LOSES_AND_WINS_NOT_ZERO_SIMULTANEOUSLY);
    }

    @Test
    public void throwsExceptionWhenNumberOfWinsLessThenZero() {
        assertGameStatisticsException(-1, 1, 0, 0, 5, GameStatistics.NUMBER_WINS_NOT_NEGATIVE);
    }

    @Test
    public void throwsExceptionWhenNumberOfWinsInconmingOutRollMinorThanWins() {
        assertGameStatisticsException(1, 1, 2, 3, 5, GameStatistics.NUMBER_OF_WINS_INCOMING_OUT_ROLL_GREATER_THAN_WINS);
    }

    @Test
    public void throwsExceptionWhenNumberOfLossesInconmingOutRollMinorThanLosses() {
        assertGameStatisticsException(1, 1, 0, 3, 5, GameStatistics.NUMBER_OF_LOSSES_INCOMING_OUT_ROLL_GREATER_THAN_LOSSES);
    }

    @Test
    public void throwsExceptionWhenNumberOfLosesLessThanZero() {
        assertGameStatisticsException(1, -1, 0, 0, 5, GameStatistics.NUMBER_LOSES_NOT_NEGATIVE);
    }

    @Test
    public void throwsExceptionWhenLengthOfLongestGameLessThanOne() {
        assertGameStatisticsException(1, 1, 0, 0, 0, GameStatistics.NUMBER_OF_LENGHT_OF_LONGEST_GAME_MINOR_THAN_ONE);
    }
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

    private void assertGameStatisticsException(int numWins, int numLoses, int numberOfWinsOnComingOutRoll,
                                               int numberOfLosesOnComingOutRoll, int lengthOfLongestGame, String expectedErrorMessage) {
        try {
            new GameStatistics(numWins, numLoses, lengthOfLongestGame, 0, numberOfWinsOnComingOutRoll, numberOfLosesOnComingOutRoll);
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), equalTo(expectedErrorMessage));
        }
    }


}

