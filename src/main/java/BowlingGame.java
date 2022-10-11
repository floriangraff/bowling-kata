import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> frames = new ArrayList<>();

    public BowlingGame(String frameString) {
        this.convertFrameStringToObjects(frameString);
    }

    public int getTotalScore() {
        return 0;
    }

    private void convertFrameStringToObjects(String frameString) {
        String[] frameSymbols = frameString.split(" ");
        for (String turnSymbols : frameSymbols) {
            Frame frame = new Frame();
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
            this.frames.add(frame);
        }
    }
}
