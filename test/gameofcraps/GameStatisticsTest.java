package gameofcraps;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by nayvir on 10/19/17.
 */
public class GameStatisticsTest {
    private static final int WINS = 3;
    private static final int LOSSES = 4;
    private static final int WINS_INVALID = -3;
    private static final int LOSSES_INVALID = -4;
    private static final int NUMBERS_GAMES = WINS + LOSSES;
    private static final int TOTAL_ROLLS = 20;
    private static final int LONGEST_PLAY = 79;
    private static final int NUMBERS_WINS_FIRST_ROLL = 1;
    private static final int NUMBERS_LOSSES_FIRST_ROLL = 0;
    private static final int AVERAGE_ROLL = 15;
    GameStatistics gameStatistics;

    @Before
    public  void setup() {
        gameStatistics = new GameStatistics(WINS, LOSSES, TOTAL_ROLLS, LONGEST_PLAY, NUMBERS_WINS_FIRST_ROLL, NUMBERS_LOSSES_FIRST_ROLL, AVERAGE_ROLL);
    }

    @Test
    public void createGameStatisticsResultsTotalNumberOfGames() {
        assertEquals(gameStatistics.numberOfGames, NUMBERS_GAMES);

    }

    @Test
    public void createGameStatisticsResultsProbabilityOfWin() {
        assertEquals(gameStatistics.probabilityWin, (WINS / NUMBERS_GAMES), 0);
    }

    @Test
    public void createGameStatisticsResultsTotalRolls(){
        assertEquals(gameStatistics.totalRolls, TOTAL_ROLLS);
    }

    @Test
    public void createGameStatisticsResultsLongestGame(){
        assertEquals(gameStatistics.longestPlay, LONGEST_PLAY);
    }

    @Test
    public void createGameStatisticsResultsNumberOfWinsFirst() {
        assertEquals(gameStatistics.numberOfWinsFirst, NUMBERS_WINS_FIRST_ROLL);
    }

    @Test
    public void createGameStatisticsResultsNumberOfLossesFirst() {
        assertEquals(gameStatistics.numberOfLossesFirst, NUMBERS_LOSSES_FIRST_ROLL);
    }

    @Test
    public void createGameStatisticsResultsProbabilityOfWinningAtFirstRoll() {
        assertEquals(gameStatistics.probabilityOfWinAtFirstRoll, NUMBERS_WINS_FIRST_ROLL / NUMBERS_GAMES, 0);
    }

    @Test
    public void createGameStatisticsResultsProbabilityOfLosingAtFirstRoll() {
        assertEquals(gameStatistics.probabilityOfLosingAtFirstRoll, NUMBERS_LOSSES_FIRST_ROLL / NUMBERS_GAMES, 0);
    }

    @Test
    public void createGameStatisticsResultsAverageNumberOfRollsPerGame() {
        assertEquals(gameStatistics.averageNumberOfRollsPerGame, AVERAGE_ROLL / NUMBERS_GAMES, 2.0 );
    }

    @Test
    public void throwsExceptionWhenWinsIsNegative() {
        try {
            new GameStatistics(-1, LOSSES, TOTAL_ROLLS, LONGEST_PLAY, NUMBERS_WINS_FIRST_ROLL, NUMBERS_LOSSES_FIRST_ROLL, AVERAGE_ROLL);

            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative wins are not allowed", e.getMessage());
        }
    }

    @Test
    public void throwsExceptionWhenLossesIsNegative() {
        try {
            new GameStatistics(WINS, -1, TOTAL_ROLLS, LONGEST_PLAY, NUMBERS_WINS_FIRST_ROLL, NUMBERS_LOSSES_FIRST_ROLL, AVERAGE_ROLL);

            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative losses are not allowed", e.getMessage());
        }
    }

    @Test
    public void throwsExceptionWhenNumberOfGamesIsZero() {
        try {
            new GameStatistics(0, 0, TOTAL_ROLLS, LONGEST_PLAY, NUMBERS_WINS_FIRST_ROLL, NUMBERS_LOSSES_FIRST_ROLL, AVERAGE_ROLL);

            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("The sum of wins and losses must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void throwsExceptionWhenTotalRollsIsLesserThanOne() {
        try {
            new GameStatistics(WINS, LOSSES, -5, LONGEST_PLAY, NUMBERS_WINS_FIRST_ROLL, NUMBERS_LOSSES_FIRST_ROLL, AVERAGE_ROLL);

            fail("Should have failed");
        } catch (IllegalArgumentException e) {
            assertEquals("totalRolls must be Greater than zero", e.getMessage());
        }
    }

}
