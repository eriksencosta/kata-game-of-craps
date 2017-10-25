package gameofcraps;

import static org.hamcrest.Matchers.*;

import org.junit.Rule;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class GameStatisticsTest {
    int numLoses, numWins, longestPlayedGame, rollsMade, winsInComingOutRoll, losesInComingOutRoll;
    GameStatistics stats;

    private static final int NUM_LOSSES = 10;
    private static final int NUM_WINS = 10;
    private static final int LONGEST_PLAYED_GAME = 10;
    private static final int ROLLS_MADE = 10;
    private static final int WINS_IN_COMMING_OUT_ROLL = 10;
    private static final int LOSSES_IN_COMMING_OUT_ROLL = 10;


    numLoses = 10;
    numWins = -10;
    longestPlayedGame = 34;
    rollsMade = 150;
    winsInComingOutRoll = 4;
    losesInComingOutRoll = 3;

    @Before
    public void createGameStatistics() {
        stats = new GameStatistics(numWins, numLoses, longestPlayedGame, rollsMade, winsInComingOutRoll, losesInComingOutRoll);
    }

    @Test
    public void creatingGameStatisticsResultsInNumberOfPlayedGames() {
        assertThat(stats.playedGames(), equalTo(numLoses + numWins));
    }


    @Test
    public void creatingGameStatisticsResultsInNumberOfWinsGames() {
        assertThat(stats.wins, equalTo(numWins));
    }

    @Test
    public void creatingGameStatisticsResultsInNumberOfLongestPlayedGame() {
        assertThat(stats.longestPlayedGame, equalTo(longestPlayedGame));
    }

    @Test
    public void creatingGameStatisticsResultsInWinnerProbability() {
        double probability = ((double)numWins / (numWins + numLoses));
        assertThat(stats.winnerProbability(), closeTo(probability, 0.00005));
    }

    @Test
    public void creatingGameStatisticsResultsInNumberOfRollsMade() {
        assertThat(stats.rollsMade, equalTo(rollsMade));
    }

    @Test
    public void creatingGameStatisticsResultsInNumberOfRollsPerGame() {
        double roolsPerGame = (double) rollsMade / (numWins + numLoses);
        assertThat(stats.rollsPerGame(), equalTo(roolsPerGame));
    }

    @Test
    public void creatingGameStatisticsResultsInNumberOfWinsInCommingOutRoll() {
        assertThat(stats.winsInComingOutRoll, equalTo(winsInComingOutRoll));
    }

    @Test
    public void creatingGameStatisticsResultsInWinnerProbabilityInComingOutRoll() {
        double probability = ((double) winsInComingOutRoll / (numWins + numLoses));
        assertThat(stats.winnerProbabilityInComingOutRoll(), closeTo(probability, 0.00005));
    }

    @Test
    public void creatingGameStatisticsResultsInNUmberOfLosesInComingOutRoll() {
        assertThat(stats.losesInComingOutRoll, equalTo(losesInComingOutRoll));
    }

    @Test
    public void creatingGameStatisticsResultsInLosesProbabilityInComingOutRoll() {
        double probability = ((double) losesInComingOutRoll / (numWins + numLoses));
        assertThat(stats.losesProbabilityInComingOutRoll(), closeTo(probability, 0.00005));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void creatingGameStatisticsThrowsExceptionWhenWinsIsNegativeOnInstantiation() {

        thrown.expect(InvalidParameterException.class);
        thrown.expectMessage("Wins cannot be negative");

        new GameStatistics(numWins, numLoses, longestPlayedGame, rollsMade, winsInComingOutRoll, losesInComingOutRoll);
    }
    
}

