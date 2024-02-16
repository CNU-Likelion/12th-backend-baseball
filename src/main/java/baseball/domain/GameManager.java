package baseball.domain;

public class GameManager {

    private final String randomNumber;
    private final Referee referee;
    private Player player;

    private GameManager(String randomNumber) {
        this.randomNumber = randomNumber;
        this.referee = new Referee();
    }

    public static GameManager create(String randomNumber) {
        return new GameManager(randomNumber);
    }

    public Player startOneGame(String playerAnswer) {
        this.player = Player.create(playerAnswer);
        System.out.println(randomNumber);
        Score score = referee.judgeGame(randomNumber, player);
        player.createScore(score);
        return player;
    }

    public boolean checkGameEnd(Player player) {
        if (player.getPlayerAnswer().equals(randomNumber)) {
            return true;
        }
        return false;
    }
}
