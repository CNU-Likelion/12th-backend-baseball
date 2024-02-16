package baseball.domain;

import baseball.domain.Wrapper.Ball;
import baseball.domain.Wrapper.Strike;

public class Score {

    private Strike strike;
    private Ball ball;

    public Score(Strike strike, Ball ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Score create(Strike strikes, Ball balls) {
        return new Score(strikes, balls);
    }

    public Strike getStrike() {
        return strike;
    }

    public Ball getBall() {
        return ball;
    }
}
