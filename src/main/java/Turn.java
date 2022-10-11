abstract class Turn {

    int turnNumber;

    Frame frame;

    public Turn(Frame frame) {
        this.frame = frame;
    }

    abstract int getNumberRepresentation();

    Turn getNextTurn() {
        Turn nextTurn = this.getFrame().getGame().getTurn(this.turnNumber);
        return nextTurn;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public Frame getFrame() {
        return frame;
    }
}
