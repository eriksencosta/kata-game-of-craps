package gameofcraps;

public class PlayCraps {

    public static void main(String[] args) {
        int numGames = 1000;
        GameStatistics statistics = play(numGames);

        System.out.println("Welcome to Craps!");
        System.out.println(statistics.toString());
    }

    static GameStatistics play(int numGames) {
        Dice dice = new Dice();
        CrapsGame gameList[] = new CrapsGame[numGames];

        int totalWins = 0;
        int totalLoses = 0;
        int lengthOfLongestGame = 0;
        int totalRolls = 0;
        int numberOfWinsOnComingOutRoll = 0;
        int numberOfLosesOnComingOutRoll = 0;

        for (int i = 0; i < numGames; i++) {
            gameList[i] = new CrapsGame(dice);
            CrapsGame game = gameList[i];

            game.play();

            if (game.getWin()) {
                totalWins++;
            } else {
                totalLoses++;
            }

            if (game.getNumRolls() > lengthOfLongestGame) {
                lengthOfLongestGame = game.getNumRolls();
            }

            totalRolls += game.getNumRolls();

            if (game.getWin() && game.getNumRolls() == 1) {
                numberOfWinsOnComingOutRoll++;
            }

            if (!game.getWin() && game.getNumRolls() == 1) {
                numberOfLosesOnComingOutRoll++;
            }
        }

        return new GameStatistics(totalWins, totalLoses, lengthOfLongestGame, totalRolls, numberOfWinsOnComingOutRoll,
                numberOfLosesOnComingOutRoll);
    }

}
