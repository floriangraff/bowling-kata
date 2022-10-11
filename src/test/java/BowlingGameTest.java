import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    @Test
    void twelveStrikesShouldEqualMaxScore() {
        BowlingGame game = new BowlingGame("X X X X X X X X X X X X");
        assertEquals(300, game.getTotalScore());
    }

    @Test
    void tenPairsOfNineAndMissShouldEqualNinety() {
        BowlingGame game = new BowlingGame("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-");
        assertEquals(90, game.getTotalScore());
    }

    @Test
    void tenPairsOfFiveAndSparePlusBonusFiveShouldEqualOneHundredFifty() {
        BowlingGame game = new BowlingGame("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5");
        assertEquals(150, game.getTotalScore());
    }
}