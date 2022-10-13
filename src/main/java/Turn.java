abstract class Turn {
    Turn nextTurn;
    Turn previousTurn;

    public Turn(Frame frame) {

    }

    abstract int getNumberRepresentation();

    Turn getNextTurn() {
        return this.nextTurn;
    }

    public void setNextTurn(Turn nextTurn) {
        this.nextTurn = nextTurn;
    }

    Turn getPreviousTurn() {
        return this.previousTurn;
    }

    public void setPreviousTurn(Turn previousTurn) {
        this.previousTurn = previousTurn;
    }

}
