package gameofcraps;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GameStatisticsTest {

    private static final int WINS = 3;
    private static final int LOSSES = 4;
    private static final int NUMBERS_OF_GAMES = WINS + LOSSES;
    private static final int TOTAL_ROLLS = 20;
    private static final int LONGEST_PLAY = 79;
    private static final int NUMBERS_WINS_COMING_ROLL = 1;
    private static final int NUMBERS_LOSSES_COMING_ROLL = 2;
    private static final int AVERAGE_ROLL = 15;
    private static final double TOLERANCE = 1e-4;
    private GameStatistics gameStatistics = new GameStatistics(WINS, LOSSES, TOTAL_ROLLS, LONGEST_PLAY,
            NUMBERS_WINS_COMING_ROLL, NUMBERS_LOSSES_COMING_ROLL, AVERAGE_ROLL);

    @Test
    public void throwsExceptionWhenWinsIsNegative() {
        try {
            new GameStatistics(-1, LOSSES, TOTAL_ROLLS, LONGEST_PLAY, NUMBERS_WINS_COMING_ROLL,
                    NUMBERS_LOSSES_COMING_ROLL, AVERAGE_ROLL);

            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative wins are not allowed", e.getMessage());
        }
    }

    @Test
    public void throwsExceptionWhenLossesIsNegative() {
        try {
            new GameStatistics(WINS, -1, TOTAL_ROLLS, LONGEST_PLAY, NUMBERS_WINS_COMING_ROLL,
                    NUMBERS_LOSSES_COMING_ROLL, AVERAGE_ROLL);

            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative losses are not allowed", e.getMessage());
        }
    }

    @Test
    public void throwsExceptionWhenNumberOfGamesIsZero() {
        try {
            new GameStatistics(0, 0, TOTAL_ROLLS, LONGEST_PLAY, NUMBERS_WINS_COMING_ROLL,
                    NUMBERS_LOSSES_COMING_ROLL, AVERAGE_ROLL);

            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("The sum of wins and losses must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void throwsExceptionWhenTotalRollsIsLesserThanOne() {
        try {
            new GameStatistics(WINS, LOSSES, -5, LONGEST_PLAY, NUMBERS_WINS_COMING_ROLL,
                    NUMBERS_LOSSES_COMING_ROLL, AVERAGE_ROLL);

            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("totalRolls must be greater than one", e.getMessage());
        }
    }

    @Test
    public void throwsExceptionWhenLongestPlayIsLesserThanOne() {
        try {
            new GameStatistics(WINS, LOSSES, TOTAL_ROLLS, -1, NUMBERS_WINS_COMING_ROLL,
                    NUMBERS_LOSSES_COMING_ROLL, AVERAGE_ROLL);

            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("longestPlay must be greater than one", e.getMessage());
        }
    }

    @Test
    public void throwsExceptionWhennumberOfWinsComingRollIsLesserThanOne() {
        try {
            new GameStatistics(WINS, LOSSES, TOTAL_ROLLS, LONGEST_PLAY, -1,
                    NUMBERS_LOSSES_COMING_ROLL, AVERAGE_ROLL);

            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numberOfWinsComingRoll are not allowed", e.getMessage());
        }
    }

    @Test
    public void throwsExceptionWhennumbersOfLossesFirstIsLesserThanOne() {
        try {
            new GameStatistics(WINS, LOSSES, TOTAL_ROLLS, LONGEST_PLAY, NUMBERS_WINS_COMING_ROLL,
                    -1, AVERAGE_ROLL);

            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numberOfLossesComingRoll are not allowed", e.getMessage());
        }
    }

    @Test
    public void throwsExceptionWhenAverageRollsIsLesserThanOne() {
        try {
            new GameStatistics(WINS, LOSSES, TOTAL_ROLLS, LONGEST_PLAY, NUMBERS_WINS_COMING_ROLL,
                    NUMBERS_LOSSES_COMING_ROLL, 0);
            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("averageRolls must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void createGameStatisticsResultsTotalNumberOfGames() {
        assertEquals(gameStatistics.numberOfGames, NUMBERS_OF_GAMES);
    }

    @Test
    public void createGameStatisticsResultsProbabilityOfWin() {
        assertEquals(gameStatistics.probabilityWin, 0.4285, TOLERANCE);
    }

    @Test
    public void createGameStatisticsResultsTotalRolls() {
        assertEquals(gameStatistics.totalRolls, TOTAL_ROLLS);
    }

    @Test
    public void createGameStatisticsResultsLongestGame() {
        assertEquals(gameStatistics.longestPlay, LONGEST_PLAY);
    }

    @Test
    public void createGameStatisticsResultsnNumberOfWinsComingRoll() {
        assertEquals(gameStatistics.numberOfWinsComingRoll, NUMBERS_WINS_COMING_ROLL);
    }

    @Test
    public void createGameStatisticsResultsNumberOfLossesComingRoll() {
        assertEquals(gameStatistics.numberOfLossesComingRoll, NUMBERS_LOSSES_COMING_ROLL);
    }

    @Test
    public void createGameStatisticsResultsProbabilityOfWinningAtFirstRoll() {
        assertEquals(gameStatistics.probabilityOfWinAtComingRoll, 0.1428, TOLERANCE);
    }

    @Test
    public void createGameStatisticsResultsProbabilityOfLosingAtFirstRoll() {
        assertEquals(gameStatistics.probabilityOfLosingAtComingRoll, 0.2857, TOLERANCE);
    }

    @Test
    public void createGameStatisticsResultsAverageNumberOfRollsPerGame() {
        assertEquals(gameStatistics.averageNumberOfRollsPerGame, 2.1428, TOLERANCE);
    }

}
