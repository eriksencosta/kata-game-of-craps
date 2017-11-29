package gameofcraps;

public class CrapsGame {
    private Dice pairOfDice;
    private boolean won;
    private boolean lose;
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
        won = diceResult == 7 || diceResult == 11;
        lose = diceResult == 2 || diceResult == 3 || diceResult == 12;

        if (!won && !lose) {
            firstRoll = diceResult;

            do{
                pairOfDice.roll();
                numRolls ++;

                diceResult = pairOfDice.getSumOfFaces();
            }while(diceResult != 7 && diceResult != firstRoll);

            won = diceResult == firstRoll;
        }

    }

    public boolean getWin() {
        return won;
    }

    public boolean getLose() {
        return lose;
    }

    public int getNumRolls() {
        return -1;
    }


}