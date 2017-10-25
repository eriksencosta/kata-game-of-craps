package gameofcraps;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.IsCloseTo.*;

import org.junit.*;


public class GameStatisticsTest {
    private GameStatistics gameStatistics = new GameStatistics(GAMES_WON, GAMES_LOST, 5,TOTAL_ROLLS, 5, 2);

    private static final int GAMES_WON = 10;
    private static final int GAMES_LOST = 20;
    private static final int GAMES_PLAYED = 30;
    private static final int TOTAL_ROLLS = 60;

    @Test
    public void calculateNumberOfWins() {
        assertThat(gameStatistics.numWins, equalTo(GAMES_WON));
    }

    @Test
    public void calculateNumberOfLoses() {
        assertThat(gameStatistics.numLoses, equalTo(GAMES_LOST));
    }

    @Test
    public void calculateNumberOfGames(){
        assertThat(gameStatistics.numGames, equalTo(GAMES_PLAYED));
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
        assertThat(gameStatistics.numTotalRolls, equalTo(TOTAL_ROLLS));
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

    @Test(expected = IllegalArgumentException.class)
    public void raisesErrorWhenNumberOfGamesIsZero() {
        new GameStatistics(0, 0, 0, 0, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void raisesErrorWhenNunberOfWinsLessThenZero() {
        new GameStatistics(-5, 2, 0, 0, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void raisesErrorWhenNunberOfLosesLessThenZero() {
        new GameStatistics(2, -5, 0, 0, 0, 0);
    }
}

