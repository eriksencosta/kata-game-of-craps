package gameofcraps;

import java.lang.IllegalArgumentException;

public class GameStatistics {

    public final int wins;
    public final int losses;
    public final int longestPlayedGame;
    public final int rollsMade;
    public final int winsInComingOutRoll;
    public final int lossesInComingOutRoll;

    public GameStatistics(int wins, int losses, int longestPlayedGame, int rollsMade, int winsInComingOutRoll,
                          int lossesInComingOutRoll) {

        if (wins < 0) {
            throw new IllegalArgumentException("Wins cannot be negative");
        }

        this.wins = wins;
        this.losses = losses;
        this.longestPlayedGame = longestPlayedGame;
        this.rollsMade = rollsMade;
        this.winsInComingOutRoll = winsInComingOutRoll;
        this.lossesInComingOutRoll = lossesInComingOutRoll;
    }

    public int playedGames()
    {
        return this.wins + this.losses;
    }

    public double winningProbability(){
        return (double) this.wins / this.playedGames();
    }

    public double rollsPerGame(){
        return (double) this.rollsMade / this.playedGames();
    }

    public double winningProbabilityInComingOutRoll(){
        return (double) this.winsInComingOutRoll / this.playedGames();
    }

    public double lossesProbabilityInComingOutRoll(){
        return (double) this.lossesInComingOutRoll / this.playedGames();
    }

}
