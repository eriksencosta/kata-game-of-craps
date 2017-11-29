package gameofcraps;

public class PlayCraps {
    public static void main(String[] args) {
        CrapsGame game = new CrapsGame(new Dice());
        int numGames;

        System.out.println("Welcome to Craps!");
        System.out.println("Enter number of games: ");
        numGames = Integer.parseInt(args[0]);
    }
    public GameStatistics play(int numGames){
        return new GameStatistics(3, 4, 20, 79, 1, 0, 15);
    }



}