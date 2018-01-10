package gameofcraps;

public class PlayCraps {
    public static void main(String[] args) {

        int numGames;

        System.out.println("Welcome to Craps!");
        System.out.println("Enter number of games: ");
        numGames = Integer.parseInt(args[0]);

        GameStatistics gameStatistics = play(numGames);

        System.out.println("Played games: " + gameStatistics.playedGames());
        System.out.println("Winning probability games: " + gameStatistics.winningProbability());
        System.out.println("Rolls per game: " + gameStatistics.rollsPerGame());
        System.out.println("Longest played game: " + gameStatistics.longestPlayedGame());
        System.out.println("Winning probability in comming roll out: " + gameStatistics.winningProbabilityInComingOutRoll());
        System.out.println("Lose probbility in comming roll out: " + gameStatistics.lossesProbabilityInComingOutRoll());
    }

    public static GameStatistics play(int numGames) {

        if (numGames < 1) {
            throw new IllegalArgumentException("numGames must be at least one");
        }

        CrapsGame game = new CrapsGame();

        int wins = 0;
        int losses = 0;
        int longestPlayedGame = 0;
        int rollsMade = 0;
        int winsComingOutRoll = 0;
        int lossesInComingOutRoll = 0;

        for (int i = 1; i <= numGames; i++) {
            game.play();
            if (game.getWin()) {
                wins++;
            }
            else {
                losses++;
            }
            if (game.getNumRolls() > longestPlayedGame) {
                longestPlayedGame = game.getNumRolls();
            }
            rollsMade += game.getNumRolls();


            if (game.getNumRolls() == 1 && game.getWin()) {
                winsComingOutRoll++;
            }
            if (game.getNumRolls() == 1 && !game.getWin()) {
                lossesInComingOutRoll++;
            }
        }

        return new GameStatistics(wins, losses, longestPlayedGame, rollsMade, winsComingOutRoll, lossesInComingOutRoll);
    }

}