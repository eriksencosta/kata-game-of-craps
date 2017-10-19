package gameofcraps;

public class GameStatistics {

    public final int numWins;
    public final int numLoses;
    public final int numGames;
    public final int lengthLongestGame;
    public final double winningProbability;
    public final int numTotalRolls;
    public final double averageNumRoll;
    public final int numWinsOnComingOutRoll;
    public final double winningOnComingPutRollProbability;
    public final int numLosesOnComingOutRoll;
    public final double losingOnComingPutRollProbability;

    public GameStatistics(
            int numWins, int numLoses, int lengthLongestGame, int numTotalRolls,
            int numWinsOnComingOutRoll, int numLosesOnComingOutRoll
    ) {
        this.numWins = numWins;
        this.numLoses = numLoses;
        this.numGames = numWins+numLoses;
        this.lengthLongestGame = lengthLongestGame;
        this.winningProbability = (double) numWins / this.numGames;
        this.numTotalRolls = numTotalRolls;
        this.averageNumRoll = (double) numTotalRolls / this.numGames;
        this.numWinsOnComingOutRoll = numWinsOnComingOutRoll;
        this.winningOnComingPutRollProbability = (double) this.numWinsOnComingOutRoll / this.numGames;
        this.numLosesOnComingOutRoll = numLosesOnComingOutRoll;
        this.losingOnComingPutRollProbability = (double) this.numLosesOnComingOutRoll / this.numGames;
    }
}
