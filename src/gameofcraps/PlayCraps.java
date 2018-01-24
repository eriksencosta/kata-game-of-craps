package gameofcraps;

public class PlayCraps {
    public static void main(String[] args) {
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

        CrapsGame crapsGame = new CrapsGame(new Dice());
        int wins = 0;
        int losses = 0;
        int winsAtComingOutRoll = 0;
        int lossesAtComingOutRoll = 0;
        int longestPlay = 0;
        int averageRoll = 0;
        int totalRolls = 0;

        for(int i = 0; i < numGames; i ++) {
            crapsGame.play();
            boolean resultGame = crapsGame.getWin();
            int numRolls = crapsGame.getNumRolls();

            if (resultGame == true)
                wins++;
            if (resultGame == false)
                losses++;
            if (resultGame == true && numRolls == 1)
                winsAtComingOutRoll++;
            if (resultGame == false && numRolls == 1)
                lossesAtComingOutRoll++;
            if (longestPlay < numRolls)
                longestPlay = numRolls;
            totalRolls += numRolls;
            averageRoll = totalRolls / numGames;
        }

        return new GameStatistics(wins, losses, totalRolls, longestPlay,
                winsAtComingOutRoll, lossesAtComingOutRoll, averageRoll);
    }
}