package gameofcraps;

public class CrapsGame {
    private Dice pairOfDice;
    private boolean win;
    private int numRolls;

    public CrapsGame(Dice customDice) {
        pairOfDice = customDice;
    }

    public CrapsGame() {
        pairOfDice = new Dice();
    }

    public void reset() {

    }

    public void play() {
        int diceResult = pairOfDice.roll();
        win = diceResult == 7 || diceResult == 11;
    }

    public boolean getWin() {
        return win;
    }

    public int getNumRolls() {
        return -1;
    }
}