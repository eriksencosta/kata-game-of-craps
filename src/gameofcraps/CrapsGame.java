package gameofcraps;

public class CrapsGame {
    private Dice pairOfDice;
    private boolean won;
    private int numberOfRolls;


    public CrapsGame(Dice dice) {
        pairOfDice = dice;
    }

    public CrapsGame() {
        pairOfDice = new Dice();
    }

    public void reset() {
        numberOfRolls = 0;
        won = false;
    }

    public void play() {
        pairOfDice.roll();
        numberOfRolls = 1;
        int firstRoll;

        int diceResult = pairOfDice.sumOfFaces();

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
            numberOfRolls++;
            diceResult = pairOfDice.sumOfFaces();

        } while (diceResult != 7 && diceResult != firstRoll);

        won = diceResult == firstRoll;

    }

    public boolean win() {
        return won;
    }

    public int numberOfRolls() {
        return numberOfRolls;
    }


}