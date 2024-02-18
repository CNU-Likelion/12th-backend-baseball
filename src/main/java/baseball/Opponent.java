package baseball;

import java.util.List;

public class Opponent {

    private final List<Integer> answers;

    private Opponent(final List<Integer> answers) {
        this.answers = answers;
    }

    public static Opponent from(final AnswerGenerator answerGenerator) {
        final List<Integer> answers = answerGenerator.generate();
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
