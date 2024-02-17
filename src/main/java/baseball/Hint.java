package baseball;

public class Hint {

    private static final int STRIKE_OUT_COUNT = 3;
    private static final int INITIAL_STRIKE_COUNT = 0;
    private static final int INITIAL_BALL_COUNT = 0;

    private int strike;
    private int ball;

    public Hint() {
        this.strike = INITIAL_STRIKE_COUNT;
        this.ball = INITIAL_BALL_COUNT;
    }

    public void increaseStrike() {
        this.strike++;
    }

    public void increaseBall() {
        this.ball++;
    }

    public boolean isStrikeOut() {
        return strike == STRIKE_OUT_COUNT;
    }

    public void print() {
        final StringBuilder hintMessageBuilder = new StringBuilder();
        if (ball != INITIAL_BALL_COUNT) {
            hintMessageBuilder.append(ball).append("볼 ");
        }
        if (strike != INITIAL_STRIKE_COUNT) {
            hintMessageBuilder.append(strike).append("스트라이크");
        }
        if (ball == INITIAL_BALL_COUNT && strike == INITIAL_STRIKE_COUNT) {
            hintMessageBuilder.append("낫싱");
        }
        System.out.println(hintMessageBuilder);
    }
}
