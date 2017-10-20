package gameofcraps;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by nayvir on 10/19/17.
 */
public class GameStatisticsTest {
    int wins;
    int losses;
    int numberOfGames;
    int totalRolls;
    int longestPlay;
    int numberOfWinsFirst;
    int numberOfLossesFirst;
    int averageRolls;
    GameStatistics gameStatistics;

    @Before
    public  void setup(){
        wins = 3;
        losses = 4;
        numberOfGames = wins + losses;
        totalRolls = 20;
        longestPlay = 79;
        numberOfWinsFirst = 1;
        numberOfLossesFirst = 0;
        averageRolls = 15;
        gameStatistics = new GameStatistics(wins, losses, totalRolls, longestPlay, numberOfWinsFirst, numberOfLossesFirst, averageRolls);
    }

    @Test
    public void createGameStatisticsResultsTotalNumberOfGames() {
        assertEquals(gameStatistics.numberOfGames, (wins+losses));

    }

    @Test
    public void createGameStatisticsResultsProbabilityOfWin(){
        assertEquals(gameStatistics.probabilityWin, (wins / numberOfGames), 0);
    }

    @Test
    public void createGameStatisticsResultsTotalRolls(){
        assertEquals(gameStatistics.totalRolls,totalRolls);
    }

    @Test
    public void createGameStatisticsResultsLongestGame(){
        assertEquals(gameStatistics.longestPlay,longestPlay);
    }

    @Test
    public void createGameStatisticsResultsNumberOfWinsFirst(){
        assertEquals(gameStatistics.numberOfWinsFirst,numberOfWinsFirst);
    }

    @Test
    public void createGameStatisticsResultsNumberOfLossesFirst(){
        assertEquals(gameStatistics.numberOfLossesFirst,numberOfLossesFirst);
    }

    @Test
    public void createGameStatisticsResultsProbabilityOfWinningAtFirstRoll(){
        assertEquals(gameStatistics.probabilityOfWinAtFirstRoll, numberOfWinsFirst /  numberOfGames, 0);
    }

    @Test
    public void createGameStatisticsResultsProbabilityOfLosingAtFirstRoll(){
        assertEquals(gameStatistics.probabilityOfLosingAtFirstRoll, numberOfLossesFirst /  numberOfGames, 0);
    }

    @Test
    public void createGameStatisticsResultsAverageNumberOfRollsPerGame(){
        assertEquals(gameStatistics.averageNumberOfRollsPerGame, averageRolls / numberOfGames, 2.0 );
    }


}
