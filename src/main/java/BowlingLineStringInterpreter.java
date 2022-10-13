import java.util.ArrayList;
import java.util.List;

public class BowlingLineStringInterpreter {

    public List<Frame> getFrameListFromLineString(String frameString, BowlingGame game) {
        List<Frame> frames = new ArrayList<>();
        String[] frameSymbols = frameString.split(" ");
        for (String turnSymbols : frameSymbols) {
            Frame frame = new Frame(game);
            for (int i = 0; i < turnSymbols.length(); i++) {
                char turnSymbol = turnSymbols.charAt(i);
                Turn turn = this.getTurnBySymbol(turnSymbol, frame);
                frame.addTurn(turn);
            }
            frames.add(frame);
        }
        return frames;
    }

    private Turn getTurnBySymbol(char turnSymbol, Frame frame) {
        if (turnSymbol == 'X') {
            return new Strike(frame);
        }
        if (turnSymbol == '/') {
            return new Spare(frame);
        }
        if (turnSymbol == '-') {
            return new Miss(frame);
        }
        int pinsHit = Integer.parseInt(String.valueOf(turnSymbol));
        return new Number(frame, pinsHit);
    }

}
