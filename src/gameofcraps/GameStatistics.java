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
    public final static String LOSES_AND_WINS_NOT_ZERO_SIMULTANEOUSLY = "Losses and wins cannot be equal to zero simultaneously";
    public final static String NUMBER_WINS_NOT_NEGATIVE = "Number of wins cannot be negative";
    public final static String NUMBER_LOSES_NOT_NEGATIVE = "Number of loses cannot be negative";
    public final static String NUMBER_OF_WINS_INCOMING_OUT_ROLL_GREATER_THAN_WINS = "numberOfWinsOnComingOutRoll must be minor than wins";
    public final static String NUMBER_OF_LOSSES_INCOMING_OUT_ROLL_GREATER_THAN_LOSSES = "numberOfLosesOnComingOutRoll must be minor than wins";
    public final static String NUMBER_OF_LENGHT_OF_LONGEST_GAME_MINOR_THAN_ONE = "lengthOfLongestGame must be at least one";

    public GameStatistics(
            int numberOfWins, int numberOfLosses, int lengthOfLongestGame, int numberOfTotalRolls,
            int numberOfWinsOnComingOutRoll, int numberOfLosesOnComingOutRoll
    ) throws IllegalArgumentException {

        if (numberOfWins == 0 && numberOfLosses == 0) {
            throw new IllegalArgumentException(LOSES_AND_WINS_NOT_ZERO_SIMULTANEOUSLY);
        }

        if (numberOfWins < 0) {
            throw new IllegalArgumentException(NUMBER_WINS_NOT_NEGATIVE);
        }

        if (numberOfLosses < 0) {
            throw new IllegalArgumentException(NUMBER_LOSES_NOT_NEGATIVE);
        }

        if (numberOfWinsOnComingOutRoll > numberOfWins) {
            throw new IllegalArgumentException(NUMBER_OF_WINS_INCOMING_OUT_ROLL_GREATER_THAN_WINS);
        }

        if (numberOfLosesOnComingOutRoll > numberOfLosses) {
            throw new IllegalArgumentException(NUMBER_OF_LOSSES_INCOMING_OUT_ROLL_GREATER_THAN_LOSSES);
        }

        if (lengthOfLongestGame < 1) {
            throw new IllegalArgumentException(NUMBER_OF_LENGHT_OF_LONGEST_GAME_MINOR_THAN_ONE);
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

    @Override
    public String toString() {
        return "Total Wins: " + numberOfWins +
                "\nTotal Loses: " + numberOfLosses +
                "\nNumber Of Games: " + numberOfGames +
                "\nLength Of Longest Game: " + lengthOfLongestGame +
                "\nWinning Probability: " + winningProbability +
                "\nNumber Of Total Rolls: " + numberOfTotalRolls +
                "\nAverage Number Of Rolls: " + averageNumberOfRolls +
                "\nNumber Of Wins On Coming Out Roll: " + numberOfWinsOnComingOutRoll +
                "\nWinning On Coming Put Roll Probability: " + winningOnComingPutRollProbability +
                "\nNumber Of Loses On Coming Out Roll: " + numberOfLosesOnComingOutRoll +
                "\nLosing On Coming Put Roll Probability: " + losingOnComingPutRollProbability;
    }

}
