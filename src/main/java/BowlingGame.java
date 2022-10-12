import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static final int MAX_VALID_FRAMES_WITHOUT_BONUS = 10;
    public static final int MAX_PINS_HIT_IN_ONE_FRAME = 10;
    private List<Frame> frames = new ArrayList<>();
    private List<Turn> turns = new ArrayList<>();
    private int turnCounter = 0;

    public BowlingGame(String frameString) {
        this.convertFrameStringToObjects(frameString);
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (int i = 0; i < MAX_VALID_FRAMES_WITHOUT_BONUS; i++) {
            totalScore += this.frames.get(i).getScore();
        }
        return totalScore;
    }

    private void convertFrameStringToObjects(String frameString) {
        String[] frameSymbols = frameString.split(" ");
        for (String turnSymbols : frameSymbols) {
            Frame frame = new Frame(this);
            for (int i = 0; i < turnSymbols.length(); i++) {
                char turnSymbol = turnSymbols.charAt(i);
                Turn turn;
                if (turnSymbol == 'X') {
                    turn = new Strike(frame);
                } else if (turnSymbol == '/') {
                    turn = new Spare(frame);
                } else if (turnSymbol == '-') {
                    turn = new Miss(frame);
                } else {
                    int pinsHit = Integer.parseInt(String.valueOf(turnSymbol));
                    turn = new Number(frame, pinsHit);
                }
                frame.addTurn(turn);
            }
            this.addFrame(frame);
        }
    }

    private boolean addFrame(Frame frame) {
        return this.frames.add(frame);
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
