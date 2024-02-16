package baseball.view;

import java.util.function.Supplier;
import mallang.missionutils.Console;

public class InputView {

    private static final String PLAYER_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public <T> T getInputWithRetry(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return getInputWithRetry(inputReader);
        }
    }

    public String getNumbers() {
        OutputView.print(PLAYER_INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public int getRestartCondition() {
        OutputView.print(RESTART_INPUT_MESSAGE);
        String restartCondition = Console.readLine();
        return Integer.parseInt(restartCondition);
    }
}
