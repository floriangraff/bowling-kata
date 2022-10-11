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
        BowlingGame game = new BowlingGame("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5");
        assertEquals(150, game.getTotalScore());
    }

    @Test
    void tenStrikesAndNineBonusShouldEqualMaxScore() {
        BowlingGame game = new BowlingGame("X X X X X X X X X X 45");
        assertEquals(283, game.getTotalScore());
    }

    @Test
    void TwentyMissesShouldEqualZero() {
        BowlingGame game = new BowlingGame("-- -- -- -- -- -- -- -- -- --");
        assertEquals(0, game.getTotalScore());
    }

    @Test
    void anotherCheck() {
        BowlingGame game = new BowlingGame("-1 -2 -3 -4 -5 -6 -7 -8 -9 --");
        assertEquals(45, game.getTotalScore());
    }
}