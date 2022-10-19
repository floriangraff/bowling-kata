import java.util.ArrayList;
import java.util.List;

public class BowlingLineStringInterpreter {

    private Turn previousTurn = null;

    public List<Frame> getFrameListFromLineString(String frameString) {
        List<Frame> frames = new ArrayList<>();
        String[] frameSymbols = frameString.split(" ");
        for (String turnSymbols : frameSymbols) {
            frames.add(this.getFrameFromTurnSymbols(turnSymbols));
        }
        return frames;
    }

    private Frame getFrameFromTurnSymbols(String turnSymbols) {
        Frame frame = new Frame();
        for (int i = 0; i < turnSymbols.length(); i++) {
            char turnSymbol = turnSymbols.charAt(i);
            Turn turn = this.getTurnBySymbol(turnSymbol);
            if (this.previousTurn != null) {
                turn.setPreviousTurn(this.previousTurn);
                this.previousTurn.setNextTurn(turn);
            }
            this.previousTurn = turn;
            frame.addTurn(turn);
        }
        return frame;
    }

    private Turn getTurnBySymbol(char turnSymbol) {
        if (turnSymbol == 'X') {
            return new Strike();
        }
        if (turnSymbol == '/') {
            return new Spare();
        }
        if (turnSymbol == '-') {
            return new Miss();
        }
        int pinsHit = Integer.parseInt(String.valueOf(turnSymbol));
        return new Number(pinsHit);
    }

}
