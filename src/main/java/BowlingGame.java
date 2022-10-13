import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static final int MAX_VALID_FRAMES_WITHOUT_BONUS = 10;
    public static final int MAX_PINS_HIT_IN_ONE_FRAME = 10;
    private List<Frame> frames;

    public BowlingGame(String lineString) {
        BowlingLineStringInterpreter interpreter = new BowlingLineStringInterpreter();
        this.frames = interpreter.getFrameListFromLineString(lineString);
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (int i = 0; i < MAX_VALID_FRAMES_WITHOUT_BONUS; i++) {
            totalScore += this.frames.get(i).getScore();
        }
        return totalScore;
    }
}
