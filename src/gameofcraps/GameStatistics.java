package gameofcraps;

/**
 * Created by nayvir on 10/19/17.
 */
public class GameStatistics {

    public final int wins;
    public final int losses;
    public final int numberOfGames;
    public final float probabilityWin;
    public final float probabilityOfWinAtFirstRoll;
    public final float probabilityOfLosingAtFirstRoll;
    public final float averageNumberOfRollsPerGame;
    public final int totalRolls;
    public final int longestPlay;
    public final int numberOfWinsFirst;
    public final int numberOfLossesFirst;
    public final int averageRolls;


    GameStatistics (int wins, int losses, int totalRolls, int longestPlay, int numberOfWinsFirst, int numberOfLossesFirst, int averageRolls){
        this.wins = wins;
        this.losses = losses;
        this.numberOfGames = wins + losses;
        this.probabilityWin = ProbabilityOfWin();
        this.probabilityOfWinAtFirstRoll = ProbabilityOfWinAtFirstRoll();
        this.probabilityOfLosingAtFirstRoll = ProbabilityOfLosingAtFirstRoll();
        this.averageNumberOfRollsPerGame = AverageNumberOfRollsPerGame();
        this.totalRolls = totalRolls;
        this.longestPlay = longestPlay;
        this.numberOfWinsFirst = numberOfWinsFirst;
        this.numberOfLossesFirst = numberOfLossesFirst;
        this.averageRolls = averageRolls;
    }

    public  float ProbabilityOfWin(){
        float  probabilityWin = wins / numberOfGames;
        return probabilityWin;
    }

    public  float ProbabilityOfWinAtFirstRoll(){
        float  probabilityOfWinAtFirstRoll = numberOfWinsFirst / numberOfGames;
        return probabilityOfWinAtFirstRoll;
    }

    public  float ProbabilityOfLosingAtFirstRoll(){
        float  probabilityOfLosingAtFirstRoll = numberOfWinsFirst / numberOfGames;
        return probabilityOfLosingAtFirstRoll;
    }

    public  float AverageNumberOfRollsPerGame(){
        float  averageNumberOfRollsPerGame =   averageRolls / numberOfGames;
        return averageNumberOfRollsPerGame;
    }

}
