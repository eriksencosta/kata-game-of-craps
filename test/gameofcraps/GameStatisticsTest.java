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
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void creatingGameStatisticsThrowsExceptionWhenWinsIsNegativeOnInstantiation() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("wins cannot be negative");

        new GameStatistics(-1, NUMBER_OF_LOSSES, LONGEST_PLAYED_GAME, ROLLS_MADE, WINS_IN_COMMING_OUT_ROLL,
                LOSSES_IN_COMMING_OUT_ROLL);
    }

    @Test
    public void creatingGameStatisticsThrowsExceptionWhenLossesIsNegativeOnInstantiation() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("losses cannot be negative");

        new GameStatistics(NUMBER_OF_WINS, -1, LONGEST_PLAYED_GAME, ROLLS_MADE, WINS_IN_COMMING_OUT_ROLL,
                    LOSSES_IN_COMMING_OUT_ROLL);

    }

    @Test
    public void creatingGameStatisticsThrowsExceptionWhenWinsInComingOutRollIsNegativeOnInstantiation() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("wins in coming out roll cannot be negative");

        new GameStatistics(NUMBER_OF_WINS, NUMBER_OF_LOSSES, LONGEST_PLAYED_GAME, ROLLS_MADE, -1,
                LOSSES_IN_COMMING_OUT_ROLL);

    }

    @Test
    public void creatingGameStatisticsThrowsExceptionWhenLossesInComingOutRollIsNegativeOnInstantiation() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("losses in coming out roll cannot be negative");

        new GameStatistics(NUMBER_OF_WINS, NUMBER_OF_LOSSES, LONGEST_PLAYED_GAME, ROLLS_MADE, WINS_IN_COMMING_OUT_ROLL,
                -1);

    }

    @Test
    public void creatingGameStatisticsThrowsExceptionWhenLossesAndWinsEqualToZeroSimultaneouslyOnInstantiation() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("losses and wins are equal to zero simultaneously");

        new GameStatistics(0, 0, LONGEST_PLAYED_GAME, ROLLS_MADE, WINS_IN_COMMING_OUT_ROLL,
                LOSSES_IN_COMMING_OUT_ROLL);

    }
    
    @Test
    public void creatingGameStatisticsThrowsExceptionWhenLongestPlayedGameIsLessThanOne() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("longestPlayedGame play must be at least one");

        new GameStatistics(NUMBER_OF_WINS, NUMBER_OF_LOSSES, 0, ROLLS_MADE, WINS_IN_COMMING_OUT_ROLL,
                LOSSES_IN_COMMING_OUT_ROLL);
    }

    @Test
    public void creatingGameStatisticsThrowsExceptionWhenWinsInComingOutRollsIsMajorThanWins() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("winsInComingOutRoll must be minor than wins");

        new GameStatistics(NUMBER_OF_WINS, NUMBER_OF_LOSSES, LONGEST_PLAYED_GAME, ROLLS_MADE, NUMBER_OF_WINS + 1,
                LOSSES_IN_COMMING_OUT_ROLL);
    }

    @Test
    public void creatingGameStaticsThrownExceptionWhenLossesInComingOutRollsIsMajorThanLosses() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("lossesInComingOutRoll must be minor than losses");

        new GameStatistics(NUMBER_OF_WINS, NUMBER_OF_LOSSES, LONGEST_PLAYED_GAME, ROLLS_MADE, NUMBER_OF_WINS,
                NUMBER_OF_LOSSES + 1);
    }

}

