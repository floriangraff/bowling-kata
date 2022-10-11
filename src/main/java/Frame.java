import java.util.ArrayList;
import java.util.List;

public class Frame {

    List<Turn> turns = new ArrayList<>();

    public int getScore() {
        return 0;
    }

    public boolean addTurn(Turn turn) {
        return this.turns.add(turn);
    }
}
