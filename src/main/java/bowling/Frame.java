package bowling;

import java.util.Optional;

public class Frame {
    private final int score;
    private int bonus;
    private char roll1;
    private char roll2;

    public Frame(String frameScore) {
        roll1 = frameScore.charAt(0);
        roll2 = frameScore.charAt(1);
        score = compute();
    }

    private int compute() {
        if (getScore() != 0) {
            return score;
        }
        if (isSpare()) return 10;
        return roll1 == 0 ? 0 : convertToNumber(roll1)
            + roll2 == 0 ? 0 : convertToNumber(roll2);
    }

    public int getScore() {
        return score;
    }

    private boolean isSpare() {
        return '/' == roll2;
    }

    private int convertToNumber(char letter) {
        return Integer.valueOf(String.valueOf(letter));
    }

    public Frame sum(Frame nextFrame) {
        int score = this.getScore() + nextFrame.compute();
        int bonus = this.isSpare() ? roll1 : 0;

        return new Frame(score, bonus);
    }

    public Frame(int score, int bonus) {
        this.score = score;
        this.bonus = bonus;
    }


    public int getTotalScore() {
        return score + bonus;
    }
}
