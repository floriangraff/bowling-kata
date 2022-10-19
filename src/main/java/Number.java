public class Number extends Turn {
    private int pinsHit;

    public Number(int pinsHit) {
        this.pinsHit = pinsHit;
    }

    @Override public int getNumberRepresentation() {
        return this.pinsHit;
    }
}
