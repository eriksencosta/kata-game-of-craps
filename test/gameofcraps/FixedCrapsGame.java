package gameofcraps;

public class FixedCrapsGame extends CrapsGame {


    private boolean won;
    private int numberOfRolls;

    public FixedCrapsGame (Boolean won, int numberOfRolls) {
        this.won = won;
        this.numberOfRolls = numberOfRolls;
    }

    @Override
    public boolean win() {
        return won;
    }

    @Override
    public  int numberOfRolls() {
        return numberOfRolls;
    }

}
