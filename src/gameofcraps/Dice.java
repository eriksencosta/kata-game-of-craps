package gameofcraps;

public class Dice {
    private int face1;
    private int face2;

    private static int rollOneDice() {
        return (int) (6 * Math.random() + 1);
    }

    public Dice() {
    }

    public int sumOfFaces() {
        return face1 + face2;
    }

    public void roll() {
        face1 = rollOneDice();
        face2 = rollOneDice();
    }
}