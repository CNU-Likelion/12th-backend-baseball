package baseball.view;

import baseball.domain.dto.PlayerDto;

public class OutputView {

    private static final String GAME_SCORE_ONLY_BALL_FORMAT = "%d볼";
    private static final String GAME_SCORE_ONLY_STRIKE_FORMAT = "%d볼";
    private static final String GAME_SCORE_FORMAT = "%d볼 %d스트라이크";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void print(String message) {
        System.out.println(message);
    }

    public void showGameScore(PlayerDto playerDto) {
        String gameScoreMessage = getGameScoreMessage(playerDto.getStrike(), playerDto.getBall());
        print(gameScoreMessage);
    }

    private String getGameScoreMessage(int strike, int ball) {
        if (strike == 0 && ball != 0) {
            return String.format(GAME_SCORE_ONLY_BALL_FORMAT, ball);
        }
        if (strike != 0 && ball == 0) {
            return String.format(GAME_SCORE_ONLY_STRIKE_FORMAT, strike);
        }
        return String.format(GAME_SCORE_FORMAT, ball, strike);
    }

    public void showGameEnd() {
        print(GAME_END_MESSAGE);
    }
}
