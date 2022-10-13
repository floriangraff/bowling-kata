import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static final int MAX_VALID_FRAMES_WITHOUT_BONUS = 10;
    public static final int MAX_PINS_HIT_IN_ONE_FRAME = 10;
    private List<Frame> frames = new ArrayList<>();
    private List<Turn> turns = new ArrayList<>();
    private int turnCounter = 0;

    public BowlingGame(String lineString) {
        BowlingLineStringInterpreter interpreter = new BowlingLineStringInterpreter();
        this.frames = interpreter.getFrameListFromLineString(lineString, this);
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (int i = 0; i < MAX_VALID_FRAMES_WITHOUT_BONUS; i++) {
            totalScore += this.frames.get(i).getScore();
        }
        return totalScore;
    }
    public boolean addTurn(Turn turn) {
        return this.turns.add(turn);
    }
    public Turn getTurn(int turnNumber) {
        return this.turns.get(turnNumber);
    }
    public int getTurnCounter () {
        return this.turnCounter;
    }
    public void increaseTurnCounter () {
        this.turnCounter++;
    }
}
