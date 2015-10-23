package bowling;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() throws Exception {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void shouldComputeScoreWithoutAnySpecialRoll() {
        String inputRolls = "234567";
        int score = bowlingGame.computeScore(inputRolls);
        Assertions.assertThat(score).isEqualTo(27);
    }

    @Test
    public void shouldComputeScoreWhen2PinsAndSpare() {
        String inputRolls = "2/";
        int score = bowlingGame.computeScore(inputRolls);
        Assertions.assertThat(score).isEqualTo(10);
    }

    @Test
    public void shouldComputeScoreWhen8PinsAndSpare() {
        String inputRolls = "8/";
        int score = bowlingGame.computeScore(inputRolls);
        Assertions.assertThat(score).isEqualTo(10);
    }


    @Test
    public void shouldComputeScoreWhen6PinsAndSpare() {
        String inputRolls = "6/11";
        int score = bowlingGame.computeScore(inputRolls);
        Assertions.assertThat(score).isEqualTo(13);
    }
}