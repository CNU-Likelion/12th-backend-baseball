package baseball.domain;

import baseball.domain.Wrapper.Ball;
import baseball.domain.Wrapper.Strike;
import java.util.stream.IntStream;

public class Referee {

    public Score judgeGame(String answer, Player player) {
        Strike strikes = checkStrike(answer, player);
        Ball balls = checkBalls(answer, player);
        return Score.create(strikes, balls);
    }

    private static Strike checkStrike(String answer, Player player) {
        long strikes = IntStream.range(0, answer.length())
                .filter(i -> answer.charAt(i) == player.getPlayerAnswer().charAt(i))
                .count();

        return new Strike((int) strikes);
    }

    private Ball checkBalls(String answer, Player player) {
        int balls = 0;
        for (int i = 0; i < answer.length(); i++) {
            char digit = player.getPlayerAnswer().charAt(i);
            if (answer.indexOf(digit) != -1 && answer.charAt(i) != digit) {
                balls++;
            }
        }
        return new Ball(balls);
    }
}
