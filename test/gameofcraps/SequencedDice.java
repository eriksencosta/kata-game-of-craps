package gameofcraps;

import java.util.List;
import java.util.Arrays;

public class SequencedDice extends Dice {
    private final List<Integer> sequencedResults;
    private int rolls = -1;

    SequencedDice(Integer ...results) {
        sequencedResults = Arrays.asList(results);
    }

    @Override
    public int getSumOfFaces() {
        return sequencedResults.get(rolls);
    }

    @Override
    public void roll() {
        rolls++;

        if (rolls >= sequencedResults.size()) {
            throw new ExhaustedDiceException();
        }
    }

    private class ExhaustedDiceException extends RuntimeException {
        ExhaustedDiceException() {
            super("The SequencedDice has been exhausted. Sequence: " + sequencedResults.toString());
        }
    }

}
