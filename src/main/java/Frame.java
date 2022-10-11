import java.util.ArrayList;
import java.util.List;

public class Frame {

    List<Turn> turns = new ArrayList<>();
    BowlingGame game;
    int frameNumber;

    public Frame(BowlingGame game, int frameNumber) {
        this.game = game;
        this.frameNumber = frameNumber;
    }

    public int getScore() {
        Turn firstTurn = this.turns.get(0);
        if (this.frameNumber >= BowlingGame.MAX_VALID_FRAMES_WITHOUT_BONUS) {
            return firstTurn.getNumberRepresentation();
        }
        if (firstTurn instanceof Strike) {
            return firstTurn.getNumberRepresentation() + this.getNextFrame().getNumberRepresenation() + this.getNextFrame().getNextFrame().getNumberRepresenation();
        }
        Turn secondTurn = this.turns.get(1);
        if (secondTurn instanceof Spare) {
            return secondTurn.getNumberRepresentation() + this.getNextFrame().getTurns().get(0).getNumberRepresentation();
        }
        return firstTurn.getNumberRepresentation() + secondTurn.getNumberRepresentation();
    }

    public boolean addTurn(Turn turn) {
        return this.turns.add(turn);
    }

    public List<Turn> getTurns() {
        return this.turns;
    }

    public int getNumberRepresenation() {
        int totalNumberRepresentation = 0;
        for (Turn turn : this.turns) {
            totalNumberRepresentation += turn.getNumberRepresentation();
        }
        return totalNumberRepresentation;
    }

    private Frame getNextFrame() {
        return this.game.getFrames().get(this.frameNumber + 1);
    }
}
