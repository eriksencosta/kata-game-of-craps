package gameofcraps;

public class GameStatistics {

    public final int wins;
    public final int losses;
    public final int numberOfGames;
    public final double probabilityOfWinAtComingRoll;
    public final double probabilityOfLosingAtComingRoll;
    public final double averageNumberOfRollsPerGame;
    public final int totalRolls;
    public final int longestPlay;
    public final int numberOfWinsComingRoll;
    public final int numberOfLossesComingRoll;
    public final int averageRolls;
    public final double probabilityWin;

    public GameStatistics(int wins, int losses, int totalRolls, int longestPlay, int numberOfWinsComingRoll,
                          int numberOfLossesComingRoll, int averageRolls) {

        if (wins < 0)
            throw new IllegalArgumentException("Negative wins are not allowed");

        if (losses < 0)
            throw new IllegalArgumentException("Negative losses are not allowed");

        if (wins + losses == 0)
            throw new IllegalArgumentException("The sum of wins and losses must be greater than zero");

        if (totalRolls < 1)
            throw new IllegalArgumentException("totalRolls must be greater than one");

        if (longestPlay < 1)
            throw new IllegalArgumentException("longestPlay must be greater than one");

        if (numberOfWinsComingRoll < 0)
            throw new IllegalArgumentException("Negative numberOfWinsComingRoll are not allowed");

        if (numberOfLossesComingRoll < 0)
            throw new IllegalArgumentException("Negative numberOfLossesComingRoll are not allowed");

        if (averageRolls < 1)
            throw new IllegalArgumentException("averageRolls must be greater than zero");

        this.wins = wins;
        this.losses = losses;
        this.numberOfGames = wins + losses;
        this.probabilityOfWinAtComingRoll = (double) numberOfWinsComingRoll / numberOfGames;
        this.probabilityOfLosingAtComingRoll = (double) numberOfLossesComingRoll / numberOfGames;
        this.averageNumberOfRollsPerGame = (double) averageRolls / numberOfGames;
        this.totalRolls = totalRolls;
        this.longestPlay = longestPlay;
        this.numberOfWinsComingRoll = numberOfWinsComingRoll;
        this.numberOfLossesComingRoll = numberOfLossesComingRoll;
        this.averageRolls = averageRolls;
        this.probabilityWin = (double) wins / numberOfGames;
    }
}