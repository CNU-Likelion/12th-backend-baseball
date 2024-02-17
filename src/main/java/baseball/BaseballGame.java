package baseball;

import java.util.ArrayList;
import mallang.missionutils.Console;

public class BaseballGame {

    public void start() {
        do {
            final Opponent opponent = new Opponent(new ArrayList<>());
            startUserProcess(opponent);
        } while (isRestarting());
    }

    private void startUserProcess(final Opponent opponent) {
        while (true) {
            final User user = initializeUser();
            final Hint hint = opponent.checkHint(user.getNumbers());
            hint.print();

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

    private boolean isRestarting() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        final String waitingCommand = Console.readLine();
        return GameCommand.isRestarting(waitingCommand);
    }
}
