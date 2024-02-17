package baseball.domain.dto;

import baseball.domain.Score;
import baseball.domain.Wrapper.Ball;
import baseball.domain.Wrapper.Strike;

public class PlayerDto {

    private Strike strike;
    private Ball ball;

    public PlayerDto(Score score) {
        this.strike = score.getStrike();
        this.ball = score.getBall();
    }

    public int getStrike() {
        return strike.getStrike();
    }

    public int getBall() {
        return ball.getBall();
    }
}
