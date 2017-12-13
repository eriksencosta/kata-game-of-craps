package gameofcraps;

public class DeterministicDice extends Dice {
    private int result;
    private boolean rolled;

    DeterministicDice(Integer result) {
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
            super("The DeterministicDice has already been rolled.");
        }
    }
}
