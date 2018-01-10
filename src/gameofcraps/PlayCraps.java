package gameofcraps;

public class PlayCraps {
    public static void main(String[] args) {
        CrapsGame game = new CrapsGame(new Dice());
        int numGames;
        System.out.println("Welcome to Craps!");
        numGames = Integer.parseInt(args[0]);
        System.out.println("Enter number of games: " + numGames);
        GameStatistics gameStatisticsResult= play(numGames);
        System.out.println("wins " + gameStatisticsResult.wins);
        System.out.println("losses " + gameStatisticsResult.losses);
        System.out.println("numberOfGames " + gameStatisticsResult.numberOfGames);
        System.out.println("probabilityOfWinAtComingRoll " +
                gameStatisticsResult.probabilityOfWinAtComingRoll);
        System.out.println("probabilityOfLosingAtComingRoll " +
                gameStatisticsResult.probabilityOfLosingAtComingRoll);
        System.out.println("averageNumberOfRollsPerGame " +
                gameStatisticsResult.averageNumberOfRollsPerGame);
        System.out.println("totalRolls " + gameStatisticsResult.totalRolls);
        System.out.println("longestPlay " + gameStatisticsResult.longestPlay);
        System.out.println("numberOfWinsComingRoll " +
                gameStatisticsResult.numberOfWinsComingRoll);
        System.out.println("numberOfLossesComingRoll " +
                gameStatisticsResult.numberOfLossesComingRoll);
        System.out.println("averageRolls " + gameStatisticsResult.averageRolls);
        System.out.println("probabilityWin " + gameStatisticsResult.probabilityWin);
    }
    public static GameStatistics play(int numGames){
        return new GameStatistics(3, 4, 20, 79,
                1, 0, 15);
    }
}