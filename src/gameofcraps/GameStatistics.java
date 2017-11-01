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
    public final static String NUMBER_WINS_NOT_ZERO = "Number of wins cannot be zero";
    public final static String NUMBER_LOSES_NOT_ZERO = "Number of loses cannot be zero";
    public final static String NUMBER_WINS_NOT_NEGATIVE = "Number of wins cannot be negative";
    public final static String NUMBER_LOSES_NOT_NEGATIVE = "Number of loses cannot be negative";

    public GameStatistics(
            int numWins, int numLoses, int lengthLongestGame, int numTotalRolls,
            int numWinsOnComingOutRoll, int numLosesOnComingOutRoll
    ) throws IllegalArgumentException {

        if (numWins == 0) {
            throw new IllegalArgumentException(NUMBER_WINS_NOT_ZERO);
        }
        if(numLoses == 0){
            throw new IllegalArgumentException(NUMBER_LOSES_NOT_ZERO);
        }
        if (numWins < 0 ) {
            throw new IllegalArgumentException(NUMBER_WINS_NOT_NEGATIVE);
        }
        if(numLoses < 0 ){
            throw new IllegalArgumentException(NUMBER_LOSES_NOT_NEGATIVE);
        }

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
