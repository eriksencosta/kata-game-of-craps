package gameofcraps;

public class CrapsGame {
    private Dice pairOfDice;
    private boolean win;
    private int numRolls;
    private int comingOutRoll;
    private int value;

    public CrapsGame(Dice dice) {
        this.pairOfDice = dice;
    }

    public void reset() {
    }

    public void play() {

        pairOfDice.roll();
        numRolls++;
        comingOutRoll = pairOfDice.getSumOfFaces();

        if (comingOutRoll == 7|| comingOutRoll == 11) {
            win = true;
            return;
        }

        if (comingOutRoll == 2 || comingOutRoll == 3 || comingOutRoll == 12) {
            return;
        }

        do {
            pairOfDice.roll();
            numRolls++;
            value = pairOfDice.getSumOfFaces();
        } while (value != comingOutRoll || value == 7);

        win = value == comingOutRoll;
    }


    public boolean getWin() {
        return win;
    }

    public int getNumRolls() {
        return numRolls;
    }
}