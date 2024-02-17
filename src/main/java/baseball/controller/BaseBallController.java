package baseball.controller;

import baseball.domain.GameManager;
import baseball.domain.Player;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public final class BaseBallController {

    private final InputView inputView;
    private final OutputView outputView;

    public BaseBallController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.create();
        final GameManager gameManager = GameManager.create(randomNumberGenerator.setComputerNumber());
        inputOneAnswer(gameManager);
    }

    private void inputOneAnswer(GameManager gameManager) {
        String playerAnswer = inputView.getInputWithRetry(inputView::getNumbers);
        Player player = gameManager.startOneGame(playerAnswer);
        outputView.showGameScore(player.createPlayerDto());
        if (gameManager.checkGameEnd(player)) {
            askRestartOrExit();
            return;
        }
        inputOneAnswer(gameManager);
    }

    private void askRestartOrExit() {
        outputView.showGameEnd();
        int condition = inputView.getInputWithRetry(inputView::getRestartCondition);
        if (condition == 1) {
            start();
            return;
        }
        if (condition == 2) {
            return;
        }
        askRestartOrExit();
    }
}