package baseball;

import java.util.ArrayList;
import java.util.List;
import mallang.missionutils.Randoms;

public class Opponent {

    private static final int MAXIMUM_LENGTH_OF_ANSWER = 3;

    private final List<Integer> answers;

    private Opponent(final List<Integer> answers) {
        this.answers = answers;
    }

    public static Opponent create() {
        final List<Integer> answers = new ArrayList<>();
        while (answers.size() < MAXIMUM_LENGTH_OF_ANSWER) {
            final int randomDigit = Randoms.pickNumberInRange(1, 9);
            if (!answers.contains(randomDigit)) {
                answers.add(randomDigit);
            }
        }
        return new Opponent(answers);
    }

    public Hint checkHint(final List<Integer> userNumbers) {
        final Hint hint = new Hint();
        for (int i = 0; i < userNumbers.size(); i++) {
            final int userDigit = userNumbers.get(i);
            final int opponentDigit = answers.get(i);

            if (userDigit == opponentDigit) {
                hint.increaseStrike();
                continue;
            }
            if (answers.contains(userDigit)) {
                hint.increaseBall();
            }
        }
        return hint;
    }
}
