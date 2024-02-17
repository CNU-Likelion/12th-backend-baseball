package baseball.domain;

import baseball.domain.Wrapper.Ball;
import baseball.domain.Wrapper.Strike;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Referee {

    public Score judgeGame(String answer, Player player) {
        Strike strikes = checkStrike(answer, player);
        Ball balls = checkBalls(answer, player);
        return Score.create(strikes, balls);
    }

    private static Strike checkStrike(String answer, Player player) {
        int strikes = (int) IntStream.range(0, answer.length())
                .filter(i -> answer.charAt(i) == player.getPlayerAnswer().charAt(i))
                .count();

        return new Strike(strikes);
    }

    private Ball checkBalls(String answer, Player player) {
        int balls = (int) IntStream.range(0, answer.length())
                .filter(i -> answer.indexOf(player.getPlayerAnswer().charAt(i)) != -1 &&
                        answer.charAt(i) != player.getPlayerAnswer().charAt(i))
                .count();

        return new Ball(balls);
    }
}
