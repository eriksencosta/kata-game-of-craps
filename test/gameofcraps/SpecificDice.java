package gameofcraps;

public class SpecificDice extends Dice {

    private int result;
    private boolean rolled;

    SpecificDice(Integer result) {
        this.result = result;
    }

    @Override
    public int getSumOfFaces() {
        return result;
    }

    @Override
    public void roll() {
        if (rolled) {
            throw new PreviouslyRolledDiceException();
        }

        rolled = true;
    }

    private class PreviouslyRolledDiceException extends RuntimeException {
        PreviouslyRolledDiceException() {
            super("The SpecificDice has already been rolled.");
        }
    }

}
