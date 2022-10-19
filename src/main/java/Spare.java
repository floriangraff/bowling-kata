public class Spare extends Turn {

    @Override
    int getNumberRepresentation() {
        Turn previousTurn = this.getPreviousTurn();
        return BowlingGame.MAX_PINS_HIT_IN_ONE_FRAME - previousTurn.getNumberRepresentation();
    }
}
