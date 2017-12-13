package gameofcraps;

public class CrapsGame {

    private Dice pairOfDice;
    private boolean win;
    private int numRolls;

    CrapsGame(Dice dice) {
        pairOfDice = dice;
    }

    public void reset() {
        win = false;
        numRolls = 0;
    }

    public void play() {
        int rollOut;
        rollDices();
        int comingRollOut = pairOfDice.getSumOfFaces();

        if (comingRollOut == 7 || comingRollOut == 11) {
            win = true;
            return;
        }

        if (comingRollOut == 2 || comingRollOut == 3 || comingRollOut == 12) {
            win = false;
            return;
        }

        do {
            rollDices();
            rollOut = pairOfDice.getSumOfFaces();

        } while (rollOut != comingRollOut && rollOut != 7);

        win = rollOut == comingRollOut;
    }

    private void rollDices() {
        pairOfDice.roll();
        numRolls++;
    }

    public boolean getWin() {
        return win;
    }

    public int getNumRolls() {
        return numRolls;
    }

}