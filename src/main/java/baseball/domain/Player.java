package baseball.domain;

import baseball.domain.dto.PlayerDto;

public final class Player {

    private static final String LENGTH_ERROR_MESSAGE = "3자리 수만 입력해주세요.";
    private static final String INVALID_INPUT_MESSAGE = "숫자를 입력해주세요.";

    private final String playerAnswer;
    private Score score;

    private Player(String playerAnswer) {
        this.playerAnswer = playerAnswer;
    }

    public static Player create(String playerAnswer) {
        validateLength(playerAnswer);
        validateNumeric(playerAnswer);
        return new Player(playerAnswer);
    }

    private static void validateLength(String playerAnswer) {
        if (playerAnswer.length() != 3) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateNumeric(String playerAnswer) {
        try {
            Integer.parseInt(playerAnswer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    public String getPlayerAnswer() {
        return playerAnswer;
    }

    public void createScore(Score score) {
        this.score = score;
    }

    public PlayerDto createPlayerDto() {
        return new PlayerDto(score);
    }
}
