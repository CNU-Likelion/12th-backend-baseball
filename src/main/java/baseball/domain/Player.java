package baseball.domain;

import baseball.domain.dto.PlayerDto;

public final class Player {

    private final String playerAnswer;
    private Score score;

    private Player(String playerAnswer) {
        this.playerAnswer = playerAnswer;
    }
    public static Player create(String playerAnswer) {
        return new Player(playerAnswer);
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
