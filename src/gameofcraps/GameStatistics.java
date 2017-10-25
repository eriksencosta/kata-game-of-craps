package gameofcraps;

/**
 * Created by nayvir on 10/19/17.
 */
public class GameStatistics {

    public final int wins;
    public final int losses;
    public final int numberOfGames;
    public final float probabilityOfWinAtFirstRoll;
    public final float probabilityOfLosingAtFirstRoll;
    public final float averageNumberOfRollsPerGame;
    public final int totalRolls;
    public final int longestPlay;
    public final int numberOfWinsFirst;
    public final int numberOfLossesFirst;
    public final int averageRolls;
    public final float probabilityWin;


    GameStatistics (int wins, int losses, int totalRolls, int longestPlay, int numberOfWinsFirst, int numberOfLossesFirst, int averageRolls){
        this.wins = wins;
        this.losses = losses;
        this.numberOfGames = wins + losses;
        this.probabilityOfWinAtFirstRoll = numberOfWinsFirst / numberOfGames;
        this.probabilityOfLosingAtFirstRoll = numberOfWinsFirst / numberOfGames;
        this.averageNumberOfRollsPerGame = averageRolls / numberOfGames;
        this.totalRolls = totalRolls;
        this.longestPlay = longestPlay;
        this.numberOfWinsFirst = numberOfWinsFirst;
        this.numberOfLossesFirst = numberOfLossesFirst;
        this.averageRolls = averageRolls;
        this.probabilityWin = wins / numberOfGames;
    }

}
