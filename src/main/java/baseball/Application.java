package baseball;

import baseball.controller.BaseBallController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final BaseBallController baseBallController = new BaseBallController(inputView, outputView);
        baseBallController.start();
    }
}
