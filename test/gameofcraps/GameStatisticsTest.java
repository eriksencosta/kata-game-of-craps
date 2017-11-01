package gameofcraps;

import static org.hamcrest.Matchers.*;

import org.junit.Rule;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.IllegalArgumentException;

import static org.junit.Assert.*;

public class GameStatisticsTest {

    GameStatistics stats;

    private static final int NUMBER_OF_LOSSES = 10;
    private static final int NUMBER_OF_WINS = 10;
    private static final int LONGEST_PLAYED_GAME = 10;
    private static final int ROLLS_MADE = 10;
    private static final int WINS_IN_COMMING_OUT_ROLL = 10;
    private static final int LOSSES_IN_COMMING_OUT_ROLL = 10;
    private static final double TOLERANCE = 1e-6;



    @Before
    public void createGameStatistics() {
        stats = new GameStatistics(NUMBER_OF_WINS, NUMBER_OF_LOSSES, LONGEST_PLAYED_GAME, ROLLS_MADE,
                WINS_IN_COMMING_OUT_ROLL, LOSSES_IN_COMMING_OUT_ROLL);
    }

    @Test
    public void creatingGameStatisticsResultsInNumberOfPlayedGames() {
        assertThat(stats.playedGames(), equalTo(NUMBER_OF_LOSSES + NUMBER_OF_WINS));
    }


    @Test
    public void creatingGameStatisticsResultsInNumberOfWinsGames() {
        assertThat(stats.wins, equalTo(NUMBER_OF_WINS));
    }

    @Test
    public void creatingGameStatisticsResultsInNumberOfLongestPlayedGame() {
        assertThat(stats.longestPlayedGame, equalTo(LONGEST_PLAYED_GAME));
    }

    @Test
    public void creatingGameStatisticsResultsInWinnerProbability() {
        double probability = ((double) NUMBER_OF_WINS / (NUMBER_OF_WINS + NUMBER_OF_LOSSES));
        assertThat(stats.winningProbability(), closeTo(probability, TOLERANCE));
    }

    @Test
    public void creatingGameStatisticsResultsInNumberOfRollsMade() {
        assertThat(stats.rollsMade, equalTo(ROLLS_MADE));
    }

    @Test
    public void creatingGameStatisticsResultsInNumberOfRollsPerGame() {
        double roolsPerGame = (double) ROLLS_MADE / (NUMBER_OF_WINS + NUMBER_OF_LOSSES);
        assertThat(stats.rollsPerGame(), equalTo(roolsPerGame));
    }

    @Test
    public void creatingGameStatisticsResultsInNumberOfWinsInCommingOutRoll() {
        assertThat(stats.winsInComingOutRoll, equalTo(WINS_IN_COMMING_OUT_ROLL));
    }

    @Test
    public void creatingGameStatisticsResultsInWinnerProbabilityInComingOutRoll() {
        double probability = ((double) WINS_IN_COMMING_OUT_ROLL / (NUMBER_OF_WINS + NUMBER_OF_LOSSES));
        assertThat(stats.winningProbabilityInComingOutRoll(), closeTo(probability, TOLERANCE));
    }

    @Test
    public void creatingGameStatisticsResultsInNUmberOfLosesInComingOutRoll() {
        assertThat(stats.lossesInComingOutRoll, equalTo(LOSSES_IN_COMMING_OUT_ROLL));
    }

    @Test
    public void creatingGameStatisticsResultsInLosesProbabilityInComingOutRoll() {
        double probability = ((double) LOSSES_IN_COMMING_OUT_ROLL / (NUMBER_OF_WINS + NUMBER_OF_LOSSES));
        assertThat(stats.lossesProbabilityInComingOutRoll(), closeTo(probability, TOLERANCE));
    }

    @Rule
    public ExpectedException thrownNegativeWins = ExpectedException.none();

    @Test
    public void creatingGameStatisticsThrowsExceptionWhenWinsIsNegativeOnInstantiation() {

        thrownNegativeWins.expect(IllegalArgumentException.class);
        thrownNegativeWins.expectMessage("Wins cannot be negative");

        new GameStatistics(-1, NUMBER_OF_LOSSES, LONGEST_PLAYED_GAME, ROLLS_MADE, WINS_IN_COMMING_OUT_ROLL,
                LOSSES_IN_COMMING_OUT_ROLL);
    }

    @Rule
    public ExpectedException thrownNegativeLosses = ExpectedException.none();

    @Test
    public void creatingGameStatisticsThrowsExceptionWhenLossesIsNegativeOnInstantiation() {

        thrownNegativeLosses.expect(IllegalArgumentException.class);
        thrownNegativeLosses.expectMessage("Losses cannot be negative");

        new GameStatistics(NUMBER_OF_WINS, -1, LONGEST_PLAYED_GAME, ROLLS_MADE, WINS_IN_COMMING_OUT_ROLL,
                    LOSSES_IN_COMMING_OUT_ROLL);

    }
    
}

