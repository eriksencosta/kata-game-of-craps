package gameofcraps;

public class PlayCraps {
    public static void main(String[] args) {
        CrapsGame game = new CrapsGame();
        int numGames;

        System.out.println("Welcome to Craps!");
        System.out.println("Enter number of games: ");
        numGames = Integer.parseInt(args[0]);
    }
}