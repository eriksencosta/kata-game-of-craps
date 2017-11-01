package gameofcraps;

public class GameStatistics {

    public final int numberOfWins;
    public final int numberOfLosses;
    public final int numberOfGames;
    public final int lengthOfLongestGame;
    public final double winningProbability;
    public final int numberOfTotalRolls;
    public final double averageNumberOfRolls;
    public final int numberOfWinsOnComingOutRoll;
    public final double winningOnComingPutRollProbability;
    public final int numberOfLosesOnComingOutRoll;
    public final double losingOnComingPutRollProbability;
    public final static String NUMBER_WINS_NOT_ZERO = "Number of wins cannot be zero";
    public final static String NUMBER_LOSES_NOT_ZERO = "Number of loses cannot be zero";
    public final static String NUMBER_WINS_NOT_NEGATIVE = "Number of wins cannot be negative";
    public final static String NUMBER_LOSES_NOT_NEGATIVE = "Number of loses cannot be negative";

    public GameStatistics(
            int numberOfWins, int numberOfLosses, int lengthOfLongestGame, int numberOfTotalRolls,
            int numberOfWinsOnComingOutRoll, int numberOfLosesOnComingOutRoll
    ) throws IllegalArgumentException {

        if (numberOfWins == 0) {
            throw new IllegalArgumentException(NUMBER_WINS_NOT_ZERO);
        }
        if (numberOfLosses == 0) {
            throw new IllegalArgumentException(NUMBER_LOSES_NOT_ZERO);
        }
        if (numberOfWins < 0) {
            throw new IllegalArgumentException(NUMBER_WINS_NOT_NEGATIVE);
        }
        if (numberOfLosses < 0) {
            throw new IllegalArgumentException(NUMBER_LOSES_NOT_NEGATIVE);
        }

        this.numberOfWins = numberOfWins;
        this.numberOfLosses = numberOfLosses;
        this.numberOfGames = numberOfWins + numberOfLosses;
        this.lengthOfLongestGame = lengthOfLongestGame;
        this.winningProbability = (double) numberOfWins / this.numberOfGames;
        this.numberOfTotalRolls = numberOfTotalRolls;
        this.averageNumberOfRolls = (double) numberOfTotalRolls / this.numberOfGames;
        this.numberOfWinsOnComingOutRoll = numberOfWinsOnComingOutRoll;
        this.winningOnComingPutRollProbability = (double) this.numberOfWinsOnComingOutRoll / this.numberOfGames;
        this.numberOfLosesOnComingOutRoll = numberOfLosesOnComingOutRoll;
        this.losingOnComingPutRollProbability = (double) this.numberOfLosesOnComingOutRoll / this.numberOfGames;
    }
}
