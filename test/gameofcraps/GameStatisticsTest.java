package gameofcraps;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.IsCloseTo.*;

import org.junit.*;


public class GameStatisticsTest {
    private GameStatistics gameStatistics;

    @Before
    public void createGameStatistics(){
        gameStatistics = new GameStatistics(10, 20, 5,60, 5, 2);
    }

    @Test
    public void calculateNumberOfWins() {
        assertThat(gameStatistics.numWins, equalTo(10));
    }

    @Test
    public void calculateNumberOfLoses() {
        assertThat(gameStatistics.numLoses, equalTo(20));
    }

    @Test
    public void calculateNumberOfGames(){
        assertThat(gameStatistics.numGames, equalTo(30));
    }

    @Test
    public void calculateLengthOfLongestGame(){
        assertThat(gameStatistics.lengthLongestGame, equalTo(5));
    }

    @Test
    public void calculateWinningProbability() {
        assertThat(gameStatistics.winningProbability, closeTo(0.3, 0.05));
    }

    @Test
    public void calculateNumberOfTotalRolls() {
        assertThat(gameStatistics.numTotalRolls, equalTo(60));
    }

    @Test
    public void calculateAverageNumRoll() {
        assertThat(gameStatistics.averageNumRoll, closeTo(2,0.05));
    }

    @Test
    public void calculateNumWinsOnComingOutRoll() {
        assertThat(gameStatistics.numWinsOnComingOutRoll, equalTo(5));
    }

    @Test
    public void calculateWinningOnComingPutRollProbability() {
        assertThat(gameStatistics.winningOnComingPutRollProbability, closeTo(0.16,0.01));
    }

    @Test
    public void calculateNumLosesOnComingOutRoll(){
        assertThat(gameStatistics.numLosesOnComingOutRoll, equalTo(2));
    }

    @Test
    public void calculateLosingOnComingPutRollProbability() {
        assertThat(gameStatistics.losingOnComingPutRollProbability, closeTo(0.06,0.01));
    }
}
