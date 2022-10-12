import java.util.ArrayList;
import java.util.List;

public class Frame {

    List<Turn> turns = new ArrayList<>();
    BowlingGame game;

    public Frame(BowlingGame game) {
        this.game = game;
    }

    public int getScore() {
        Turn firstTurn = this.turns.get(0);
        if (firstTurn instanceof Strike) {
            return firstTurn.getNumberRepresentation() + firstTurn.getNextTurn().getNumberRepresentation() + firstTurn.getNextTurn().getNextTurn().getNumberRepresentation();
        }
        Turn secondTurn = this.turns.get(1);
        if (secondTurn instanceof Spare) {
            return firstTurn.getNumberRepresentation() + secondTurn.getNumberRepresentation() + secondTurn.getNextTurn().getNumberRepresentation();
        }
        return firstTurn.getNumberRepresentation() + secondTurn.getNumberRepresentation();
    }

    public boolean addTurn(Turn turn) {
        this.getGame().increaseTurnCounter();
        turn.setTurnNumber(this.getGame().getTurnCounter());
        this.getGame().addTurn(turn);
        return this.turns.add(turn);
    }

    public BowlingGame getGame() {
        return game;
    }
}
