package baseball;

import baseball.domain.GameCommand;
import baseball.domain.Hint;
import baseball.domain.Opponent;
import baseball.domain.RandomAnswerGenerator;
import baseball.domain.User;
import mallang.missionutils.Console;

public class BaseballGame {

    public void start() {
        do {
            final Opponent opponent = Opponent.from(new RandomAnswerGenerator());
            startUserProcess(opponent);
        } while (isRestarting());
    }

    private void startUserProcess(final Opponent opponent) {
        while (true) {
            final User user = initializeUser();
            final Hint hint = opponent.checkHint(user.getNumbers());
            printHint(hint);

            if (hint.isStrikeOut()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private User initializeUser() {
        System.out.print("숫자를 입력해주세요 : ");
        final String userInput = Console.readLine();
        return User.from(userInput);
    }

    private void printHint(final Hint hint) {
        final int strike = hint.getStrike();
        final int ball = hint.getBall();
        final StringBuilder hintMessageBuilder = new StringBuilder();

        if (hint.hasBall()) {
            hintMessageBuilder.append(ball).append("볼 ");
        }
        if (hint.hasStrike()) {
            hintMessageBuilder.append(strike).append("스트라이크");
        }
        if (hint.isNothing()) {
            hintMessageBuilder.append("낫싱");
        }
        System.out.println(hintMessageBuilder);
    }

    private boolean isRestarting() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        final String waitingCommand = Console.readLine();
        return GameCommand.isRestarting(waitingCommand);
    }
}
