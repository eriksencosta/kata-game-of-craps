package gameofcraps;

public class Dice {
    private int face1;
    private int face2;

    private static int getRandInt1To6() {
        return (int) (6 * Math.random() + 1);
    }

    public Dice() {
    }

    public int getSumOfFaces() {
        return face1 + face2;
    }

    public void roll() {
        face1 = getRandInt1To6();
        face2 = getRandInt1To6();
    }
}