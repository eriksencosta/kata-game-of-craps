package gameofcraps;

public class CrapsGame {
    private Dice pairOfDice;
    private boolean win;
    private int numRolls;
    private int firstRoll;
    private int value;

    public CrapsGame(Dice dice) {
        this.pairOfDice = dice;
    }

    public void reset() {
    }

    public void play() {
        pairOfDice.roll();
        numRolls++;
        firstRoll = pairOfDice.getSumOfFaces();
        if (firstRoll==7||firstRoll==11){
          win=true;
        }
        else if (firstRoll != 2 && firstRoll!= 3 && firstRoll !=12){
            do {
                pairOfDice.roll();
                numRolls++;
                value = pairOfDice.getSumOfFaces();

            }
            while (value != firstRoll || value == 7);
            if (value == firstRoll){
                win= true;
            }
        }
    }

    public boolean getWin() {
        return win;
    }

    public int getNumRolls() {
        return numRolls;
    }
}