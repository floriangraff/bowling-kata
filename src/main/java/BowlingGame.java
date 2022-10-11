import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> frames = new ArrayList<>();
    public static final int MAX_VALID_FRAMES_WITHOUT_BONUS = 10;

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
        int frameCounter = 0;
        for (String turnSymbols : frameSymbols) {
            Frame frame = new Frame(this, frameCounter);
            for (int i = 0; i < turnSymbols.length(); i++) {
                char turnSymbol = turnSymbols.charAt(i);
                Turn turn;
                if (turnSymbol == 'X') {
                    turn = new Strike();
                } else if (turnSymbol == '/') {
                    turn = new Spare();
                } else if (turnSymbol == '-') {
                    turn = new Miss();
                } else {
                    int pinsHit = Integer.parseInt(String.valueOf(turnSymbol));
                    turn = new Number(pinsHit);
                }
                frame.addTurn(turn);
            }
            this.addFrame(frame);
            frameCounter++;
        }
    }

    private boolean addFrame(Frame frame) {
        return this.frames.add(frame);
    }

    public List<Frame> getFrames() {
        return this.frames;
    }
}
