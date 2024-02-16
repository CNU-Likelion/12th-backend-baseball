package baseball.domain;

public class GameManager {

    private final String randomNumber;

    private GameManager(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static GameManager create(String randomNumber) {
        return new GameManager(randomNumber);
    }

    public void startOneGame(String playerAnswer) {

    }
}
