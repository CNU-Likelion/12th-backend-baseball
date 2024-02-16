package baseball.controller;

import baseball.domain.GameManager;
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
        final GameManager gameManager = GameManager.create(randomNumberGenerator.getRandomNumber());
        inputOneAnswer(gameManager);
    }

    private void inputOneAnswer(GameManager gameManager) {
        String playerAnswer = inputView.getInputWithRetry(inputView::getNumbers);
        gameManager.startOneGame(playerAnswer);
        if (checkGameEnd(playerAnswer, gameManager)) {
            return;
        }
        inputOneAnswer(gameManager);
    }

    private boolean checkGameEnd(String playerAnswer, GameManager gameManager) {

    }
}
