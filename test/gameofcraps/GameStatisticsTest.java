package gameofcraps;

//import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.IsCloseTo.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameStatisticsTest {
    int numLoses, numWins, longestPlayedGame, rollsMade, winsInComingOutRoll, losesInComingOutRoll;
    GameStatistics stats;

    @Before
    public void createGameStatistics(){
        numLoses = 10;
        numWins = 15;
        longestPlayedGame = 34;
        rollsMade = 150;
        winsInComingOutRoll = 4;
        losesInComingOutRoll = 3;
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

}

