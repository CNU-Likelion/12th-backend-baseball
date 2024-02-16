package baseball.view;

import java.util.function.Supplier;
import mallang.missionutils.Console;

public class InputView {

    private static final String PLAYER_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public <T> T getInputWithRetry(Supplier<T> inputReader) {
        return inputReader.get();
    }

    public String getNumbers() {
        OutputView.print(PLAYER_INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
