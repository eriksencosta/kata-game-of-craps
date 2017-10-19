package gameofcraps;

public class CrapsGame {
    private Dice pairOfDice;
    private boolean win;
    private int numRolls;

    public CrapsGame() {
        this.win = false;
        this.numRolls = 0;
        this.pairOfDice = new Dice();
    }

    public void reset() {
        this.win = false;
        this.numRolls = 0;
    }

    public void play() {
    }

    public boolean getWin() {
        return false;
    }

    public int getNumRolls() {
        return -1;
    }
}