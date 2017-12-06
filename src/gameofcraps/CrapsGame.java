package gameofcraps;

public class CrapsGame {
    private Dice pairOfDice;
    private boolean won;
    private int numRolls;
    private int firstRoll;


    public CrapsGame(Dice customDice) {
        pairOfDice = customDice;
    }

    public CrapsGame() {
        pairOfDice = new Dice();
    }

    public void reset() {

    }

    public void play() {
        pairOfDice.roll();
        numRolls = 1;

        int diceResult = pairOfDice.getSumOfFaces();

        if (diceResult == 7 || diceResult == 11) {
            won = true;
            return;
        }

        if (diceResult == 2 || diceResult == 3 || diceResult == 12) {
            return;
        }

            firstRoll = diceResult;

            do {
                pairOfDice.roll();
                numRolls ++;
                diceResult = pairOfDice.getSumOfFaces();

            } while (diceResult != 7 && diceResult != firstRoll);

            won = diceResult == firstRoll;

    }

    public boolean getWin() {
        return won;
    }

    public int getNumRolls() {
        return -1;
    }


}