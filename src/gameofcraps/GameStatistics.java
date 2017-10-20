package gameofcraps;

public class GameStatistics {

    public final int wins;
    public final int loses;
    public final int longestPlayedGame;
    public final int rollsMade;
    public final int winsInComingOutRoll;
    public final int losesInComingOutRoll;

    public GameStatistics(int wins, int loses, int longestPlayedGame, int rollsMade, int winsInComingOutRoll,
        int losesInComingOutRoll){
        this.wins = wins;
        this.loses = loses;
        this.longestPlayedGame = longestPlayedGame;
        this.rollsMade = rollsMade;
        this.winsInComingOutRoll = winsInComingOutRoll;
        this.losesInComingOutRoll = losesInComingOutRoll;
    }

    public int playedGames()
    {
        return this.wins + this.loses;
    }

    public double winnerProbability(){
        return (double) this.wins / this.playedGames();
    }

    public double rollsPerGame(){
        return (double) this.rollsMade / this.playedGames();
    }

    public double winnerProbabilityInComingOutRoll(){
        return (double) this.winsInComingOutRoll / this.playedGames();
    }

    public double losesProbabilityInComingOutRoll(){
        return (double) this.losesInComingOutRoll / this.playedGames();
    }

}
