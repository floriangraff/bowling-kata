public class Number extends Turn {
    private int pinsHit;

    public Number(Frame frame, int pinsHit) {
        super(frame);
        this.pinsHit = pinsHit;
    }

    @Override public int getNumberRepresentation() {
        return this.pinsHit;
    }
}
