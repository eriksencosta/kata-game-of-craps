package gameofcraps;

public class CrapsGame {
    private Dice pairOfDice;
    private boolean win;
    private int numRolls;

    public CrapsGame(Dice dice) {
        pairOfDice = dice;
        numRolls = 0;
    }


    public void reset() {
        win = false;
        numRolls = 0;
    }

    public void play() {
        int rollOut;
        pairOfDice.roll();
        int comingRollOut = pairOfDice.getSumOfFaces();

        if (comingRollOut == 7 || comingRollOut == 11) {
            win = true;
        } else if (comingRollOut == 2 || comingRollOut == 3 || comingRollOut == 12) {
            win = false;
        } else {

            do {
                pairOfDice.roll();
                rollOut = pairOfDice.getSumOfFaces();

            } while (rollOut != comingRollOut && comingRollOut != 7);
            
            win = rollOut == comingRollOut ? true : false;
        }
    }

    public boolean getWin() {
        return win;
    }

    public int getNumRolls() {
        return numRolls;
    }
}