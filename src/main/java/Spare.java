public class Spare extends Turn {


    public Spare(Frame frame) {
        super(frame);
    }

    @Override
    int getNumberRepresentation() {
        Turn previousTurn = this.getPreviousTurn();
        return BowlingGame.MAX_PINS_HIT_IN_ONE_FRAME - previousTurn.getNumberRepresentation();
    }
}
