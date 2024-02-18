package baseball;

import java.util.Arrays;
import java.util.Objects;

public enum GameCommand {

    RESTART("1"),
    EXIT("2"),
    ;

    private final String commandDigit;

    GameCommand(final String commandDigit) {
        this.commandDigit = commandDigit;
    }

    public static boolean isRestarting(final String waitingCommand) {
        if (isIncorrectCommand(waitingCommand)) {
            throw new IllegalArgumentException("커맨드는 1, 2만 가능합니다.");
        }
        return Objects.equals(RESTART.commandDigit, waitingCommand);
    }

    private static boolean isIncorrectCommand(final String waitingCommand) {
        return Arrays.stream(values())
                .map(gameCommand -> gameCommand.commandDigit)
                .noneMatch(commandDigit -> commandDigit.equals(waitingCommand));
    }
}
